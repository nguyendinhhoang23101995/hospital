package android.hospital.utils;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class RecyclerNullDecorator extends RecyclerView.ItemDecoration {

    private int marginHorizontal = 0;
    private int marginVertical = 0;

    public RecyclerNullDecorator(int margin) {
        this.marginVertical = margin;
        this.marginHorizontal = margin;
    }

    public RecyclerNullDecorator(Context context, ORIENTATION orientation) {
        if (orientation == ORIENTATION.VERTICAL) {
            this.marginVertical = 0;
        } else if (orientation == ORIENTATION.HORIZONTAL) {
            this.marginHorizontal = 0;
        } else {
            this.marginVertical = 0;
            this.marginHorizontal = 0;
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(marginHorizontal, marginVertical, marginHorizontal, marginVertical);
    }

    public enum ORIENTATION {
        HORIZONTAL, VERTICAL, BOTH
    }

}
