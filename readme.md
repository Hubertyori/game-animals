# Animals
######Assigenment 002 #######################

![my_Game Animals](https://github.com/Hubertyori/game-animals/blob/master/SVID_20180323_225905_20180323230534.gif)

The land virsion layout

![my_Game Animals_land](https://github.com/Hubertyori/game-animals/blob/master/SVID_20180323_225946_20180323230309.gif)

I make the game changing every time, and I add two numbers, the white one is for the correct times and the other is for the wrong times.

I make my random changing function by using the following code:

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
    
And the following code is the way I transfer the number of winning times and losing times.
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
    
And when I pressed play again, I give them back.

    public void clkPlayagain(View view) {
        Intent intent = getIntent();
        //获取传递的值
        int winint = intent.getIntExtra("windata",0);
        int loseint = intent.getIntExtra("losedata",0);
        Intent myintent = new Intent(LoseActivity.this,MainActivity.class);
        myintent.putExtra("windata",winint);
        myintent.putExtra("losedata",loseint);
        startActivity(myintent);
        LoseActivity.this.finish();
    }
    
An other question is how to use the .ttf files.
I use the following code to finish it:

        TextView Count = findViewById(R.id.losecount);
        Count.setText(String.valueOf(losecount));
        Count = findViewById(R.id.wincount);
        Count.setText(String.valueOf(wincount));

        typeface = Typeface.createFromAsset(getAssets(), "Fonts/font_one.TTF");
        TextView tex = findViewById(R.id.textView);
        tex.setTypeface(typeface);
        tex = findViewById(R.id.textView);
        tex.setTypeface(typeface);
        
        

![Game Animals](display/demo.gif)
