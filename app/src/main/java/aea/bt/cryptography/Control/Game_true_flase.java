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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import aea.bt.cryptography.Database.Database_true_fluse;
import aea.bt.cryptography.MainActivity;
import aea.bt.cryptography.R;
import aea.bt.cryptography.menu.Game_brain;

public class Game_true_flase extends AppCompatActivity {
    ImageView Emoji, question;
    ImageView btnNext;
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
    TextView Mtrue, Mfluse;
    public String text = "ກະລຸນາຫລີ້ນເກມໃຫ້ຈົບກ່ອນ";

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
        setContentView(R.layout.game_true_flase);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        XML();
        Database_true_fluse db = new Database_true_fluse(this);
        gameID = getIntent().getIntExtra("gameID", 0);
        dfID = getIntent().getIntExtra("dfID", 0);
        arrayQuiz = db.getAllQuiz(gameID, dfID);
        COUNTDOWN_IN_MILLIS = 15000;
        showNextQuiz();
    }



    private void XML() {
        Mtrue = findViewById(R.id.true_btn);
        Mfluse = findViewById(R.id.btn_false);
        Emoji = findViewById(R.id.emoji);
        question = findViewById(R.id.question);
        timer = findViewById(R.id.time_bar_text);
        countLabel = findViewById(R.id.countLabel);
        btnNext = findViewById(R.id.btn_next);
        textColorDefaultCd = timer.getTextColors();
    }

    public static int randInt(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    private void showNextQuiz() {
        countLabel.setText(+quizCount + "/10");
        int randomNum = randInt(arrayQuiz.size());
        ArrayList<String> ranQuiz = arrayQuiz.get(randomNum);
        question.setImageResource(getResources().getIdentifier(ranQuiz.get(0), "drawable", getPackageName()));
        rightanswer = "True";
        Mtrue.setText(ranQuiz.get(1));
        Mfluse.setText(ranQuiz.get(2));
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
    public void Correct() {
        soundPool.play(correct, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void Wring() {
        soundPool.play(wrong, 1.0f, 1.0f, 1, 0, 1.0f);

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

    private void trueAns() {

        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pop_up_score1);
        btnNext.setOnClickListener(new View.OnClickListener() {
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
                            Intent intent = new Intent(Game_true_flase.this, MainActivity.class);
                            startActivity(intent);finish();
                        }
                    });
                    btn_return.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), Game_true_flase.class);
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
                    Emoji.setBackgroundResource(R.drawable.emoji_normal);
                    btnNext.setBackgroundResource(R.drawable.bg_color_nocolor);
                    Mfluse.setEnabled(true);
                    Mtrue.setEnabled(true);
                    btnNext.setEnabled(false);
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        Mfluse.setEnabled(false);
        Mtrue.setEnabled(false);
        btnNext.setEnabled(true);
        Emoji.setBackgroundResource(R.drawable.emoji_smile);
        btnNext.setBackgroundResource(R.drawable.next_qs);
    }

    public void falseans() {
        final Dialog dialog = new Dialog(this);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.pop_up_score1);
        btnNext.setOnClickListener(new View.OnClickListener() {
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
                            Intent intent = new Intent(Game_true_flase.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                    btn_return.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), Game_true_flase.class);
                            startActivity(intent);
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
                    Emoji.setBackgroundResource(R.drawable.emoji_normal);
                    btnNext.setBackgroundResource(R.drawable.bg_color_nocolor);
                    Mfluse.setEnabled(true);
                    Mtrue.setEnabled(true);
                    btnNext.setEnabled(false);
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        Mfluse.setEnabled(false);
        Mtrue.setEnabled(false);
        btnNext.setEnabled(true);
        Emoji.setBackgroundResource(R.drawable.emoji_sad);
        btnNext.setBackgroundResource(R.drawable.next_qs);
    }
    @Override
    public void onBackPressed() {

        final Dialog dialog = new Dialog(Game_true_flase.this);
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

                Intent intent = new Intent(Game_true_flase.this, Game_brain.class);
                startActivity(intent);finish();
            }
        });
    }
}