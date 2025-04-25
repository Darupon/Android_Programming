package com.example.surfaceview;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class Ball {
    private Drawable image = null;
    private Point point = new Point();
    private Point size = new Point();
    private Point delta;

    // private이기 때문에 get(읽기)과 set(쓰기)으로 접근해야함
    public Drawable getImage() {
        return image;
    }

    public Point getPoint() {
        return point;
    }

    public Point getSize() {
        return size;
    }

    public Point getDelta() {
        return delta;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public void setDelta(Point delta) {
        this.delta = delta;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void setSize(Point size) {
        this.size = size;
    }

    public void draw(Canvas canvas) {
        image.setBounds(point.x, point.y, point.x + size.x, point.y + size.y);
        image.draw(canvas);
    }

    public void setDelta(int dx, int dy) {
        delta = new Point(dx, dy);
    }

    public void move(Rect surfaceFrame) {
        if(point.x + delta.x < 0 || point.x + delta.x + size.x > surfaceFrame.right) delta.x *= -1;
        else point.x += delta.x;

        if(point.y + delta.y < 0 || point.y + delta.y + size.y > surfaceFrame.bottom) delta.y *= -1;
        else point.y += delta.y;
    }

}
