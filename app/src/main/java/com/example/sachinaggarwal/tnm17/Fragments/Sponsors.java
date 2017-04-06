package com.example.sachinaggarwal.tnm17.Fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sachinaggarwal.tnm17.R;

/**
 * Created by HIman$hu on 2/19/2017.
 */

public class Sponsors extends Fragment {
    private Bitmap mBitmap;
    int [] DEVELOPER_PICS={R.drawable.pic15,R.drawable.pic01,R.drawable.pic03,R.drawable.pic07,R.drawable.pic08,R.drawable.pic09,R.drawable.pic11,R.drawable.pic13,R.drawable.pic18};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_sponsors, container, false);
//        GridView gridView = (GridView) view.findViewById(R.id.grid_view);

//            Bitmap pics= BitmapFactory.decodeResource(getResources(), DEVELOPER_PICS[3]);
//            pics=getCircularBitmapWithWhiteBorder(pics,100);


        RoundedBitmapDrawable roundedImageDrawable1 = createRoundedBitmapImageDrawableWithBorder(BitmapFactory.decodeResource(getResources(), DEVELOPER_PICS[1]));
        ImageView imageView1= (ImageView) view.findViewById(R.id.imageView1);
        imageView1.setImageDrawable(getResources().getDrawable(DEVELOPER_PICS[1]));
        RoundedBitmapDrawable roundedImageDrawable2 = createRoundedBitmapImageDrawableWithBorder(BitmapFactory.decodeResource(getResources(), DEVELOPER_PICS[2]));
        ImageView imageView2= (ImageView) view.findViewById(R.id.imageView2);
        imageView2.setImageDrawable(getResources().getDrawable(DEVELOPER_PICS[2]));
        RoundedBitmapDrawable roundedImageDrawable3 = createRoundedBitmapImageDrawableWithBorder(BitmapFactory.decodeResource(getResources(), DEVELOPER_PICS[3]));
        ImageView imageView3= (ImageView) view.findViewById(R.id.imageView3);
        imageView3.setImageDrawable(getResources().getDrawable(DEVELOPER_PICS[3]));
        RoundedBitmapDrawable roundedImageDrawable4 = createRoundedBitmapImageDrawableWithBorder(BitmapFactory.decodeResource(getResources(), DEVELOPER_PICS[4]));
        ImageView imageView4= (ImageView) view.findViewById(R.id.imageView4);
        imageView4.setImageDrawable(getResources().getDrawable(DEVELOPER_PICS[4]));
        RoundedBitmapDrawable roundedImageDrawable5 = createRoundedBitmapImageDrawableWithBorder(BitmapFactory.decodeResource(getResources(), DEVELOPER_PICS[5]));
        ImageView imageView5= (ImageView) view.findViewById(R.id.imageView5);
        imageView5.setImageDrawable(getResources().getDrawable(DEVELOPER_PICS[5]));
        RoundedBitmapDrawable roundedImageDrawable6 = createRoundedBitmapImageDrawableWithBorder(BitmapFactory.decodeResource(getResources(), DEVELOPER_PICS[6]));
        ImageView imageView6= (ImageView) view.findViewById(R.id.imageView6);
        imageView6.setImageDrawable(getResources().getDrawable(DEVELOPER_PICS[6]));
        RoundedBitmapDrawable roundedImageDrawable7 = createRoundedBitmapImageDrawableWithBorder(BitmapFactory.decodeResource(getResources(), DEVELOPER_PICS[7]));
        ImageView imageView7= (ImageView) view.findViewById(R.id.imageView7);
        imageView7.setImageDrawable(getResources().getDrawable(DEVELOPER_PICS[7]));
        RoundedBitmapDrawable roundedImageDrawable8 = createRoundedBitmapImageDrawableWithBorder(BitmapFactory.decodeResource(getResources(), DEVELOPER_PICS[8]));
        ImageView imageView8= (ImageView) view.findViewById(R.id.imageView8);
        imageView8.setImageDrawable(getResources().getDrawable(DEVELOPER_PICS[8]));
