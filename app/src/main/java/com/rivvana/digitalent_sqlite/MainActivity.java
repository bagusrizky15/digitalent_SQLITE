package com.rivvana.digitalent_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvMsg = findViewById(R.id.tv_text);
        btnInsert = findViewById(R.id.btn_insert_data);

        File storagePath = getApplication().getFilesDir();
        String myDbPath = storagePath + "/" + "vsga2022DB";
        tvMsg.setText("DB Path : " + myDbPath);
        try {
            db = SQLiteDatabase.openDatabase(myDbPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
           // db.close();
            tvMsg.append("\nAll done");
        } catch (Exception e) {
            tvMsg.append("\nError " + e.getMessage());
        }

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("create table tblPhone ("
                        + " id integer PRIMARY KEY autoincrement, "
                        + " name text, "
                        + " phone text); " );
                db.execSQL("insert into tblPhone(name, phone) values ('Budi', '085712341234');");
                db.execSQL("insert into tblPhone(name, phone) values ('Juli', '085712344567');");
                db.execSQL("insert into tblPhone(name, phone) values ('Aqua', '085712347890');");
            }
        });

    }
}