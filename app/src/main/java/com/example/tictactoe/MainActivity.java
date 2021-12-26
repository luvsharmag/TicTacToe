package com.example.tictactoe;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winposition = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}
            , {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}};
    int activeplayer = 0;
    boolean gameActive = true;
    public void playertap(View view) {
        ImageView img = (ImageView) view;
        int tapimage = Integer.parseInt(img.getTag().toString());
        if (gamestate[tapimage] == 2) {
            gamestate[tapimage] = activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer == 0) {
                img.setImageResource(R.drawable.x);
                TextView status  = findViewById(R.id.textView2);
                status.setText("O's turn");
                activeplayer = 1;
            } else {
                img.setImageResource(R.drawable.o);
                TextView status = findViewById(R.id.textView2);
                status.setText("X's turn");
                activeplayer = 0;
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for (int[] winpositions : winposition) {
            if (gamestate[winpositions[0]] == gamestate[winpositions[1]] &&
                    gamestate[winpositions[1]] == gamestate[winpositions[2]] && gamestate[winpositions[0]] != 2) {
                String winstr;
                gameActive = false;
                if (gamestate[winpositions[0]] == 0) {
                    winstr = "X's win";

                } else {
                    winstr = "0's win";
                }
                TextView status = findViewById(R.id.textView2);
                status.setText(winstr);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
