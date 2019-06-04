package edu.funix.ncdat.prm391x_quizapp_ncdatfx00499;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // TextView txtQuizApp, txtQuestion1, txtQuestion2, txtQuestion3, txtQuestion4, txtQuestion5, txtQuestion6, txtQuestion7, txtQuestion8, txtQuestion9, txtQuestion10;

    TextView txtUserName, txtStdCode;

    RadioGroup radGroup1, radGroup2, radGroup3;

    RadioButton radRNA, radCIA, radDNA, radPalmTrees, radPineTrees, radOrkTrees, radStalactites, radStalagmites;

    EditText edtQuestion2, edtQuestion4, edtQuestion6, edtQuestion8, edtQuestion10;

    CheckBox chkRibosome, chkPlasmids, chkGolgiApparatus, chkDiploid, chkCeres, chkMercury, chkPluto, chkEarth;

    Button btnSubmission;

    int tempQuestion1, tempQuestion2, tempQuestion3, tempQuestion4, tempQuestion5, tempQuestion6, tempQuestion7, tempQuestion8, tempQuestion9, tempQuestion10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        receiveIntent();
        countDownTime();
        testQuestion1();
        testQuestion5();
        testQuestion9();
        btnSubmission();
    }

    private void countDownTime() {
        new CountDownTimer(120000, 60000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                testQuestion2();
                testQuestion3();
                testQuestion4();
                testQuestion6();
                testQuestion7();
                testQuestion8();
                testQuestion10();
                timeOutResult();
            }
        }.start();
    }

    private void timeOutResult() {
        ArrayList<Integer> result = new ArrayList<>();
        if (tempQuestion1 == 1) {
            result.add(tempQuestion1);
        }
        if (tempQuestion2 == 1) {
            result.add(tempQuestion2);
            tempQuestion2 = 0;
        }
        if (tempQuestion3 == 1) {
            result.add(tempQuestion3);
            tempQuestion3 = 0;
        }
        if (tempQuestion4 == 1) {
            result.add(tempQuestion4);
            tempQuestion4 = 0;
        }
        if (tempQuestion5 == 1) {
            result.add(tempQuestion5);
        }
        if (tempQuestion6 == 1) {
            result.add(tempQuestion6);
            tempQuestion6 = 0;
        }
        if (tempQuestion7 == 1) {
            result.add(tempQuestion7);
            tempQuestion7 = 0;
        }
        if (tempQuestion8 == 1) {
            result.add(tempQuestion8);
            tempQuestion8 = 0;
        }
        if (tempQuestion9 == 1) {
            result.add(tempQuestion9);
        }
        if (tempQuestion10 == 1) {
            result.add(tempQuestion10);
            tempQuestion10 = 0;
        }

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putIntegerArrayListExtra("Result", result);
        startActivity(intent);
    }

    private void receiveIntent() {
        Intent intent = getIntent();
        txtUserName.setText("Student: " + intent.getStringExtra("Username"));
        txtStdCode.setText("Code: " + intent.getStringExtra("StudentCode"));
    }

    // Method to get anwser of Question 10
    private void testQuestion10() {
        String anwserQuestion10 = edtQuestion10.getText().toString();
        if (anwserQuestion10.equalsIgnoreCase("Smelting")) {
            tempQuestion10 = 1;
        }
    }

    // Method to get anwser of Question 9
    private void testQuestion9() {
        radGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radStalactites:
                        tempQuestion9 = 2;
                        break;
                    case R.id.radStalagmites:
                        tempQuestion9 = 1;
                        break;
                }
            }
        });
    }

    // Method to get anwser of Question 8
    private void testQuestion8() {
        String anwserQuestion8 = edtQuestion8.getText().toString();
        if (anwserQuestion8.equalsIgnoreCase("Wrist")) {
            tempQuestion8 = 1;
        }
    }

    // Method to get anwser of Question 7
    private  void testQuestion7() {
        String temp = "";
        if (chkCeres.isChecked()) {
            temp += chkCeres.getText().toString();
        }
        if (chkMercury.isChecked()) {
            temp += chkMercury.getText().toString();
        }
        if (chkEarth.isChecked()) {
            temp += chkEarth.getText().toString();
        }
        if (chkPluto.isChecked()) {
            temp += chkPluto.getText().toString();
        }

        if (temp.equals("EarthPluto")) {
            tempQuestion7 = 1;
        }
    }

    // Method to get anwser of Question 6
    private void testQuestion6() {
        String anwserQuestion6 = edtQuestion6.getText().toString();
        if(anwserQuestion6.equalsIgnoreCase("Clouds") || anwserQuestion6.equalsIgnoreCase("Cloud")) {
            tempQuestion6 = 1;
        }
    }

    // Method to get anwser of Question 5
    private  void testQuestion5() {
        radGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radPineTrees:
                        tempQuestion5 = 1;
                        break;
                    case R.id.radOrkTrees:
                        tempQuestion5 = 2;
                        break;
                    case R.id.radPalmTrees:
                        tempQuestion5 = 3;
                        break;
                }
            }
        });
    }

    // Method to get anwser of Question 4
    private void testQuestion4() {
        String awnserQuestion4 = edtQuestion4.getText().toString();
        if (awnserQuestion4.equalsIgnoreCase("Gravity")) {
            tempQuestion4 = 1;
        }
    }

    // Method to get anwser of Question 3
    private void testQuestion3() {
        String temp = "";
        if(chkRibosome.isChecked()) {
            temp += chkRibosome.getText().toString();
        }
        if(chkPlasmids.isChecked()) {
            temp += chkPlasmids.getText().toString();
        }
        if(chkGolgiApparatus.isChecked()) {
            temp += chkGolgiApparatus.getText().toString();
        }
        if(chkDiploid.isChecked()) {
            temp += chkDiploid.getText().toString();
        }

        if(temp.equals("RibosomesGolgi apparatus")) {
            tempQuestion3 = 1;
        }
    }

    // Method to get anwser of Question 2
    private void testQuestion2() {
        String awnserQuestion2 = edtQuestion2.getText().toString();
        if (awnserQuestion2.equalsIgnoreCase("Vulcanizing")) {
            tempQuestion2 = 1;
        }

    }

    // Method to get anwser of Question 1
    private void testQuestion1() {
        radGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radRNA:
                        tempQuestion1 = 3;
                        break;
                    case R.id.radCIA:
                        tempQuestion1 = 2;
                        break;
                    case R.id.radDNA:
                        tempQuestion1 = 1;
                        break;
                }
            }
        });
    }

    public void btnSubmission() {
        btnSubmission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testQuestion2();
                testQuestion3();
                testQuestion4();
                testQuestion6();
                testQuestion7();
                testQuestion8();
                testQuestion10();
                checkResult();

            }
        });
    }

    public void checkResult() {
        ArrayList<Integer> result = new ArrayList<>();
        if (tempQuestion1 == 1) {
            result.add(tempQuestion1);
        }
        if (tempQuestion2 == 1) {
            result.add(tempQuestion2);
            tempQuestion2 = 0;
        }
        if (tempQuestion3 == 1) {
            result.add(tempQuestion3);
            tempQuestion3 = 0;
        }
        if (tempQuestion4 == 1) {
            result.add(tempQuestion4);
            tempQuestion4 = 0;
        }
        if (tempQuestion5 == 1) {
            result.add(tempQuestion5);
        }
        if (tempQuestion6 == 1) {
            result.add(tempQuestion6);
            tempQuestion6 = 0;
        }
        if (tempQuestion7 == 1) {
            result.add(tempQuestion7);
            tempQuestion7 = 0;
        }
        if (tempQuestion8 == 1) {
            result.add(tempQuestion8);
            tempQuestion8 = 0;
        }
        if (tempQuestion9 == 1) {
            result.add(tempQuestion9);
        }
        if (tempQuestion10 == 1) {
            result.add(tempQuestion10);
            tempQuestion10 = 0;
        }

        switch (result.size()) {
            case 1: Toast.makeText(MainActivity.this, "Try again! You scored 1 out of 10", Toast.LENGTH_SHORT).show(); break;
            case 2: Toast.makeText(MainActivity.this, "Try again! You scored 2 out of 10", Toast.LENGTH_SHORT).show(); break;
            case 3: Toast.makeText(MainActivity.this, "Try again! You scored 3 out of 10", Toast.LENGTH_SHORT).show(); break;
            case 4: Toast.makeText(MainActivity.this, "Try again! You scored 4 out of 10", Toast.LENGTH_SHORT).show(); break;
            case 5: Toast.makeText(MainActivity.this, "Try again! You scored 5 out of 10", Toast.LENGTH_SHORT).show(); break;
            case 6: Toast.makeText(MainActivity.this, "Try again! You scored 6 out of 10", Toast.LENGTH_SHORT).show(); break;
            case 7: Toast.makeText(MainActivity.this, "Try again! You scored 7 out of 10", Toast.LENGTH_SHORT).show(); break;
            case 8: Toast.makeText(MainActivity.this, "Try again! You scored 8 out of 10", Toast.LENGTH_SHORT).show(); break;
            case 9: Toast.makeText(MainActivity.this, "Try again! You scored 9 out of 10", Toast.LENGTH_SHORT).show(); break;
            case 10: Toast.makeText(MainActivity.this, "Perfect! You scored 10 out of 10", Toast.LENGTH_SHORT).show(); break;
            default: Toast.makeText(MainActivity.this, "BAD! You scored 0 out of 10", Toast.LENGTH_SHORT).show(); break;
        }

    }

    private void addControls() {
        txtUserName = findViewById(R.id.txtUserName);
        txtStdCode = findViewById(R.id.txtStdCode);
        radGroup1 = findViewById(R.id.radGroup1);
        radGroup2 = findViewById(R.id.radGroup2);
        radGroup3 = findViewById(R.id.radGroup3);
        radRNA = findViewById(R.id.radRNA);
        radCIA = findViewById(R.id.radCIA);
        radDNA = findViewById(R.id.radDNA);
        radPalmTrees = findViewById(R.id.radPalmTrees);
        radPineTrees = findViewById(R.id.radPineTrees);
        radOrkTrees = findViewById(R.id.radOrkTrees);
        radStalactites = findViewById(R.id.radStalactites);
        radStalagmites = findViewById(R.id.radStalagmites);
        edtQuestion2 = findViewById(R.id.edtQuestion2);
        edtQuestion4 = findViewById(R.id.edtQuestion4);
        edtQuestion6 = findViewById(R.id.edtQuestion6);
        edtQuestion8 = findViewById(R.id.edtQuestion8);
        edtQuestion10 = findViewById(R.id.edtQuestion10);
        chkRibosome = findViewById(R.id.chkRibosome);
        chkPlasmids = findViewById(R.id.chkPlasmids);
        chkGolgiApparatus = findViewById(R.id.chkGolgiApparatus);
        chkDiploid = findViewById(R.id.chkDiploid);
        chkCeres = findViewById(R.id.chkCeres);
        chkMercury = findViewById(R.id.chkMercury);
        chkPluto = findViewById(R.id.chkPluto);
        chkEarth = findViewById(R.id.chkEarth);
        btnSubmission = findViewById(R.id.btnSubmission);
    }
}
