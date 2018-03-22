package studio.opclound.game_animals;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static Typeface typeface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        typeface=Typeface.createFromAsset(getAssets(),"Fonts/font_one.TTF");
        TextView tex = findViewById(R.id.textView);
        tex.setTypeface(typeface);
        tex = findViewById(R.id.textView);
        tex.setTypeface(typeface);
    }

    public void clkfish(View view) {
        Intent itent=new Intent();
        itent.setClass(MainActivity.this, LoseActivity.class);
        startActivity(itent);
        MainActivity.this.finish();
    }

    public void clkhouse(View view) {
        Intent itent=new Intent();
        itent.setClass(MainActivity.this, LoseActivity.class);
        startActivity(itent);
        MainActivity.this.finish();
    }

    public void clksun(View view) {
        Intent itent=new Intent();
        itent.setClass(MainActivity.this, WinActivity.class);
        startActivity(itent);
        MainActivity.this.finish();
    }

    public void clkbird(View view) {
        Intent itent=new Intent();
        itent.setClass(MainActivity.this, LoseActivity.class);
        startActivity(itent);
        MainActivity.this.finish();
    }
}
