package com.example.mycanteen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminSignup extends AppCompatActivity {
    EditText fname,lname,email,pass,phone;
    Button b1;
    TextView t1;
    DBhelper DB;
    public static String SIGNUPEMAIL="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_signup_page);
        fname=findViewById(R.id.fnameAdmin);
        lname=findViewById(R.id.lnameAdmin);
        email=findViewById(R.id.emailIdAdmin);
        pass=findViewById(R.id.pwdAdmin);
        phone=findViewById(R.id.phoneAdmin);
        b1=findViewById(R.id.signinbtnAdmin);
        t1=findViewById(R.id.signintxtAdmin);
        DB=new DBhelper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fnameStr=fname.getText().toString();
                String lnameStr=lname.getText().toString();
                String emailStr=email.getText().toString();
                String passStr=pass.getText().toString();
                String phoneStr=phone.getText().toString();
                if(fnameStr.equals("")|| lnameStr.equals("") || emailStr.equals("") || passStr.equals("") || phoneStr.equals(""))
                {
                    Toast.makeText(AdminSignup.this,"Please enter all the fields",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Boolean checkemail=DB.checkEmail(emailStr);
                    if(checkemail==false)
                    {
                        Boolean insert=DB.insertData(fnameStr,lnameStr,emailStr,passStr,phoneStr);
                        if(insert==true)
                        {
                            Toast.makeText(AdminSignup.this,"Registered Successfully",Toast.LENGTH_LONG).show();
                            SIGNUPEMAIL=emailStr;
                            Intent intent=new Intent(AdminSignup.this,MainActivity2.class);
                            intent.putExtra("EMAIL",emailStr);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(AdminSignup.this,"Registration Failed",Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(AdminSignup.this,"User alreday exists, Please Sign in",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent11=new Intent(AdminSignup.this,AdminLogin.class);

                startActivity(intent11);

            }
        });

    }
}