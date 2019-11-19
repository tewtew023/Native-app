package com.amon.mafirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.Amon.mafirstapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testFirestore();

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
    public void testFirestore(){
        final String TAG = "testFireStore";
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("category")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }
    public void openListPage(View view){
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
    }

}
