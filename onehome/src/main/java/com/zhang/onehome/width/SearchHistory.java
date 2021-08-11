package com.zhang.onehome.width;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @author 张海旭
 */
public class SearchHistory extends LinearLayout {
    private Paint paint;
    public SearchHistory(Context context) {
        super(context);
        init();
    }

    public SearchHistory(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SearchHistory(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(32);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(20f);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        canvas.drawText("zhanghaixu",170,60,paint);
        canvas.drawRoundRect(new RectF(90,0,100,60),10,100,paint);
        requestLayout();
    }
}
