package aea.bt.cryptography.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import aea.bt.cryptography.Database.Question.tableQuestion;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String database_Name = "Database_game_mr5";
    public static final int database_Version = 1;
    SQLiteDatabase db;

    public DatabaseHelper(@Nullable Context context) {
        super(context, database_Name, null, database_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String create_table = "CREATE TABLE " + tableQuestion.questionTable_Name + "(" + tableQuestion._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + tableQuestion.question + " TEXT," + tableQuestion.rightAnswer + " TEXT," + tableQuestion.option1 + " TEXT," + tableQuestion.option2 + " TEXT,"
                + tableQuestion.codeName + " TEXT)";



        db.execSQL(create_table);

        final String insertData = "INSERT INTO " + tableQuestion.questionTable_Name + "(" + tableQuestion.question + "," + tableQuestion.rightAnswer + "," +
                tableQuestion.option1 + "," + tableQuestion.option2 + "," + Question.tableQuestion.codeName + ") VALUES" +
                "('read_qs1', '01 ກັນຍາ', '10 ກັນຍາ', '01 ຕຸລາ','read_lesson1')" +
                ",('read_qs2', 'ກາຍເປັນຄົນດີ ແລະ ມີຄວາມຮູ້ຄວາມສາມາດ', 'ກາຍເປັນຄົນທີ່ມີໝູ່ເພື່ອນຫຼາຍ', 'ກາຍເປັນຄົນຂີ້ຄ້ານ','read_lesson1')" +
                ",('read_qs3', 'ຊັບພະຍາກອນມະນຸດ', 'ຄູອາຈານ', 'ເດັກນ້ອຍ','read_lesson1')" +
                ",('read_qs4', '4', '5', '2','read_lesson1')" +
                ",('read_qs5', 'ປຽບມື້ບຸນມະໂຫລານ', 'ປຽບເໝືອນມື້ທຳມະດາ', 'ປຽບເໝືອນມື້ທີ່ໄດ້ພົບກັນ','read_lesson1')" +
                ",('read_qs6', 'ເຍົາວະຊົນ', 'ຊາວໜຸ່ມ', 'ອານຸຊົນ','read_lesson1')" +
                ",('read_qs7', 'ບຸນທີ່ຍິ່ງໃຫຍ່', 'ບຸນຊ່ວງເຮືອນ', 'ບຸນພະທາດຫຼວງ','read_lesson1')" +
                ",('read_qs8', 'ຜູ້ທີ່ເຮັດວຽກກ່ຽວກັບການວິທະຍາສາດ', 'ຜູ້ທີ່ເຮັດວຽກກ່ຽວກັບກິລາ', 'ຜູ້ທີ່ເຮັດວຽກກ່ຽວກັບການປຸກຝັງ-ລ້ຽງສັດ','read_lesson1')" +
                ",('read_qs9', 'ຜູ້ທີ່ເຮັດວຽກວິຊາການຂອງຂະແໜງການໃດໜຶ່ງ', 'ຜູ້ທີ່ເຮັດວຽກກ່ຽວກັບການເມືອງ', 'ຜູ້ທີ່ເຮັດວຽກກ່ຽວກັບການຕະຫຼາດ','read_lesson1')" +
                ",('read_qs10', 'ແມ່ນບົດຫັດແຕ່ງ', 'ແມ່ນບົດຫັດອ່ານ', 'ແມ່ນບົດສຳພາດ','read_lesson1')" +

                //______________________________________________________________________________________________________________
                ",('read_ls2_ex1', 'ມື້ໄປເສັງນັກຮຽນເກັງຂັ້ນເມືອງ', 'ມື້ເປີດສົກຮຽນໃໝ່', 'ມື້ສອບເສັງຈົບຊັ້ນ ປ5','read_lesson2')" +
                ",('read_ls2_ex2', 'ເຂົ້າໄປສະບາຍດີ', 'ບໍ່ສົນໃຈ', 'ແລ່ນໜີຄຸ','read_lesson2')" +
                ",('read_ls2_ex3', 'ຄູອາຈານ', 'ນາຍບ້ານ', 'ຜູ້ປົກຄອງ','read_lesson2')" +
                ",('read_ls2_ex4', 'ຄາວຮຽນຢູ່ ປ1', 'ຄາວຮຽນຢູ່ ປ4', 'ຄາວຮຽນຢູ່ອານຸບານ','read_lesson2')" +
                ",('read_ls2_ex5', 'ນາຍຄຸພອນສະຫວັນ', 'ນາຍຄຸພອນມະນີ', 'ນາຍຄຸຄຳ','read_lesson2')" +
                ",('read_ls2_ex6', 'ບໍ່ຈື່ເລີຍ', 'ຈື່ໄດ້ດີເລີຍ', 'ບໍ່ຈື່ປານໃດ','read_lesson2')" +
                ",('read_ls2_ex7', 'ຄວາມຮູ້ບຸນຄຸນ', 'ຄວາມດຸໝັ່ນ', 'ຄວາມສູພາບຮຽບຮ້ອຍ','read_lesson2')" +
                ",('read_ls2_ex8', 'ທ່າທີ່, ການປະພຶດ', 'ການແຕ່ງກາຍ', 'ການຮຽນ','read_lesson2')" +
                ",('read_ls2_ex9', 'ເວລານັ້ນ, ຕອນນັ້ນ.', 'ມື້ວານນີ້', 'ມື້ອື່ນ.','read_lesson2')" +
                ",('read_ls2_ex10', '3', '4', '2','read_lesson2')" +

                //______________________________________________________________________________________________________________
                ",('read_ls3_ex1', 'ຕົກໃຈ', 'ດີໃຈ', 'ຢ້ານ','read_lesson3')" +
                ",('read_ls3_ex2', 'ເຂົ້າໃຈເຖິງອັນຕະລາຍໃນການເຂົ້າປ່າ', 'ບໍ່ເຂົ້າໃຈຫຍັງເລີຍ', 'ບໍ່ໄດ້ສົນໃຈເລີຍ','read_lesson3')" +
                ",('read_ls3_ex3', 'ໄປຫາຟຶນ', 'ໄປຕຶກປາ', 'ໄປນາ','read_lesson3')" +
                ",('read_ls3_ex4', 'ຢູ່ແຄມທົ່ງນາ', 'ຢຸ່ໃນປ່າ', 'ຢູ່ແຄມນ້ຳ','read_lesson3')" +
                ",('read_ls3_ex5', 'ງວາກໄປທັນທີ', 'ບໍ່ສົນໃຈ', 'ແລ່ນໜີ','read_lesson3')" +
                ",('read_ls3_ex6', '2 ຄົນ', 'ຄົນດຽວ', '3 ຄົນ','read_lesson3')" +
                ",('read_ls3_ex7', 'ບໍ່ແນ່ໃຈ', 'ໝັ້ນໃຈ', 'ໄວ້ໃຈ','read_lesson3')" +
                ",('read_ls3_ex8', 'ບອກໃຫ້ຮູ້', 'ມິດງຽບ', 'ສົນທະນາກັນ','read_lesson3')" +
                ",('read_ls3_ex9', 'ຄົນດຽວ', 'ກັບໝູ່', 'ກັບພໍ່ຂອງລາວ','read_lesson3')" +
                ",('read_ls3_ex10', 'ຄວນເອົາໄມ້ທີ່ຕາຍແລ້ວ', 'ຄວນຕັດເອົາໄມ້ທີ່ຍັງບໍ່ທັນຕາຍ', 'ບໍ່ຄວນເອົາໄມ້ໃນປ່າໄປເຮັດຟຶນ','read_lesson3')" +


                //////////////////////
                ",('read_ls5_ex1', 'ປ່າເວລຸວັນ', 'ປ່າດົງດິບ', 'ປ່າເວລາວັນ','read_lesson5')" +
                ",('read_ls5_ex2', 'ໂມໂຫ ແລະ ເວົ້າອວດອົ່ງ', 'ຍິ້ມແຍ້ມແຈ່ມໃສ', 'ເວົ້າຈາມ່ວນຫູ','read_lesson5')" +
                ",('read_ls5_ex3', 'ເຮົາຄວນຢູ່ດ້ວຍກັນດ້ວຍຄວາມສາມັກຄີ', 'ເຮົາຄວນຍ້າຍຖິ່ນຖານໄປຢູ່ບ່ອນອື່ນ', 'ຍອມໃຫ້ຊ້າງຂົ່ມຂູແບບນັ້ນຕໍ່ໄປ','read_lesson5')" +
                ",('read_ls5_ex4', 'ໃຫ້ຍອມຮັບຄວາມເປັນຈິງ', 'ຕ້ອງເອົາຄືນຊ້າງສານໃຫ້ໄດ້', 'ບໍ່ມີຄຳເຫັນໃດໆຈາກກາ','read_lesson5')" +
                ",('read_ls5_ex5', 'ປ່າໄມ້ໄຜ່', 'ປ່າດົງດິບ', 'ປ່າວິເສດີ','read_lesson5')" +
                ",('read_ls5_ex6', 'ຊ້າງໃຫຍ່', 'ຊ້າງເຜືອກ', 'ຊ້າງນ້ອຍ','read_lesson5')" +
                ",('read_ls5_ex7', 'ສົ່ງໜີ ໄລ່ໜີ', 'ມາຫາ', 'ຮັກສາໄວ້','read_lesson5')" +
                ",('read_ls5_ex8', 'ໃຈຮ້າຍ', 'ໃຈດີ', 'ອາລົມດີ','read_lesson5')" +
                ",('read_ls5_ex9', 'ຄວາມອວດອົ່ງຂອງຊ້າງສານ', 'ຄວາມສະຫຼາດຂອງຊ້າງສານ', 'ຄວາມອ່ອນແອຂອງນົກໄສ່','read_lesson5')" +
                ",('read_ls5_ex10', 'ອິດຖະລິດ', 'ທຸກະລາດ', 'ເວລຸວັນ','read_lesson5')" +
                ////////////////////////////////////////

                ",('read_ls6_ex1', 'ສັດປ່ານາໆຊະນິດໃນປະເທດເຮົາ.', 'ປ່າໄມ້ໃນປະເທດເຮົາ', 'ທຳມະຊາດໃນປະເທດເຮົາ','read_lesson6')" +
                ",('read_ls6_ex2', 'ສາມາດເປັນອາຫານ ແລະ ຢາໄດ້', 'ເປັນອັນຕະລາຍຕໍ່ຄົນເຮົາ', 'ບໍ່ມີຄຸນປະໂຫຍດຫຍັງູ','read_lesson6')" +
                ",('read_ls6_ex3', 'ບໍ່ລ້າ ແລະ ຮັກສາພັນີ', 'ເອົາມາລ້ຽງຢູ່ສວນສັດ', 'ເອົາມາລ້ຽງຢຸ່ເຮືອນ','read_lesson6')" +
                ",('read_ls6_ex4', 'ສະຖານທີ່ຂອງສັດ', 'ເສດແກ້ວ້', 'ປ່າຕຶບໜາ','read_lesson6')" +
                ",('read_ls6_ex5', 'ບ່ອນສັດລົງຫາກິນ່', 'ທີ່ຢູ່ອາໄສຂອງສັດ', 'ເຂດຫວງຫ້າມ','read_lesson6')" +
                ",('read_ls6_ex6', 'ຄຳສັ່ງ', 'ຄຳຊີ້ແຈງ', 'ການປຸກເຂົ້າ','read_lesson6')" +
                ",('read_ls6_ex7', 'ຮູບຮ່າງ, ນິດໃສ…', 'ປະເພດຂອງສັດ', 'ການເຄື່ອນໄຫວ້','read_lesson6')" +
                ",('read_ls6_ex8', 'ຮູບຮ່າງຂອງສັດ', 'ນິດໄສຂອງສັດ', 'ອາຈີນຂອງສັດ','read_lesson6')" +
                ",('read_ls6_ex1', 'ສັດປ່ານາໆຊະນິດໃນປະເທດເຮົາ.', 'ປ່າໄມ້ໃນປະເທດເຮົາ', 'ທຳມະຊາດໃນປະເທດເຮົາ','read_lesson6')" +
                ",('read_ls6_ex4', 'ສະຖານທີ່ຂອງສັດ', 'ເສດແກ້ວ', 'ປ່າຕຶບໜາ','read_lesson6')" +
                /////////////////////////////////////////////////////////////////////////////


                ",('read_ls7_ex1', 'ເກີບ, ສາຍແອວ, ກະເປົາ.', 'ເສື້ອ, ເກີບ, ໂສ້ງ.', 'ກວຽນ, ລໍ້.','read_lesson7')" +
                ",('read_ls7_ex2', 'ເບິ່ງດູແລ້', 'ຂັງໄວ້ໃນຄອກ', 'ປ່ອຍປະລະເລີຍູ','read_lesson7')" +
                ",('read_ls7_ex3', 'ສະບູີ', 'ຢາສະຜົມ', 'ນ້ຳມັນພືດ','read_lesson7')" +
                ",('read_ls7_ex4', 'ຝຸ່ນຊີວະພາບ', 'ບໍ່ມີປະໂຫຍດຫຍັງ', 'ກວຽນ','read_lesson7')" +
                ",('read_ls7_ex5', 'ຫຍຸ່ງຍາກ່', 'ຮຸ່ງເຮືອງ', 'ສະດວກສະບາຍ','read_lesson7')" +
                ",('read_ls7_ex6', 'ຊື່ຂອງພະຍາດຊະນິດໜຶ່ງທີ່ມີໃນຊີ້ນໝູ', 'ວັດຖູຊະນິດໜຶ່ງທີ່ຫົດຢືດໄດ້', 'ພະຍາດເຫຼັກ','read_lesson7')" +
                ",('read_ls7_ex7', 'ຄວາມເປັນໄປ', 'ວັດຖູຊະນິດໜຶ່ງທີ່ຫົດຢືດໄດ້', 'ພະຍາດເຫຼັກ້','read_lesson7')" +
                ",('read_ls7_ex8', 'ສູກແດ່ດິບແດ່', 'ດິບ', 'ສຸກ','read_lesson7')" +
                ",('read_ls7_ex9', 'ຂີ້ສັດ', 'ຍ່ຽວສັດ', 'ຂົນສັດ','read_lesson7')" +
                ",('read_ls7_ex10', 'ພະຍາດທີ່ເປັນກ້ອນໃນຊີ້ນສັດ', 'ການຊອດ', 'ການທັກ','read_lesson7')" +

                /////////////////////////////////////////////
                ",('read_ls8_ex1', 'ຍ້ອນນາຍຄຸໄດ້ສອນປຸກຜັກ', 'ແມ່ຂອງລາວບອກໃຫ້ປຸກ', 'ນ້ອງຂອງລາວຊວນປຸກ','read_lesson8')" +
                ",('read_ls8_ex2', 'ຊ່ວຍກັນບົວລະບັດຮັກສາ້', 'ແບ່ງກັນເຮັດ', 'ປ່ອຍປະລະເລີຍ','read_lesson8')" +
                ",('read_ls8_ex3', 'ປະຢັດ ແລະ ໄດ້ກິນຜັກສົດ', 'ບໍ່ມີສານຜິດໃນຜັກ', 'ມີຜັກຫຼາຍ','read_lesson8')" +
                ",('read_ls8_ex4', 'ທາດເບື່ອທີ່ເປັນອັນຕະລາຍ', 'ທາດທີ່ມີປະໂຫຍດຕໍ່ສຸກຂະພາບ', 'ທາດທີ່ຢູ່ໃນຜັກ','read_lesson8')" +
                ",('read_ls8_ex5', 'ສ່ວນຜັກໃນຄົວເຮືອນ່', 'ສ່ວນທີ່່ເອົາໄວ້ປຸກເຂົ້າ', 'ບ່ອນທີ່ເອົາໄວ້ຄົວກິນ','read_lesson8')" +
                ",('read_ls8_ex6', 'ຕົ້ນຜັກທີ່ເກີດໃໝ່', 'ຕົ້ນຜັກທີ່ຕາຍແລ້ວ', 'ຕົ້ນຜັກທີ່ຖືກເດັກໄປກິນ','read_lesson8')" +
                ",('read_ls8_ex8', 'ຈຳນວນເງິນທີ່ອອກໄປ', 'ຈຳນວນເງິນທີ່ຫາໄດ້້', 'ລາຍໄດ້','read_lesson8')" +
                ",('read_ls8_ex5', 'ສ່ວນຜັກໃນຄົວເຮືອນ່', 'ສ່ວນທີ່່ເອົາໄວ້ປຸກເຂົ້າ', 'ບ່ອນທີ່ເອົາໄວ້ຄົວກິນ','read_lesson8')" +
                ",('read_ls8_ex2', 'ຊ່ວຍກັນບົວລະບັດຮັກສາ', 'ແບ່ງກັນເຮັດ', 'ປ່ອຍປະລະເລີຍ','read_lesson8')" +
                ",('read_ls8_ex1', 'ຍ້ອນນາຍຄຸໄດ້ສອນປຸກຜັກ', 'ແມ່ຂອງລາວບອກໃຫ້ປຸກ', 'ນ້ອງຂອງລາວຊວນປຸກ','read_lesson8')" +

                ////////////////////////////////////////////////////
                /////////////////////////////////////////////
                ",('read_ls9_ex1', 'ການຈັດພິທີສະເຫຼີມສະຫຼອງວັນຄູແຫ່ງຊາດ', 'ປະຫວັດຂອງວັນຄູແຫ່ງຊາດ', 'ບັນຍາກາດໃນມື້ວັນຄູແຫ່ງຊາດ','read_lesson9')" +
                ",('read_ls9_ex2', '7 ຕຸລາ', '7 ທັນວາ', '10 ຕຸລາ','read_lesson9')" +
                ",('read_ls9_ex3', 'ເພື່ອຍ້ອງຍໍຜົນງານຄຸນງາມຄວາມດີຂອງຄູ', 'ຈັດຂຶ້ນຕາມປະເພນີ', 'ເພື່ອມອບຂອງຂວັນໃຫ້ຄູ','read_lesson9')" +
                ",('read_ls9_ex4', '8 ໂມງ 30', '7 ໂມງ 30', '6 ໂມງ 30','read_lesson9')" +
                ",('read_ls9_ex5', 'ຫົວໜ້າໂຮງຮຽນ່', 'ນາຍບ້ານ', 'ແຂກ','read_lesson9')" +
                ",('read_ls9_ex6', 'ຊໍ່ດອກໄມ້ ແລະ ຂອງຂວັນ', 'ບໍ່ໄດ້ມອບຫຍັງໃຫ້', 'ດອກໄມ້','read_lesson9')" +
                ",('read_ls9_ex7', 'ອົງການຈັດຕັ້ງໃດໜຶ່ງ', 'ຄູ່ຮັກໃດໜຶ່ງ', 'ຄອບຄົວໃດໜຶ່ງ້','read_lesson9')" +
                ",('read_ls9_ex8', 'ຊ່ວຍເຫຼືອ່', 'ຍ້ອງຍໍ', 'ສັນລະເສີນ','read_lesson9')" +
                ",('read_ls9_ex2', '7 ຕຸລາ', '7 ທັນວາ', '10 ຕຸລາ','read_lesson9')" +
                ",('read_ls9_ex1', 'ການຈັດພິທີສະເຫຼີມສະຫຼອງວັນຄູແຫ່ງຊາດ', 'ປະຫວັດຂອງວັນຄູແຫ່ງຊາດ', 'ບັນຍາກາດໃນມື້ວັນຄູແຫ່ງຊາດ','read_lesson9')" +

                ////////////////////////////////////////////////////
                /////////////////////////////////////////////
                ",('read_ls10_ex1', 'ເວົ້າເຖິງການຊ່ວຍເຫຼືອເຊິ່ງກັນ ແລະ ກັນ', 'ເວົ້າເຖິງການອິດສາກັນ', 'ເວົ້າເຖິງການເຄົາລົບເຊິ່ງກັນ ແລະ ກັນ','read_lesson10')" +
                ",('read_ls10_ex2', 'ເອົາແຕ່ໃຈໂຕເອງ', 'ຂີ້ຖີ່', 'ນິດໄສດີ','read_lesson10')" +
                ",('read_ls10_ex3', 'ກາຍເປັນນັກຮຽນດີ', 'ຍັງນິດໄສຄຶເກົ່າີ', 'ນິດໄສບໍ່ດີກວ່າເກົ່າ','read_lesson10')" +
                ",('read_ls10_ex4', 'ສຸມໃສ່', 'ຮັກສາໄວ້', 'ສຽງທຸ່ມ','read_lesson10')" +
                ",('read_ls10_ex5', 'ການກະທຳ່', 'ການປູກພືດ', 'ການຮຽນຮູ້','read_lesson10')" +
                ",('read_ls10_ex6', 'ລຸກຊາຍດຽວ', 'ລຸກສາວດຽວ', 'ລຸກຜຸ້ຊາຍ','read_lesson10')" +
                ",('read_ls10_ex7', 'ລຸງບຸນຊູ ແລະ ປ້າພອນເພັດ', 'ລຸງບຸນຊຸ ແລະ ປ້າສາຄອນ', 'ລຸງສາຄອນ ແລະ ປ້າບຸນຊູ','read_lesson10')" +
                ",('read_ls10_ex8', 'ປ5', 'ປ2', 'ປ3','read_lesson10')" +
                ",('read_ls10_ex9', 'ພໍ່ແມ່', 'ຄູອາຈານາ', 'ໝຸ່','read_lesson10')" +
                ",('read_ls10_ex1', 'ເວົ້າເຖິງການຊ່ວຍເຫຼືອກິແກ້ວຂອງສາຄອນ', 'ເວົ້າເຖິງການອິດສາກັນ', 'ເວົ້າເຖິງການເຄົາລົບເຊິ່ງກັນ ແລະ ກັນ','read_lesson10')" +

                ////////////////////////////////////////////////////
                /////////////////////////////////////////////
                ",('read_ls11_ex1', 'ຄຳສັ່ງສອນຂອງພໍ່ເຖົ້າທີ່ມີຕໍ່ລູກເຂີຍ', 'ການເຮັດສວນກ້ວຍຈົນລ່ຳລວຍ', 'ການເອົາໝາກກ້ວຍໄປຂາຍຈົນລ່ຳລວຍ','read_lesson11')" +
                ",('read_ls11_ex2', '3', '4', '2','read_lesson11')" +
                ",('read_ls11_ex3', 'ດຸໝັ່ນ', 'ຂີ້ຖ່ອຍ', 'ຂີ້ຄ້ານ','read_lesson11')" +
                ",('read_ls11_ex4', 'ຕົວະວ່າມີຢາດີ', 'ບອກໃຫ້ໄປປຸກກ້ວຍ', 'ຕົວະວ່າພໍ່ມີວິຊາ','read_lesson11')" +
                ",('read_ls11_ex5', 'ທ່ຽວເຮັດແນວເປັນໄປບໍ່ໄດ້', 'ທ່ຽວຫຼີ້ນສາວ', 'ທ່ຽວຫຼິ່ນກິນຟຸ່ມເຟີຍ','read_lesson11')" +
                ",('read_ls11_ex6', 'ຄົນຮັ່ງມີ', 'ພໍ່ຄ້າ', 'ຄົນທຸກ','read_lesson11')" +
                ",('read_ls11_ex7', 'ເກັບອອມໄວ້', 'ໃຊ້ເງິນຫຼາຍ', 'ໃຊ້ໜີ້້','read_lesson11')" +
                ",('read_ls11_ex8', 'ຄຳແທ້', 'ຄຳປະສົມ', 'ຄຳປອມ','read_lesson11')" +
                ",('read_ls11_ex9', 'ຝຸ່ນ', 'ນ້ຳ', 'ຝົນ','read_lesson11')" +
                ",('read_ls11_ex10', 'ລະອຽດ', 'ຮຸ້ໝົດທຸກຢ່າງ', 'ອ້ອມຮອບ','read_lesson11')" +

                ////////////////////////////////////////////////////
                /////////////////////////////////////////////
                ",('read_ls12_ex1', 'ນ້ຳໃຈສາມັກຄີຕໍ່ສູ້ຂອງປະຊາຊົນລາວ', 'ການປະທ້ວງຂອງປະຊາຊົນລາວ', 'ສະໄໝສົງຄາມ','read_lesson12')" +
                ",('read_ls12_ex2', 'ອຳນາດການປົກຄອງໃນສະໄໝກ່ອນ', 'ການຂຸດດິນ', 'ການເຮັດນາສັກ','read_lesson12')" +
                ",('read_ls12_ex3', 'ວັນປະກາດເອກະລາດ', 'ວັກຊາດ', 'ວັນສະຖາປະນາ','read_lesson12')" +
                ",('read_ls12_ex4', 'ພວກຮັບໃຊ້', 'ປະຊາຊົນ', 'ຫົວໜ້າ','read_lesson12')" +
                ",('read_ls12_ex5', 'ໂລກມະນຸດ', 'ຝຸງກາ', 'ຝຸງນົກ','read_lesson12')" +
                ",('read_ls12_ex6', 'ຍາມ, ເວລາ', 'ຊອກລີກ', 'ຊ່ອງວ່າງ','read_lesson12')" +
                ",('read_ls12_ex7', 'ຮຸກຮານ', 'ຕໍ່ສູ້ໍ', 'ສົງຄາມ','read_lesson12')" +
                ",('read_ls12_ex8', 'ອິດສະຫຼະພາບ', 'ກົດບັງຄັບ', 'ລະບຽບ','read_lesson12')" +
                ",('read_ls12_ex9', 'ຖືກໝົດ', 'ຂຽນ', 'ບັນທຶກ','read_lesson12')" +
                ",('read_ls12_ex10', 'ຖືກໝົດ', 'ແຜ່ອຳນາດ', 'ລັດທິຂະຫຍາຍອານາເຂດ','read_lesson12')" +

                ////////////////////////////////////////////////////


                //______________________________________________________________________________________________________________
                ",('read_ls4_ex1', 'ສີຂຽວ', 'ສີຟ້າ', 'ສີແດງ','read_lesson4')" +
                ",('read_ls4_ex2', 'ສັດ', 'ພືດ', 'ວັດຖຸ','read_lesson4')" +
                ",('read_ls4_ex3', 'ເມກ, ເຝື້ອ', 'ຂີ້ຝຸ່ນ', 'ຂີ້ເຖົ່າ','read_lesson4')" +
                ",('read_ls4_ex4', 'ຝຸ່ນ, ເມັດນ້ອຍໆ', 'ຂີ່ເທົ່າ', 'ຝົນ, ເມັດນຳ້','read_lesson4')" +
                ",('read_ls4_ex5', 'ທ້ອງຟ້າ, ອາກາດ', 'ບັນຍາກາດ', 'ສະພາບແວດລ້ອມ','read_lesson4')" +
                ",('read_ls4_ex6', 'ລົມ', 'ດິນ', 'ອາກາດ','read_lesson4')" +
                ",('read_ls4_ex7', 'ທ້ອງຟ້າ', 'ພື້ນດິນ', 'ເດິ່ນຫຍ້າ','read_lesson4')" +
                ",('read_ls4_ex8', 'ຟ້າເມບ', 'ລົມພັດ', 'ໄຟໄໝ້','read_lesson4')" +
                ",('read_ls4_ex9', 'ສາຍນ້ຳ', 'ສາຍລົມ', 'ສາຍຝົນ','read_lesson4')"+
                ",('read_ls4_ex10', 'ໂລກເມືອງຄົນ', 'ສັດສາວາສິ່ງ', 'ທຳມະຊາດ','read_lesson4')" ;
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
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion.questionTable_Name + " WHERE " + tableQuestion.codeName + "= 'read_lesson1'", null);
        } else if (gameID == 0 && dfID == 1) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion.questionTable_Name + " WHERE " + tableQuestion.codeName + "= 'read_lesson2'", null);
        } else if (gameID == 1 && dfID == 0) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion.questionTable_Name + " WHERE " + tableQuestion.codeName + "= 'read_lesson3'", null);
        }else if (gameID == 1 && dfID == 1) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion.questionTable_Name + " WHERE " + tableQuestion.codeName + "= 'read_lesson4'", null);
        }else if (gameID == 1 && dfID == 2) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion.questionTable_Name + " WHERE " + tableQuestion.codeName + "= 'read_lesson5'", null);
        }else if (gameID == 2 && dfID == 1) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion.questionTable_Name + " WHERE " + tableQuestion.codeName + "= 'read_lesson6'", null);
        }else if (gameID == 2 && dfID == 2) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion.questionTable_Name + " WHERE " + tableQuestion.codeName + "= 'read_lesson7'", null);
        }else if (gameID == 3 && dfID == 1) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion.questionTable_Name + " WHERE " + tableQuestion.codeName + "= 'read_lesson8'", null);
        }else if (gameID == 3 && dfID == 2) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion.questionTable_Name + " WHERE " + tableQuestion.codeName + "= 'read_lesson9'", null);
        }else if (gameID == 3 && dfID == 3) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion.questionTable_Name + " WHERE " + tableQuestion.codeName + "= 'read_lesson10'", null);
        }else if (gameID == 1 && dfID == 3) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion.questionTable_Name + " WHERE " + tableQuestion.codeName + "= 'read_lesson11'", null);
        }else if (gameID == 2 && dfID == 3) {
            cursor = db.rawQuery("SELECT * FROM " + tableQuestion.questionTable_Name + " WHERE " + tableQuestion.codeName + "= 'read_lesson12'", null);
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
