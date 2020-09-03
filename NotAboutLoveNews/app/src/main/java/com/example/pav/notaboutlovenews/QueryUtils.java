package com.example.pav.notaboutlovenews;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public final class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils(){
    }

    public static List<NewsItem> fetchNewsItemData(String requestUrl){
        URL url = createUrl(requestUrl);

        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e){
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        List<NewsItem> newsItems = extractFeatureFromJson(jsonResponse);
        return newsItems;
    }


    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private static List<NewsItem> extractFeatureFromJson(String newsItemJSON){
        if (TextUtils.isEmpty(newsItemJSON)){
            return null;
        }
        List<NewsItem> newsItems = new ArrayList<>();

        try {
            JSONObject baseJsonRespone = new JSONObject(newsItemJSON);
            JSONArray newsItemArray = baseJsonRespone.getJSONObject("response").getJSONArray("results");
            for (int i = 0; i < newsItemArray.length(); i++){
                JSONObject currentNewsItem = newsItemArray.getJSONObject(i);

                String headline = currentNewsItem.getString("webTitle");
                String sectionName = currentNewsItem.getString("sectionName");


                String author = "No Author";

                try {
                    author = currentNewsItem.getJSONArray("tags").getJSONObject(0).getString("webTitle");
                } catch (JSONException e){
                    Log.e("QueryUtils", "Problem parsing the JSON results", e);
                }


                String webPublicationDate = "No Date";

                try {
                    webPublicationDate = currentNewsItem.getString("webPublicationDate");
                } catch (JSONException e){
                    Log.e("QueryUtils", "Problem parsing the JSON results", e);
                }


                String webUrl = currentNewsItem.getString("webUrl");

                NewsItem newsItem = new NewsItem(author, headline, webPublicationDate, sectionName, webUrl);

                newsItems.add(newsItem);
            }
        } catch (JSONException e){
            Log.e("QueryUtils", "Problem parsing the JSON results", e);
        }
        return newsItems;
    }
}
