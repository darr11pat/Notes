package edu.niu.cs.z1779946.notes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertNote("New note");
    }

    private void insertNote(String note_text) {
        ContentValues values = new ContentValues();
        values.put(String.valueOf(DBOpenHelper.NOTE_TEXT), note_text);
        Uri noteUri =  getContentResolver().insert(NotesProvider.CONTENT_URI, values);

        Log.d("MainActivity", "Inserted note" + noteUri.getLastPathSegment());
    }
}
