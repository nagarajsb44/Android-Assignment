package com.example.sois.healthcare;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button _btnLogin;
    EditText _text1, _text2;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openHelper = new DatabaseHelper(this);
        db = openHelper.getReadableDatabase();
        _btnLogin = (Button) findViewById(R.id.btnLogin);
        _text1 = (EditText) findViewById(R.id.text1);
        _text2 = (EditText) findViewById(R.id.text2);
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = _text1.getText().toString();
                String pass = _text2.getText().toString();
                cursor = db.rawQuery(" SELECT * FROM " + DatabaseHelper.TABLE_NAME +" WHERE "+DatabaseHelper.COL_4 + " = ? AND DatabaseHelper.COL_5 =?", new String[]{email, pass});
                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(), "login successfully", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                    }




                }
            }


        });

    }
}
