package com.example.android.wukillaqeez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // This counts the questions!
    int Counter = 0;
    int trueCounter = 0;
    int falseCounter = 0;
    String question;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String getQuestion(int Counter){
        if (Counter == 1) {
            question = "Is Brooklyn the majority of Wu-Tang Members are from which New York City Borough?";
        } if (Counter == 2){
            question = "All Wu-Tang members go by numerous aliases when they rap. Is Golden Arms the nickname of U-God?";
        } if (Counter == 3){
            question = "Is Raekwon the first Wu-Tang member to release a solo effort?";
        } if (Counter == 4){
            question = "The RZA handles the primary production on the majority of Wu-Tang tracks.";
        } if (Counter == 5){
            question = "Wu-Tang's sophomore effort, \"Wu-Tang Forever\" received five mics in \"The Source\" hip-hop magazine.";
        } if (Counter == 6){
            question = "Has U-God a song named after him?";
        } if (Counter == 7){
            question = "The Wu-Tang Clan has never collaborated with Snoop Dogg.";
        } if (Counter == 8){
            question = "Did RZA the music soundtack of the movie Kill Bill?";
        } return question;
    }

    public void goToNext(View view) {
        if (Counter == 9){
            Counter +=1;
            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.trueFalseRadioGroup);
            radioGroup.setVisibility(View.INVISIBLE);

            Button submitButton = (Button) findViewById(R.id.submitButton);
            submitButton.setVisibility(View.INVISIBLE);
            question = "Finish. Push back to exit!";
        } else {
            Counter +=1;
            question = getQuestion(Counter);
        }
        TextView questionTextView = (TextView) findViewById(
                R.id.question_text_view);
        questionTextView.setText(question);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.trueFalseRadioGroup);
        radioGroup.clearCheck();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.trueButton:
                if (checked) {
                    if (Counter == 0) {
                        Toast.makeText(this, "Wrong! Protect Ya Neck...", Toast.LENGTH_SHORT).show();
                        falseCounter += 1;
                    } if (Counter == 1){
                        Toast.makeText(this, "Wrong! Shame on a nuh...", Toast.LENGTH_SHORT).show();
                        falseCounter += 1;
                    } if (Counter == 2){
                        Toast.makeText(this, "True! You are a Shaolin!", Toast.LENGTH_SHORT).show();
                        trueCounter += 1;
                    } if (Counter == 3){
                        Toast.makeText(this, "Wrong! I bust that nigga ass right now", Toast.LENGTH_SHORT).show();
                        falseCounter += 1;
                    } if (Counter == 4){
                        Toast.makeText(this, "Shimmy Shimmy Yeah! Great son...", Toast.LENGTH_SHORT).show();
                        trueCounter += 1;
                    } if (Counter == 5){
                        Toast.makeText(this, "Wrong! you know who you talking to?", Toast.LENGTH_SHORT).show();
                        falseCounter += 1;
                    } if (Counter == 6){
                        Toast.makeText(this, "Wrong! M-E-T-H-O-D Maaaaaan!", Toast.LENGTH_SHORT).show();
                    } if (Counter == 7){
                        Toast.makeText(this, "No Kid! Go buy \"The W\" 2000 released!", Toast.LENGTH_SHORT).show();
                        falseCounter += 1;
                    } if (Counter == 8){
                        Toast.makeText(this, "True! He is the father of the Army son!", Toast.LENGTH_SHORT).show();
                        trueCounter += 1;
                    }
                }

                    break;

            case R.id.falseButton:
                if (checked) {
                    if (Counter == 0) {
                        Toast.makeText(this, "True! You are a Shaolin!", Toast.LENGTH_SHORT).show();
                        trueCounter += 1;
                    } if (Counter == 1){
                        Toast.makeText(this, "Shimmy Shimmy Yeah! Cool", Toast.LENGTH_SHORT).show();
                        trueCounter += 1;
                    } if (Counter == 2){
                        Toast.makeText(this, "Wrong! Protect Ya Neck...", Toast.LENGTH_SHORT).show();
                        falseCounter += 1;
                    } if (Counter == 3){
                        Toast.makeText(this, "Right. Good boy!", Toast.LENGTH_SHORT).show();
                        trueCounter += 1;
                    } if (Counter == 4){
                        Toast.makeText(this, "Wrong! Shame on a nuh...", Toast.LENGTH_SHORT).show();
                        falseCounter += 1;
                    } if (Counter == 5){
                        Toast.makeText(this, "True! Get the money dolla dolla bill y'all", Toast.LENGTH_SHORT).show();
                        trueCounter += 1;
                    } if (Counter == 6){
                        Toast.makeText(this, "Yeah! You came to bring the pain!", Toast.LENGTH_SHORT).show();
                        trueCounter += 1;
                    } if (Counter == 7){
                        Toast.makeText(this, "True soldier! You smoke because you like to get high!", Toast.LENGTH_SHORT).show();
                        trueCounter += 1;
                    } if (Counter == 8){
                        Toast.makeText(this, "No! Thake a sip from the cup of Death.", Toast.LENGTH_SHORT).show();
                        falseCounter += 1;
                    }
                }
                    break;
        }

        TextView trueTextView = (TextView) findViewById(
                R.id.trueResults);
        trueTextView.setText("TRUE: " + trueCounter);

        TextView falseTextView = (TextView) findViewById(R.id.falseResults);
        falseTextView.setText("FALSE: "+ falseCounter);

    }
}