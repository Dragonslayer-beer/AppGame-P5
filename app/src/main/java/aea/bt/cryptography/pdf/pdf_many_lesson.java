package aea.bt.cryptography.pdf;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

import aea.bt.cryptography.Control.Game_control_read;
import aea.bt.cryptography.Control.Game_control_write;
import aea.bt.cryptography.Control.Noun_control;
import aea.bt.cryptography.MainActivity;
import aea.bt.cryptography.R;
import aea.bt.cryptography.manager_lesson.manager_many_lesson;
import aea.bt.cryptography.manager_lesson.read_manager_lesson;
import aea.bt.cryptography.manager_lesson.write_manager_lesson;
import aea.bt.cryptography.menu.Lesson_activity;
import aea.bt.cryptography.music.HomeWatcher;
import aea.bt.cryptography.music.MusicService;

public class pdf_many_lesson extends AppCompatActivity {
    HomeWatcher mHomeWatcher;
    String textScroll = "ສາມາດເລື່ອນລົງເພື່ອເບີ່ງໜ້າຕໍ່ໄປ";
    PDFView pdfView;
    Button play, next_play;
    Vibrator vibrator;
    public static int class_pdf_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_many_lesson);
        doBindService();
        pdfView = findViewById(R.id.pdfView);
        play = findViewById(R.id.play);
        next_play = findViewById(R.id.play_next);
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
        if (manager_many_lesson.many_classID == 1) {
            pdfView.fromAsset("laos_language_lesson_1.pdf").load();
            class_pdf_ID = 1;
            Toast.makeText(getApplicationContext(), textScroll, Toast.LENGTH_LONG).show();
        } else if (manager_many_lesson.many_classID == 2) {
            class_pdf_ID = 2;
            pdfView.fromAsset("laos_language_lesson_2.pdf").load();
        } else if (manager_many_lesson.many_classID == 3) {
            class_pdf_ID = 3;
            pdfView.fromAsset("laos_language_lesson_3.pdf").load();
        } else if (manager_many_lesson.many_classID == 4) {
            class_pdf_ID = 4;
            pdfView.fromAsset("laos_language_lesson_4.pdf").load();
            Toast.makeText(getApplicationContext(), textScroll, Toast.LENGTH_LONG).show();
        } else if (manager_many_lesson.many_classID == 5) {
            class_pdf_ID = 5;
            pdfView.fromAsset("laos_language_lesson_5.pdf").load();
            Toast.makeText(getApplicationContext(), textScroll, Toast.LENGTH_LONG).show();
        } else if (manager_many_lesson.many_classID == 6) {
            class_pdf_ID = 6;
            pdfView.fromAsset("laos_language_lesson_6.pdf").load();

        } else if (manager_many_lesson.many_classID == 7) {
            class_pdf_ID = 7;
            pdfView.fromAsset("laos_language_lesson_7.pdf").load();
            Toast.makeText(getApplicationContext(), textScroll, Toast.LENGTH_LONG).show();
        } else if (manager_many_lesson.many_classID == 8) {
            class_pdf_ID = 8;
            pdfView.fromAsset("laos_language_lesson_8.pdf").load();
        } else if (manager_many_lesson.many_classID == 9) {
            class_pdf_ID = 9;
            pdfView.fromAsset("laos_language_lesson_9.pdf").load();
        } else if (manager_many_lesson.many_classID == 10) {
            class_pdf_ID = 10;
            pdfView.fromAsset("laos_language_lesson_10.pdf").load();
        } else if (manager_many_lesson.many_classID == 11) {
            class_pdf_ID = 11;
            pdfView.fromAsset("laos_language_lesson_11.pdf").load();
        } else if (manager_many_lesson.many_classID == 12) {
            class_pdf_ID = 12;
            pdfView.fromAsset("laos_language_lesson_12.pdf").load();
        } else if (manager_many_lesson.many_classID == 15) {
            class_pdf_ID = 15;
            pdfView.fromAsset("laos_language_lesson_15.pdf").load();
        } else if (manager_many_lesson.many_classID == 16) {
            class_pdf_ID = 16;
            pdfView.fromAsset("laos_language_lesson_16.pdf").load();
        } else if (manager_many_lesson.many_classID == 17) {
            class_pdf_ID = 17;
            pdfView.fromAsset("laos_language_lesson_17.pdf").load();
        } else if (manager_many_lesson.many_classID == 18) {
            class_pdf_ID = 18;
            pdfView.fromAsset("laos_language_lesson_18.pdf").load();
        } else if (manager_many_lesson.many_classID == 19) {
            class_pdf_ID = 19;
            pdfView.fromAsset("laos_language_lesson_19.pdf").load();
        } else if (manager_many_lesson.many_classID == 20) {
            class_pdf_ID = 20;
            pdfView.fromAsset("laos_language_lesson_20.pdf").load();
        } else if (manager_many_lesson.many_classID == 21) {
            class_pdf_ID = 21;
            pdfView.fromAsset("laos_language_lesson_21.pdf").load();
        } else if (manager_many_lesson.many_classID == 22) {
            class_pdf_ID = 22;
            pdfView.fromAsset("laos_language_lesson_22.pdf").load();
        } else if (manager_many_lesson.many_classID == 23) {
            class_pdf_ID = 23;
            pdfView.fromAsset("laos_language_lesson_23.pdf").load();
        } else if (manager_many_lesson.many_classID == 24) {
            class_pdf_ID = 24;
            pdfView.fromAsset("laos_language_lesson_24.pdf").load();
        } else if (manager_many_lesson.many_classID == 25) {
            class_pdf_ID = 25;
            pdfView.fromAsset("laos_language_lesson_25.pdf").load();
        } else if (manager_many_lesson.many_classID == 26) {
            class_pdf_ID = 26;
            pdfView.fromAsset("laos_language_lesson_26.pdf").load();
        } else if (manager_many_lesson.many_classID == 29) {
            class_pdf_ID = 29;
            pdfView.fromAsset("laos_language_lesson_29.pdf").load();
        } else if (manager_many_lesson.many_classID == 30) {
            class_pdf_ID = 30;
            pdfView.fromAsset("laos_language_lesson_30.pdf").load();
        } else if (manager_many_lesson.many_classID == 31) {
            class_pdf_ID = 31;
            pdfView.fromAsset("laos_language_lesson_31.pdf").load();
        } else if (manager_many_lesson.many_classID == 32) {
            class_pdf_ID = 32;
            pdfView.fromAsset("laos_language_lesson_32.pdf").load();
        } else if (manager_many_lesson.many_classID == 33) {
            class_pdf_ID = 33;
            pdfView.fromAsset("laos_language_lesson_33.pdf").load();
        } else if (manager_many_lesson.many_classID == 34) {
            class_pdf_ID = 34;
            pdfView.fromAsset("laos_language_lesson_34.pdf").load();
        } else if (manager_many_lesson.many_classID == 35) {
            class_pdf_ID = 35;
            pdfView.fromAsset("laos_language_lesson_35.pdf").load();
        } else if (manager_many_lesson.many_classID == 36) {
            class_pdf_ID = 36;
            pdfView.fromAsset("laos_language_lesson_36.pdf").load();
        } else if (manager_many_lesson.many_classID == 37) {
            class_pdf_ID = 37;
            pdfView.fromAsset("laos_language_lesson_37.pdf").load();
        } else if (manager_many_lesson.many_classID == 38) {
            class_pdf_ID = 38;
            pdfView.fromAsset("laos_language_lesson_38.pdf").load();
        } else if (manager_many_lesson.many_classID == 39) {
            class_pdf_ID = 39;
            pdfView.fromAsset("laos_language_lesson_39.pdf").load();
        } else if (manager_many_lesson.many_classID == 40) {
            class_pdf_ID = 40;
            pdfView.fromAsset("laos_language_lesson_40.pdf").load();
        } else if (manager_many_lesson.many_classID == 41) {
            class_pdf_ID = 41;
            pdfView.fromAsset("laos_language_lesson_41.pdf").load();
        } else if (manager_many_lesson.many_classID == 42) {
            class_pdf_ID = 42;
            pdfView.fromAsset("laos_language_lesson_42.pdf").load();
        } else if (manager_many_lesson.many_classID == 45) {
            class_pdf_ID = 45;
            pdfView.fromAsset("laos_language_lesson_45.pdf").load();
        } else if (manager_many_lesson.many_classID == 46) {
            class_pdf_ID = 46;
            pdfView.fromAsset("laos_language_lesson_46.pdf").load();
        } else if (manager_many_lesson.many_classID == 47) {
            class_pdf_ID = 47;
            pdfView.fromAsset("laos_language_lesson_47.pdf").load();
        } else if (manager_many_lesson.many_classID == 48) {
            class_pdf_ID = 48;
            pdfView.fromAsset("laos_language_lesson_48.pdf").load();
        } else if (manager_many_lesson.many_classID == 49) {
            class_pdf_ID = 49;
            pdfView.fromAsset("laos_language_lesson_49.pdf").load();
        } else if (manager_many_lesson.many_classID == 50) {
            class_pdf_ID = 50;
            pdfView.fromAsset("laos_language_lesson_50.pdf").load();
        } else if (manager_many_lesson.many_classID == 51) {
            class_pdf_ID = 51;
            pdfView.fromAsset("laos_language_lesson_51.pdf").load();
        } else if (manager_many_lesson.many_classID == 52) {
            class_pdf_ID = 52;
            pdfView.fromAsset("laos_language_lesson_52.pdf").load();
        } else if (manager_many_lesson.many_classID == 53) {
            class_pdf_ID = 53;
            pdfView.fromAsset("laos_language_lesson_53.pdf").load();
        } else if (manager_many_lesson.many_classID == 54) {
            class_pdf_ID = 54;
            pdfView.fromAsset("laos_language_lesson_54.pdf").load();
        } else if (manager_many_lesson.many_classID == 55) {
            class_pdf_ID = 55;
            pdfView.fromAsset("laos_language_lesson_55.pdf").load();
        } else if (manager_many_lesson.many_classID == 56) {
            class_pdf_ID = 56;
            pdfView.fromAsset("laos_language_lesson_56.pdf").load();
        }
        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.showgame);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCancelable(false);
                dialog.show();
                Button Read = dialog.findViewById(R.id.btnread);
                Button Garmar = dialog.findViewById(R.id.btngramar);
                Button Write = dialog.findViewById(R.id.btnwrite);
                Button cansel = dialog.findViewById(R.id.can);
                cansel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                Read.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mServ != null) {
                            mServ.pauseMusic();
                        }
                        Intent intent = new Intent(pdf_many_lesson.this, Game_control_read.class);
                        startActivity(intent);
                    }
                });
                Write.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(pdf_many_lesson.this, Game_control_write.class);
                        startActivity(intent);


                    }
                });
                Garmar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mServ != null) {
                            mServ.pauseMusic();
                        }
                        Intent intent = new Intent(pdf_many_lesson.this, Noun_control.class);
                        startActivity(intent);

                    }
                });
                if (class_pdf_ID == 3) {
                    Write.setBackgroundResource(R.drawable.write_noplay);
                    Write.setEnabled(false);
                }
                if (class_pdf_ID == 6) {
                    Garmar.setBackgroundResource(R.drawable.noun_noplay);
                    Garmar.setEnabled(false);
                }
                if (class_pdf_ID == 7) {
                    Garmar.setBackgroundResource(R.drawable.noun_noplay);
                    Garmar.setEnabled(false);
                }
                if (class_pdf_ID == 8) {
                    Garmar.setBackgroundResource(R.drawable.noun_noplay);
                    Garmar.setEnabled(false);
                }
                if (class_pdf_ID == 10) {
                    Write.setBackgroundResource(R.drawable.write_noplay);
                    Write.setEnabled(false);
                }
                if (class_pdf_ID == 12) {
                    Write.setBackgroundResource(R.drawable.write_noplay);
                    Write.setEnabled(false);
                }
                for (int i = 13; i < 56; i++) {
                    if (class_pdf_ID == i) {
                        Garmar.setBackgroundResource(R.drawable.noun_noplay);
                        Garmar.setEnabled(false);
                        Write.setBackgroundResource(R.drawable.write_noplay);
                        Write.setEnabled(false);
                        Read.setBackgroundResource(R.drawable.write_noplay);
                        Read.setEnabled(false);
                    }
                }

            }
        });
        next_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager_many_lesson.many_classID++;
                Intent intent = new Intent(getApplicationContext(), pdf_many_lesson.class);
                startActivity(intent);

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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(pdf_many_lesson.this, manager_many_lesson.class);
        startActivity(intent);
        finish();
    }

}