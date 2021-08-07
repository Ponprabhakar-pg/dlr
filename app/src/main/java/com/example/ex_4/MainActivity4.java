package com.example.ex_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity{
    String usr,email,mobile,city;
    TextView t1,t3,t4,t5;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db=openOrCreateDatabase("stockdata", Context.MODE_PRIVATE, null);
        setContentView(R.layout.activity_main4);
        Button b7,b8;
        usr = getIntent().getStringExtra("a");
        email = getIntent().getStringExtra("b");
        mobile = getIntent().getStringExtra("c");
        city = getIntent().getStringExtra("d");
        t1 = (TextView)findViewById(R.id.username);
        t3 = (TextView)findViewById(R.id.email);

        t1.setText("Username:  "+usr);
        t1.setTextSize(20);
        t3.setText("Mail ID:  "+email);
        t3.setTextSize(20);


        b7 = (Button)findViewById(R.id.button7);
        b8 = (Button)findViewById(R.id.button8);

        b7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(MainActivity4.this,MainActivity.class);
                startActivity(n);
            }
        });

        b8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.delete("student", "username" + "=?", new String[]{usr}) > 0) {
                    Toast.makeText(getApplicationContext(),"Stock deleted successfully!",Toast.LENGTH_SHORT).show();
                    Intent n = new Intent(MainActivity4.this, MainActivity.class);
                    startActivity(n);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Unable to delete!",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
