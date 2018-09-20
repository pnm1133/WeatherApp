package com.example.weathercustomview.graph;

import android.content.Context;
import android.graphics.Canvas;

import com.example.weathercustomview.models.MeasureGraph;

import java.util.Objects;

public class GraphViewManager {

    private Context mContext;
    private GraphViewAnimation mGraphViewAnimation;
    private MeasureGraph mMeasureGraph;

    private GraphViewManager(Builder builder) {
        mContext = builder.context;
        mGraphViewAnimation = builder.mGraphViewAnimation;
        mMeasureGraph = builder.mMeasureGraph;
        Objects.requireNonNull(mContext,"context must set in builder");
        Objects.requireNonNull(mGraphViewAnimation,"GraphViewAnimation must set in builder");
        Objects.requireNonNull(mMeasureGraph,"MeasureGraph must set in builder");

    }

    public void setCanvas(Canvas mCanvas) {
        GraphViewCanvas graphViewCanvas = new GraphViewDraw(mMeasureGraph);
        graphViewCanvas.startDrawView(mCanvas);
    }
    /*
    * this class for builder Graphview Manager
    * */
    public static class Builder {
        private Context context;
        private GraphViewAnimation mGraphViewAnimation;
        private MeasureGraph mMeasureGraph;

        public Builder setContext(Context context){
            this.context = context;
            return Builder.this;
        }

        public Builder setValueAnimation(GraphViewAnimation graphViewAnimation){
            this.mGraphViewAnimation = graphViewAnimation;
            return Builder.this;
        }

        public Builder setMeasure(MeasureGraph measureGraph){
            this.mMeasureGraph = measureGraph;
            return Builder.this;
        }

        public GraphViewManager build() {
            return new GraphViewManager(this);
        }
    }
}
