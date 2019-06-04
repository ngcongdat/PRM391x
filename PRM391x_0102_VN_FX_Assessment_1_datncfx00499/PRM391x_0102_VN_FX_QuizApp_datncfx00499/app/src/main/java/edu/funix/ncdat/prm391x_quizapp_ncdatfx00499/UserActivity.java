package edu.funix.ncdat.prm391x_quizapp_ncdatfx00499;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {

    EditText edtUserName, edtStdCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        addControls();
    }

    private void addControls() {
        edtUserName = findViewById(R.id.edtUserName);
        edtStdCode = findViewById(R.id.edtStdCode);
    }

    public void btnLogin(View view) {
        if(edtUserName.getText().length() != 0 && edtStdCode.getText().length() != 0) {
            Intent intent = new Intent(UserActivity.this, MainActivity.class);
            intent.putExtra("Username", edtUserName.getText().toString());
            intent.putExtra("StudentCode", edtStdCode.getText().toString());
            startActivity(intent);
        }
        if (edtUserName.getText().length() == 0 && edtStdCode.getText().length() != 0) {
            Toast.makeText(UserActivity.this, "Please input your Username!!!", Toast.LENGTH_LONG).show();
        }
        if (edtUserName.getText().length() != 0 && edtStdCode.getText().length() == 0) {
            Toast.makeText(UserActivity.this, "Please input your Student Code!!!", Toast.LENGTH_LONG).show();
        }
        if(edtUserName.getText().length() == 0 && edtStdCode.getText().length() == 0) {
            Toast.makeText(UserActivity.this, "Please input your information!!!", Toast.LENGTH_LONG).show();
        }
    }
}
