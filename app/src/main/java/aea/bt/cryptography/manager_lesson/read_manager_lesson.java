package aea.bt.cryptography.manager_lesson;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.Switch;
import android.widget.TextView;

import java.util.prefs.Preferences;

import aea.bt.cryptography.Control.Game_control_read;
import aea.bt.cryptography.MainActivity;
import aea.bt.cryptography.R;
import aea.bt.cryptography.menu.Lesson_activity;
import aea.bt.cryptography.music.HomeWatcher;
import aea.bt.cryptography.music.MusicService;
import aea.bt.cryptography.pdf.pdf_lesson;

public class read_manager_lesson extends AppCompatActivity {
    Button lesson1, lesson2, lesson3, lesson4, lesson5, lesson6, lesson7, lesson8, lesson9, lesson10, lesson11, lesson12;
    TextView score1, score2, score3, score4, score5, score6, score7, score8, score9, score10, score11, score12;
    Vibrator vibrator;
    public static int classID;
    int scores_test1;
    int scores_test2;
    int scores_test3;
    int scores_test4;
    int scores_test5;
    int scores_test6;
    int scores_test7;
    int scores_test8;
    int scores_test9;
    int scores_test10;
    int scores_test11;
    int scores_test12;
 private int highscore1;
    ImageView comeblack;
    HomeWatcher mHomeWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_manager_lesson);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        XLM();
        doBindService();
        comeblack = findViewById(R.id.btn_come_black);
        comeblack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(read_manager_lesson.this, Lesson_activity.class);
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
        score6 = findViewById(R.id.Score6);
        score7 = findViewById(R.id.Score7);
        score8 = findViewById(R.id.Score8);
        score9 = findViewById(R.id.Score9);
        score10 = findViewById(R.id.Score10);
        score11 = findViewById(R.id.Score11);
        score12 = findViewById(R.id.Score12);

        SharedPreferences preferences1 = this.getSharedPreferences("myPrefsKey1", Context.MODE_PRIVATE);
        SharedPreferences preferences2 = this.getSharedPreferences("myPrefsKey2", Context.MODE_PRIVATE);
        SharedPreferences preferences3 = this.getSharedPreferences("myPrefsKey3", Context.MODE_PRIVATE);
        SharedPreferences preferences4 = this.getSharedPreferences("myPrefsKey4", Context.MODE_PRIVATE);
        SharedPreferences preferences5 = this.getSharedPreferences("myPrefsKey5", Context.MODE_PRIVATE);
        SharedPreferences preferences6 = this.getSharedPreferences("myPrefsKey6", Context.MODE_PRIVATE);
        SharedPreferences preferences7 = this.getSharedPreferences("myPrefsKey7", Context.MODE_PRIVATE);
        SharedPreferences preferences8 = this.getSharedPreferences("myPrefsKey8", Context.MODE_PRIVATE);
        SharedPreferences preferences9= this.getSharedPreferences("myPrefsKey9", Context.MODE_PRIVATE);
        SharedPreferences preferences10 = this.getSharedPreferences("myPrefsKey10", Context.MODE_PRIVATE);
        SharedPreferences preferences11 = this.getSharedPreferences("myPrefsKey11", Context.MODE_PRIVATE);
        SharedPreferences preferences12 = this.getSharedPreferences("myPrefsKey12", Context.MODE_PRIVATE);
        scores_test1 = preferences1.getInt("rightanswerCount", 0);
        scores_test2 = preferences2.getInt("rightanswerCount", 0);
        scores_test3 = preferences3.getInt("rightanswerCount", 0);
        scores_test4 = preferences4.getInt("rightanswerCount", 0);
        scores_test5 = preferences5.getInt("rightanswerCount", 0);
        scores_test6 = preferences6.getInt("rightanswerCount", 0);
        scores_test7 = preferences7.getInt("rightanswerCount", 0);
        scores_test8 = preferences8.getInt("rightanswerCount", 0);
        scores_test9 = preferences9.getInt("rightanswerCount", 0);
        scores_test10 = preferences10.getInt("rightanswerCount", 0);
        scores_test11 = preferences11.getInt("rightanswerCount", 0);
        scores_test12 = preferences12.getInt("rightanswerCount", 0);
        score1.setText(scores_test1 + "/10");
        score2.setText(scores_test2 + "/10");
        score3.setText(scores_test3 + "/10");
        score4.setText(scores_test4 + "/10");
        score5.setText(scores_test5 + "/10");
        score6.setText(scores_test6 + "/10");
        score7.setText(scores_test7 + "/10");
        score8.setText(scores_test8 + "/10");
        score9.setText(scores_test9 + "/10");
        score10.setText(scores_test10 + "/10");
        score11.setText(scores_test11 + "/10");
        score12.setText(scores_test12 + "/10");
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

                classID = 1;
                break;
            case R.id.play_lss2:
                classID = 2;
                break;
            case R.id.play_lss3:
                classID = 3;
                break;
            case R.id.play_lss4:
                classID = 4;
                break;
            case R.id.play_lss5:
                classID = 5;
                break;
            case R.id.play_lss6:
                classID = 6;
                break;
            case R.id.play_lss7:
                classID = 7;
                break;
            case R.id.play_lss8:
                classID = 8;
                break;
            case R.id.play_lss9:
                classID = 9;
                break;
            case R.id.play_lss10:
                classID = 10;
                break;
            case R.id.play_lss11:
                classID = 11;
                break;
            case R.id.play_lss12:
                classID = 12;
                break;
        }

        Intent intent = new Intent(getApplicationContext(),Game_control_read.class);
        intent.putExtra("classID", classID);
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
        Intent intent = new Intent(read_manager_lesson.this, Lesson_activity.class);
        startActivity(intent);
        finish();
    }

}