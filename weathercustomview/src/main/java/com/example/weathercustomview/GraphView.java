package com.example.weathercustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

import com.example.weathercustomview.graph.GraphViewAnimation;
import com.example.weathercustomview.graph.GraphViewIMP;
import com.example.weathercustomview.graph.GraphViewManager;
import com.example.weathercustomview.models.MeasureGraph;

public class GraphView extends View implements GraphViewIMP {

    public static final String TAG = GraphView.class.getSimpleName();

    private GraphViewManager graphViewManager;
    private GraphViewAnimation graphViewAnimation;

    public GraphView(Context context) {
        super(context);
        init(context, null);
    }

    public GraphView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public GraphView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(final Context context, AttributeSet attrs) {
        if (graphViewManager == null) {
            getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    //set animation of the when draw graphview
                    graphViewAnimation = new GraphViewAnimation();

                    //set size of the Graphview
                    MeasureGraph measureGraph = new MeasureGraph(getWidth(), getHeight());
                    measureGraph.setDensity(getResources().getDisplayMetrics().density);

                    //set graphManager => this class for manager draw view
                    graphViewManager = new GraphViewManager.Builder()
                            .setContext(context)
                            .setValueAnimation(graphViewAnimation)
                            .setMeasure(measureGraph)
                            .build();
                    return true;
                }
            });
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        graphViewManager.setCanvas(canvas);
        super.onDraw(canvas);
//        Log.e(TAG,"onDraw");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        Log.e(TAG,"onMeasure");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
//        Log.e(TAG,"onLayout");
    }

    @Override
    public void start() {
        postInvalidate();
    }
}
