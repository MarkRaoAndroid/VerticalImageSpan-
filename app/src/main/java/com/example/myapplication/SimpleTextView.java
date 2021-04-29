package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class SimpleTextView extends AppCompatTextView {

    private static final String TAG = "*";
    private int margin;

    public SimpleTextView(Context context) {
        super(context);
    }

    public SimpleTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public SimpleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SimpleTextView);
        margin = DpUtils.dip2px(context, 4);
        setTextContent(typedArray.getString(R.styleable.SimpleTextView_setText));
        typedArray.recycle();
    }

    public void setTextContent(Editable editable){
        if(!TextUtils.isEmpty(editable)){
            setTextContent(editable.toString());
        }
    }

    public void setTextContent(String content){
        if(!TextUtils.isEmpty(content)){
            SpannableString spannableString = new SpannableString(content + TAG);
            Drawable drawable = getResources().getDrawable(R.mipmap.icon_tips);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            VerticalImageSpan imageSpan = new VerticalImageSpan(drawable, margin, 0);
            spannableString.setSpan(imageSpan, content.length(), content.length() + TAG.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
            setText(spannableString);
        }
    }



}
