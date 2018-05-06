 public static Bitmap drawTextOnImage(final ImageView imageView, Bitmap bitmap, double latitude, double logitude) {

        Bitmap newBitmap = null;
        Bitmap.Config config = bitmap.getConfig();
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }

        newBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), config);
        if (newCanvas == null)
            newCanvas = new Canvas(newBitmap);
        newCanvas.drawBitmap(bitmap, 0, 0, null);

        Date currentTime = Calendar.getInstance().getTime();
        date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(currentTime).toString();

        if (paint == null)
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        if (paintLatitude == null)
//            paintLatitude = new Paint(Paint.ANTI_ALIAS_FLAG);
//        if (paintLogitude == null)
//            paintLogitude = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setTextSize(12);
//        paintLogitude.setTextSize(12);
//        paintLatitude.setTextSize(12);

        paint.setColor(Color.WHITE);
//        paintLogitude.setColor(Color.WHITE);
//        paintLatitude.setColor(Color.WHITE);

        paint.setTypeface(Typeface.SANS_SERIF);
//        paintLogitude.setTypeface(Typeface.SANS_SERIF);
//        paintLatitude.setTypeface(Typeface.SANS_SERIF);

//        int width = imageView.getDrawable().getIntrinsicWidth();
//        int height = imageView.getDrawable().getIntrinsicHeight();
//
//        Rect rectText = new Rect();
//        paintDate.getTextBounds(date, 0, date.length(), rectText);


        heightSize = imageView.getLayoutParams().height;
        widthSize = imageView.getLayoutParams().height;


//        newCanvas.drawText(date, 0, rectText.height(), paintDate);

//        newCanvas.drawText(date, 0, 300, paintDate);
//        newCanvas.drawText(latitude, 0, 20, paintLatitude);
//        newCanvas.drawText(logitude, 0, 30, paintLogitude);

        newCanvas.drawText(date, 0, heightSize + 50, paint);
        newCanvas.drawText(latitude + "", 0, heightSize + 35, paint);
        newCanvas.drawText(logitude + "", 0, heightSize + 20, paint);


        return newBitmap;
    }
