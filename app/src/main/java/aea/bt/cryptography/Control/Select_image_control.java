package aea.bt.cryptography.Control;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

import aea.bt.cryptography.Database.DatabaseHelper2;
import aea.bt.cryptography.MainActivity;
import aea.bt.cryptography.R;
import aea.bt.cryptography.manager_lesson.noun_manager_lesson;
import aea.bt.cryptography.menu.Game_brain;

public class Select_image_control extends AppCompatActivity {
    private ImageView question;
    private Button ansbut1, ansbut2, ansbut3;
    RelativeLayout r;
    int gameID, dfID;
    private TextView countLabel;
    public String text = "ກະລຸນາຫລີ້ນເກມໃຫ້ຈົບກ່ອນ";
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
    ImageView nextqs;
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

            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.music_ingame);
            }
            setContentView(R.layout.select_image_control);
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            XML();

        }
    }
    private void XML() {
        timer = findViewById(R.id.time_bar_text);
        textColorDefaultCd = timer.getTextColors();
        ansbut1 = findViewById(R.id.qu1);
        ansbut2 = findViewById(R.id.qu2);
        ansbut3 = findViewById(R.id.qu3);
        nextqs = findViewById(R.id.btnnext);
        r = findViewById(R.id.show_t_and_f);
        question = findViewById(R.id.question);
        countLabel = findViewById(R.id.countLabel);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        textColorDefaultCd = timer.getTextColors();
        DatabaseHelper2 db = new DatabaseHelper2(this);
        gameID = getIntent().getIntExtra("gameID", 0);
        dfID = getIntent().getIntExtra("dfID", 0);
        arrayQuiz = db.getAllQuiz(gameID, dfID);
        COUNTDOWN_IN_MILLIS = 15000;
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
        ansbut1.setBackgroundResource(getResources().getIdentifier(ranQuiz.get(0), "drawable", getPackageName()));
        ansbut2.setBackgroundResource(getResources().getIdentifier(ranQuiz.get(1), "drawable", getPackageName()));
        ansbut3.setBackgroundResource(getResources().getIdentifier(ranQuiz.get(2), "drawable", getPackageName()));
        arrayQuiz.remove(randomNum);
        timeLeftInmillis = COUNTDOWN_IN_MILLIS;
        StartCountDown();
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

    public static int randInt(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
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


    public void Check(View view) {
        vibrator.vibrate(50);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.blink_anim);
        view.startAnimation(animation);
        countDownTimer.cancel();
        TextView answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        if (btnText.equals(rightanswer)) {
            Correct();
            trueAns();

            rightanswerCount++;
        } else {
            Wring();
            falseans();
        }

    }

    public void falseans() {
        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pop_up_score1);
        nextqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quizCount == Quiz_Count) {
                    TextView Score = dialog.findViewById(R.id.Score);
                    ImageView btn_home = dialog.findViewById(R.id.btn_pop_home);
                    ImageView btn_return = dialog.findViewById(R.id.btn_pop_Return);
                    int score = getIntent().getIntExtra("rightanswerCount", rightanswerCount);
                    Score.setText(score + "/10");
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.setCancelable(false);
                    dialog.show();
                    btn_home.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(Select_image_control.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    btn_return.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(),Select_image_control.class);
                            startActivity(intent);finish();
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
                    r.setBackgroundResource(R.drawable.bg_color_nocolor);
                    nextqs.setBackgroundResource(R.drawable.bg_color_nocolor);
                    ansbut1.setEnabled(true);
                    ansbut2.setEnabled(true);
                    ansbut3.setEnabled(true);
                    quizCount++;
                    showNextQuiz();
                }
            }
        });

        r.setBackgroundResource(R.drawable.pop_up_dialog_false);
        nextqs.setBackgroundResource(R.drawable.next_qs);
        ansbut1.setEnabled(false);
        ansbut2.setEnabled(false);
        ansbut3.setEnabled(false);


    }
    public void Correct() {
        soundPool.play(correct, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void Wring() {
        soundPool.play(wrong, 1.0f, 1.0f, 1, 0, 1.0f);

    }
    private void trueAns() {
        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pop_up_score);
        nextqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView Score = dialog.findViewById(R.id.Score);
                if (quizCount == Quiz_Count) {
                    int score = getIntent().getIntExtra("rightanswerCount", rightanswerCount);
                    Score.setText(score + "/10");
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.setCancelable(false);
                    dialog.show();
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
                    r.setBackgroundResource(R.drawable.bg_color_nocolor);
                    nextqs.setBackgroundResource(R.drawable.bg_color_nocolor);
                    ansbut1.setEnabled(true);
                    ansbut2.setEnabled(true);
                    ansbut3.setEnabled(true);
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        r.setBackgroundResource(R.drawable.pop_up_dialog_true);
        nextqs.setBackgroundResource(R.drawable.next_qs);
        ansbut1.setEnabled(false);
        ansbut2.setEnabled(false);
        ansbut3.setEnabled(false);

    }

    @Override
    public void onBackPressed() {


        final Dialog dialog = new Dialog(Select_image_control.this);
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
                Intent intent = new Intent(Select_image_control.this, Game_brain.class);
                startActivity(intent);finish();
            }
        });
    }

}