package aea.bt.cryptography.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import aea.bt.cryptography.MainActivity;
import aea.bt.cryptography.R;
import aea.bt.cryptography.manager_lesson.noun_manager_lesson;
import aea.bt.cryptography.manager_lesson.read_manager_lesson;
import aea.bt.cryptography.manager_lesson.write_manager_lesson;

public class Lesson_activity extends AppCompatActivity {
    ImageView comeblack;
    LinearLayout btn_write, btn_reading, btn_game_lesson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_activity);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        Readfilexml();
        NEWclass();
    }

    private void NEWclass() {
        comeblack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Lesson_activity.this, MainActivity.class);
                startActivity(i);finish();
            }
        });
        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lesson_activity.this, write_manager_lesson.class);
                startActivity(intent);finish();
            }
        });
        btn_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lesson_activity.this, read_manager_lesson.class);
                startActivity(intent);finish();
            }
        });
        btn_game_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lesson_activity.this, noun_manager_lesson.class);
                startActivity(intent);finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Lesson_activity.this,MainActivity.class);
        startActivity(intent);finish();
    }
    private void Readfilexml() {
        btn_game_lesson = findViewById(R.id.btn_game_lesson);
        comeblack = findViewById(R.id.btn_come_black);
        btn_write = findViewById(R.id.btn_write);
        btn_reading = findViewById(R.id.btn_reading);
    }
}