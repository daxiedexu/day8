package com.zhang.onehome.width;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author 张海旭
 */
public class WidthEditView extends androidx.appcompat.widget.AppCompatEditText {
    private String data;
    private Paint paint;
    private boolean is = true;
    public WidthEditView(Context context) {
        super(context);
        init();
    }

    public WidthEditView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WidthEditView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        initPaint(Color.GRAY);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                is = true;
                requestLayout();
            }
        });
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (!TextUtils.isEmpty(getText().toString().trim())){
            if (focused){
                data = getText().toString();
                is = true;
                requestLayout();
            }else {
                data = getText().toString();
                is = false;
                setText("");
                requestLayout();
            }
        }else {
            is = true;
            requestLayout();
        }
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!is){
            paint.setColor(Color.RED);
            canvas.drawText(data,170,60,paint);
            paint.setColor(Color.BLACK);
        }
    }

    private void initPaint(int color){
        if (paint==null){
            paint = new Paint();
            paint.setColor(color);
            paint.setStrokeWidth(10f);
            paint.setTextSize(50);
            paint.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!is){
            paint.setColor(Color.GRAY);
            canvas.drawRoundRect(new RectF(90,0,600,100),80,70,paint);
        }
    }
}
