package aea.bt.cryptography.Control;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import aea.bt.cryptography.Database.DatabaseHelper;
import aea.bt.cryptography.Database.DatabaseHelper1;
import aea.bt.cryptography.MainActivity;
import aea.bt.cryptography.R;
import aea.bt.cryptography.manager_lesson.read_manager_lesson;
import aea.bt.cryptography.manager_lesson.write_manager_lesson;
import aea.bt.cryptography.pdf.pdf1_lesson;
import aea.bt.cryptography.pdf.pdf_lesson;
import aea.bt.cryptography.pdf.pdf_many_lesson;

public class Game_control_write extends AppCompatActivity {
    private Button btn_ok;
    RelativeLayout r;
    public String text = "ກະລຸນາຫລີ້ນເກມໃຫ້ຈົບກ່ອນ";
    EditText txt_input_write;
    int sound;
    ImageView btnNext, q, m;
    int gameID, dfID;
    private TextView countLabel;
    private int quizCount = 1;
    final static private int Quiz_Count = 10;
    String rightanswer;
    Vibrator vibrator;
    //_____time COUNTDOWN _______
    private static long COUNTDOWN_IN_MILLIS;
    private ColorStateList textColorDefaultCd;
    private TextView timer;
    private CountDownTimer countDownTimer;
    private long timeLeftInmillis;
    ArrayList<ArrayList<String>> arrayQuiz = new ArrayList<>();
    private AudioAttributes audioAttributes;
    SoundPool soundPool;
    final int SOUND_POOL_MAX = 2;
    private int wrong, correct;
    MediaPlayer mediaPlayer;
    private int rightanswerCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (MainActivity.numberOpen == 1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                audioAttributes = new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_GAME)
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build();

