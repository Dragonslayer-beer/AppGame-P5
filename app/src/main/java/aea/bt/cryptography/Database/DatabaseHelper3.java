package aea.bt.cryptography.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import aea.bt.cryptography.Database.Question.tableQuestion1;


public class DatabaseHelper3 extends SQLiteOpenHelper {
    public static final String database_Name = "Database_game_mr5_2";
    public static final int database_Version = 1;
    SQLiteDatabase db;

    public DatabaseHelper3(@Nullable Context context) {
        super(context, database_Name, null, database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String create_table = "CREATE TABLE " + tableQuestion1.questionTable_Name + "(" + tableQuestion1._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + tableQuestion1.question + " TEXT," + tableQuestion1.rightAnswer + " TEXT," + tableQuestion1.option1 + " TEXT," + tableQuestion1.option2 + " TEXT,"
                + tableQuestion1.codeName + " TEXT)";


        db.execSQL(create_table);

        final String insertData = "INSERT INTO " + tableQuestion1.questionTable_Name + "(" + tableQuestion1.question + "," + tableQuestion1.rightAnswer + "," +
                tableQuestion1.option1 + "," + tableQuestion1.option2 + "," + tableQuestion1.codeName + ") VALUES" +
                "('t1_noun_ex1', '. ', ',', ';','noun_lesson1')" +
                ",('t1_noun_ex2', ',', '.', ';','noun_lesson1')" +
                ",('t1_noun_ex3', ';', '.', ',','noun_lesson1')" +
                ",('t1_noun_ex4', '!', ',', ';','noun_lesson1')" +
                ",('t1_noun_ex5', '“”', '?', '!','noun_lesson1')" +
                ",('t1_noun_ex6', ':', ';', '“”','noun_lesson1')" +
                ",('t1_noun_ex7', 'ເຊັ່ນ', 'ຫຼື', 'ແລະ','noun_lesson1')" +
                ",('t1_noun_ex8', 'ໂທເອີຍ', 'ໂດຍ', 'ແມ່ນແລ້ວ','noun_lesson1')" +
                ",('t1_noun_ex9', ' ວັກຕອນ', 'ຄຳຖາມ', 'ໄວຍາກອນ','noun_lesson1')" +
                ",('t1_noun_ex10', ' ,', '.', ';','noun_lesson1')" +

                //______________________________________________________________________________________________________________
                ",('t2_noun_ex1', 'ຄຳນາມ', 'ຄຳແທນນາມ', 'ຄຳກຳມະ','noun_lesson2')" +
                ",('t2_noun_ex2', 'ຄຳແທນນາມ', 'ຄຳນາມ', 'ຄຳກຳມະ','noun_lesson2')" +
                ",('t2_noun_ex3', 'ຄຳກຳມະ ', 'ຄຳແທນນາມ', 'ຄຳນາມ','noun_lesson2')" +
                ",('t2_noun_ex4', 'ທ້າວຄຳໃສ', 'ຂ້ອຍ', 'ເວົ້າ','noun_lesson2')" +
                ",('t2_noun_ex4', 'ໂຮງຮຽນ', 'ເຈົ້າ', 'ກ່າວວ່າ','noun_lesson2')" +
                ",('t2_noun_ex4', 'ໝາ', 'ພວກເຂົາ', 'ນົບໄຫວ້','noun_lesson2')" +
                ",('t2_noun_ex7', 'ຂ້ອຍ', 'ແມວ', 'ປຶ້ມ','noun_lesson2')" +
                ",('t2_noun_ex7', 'ລາວ', 'ມາ', 'ສໍດຳ','noun_lesson2')" +
                ",('t2_noun_ex7', 'ພວກເຂົາ', 'ໄກ່', 'ຂີ່ລົດ','noun_lesson2')" +
                ",('t2_noun_ex10', 'ຍ່າງ', 'ຂ້ອຍ', 'ກິນ','noun_lesson2')" +

                //______________________________________________________________________________________________________________
                ",('t3_noun_ex1', 'ຄຳຄຸນນາມ', 'ຄຳເຊື່ອມ', 'ຄຳອຸທານ','noun_lesson3')" +
                ",('t3_noun_ex2', 'ຄຳເຊື່ອມ', 'ຄຳຕໍ່', 'ຄຳອຸທານ','noun_lesson3')" +
                ",('t3_noun_ex3', 'ຄຳຕໍ່', 'ຄຳເຊື່ອມ', 'ຄຳຄຸນນາມ','noun_lesson3')" +
                ",('t3_noun_ex4', 'ຄຳອຸທານ', 'ຄຳແທນນາມ', 'ຄຳນາມ','noun_lesson3')" +
                ",('t3_noun_ex5', 'ແຈ້ງດີ', 'ຄິດ', 'ໂຢວ!','noun_lesson3')" +
                ",('t3_noun_ex6', 'ໃນ', 'ລັ່ງເລໃຈ', 'ຄ່ອຍໆ','noun_lesson3')" +
                ",('t3_noun_ex7', 'ແລະ', 'ລັ່ງເລໃຈ', 'ຄິດ','noun_lesson3')" +
                ",('t3_noun_ex8', 'ປັດໂທ!', 'ຂອບໃຈ', 'ຮ້າຍ!','noun_lesson3')" +
                ",('t3_noun_ex5', 'ຮ້າຍ', 'ສະບາຍດີ', 'ເປັນຫ່ວງ','noun_lesson3')" +
                ",('t3_noun_ex8', 'ໂອຍ!', 'ເຈົ້າ!', 'ຮາຮາ!','noun_lesson3')" +

                //______________________________________________________________________________________________________________
                ",('t4_noun_ex1', 'ຄຳບຸພະບົດ', 'ຄຳສ້ອຍ', 'ອຸທານ','noun_lesson4')" +
                ",('t4_noun_ex2', 'ຄຳສ້ອຍ', 'ຄຳບຸພະບົດ', 'ຄຳແທນນາມ','noun_lesson4')" +
                ",('t4_noun_ex3', 'ພໍເຫັນ', 'ແທ້ເດ', 'ພັດພາກ','noun_lesson4')" +
                ",('t4_noun_ex4', 'ແທ້ເດ', 'ໜ້ອຍໜຶ່ງ', 'ຟັງເນີ','noun_lesson4')" +
                ",('t4_noun_ex3', 'ໜ້ອຍໜຶ່ງ', 'ບຶດດຽວ', 'ໜ້ອຍດຽວ','noun_lesson4')" +
                ",('t4_noun_ex3', 'ຄາວໜຶ່ງ ', 'ຄາວດຽວ', 'ຄາວໜ້າ','noun_lesson4')" +
                ",('t4_noun_ex4', 'ແທ້ແລ້ວ', 'ແມ່ນແທ້', 'ແທ້ໆ','noun_lesson4')" +
                ",('t4_noun_ex3', 'ຟັງເນີ', 'ຟັງແດ່', 'ຟັງບໍ','noun_lesson4')" +
                ",('t4_noun_ex4', 'ພຸ້ນເນີ', 'ພຸ້ນພີ້', 'ພຸ້ນນະ','noun_lesson4')" +
                ",('t4_noun_ex3', 'ຟັງສຽງ ', 'ຟັງເພງ', 'ຟັງລຳ','noun_lesson4')" +

                //________________________________________________________________
                //______________________________________________________________________________________________________________
                ",('t5_noun_ex1', 'ປະໂຫຍກ', 'ຄຳ', 'ຄຳຕົວຕັ້ງ','noun_lesson5')" +
                ",('t5_noun_ex2', 'ປະໂຫຍກ', 'ວະລີ', 'ຄຳອຸທານ','noun_lesson5')" +
                ",('t5_noun_ex3', 'ປະໂຫຍກ 2', 'ປະໂຫຍກ 3', 'ປະໂຫຍກ 4','noun_lesson5')" +
                ",('t5_noun_ex4', 'ປະໂຫຍກ 3', 'ປະໂຫຍກ 2', 'ປະໂຫຍກ 4','noun_lesson5')" +
                ",('t5_noun_ex5', 'ຊ້າງ ອວດສະຫາວ', 'ນາງນົກໄສ່ ໄປຫາພະຍາກົບ', 'ພະຍາກົບໃຫ້ຄຳແນະນຳ','noun_lesson5')" +
                ",('t5_noun_ex6', 'ຊ້າງ ດຶງ ຮຽວໄຜ່', 'ນົກໄສ່ເສຍໃຈ', 'ຂ້ອຍດີໃຈ','noun_lesson5')" +
                ",('t5_noun_ex5', 'ນົກໄສ່ ໂສກເສົ້າ', 'ຂ້ອຍຍ່າງໄປໂຮງຮຽນ', 'ນົກບິນຂຶ້ນຟ້າ','noun_lesson5')" +
                ",('t5_noun_ex6', 'ນົກໄສ່ ເຫັນ ຊ້າງ', 'ຊ້າງສານໂມໂຫ', 'ລາວຮ້ອງໄຫ້','noun_lesson5')" +
                ",('t5_noun_ex4', 'ປະໂຫຍກ 3', 'ປະໂຫຍກ 2', 'ປະໂຫຍກ 4','noun_lesson5')" +
                ",('t5_noun_ex1', 'ປະໂຫຍກ', 'ຄຳ', 'ຄຳຕົວຕັ້ງ','noun_lesson5')" +

                //________________________________________________________________
                //______________________________________________________________________________________________________________
                ",('t6_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson6')" +
                ",('t6_noun_ex2', 'ex1', 'ex2', 'ex3','noun_lesson6')" +
                ",('t6_noun_ex3', 'ex1', 'ex2', 'ex3','noun_lesson6')" +
                ",('t6_noun_ex4', 'ex1', 'ex2', 'ex3','noun_lesson6')" +
                ",('t6_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson6')" +
                ",('t6_noun_ex2', 'ex1', 'ex2', 'ex3','noun_lesson6')" +
                ",('t6_noun_ex3', 'ex1', 'ex2', 'ex3','noun_lesson6')" +
                ",('t6_noun_ex4', 'ex1', 'ex2', 'ex3','noun_lesson6')" +
                ",('t6_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson6')" +
                ",('t6_noun_ex2', 'ex1', 'ex2', 'ex3','noun_lesson6')" +

                //________________________________________________________________
                //______________________________________________________________________________________________________________
                ",('t7_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson7')" +
                ",('t7_noun_ex2', 'ex1', 'ex2', 'ex3','noun_lesson7')" +
                ",('t7_noun_ex3', 'ex1', 'ex2', 'ex3','noun_lesson7')" +
                ",('t7_noun_ex4', 'ex1', 'ex2', 'ex3','noun_lesson7')" +
                ",('t7_noun_ex5', 'ex1', 'ex2', 'ex3','noun_lesson7')" +
                ",('t7_noun_ex6', 'ex1', 'ex2', 'ex3','noun_lesson7')" +
                ",('t7_noun_ex7', 'ex1', 'ex2', 'ex3','noun_lesson7')" +
                ",('t7_noun_ex8', 'ex1', 'ex2', 'ex3','noun_lesson7')" +
                ",('t7_noun_ex9', 'ex1', 'ex2', 'ex3','noun_lesson7')" +
                ",('t7_noun_ex10', 'ex1', 'ex2', 'ex3','noun_lesson7')" +

                //________________________________________________________________
                //______________________________________________________________________________________________________________
                ",('t8_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson8')" +
                ",('t8_noun_ex2', 'ex1', 'ex2', 'ex3','noun_lesson8')" +
                ",('t8_noun_ex3', 'ex1', 'ex2', 'ex3','noun_lesson8')" +
                ",('t8_noun_ex4', 'ex1', 'ex2', 'ex3','noun_lesson8')" +
                ",('t8_noun_ex5', 'ex1', 'ex2', 'ex3','noun_lesson8')" +
                ",('t8_noun_ex6', 'ex1', 'ex2', 'ex3','noun_lesson8')" +
                ",('t8_noun_ex7', 'ex1', 'ex2', 'ex3','noun_lesson8')" +
                ",('t8_noun_ex8', 'ex1', 'ex2', 'ex3','noun_lesson8')" +
                ",('t8_noun_ex9', 'ex1', 'ex2', 'ex3','noun_lesson8')" +
                ",('t8_noun_ex10', 'ex1', 'ex2', 'ex3','noun_lesson8')" +

                //________________________________________________________________
                //______________________________________________________________________________________________________________
                ",('t9_noun_ex1', 'ປະໂຫຍກບອກເລົ່າ', 'ປະໂຫຍກບອກກ່າວ', 'ປະໂຫຍກເລົ່າ','noun_lesson9')" +
                ",('t9_noun_ex2', 'ປະໂຫຍກສາມັນ', 'ປະໂຫຍກວະລີ', 'ປະໂຫຍກທຳມະດາ','noun_lesson9')" +
                ",('t9_noun_ex3', 'ວັນທີ 7 ຕຸລາ', 'ນາຍບ້ານ', 'ອຳນວຍການໂຮງຮຽນ','noun_lesson9')" +
                ",('t9_noun_ex4', 'ທ້າວຈັນສະໝຸດ', 'ການມອບຂອງຂວັນ', 'ກຳລັງ','noun_lesson9')" +
                ",('t9_noun_ex1', 'ປະໂຫຍກບອກເລົ່າ', 'ປະໂຫຍກບອກກ່າວ', 'ປະໂຫຍກເລົ່າ','noun_lesson9')" +
                ",('t9_noun_ex2', 'ປະໂຫຍກສາມັນ', 'ປະໂຫຍກວະລີ', 'ປະໂຫຍກທຳມະດາ','noun_lesson9')" +
                ",('t9_noun_ex3', 'ວັນທີ 7 ຕຸລາ', 'ນາຍບ້ານ', 'ອຳນວຍການໂຮງຮຽນ','noun_lesson9')" +
                ",('t9_noun_ex4', 'ທ້າວຈັນສະໝຸດ', 'ການມອບຂອງຂວັນ', 'ກຳລັງ','noun_lesson9')" +
                ",('t9_noun_ex1', 'ປະໂຫຍກບອກເລົ່າ', 'ປະໂຫຍກບອກກ່າວ', 'ປະໂຫຍກເລົ່າ','noun_lesson9')" +
                ",('t9_noun_ex2', 'ປະໂຫຍກສາມັນ', 'ປະໂຫຍກວະລີ', 'ປະໂຫຍກທຳມະດາ','noun_lesson9')" +

                //________________________________________________________________
                //______________________________________________________________________________________________________________
                ",('t10_noun_ex1', 'ປະໂຫຍກໃຈຄວາມດຽວ', 'ປະໂຫຍກໃຈດຽວ', 'ປະໂຫຍກຄວາມດຽວ','noun_lesson10')" +
                ",('t10_noun_ex2', 'ປະໂຫຍກບອກເລົ່າ', 'ປະໂຫຍກບອກກ່າວ', 'ປະໂຫຍກເລົ່າ','noun_lesson10')" +
                ",('t10_noun_ex3', 'ປະໂຫຍກສາມັນ', 'ປະໂຫຍກວະລີ', 'ປະໂຫຍກທຳມະດາ','noun_lesson10')" +
                ",('t10_noun_ex4', 'ວັນທີ 7 ຕຸລາ', 'ນາຍບ້ານ', 'ອຳນວຍການໂຮງຮຽນ','noun_lesson10')" +
                ",('t10_noun_ex5', 'ທ້າວຈັນສະໝຸດ', 'ການມອບຂອງຂວັນ', 'ກຳລັງ','noun_lesson10')" +
                ",('t10_noun_ex6', 'ຊ້າງ ອວດສະຫາວ', 'ນາງນົກໄສ່ ໄປຫາພະຍາກົບ', 'ພະຍາກົບໃຫ້ຄຳແນະນຳ','noun_lesson10')" +
                ",('t10_noun_ex7', 'ຊ້າງ ດຶງ ຮຽວໄຜ່', 'ນົກໄສ່ເສຍໃຈ', 'ຂ້ອຍດີໃຈ','noun_lesson10')" +
                ",('t10_noun_ex6', 'ນົກໄສ່ ໂສກເສົ້າ', 'ຂ້ອຍຍ່າງໄປໂຮງຮຽນ', 'ນົກບິນຂຶ້ນຟ້າ','noun_lesson10')" +
                ",('t10_noun_ex7', 'ນົກໄສ່ ເຫັນ ຊ້າງ', 'ຊ້າງສານໂມໂຫ', 'ລາວຮ້ອງໄຫ້','noun_lesson10')" +
                ",('t10_noun_ex10', 'ປະໂຫຍກ 3', 'ປະໂຫຍກ 2', 'ປະໂຫຍກ 4','noun_lesson10')" +

                //________________________________________________________________
                //______________________________________________________________________________________________________________
                ",('t11_noun_ex1', 'ປະໂຫຍກຫຼາຍໃຈຄວາມ', 'ປະໂຫຍກບອກເລົ່າ', 'ປະໂຫຍກໃຈຄວາມດຽວ','noun_lesson11')" +
                ",('t11_noun_ex2', 'ປະໂຫຍກບອກເລົ່າ', 'ປະໂຫຍກຫຼາຍໃຈຄວາມ', 'ປະໂຫຍກໃຈຄວາມດຽວ','noun_lesson11')" +
                ",('t11_noun_ex3', 'ປະໂຫຍກຫຼາຍໃຈຄວາມ', 'ປະໂຫຍກບອກເລົ່າ', 'ປະໂຫຍກໃຈຄວາມດຽວ','noun_lesson11')" +
                ",('t11_noun_ex4', 'ປະໂຫຍກໃຈຄວາມດຽວ', 'ປະໂຫຍກໃຈດຽວ', 'ປະໂຫຍກຄວາມດຽວ','noun_lesson11')" +
                ",('t11_noun_ex5', 'ປະໂຫຍກ 3', 'ປະໂຫຍກ 2', 'ປະໂຫຍກ 4','noun_lesson11')" +
                ",('t11_noun_ex6', 'ເພາະ', 'ເບາະ', 'ເນາະ','noun_lesson11')" +
                ",('t11_noun_ex7', 'ຂ້ອຍຫົວ', 'ຊ້າງຮ່ຽວໄມ້ໄຜ່', 'ລາວໄປເຕະບານ','noun_lesson11')" +
                ",('t11_noun_ex6', 'ພ້ອມທັງ', 'ຂ້ອຍຫົວ', 'ຍ້ອນວ່າ','noun_lesson11')" +
                ",('t11_noun_ex9', 'ຂ້ອຍ ໄປ ຕະຫຼາດ', 'ເພາະ', 'ກຳລັງກິນເຂົ້າ','noun_lesson11')" +
                ",('t11_noun_ex6', 'ຍ້ອນວ່າ', 'ຂ້ອຍ', 'ພວກຂ້ອຍ','noun_lesson11')" +

                //________________________________________________________________
                //______________________________________________________________________________________________________________
                ",('txt_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson12')" +
                ",('txt_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson12')" +
                ",('txt_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson12')" +
                ",('txt_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson12')" +
                ",('txt_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson12')" +
                ",('txt_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson12')" +
                ",('txt_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson12')" +
                ",('txt_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson12')" +
                ",('txt_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson12')" +
                ",('txt_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson12')" +
                ",('txt_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson12')" +
                ",('txt_noun_ex1', 'ex1', 'ex2', 'ex3','noun_lesson12')";
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
        if (gameID == 0 && dfID == 1) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion1.questionTable_Name + " WHERE " + tableQuestion1.codeName + "= 'noun_lesson1'", null);
        } else if (gameID == 0 && dfID == 2) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion1.questionTable_Name + " WHERE " + tableQuestion1.codeName + "= 'noun_lesson2'", null);
        } else if (gameID == 0 && dfID == 3) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion1.questionTable_Name + " WHERE " + tableQuestion1.codeName + "= 'noun_lesson3'", null);
        } else if (gameID == 0 && dfID == 4) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion1.questionTable_Name + " WHERE " + tableQuestion1.codeName + "= 'noun_lesson4'", null);
        }else if (gameID == 0 && dfID == 5) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion1.questionTable_Name + " WHERE " + tableQuestion1.codeName + "= 'noun_lesson5'", null);
        } else if (gameID == 0 && dfID ==9) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion1.questionTable_Name + " WHERE " + tableQuestion1.codeName + "= 'noun_lesson9'", null);
        } else if (gameID == 0 && dfID ==10) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion1.questionTable_Name + " WHERE " + tableQuestion1.codeName + "= 'noun_lesson10'", null);
        } else if (gameID == 0 && dfID == 11) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion1.questionTable_Name + " WHERE " + tableQuestion1.codeName + "= 'noun_lesson11'", null);
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
