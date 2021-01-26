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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import aea.bt.cryptography.Control.Noun_control;
import aea.bt.cryptography.R;
import aea.bt.cryptography.menu.Lesson_activity;
import aea.bt.cryptography.music.HomeWatcher;
import aea.bt.cryptography.music.MusicService;
import aea.bt.cryptography.pdf.pdf2_lesson;
import aea.bt.cryptography.pdf.pdf_lesson;

public class noun_manager_lesson extends AppCompatActivity {
    Button lesson1, lesson2, lesson3, lesson4, lesson5, lesson6, lesson7 ,lesson8 ,lesson9,lesson10,lesson11,lesson12;
    TextView score1, score2, score3, score4, score5, score9, score10, score11;
    Vibrator vibrator;
    public static int noun_classID;
    int scores_tester1;
    int scores_tester2;
    int scores_tester3;
    int scores_tester4;
    int scores_tester5;
    int scores_tester9;
    int scores_tester10;
    int scores_tester11;
    private int highscore1;


    ImageView comeblack;
    HomeWatcher mHomeWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noun_manager_lesson);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        doBindService();
        XLM();
        comeblack = findViewById(R.id.btn_come_black);
        comeblack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(noun_manager_lesson.this, Lesson_activity.class);
                startActivity(a);
            }
        });
        Intent music = new Intent();
        music.setClass(this, MusicService.class);
        startService(music);
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
        lesson3 = findViewById(R.id.play_lss3);
        lesson4 = findViewById(R.id.play_lss4);
        lesson5 = findViewById(R.id.play_lss5);
        lesson6 = findViewById(R.id.play_lss6);
        lesson7 = findViewById(R.id.play_lss7);
        lesson8 = findViewById(R.id.play_lss8);
        lesson9 = findViewById(R.id.play_lss9);
        lesson10 = findViewById(R.id.play_lss10);
        lesson11 = findViewById(R.id.play_lss11);
        lesson12 = findViewById(R.id.play_lss12);
        score1 = findViewById(R.id.Score1);
        score2 = findViewById(R.id.Score2);
        score3 = findViewById(R.id.Score3);
        score4 = findViewById(R.id.Score4);
        score5 = findViewById(R.id.Score5);
        score9 = findViewById(R.id.Score9);
        score10 = findViewById(R.id.Score10);
        score11 = findViewById(R.id.Score11);

        SharedPreferences preferences1 = this.getSharedPreferences("a1", Context.MODE_PRIVATE);
        SharedPreferences preferences2 = this.getSharedPreferences("a2", Context.MODE_PRIVATE);
        SharedPreferences preferences3 = this.getSharedPreferences("a3", Context.MODE_PRIVATE);
        SharedPreferences preferences4 = this.getSharedPreferences("a4", Context.MODE_PRIVATE);
        SharedPreferences preferences5 = this.getSharedPreferences("a5", Context.MODE_PRIVATE);
        SharedPreferences preferences9 = this.getSharedPreferences("a9", Context.MODE_PRIVATE);
        SharedPreferences preferences10 = this.getSharedPreferences("a10", Context.MODE_PRIVATE);
        SharedPreferences preferences11 = this.getSharedPreferences("a11", Context.MODE_PRIVATE);
        scores_tester1 = preferences1.getInt("rightanswerCount", 0);
        scores_tester2 = preferences2.getInt("rightanswerCount", 0);
        scores_tester3 = preferences3.getInt("rightanswerCount", 0);
        scores_tester4 = preferences4.getInt("rightanswerCount", 0);
        scores_tester5 = preferences5.getInt("rightanswerCount", 0);
        scores_tester9 = preferences9.getInt("rightanswerCount", 0);
        scores_tester10 = preferences10.getInt("rightanswerCount", 0);
        scores_tester11 = preferences11.getInt("rightanswerCount", 0);
        score1.setText(scores_tester1 + "/10");
        score2.setText(scores_tester2 + "/10");
        score3.setText(scores_tester3 + "/10");
        score4.setText(scores_tester4 + "/10");
        score5.setText(scores_tester5 + "/10");
        score9.setText(scores_tester9 + "/10");
        score10.setText(scores_tester10 + "/10");
        score11.setText(scores_tester11 + "/10");
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
                noun_classID = 1;
                break;
            case R.id.play_lss2:
                noun_classID = 2;
                break;
            case R.id.play_lss3:
                noun_classID = 3;
                break;
            case R.id.play_lss4:
                noun_classID = 4;
                break;
            case R.id.play_lss5:
                noun_classID = 5;
                break;
            case R.id.play_lss9:
                noun_classID = 9;
                break;
            case R.id.play_lss10:
                noun_classID = 10;
                break;
            case R.id.play_lss11:
                noun_classID = 11;
                break;
        }
        Intent intent = new Intent(getApplicationContext(), Noun_control.class);
        intent.putExtra("noun_classID", noun_classID);
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
        Intent intent = new Intent(noun_manager_lesson.this, Lesson_activity.class);
        startActivity(intent);
        finish();
    }
}