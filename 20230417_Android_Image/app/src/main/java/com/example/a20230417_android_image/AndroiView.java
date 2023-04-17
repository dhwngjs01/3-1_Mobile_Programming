package com.example.a20230417_android_image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class AndroiView extends View {
    Drawable imgAndroi;
    int ix, iy;
    int imgWidth, imgHeight, screenWidth, screenHeight;

    public AndroiView(Context context, AttributeSet attrs) {
        super(context, attrs);

        imgAndroi = this.getResources().getDrawable(R.drawable.androi);
        imgWidth = imgAndroi.getIntrinsicWidth();
        imgHeight = imgAndroi.getIntrinsicHeight();
        ix = 0;
        iy = 0;


    }

    @Override
    protected void onDraw(Canvas canvas) {
        imgAndroi.setBounds(ix, iy, ix+imgWidth, iy+imgHeight);
        imgAndroi.draw(canvas);
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        screenWidth  = this.getWidth();
        screenHeight = this.getHeight();
        ix = (screenWidth - imgWidth) / 2;
        iy = (screenHeight - imgHeight) / 2;

        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        screenWidth  = this.getWidth();
        screenHeight = this.getHeight();

        switch(keyCode){
            case KeyEvent.KEYCODE_DPAD_LEFT:
                ix -= 30;
                if(ix <= 0) ix = 0;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                ix += 30;
                if(ix >= screenWidth-imgWidth) ix = screenWidth-imgWidth;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                iy -= 30;
                if(iy <= 0) iy = 0;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                iy += 30;
                if(iy >= screenHeight-imgHeight) iy = screenHeight-imgHeight;
                break;
        }

        this.invalidate();

        return super.onKeyDown(keyCode, event);
    }

    public boolean onTouchEvent(MotionEvent event) {
        ix = (int)event.getX() - imgWidth / 2;
        iy = (int)event.getY() - imgHeight / 2;

        this.invalidate();

        return super.onTouchEvent(event);
    }
}
