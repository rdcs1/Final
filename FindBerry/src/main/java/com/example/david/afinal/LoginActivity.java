package com.example.david.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUser,etPass;
    Button bLog;
    TextView tvReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        etUser = (EditText)findViewById(R.id.etLogUser);
        etPass = (EditText)findViewById(R.id.etLogPass);
        bLog = (Button)findViewById(R.id.bLogLog);
        tvReg = (TextView)findViewById(R.id.tvLogReg);

        tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        etUser.setText(getIntent().getStringExtra("user"));
        etPass.setText(getIntent().getStringExtra("pass"));

        bLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUser.getText().toString().equals(getIntent().getStringExtra("user"))){
                    if(etPass.getText().toString().equals(getIntent().getStringExtra("pass"))){
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        intent.putExtra("user",getIntent().getStringExtra("user"));
                        intent.putExtra("email",getIntent().getStringExtra("email"));
                        startActivity(intent);
                        finish();
                    }
                    else if(etPass.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(),R.string.tLogEmpty,Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),R.string.tLogWrongPass,Toast.LENGTH_SHORT).show();
                    }
                }
                else if(etUser.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),R.string.tLogEmpty,Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),R.string.tLogWrongUser,Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
