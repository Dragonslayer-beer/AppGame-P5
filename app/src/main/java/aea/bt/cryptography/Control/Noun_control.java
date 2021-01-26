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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

import aea.bt.cryptography.Database.DatabaseHelper3;
import aea.bt.cryptography.MainActivity;
import aea.bt.cryptography.R;
import aea.bt.cryptography.manager_lesson.noun_manager_lesson;
import aea.bt.cryptography.manager_lesson.read_manager_lesson;
import aea.bt.cryptography.pdf.pdf2_lesson;
import aea.bt.cryptography.pdf.pdf_many_lesson;

public class Noun_control extends AppCompatActivity {
    Button text1, text2, text3, boxshow;
    ImageView qs, btnnext, model;
    RelativeLayout q;
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
    public static int scoreID;


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

            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.music_ingame);
            }
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
            wrong = soundPool.load(this, R.raw.wrong, 1);
            correct = soundPool.load(this, R.raw.correct, 1);
        }
        setContentView(R.layout.noun_control);
        XML();
    }

    private void XML() {
        text1 = findViewById(R.id.n_text1);
        text2 = findViewById(R.id.n_text2);
        text3 = findViewById(R.id.n_text3);
        timer = findViewById(R.id.time_bar_text);
        textColorDefaultCd = timer.getTextColors();
        qs = findViewById(R.id.qs_n);
        countLabel = findViewById(R.id.countLabel);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        boxshow = findViewById(R.id.box_show);
        btnnext = findViewById(R.id.btn_next);
        model = findViewById(R.id.model_show);
        q = findViewById(R.id.show_t_and_f);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        textColorDefaultCd = timer.getTextColors();
        DatabaseHelper3 db = new DatabaseHelper3(this);
        if (noun_manager_lesson.noun_classID == 1 || pdf_many_lesson.class_pdf_ID == 1) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 1);
            scoreID = 1;

        } else if (noun_manager_lesson.noun_classID == 2 || pdf_many_lesson.class_pdf_ID == 2) {
            scoreID = 2;
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 2);

        } else if (noun_manager_lesson.noun_classID == 3 || pdf_many_lesson.class_pdf_ID == 3) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 3);
            scoreID = 3;
        } else if (noun_manager_lesson.noun_classID == 4 || pdf_many_lesson.class_pdf_ID == 4) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 4);
            scoreID = 4;
        } else if (noun_manager_lesson.noun_classID == 5 || pdf_many_lesson.class_pdf_ID == 5) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 5);
            scoreID = 5;
        } else if (noun_manager_lesson.noun_classID == 9 || pdf_many_lesson.class_pdf_ID == 9) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 9);
            scoreID = 9;
        } else if (noun_manager_lesson.noun_classID == 10 || pdf_many_lesson.class_pdf_ID == 10) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 10);
            scoreID = 10;
        } else if (noun_manager_lesson.noun_classID == 11 || pdf_many_lesson.class_pdf_ID == 11) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 11);
            scoreID = 11;
        }
        arrayQuiz = db.getAllQuiz(gameID, dfID);
        COUNTDOWN_IN_MILLIS = 30000;
        showNextQuiz();
    }

    private void showNextQuiz() {
        countLabel.setText(+quizCount + "/10");
        int randomNum = randInt(arrayQuiz.size());
        ArrayList<String> ranQuiz = arrayQuiz.get(randomNum);

        qs.setImageResource(getResources().getIdentifier(ranQuiz.get(0), "drawable", getPackageName()));
        rightanswer = ranQuiz.get(1);
        ranQuiz.remove(0);

        Collections.shuffle(ranQuiz);
        text1.setText(ranQuiz.get(0));
        text2.setText(ranQuiz.get(1));
        text3.setText(ranQuiz.get(2));
        arrayQuiz.remove(randomNum);
        timeLeftInmillis = COUNTDOWN_IN_MILLIS;
        StartCountDown();
    }

    private void StartCountDown() {
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
                Wring();
                if (rightanswer == text1.getText()) {
                    text2.setBackgroundResource(R.drawable.noun_color_f);
                    text1.setBackgroundResource(R.drawable.noun_color_t);
                    text3.setBackgroundResource(R.drawable.noun_color_f);
                } else if (text2.getText() == rightanswer) {


                    text1.setBackgroundResource(R.drawable.noun_color_f);
                    text2.setBackgroundResource(R.drawable.noun_color_t);
                    text3.setBackgroundResource(R.drawable.noun_color_f);
                } else if (text3.getText() == rightanswer) {
                    text1.setBackgroundResource(R.drawable.noun_color_f);
                    text2.setBackgroundResource(R.drawable.noun_color_f);
                    text3.setBackgroundResource(R.drawable.noun_color_t);
                }

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

    @Override
    protected void onResume() {
        super.onResume();
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }

    }

    public void check_noun(View view) {
        vibrator.vibrate(50);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
        view.startAnimation(animation);
        countDownTimer.cancel();
        TextView answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        if (btnText.equals(rightanswer)) {
            trueAns();
            Correct();


            if (text1.getText() == rightanswer) {
                boxshow.setText(text1.getText());
                text1.setBackgroundResource(R.drawable.noun_color_t);
                text2.setBackgroundResource(R.drawable.noun_color_f);
                text3.setBackgroundResource(R.drawable.noun_color_f);
                boxshow.setBackgroundResource(R.drawable.noun_color_t);
            } else if (text2.getText() == rightanswer) {
                boxshow.setText(text2.getText());
                boxshow.setBackgroundResource(R.drawable.noun_color_t);
                text2.setBackgroundResource(R.drawable.noun_color_t);
                text1.setBackgroundResource(R.drawable.noun_color_f);
                text3.setBackgroundResource(R.drawable.noun_color_f);
            } else if (text3.getText() == rightanswer) {
                boxshow.setText(text3.getText());
                text3.setBackgroundResource(R.drawable.noun_color_t);
                boxshow.setBackgroundResource(R.drawable.noun_color_t);
                text1.setBackgroundResource(R.drawable.noun_color_f);
                text2.setBackgroundResource(R.drawable.noun_color_f);
            }

            rightanswerCount++;
        } else {
            Wring();
            falseans();
            if (rightanswer == text1.getText()) {
                text2.setBackgroundResource(R.drawable.noun_color_f);
                text1.setBackgroundResource(R.drawable.noun_color_t);
                text3.setBackgroundResource(R.drawable.noun_color_f);
            } else if (text2.getText() == rightanswer) {


                text1.setBackgroundResource(R.drawable.noun_color_f);
                text2.setBackgroundResource(R.drawable.noun_color_t);
                text3.setBackgroundResource(R.drawable.noun_color_f);
            } else if (text3.getText() == rightanswer) {
                text1.setBackgroundResource(R.drawable.noun_color_f);
                text2.setBackgroundResource(R.drawable.noun_color_f);
                text3.setBackgroundResource(R.drawable.noun_color_t);
            }


        }


    }


    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }

    }

    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }


    public static int randInt(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    private void trueAns() {
        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pop_up_score);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView Score = dialog.findViewById(R.id.Score);
                ImageView btn_home = dialog.findViewById(R.id.btn_pop_home);
                ImageView btn_return = dialog.findViewById(R.id.btn_pop_Return);
                if (quizCount == Quiz_Count) {
                    int score = getIntent().getIntExtra("rightanswerCount", rightanswerCount);
                    Score.setText(score + "/10");
                    if (noun_manager_lesson.noun_classID == 1 || pdf_many_lesson.class_pdf_ID == 1) {
                        SharedPreferences prefs = getSharedPreferences("a1", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (noun_manager_lesson.noun_classID == 2 || pdf_many_lesson.class_pdf_ID == 2) {
                        SharedPreferences prefs = getSharedPreferences("a2", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (noun_manager_lesson.noun_classID == 3 || pdf_many_lesson.class_pdf_ID == 3) {
                        SharedPreferences prefs = getSharedPreferences("a3", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (noun_manager_lesson.noun_classID == 4 || pdf_many_lesson.class_pdf_ID == 4) {
                        SharedPreferences prefs = getSharedPreferences("a4", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (noun_manager_lesson.noun_classID == 5 || pdf_many_lesson.class_pdf_ID == 5) {
                        SharedPreferences prefs = getSharedPreferences("a5", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (noun_manager_lesson.noun_classID == 9 || pdf_many_lesson.class_pdf_ID == 9) {
                        SharedPreferences prefs = getSharedPreferences("a9", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (noun_manager_lesson.noun_classID == 10 || pdf_many_lesson.class_pdf_ID == 10) {
                        SharedPreferences prefs = getSharedPreferences("a10", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (noun_manager_lesson.noun_classID == 11 || pdf_many_lesson.class_pdf_ID == 11) {
                        SharedPreferences prefs = getSharedPreferences("a11", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    }


                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.setCancelable(false);
                    dialog.show();

                    btn_home.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(Noun_control.this, noun_manager_lesson.class);
                            startActivity(intent);
                        }
                    });

                    btn_return.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (read_manager_lesson.classID == 0) {
                                Intent a = new Intent(getApplicationContext(), Noun_control.class);
                                startActivity(a);
                            } else if (read_manager_lesson.classID == 1) {
                                Intent b = new Intent(getApplicationContext(), Noun_control.class);
                                startActivity(b);
                            }

                        }
                    });
                } else {
                    q.setBackgroundResource(R.drawable.bg_color_nocolor);
                    btnnext.setBackgroundResource(R.drawable.bg_color_nocolor);
                    text1.setEnabled(true);
                    text2.setEnabled(true);
                    text3.setEnabled(true);
                    btnnext.setEnabled(false);
                    boxshow.setText("");
                    text1.setBackgroundResource(R.drawable.txt_noun_normal);
                    text2.setBackgroundResource(R.drawable.txt_noun_normal);
                    text3.setBackgroundResource(R.drawable.txt_noun_normal);
                    boxshow.setBackgroundResource(R.drawable.txt_input);

                    quizCount++;
                    showNextQuiz();
                }

            }
        });
        q.setBackgroundResource(R.drawable.ig_noun_t);
        btnnext.setBackgroundResource(R.drawable.next_qs);
        text1.setEnabled(false);
        btnnext.setEnabled(true);
        text2.setEnabled(false);
        text3.setEnabled(false);

    }

    private void falseans() {
        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pop_up_score);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView Score = dialog.findViewById(R.id.Score);
                ImageView btn_home = dialog.findViewById(R.id.btn_pop_home);
                ImageView btn_return = dialog.findViewById(R.id.btn_pop_Return);
                if (quizCount == Quiz_Count) {
                    int score = getIntent().getIntExtra("rightanswerCount", rightanswerCount);
                    Score.setText(score + "/10");
                    if (noun_manager_lesson.noun_classID == 1 || pdf_many_lesson.class_pdf_ID == 1) {
                        SharedPreferences prefs = getSharedPreferences("a1", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (noun_manager_lesson.noun_classID == 2 || pdf_many_lesson.class_pdf_ID == 2) {
                        SharedPreferences prefs = getSharedPreferences("a2", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (noun_manager_lesson.noun_classID == 3 || pdf_many_lesson.class_pdf_ID == 3) {
                        SharedPreferences prefs = getSharedPreferences("a3", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (noun_manager_lesson.noun_classID == 4 || pdf_many_lesson.class_pdf_ID == 4) {
                        SharedPreferences prefs = getSharedPreferences("a4", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (noun_manager_lesson.noun_classID == 5 || pdf_many_lesson.class_pdf_ID == 5) {
                        SharedPreferences prefs = getSharedPreferences("a5", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (noun_manager_lesson.noun_classID == 9 || pdf_many_lesson.class_pdf_ID == 9) {
                        SharedPreferences prefs = getSharedPreferences("a9", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (noun_manager_lesson.noun_classID == 10 || pdf_many_lesson.class_pdf_ID == 10) {
                        SharedPreferences prefs = getSharedPreferences("a10", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (noun_manager_lesson.noun_classID == 11 || pdf_many_lesson.class_pdf_ID == 11) {
                        SharedPreferences prefs = getSharedPreferences("a11", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    }


                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.setCancelable(false);
                    dialog.show();

                    btn_home.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(Noun_control.this, noun_manager_lesson.class);
                            startActivity(intent);
                        }
                    });

                    btn_return.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (read_manager_lesson.classID == 0) {
                                Intent a = new Intent(getApplicationContext(), Noun_control.class);
                                startActivity(a);
                            } else if (read_manager_lesson.classID == 1) {
                                Intent b = new Intent(getApplicationContext(), Noun_control.class);
                                startActivity(b);
                            }

                        }
                    });
                } else {
                    q.setBackgroundResource(R.drawable.bg_color_nocolor);
                    btnnext.setBackgroundResource(R.drawable.bg_color_nocolor);
                    text1.setEnabled(true);
                    text2.setEnabled(true);
                    text3.setEnabled(true);
                    btnnext.setEnabled(false);
                    boxshow.setText("");
                    text1.setBackgroundResource(R.drawable.txt_noun_normal);
                    text2.setBackgroundResource(R.drawable.txt_noun_normal);
                    text3.setBackgroundResource(R.drawable.txt_noun_normal);
                    boxshow.setBackgroundResource(R.drawable.txt_input);
                    quizCount++;
                    showNextQuiz();
                }

            }
        });
        q.setBackgroundResource(R.drawable.ig_noun_ff);
        btnnext.setBackgroundResource(R.drawable.next_qs);
        text1.setEnabled(false);
        btnnext.setEnabled(true);
        text2.setEnabled(false);
        text3.setEnabled(false);
    }

    public void Correct() {
        if (mediaPlayer != null) {
            soundPool.play(correct, 1.0f, 1.0f, 1, 0, 1.0f);
        }
    }

    public void Wring() {
        if (mediaPlayer != null) {
            soundPool.play(wrong, 1.0f, 1.0f, 1, 0, 1.0f);
        }

    }

    @Override
    public void onBackPressed() {

        final Dialog dialog = new Dialog(Noun_control.this);
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
                Intent intent = new Intent(Noun_control.this, noun_manager_lesson.class);
                startActivity(intent);
                finish();
            }
        });
    }
}