package studio.opclound.game_animals;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    public static Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        typeface=Typeface.createFromAsset(getAssets(),"Fonts/font_one.TTF");
        Button btn = (Button) findViewById(R.id.btn_play);
        btn.setTypeface(typeface);
        btn = (Button) findViewById(R.id.btn_settings);
        btn.setTypeface(typeface);
    }

    public void clkPlay(View view) {
        Intent itent=new Intent();
        itent.setClass(MenuActivity.this, MainActivity.class);
        itent.putExtra("windata",0);
        itent.putExtra("losedata",0);
        startActivity(itent);
        MenuActivity.this.finish();
    }


    public void clkExit(View view) {
        MenuActivity.this.finish();
    }
}
