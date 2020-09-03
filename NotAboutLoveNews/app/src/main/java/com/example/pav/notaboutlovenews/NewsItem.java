package com.example.pav.notaboutlovenews;

import java.text.SimpleDateFormat;

class NewsItem {

    private String mHeadline;

    private String mSectionName;

    private String mWebPublicationDate;

    private String mAuthor;

    private String mUrl;

    public NewsItem(String mAuthor, String mHeadline, String mWebPublicationDate, String mSectionName, String mUrl) {
        this.mAuthor = mAuthor;
        this.mHeadline = mHeadline;
        this.mWebPublicationDate = mWebPublicationDate;
        this.mSectionName = mSectionName;
        this.mUrl = mUrl;
    }

    public String getHeadline() {
        return mHeadline;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public String getWebPublicationDate() {
        return mWebPublicationDate;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getUrl() {
        return mUrl;
    }
}
