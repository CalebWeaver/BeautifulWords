package com.bearlymade.beautifulwords;

import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ShareActionProvider;
import android.widget.TextView;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity
    implements View.OnTouchListener {


    Random rand;
    HaikuGenerator generator;
    Typewriter haikuView;
    int width;
    int height;
    static int[] iconIds = {R.drawable.spiral1,
            R.drawable.spiral2,
            R.drawable.spiral3,
            R.drawable.spiral4,
            R.drawable.spiral5,
            R.drawable.spiral6,
            R.drawable.spiral7,
            R.drawable.spiral8,
            R.drawable.spiral9,
            R.drawable.spiral10,
            R.drawable.spiral11,
            R.drawable.spiral12};
    int colorSwitch = 1;
    Utility util;
    ShareActionProvider shareActionProvider;
    ShareButton shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        findViewById(R.id.new_button).setOnTouchListener(this);
        findViewById(R.id.background).setOnTouchListener(this);shareButton = (ShareButton)findViewById(R.id.share_button);
        rand = new Random();
        util = new Utility(this);
        shareActionProvider = new ShareActionProvider(this);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        generator = new HaikuGenerator(this);
        haikuView = (Typewriter) findViewById(R.id.haiku_view);
        haikuView.setCharacterDelay(90);
        haikuView.animateText(generator.generateHaiku());
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == R.id.new_button) {
            haikuView.animateText(generator.generateHaiku());
            ActivationCircle circle = new ActivationCircle(this);
            View newButton = findViewById(R.id.button_wrapper);
            circle.setY(newButton.getY() + event.getY());
            circle.setX(newButton.getX() + event.getX());
            addContentView(circle, new android.app.ActionBar.LayoutParams(100, 100));
            ImageFadeView buttonIcon = (ImageFadeView) findViewById(R.id.button_icon);
            buttonIcon.switchImage(iconIds[rand.nextInt(iconIds.length)]);
            circle.explode();
            return false;
        } else if (v.getId() == R.id.share_button) {
//            Intent shareIntent = new Intent();
//            shareIntent.setAction(Intent.ACTION_SEND);
//            shareIntent.putExtra(Intent.EXTRA_TEXT, haikuView.getText());
//            shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Haiku");
//            shareIntent.setType("text/plain");
//            startActivity(Intent.createChooser(shareIntent, "Share via"));
            ShareLinkContent content = new ShareLinkContent.Builder()
                    .setContentTitle("These Beautiful Words")
                    .setContentDescription(haikuView.getText()+"")
//                    .setContentUrl(Uri.parse("URL[will open website or app]"))
//                    .setImageUrl(Uri.parse("image or logo [if playstore or app store url then no need of this image url]"))
                    .build();
            shareButton.setShareContent(content);
        } else if (v.getId() == R.id.background) {
            changeColors();
            return false;
        }
        return false;
    }

    private void changeColors() {
        GradientDrawable background = (GradientDrawable) findViewById(R.id.background).getBackground();
        GradientDrawable button = (GradientDrawable) findViewById(R.id.new_button).getBackground();
        TextView text = (TextView) findViewById(R.id.haiku_view);

        int backGroundStrokeWidth = Math.round(util.dpTopx(6));
        int buttonStrokeWidth = Math.round(util.dpTopx(6));

        int[] theme = ThemesSelector.getTheme(colorSwitch);

        background.setStroke(backGroundStrokeWidth, ContextCompat.getColor(this,theme[0]));
        background.setColor(ContextCompat.getColor(this,theme[1]));
        button.setStroke(buttonStrokeWidth, ContextCompat.getColor(this,theme[2]));
        button.setColor(ContextCompat.getColor(this,theme[3]));
        text.setTextColor(ContextCompat.getColor(this,theme[4]));

        colorSwitch = (colorSwitch + 1) % ThemesSelector.themeCount();
    }
}
