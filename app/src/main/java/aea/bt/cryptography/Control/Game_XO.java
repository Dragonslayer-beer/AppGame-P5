package aea.bt.cryptography.Control;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import aea.bt.cryptography.MainActivity;
import aea.bt.cryptography.R;
import aea.bt.cryptography.manager_lesson.noun_manager_lesson;
import aea.bt.cryptography.menu.Game_brain;

public class Game_XO extends AppCompatActivity implements View.OnClickListener {
    private TextView playOneScore, playTwoScore, PlayStatus;
    private Button[] buttons = new Button[9];
    Button resetGame;
    private AudioAttributes audioAttributes;
    private int playerOneScoreCount, playerTwoScoreCount, rountCount;
    boolean activePlayer;

    // player == 0
// player == 1
    //empty => 2
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] WinningPositions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}

    };
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

            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.xo);
            }
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
            wrong = soundPool.load(this, R.raw.wrong, 1);
            correct = soundPool.load(this, R.raw.correct, 1);
        }
        setContentView(R.layout.game_x_o);

        playOneScore = (TextView) findViewById(R.id.playOnescore);
        playTwoScore = (TextView) findViewById(R.id.playTwoscore);
        PlayStatus = (TextView) findViewById(R.id.playerStatus);

        // resetGame = (Button) findViewById(R.id.ResetGame);
        for (int i = 0; i < buttons.length; i++) {
            String buttonID = "btn_" + i;
            int resourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = (Button) findViewById(resourceID);
            buttons[i].setOnClickListener(this);
        }
        rountCount = 0;
        playerTwoScoreCount = 0;
        playerOneScoreCount = 0;
        activePlayer = true;
    }

    @Override
    public void onClick(View v) {
        final Dialog dialog = new Dialog(Game_XO.this);
        dialog.setContentView(R.layout.winner);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        String buttonID = v.getResources().getResourceEntryName(v.getId());
        int gameStatePointer = Integer.parseInt(buttonID.substring(buttonID.length() - 1, buttonID.length()));//2
        if (activePlayer) {
            ((Button) v).setText("X");
            ((Button) v).setTextColor(Color.parseColor("#FFC34A"));
            gameState[gameStatePointer] = 0;


        } else {
            ((Button) v).setText("O");
            ((Button) v).setTextColor(Color.parseColor("#70FFEA"));
            gameState[gameStatePointer] = 1;
        }
        rountCount++;
        if (checkWinner()) {
            if (activePlayer) {
                playerOneScoreCount++;
                updatePlayerScore();
                Toast.makeText(this, "Player One Won!", Toast.LENGTH_SHORT).show();
                playAgain();
            } else {
                playerTwoScoreCount++;
                updatePlayerScore();
                Toast.makeText(this, "Player Two Won!", Toast.LENGTH_SHORT).show();
                playAgain();
            }
        } else if (playerOneScoreCount == 5) {
            dialog.show();
            TextView win = dialog.findViewById(R.id.playerwinner);
            ImageView home = dialog.findViewById(R.id.btn_pop_home);
            ImageView returns = dialog.findViewById(R.id.btn_pop_Return);
            win.setText("ຜູ້ຫຼີ້ນ1");
            returns.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Game_XO.this,Game_XO.class);
                    startActivity(intent);finish();
                }
            });
            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Game_XO.this,Game_brain.class);
                    startActivity(intent);finish();
                }
            });
        } else if (playerTwoScoreCount == 5) {

            dialog.show();
            TextView win = dialog.findViewById(R.id.playerwinner);
            ImageView home = dialog.findViewById(R.id.btn_pop_home);
            ImageView returns = dialog.findViewById(R.id.btn_pop_Return);
            win.setText("ຜູ້ຫຼີ້ນ2");
            returns.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Game_XO.this,Game_XO.class);
                    startActivity(intent);
                }
            });
            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Game_XO.this,Game_brain.class);
                    startActivity(intent);
                }
            });
        }else if (rountCount == 9) {
            playAgain();
            Toast.makeText(this, "No Winner ! ", Toast.LENGTH_SHORT).show();
        } else {
            activePlayer = !activePlayer;
        }
        if (playerOneScoreCount > playerTwoScoreCount) {
            PlayStatus.setText("Player One is Winning");
        } else if (playerOneScoreCount < playerTwoScoreCount) {
            PlayStatus.setText("Player Two is Winning");
        } else {
            PlayStatus.setText("");
        }

    }

    public boolean checkWinner() {
        boolean winnerResult = false;
        for (int[] winingPosion : WinningPositions) {
            if (gameState[winingPosion[0]] == gameState[winingPosion[1]] &&
                    gameState[winingPosion[1]] == gameState[winingPosion[2]] &&
                    gameState[winingPosion[0]] != 2) {
                winnerResult = true;


            }
        }
        return winnerResult;

    }

    public void updatePlayerScore() {
        playOneScore.setText(Integer.toString(playerOneScoreCount));
        playTwoScore.setText(Integer.toString(playerTwoScoreCount));
    }

    public void playAgain() {
        rountCount = 0;
        activePlayer = true;
        for (int i = 0; i < buttons.length; i++) {
            gameState[i] = 2;
            buttons[i].setText("");
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

    @Override
    public void onBackPressed() {

        final Dialog dialog = new Dialog(Game_XO.this);
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
                Intent intent = new Intent(Game_XO.this, Game_brain.class);
                startActivity(intent);
            }
        });
    }
}