//        // Instance of ImageAdapter Class
//        gridView.setAdapter(new ImageAdapter(getContext()));
        return view;
    }

//    public Bitmap getRoundedShape(Bitmap scaleBitmapImage) {
//        int targetWidth = scaleBitmapImage.getWidth();
//        int targetHeight = scaleBitmapImage.getHeight();
//        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth,
//                targetHeight, Bitmap.Config.ARGB_8888);
//
//        Canvas canvas = new Canvas(targetBitmap);
//        Path path = new Path();
//        path.addCircle(((float) targetWidth - 1)/2 ,
//                ((float) targetHeight - 1) /2,
//                (Math.min(((float) targetWidth),
//                        ((float) targetHeight)) /2),
//                Path.Direction.CCW);
//
//        canvas.clipPath(path);
//        Bitmap sourceBitmap = scaleBitmapImage;
//        canvas.drawBitmap(sourceBitmap,
//                new Rect(0, 0, sourceBitmap.getWidth(),
//                        sourceBitmap.getHeight()),
//                new Rect(0, 0, targetWidth, targetHeight), null);
//        return targetBitmap;
//    }
//
//    public  Bitmap getCircularBitmapWithWhiteBorder(Bitmap bitmap,
//                                                          int borderWidth) {
//        if (bitmap == null || bitmap.isRecycled()) {
//            return null;
//        }
//
//        final int width = bitmap.getWidth() + borderWidth;
//        final int height = bitmap.getHeight() + borderWidth;
//
//        Bitmap canvasBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//        Paint paint = new Paint();
//        paint.setAntiAlias(true);
//        paint.setShader(shader);
//
//        Canvas canvas = new Canvas(canvasBitmap);
//        float radius = width > height ? ((float) height) / 2f : ((float) width) / 2f;
//        canvas.drawCircle(width / 2, height / 2, radius, paint);
//        paint.setShader(null);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setColor(Color.RED);
//        paint.setStrokeWidth(borderWidth);
//        canvas.drawCircle(width / 2, height / 2, radius - borderWidth / 2, paint);
//        return canvasBitmap;


    private RoundedBitmapDrawable createRoundedBitmapImageDrawableWithBorder(Bitmap bitmap){
        int bitmapWidthImage = bitmap.getWidth();
        int bitmapHeightImage = bitmap.getHeight();
        int borderWidthHalfImage = 12;

        int bitmapRadiusImage = Math.min(bitmapWidthImage,bitmapHeightImage)/2;
        int bitmapSquareWidthImage = Math.min(bitmapWidthImage,bitmapHeightImage);
        int newBitmapSquareWidthImage = bitmapSquareWidthImage+borderWidthHalfImage;

        Bitmap roundedImageBitmap = Bitmap.createBitmap(newBitmapSquareWidthImage,newBitmapSquareWidthImage,Bitmap.Config.ARGB_8888);
        Canvas mcanvas = new Canvas(roundedImageBitmap);
        mcanvas.drawColor(Color.RED);
        int i = borderWidthHalfImage + bitmapSquareWidthImage - bitmapWidthImage;
        int j = borderWidthHalfImage + bitmapSquareWidthImage - bitmapHeightImage;

        mcanvas.drawBitmap(bitmap, i, j, null);

        Paint borderImagePaint = new Paint();
        borderImagePaint.setStyle(Paint.Style.STROKE);
        borderImagePaint.setStrokeWidth(borderWidthHalfImage*2);
        borderImagePaint.setColor(Color.RED);
        mcanvas.drawCircle(mcanvas.getWidth()/2, mcanvas.getWidth()/2, newBitmapSquareWidthImage/2, borderImagePaint);

        RoundedBitmapDrawable roundedImageBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),roundedImageBitmap);
        roundedImageBitmapDrawable.setCornerRadius(bitmapRadiusImage);
        roundedImageBitmapDrawable.setAntiAlias(true);
        return roundedImageBitmapDrawable;
    }
}

