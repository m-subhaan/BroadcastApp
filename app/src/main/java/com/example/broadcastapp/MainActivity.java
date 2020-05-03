package com.example.broadcastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText txt = (EditText) findViewById(R.id.msg);
        txt.setHint("Enter a message");

        Button sendbtn = (Button) findViewById(R.id.btn);
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txt.getText().toString().trim().equalsIgnoreCase(""))
                {
                    txt.setError("Fill out this Field");
                }

                else {
                    String msg = txt.getText().toString();
                    Intent i = new Intent();
                    i.putExtra("message", msg);
                    i.setAction("com.example.broadcastapp");
                    i.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                    sendBroadcast(i);
                    txt.setText("");
                    Toast toast=Toast.makeText(getApplicationContext(),"Sent!! Check Reciever App!",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }

}
