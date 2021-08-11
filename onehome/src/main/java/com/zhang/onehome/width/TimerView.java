package com.zhang.onehome.width;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;

import android.util.AttributeSet;
import android.view.View;


import androidx.annotation.Nullable;

import java.util.Timer;
import java.util.TimerTask;

public class TimerView extends View {
    private Paint paint;
    private int hour = 24;
    private int minute = 60;
    private int second = 60;
    public TimerView(Context context) {
        super(context);
        init();
    }

    public TimerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TimerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setTextSize(38);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.RED);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawText(hour+":"+minute+":"+second--,200,80,paint);
    }
}
