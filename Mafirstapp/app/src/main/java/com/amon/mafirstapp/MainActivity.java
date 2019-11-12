package com.amon.mafirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.Amon.mafirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, activity_display_name.class);
        EditText editText = (EditText) findViewById(R.id.editText2);
        String id = editText.getText().toString();

        EditText editText3 = (EditText) findViewById(R.id.editText3);
        String password = editText.getText().toString();

    login(id,password);


    }
    public void login( String user_name,String pass ){
        String id,password;
        id=user_name; password=pass;
    if((id.equals("admin") && password.equals("admin"))){
        Intent intent = new Intent(this, activity_display_name.class);
        intent.putExtra(EXTRA_MESSAGE, id);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Loging in", Toast.LENGTH_SHORT).show();
    }else{Toast.makeText(getApplicationContext(), "Wrong ID or Password", Toast.LENGTH_SHORT).show();}

    }
}
