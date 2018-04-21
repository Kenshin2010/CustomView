package com.phongbm.customview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import java.util.Random;

public class Snow {
    private int x;
    private int y;
    private int size;
    private int color;
    private Bitmap bitmap;
    private float corner = 0F;
    private Random random;
    private int rotation;
    private float fall;
    private boolean isCheck = true;

    public Snow(int x, int y, int size, int color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public Snow(int x, int y, Bitmap bitmap) {
        this.x = x;
        this.y = y;
        this.bitmap = Bitmap.createScaledBitmap(bitmap, 100, 100, false);
    }

    public void draw(Canvas canvas, Paint paint) {
//        paint.setTextSize(size);
//        paint.setColor(color);
//        canvas.drawText("*", x, y, paint);
        if (random == null) {
            random = new Random();
            rotation = random.nextInt(10);
        }
        if (rotation % 2 == 0) {
                this.fall = 0.5F;
            } else {
                this.fall = -0.5F;
            }
        if (this.isCheck) {
            this.corner = (float) ( this.corner + 0.1F);
            if (this.corner >= 30.0F) {
                this.isCheck = false;
            }
        } else {
            this.corner -= 0.1F;
            if (this.corner <= -30.0F) {
                this.isCheck = true;
            }
        }

        canvas.drawBitmap(rotateBitmap(bitmap, corner), x, y, null);
        if (this.x < (float) canvas.getWidth()) {
            this.x += this.fall;
        } else {
            this.corner = 0.0F;
        }
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

    private Bitmap rotateBitmap(Bitmap bitmap, float angal) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angal);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

}