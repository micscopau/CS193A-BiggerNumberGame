package paulygon.biggernumbergame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int rand1, rand2, points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //executed when app loads up
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        points = 0;
        pickRandomNumbers();
    }

    private void pickRandomNumbers(){
        //pick/generate random numbers
        Random randy = new Random();
        rand1 = randy.nextInt(10);
        while (true) {
            rand2 = randy.nextInt(10);
            if (rand2 != rand1) break;
        }

        Button lbttn = (Button) findViewById(R.id.left_button);
        Button rbttn = (Button) findViewById(R.id.right_button);

        lbttn.setText(Integer.toString(rand1));
        rbttn.setText(Integer.toString(rand2));
    }

    public void leftButtonClick(View view) {
        if (rand1 > rand2) {
            //correct
            points++;
            Toast.makeText(this, "Great job!", Toast.LENGTH_SHORT).show();
        }else{
            points--;
            Toast.makeText(this, "Aww you failed... :(", Toast.LENGTH_SHORT).show();
        }

        //update display of points
        TextView tv = (TextView) findViewById(R.id.points_field);
        tv.setText("Points: " + points);

        pickRandomNumbers();
    }

    public void rightButtonClick(View view) {
        if (rand2 > rand1) {
            //correct
            points++;
            Toast.makeText(this, "Great job!", Toast.LENGTH_SHORT).show();
        }else{
            points--;
            Toast.makeText(this, "Aww you failed... :(", Toast.LENGTH_SHORT).show();
        }

        //update display of points
        TextView tv = (TextView) findViewById(R.id.points_field);
        tv.setText("Points: " + points);

        pickRandomNumbers();

    }
}
