package aea.bt.cryptography;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;

import aea.bt.cryptography.menu.Game_brain;
import aea.bt.cryptography.manager_lesson.manager_many_lesson;
import aea.bt.cryptography.menu.Lesson_activity;
import aea.bt.cryptography.music.HomeWatcher;
import aea.bt.cryptography.music.MusicService;
import aea.bt.cryptography.pdf.pdf1_lesson;

public class MainActivity extends AppCompatActivity {
    Button lesson, brarin, game_leson;
    HomeWatcher mHomeWatcher;
    ImageView youtube;
    public static ToggleButton toggleButton;
    public static int switchONOff = 0;
    public static int numberOpen = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        XML();
        Stopmusic();
        NewLaout();
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, pdf1_lesson.class);
                startActivity(intent);
            }
        });

        //Start HomeWatcher


    }
    private void NewLaout() {
        lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, manager_many_lesson.class);
                startActivity(intent);
            }
        });
        game_leson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, Lesson_activity.class);
                startActivity(a);
            }
        });
        brarin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Game_brain.class);
                startActivity(i);

            }
        });

    }

    private void Stopmusic() {
        doBindService();
        toggleButton = findViewById(R.id.toggleButton2);
        if (switchONOff == 1) {
            toggleButton.setBackgroundResource(R.drawable.ic_volume_off_black_24dp);
            //switchONOff=0;


        } else if (switchONOff == 0) {
            toggleButton.setBackgroundResource(R.drawable.ic_volume_up_black_24dp);
            //switchONOff=1;

        }
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

    //Bind/Unbind music service
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
    protected void onPause() {
        super.onPause();

        //Detect idle screen
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
    protected void onDestroy() {
        super.onDestroy();

        //UNBIND music service
        doUnbindService();
        Intent music = new Intent();
        music.setClass(this, MusicService.class);
        stopService(music);

    }

    private void XML() {

        lesson = findViewById(R.id.lesson);
        game_leson = findViewById(R.id.game_lesson);
        brarin = findViewById(R.id.game_brain);
        youtube = findViewById(R.id.youtube);
    }

    public void toggleSet(View V) {
        if (switchONOff == 0) {
            toggleButton.setBackgroundResource(R.drawable.ic_volume_off_black_24dp);

            numberOpen = 0;
            switchONOff = 1;
            mServ.stopMusic();
        } else {
            toggleButton.setBackgroundResource(R.drawable.ic_volume_up_black_24dp);
            numberOpen = 1;
            switchONOff = 0;
            mServ.startMusic();
        }
    }

}