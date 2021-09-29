package com.example.uiproject4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.uiproject3.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et1 = findViewById(R.id.Name1);
        final EditText et2 = findViewById(R.id.Name2);
        final EditText et3 = findViewById(R.id.Email_addr);
        final EditText et4 = findViewById(R.id.Phone_num);
        Button btn1 = findViewById(R.id.Clr);
        //Button btn2 = findViewById(R.id.Add_cont);        // if it wasn,t a link to another activity

        btn1.setOnClickListener(v -> {
            et1.getText().clear();
            et2.getText().clear();
            et3.getText().clear();
            et4.getText().clear();
        });
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessage.class);
        EditText et1 = findViewById(R.id.Name1);
        EditText et2 = findViewById(R.id.Name2);
        EditText et3 = findViewById(R.id.Email_addr);
        EditText et4 = findViewById(R.id.Phone_num);

        //      if phone numbers are just 10 numbers, they we be reformatted
        //      length = 10, (index = 0-9 for starting point, 1-10 (+1) if specifying end point)
        if(et4.length() == 10){
            String et5 = "(" + et4.getText().toString().substring(0, 3) + ")-" + et4.getText().toString().substring(3, 6) + "-" + et4.getText().toString().substring(6, 10);
            String message = "First Name: \t" + et1.getText().toString() + "\n\nLast Name: \t" + et2.getText().toString() + "\n\nEmail Address: \n\t\t" + et3.getText().toString() + "\n\nPhone Number: \n\t\t" + et5;
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
        else {
            String message = "First Name: \t" + et1.getText().toString() + "\n\nLast Name: \t" + et2.getText().toString() + "\n\nEmail Address: \n\t\t" + et3.getText().toString() + "\n\nPhone Number: \n\t\t" + et4.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }
}