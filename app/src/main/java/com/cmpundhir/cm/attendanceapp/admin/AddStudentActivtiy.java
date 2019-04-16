package com.cmpundhir.cm.attendanceapp.admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.cmpundhir.cm.attendanceapp.R;
import com.cmpundhir.cm.attendanceapp.helper.DBHelper;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddStudentActivtiy extends AppCompatActivity {

    EditText editname,editroll;
    Button add;
    Spinner spinnerDept,spinner1Batch;
    FirebaseDatabase database ;
    DatabaseReference myRef ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student_activtiy);
        editname=findViewById(R.id.edit_nam);
        editroll=findViewById(R.id.edit_rn);
        add=findViewById(R.id.btn_add);
        spinnerDept=findViewById(R.id.dept);
        spinner1Batch=findViewById(R.id.batch);
        ArrayAdapter adapterDpt=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, DBHelper.dptlist);
        spinnerDept.setAdapter(adapterDpt);
        ArrayAdapter adapterbatch=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, DBHelper.batchList);
        spinner1Batch.setAdapter(adapterbatch);




        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");
        // Read from the database


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

    }
}
