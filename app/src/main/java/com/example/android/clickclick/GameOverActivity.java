package com.example.android.clickclick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        displayWinner();
        playAgain();

    }

    public void displayWinner() {
        Intent winnerInfo = getIntent();
        String winnerName = winnerInfo.getStringExtra("playerWin");

        TextView textView = findViewById(R.id.winner_text_view);
        textView.setText(String.format("%s won!!", winnerName));

    }

    private void playAgain() {
        Button button = findViewById(R.id.play_again_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOverActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
