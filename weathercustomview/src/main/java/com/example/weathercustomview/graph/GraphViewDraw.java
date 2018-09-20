package com.example.weathercustomview.graph;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;

import com.example.weathercustomview.models.MeasureGraph;
import java.util.Random;

public class GraphViewDraw implements GraphViewCanvas {

    private static final String TAG = GraphViewDraw.class.getSimpleName();
    private Canvas mCanvas;
    private Paint mPaintText;
    private Path mPathLine;
    private Paint mPaintLine;
    private MeasureGraph mMeasure;

    public GraphViewDraw(MeasureGraph measureGraph) {
        mPaintText = new Paint();
        mPaintLine = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPathLine = new Path();
        this.mMeasure = measureGraph;
    }

    @Override
    public void startDrawView(Canvas canvas) {
        this.mCanvas = canvas;
        drawLineGraph();
    }

    private void drawLineGraph() {

        float totalX = mMeasure.getWidthParent();
        float totalY = mMeasure.getHeightParent();

        float startPointY = mMeasure.getHeightParent()/2;
        float startPointX = 0;

        mPathLine.moveTo(startPointX, startPointY);
        for (int i = 0; i < 8; i++) {
            float x = totalX / 7 * i;
            float y = new Random().nextInt((int) totalY - 120);
            mCanvas.drawCircle(x,y,6,mPaintText);
            mPathLine.lineTo(x, y);
        }

        PathEffect effect = new CornerPathEffect(2);

        mPaintLine.setStrokeWidth(4);
        mPaintLine.setColor(Color.BLACK);
        mPaintLine.setPathEffect(effect);
        mPaintLine.setStyle(Paint.Style.STROKE);

        mCanvas.drawPath(mPathLine, mPaintLine);
    }

}
