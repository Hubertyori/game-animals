package studio.opclound.game_animals;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static Typeface typeface;
    String AImage[] = new String[]{"flower", "bird", "cat", "fish", "honey", "house", "pig", "sun"};
    Integer APath[] = new Integer[]{R.drawable.flower, R.drawable.bird, R.drawable.cat, R.drawable.fish,
            R.drawable.honey, R.drawable.house, R.drawable.pig, R.drawable.sun};
    Integer ImageNum = 8;
    int choosenum;
    int[] ImageInt = new int[4];
    int wincount = 0;
    int losecount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        //获取传递的值
        int winint = intent.getIntExtra("windata",0);
        int loseint = intent.getIntExtra("losedata",0);
        wincount = winint;
        losecount = loseint;
        TextView Count = findViewById(R.id.losecount);
        Count.setText(String.valueOf(losecount));
        Count = findViewById(R.id.wincount);
        Count.setText(String.valueOf(wincount));

        typeface = Typeface.createFromAsset(getAssets(), "Fonts/font_one.TTF");
        TextView tex = findViewById(R.id.textView);
        tex.setTypeface(typeface);
        tex = findViewById(R.id.textView);
        tex.setTypeface(typeface);
        ImageInt = mysetImage();
        ImageButton ImgButton = findViewById(R.id.BIRD);
        ImgButton.setImageResource(APath[ImageInt[0]]);
        ImgButton = findViewById(R.id.SUN);
        ImgButton.setImageResource(APath[ImageInt[1]]);
        ImgButton = findViewById(R.id.HOUSE);
        ImgButton.setImageResource(APath[ImageInt[2]]);
        ImgButton = findViewById(R.id.FISH);
        ImgButton.setImageResource(APath[ImageInt[3]]);

        Random random = new Random();
        int sttint = random.nextInt(3);
        TextView text = findViewById(R.id.textView);
        choosenum = ImageInt[sttint];
        text.setText(AImage[choosenum]);
    }

    private int[] mysetImage() {
        Random random = new Random();
        int tempint[] = new int[4];
        for (int i = 0; i < 4; i++) {
            tempint[i] = random.nextInt(ImageNum);
        }
        tempint = chickIntArry(tempint);
        return tempint;
    }

    private int[] chickIntArry(int[] tempint) {
        Random random = new Random();
        for (int i = 0; i < tempint.length; i++) {
            for (int j = i + 1; j < tempint.length; j++) {
                if (tempint[i] == tempint[j]) {
                    tempint[i] = random.nextInt(ImageNum);
                    chickIntArry(tempint);
                }
            }
        }
        return tempint;
    }

    public void clkfish(View view) {
        if (choosenum == ImageInt[3]) {
            guseRight();
        } else {
            guseError();
        }
    }

    public void clkhouse(View view) {
        if (choosenum == ImageInt[2]) {
            guseRight();
        } else {
            guseError();
        }
    }

    public void clksun(View view) {
        if (choosenum == ImageInt[1]) {
            guseRight();
        } else {
            guseError();
        }
    }

    public void clkbird(View view) {

        if (choosenum == ImageInt[0]) {
            guseRight();
        } else {
            guseError();

        }
    }

    public void guseError() {
        losecount++;
        Intent itent = new Intent();
        itent.setClass(MainActivity.this, LoseActivity.class);
        itent.putExtra("windata",wincount);
        itent.putExtra("losedata",losecount);
        startActivity(itent);
        MainActivity.this.finish();
    }

    public void guseRight() {
        wincount++;
        Intent itent = new Intent();
        itent.setClass(MainActivity.this, WinActivity.class);
        itent.putExtra("windata",wincount);
        itent.putExtra("losedata",losecount);
        startActivity(itent);
        MainActivity.this.finish();
    }
}
