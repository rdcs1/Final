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

public class RegisterActivity extends AppCompatActivity {

    Button bCancel,bReg;
    EditText etUser,etPass,etPassR,etMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        etUser = (EditText)findViewById(R.id.etRegUser);
        etPass = (EditText)findViewById(R.id.etRegPass);
        etPassR = (EditText)findViewById(R.id.etRegPassR);
        etMail = (EditText)findViewById(R.id.etRegMail);
        bCancel = (Button)findViewById(R.id.bRegCancel);
        bReg = (Button)findViewById(R.id.bRegReg);

        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(etPass.getText().toString().equals(""))&&!
                        (etMail.getText().toString().equals(""))&&!
                        (etUser.getText().toString().equals(""))&&!
                        (etPassR.getText().toString().equals(""))){
                    if(etPass.getText().toString().equals(etPassR.getText().toString())){
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        intent.putExtra("user",etUser.getText().toString());
                        intent.putExtra("pass",etPass.getText().toString());
                        intent.putExtra("email",etMail.getText().toString());
                        Toast.makeText(getApplicationContext(),R.string.tRegReg,Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),R.string.tRegPassNoMatch,Toast.LENGTH_SHORT).show();
                        etPass.setText("");
                        etPassR.setText("");
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(),R.string.tLogEmpty,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
