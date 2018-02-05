
package com.example.android.quiz;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    int reset = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method calculates the score
     */
    private int calculateScore(boolean one, boolean two, String three, boolean four1, boolean four2, boolean four3) {
        if (one) {
            score += 1;
        }
        if (two) {
            score += 1;
        }
        String answer = "November";
        if (three.equals(answer)) {
            score += 1;
        }
        if (!four2) {
            if (four1 && four3) {
                score += 1;
            }
        }

        return score;
    }

    /**
     * The method is called when the button is clicked
     */
    public void submitAnswers(View view) {

            // Getting the answers
            RadioButton question1 = (RadioButton) findViewById(R.id.answer_one);
            boolean answer1 = question1.isChecked();


            RadioButton question2 = (RadioButton) findViewById(R.id.answer_two);
            boolean answer2 = question2.isChecked();

            EditText question3 = (EditText) findViewById(R.id.question_three);
            String answer3 = question3.getText().toString();

            CheckBox question4_1 = (CheckBox) findViewById(R.id.answer_four1);
            boolean answer4_1 = question4_1.isChecked();

            CheckBox question4_incorrect = (CheckBox) findViewById(R.id.answer_four_incorrect);
            boolean answer4_incorrect = question4_incorrect.isChecked();

            CheckBox question4_2 = (CheckBox) findViewById(R.id.answer_four2);
            boolean answer4_2 = question4_2.isChecked();


            // Calling the method to calculate the score
            int result = calculateScore(answer1, answer2, answer3, answer4_1, answer4_incorrect, answer4_2);

            // Displaying the Toast message according to the score
            if (result >= 3) {
                Toast.makeText(this, "You got " + result + "/4. Congrats! You really have general culture!", Toast.LENGTH_SHORT).show();
                score = 0;
            } else {
                Toast.makeText(this, "You got " + result + "/4. You have to refresh your memory. ;)", Toast.LENGTH_SHORT).show();
                score = 0;
            }


    }

    /**
     * Resets the score for all answers to 0.
     */
    public void Refresh(View v) {
        RadioButton question1 = (RadioButton) findViewById(R.id.answer_one);
        question1.setChecked(false);
        RadioButton question12 = (RadioButton) findViewById(R.id.answer_one1);
        question12.setChecked(false);
        RadioButton question13 = (RadioButton) findViewById(R.id.answer_one2);
        question13.setChecked(false);
        RadioButton question2 = (RadioButton) findViewById(R.id.answer_two);
        question2.setChecked(false);
        RadioButton question3 = (RadioButton) findViewById(R.id.answer_two1);
        question3.setChecked(false);
        RadioButton question4 = (RadioButton) findViewById(R.id.answer_two2);
        question4.setChecked(false);
        CheckBox question4_1 = (CheckBox) findViewById(R.id.answer_four1);
        question4_1.setChecked(false);
        CheckBox question4_incorrect = (CheckBox) findViewById(R.id.answer_four_incorrect);
        question4_incorrect.setChecked(false);
        CheckBox question4_2 = (CheckBox) findViewById(R.id.answer_four2);
        question4_2.setChecked(false);
        EditText question33 = (EditText) findViewById(R.id.question_three);
        question33.setText("");
    }
}