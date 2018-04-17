package com.phongbm.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class SnowBackgroundView extends View implements Runnable {
    private Paint paint;

    private SnowManager snowManager;
    private Thread thread;

    public SnowBackgroundView(Context context) {
        super(context);
        setup();
    }

    public SnowBackgroundView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    private void setup() {
        paint = new Paint();
        paint.setAntiAlias(true);

        snowManager = new SnowManager(getContext());
        thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        snowManager.drawSnows(canvas, paint);
        // drawDemo(canvas);
    }

    private void drawDemo(Canvas canvas) {
        // snowManager.moveSnows();
        // invalidate();

        paint.setColor(Color.RED);
        paint.setStrokeWidth(16);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(10, 10, 300, 300, paint);

        // Draw circle
        paint.setColor(Color.BLUE);
        canvas.drawCircle(200, 200, 200, paint);

        // Draw text
        paint.setTextSize(32);
        paint.setColor(Color.BLACK);
        paint.setTypeface(Typeface.SANS_SERIF);
        canvas.drawText("Hello", 0, 500, paint);

        // Draw image
        Bitmap bitmap = BitmapFactory.decodeResource(
                getResources(),
                R.drawable.ic_launcher);
        canvas.drawBitmap(bitmap, 500, 500, paint);
    }

    @Override
    public void run() {
        while (true) {
            snowManager.moveSnows();
            postInvalidate();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}