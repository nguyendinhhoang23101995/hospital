package android.hospital.lib.edittext;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;

/**
 * Created by logan on 23/01/2018.
 */

public class MyCustomEditText extends android.support.v7.widget.AppCompatEditText {

    public MyCustomEditText(Context context) {
        super(context);
    }

    public MyCustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK &&
                event.getAction() == KeyEvent.ACTION_UP) {
            setFocusable(false);
            setFocusableInTouchMode(false);
            return false;
        }
        return super.onKeyPreIme(keyCode, event);
    }
}
