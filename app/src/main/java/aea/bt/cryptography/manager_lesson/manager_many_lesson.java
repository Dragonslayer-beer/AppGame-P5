package aea.bt.cryptography.manager_lesson;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import aea.bt.cryptography.MainActivity;
import aea.bt.cryptography.R;
import aea.bt.cryptography.menu.Lesson_activity;
import aea.bt.cryptography.music.HomeWatcher;
import aea.bt.cryptography.music.MusicService;
import aea.bt.cryptography.pdf.pdf2_lesson;
import aea.bt.cryptography.pdf.pdf_many_lesson;

public class manager_many_lesson extends AppCompatActivity {
    Button many1, many2, many3, many4, many5, many6, many7, many8, many9, many10, many11, many12, many15, many16, many17, many18, many19, many20, many21, many22, many23, many24, many25, many26, many29, many30, many31, many32, many33, many34, many35, many36, many37, many38, many39, many40, many41, many42, many45, many46, many47, many48, many49, many50, many51, many52, many53, many54, many55, many56;
    public static int many_classID;
    ImageView btn_come_black;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_many_lesson);

        XML();
    }

    private void XML() {
        btn_come_black = findViewById(R.id.btn_come_black);
        many1 = findViewById(R.id.many1);
        many2 = findViewById(R.id.many2);
        many3 = findViewById(R.id.many3);
        many4 = findViewById(R.id.many4);
        many5 = findViewById(R.id.many5);
        many6 = findViewById(R.id.many6);
        many7 = findViewById(R.id.many7);
        many8 = findViewById(R.id.many8);
        many9 = findViewById(R.id.many9);
        many10 = findViewById(R.id.many10);
        many11 = findViewById(R.id.many11);
        many12 = findViewById(R.id.many12);
        many15 = findViewById(R.id.many15);
        many16 = findViewById(R.id.many16);
        many17 = findViewById(R.id.many17);
        many18 = findViewById(R.id.many18);
        many19 = findViewById(R.id.many19);
        many20 = findViewById(R.id.many20);
        many21 = findViewById(R.id.many21);
        many22 = findViewById(R.id.many22);
        many23 = findViewById(R.id.many23);
        many24 = findViewById(R.id.many24);
        many25 = findViewById(R.id.many25);
        many26 = findViewById(R.id.many26);
        many29 = findViewById(R.id.many29);
        many30 = findViewById(R.id.many30);
        many31 = findViewById(R.id.many31);
        many32 = findViewById(R.id.many32);
        many33 = findViewById(R.id.many33);
        many34 = findViewById(R.id.many34);
        many35 = findViewById(R.id.many35);
        many36 = findViewById(R.id.many36);
        many37 = findViewById(R.id.many37);
        many38 = findViewById(R.id.many38);
        many39 = findViewById(R.id.many39);
        many40 = findViewById(R.id.many40);
        many41 = findViewById(R.id.many41);
        many42 = findViewById(R.id.many42);
        many45 = findViewById(R.id.many45);
        many46 = findViewById(R.id.many46);
        many47 = findViewById(R.id.many47);
        many48 = findViewById(R.id.many48);
        many49 = findViewById(R.id.many49);
        many50 = findViewById(R.id.many50);
        many51 = findViewById(R.id.many51);
        many52 = findViewById(R.id.many52);
        many53 = findViewById(R.id.many53);
        many54 = findViewById(R.id.many54);
        many55 = findViewById(R.id.many55);
        many56 = findViewById(R.id.many56);
        btn_come_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(manager_many_lesson.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void hello(View view) {
        switch (view.getId()) {
            case R.id.many1:
                many_classID = 1;
                break;
            case R.id.many2:
                many_classID = 2;
                break;
            case R.id.many3:
                many_classID = 3;
                break;
            case R.id.many4:
                many_classID = 4;
                break;
            case R.id.many5:
                many_classID = 5;
                break;
            case R.id.many6:
                many_classID = 6;
                break;
            case R.id.many7:
                many_classID = 7;
                break;
            case R.id.many8:
                many_classID = 8;
                break;
            case R.id.many9:
                many_classID = 9;
                break;
            case R.id.many10:
                many_classID = 10;
                break;
            case R.id.many11:
                many_classID = 11;
                break;
            case R.id.many12:
                many_classID = 12;
                break;
            case R.id.many15:
                many_classID = 15;
                break;
            case R.id.many16:
                many_classID = 16;
                break;
            case R.id.many17:
                many_classID = 17;
                break;
            case R.id.many18:
                many_classID = 18;
                break;
            case R.id.many19:
                many_classID = 19;
                break;
            case R.id.many20:
                many_classID = 20;
                break;
            case R.id.many21:
                many_classID = 21;
                break;
            case R.id.many22:
                many_classID = 22;
                break;
            case R.id.many23:
                many_classID = 23;
                break;
            case R.id.many24:
                many_classID = 24;
                break;
            case R.id.many25:
                many_classID = 25;
                break;
            case R.id.many26:
                many_classID = 26;
                break;
            case R.id.many29:
                many_classID = 29;
                break;
            case R.id.many30:
                many_classID = 30;
                break;
            case R.id.many31:
                many_classID = 31;
                break;
            case R.id.many32:
                many_classID = 32;
                break;
            case R.id.many33:
                many_classID = 33;
                break;
            case R.id.many34:
                many_classID = 34;
                break;
            case R.id.many35:
                many_classID = 35;
                break;
            case R.id.many36:
                many_classID = 36;
                break;
            case R.id.many37:
                many_classID = 37;
                break;
            case R.id.many38:
                many_classID = 38;
                break;
            case R.id.many39:
                many_classID = 39;
                break;
            case R.id.many40:
                many_classID = 40;
                break;
            case R.id.many41:
                many_classID = 42;
                break;
            case R.id.many45:
                many_classID = 46;
                break;
            case R.id.many47:
                many_classID = 47   ;
                break;
            case R.id.many48:
                many_classID = 48;
                break;
            case R.id.many49:
                many_classID = 49;
                break;
            case R.id.many50:
                many_classID = 50;
                break;
            case R.id.many51:
                many_classID = 51;
                break;
            case R.id.many52:
                many_classID = 52;
                break;
            case R.id.many53:
                many_classID = 53;
                break;
            case R.id.many54:
                many_classID = 54;
                break;
            case R.id.many55:
                many_classID = 55;
                break;
            case R.id.many56:
                many_classID = 56;
                break;
        }

        Intent intent = new Intent(getApplicationContext(), pdf_many_lesson.class);
        intent.putExtra("many_classID", many_classID);
        startActivity(intent);
    }
        @Override
        public void onBackPressed() {
            Intent intent = new Intent(manager_many_lesson.this,MainActivity.class);
            startActivity(intent);
            finish();
        }


}