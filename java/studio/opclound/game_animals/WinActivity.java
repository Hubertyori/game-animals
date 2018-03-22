package studio.opclound.game_animals;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {
    public static Typeface typeface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        typeface= Typeface.createFromAsset(getAssets(),"Fonts/font_one.TTF");
        TextView tex = (TextView) findViewById(R.id.textWin);
        tex.setTypeface(typeface);
        Button btn = (Button) findViewById(R.id.btn_playagain);
        btn.setTypeface(typeface);
    }

    public void clkPlayagain(View view) {
        Intent intent = new Intent(WinActivity.this,MainActivity.class);
        startActivity(intent);
        WinActivity.this.finish();
    }
}
