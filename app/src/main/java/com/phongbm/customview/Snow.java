package com.phongbm.customview;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Snow {
    private int x;
    private int y;
    private int size;
    private int color;

    public Snow(int x, int y, int size, int color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public void draw(Canvas canvas, Paint paint) {
        paint.setTextSize(size);
        paint.setColor(color);
        canvas.drawText("*", x, y, paint);
    }

    public void move() {
        y++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public void setColor(int color) {
        this.color = color;
    }

}