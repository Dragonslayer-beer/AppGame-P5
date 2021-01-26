package aea.bt.cryptography.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import aea.bt.cryptography.Database.Question.tableQuestion;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class DatabaseHelper1 extends SQLiteOpenHelper {
    public static final String database_Name = "Database_game_mr5_1";
    public static final int database_Version = 1;
    SQLiteDatabase db;

    public DatabaseHelper1(@Nullable Context context) {
        super(context, database_Name, null, database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String create_EditTable = "CREATE TABLE " + Question.tableEditQuestion.questionEditTable_Name + " ( " + Question.tableEditQuestion._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Question.tableEditQuestion.editQuestion + " TEXT," + Question.tableEditQuestion.editRightAnswer + " TEXT," + Question.tableEditQuestion.editCodeName + " TEXT)";
        db.execSQL(create_EditTable);

        final String InserteditTextQuestion = "INSERT INTO " + Question.tableEditQuestion.questionEditTable_Name + "(" + Question.tableEditQuestion.editQuestion + "," + Question.tableEditQuestion.editRightAnswer + "," + Question.tableEditQuestion.editCodeName + ") VALUES " +
                "('wt_1_ls1','ວັນທີ1ເດືອນກັນຍາຂອວທຸກໆປິ','write_ls1')," +
                "('wt_1_ls2','ໂຮງຮຽນຊັ້ນຕ່າງໆ','write_ls1')," +
                "('wt_1_ls3','ຕົວເມືອງແລະຊົນນະບົດ','write_ls1')," +
                "('wt_1_ls4','ທົ່ວປະເທດ','write_ls1')," +
                "('wt_1_ls5','ປຽບເໝືອນບຸນມະໂຫລານ','write_ls1')," +
                "('wt_1_ls6','ນັກຮຽນນຸ່ງເຄື່ອງຢ່າງເປັນລະບຽບ','write_ls1')," +
                "('wt_1_ls7','ຍິ້ມແຍ້ມແຈ່ມໃສ','write_ls1')," +
                "('wt_1_ls8','ການຮ່ຳຮຽນຈະພາໃຫ້ນັກຮຽນເປັນຄົນດີ','write_ls1')," +
                "('wt_1_ls9','ມີລະບຽບວິໄນ','write_ls1')," +
                "('wt_1_ls10','ເຍົາວະຊົນດີມີສີແກ່ຊາດເຍົາວະຊົນສະຫຼາກພາຊາດຈະເລີນ','write_ls1')," +


                "('wt_2_ls1','ທ່ານບຸນມີໄປການ','write_ls2')," +
                "('wt_2_ls2','ເວລາດື່ມກາເຟ','write_ls2')," +
                "('wt_2_ls3','ໂອ້ລົມກັບບັນດາໝູ່ເພື່ອນ','write_ls2')," +
                "('wt_2_ls4','ເວລາເລີກການ','write_ls2')," +
                "('wt_2_ls5','ເຂົ້ານອນແຕ່ຫົວຄ່ຳ','write_ls2')," +
                "('wt_2_ls6','ຂ້ານ້ອຍຊື່ຄຳໄສ','write_ls2')," +
                "('wt_2_ls7','ຂໍໂທດຫຼາຍໆ','write_ls')," +
                "('wt_2_ls8','ເມື່ອໄປຮອດສະຖານທີ່ສອບເສັງ','write_ls')," +
                "('wt_2_ls9','ໃນຂະນະນັ້ນ','write_ls2')," +
                "('wt_2_ls10','ໂຮງຮຽນປະຖົມ','write_ls2')," +

                "('test','ຕອນເຊົ້າມື້ໜຶ່ງອາກາດແຈ້ງສະຫວ່າງດີ','write_ls3')," +
                "('test','ທ້າວບຸນມີໄດ້ອອກໄປຫາຟືນ','write_ls3')," +
                "('test','ກຳລັງເອົາໃຈໃສ່ກັບການຫາຟືນ','write_ls3')," +
                "('test','ອັນຕະລາຍຈາກສັດຮ້າຍໃນປ່າ','write_ls3')," +
                "('test','ຄວນຫາເອົາໄມ້ທີ່ຕາຍແລ້ວ','write_ls3')," +
                "('test','ການຮັກສາປ່າໃຫ້ອຸດົມສົມບຸນ','write_ls3')," +
                "('test','ການເຂົ້າປ່າຄົນດຽວ','write_ls3')," +
                "('test','ການນຳໃຊ້ໄມ້ເຮັດຟືນ','write_ls3')," +
                "('test','ພໍ່ເຖົ້າສາໄປທຳນາມາແຕ່ເຊົ້າ','write_ls3')," +
                "('test','ທັ້ງຕອນເຊົ້າແລະຕອນແລງ','write_ls3')," +

                "('wt_4_ls1','ພໍເຫັນຟ້າກໍສິ້ວຊ້ອງຊໍ່ສີນິນ','write_ls4')," +
                "('wt_4_ls2','ເມໂຄຢາຍລ່ວງພະໂຍມຍາມເຊົ້າ','write_ls4')," +
                "('wt_4_ls3','ໜ້ອຍໜຶ່ງແສງສຸນສົ້າເມໂຄມົວມືດ','write_ls4')," +
                "('wt_4_ls4','ວາໂຍພັດປິ່ນເປື້ອງຄວັນກົ້ວໃຫງ່ລະອອງ','write_ls4')," +
                "('wt_4_ls5','ຟັັງສຽງຟ້າຮ້ອງຕຶ້ງດັງສະນັ່ນເວລາ','write_ls4')," +
                "('wt_4_ls6','ເມຂະຫຼາລ່ວງຜ້າຍແກວ່ງເຕໂຊແກ້ວ','write_ls4')," +
                "('wt_4_ls7','ແສງມາຍເມືອງມອງເຫຼື້ອມຫຼາຍສີແສງອ່ອນ','write_ls4')," +
                "('wt_4_ls8','ດູຕ່າງຕາຫຼາກລ້ຳແສງກ້ຽວກ່ອມງາມ','write_ls')," +
                "('wt_4_ls9','ຄາວໜຶ່ງລົມຫອມອູ້ມປັດເປົ່າເອົາຝົນ','write_ls4')," +
                "('wt_4_ls10','ເອີ້ນສັ່ງຝຸງເຂົ້າກ້າປີໜ້າຈຶ່ງຊິມາອີກເນີ','write_ls4')," +

                "('wt_5_ls1','ນົກນາງໄສ່ເສຍໃຈນຳລູກຫຼາຍ','write_ls5')," +
                "('wt_5_ls2','ໄຫວ້ວອນນົກໂຕຜົວ','write_ls5')," +
                "('wt_5_ls3','ໄປປຶກສານຳກາ','write_ls5')," +
                "('wt_5_ls4','ອະລິດຖະທີ່ເປັນສ່ຽວຮັກ','write_ls5')," +
                "('wt_5_ls5','ເຫດການທີ່ຊ້າງກະທຳຕໍ່ລຸກ','write_ls5')," +
                "('wt_5_ls6','ຄວາມເຈັບປວດນີ້ເປັນຂອງທຳມະດາ','write_ls5')," +
                "('wt_5_ls7','ບໍ່ມິໃຜຫຼີກເວັ້ນໄດ້','write_ls5')," +
                "('wt_5_ls8','ສ່ຽວຢ່າເສຍໃຈອີກເລີຍ','write_ls5')," +
                "('wt_5_ls9','ນົກໄສ່ໄປຫາພະຍາກົບ','write_ls5')," +
                "('wt_5_ls10','ຢູ່ຮ່ວມກັນດ້ວຍຄວາມສາມັກຄີ','write_ls5')," +

                "('wt_6_ls1','ປະເທດລາວມີປ່າດົງກວ້າງໃຫຍ່','write_ls6')," +
                "('wt_6_ls2','ປ່າເປັນເຮືອນຮັງຂອງສັດປ່ານາງໆຊະນິດ','write_ls6')," +
                "('wt_6_ls3','ຕາມແຄມທົ່ງນາກໍມີໄຜ່ບ້ານ','write_ls6')," +
                "('wt_6_ls4','ຕາມຕົ້ນຂາມແລະຕົ້ນພ້າວກໍຍັງມີນົກຫຼາຍຊະນິດ','write_ls6')," +
                "('wt_6_ls5','ສັດປ່າຖືກດັບສຸນຍ້ອນນາຍພານ','write_ls6')," +
                "('wt_6_ls6','ລັດຖະບ້ານໄດ້ອອກດຳລັດກ່ຽວກັບການຫ້າມລ່າເນື້ອ','write_ls6')," +
                "('wt_6_ls7','ສັດປ່າມີຄຸນປະໂຫຍດຫຼາຍຕໍ່ຊີວິດຂອງຄົນເຮົາ','write_ls6')," +
                "('wt_6_ls8','ສັດປ່າຈຳພວກໜຶ່ງເປັນສັດຮ້າຍ','write_ls6')," +
                "('wt_6_ls9','ພວກເຮົາຄວນອານຸລັກສັດປ່າ','write_ls6')," +
                "('wt_6_ls10','ຮັກສາພັນຂອງມັນໄວ້ເປັນມູູນມັງຂອງລູກຫຼານສືບຕໍ່ໄປ','write_ls6')," +


                "('wt_7_ls1','ສິ່ງທີ່ມີຊີວິດຫຼາຍຢ່າງ','write_ls7')," +
                "('wt_7_ls2t','ສັດມີຫຼາຍຊະນິດ','write_ls7')," +
                "('wt_7_ls3','ລ້ຽງໄວ້ເພື່ອໃຊ້ແຮງງານ','write_ls7')," +
                "('wt_7_ls4','ລ້ຽງໄວ້ເປັນອາຫານ','write_ls7')," +
                "('wt_7_ls5','ນຳມາປະດິດເປັນເຄື່ອງໃຊ້','write_ls7')," +
                "('wt_7_ls6','ສາມາດດັດແປງດິນໃຫ້ດີຂຶ້ນ','write_ls7')," +
                "('wt_7_ls7','ໝູທີ່ເປັນພະຍາດລໍຊໍ','write_ls7')," +
                "('wt_7_ls8','ງົວຄວາຍທີ່ເປັນສານ','write_ls7')," +
                "('wt_7_ls9','ປວດເມື່ອຍຕາມຕົນຕົວ','write_ls7')," +
                "('wt_7_ls10','ອາດເປັນອັນຕະລາຍເຖິງຊີວິດໄດ້','write_ls7')," +


                "('wt_8_ls1','ຢູ່ໂຮງຮຽນນາຍຄຸຸເພິ່ນໄດ້ສອນເລື່ອງປູກຜັກ','write_ls8')," +
                "('wt_8_ls2','ພຸນດິນໃສ່ຝຸ່ນແລະຫົດນ້ຳ','write_ls8')," +
                "('wt_8_ls3','ຮູ້ສຶກດີໃຈທີ່ເຫັນລຸກຢາກເຮັດໃນສິ່ງທີ່ມີປະໂຫຍດ','write_ls8')," +
                "('wt_8_ls4','ຄວາມຄິດນີ້ໄດ້ມາຈາກການຮຳ່ຮຽນ','write_ls8')," +
                "('wt_8_ls5','ດຽວນີ້ຜັກຢຸ່ຕະຫຼາດລາຄາແພງ','write_ls8')," +
                "('wt_8_ls6','ປະຢັດຄ່າໃຊ້ຈ່າຍ','write_ls8')," +
                "('wt_8_ls7','ມີຄວາມພາກພຸມໃຈ','write_ls8')," +
                "('wt_8_ls8','ຊ່ວຍເຫຼືອເຊິ່ງກັນແລະກັນ','write_ls8')," +
                "('wt_8_ls9','ອອກແຮງງານຮ່ວມກັນໃນຍາມວ່າງ','write_ls8')," +
                "('wt_8_ls10','ເມື່ອຮອດມື້ພັກຮຽນຂອງອາທິດນັ້ນ','write_ls8')," +


                "('wt_9_ls1','ປີກາຍນີ້','write_ls9')," +
                "('wt_9_ls2','ງານສະເຫຼີມສະຫຼອງ','write_ls9')," +
                "('wt_9_ls3','ຢ່າງເບີກບານມ່ວນຊື່ນ','write_ls9')," +
                "('wt_9_ls4','ໃນເວລາ8ໂມງ','write_ls9')," +
                "('wt_9_ls5','ເຕົ້າໂຮມກັນຢູ່ສະໂມສອນ','write_ls9')," +
                "('wt_9_ls6','ມີການປະດັບປະດາຢ່າງຈົບງາມ','write_ls9')," +
                "('wt_9_ls7','ມີຫຼາຍພາກສ່ວນ','write_ls9')," +
                "('wt_9_ls8','ແຈ້ງຈຸດປະສົງຂອງງານ','write_ls9')," +
                "('wt_9_ls9','ຕາງໜ້ານັກຮຽນທັ້ງໝົດ','write_ls9')," +
                "('wt_9_ls10','ສະແດງຄວາມຮຸ້ບຸນຄຸນ','write_ls9')," +



                "('wt_11_ls1','ແຕ່ປາງກ່ອນ','write_ls11')," +
                "('wt_11_ls2','ຖານະພໍຢຸ່ພໍກິນ','write_ls11')," +
                "('wt_11_ls3','ເມຍເປັນຄົນຂະຫຍັນ','write_ls11')," +
                "('wt_11_ls4','ວຽກບ້ານການເຮືອນ','write_ls11')," +
                "('wt_11_ls5','ປະຢັດມັດທະຍັດ','write_ls11')," +
                "('wt_11_ls6','ໄປທ່ຽວຫາເຄື່ອງເຮັດນ້ຳຢາ','write_ls11')," +
                "('wt_11_ls7','ພໍ່ມີຕຳລາມາກ່ອນເຈົ້າ','write_ls11')," +
                "('wt_11_ls8','ດີອົກດີໃຈເປັນຢ່າງຍິ່ງ','write_ls11')," +
                "('wt_11_ls9','ເຮັດສວນກ້ວຍດ້ວຍຄວາມບຸກບືນ','write_ls11')," +
                "('wt_11_ls10','ພໍ່ເຖົ້າໄດ້ອົບຮົມສັ່ງສອນລູກເຂີຍ','write_ls11')";


        db.execSQL(InserteditTextQuestion);


    }

    public void openCreateDatabase() {
        db = getReadableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Question.tableEditQuestion.questionEditTable_Name);

    }

    public ArrayList<ArrayList<String>> getAllEditQuiz(int gameID, int dfID) {
        ArrayList<ArrayList<String>> quizData = new ArrayList<>();
        db = getReadableDatabase();
        Cursor cursor = null;
        if (gameID == 0 && dfID == 1) {
            cursor = db.rawQuery("SELECT * FROM " + Question.tableEditQuestion.questionEditTable_Name + " WHERE " + Question.tableEditQuestion.editCodeName + "= 'write_ls1'", null);
        } else if (gameID == 0 && dfID == 2) {
            cursor = db.rawQuery("SELECT * FROM " + Question.tableEditQuestion.questionEditTable_Name + " WHERE " + Question.tableEditQuestion.editCodeName + "= 'write_ls2'", null);
        } else if (gameID == 0 && dfID == 4) {
            cursor = db.rawQuery("SELECT * FROM " + Question.tableEditQuestion.questionEditTable_Name + " WHERE " + Question.tableEditQuestion.editCodeName + "= 'write_ls4'", null);
        } else if (gameID == 0 && dfID == 5) {
            cursor = db.rawQuery("SELECT * FROM " + Question.tableEditQuestion.questionEditTable_Name + " WHERE " + Question.tableEditQuestion.editCodeName + "= 'write_ls5'", null);
        } else if (gameID == 0 && dfID == 6) {
            cursor = db.rawQuery("SELECT * FROM " + Question.tableEditQuestion.questionEditTable_Name + " WHERE " + Question.tableEditQuestion.editCodeName + "= 'write_ls6'", null);
        } else if (gameID == 0 && dfID == 7) {
            cursor = db.rawQuery("SELECT * FROM " + Question.tableEditQuestion.questionEditTable_Name + " WHERE " + Question.tableEditQuestion.editCodeName + "= 'write_ls7'", null);
        } else if (gameID == 0 && dfID == 8) {
            cursor = db.rawQuery("SELECT * FROM " + Question.tableEditQuestion.questionEditTable_Name + " WHERE " + Question.tableEditQuestion.editCodeName + "= 'write_ls8'", null);
        } else if (gameID == 0 && dfID == 9) {
            cursor = db.rawQuery("SELECT * FROM " + Question.tableEditQuestion.questionEditTable_Name + " WHERE " + Question.tableEditQuestion.editCodeName + "= 'write_ls9'", null);
        }  else if (gameID == 0 && dfID == 11) {
            cursor = db.rawQuery("SELECT * FROM " + Question.tableEditQuestion.questionEditTable_Name + " WHERE " + Question.tableEditQuestion.editCodeName + "= 'write_ls11'", null);
        }

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ArrayList<String> tmpQuiz = new ArrayList<>();
            tmpQuiz.add(cursor.getString(1));
            tmpQuiz.add(cursor.getString(2));
            tmpQuiz.add(cursor.getString(3));
            quizData.add(tmpQuiz);
            cursor.moveToNext();
        }
        db.close();
        return quizData;
    }

}
