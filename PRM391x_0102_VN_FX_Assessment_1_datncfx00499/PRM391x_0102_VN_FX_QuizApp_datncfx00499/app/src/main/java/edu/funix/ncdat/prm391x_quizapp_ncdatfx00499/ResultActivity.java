package edu.funix.ncdat.prm391x_quizapp_ncdatfx00499;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        txtResult = findViewById(R.id.txtResult);
        Intent intent = getIntent();
        ArrayList<Integer> tempResult = intent.getIntegerArrayListExtra("Result");
        switch (tempResult.size()) {
            case 1: txtResult.setText("You scored 1 out of 10"); break;
            case 2: txtResult.setText("You scored 2 out of 10"); break;
            case 3: txtResult.setText("You scored 3 out of 10"); break;
            case 4: txtResult.setText("You scored 4 out of 10"); break;
            case 5: txtResult.setText("You scored 5 out of 10"); break;
            case 6: txtResult.setText("You scored 6 out of 10"); break;
            case 7: txtResult.setText("You scored 7 out of 10"); break;
            case 8: txtResult.setText("You scored 8 out of 10"); break;
            case 9: txtResult.setText("You scored 9 out of 10"); break;
            case 10: txtResult.setText("You scored 10 out of 10"); break;
            default: txtResult.setText("You scored 0 out of 10"); break;
        }
    }

    public void btnTryAgain(View view) {
        Intent intent = new Intent(ResultActivity.this, UserActivity.class);
        startActivity(intent);
    }
}
