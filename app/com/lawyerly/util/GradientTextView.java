package app.com.lawyerly.util;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import app.com.lawyerly.R;

public class GradientTextView extends android.support.v7.widget.AppCompatTextView {

    public GradientTextView(Context context) {
        super(context);
    }

    public GradientTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GradientTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        //Setting the gradient if layout is changed
        if (changed) {
            getPaint().setShader(new LinearGradient(0, 0, getWidth(), getHeight(),
                    ContextCompat.getColor(getContext(), R.color.green),
                    ContextCompat.getColor(getContext(), R.color.light_yellow),
                    Shader.TileMode.CLAMP));
        }
    }
}