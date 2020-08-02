package com.example.android.wukillaquiz;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button submitButton;
    private TextView answer1TextView;
    private TextView answer2TextView;
    private TextView answer3TextView;
    private TextView answer4TextView;
    private TextView resultsTextView;
    private RadioButton question1NoRadioButton;
    private EditText question2editText;
    private RadioButton question3yesButton;
    private CheckBox question4Ghostface;
    private CheckBox question4Meth;
    private boolean buttonSubmited = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = (Button) findViewById(R.id.submit_button);
        answer1TextView = (TextView) findViewById(R.id.question_1_answer_text_view);
        answer2TextView = (TextView) findViewById(R.id.question_2_answer_text_view);
        answer3TextView = (TextView) findViewById(R.id.question_3_answer_text_view);
        answer4TextView = (TextView) findViewById(R.id.question_4_answer_text_view);
        resultsTextView = (TextView) findViewById(R.id.results_text_view);

        question1NoRadioButton = (RadioButton) findViewById(R.id.question_1_no_button);
        question2editText = (EditText) findViewById(R.id.question_2_edit_text);
        question3yesButton = (RadioButton) findViewById(R.id.question_3_yes_button);
        question4Ghostface = (CheckBox) findViewById(R.id.question_4_checkbox_ghostface_killah);
        question4Meth = (CheckBox) findViewById(R.id.question_4_checkbox_methodman);


        submitButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSubmited = true;
                int rightAnswers = countRightAnswers();
                viewRightAnswers();
                viewResultsToasted(rightAnswers);
                viewResults(rightAnswers);
            }
        }));
    }

    private void viewResultsToasted(int rightAnswers) {
        String text = "Finish! Right answers: " + rightAnswers + "/5";
        Toast.makeText(getApplication(), text, Toast.LENGTH_SHORT).show();
    }

    private void viewResults(int rightAnswers) {
        resultsTextView.setText("Finish! Right answers: " + rightAnswers + "/5");

    }

    private int countRightAnswers() {
        int counter = 0;
        if (question1NoRadioButton.isChecked()){
            counter++;
        } if (question2editText.getText().toString().equalsIgnoreCase("R")){
            counter++;
        } if (question3yesButton.isChecked()){
            counter++;
        } if (question4Ghostface.isChecked()){
            counter++;
        } if (question4Meth.isChecked()){
            counter++;
        }
        return counter;
    }

    private void viewRightAnswers() {
        answer1TextView.setText(getString(R.string.answer1));
        answer2TextView.setText(getString(R.string.answer2));
        answer3TextView.setText(getString(R.string.answer3));
        answer4TextView.setText(getString(R.string.answer4));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("buttonSubmited", buttonSubmited);
        outState.putInt("num", countRightAnswers());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int count = savedInstanceState.getInt("num");
        boolean buttonSubmited = savedInstanceState.getBoolean("buttonSubmited");
        if (buttonSubmited == true){
            viewResults(count);
            viewRightAnswers();
        }


    }
}