                soundPool = new SoundPool.Builder()
                        .setAudioAttributes(audioAttributes)
                        .setMaxStreams(SOUND_POOL_MAX)
                        .build();
            } else {
                soundPool = new SoundPool(SOUND_POOL_MAX, AudioManager.STREAM_MUSIC, 0);
            }
            wrong = soundPool.load(this, R.raw.wrong, 1);
            correct = soundPool.load(this, R.raw.correct, 1);
        }
        setContentView(R.layout.game_control_write);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        Xml();

    }


    @Override
    public void onBackPressed() {
        final Dialog dialog = new Dialog(Game_control_write.this);
        dialog.setContentView(R.layout.pop_up_exit);
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
                Intent intent = new Intent(Game_control_write.this, write_manager_lesson.class);
                startActivity(intent);
            }
        });
    }

    private void Xml() {
        q = findViewById(R.id.question);
        r = findViewById(R.id.show_t_and_f);
        countLabel = findViewById(R.id.countLabel);
        txt_input_write = findViewById(R.id.txt_input_write);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        btn_ok = findViewById(R.id.btn_test);
        timer = findViewById(R.id.time_bar_text);
        m = findViewById(R.id.model_test);
        textColorDefaultCd = timer.getTextColors();
        btnNext = findViewById(R.id.btn_next);
        DatabaseHelper1 db = new DatabaseHelper1(this);
        if (write_manager_lesson.classID_write== 1 || pdf_many_lesson.class_pdf_ID == 1) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 1);
        } else if (write_manager_lesson.classID_write==  2 || pdf_many_lesson.class_pdf_ID == 2) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 2);
        }else if (write_manager_lesson.classID_write==  4 || pdf_many_lesson.class_pdf_ID == 4) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 4);
        }else if (write_manager_lesson.classID_write==  5 || pdf_many_lesson.class_pdf_ID == 5) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 5);
        }else if (write_manager_lesson.classID_write==  6 || pdf_many_lesson.class_pdf_ID == 6) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 6);
        }else if (write_manager_lesson.classID_write==  7 || pdf_many_lesson.class_pdf_ID == 7) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 7);
        }else if (write_manager_lesson.classID_write==  8 || pdf_many_lesson.class_pdf_ID == 8) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 8);
        }else if (write_manager_lesson.classID_write==  9 || pdf_many_lesson.class_pdf_ID == 9) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 9);
        }else if (write_manager_lesson.classID_write==  11 || pdf_many_lesson.class_pdf_ID == 11) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 11);
        }
        arrayQuiz = db.getAllEditQuiz(gameID, dfID);
        COUNTDOWN_IN_MILLIS = 60000;
        showNextQuiz();

    }


    public void showNextQuiz() {
        txt_input_write.setText("");
        countLabel.setText(+quizCount + "/10");
        int randomNum = randInt(arrayQuiz.size());
        ArrayList<String> ranQuiz = arrayQuiz.get(randomNum);
        sound = getResources().getIdentifier(ranQuiz.get(0), "raw", getPackageName());
        rightanswer = ranQuiz.get(1);
        arrayQuiz.remove(randomNum);
        timeLeftInmillis = COUNTDOWN_IN_MILLIS;
        StartCountDown();

    }

    public static int randInt(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    public void StartCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInmillis, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInmillis = l;
                upDateCountDownText();

            }

            @Override
            public void onFinish() {
                timeLeftInmillis = 0;
                upDateCountDownText();
                falseans();

            }
        }.start();
    }

    public void upDateCountDownText() {
        int minutes = (int) (timeLeftInmillis / 1000) / 60;
        int second = (int) (timeLeftInmillis / 1000) % 60;

        String timeFormattted = String.format(Locale.getDefault(), "%2d:%02d", minutes, second);
        timer.setText(timeFormattted);
        if (timeLeftInmillis < 10000) {
            timer.setTextColor(Color.RED);
        } else {
            timer.setTextColor(textColorDefaultCd);
        }
    }

    public void checkAnswer(View view) {
        vibrator.vibrate(50);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
        view.startAnimation(animation);
        countDownTimer.cancel();
        String RightAnswer = txt_input_write.getText().toString();
        if (RightAnswer.equals(rightanswer)) {
            Correct();
            trueAns();


            rightanswerCount++;
        } else {
            Wring();
            falseans();

        }
    }

    public void play(View v) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, sound);
            mediaPlayer.setLooping(false);
            mediaPlayer.setVolume(50, 50);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();

                }
            });
            mediaPlayer.start();
        }

    }

    public void Correct() {
        soundPool.play(correct, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void Wring() {
        soundPool.play(wrong, 1.0f, 1.0f, 1, 0, 1.0f);

    }

    private void trueAns() {
        final Dialog a = new Dialog(Game_control_write.this);
        a.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        a.setContentView(R.layout.pop_up_score);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView btn_home = a.findViewById(R.id.btn_pop_home);
                ImageView btn_return = a.findViewById(R.id.btn_pop_Return);
                TextView Score = a.findViewById(R.id.Score);
                if (quizCount == Quiz_Count) {
                    int score = getIntent().getIntExtra("rightanswerCount", rightanswerCount);
                    Score.setText(score + "/10");
                    a.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    a.setCancelable(false);
                    a.show();
                    if (write_manager_lesson.classID_write == 1|| pdf_many_lesson.class_pdf_ID == 1) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys1", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (write_manager_lesson.classID_write == 2|| pdf_many_lesson.class_pdf_ID == 2) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys2", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (write_manager_lesson.classID_write == 4|| pdf_many_lesson.class_pdf_ID == 4) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys4", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (write_manager_lesson.classID_write == 5|| pdf_many_lesson.class_pdf_ID == 5) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys5", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (write_manager_lesson.classID_write == 6|| pdf_many_lesson.class_pdf_ID == 6) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys6", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (write_manager_lesson.classID_write == 7|| pdf_many_lesson.class_pdf_ID == 7) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys7", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (write_manager_lesson.classID_write == 8|| pdf_many_lesson.class_pdf_ID == 8) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys8", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (write_manager_lesson.classID_write == 9|| pdf_many_lesson.class_pdf_ID == 9) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys9", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (write_manager_lesson.classID_write == 11|| pdf_many_lesson.class_pdf_ID == 11) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys11", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    }
                    btn_home.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent home = new Intent(Game_control_write.this, write_manager_lesson.class);
                            startActivity(home);
                        }
                    });
                    btn_return.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (write_manager_lesson.classID_write == 0) {
                                Intent a = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(a);
                                finish();
                            } else if (write_manager_lesson.classID_write == 1) {
                                Intent b = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(b);
                                finish();
                            } else if (write_manager_lesson.classID_write == 2) {
                                Intent c = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(c);
                                finish();
                            } else if (write_manager_lesson.classID_write == 3) {
                                Intent c = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(c);
                                finish();
                            }  else if (write_manager_lesson.classID_write == 5) {
                                Intent c = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(c);
                                finish();
                            } else if (write_manager_lesson.classID_write == 6) {
                                Intent c = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(c);
                                finish();
                            } else if (write_manager_lesson.classID_write == 7) {
                                Intent c = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(c);
                                finish();
                            } else if (write_manager_lesson.classID_write == 8) {
                                Intent c = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(c);
                                finish();
                            } else if (write_manager_lesson.classID_write == 9) {
                                Intent c = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(c);
                                finish();
                            }  else if (write_manager_lesson.classID_write == 11) {
                                Intent c = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(c);
                                finish();
                            }
                        }
                    });
                } else {
                    quizCount++;
                    r.setBackgroundResource(R.drawable.bg_color_nocolor);
                    btnNext.setBackgroundResource(R.drawable.bg_color_nocolor);
                    showNextQuiz();
                    m.setBackgroundResource(R.drawable.test);
                    btn_ok.setEnabled(true);
                    txt_input_write.setEnabled(true);
                    q.setEnabled(true);
                    btnNext.setEnabled(false);

                }
            }
        });
        r.setBackgroundResource(R.drawable.pop_up_dialog_true);
        btnNext.setBackgroundResource(R.drawable.next_qs);
        btn_ok.setEnabled(false);
        txt_input_write.setEnabled(false);
        btnNext.setEnabled(true);
        q.setEnabled(false);
        m.setBackgroundResource(R.drawable.test1);

    }

    public void falseans() {
        final Dialog a = new Dialog(Game_control_write.this);
        a.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        a.setContentView(R.layout.pop_up_score);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView btn_home = a.findViewById(R.id.btn_pop_home);
                ImageView btn_return = a.findViewById(R.id.btn_pop_Return);
                TextView Score = a.findViewById(R.id.Score);
                if (quizCount == Quiz_Count) {
                    int score = getIntent().getIntExtra("rightanswerCount", rightanswerCount);
                    Score.setText(score + "/10");
                    a.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    a.setCancelable(false);
                    a.show();
                    if (write_manager_lesson.classID_write == 1|| pdf_many_lesson.class_pdf_ID == 1) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys1", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (write_manager_lesson.classID_write == 2|| pdf_many_lesson.class_pdf_ID == 2) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys2", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (write_manager_lesson.classID_write == 4|| pdf_many_lesson.class_pdf_ID == 4) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys4", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (write_manager_lesson.classID_write == 5|| pdf_many_lesson.class_pdf_ID == 5) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys5", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (write_manager_lesson.classID_write == 6|| pdf_many_lesson.class_pdf_ID == 6) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys6", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (write_manager_lesson.classID_write == 7|| pdf_many_lesson.class_pdf_ID == 7) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys7", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (write_manager_lesson.classID_write == 8|| pdf_many_lesson.class_pdf_ID == 8) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys8", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (write_manager_lesson.classID_write == 9|| pdf_many_lesson.class_pdf_ID == 9) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys9", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (write_manager_lesson.classID_write == 11|| pdf_many_lesson.class_pdf_ID == 11) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKeys11", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    }
                    btn_home.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent home = new Intent(Game_control_write.this, write_manager_lesson.class);
                            startActivity(home);
                        }
                    });
                    btn_return.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (write_manager_lesson.classID_write == 0) {
                                Intent a = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(a);
                                finish();
                            } else if (write_manager_lesson.classID_write == 1) {
                                Intent b = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(b);
                                finish();
                            } else if (write_manager_lesson.classID_write == 2) {
                                Intent c = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(c);finish();
                            } else if (write_manager_lesson.classID_write == 3) {
                                Intent c = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(c);finish();
                            }  else if (write_manager_lesson.classID_write == 5) {
                                Intent c = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(c);finish();
                            } else if (write_manager_lesson.classID_write == 6) {
                                Intent c = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(c);finish();
                            } else if (write_manager_lesson.classID_write == 7) {
                                Intent c = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(c);finish();
                            } else if (write_manager_lesson.classID_write == 8) {
                                Intent c = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(c);finish();
                            } else if (write_manager_lesson.classID_write == 9) {
                                Intent c = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(c);finish();
                            }  else if (write_manager_lesson.classID_write == 11) {
                                Intent c = new Intent(getApplicationContext(), Game_control_write.class);
                                startActivity(c);finish();
                            }

                        }
                    });
                } else {
                    quizCount++;
                    r.setBackgroundResource(R.drawable.bg_color_nocolor);
                    btnNext.setBackgroundResource(R.drawable.bg_color_nocolor);
                    showNextQuiz();
                    m.setBackgroundResource(R.drawable.test);
                    btn_ok.setEnabled(true);
                    txt_input_write.setEnabled(true);
                    q.setEnabled(true);
                    btnNext.setEnabled(false);

                }
            }
        });
        m.setBackgroundResource(R.drawable.test2);
        r.setBackgroundResource(R.drawable.pop_up_dialog_false);
        btnNext.setBackgroundResource(R.drawable.next_qs);
        btn_ok.setEnabled(false);
        txt_input_write.setEnabled(false);
        q.setEnabled(false);
        btnNext.setEnabled(true);
    }

}