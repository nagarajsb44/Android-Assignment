package com.example.sois.healthcare;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnreg,_btnlogin;
    EditText _editText1, _editText2, _editText3, _editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper = new DatabaseHelper(this);
        _btnreg = (Button) findViewById(R.id.btnreg);
        _editText1 = (EditText) findViewById(R.id.text1);
        _editText2 = (EditText) findViewById(R.id.text2);
        _editText3 = (EditText) findViewById(R.id.text3);
        _editText4 = (EditText) findViewById(R.id.text4);
        _btnlogin = (Button) findViewById(R.id.btnLogin);
        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                String fname = _editText1.getText().toString();
                String lname = _editText2.getText().toString();
                String email = _editText3.getText().toString();
                String pass = _editText4.getText().toString();
                insertdata(fname, lname, email, pass);
                Toast.makeText(getApplicationContext(), "register successfully", Toast.LENGTH_LONG).show();

            }
        });
        _btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
            }
        });

            }


    public void insertdata(String fname, String lname, String pass, String email){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, fname);
        contentValues.put(DatabaseHelper.COL_3, lname);
        contentValues.put(DatabaseHelper.COL_4, email);
        contentValues.put(DatabaseHelper.COL_5, pass);
        long id = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
    }
}
