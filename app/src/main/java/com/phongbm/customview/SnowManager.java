package com.phongbm.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnowManager {
    private List<Snow> snows;
    private Random random;
    private int widthScreen;
    private int heightScreen;

    public SnowManager(Context context) {
        snows = new ArrayList<>();
        random = new Random();

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        widthScreen = metrics.widthPixels;
        heightScreen = metrics.heightPixels;

        initializeSnows();
    }

    public void initializeSnows() {
        for (int i = 0; i < 48; i++) {
            createSnow();
        }
    }

    private void createSnow() {
        int x = random.nextInt(widthScreen);
        int y = -random.nextInt(256);
        int size = 48 + random.nextInt(128);
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        int color = Color.rgb(red, green, blue);
        snows.add(new Snow(x, y, size, color));
    }

    public void moveSnows() {
        for (int i = 0; i < snows.size(); i++) {
            Snow snow = snows.get(i);
            snow.move();
            if (snow.getY() > heightScreen) {
                snows.remove(i);
                i--;
                createSnow();
            }
        }
    }

    public void drawSnows(Canvas canvas, Paint paint) {
        for (int i = 0; i < snows.size(); i++) {
            snows.get(i).draw(canvas, paint);
        }
    }

}