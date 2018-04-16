package com.example.android.quizaboutromania;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * This app is a quiz about Romania.
 */

public class MainActivity extends AppCompatActivity {

    Button submit;
    int numberOfCorrectAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submit_button);
        submit.setOnClickListener(submitAnswers);
    }

    // Check if the user has selected the correct answer for question 1.

    private void checkAnswersQuestionOne() {
        CheckBox questionOneVampire = (CheckBox) findViewById(R.id.answer_1a);
        CheckBox questionOneGot = (CheckBox) findViewById(R.id.answer_1b);
        CheckBox questionOneSuperhero = (CheckBox) findViewById(R.id.answer_1c);
        CheckBox questionOneWallachian = (CheckBox) findViewById(R.id.answer_1d);

        boolean isQuestionOneVampireChecked = questionOneVampire.isChecked();
        boolean isQuestionOneGotChecked = questionOneGot.isChecked();
        boolean isQuestionOneSuperheroChecked = questionOneSuperhero.isChecked();
        boolean isQuestionOneWallachianChecked = questionOneWallachian.isChecked();

        if (isQuestionOneVampireChecked && isQuestionOneWallachianChecked && !isQuestionOneGotChecked && !isQuestionOneSuperheroChecked) {
            numberOfCorrectAnswers += 1;
        }
    }

    // Check if the user has selected the correct answer for question 2.

    private void checkAnswersQuestionTwo() {
        RadioButton radioButtonBrasov = (RadioButton) findViewById(R.id.answer_2b);
        boolean isQuestionTwoBrasovChecked = radioButtonBrasov.isChecked();
        if (isQuestionTwoBrasovChecked) {
            numberOfCorrectAnswers += 1;
        }
    }

    // Check if the user has selected the correct answer for question 3.

    private String getQuestionThreeUserInput() {
        EditText userInputLatinLanguage = (EditText) findViewById(R.id.answer_3);
        String name = userInputLatinLanguage.getText().toString();
        return name;
    }

    private void checkAnswersQuestionThree() {
        String name = getQuestionThreeUserInput();
        if (name.trim().equalsIgnoreCase("moldova")) {
            numberOfCorrectAnswers += 1;
        }
    }

    // Check if the user has selected the correct answer for question 4.

    private void checkAnswersQuestionFour() {
        RadioButton radioButtonLatin = (RadioButton) findViewById(R.id.answer_4a);
        boolean isQuestionFourLatinChecked = radioButtonLatin.isChecked();
        if (isQuestionFourLatinChecked) {
            numberOfCorrectAnswers += 1;
        }
    }

    // Check if the user has selected the correct answer for question 5.

    private void checkAnswersQuestionFive() {
        RadioButton radioButtonMaramures = (RadioButton) findViewById(R.id.answer_5c);
        boolean isQuestionFiveMaramuresChecked = radioButtonMaramures.isChecked();
        if (isQuestionFiveMaramuresChecked) {
            numberOfCorrectAnswers += 1;
        }
    }

    // Check if the user has selected the correct answer for question 6.

    private void checkAnswersQuestionSix() {
        RadioButton radioButtonYes = (RadioButton) findViewById(R.id.answer_5c);
        boolean isQuestionSixYesChecked = radioButtonYes.isChecked();
        if (isQuestionSixYesChecked) {
            numberOfCorrectAnswers += 1;
        }
    }

    private void checkAllQuestions() {
        checkAnswersQuestionOne();
        checkAnswersQuestionTwo();
        checkAnswersQuestionThree();
        checkAnswersQuestionFour();
        checkAnswersQuestionFive();
        checkAnswersQuestionSix();
    }


    private void resetCounterCorrectAnswers() {
        numberOfCorrectAnswers = 0;
    }

    /**
     * This method is called when the Submit answers button is clicked.
     */
    final View.OnClickListener submitAnswers = new View.OnClickListener() {
        public void onClick(final View v) {

            EditText inputName = (EditText) findViewById(R.id.input_name);
            String playerName = inputName.getText().toString();

            checkAllQuestions();

            if (numberOfCorrectAnswers == 6) {
                Toast.makeText(MainActivity.this, playerName + " , congratulations, your knowledge about Romania is perfect!",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, playerName + ", you have " + numberOfCorrectAnswers + " out of 6 correct answers. Retake the test!",
                        Toast.LENGTH_LONG).show();
                resetCounterCorrectAnswers();
            }
        }

    };
}
