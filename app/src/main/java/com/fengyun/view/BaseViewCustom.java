package com.fengyun.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by prize on 2017/11/7.
 */

public class BaseViewCustom extends View implements IViewCustom {

    private Paint mPaint = new Paint();

    public BaseViewCustom(Context context) {
        this(context, null);
    }

    public BaseViewCustom(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseViewCustom(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public BaseViewCustom(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void init() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//      testCanvasScale(canvas);
//      testCanvasRotateText(canvas);
//        canvas.drawText("Hello, World !",0, 0, mPaint);
        drawText(canvas, "Hello, World !", 0, 0, 0);
    }

    private void testCanvasScale(Canvas canvas) {
        canvas.save();
        mPaint.setColor(getResources().getColor(android.R.color.holo_blue_light));
        canvas.drawRect(100, 100 ,200, 200 , mPaint);
        canvas.scale(0.5f, 0.5f);
        mPaint.setColor(getResources().getColor(android.R.color.holo_red_light));
        canvas.drawRect(100, 100 ,200, 200 , mPaint);
        canvas.restore();
        mPaint.setColor(getResources().getColor(android.R.color.holo_green_light));
        canvas.drawRect(100, 100 ,200, 200 , mPaint);

    }

    private void testCanvasRotateText(Canvas canvas) {
        canvas.save();
        mPaint.setColor(getResources().getColor(android.R.color.holo_blue_light));
        drawText(canvas,"Hello, World !", 100  ,100, 50f);
        canvas.rotate(30, 100, 100);
        mPaint.setColor(getResources().getColor(android.R.color.holo_red_light));
        drawText(canvas,"Hello, World !", 100  ,100, 50f);
        canvas.restore();
        mPaint.setColor(getResources().getColor(android.R.color.holo_green_light));
        drawText(canvas,"Hello, World !", 100  ,100, 50f);
    }

    private void testCanvasRotate(Canvas canvas){
        canvas.save();
        mPaint.setColor(getResources().getColor(android.R.color.holo_blue_light));
        canvas.drawRect(100, 100 ,200, 500 , mPaint);
        canvas.rotate(30, 100, 100);
        mPaint.setColor(getResources().getColor(android.R.color.holo_red_light));
        canvas.drawRect(100, 100 ,200, 500 , mPaint);
        canvas.restore();
        mPaint.setColor(getResources().getColor(android.R.color.holo_green_light));
        canvas.drawRect(200, 100 ,300, 500 , mPaint);
    }


    protected void drawText(Canvas canvas, String s, int start, int end, float x, float y, float textSize){
        if(textSize > 0)
            mPaint.setTextSize(textSize);

        canvas.drawText(s, start,end ,x, y + mPaint.descent() - mPaint.ascent(), mPaint);
    }

    protected void drawText(Canvas canvas, String s, float x, float y, float textSize){
        if(textSize > 0)
            mPaint.setTextSize(textSize);
        float as = mPaint.ascent();
        float ds = mPaint.descent();
        canvas.drawText(s, x, y + mPaint.descent() - mPaint.ascent(), mPaint);
    }

}
