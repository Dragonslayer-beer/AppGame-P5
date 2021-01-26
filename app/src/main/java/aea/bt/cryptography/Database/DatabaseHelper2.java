package aea.bt.cryptography.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import aea.bt.cryptography.Database.Question.tableQuestion1;


public class DatabaseHelper2 extends SQLiteOpenHelper {
    public static final String database_Name = "Database_game_mr5_2";
    public static final int database_Version = 1;
    SQLiteDatabase db;

    public DatabaseHelper2(@Nullable Context context) {
        super(context, database_Name, null, database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String create_table = "CREATE TABLE " + tableQuestion1.questionTable_Name + "(" + tableQuestion1._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + tableQuestion1.question + " TEXT," + Question.tableQuestion1.rightAnswer + " TEXT," + tableQuestion1.option1 + " TEXT," + tableQuestion1.option2 + " TEXT,"
                + tableQuestion1.codeName + " TEXT)";



        db.execSQL(create_table);

        final String insertData = "INSERT INTO " + tableQuestion1.questionTable_Name + "(" + tableQuestion1.question + "," + tableQuestion1.rightAnswer + "," +
                tableQuestion1.option1 + "," + tableQuestion1.option2 + "," + tableQuestion1.codeName + ") VALUES" +
                "('st1', 'st_1_1', 'st_1_2', 'st_1_3','lesson1')" +
                ",('st2', 'st_2_1', 'st_2_2', 'st_2_3','lesson1')" +
                ",('st3', 'st_3_1', 'st_3_2', 'st_3_3','lesson1')" +
                ",('st4', 'st_4_1', 'st_4_2', 'st_4_3','lesson1')" +
                ",('st5', 'st_5_1', 'st_5_2', 'st_5_3','lesson1')" +
                ",('st6', 'st_6_1', 'st_6_2', 'st_6_3','lesson1')" +
                ",('st7', 'st_7_1', 'st_7_2', 'st_7_3','lesson1')" +
                ",('st8', 'st_8_1', 'st_8_2', 'st_8_3','lesson1')" +
                ",('st9', 'st_9_1', 'st_9_2', 'st_9_3','lesson1')" +
                ",('st10', 'st_10_1', 'st_10_2', 'st_10_3','lesson1')";
        db.execSQL(insertData);
}
    public void openCreateDatabase() {
        db = getReadableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableQuestion1.questionTable_Name);
        onCreate(db);

    }

    public ArrayList<ArrayList<String>> getAllQuiz(int gameID, int dfID) {
        ArrayList<ArrayList<String>> quizData = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = null;
        if (gameID == 0 && dfID == 0) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion1.questionTable_Name + " WHERE " + tableQuestion1.codeName + "= 'lesson1'", null);
        }
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ArrayList<String> tmpQuiz = new ArrayList<>();
            tmpQuiz.add(cursor.getString(1));
            tmpQuiz.add(cursor.getString(2));
            tmpQuiz.add(cursor.getString(3));
            tmpQuiz.add(cursor.getString(4));
            quizData.add(tmpQuiz);
            cursor.moveToNext();
        }

        db.close();
        return quizData;
    }

}
