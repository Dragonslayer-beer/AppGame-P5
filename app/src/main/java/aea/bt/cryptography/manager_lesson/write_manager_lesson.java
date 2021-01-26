package aea.bt.cryptography.manager_lesson;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import aea.bt.cryptography.Control.Game_control_write;
import aea.bt.cryptography.MainActivity;
import aea.bt.cryptography.R;
import aea.bt.cryptography.menu.Lesson_activity;
import aea.bt.cryptography.music.HomeWatcher;
import aea.bt.cryptography.music.MusicService;
import aea.bt.cryptography.pdf.pdf1_lesson;
import aea.bt.cryptography.pdf.pdf_lesson;

public class write_manager_lesson extends AppCompatActivity {
    Button lesson1, lesson2, lesson3, lesson4, lesson5, lesson6, lesson7, lesson8, lesson9, lesson10, lesson11, lesson12;
    TextView score1, score2, score3, score4, score5, score6, score7, score8, score9, score10, score11, score12;
    public static int classID_write;
    int score_test1;
    int score_test2;
    int score_test4;
    int score_test5;
    int score_test6;
    int score_test7;
    int score_test8;
    int score_test9;
    int score_test11;
    ImageView comeblack;
    Vibrator vibrator;
    HomeWatcher mHomeWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_manager_lesson);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        XLM();
        comeblack = findViewById(R.id.btn_come_black);
        comeblack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(write_manager_lesson.this, Lesson_activity.class);
                startActivity(a);
            }
        });
        doBindService();

        mHomeWatcher = new HomeWatcher(this);
        mHomeWatcher.setOnHomePressedListener(new HomeWatcher.OnHomePressedListener() {
            @Override
            public void onHomePressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }

            @Override
            public void onHomeLongPressed() {
                if (mServ != null) {
                    mServ.pauseMusic();
                }
            }
        });
        mHomeWatcher.startWatch();

    }




    private void XLM() {
        lesson1 = findViewById(R.id.play_lss1);
        lesson2 = findViewById(R.id.play_lss2);
        lesson4 = findViewById(R.id.play_lss4);
        lesson5 = findViewById(R.id.play_lss5);
        lesson6 = findViewById(R.id.play_lss6);
        lesson7 = findViewById(R.id.play_lss7);
        lesson8 = findViewById(R.id.play_lss8);
        lesson9 = findViewById(R.id.play_lss9);
        lesson11 = findViewById(R.id.play_lss11);
        score1 = findViewById(R.id.Score1);
        score2 = findViewById(R.id.Score2);
        score4 = findViewById(R.id.Score4);
        score5 = findViewById(R.id.Score5);
        score6 = findViewById(R.id.Score6);
        score7 = findViewById(R.id.Score7);
        score8 = findViewById(R.id.Score8);
        score9 = findViewById(R.id.Score9);
        score11 = findViewById(R.id.Score11);

        SharedPreferences preferences1 = this.getSharedPreferences("myPrefsKeys1", Context.MODE_PRIVATE);
        SharedPreferences preferences2 = this.getSharedPreferences("myPrefsKeys2", Context.MODE_PRIVATE);
        SharedPreferences preferences4 = this.getSharedPreferences("myPrefsKeys4", Context.MODE_PRIVATE);
        SharedPreferences preferences5 = this.getSharedPreferences("myPrefsKeys5", Context.MODE_PRIVATE);
        SharedPreferences preferences6 = this.getSharedPreferences("myPrefsKeys6", Context.MODE_PRIVATE);
        SharedPreferences preferences7 = this.getSharedPreferences("myPrefsKeys7", Context.MODE_PRIVATE);
        SharedPreferences preferences8 = this.getSharedPreferences("myPrefsKeys8", Context.MODE_PRIVATE);
        SharedPreferences preferences9 = this.getSharedPreferences("myPrefsKeys9", Context.MODE_PRIVATE);
        SharedPreferences preferences11 = this.getSharedPreferences("myPrefsKeys11", Context.MODE_PRIVATE);

        score_test1 = preferences1.getInt("rightanswerCount", 0);
        score_test2 = preferences2.getInt("rightanswerCount", 0);
        score_test4 = preferences4.getInt("rightanswerCount", 0);
        score_test5 = preferences5.getInt("rightanswerCount", 0);
        score_test6 = preferences6.getInt("rightanswerCount", 0);
        score_test7 = preferences7.getInt("rightanswerCount", 0);
        score_test8 = preferences8.getInt("rightanswerCount", 0);
        score_test9 = preferences9.getInt("rightanswerCount", 0);
        score_test11 = preferences11.getInt("rightanswerCount", 0);
        score1.setText(score_test1 + "/10");
        score2.setText(score_test2 + "/10");
        score4.setText(score_test4 + "/10");
        score5.setText(score_test5 + "/10");
        score6.setText(score_test6 + "/10");
        score7.setText(score_test7 + "/10");
        score8.setText(score_test8 + "/10");
        score9.setText(score_test9 + "/10");
        score11.setText(score_test11 + "/10");
    }

    public void Next(View view) {
        if (mServ != null) {
            mServ.pauseMusic();
        }
        vibrator.vibrate(50);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_anim);
        view.startAnimation(animation);
        switch (view.getId()) {
            case R.id.play_lss1:
                classID_write = 1;
                break;
            case R.id.play_lss2:
                classID_write = 2;
                break;
            case R.id.play_lss3:
                classID_write = 3;
                break;
            case R.id.play_lss4:
                classID_write = 4;
                break;
            case R.id.play_lss5:
                classID_write = 5;
                break;
            case R.id.play_lss6:
                classID_write = 6;
                break;
            case R.id.play_lss7:
                classID_write = 7;
                break;
            case R.id.play_lss8:
                classID_write = 8;
                break;
            case R.id.play_lss9:
                classID_write = 9;
                break;
            case R.id.play_lss10:
                classID_write = 10;
                break;
            case R.id.play_lss11:
                classID_write = 11;
                break;
            case R.id.play_lss12:
                classID_write = 12;
                break;

        }
        Intent intent = new Intent(getApplicationContext(), Game_control_write.class);
        intent.putExtra("classID", classID_write);
        startActivity(intent);

    }
    private boolean mIsBound = false;
    private MusicService mServ;
    private ServiceConnection Scon = new ServiceConnection() {

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            mServ = ((MusicService.ServiceBinder) binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService() {
        bindService(new Intent(this, MusicService.class),
                Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService() {
        if (mIsBound) {
            unbindService(Scon);
            mIsBound = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mServ != null) {
            mServ.resumeMusic();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHomeWatcher.stopWatch();
        doUnbindService();
        Intent music = new Intent();
        music.setClass(this, MusicService.class);
        stopService(music);

    }

    @Override
    protected void onPause() {
        super.onPause();

        PowerManager pm = (PowerManager)
                getSystemService(Context.POWER_SERVICE);
        boolean isScreenOn = false;
        if (pm != null) {
            isScreenOn = pm.isScreenOn();
        }

        if (!isScreenOn) {
            if (mServ != null) {
                mServ.pauseMusic();
            }
        }

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(write_manager_lesson.this, Lesson_activity.class);
        startActivity(intent);
        finish();
    }

}