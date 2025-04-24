package com.example.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

// 클래스: 멤버변수 + 멤버함수 + 생성자(클래스 이름과 같은 메서드)
public class CustomView extends View {
    private static final String TAG = "CustomView";
    private static final int IMAGE_SIZE = 250;
    private static final int WHAT_UPDATE = 1;
    private static final long DELAY_MS = 33;
    private static final int DELTA = 20;
    private int direction = 1;
    private Drawable drawable;
    private Rect rect = new Rect();
    private Point point = new Point();
    private Point size = new Point();

    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (direction == 1) {
                if (point.y + DELTA + IMAGE_SIZE <= size.y) point.y += DELTA;
                else direction *= -1;
            } else if (direction == -1) {
                if (point.y + DELTA >= 0) point.y -= DELTA;
            } else direction *= -1;
            invalidate();
            handler.sendEmptyMessageDelayed(WHAT_UPDATE, DELAY_MS);
        }
    };
    @SuppressLint("UseCompatLoadingForDrawables")
    public CustomView(Context context, @Nullable AttributeSet attrs) { // 생성자
        super(context, attrs);
        Log.i(TAG, "CustomView");
        drawable = getResources().getDrawable(R.drawable.img, null);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        size.x = getWidth();
        size.y = getHeight();
        point.y = (size.y / 2) - (IMAGE_SIZE / 2);
        point.x = (size.x / 2) - (IMAGE_SIZE / 2);

        Log.i(TAG, "size = " + size);
        Log.i(TAG, "point = " + size);

        handler.sendEmptyMessageDelayed(WHAT_UPDATE, DELAY_MS);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        rect.left = point.x;
        rect.top = point.y;
        rect.right = point.x + IMAGE_SIZE;
        rect.bottom = point.y + IMAGE_SIZE;

        drawable.setBounds(rect);
        drawable.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        point.x = (int) event.getX() - (IMAGE_SIZE / 2);
        point.y = (int) event.getY() - (IMAGE_SIZE / 2);
        Log.i(TAG, "onTouchEvent" + point);
        invalidate();
        return super.onTouchEvent(event);
    }
}
