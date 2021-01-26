package aea.bt.cryptography.pdf;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import aea.bt.cryptography.Control.Game_control_write;
import aea.bt.cryptography.Control.Noun_control;
import aea.bt.cryptography.R;
import aea.bt.cryptography.manager_lesson.noun_manager_lesson;
import aea.bt.cryptography.manager_lesson.read_manager_lesson;
import aea.bt.cryptography.manager_lesson.write_manager_lesson;
import aea.bt.cryptography.music.HomeWatcher;
import aea.bt.cryptography.music.MusicService;

public class pdf2_lesson extends AppCompatActivity {
    HomeWatcher mHomeWatcher;
    String textScroll = "ສາມາດເລື່ອນລົງເພື່ອເບີ່ງໜ້າຕໍ່ໄປ";
    PDFView pdfView;
    Button play;
    Vibrator vibrator;
    public static int class_pdf_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf2_lesson);
        doBindService();
        Toast.makeText(getApplicationContext(), textScroll, Toast.LENGTH_LONG).show();
        play = findViewById(R.id.play);
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
        pdfView = findViewById(R.id.pdfView);
        if (noun_manager_lesson.noun_classID  == 1) {
            pdfView.fromAsset("laos_language_lesson_1.pdf").load();
            class_pdf_ID = 1;
        } else if ( noun_manager_lesson.noun_classID ==2) {
            class_pdf_ID= 2;
            pdfView.fromAsset("laos_language_lesson_2.pdf").load();
        } else if (noun_manager_lesson.noun_classID == 3) {
            class_pdf_ID = 3;
            pdfView.fromAsset("laos_language_lesson_3.pdf").load();
        } else if (noun_manager_lesson.noun_classID == 4) {
            class_pdf_ID = 4;
            pdfView.fromAsset("laos_language_lesson_4.pdf").load();
        } else if (noun_manager_lesson.noun_classID == 5) {
            class_pdf_ID = 5;
            pdfView.fromAsset("laos_language_lesson_5.pdf").load();
        } else if (noun_manager_lesson.noun_classID == 6) {
            class_pdf_ID= 6;
            pdfView.fromAsset("laos_language_lesson_6.pdf").load();

        } else if (noun_manager_lesson.noun_classID == 7) {
            class_pdf_ID = 7;
            pdfView.fromAsset("laos_language_lesson_7.pdf").load();
        } else if (noun_manager_lesson.noun_classID == 8) {
            class_pdf_ID = 8;
            pdfView.fromAsset("laos_language_lesson_8.pdf").load();
        } else if (noun_manager_lesson.noun_classID == 9) {
            class_pdf_ID= 9;
            pdfView.fromAsset("laos_language_lesson_9.pdf").load();
        } else if (noun_manager_lesson.noun_classID == 10) {
            class_pdf_ID = 10;
            pdfView.fromAsset("laos_language_lesson_10.pdf").load();
        } else if (noun_manager_lesson.noun_classID == 11) {
            class_pdf_ID = 11;
            pdfView.fromAsset("laos_language_lesson_11.pdf").load();
        } else if (noun_manager_lesson.noun_classID == 12) {
            class_pdf_ID = 12;
            pdfView.fromAsset("laos_language_lesson_12.pdf").load();
        } else if (noun_manager_lesson.noun_classID == 15) {
            class_pdf_ID = 15;
            pdfView.fromAsset("laos_language_lesson_15.pdf").load();
        } else if (noun_manager_lesson.noun_classID ==16) {
            class_pdf_ID= 16;
            pdfView.fromAsset("laos_language_lesson_16.pdf").load();
        } else if (noun_manager_lesson.noun_classID ==17) {
            class_pdf_ID = 17;
            pdfView.fromAsset("laos_language_lesson_17.pdf").load();
        } else if (noun_manager_lesson.noun_classID== 18) {
            class_pdf_ID = 18;
            pdfView.fromAsset("laos_language_lesson_18.pdf").load();
        } else if (noun_manager_lesson.noun_classID == 19) {
            class_pdf_ID= 19;
            pdfView.fromAsset("laos_language_lesson_19.pdf").load();
        } else if (noun_manager_lesson.noun_classID== 20) {
            class_pdf_ID = 20;
            pdfView.fromAsset("laos_language_lesson_20.pdf").load();
        }else if (noun_manager_lesson.noun_classID ==21) {
            class_pdf_ID= 21;
            pdfView.fromAsset("laos_language_lesson_21.pdf").load();
        }else if (noun_manager_lesson.noun_classID == 22) {
            class_pdf_ID = 22;
            pdfView.fromAsset("laos_language_lesson_22.pdf").load();
        }else if (noun_manager_lesson.noun_classID == 23) {
            class_pdf_ID = 23;
            pdfView.fromAsset("laos_language_lesson_23.pdf").load();
        }else if (noun_manager_lesson.noun_classID== 24) {
            class_pdf_ID = 24;
            pdfView.fromAsset("laos_language_lesson_24.pdf").load();
        }else if (noun_manager_lesson.noun_classID == 25) {
            class_pdf_ID = 25;
            pdfView.fromAsset("laos_language_lesson_25.pdf").load();
        }else if (noun_manager_lesson.noun_classID ==26) {
            class_pdf_ID = 26;
            pdfView.fromAsset("laos_language_lesson_26.pdf").load();
        }else if (noun_manager_lesson.noun_classID==29) {
            class_pdf_ID= 29;
            pdfView.fromAsset("laos_language_lesson_29.pdf").load();
        }else if (noun_manager_lesson.noun_classID == 30) {
            class_pdf_ID = 30;
            pdfView.fromAsset("laos_language_lesson_30.pdf").load();
        }else if (noun_manager_lesson.noun_classID ==31) {
            class_pdf_ID= 31;
            pdfView.fromAsset("laos_language_lesson_31.pdf").load();
        }else if (noun_manager_lesson.noun_classID== 32) {
            class_pdf_ID = 32;
            pdfView.fromAsset("laos_language_lesson_32.pdf").load();
        }else if (noun_manager_lesson.noun_classID == 33) {
            class_pdf_ID = 33;
            pdfView.fromAsset("laos_language_lesson_33.pdf").load();
        }else if (noun_manager_lesson.noun_classID == 34) {
            class_pdf_ID = 34;
            pdfView.fromAsset("laos_language_lesson_34.pdf").load();
        }else if (noun_manager_lesson.noun_classID== 35) {
            class_pdf_ID = 35;
            pdfView.fromAsset("laos_language_lesson_35.pdf").load();
        }else if (noun_manager_lesson.noun_classID== 36) {
            class_pdf_ID= 36;
            pdfView.fromAsset("laos_language_lesson_36.pdf").load();
        }else if (noun_manager_lesson.noun_classID ==37) {
            class_pdf_ID = 37;
            pdfView.fromAsset("laos_language_lesson_37.pdf").load();
        }else if (noun_manager_lesson.noun_classID == 38) {
            class_pdf_ID = 38;
            pdfView.fromAsset("laos_language_lesson_38.pdf").load();
        }else if (noun_manager_lesson.noun_classID == 39) {
            class_pdf_ID = 39;
            pdfView.fromAsset("laos_language_lesson_39.pdf").load();
        }else if (noun_manager_lesson.noun_classID== 40) {
            class_pdf_ID= 40;
            pdfView.fromAsset("laos_language_lesson_40.pdf").load();
        }else if (noun_manager_lesson.noun_classID == 41) {
            class_pdf_ID = 41;
            pdfView.fromAsset("laos_language_lesson_41.pdf").load();
        }else if (noun_manager_lesson.noun_classID ==42) {
            class_pdf_ID = 42;
            pdfView.fromAsset("laos_language_lesson_42.pdf").load();
        }else if (noun_manager_lesson.noun_classID== 45) {
            class_pdf_ID = 45;
            pdfView.fromAsset("laos_language_lesson_45.pdf").load();
        }else if (noun_manager_lesson.noun_classID == 46) {
            class_pdf_ID= 46;
            pdfView.fromAsset("laos_language_lesson_46.pdf").load();
        }else if (noun_manager_lesson.noun_classID == 47) {
            class_pdf_ID = 47;
            pdfView.fromAsset("laos_language_lesson_47.pdf").load();
        }else if (noun_manager_lesson.noun_classID ==48) {
            class_pdf_ID = 48;
            pdfView.fromAsset("laos_language_lesson_48.pdf").load();
        }else if (noun_manager_lesson.noun_classID==49) {
            class_pdf_ID= 49;
            pdfView.fromAsset("laos_language_lesson_49.pdf").load();
        }else if (noun_manager_lesson.noun_classID== 50) {
            class_pdf_ID = 50;
            pdfView.fromAsset("laos_language_lesson_50.pdf").load();
        }else if (noun_manager_lesson.noun_classID ==51) {
            class_pdf_ID = 51;
            pdfView.fromAsset("laos_language_lesson_51.pdf").load();
        }else if (noun_manager_lesson.noun_classID == 52) {
            class_pdf_ID = 52;
            pdfView.fromAsset("laos_language_lesson_52.pdf").load();
        }else if (noun_manager_lesson.noun_classID ==53) {
            class_pdf_ID = 53;
            pdfView.fromAsset("laos_language_lesson_53.pdf").load();
        }else if (noun_manager_lesson.noun_classID == 54) {
            class_pdf_ID = 54;
            pdfView.fromAsset("laos_language_lesson_54.pdf").load();
        }else if (noun_manager_lesson.noun_classID == 55) {
            class_pdf_ID = 55;
            pdfView.fromAsset("laos_language_lesson_55.pdf").load();
        }else if (noun_manager_lesson.noun_classID== 56) {
            class_pdf_ID = 56;
            pdfView.fromAsset("laos_language_lesson_56.pdf").load();
        }

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mServ != null) {
                    mServ.pauseMusic();
                    Intent intent = new Intent(getApplicationContext(), Noun_control.class);
                    intent.putExtra("class_pdf_ID", class_pdf_ID);
                    startActivity(intent);

                }

            }
        });


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

    public void Playzz(View view) {
        vibrator.vibrate(50);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_anim);
        view.startAnimation(animation);
    }

    @Override
    public void onBackPressed() {
        final Dialog dialog = new Dialog(pdf2_lesson.this);
        dialog.setContentView(R.layout.pop_up_exit1);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();

        Button btn_pop_cancel = dialog.findViewById(R.id.btn_cancel);
        btn_pop_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        Button btn_pop_exit = dialog.findViewById(R.id.btn_close);
        btn_pop_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pdf2_lesson.this, noun_manager_lesson.class);
                startActivity(intent);
            }
        });


    }


}