package android.hospital.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MyUtils {

    private static Gson gson;

    private MyUtils() {
    }

    public static Gson getGsonParser() {
        if (gson == null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gson = gsonBuilder.create();
        }
        return gson;
    }

    public static int dpToPx(Context context, int dp) {
        return Math.round(dp * getPixelScaleFactor(context));
    }

    public static int pxToDp(Context context, int px) {
        return Math.round(px / getPixelScaleFactor(context));
    }

    private static float getPixelScaleFactor(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT;
    }


    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable)
            return ((BitmapDrawable) drawable).getBitmap();

        // We ask for the bounds if they have been set as they would be most
        // correct, then we check we are  > 0
        final int width = !drawable.getBounds().isEmpty() ? drawable.getBounds().width() : drawable.getIntrinsicWidth();

        final int height = !drawable.getBounds().isEmpty() ? drawable.getBounds().height() : drawable.getIntrinsicHeight();

        // Now we check we are > 0
        final Bitmap bitmap = Bitmap.createBitmap(width <= 0 ? 1 : width, height <= 0 ? 1 : height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.equals("")) {
            return "";
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public static String getNumberString(Double number) {
        if (number == null) {
            return "0";
        }
        if (number < number.intValue() + 0.00001) {
            NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
            DecimalFormat formatter = (DecimalFormat) nf;
            formatter.applyPattern("###,###,###");
            return formatter.format(number);
        } else {
            NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
            DecimalFormat formatter = (DecimalFormat) nf;
            formatter.applyPattern("###,###,###.##");
            return formatter.format(number);
        }
    }

    public static void changeLang(Context context, String lang) {
        Locale myLocale = new Locale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        context.getResources().updateConfiguration(config, context.getResources().getDisplayMetrics());
    }

    public static String convertTimeToDisplayTextMDY(String date) {
        String result = "*** **, ****";
        if (date != null && !date.equals("")) {
            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
                Date parsedDate = inputFormat.parse(date);
                result = new SimpleDateFormat("MMM dd, yyyy").format(parsedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String convertTimeToDisplayTextHI(String date) {
        String result = "**:** **";
        if (date != null && !date.equals("")) {
            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
                Date parsedDate = inputFormat.parse(date);
                result = new SimpleDateFormat("h:mm a").format(parsedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static float convertTimeToTimeStamp(String date) {
        if (date != null && !date.equals("")) {
            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
                Date parsedDate = inputFormat.parse(date);
                return parsedDate.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static String convertTimeToDisplayTextDY(String date) {
        String result = "**/****";
        if (date != null && !date.equals("")) {
            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
                Date parsedDate = inputFormat.parse(date);
                result = new SimpleDateFormat("dd/yyyy").format(parsedDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static boolean isValidEmail(String email) {
        if (email != null && email.length() > 0) {
            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
            return email.matches(emailPattern);
        }
        return false;
    }
}
