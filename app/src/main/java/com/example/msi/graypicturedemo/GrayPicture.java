package com.example.msi.graypicturedemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * Created by MSI on 2017/6/21.
 */

public class GrayPicture {
    Bitmap bitmap;
    public float mHue=0, mStauration=0 , mLum=1;

    /**
     *
     * @param btm 需要变色的图片
//     * @param mHue 色调值 该出默认为0
//     * @param  mStauration 饱和度值 该出默认为0
//     * @param mLum 亮度值，该出默认为1,该出为0会变成黑色
     * @return
     */
    public Bitmap setBitmap(Bitmap btm){
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setRotate(0, mHue);
        colorMatrix.setRotate(1, mHue);
        colorMatrix.setRotate(2, mHue);
        ColorMatrix colorMatrix1 = new ColorMatrix();
        colorMatrix1.setSaturation(mStauration);
        ColorMatrix colorMatrix2 = new ColorMatrix();
        colorMatrix2.setScale(mLum, mLum, mLum, 1);
        ColorMatrix colorMatrixs = new ColorMatrix();
        colorMatrixs.postConcat(colorMatrix);
        colorMatrixs.postConcat(colorMatrix1);
        colorMatrixs.postConcat(colorMatrix2);

        bitmap = Bitmap.createBitmap(btm.getWidth(), btm.getHeight(), Bitmap.Config.ARGB_8888);
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        Canvas canvas = new Canvas(bitmap);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrixs));
        canvas.drawBitmap(btm, 0, 0, paint);
        return bitmap;
    }
}
