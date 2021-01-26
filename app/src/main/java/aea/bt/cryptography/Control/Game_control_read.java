package aea.bt.cryptography.Control;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

import aea.bt.cryptography.Database.DatabaseHelper;
import aea.bt.cryptography.MainActivity;
import aea.bt.cryptography.R;
import aea.bt.cryptography.manager_lesson.read_manager_lesson;
import aea.bt.cryptography.manager_lesson.write_manager_lesson;
import aea.bt.cryptography.pdf.pdf_lesson;
import aea.bt.cryptography.pdf.pdf_many_lesson;

public class Game_control_read extends AppCompatActivity {
    private ImageView question, btnNext, model;
    private Button ansbut1, ansbut2, ansbut3;
    RelativeLayout r;
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
    TextView test;
    private int rightanswerCount = 0;
    public static int scoreID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_control_read);
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
        XML();
    }

    private void XML() {
        timer = findViewById(R.id.time_bar_text);
        textColorDefaultCd = timer.getTextColors();
        ansbut1 = findViewById(R.id.qu1);
        ansbut2 = findViewById(R.id.qu2);
        test = findViewById(R.id.test);
        ansbut3 = findViewById(R.id.qu3);
        model = findViewById(R.id.model_test);
        btnNext = findViewById(R.id.btn_next);
        r = findViewById(R.id.show_t_and_f);
        question = findViewById(R.id.question);
        countLabel = findViewById(R.id.countLabel);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        textColorDefaultCd = timer.getTextColors();
        DatabaseHelper db = new DatabaseHelper(this);
        if (read_manager_lesson.classID == 1 || pdf_many_lesson.class_pdf_ID == 1) {
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 0);
            test.setText("ບົດທີ່ 1");
        } else if (read_manager_lesson.classID == 2 || pdf_many_lesson.class_pdf_ID == 2) {
            test.setText("ບົດທີ່ 2");
            gameID = getIntent().getIntExtra("gameID", 0);
            dfID = getIntent().getIntExtra("dfID", 1);
        } else if (read_manager_lesson.classID == 3 || pdf_many_lesson.class_pdf_ID == 3) {
            gameID = getIntent().getIntExtra("gameID", 1);
            dfID = getIntent().getIntExtra("dfID", 0);
            test.setText("ບົດທີ່ 3");
        } else if (read_manager_lesson.classID == 4 || pdf_many_lesson.class_pdf_ID == 4) {
            gameID = getIntent().getIntExtra("gameID", 1);
            dfID = getIntent().getIntExtra("dfID", 1);
            test.setText("ບົດທີ່ 4");
        } else if (read_manager_lesson.classID == 5 || pdf_many_lesson.class_pdf_ID == 5) {
            gameID = getIntent().getIntExtra("gameID", 1);
            dfID = getIntent().getIntExtra("dfID", 2);
            test.setText("ບົດທີ່ 5");
        } else if (read_manager_lesson.classID == 6 || pdf_many_lesson.class_pdf_ID == 6) {
            gameID = getIntent().getIntExtra("gameID", 2);
            dfID = getIntent().getIntExtra("dfID", 1);
            test.setText("ບົດທີ່ 6");
        } else if (read_manager_lesson.classID == 7 || pdf_many_lesson.class_pdf_ID == 7) {
            gameID = getIntent().getIntExtra("gameID", 2);
            dfID = getIntent().getIntExtra("dfID", 2);
            test.setText("ບົດທີ່ 7");
        } else if (read_manager_lesson.classID == 8 || pdf_many_lesson.class_pdf_ID == 8) {
            gameID = getIntent().getIntExtra("gameID", 3);
            dfID = getIntent().getIntExtra("dfID", 1);
            test.setText("ບົດທີ່ 8");
        } else if (read_manager_lesson.classID == 9 || pdf_many_lesson.class_pdf_ID == 9) {
            gameID = getIntent().getIntExtra("gameID", 3);
            dfID = getIntent().getIntExtra("dfID", 2);
            test.setText("ບົດທີ່ 9");
            scoreID = 9;
        } else if (read_manager_lesson.classID == 10 || pdf_many_lesson.class_pdf_ID == 10) {
            gameID = getIntent().getIntExtra("gameID", 3);
            dfID = getIntent().getIntExtra("dfID", 3);
            test.setText("ບົດທີ່ 10");
        } else if (read_manager_lesson.classID == 11 || pdf_many_lesson.class_pdf_ID == 11) {
            gameID = getIntent().getIntExtra("gameID", 1);
            dfID = getIntent().getIntExtra("dfID", 3);
            test.setText("ບົດທີ່ 11");
        } else if (read_manager_lesson.classID ==12 || pdf_many_lesson.class_pdf_ID == 12) {
            gameID = getIntent().getIntExtra("gameID", 2);
            dfID = getIntent().getIntExtra("dfID", 3);
            test.setText("ບົດທີ່ 12");
        }
        arrayQuiz = db.getAllQuiz(gameID, dfID);
        COUNTDOWN_IN_MILLIS = 30000;

        showNextQuiz();

    }

    private void showNextQuiz() {
        countLabel.setText(+quizCount + "/10");
        int randomNum = randInt(arrayQuiz.size());
        ArrayList<String> ranQuiz = arrayQuiz.get(randomNum);

        question.setImageResource(getResources().getIdentifier(ranQuiz.get(0), "drawable", getPackageName()));
        rightanswer = ranQuiz.get(1);
        ranQuiz.remove(0);

        Collections.shuffle(ranQuiz);
        ansbut1.setText(ranQuiz.get(0));
        ansbut2.setText(ranQuiz.get(1));
        ansbut3.setText(ranQuiz.get(2));
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
                Drawable A_t = ansbut1.getContext().getResources().getDrawable(R.drawable.btn_a_t);
                Drawable B_t = ansbut1.getContext().getResources().getDrawable(R.drawable.btn_b_t);
                Drawable C_t = ansbut1.getContext().getResources().getDrawable(R.drawable.btn_c_t);
                Drawable A_f = ansbut1.getContext().getResources().getDrawable(R.drawable.btn_a_f);
                Drawable B_f = ansbut1.getContext().getResources().getDrawable(R.drawable.btn_b_f);
                Drawable C_f = ansbut1.getContext().getResources().getDrawable(R.drawable.btn_c_f);
                if (rightanswer == ansbut1.getText()) {
                    ansbut1.setCompoundDrawablesWithIntrinsicBounds(A_t, null, null, null);
                    ansbut2.setCompoundDrawablesWithIntrinsicBounds(B_f, null, null, null);
                    ansbut3.setCompoundDrawablesWithIntrinsicBounds(C_f, null, null, null);
                } else if (ansbut2.getText() == rightanswer) {

                    ansbut1.setCompoundDrawablesWithIntrinsicBounds(A_f, null, null, null);
                    ansbut2.setCompoundDrawablesWithIntrinsicBounds(B_t, null, null, null);
                    ansbut3.setCompoundDrawablesWithIntrinsicBounds(C_f, null, null, null);
                } else if (ansbut3.getText() == rightanswer) {
                    ansbut1.setCompoundDrawablesWithIntrinsicBounds(A_f, null, null, null);
                    ansbut2.setCompoundDrawablesWithIntrinsicBounds(B_f, null, null, null);
                    ansbut3.setCompoundDrawablesWithIntrinsicBounds(C_t, null, null, null);
                }

            }
        }.start();
    }

    public static int randInt(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
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

    public void Correct() {
        if (mediaPlayer != null) {
            soundPool.play(correct, 1.0f, 1.0f, 1, 0, 1.0f);
    }}

    public void Wring() {
        if (mediaPlayer != null) {
            soundPool.play(wrong, 1.0f, 1.0f, 1, 0, 1.0f);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mediaPlayer != null) {
            mediaPlayer.start();
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

    public void checkAnswer(View view) {


        vibrator.vibrate(50);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.blink_anim);
        view.startAnimation(animation);
        countDownTimer.cancel();
        TextView answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        Drawable A_t = ansbut1.getContext().getResources().getDrawable(R.drawable.btn_a_t);
        Drawable B_t = ansbut1.getContext().getResources().getDrawable(R.drawable.btn_b_t);
        Drawable C_t = ansbut1.getContext().getResources().getDrawable(R.drawable.btn_c_t);
        Drawable A_f = ansbut1.getContext().getResources().getDrawable(R.drawable.btn_a_f);
        Drawable B_f = ansbut1.getContext().getResources().getDrawable(R.drawable.btn_b_f);
        Drawable C_f = ansbut1.getContext().getResources().getDrawable(R.drawable.btn_c_f);
        if (btnText.equals(rightanswer)) {
            Correct();
            trueAns();

            if (ansbut1.getText() == rightanswer) {
                ansbut1.setCompoundDrawablesWithIntrinsicBounds(A_t, null, null, null);
                ansbut2.setCompoundDrawablesWithIntrinsicBounds(B_f, null, null, null);
                ansbut3.setCompoundDrawablesWithIntrinsicBounds(C_f, null, null, null);
            } else if (ansbut2.getText() == rightanswer) {
                ansbut1.setCompoundDrawablesWithIntrinsicBounds(A_f, null, null, null);
                ansbut2.setCompoundDrawablesWithIntrinsicBounds(B_t, null, null, null);
                ansbut3.setCompoundDrawablesWithIntrinsicBounds(C_f, null, null, null);
            } else if (ansbut3.getText() == rightanswer) {
                ansbut1.setCompoundDrawablesWithIntrinsicBounds(A_f, null, null, null);
                ansbut2.setCompoundDrawablesWithIntrinsicBounds(B_f, null, null, null);
                ansbut3.setCompoundDrawablesWithIntrinsicBounds(C_t, null, null, null);
            }

            rightanswerCount++;
        } else {
            if (soundPool != null) {
            }
            Wring();
            falseans();
            if (rightanswer == ansbut1.getText()) {
                ansbut1.setCompoundDrawablesWithIntrinsicBounds(A_t, null, null, null);
                ansbut2.setCompoundDrawablesWithIntrinsicBounds(B_f, null, null, null);
                ansbut3.setCompoundDrawablesWithIntrinsicBounds(C_f, null, null, null);
            } else if (ansbut2.getText() == rightanswer) {

                ansbut1.setCompoundDrawablesWithIntrinsicBounds(A_f, null, null, null);
                ansbut2.setCompoundDrawablesWithIntrinsicBounds(B_t, null, null, null);
                ansbut3.setCompoundDrawablesWithIntrinsicBounds(C_f, null, null, null);
            } else if (ansbut3.getText() == rightanswer) {
                ansbut1.setCompoundDrawablesWithIntrinsicBounds(A_f, null, null, null);
                ansbut2.setCompoundDrawablesWithIntrinsicBounds(B_f, null, null, null);
                ansbut3.setCompoundDrawablesWithIntrinsicBounds(C_t, null, null, null);
            }


        }


    }

    public void falseans() {

        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pop_up_score);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView Score = dialog.findViewById(R.id.Score);
                ImageView btn_home = dialog.findViewById(R.id.btn_pop_home);
                ImageView btn_return = dialog.findViewById(R.id.btn_pop_Return);
                if (quizCount == Quiz_Count) {
                    int score = getIntent().getIntExtra("rightanswerCount", rightanswerCount);
                    Score.setText(score + "/10");
                    if (read_manager_lesson.classID == 1 || pdf_many_lesson.class_pdf_ID == 1) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey1", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 2 || pdf_many_lesson.class_pdf_ID == 2) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey2", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 3 || pdf_many_lesson.class_pdf_ID == 3) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey3", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID ==4 || pdf_many_lesson.class_pdf_ID == 4) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey4", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID ==5 || pdf_many_lesson.class_pdf_ID == 5) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey5", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 6 || pdf_many_lesson.class_pdf_ID == 6) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey6", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 7 || pdf_many_lesson.class_pdf_ID == 7) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey7", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 8 || pdf_many_lesson.class_pdf_ID == 8) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey8", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 9 || pdf_many_lesson.class_pdf_ID == 9) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey9", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 10 || pdf_many_lesson.class_pdf_ID == 10) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey10", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 11 || pdf_many_lesson.class_pdf_ID == 11) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey11", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 12 || pdf_many_lesson.class_pdf_ID == 12) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey12", Context.MODE_PRIVATE);
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
                            Intent intent = new Intent(Game_control_read.this, read_manager_lesson.class);
                            startActivity(intent);
                        }
                    });
                    btn_return.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (read_manager_lesson.classID == 0) {
                                Intent a = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(a);
                            } else if (read_manager_lesson.classID == 1 || pdf_many_lesson.class_pdf_ID == 1) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                            } else if (read_manager_lesson.classID == 2 || pdf_many_lesson.class_pdf_ID == 2) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                            } else if (read_manager_lesson.classID == 3 || pdf_many_lesson.class_pdf_ID == 3) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                            } else if (read_manager_lesson.classID == 4 || pdf_many_lesson.class_pdf_ID == 4) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                            } else if (read_manager_lesson.classID == 5 || pdf_many_lesson.class_pdf_ID == 5) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                            } else if (read_manager_lesson.classID == 6 || pdf_many_lesson.class_pdf_ID == 6) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                            } else if (read_manager_lesson.classID == 7 || pdf_many_lesson.class_pdf_ID == 7) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                            } else if (read_manager_lesson.classID == 8 || pdf_many_lesson.class_pdf_ID == 8) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                            } else if (read_manager_lesson.classID == 9 || pdf_many_lesson.class_pdf_ID == 9) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                            } else if (read_manager_lesson.classID == 9 || pdf_many_lesson.class_pdf_ID == 9) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                            } else if (read_manager_lesson.classID == 9 || pdf_many_lesson.class_pdf_ID == 9) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                            } else if (read_manager_lesson.classID == 10 || pdf_many_lesson.class_pdf_ID == 10) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                            } else if (read_manager_lesson.classID == 11 || pdf_many_lesson.class_pdf_ID == 11) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                            } else if (read_manager_lesson.classID == 12 || pdf_many_lesson.class_pdf_ID == 12) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                            }

                        }
                    });
                    if (soundPool != null) {
                        try {
                            soundPool.release();
                        } finally {
                            soundPool = null;
                        }
                    }
                    if (mediaPlayer != null) {
                        try {
                            mediaPlayer.stop();
                            mediaPlayer.release();
                        } finally {
                            mediaPlayer = null;
                        }
                    }
                } else {
                    Drawable A = ansbut1.getContext().getResources().getDrawable(R.drawable.btn_a);
                    Drawable B = ansbut2.getContext().getResources().getDrawable(R.drawable.btn_b);
                    Drawable C = ansbut3.getContext().getResources().getDrawable(R.drawable.btn_c);
                    r.setBackgroundResource(R.drawable.bg_color_nocolor);
                    btnNext.setBackgroundResource(R.drawable.bg_color_nocolor);
                    model.setBackgroundResource(R.drawable.test);
                    ansbut1.setEnabled(true);
                    ansbut2.setEnabled(true);
                    ansbut3.setEnabled(true);
                    btnNext.setEnabled(false);
                    ansbut1.setCompoundDrawablesWithIntrinsicBounds(A, null, null, null);
                    ansbut2.setCompoundDrawablesWithIntrinsicBounds(B, null, null, null);
                    ansbut3.setCompoundDrawablesWithIntrinsicBounds(C, null, null, null);
                    quizCount++;
                    showNextQuiz();
                }

            }
        });
        r.setBackgroundResource(R.drawable.fluse_bg);
        btnNext.setBackgroundResource(R.drawable.next_qs);
        model.setBackgroundResource(R.drawable.test2);
        ansbut1.setEnabled(false);
        btnNext.setEnabled(true);
        ansbut2.setEnabled(false);
        ansbut3.setEnabled(false);


    }

    private void trueAns() {

        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pop_up_score);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView btn_home = dialog.findViewById(R.id.btn_pop_home);
                ImageView btn_return = dialog.findViewById(R.id.btn_pop_Return);
                TextView Score = dialog.findViewById(R.id.Score);
                if (quizCount == Quiz_Count) {
                    int score = getIntent().getIntExtra("rightanswerCount", rightanswerCount);
                    Score.setText(score + "/10");
                    if (read_manager_lesson.classID == 1 || pdf_many_lesson.class_pdf_ID == 1) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey1", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 2 || pdf_many_lesson.class_pdf_ID == 2) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey2", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 3 || pdf_many_lesson.class_pdf_ID == 3) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey3", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID ==4 || pdf_many_lesson.class_pdf_ID == 4) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey4", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID ==5 || pdf_many_lesson.class_pdf_ID == 5) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey5", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 6 || pdf_many_lesson.class_pdf_ID == 6) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey6", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 7 || pdf_many_lesson.class_pdf_ID == 7) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey7", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 8 || pdf_many_lesson.class_pdf_ID == 8) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey8", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 9 || pdf_many_lesson.class_pdf_ID == 9) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey9", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 10 || pdf_many_lesson.class_pdf_ID == 10) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey10", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 11 || pdf_many_lesson.class_pdf_ID == 11) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey11", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("rightanswerCount", score);
                        editor.commit();
                    } else if (read_manager_lesson.classID == 12 || pdf_many_lesson.class_pdf_ID == 12) {
                        SharedPreferences prefs = getSharedPreferences("myPrefsKey12", Context.MODE_PRIVATE);
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
                            Intent home = new Intent(Game_control_read.this, read_manager_lesson.class);
                            startActivity(home);
                        }
                    });
                    btn_return.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (read_manager_lesson.classID == 0) {
                                Intent a = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(a);
                                finish();
                            } else if (read_manager_lesson.classID == 1 || pdf_many_lesson.class_pdf_ID == 1) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                                finish();
                            } else if (read_manager_lesson.classID == 2 || pdf_many_lesson.class_pdf_ID == 2) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                                finish();
                            } else if (read_manager_lesson.classID == 3 || pdf_many_lesson.class_pdf_ID == 3) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                                finish();
                            } else if (read_manager_lesson.classID == 4 || pdf_many_lesson.class_pdf_ID == 4) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                                finish();
                            } else if (read_manager_lesson.classID == 5 || pdf_many_lesson.class_pdf_ID == 5) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                                finish();
                            } else if (read_manager_lesson.classID == 6 || pdf_many_lesson.class_pdf_ID == 6) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                                finish();
                            } else if (read_manager_lesson.classID == 7 || pdf_many_lesson.class_pdf_ID == 7) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                                finish();
                            } else if (read_manager_lesson.classID == 8 || pdf_many_lesson.class_pdf_ID == 8) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                                finish();
                            } else if (read_manager_lesson.classID == 9 || pdf_many_lesson.class_pdf_ID == 9) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                                finish();
                            } else if (read_manager_lesson.classID == 9 || pdf_many_lesson.class_pdf_ID == 9) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                                finish();
                            } else if (read_manager_lesson.classID == 9 || pdf_many_lesson.class_pdf_ID == 9) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                                finish();
                            } else if (read_manager_lesson.classID == 10 || pdf_many_lesson.class_pdf_ID == 10) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                                finish();
                            } else if (read_manager_lesson.classID == 11 || pdf_many_lesson.class_pdf_ID == 11) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                                finish();
                            } else if (read_manager_lesson.classID == 12 || pdf_many_lesson.class_pdf_ID == 12) {
                                Intent b = new Intent(getApplicationContext(), Game_control_read.class);
                                startActivity(b);
                                finish();
                            }

                        }
                    });
                    if (soundPool != null) {
                        try {
                            soundPool.release();
                        } finally {
                            soundPool = null;
                        }
                    }
                    if (mediaPlayer != null) {
                        try {
                            mediaPlayer.stop();
                            mediaPlayer.release();
                        } finally {
                            mediaPlayer = null;
                        }
                    }


                } else {
                    Drawable A = ansbut1.getContext().getResources().getDrawable(R.drawable.btn_a);
                    Drawable B = ansbut2.getContext().getResources().getDrawable(R.drawable.btn_b);
                    Drawable C = ansbut3.getContext().getResources().getDrawable(R.drawable.btn_c);
                    r.setBackgroundResource(R.drawable.bg_color_nocolor);
                    btnNext.setBackgroundResource(R.drawable.bg_color_nocolor);
                    ansbut1.setEnabled(true);
                    ansbut2.setEnabled(true);
                    ansbut3.setEnabled(true);
                    btnNext.setEnabled(false);
                    ansbut1.setCompoundDrawablesWithIntrinsicBounds(A, null, null, null);
                    ansbut2.setCompoundDrawablesWithIntrinsicBounds(B, null, null, null);
                    ansbut3.setCompoundDrawablesWithIntrinsicBounds(C, null, null, null);
                    model.setBackgroundResource(R.drawable.test);
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        r.setBackgroundResource(R.drawable.true_bg);
        btnNext.setBackgroundResource(R.drawable.next_qs);
        model.setBackgroundResource(R.drawable.test1);
        ansbut1.setEnabled(false);
        ansbut2.setEnabled(false);
        ansbut3.setEnabled(false);
        btnNext.setEnabled(true);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (soundPool != null) {
            try {
                soundPool.release();
            } finally {
                soundPool = null;
            }
        }

        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                mediaPlayer.release();
            } finally {
                mediaPlayer = null;
            }
        }
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override
    public void onBackPressed() {

        final Dialog dialog = new Dialog(Game_control_read.this);
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
                Intent intent = new Intent(Game_control_read.this, read_manager_lesson.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
