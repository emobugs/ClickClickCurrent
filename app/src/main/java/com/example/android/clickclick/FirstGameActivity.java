package com.example.android.clickclick;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstGameActivity extends AppCompatActivity {

    int firstPlayerPoints;
    int secondPlayerPoints;

    SoundPool mSoundPool;
    int buttonClickSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_game);

        mSoundPool = new SoundPool(7, AudioManager.STREAM_MUSIC, 0);

        firstButtonClick();
        secondButtonClick();

        Intent intent = getIntent();

        TextView blueName = findViewById(R.id.blue_player_name);
        blueName.setText(intent.getStringExtra("blueName"));


        TextView redName = findViewById(R.id.red_player_name);
        redName.setText(intent.getStringExtra("redName"));

        buttonClickSound = mSoundPool.load(getApplicationContext(), R.raw.note1_c, 1);

    }


    //    First Player Increment Points
    private void firstPlayerButton() {
        firstPlayerPoints++;
        if (firstPlayerPoints == Constants.FIRST_LEVEL_MAX_POINTS) {
//            TODO: Send view with player 1 win Text and Play AGAIN
//            TODO: Put player name as parameter - add functionality player to be able to set his name
            TextView playerName = findViewById(R.id.blue_player_name);
            gameOver(playerName.getText().toString());        }
        displayFirstPlayerResult();
        Log.d(this.getPackageName(), "firstPlayerButton method");
    }

    // Listener for click on the First Player button
    private void firstButtonClick() {
        final Button button1 = findViewById(R.id.first_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setSoundEffectsEnabled(false);
                firstPlayerButton();
                playSoundButtonClick();
            }
        });
    }

    private void displayFirstPlayerResult() {
        TextView firstPlayerText = findViewById(R.id.first_player_result_text);
        firstPlayerText.setText(String.valueOf(firstPlayerPoints));
    }


    //    Second Player Increment Points
    private void secondPlayerButton() {
        secondPlayerPoints++;
        if (secondPlayerPoints == Constants.FIRST_LEVEL_MAX_POINTS) {
//            TODO: Send view with player 1 win Text and Play AGAIN
//            TODO: Put player name as parameter - add functionality player to be able to set his name
            TextView playerName = findViewById(R.id.red_player_name);
            gameOver(playerName.getText().toString());

        }
        displaySecondPlayerResult();
        Log.d(this.getPackageName(), "firstPlayerButton method");

    }

    // Listener for click on Second Player button
    private void secondButtonClick() {
        final Button button2 = findViewById(R.id.second_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setSoundEffectsEnabled(false);
                secondPlayerButton();
                playSoundButtonClick();
            }
        });
    }

    private void displaySecondPlayerResult() {
        TextView firstPlayerText = findViewById(R.id.second_player_result_text);
        firstPlayerText.setText(String.valueOf(secondPlayerPoints));
    }


    private void gameOver(String player) {
        Intent intent = new Intent(FirstGameActivity.this, GameOverActivity.class);
        intent.putExtra("playerWin", player);
        startActivity(intent);
    }

    private void playSoundButtonClick() {
        mSoundPool.play(buttonClickSound, 1.0f, 1.0f, 0, 0, 1.0f);
    }

}
