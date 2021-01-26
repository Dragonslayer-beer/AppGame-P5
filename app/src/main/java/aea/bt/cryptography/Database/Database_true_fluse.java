package aea.bt.cryptography.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import aea.bt.cryptography.Database.Question.tableQuestion;


public class Database_true_fluse extends SQLiteOpenHelper {
    public static final String database_Name = "Database_gamee_mr5";
    public static final int database_Version = 1;
    SQLiteDatabase db;

    public Database_true_fluse(@Nullable Context context) {
        super(context, database_Name, null, database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String create_table = "CREATE TABLE " + tableQuestion.questionTable_Name + "(" + tableQuestion._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + tableQuestion.question + " TEXT," + tableQuestion.rightAnswer + " TEXT," + tableQuestion.option1 + " TEXT,"
                + tableQuestion.codeName + " TEXT)";



        db.execSQL(create_table);

        final String insertData = "INSERT INTO " + tableQuestion.questionTable_Name + "(" + tableQuestion.question + "," + tableQuestion.rightAnswer + "," +
                tableQuestion.option1 + "," + tableQuestion.codeName + ") VALUES" +
                "('chck1', 'True',  'ss','ex')" +
                ",('chck2', '10 ກັນຍາ', 'True','ex')" +
                ",('chck3', 'True', 'True','ex')" +
                ",('chck4', 'True', 'sss','ex')" +
                ",('chck5', 'True', 'sss','ex')" +
                ",('chck6', '10 ກັນຍາ', 'True','ex')" +
                ",('chck7', '10 ກັນຍາ', 'True','ex')" +
                ",('chck8', 'True', 'sss','ex')" +
                ",('chck9', '10 ກັນຍາ', 'True','ex')" +
                ",('chck10', 'True', 'se','ex')" +
                ",('chck11', '10 ກັນຍາ', 'True','ex')" +
                ",('chck12', 'True', 'Trsue','ex')" +
                ",('chck13', '10 ກັນຍາ', 'True','ex')" +
                ",('chck14', 'True', 'Tsrue','ex')" +
                ",('chck15', 'True', 'Tsrue','ex')" +
                ",('chck16', '10 ກັນຍາ', 'True','ex')" +
                ",('chck17', 'True', 'Trsue','ex')" +
                ",('chck18', 'True', 'Trsue','ex')" +
                ",('chck19', '10 ກັນຍາ', 'True','ex')" +
                ",('chck20', 'True', 'Tsrue','ex')" ;


                //______________________________________________________________________________________________________________
        db.execSQL(insertData);


}

    public void openCreateDatabase() {
        db = getReadableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + tableQuestion.questionTable_Name);
        onCreate(db);

    }

    public ArrayList<ArrayList<String>> getAllQuiz(int gameID, int dfID) {
        ArrayList<ArrayList<String>> quizData = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = null;
        if (gameID == 0 && dfID == 0) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion.questionTable_Name + " WHERE " + tableQuestion.codeName + "= 'ex'", null);


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
