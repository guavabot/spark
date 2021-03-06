package com.robinhood.spark;

import android.graphics.RectF;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestAdapter extends SparkAdapter {
    private float[] yData, xData;
    private RectF dataBounds;

    public void setYData(float[] yData) {
        this.yData = yData;
    }

    public void setXData(float[] xData) {
        this.xData = xData;
    }

    public void setDataBounds(float left, float top, float right, float bottom) {
        this.dataBounds = createMockRectF(left, top, right, bottom);
    }

    @Override
    public int getCount() {
        return yData == null ? 0 : yData.length;
    }

    @Override
    public Object getItem(int index) {
        return yData[index];
    }

    @Override
    public float getY(int index) {
        return yData[index];
    }

    @Override
    public float getX(int index) {
        return  xData == null
                ? super.getX(index)
                : xData[index];
    }

    @Override
    public RectF getDataBounds() {
        return dataBounds == null
                ? super.getDataBounds()
                : dataBounds;
    }

    @Override
    RectF createRectF(float left, float top, float right, float bottom) {
        return createMockRectF(left, top, right, bottom);
    }

    public static RectF createMockRectF(float left, float top, float right, float bottom) {
        RectF rectF = mock(RectF.class);
        rectF.left = left;
        rectF.top = top;
        rectF.right = right;
        rectF.bottom = bottom;
        when(rectF.width()).thenReturn(right - left);
        when(rectF.height()).thenReturn(bottom - top);
        return rectF;
    }
}
