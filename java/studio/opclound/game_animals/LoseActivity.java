package studio.opclound.game_animals;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoseActivity extends AppCompatActivity {
    public static Typeface typeface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        typeface= Typeface.createFromAsset(getAssets(),"Fonts/font_one.TTF");
        TextView tex = findViewById(R.id.textLose);
        tex.setTypeface(typeface);
        //Button btn = findViewById(R.id.btn_tryagain);
        //btn.setTypeface(typeface);
        Button btn =  findViewById(R.id.btn_tryagain);
        btn.setTypeface(typeface);
    }

    public void clkPlayagain(View view) {
        Intent intent = new Intent(LoseActivity.this,MainActivity.class);
        startActivity(intent);
        LoseActivity.this.finish();
    }
}
