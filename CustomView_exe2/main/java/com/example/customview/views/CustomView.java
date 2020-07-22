package com.example.customview.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.customview.R;

import java.util.Timer;
import java.util.TimerTask;

public class CustomView extends View {

    private static final int SQUARE_SIZE_DEF = 200;

    private Rect mRectSquare;
    private Paint mPaintSquare;
    private int mSquareColor;
    private int mSquareSize;
    private Paint mPaintCircle;

    private float mCircleX, mCircleY;
    private float mCircleRadius = 100f;

    private Bitmap mImage;

    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private  void init(@Nullable AttributeSet set){
        mRectSquare = new Rect();
        mPaintSquare = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPaintCircle = new Paint();
        mPaintCircle.setAntiAlias(true);
        mPaintCircle.setColor(Color.parseColor("#00ccff"));

        mImage = BitmapFactory.decodeResource(getResources(), R.drawable.dienthoai);


        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
                else
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);

                int padding = 50;

                mImage = getResizedBitmap(mImage, getWidth() - padding, getHeight() - padding);

                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        int newWidth = mImage.getWidth() - 50;
                        int newHeight = mImage.getHeight() - 50;

                        if (newWidth <= 0 || newHeight <= 0){
                            cancel();
                            return;
                        }
                        mImage = getResizedBitmap(mImage, newWidth, newHeight);
                        postInvalidate();
                    }
                },400,800);
            }
        });

        if (set == null)
            return;

        TypedArray ta = getContext().obtainStyledAttributes(set, R.styleable.CustomView);
        mSquareColor = ta.getColor(R.styleable.CustomView_square_color,Color.GREEN);
        mSquareSize = ta.getDimensionPixelSize(R.styleable.CustomView_square_size,SQUARE_SIZE_DEF);
        mPaintSquare.setColor(mSquareColor);
        ta.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void swapColor(){
        mPaintSquare.setColor(mPaintSquare.getColor() == Color.GREEN ? Color.RED : Color.GREEN);

        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mRectSquare.left = 50;
        mRectSquare.top = 50;
        mRectSquare.right = mRectSquare.left + mSquareSize;
        mRectSquare.bottom = mRectSquare.top + mSquareSize;

        canvas.drawRect(mRectSquare,mPaintSquare);

        if (mCircleX == 0f || mCircleY == 0f){
            mCircleX = getWidth() / 2;
            mCircleY = getHeight() / 2;

        }

        canvas.drawCircle(mCircleX, mCircleY, mCircleRadius, mPaintCircle);

        float imageX = (getWidth() - mImage.getWidth()) / 2;
        float imageY = (getHeight() - mImage.getHeight()) / 2;

        canvas.drawBitmap(mImage, imageX, imageY, null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean value = super.onTouchEvent(event);

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN: {

                float x = event.getX();
                float y = event.getY();

                if (mRectSquare.left < x && mRectSquare.right > x)
                    if (mRectSquare.top < y && mRectSquare.bottom > y)
                    {
                        mCircleRadius += 10f;
                        postInvalidate();
                    }
                return true;
            }

            case MotionEvent.ACTION_MOVE: {
                float x = event.getX();
                float y = event.getY();

                double dx = Math.pow(x - mCircleX, 2);
                double dy = Math.pow(y - mCircleY, 2);

                if (dx + dy < Math.pow(mCircleRadius, 2)){

                    mCircleX = x;
                    mCircleY = y;

                    postInvalidate();
                    return true;
                }
                return true;
            }
        }
        return value ;
    }

    private Bitmap getResizedBitmap(Bitmap bitmap, int reqWidth, int reqHeight){
        Matrix matrix = new Matrix();

        RectF src = new RectF(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF dst = new RectF(0, 0, reqWidth, reqHeight);

        matrix.setRectToRect(src, dst, Matrix.ScaleToFit.CENTER);

        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight() , matrix, true);

    }
}
