package io.rnkit.actionsheetpicker.view;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

import io.rnkit.actionsheetpicker.R;

/**
 * Created by SimMan on 2016/11/30.
 */

public class DatePickerView extends TimePickerView implements DefaultHardwareBackBtnHandler{

    private TextView btnSubmit, btnCancel, tvTitle;
    private static final String TAG_SUBMIT = "submit";
    private static final String TAG_CANCEL = "cancel";
    private OnTimeCancelListener timeCancelListener;

    public DatePickerView(Context context, Type type) {
        super(context, type);

        btnSubmit = (TextView) findViewById(R.id.btnSubmit);
        btnCancel = (TextView) findViewById(R.id.btnCancel);
        tvTitle = (TextView) findViewById(R.id.tvTitle);

        btnCancel.setTextSize(15);

        btnSubmit.setTextSize(15);
        btnSubmit.setGravity(Gravity.RIGHT|Gravity.CENTER_VERTICAL);

        tvTitle.setTextSize(18);

        year =(TextView) findViewById(R.id.year);
        month = (TextView) findViewById(R.id.month);
        day = (TextView) findViewById(R.id.day);
        hours = (TextView) findViewById(R.id.hour);
        minutes = (TextView) findViewById(R.id.min);
    }

    @Override
    public void onClick(View v) {
        String tag = (String) v.getTag();
        if (tag.equals(TAG_CANCEL)) {
            dismiss();
            if (timeCancelListener != null) {
                timeCancelListener.onCancel();
            }
            return;
        }
        super.onClick(v);
    }

//    public static int sp2px(Context context, float spValue) {
//        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
//        return (int) (spValue * fontScale + 0.5f);
//    }

    public interface OnTimeCancelListener {
        void onCancel();
    }

    public void setOnTimeCancelListener(OnTimeCancelListener timeCancelListener) {
        this.timeCancelListener = timeCancelListener;
    }

    public TextView getSubmitButton() {
        return this.btnSubmit;
    }

    public TextView getCancelButton() {
        return this.btnCancel;
    }

    public TextView getTitle() {
        return this.tvTitle;
    }

    public TextView getMinutes() {
        return minutes;
    }

    public TextView getYear() {
        return year;
    }

    public TextView getMonth() {
        return month;
    }

    public TextView getDay() {
        return day;
    }

    public TextView getHours() {
        return hours;
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        if (this.isShowing()) {
            this.dismissImmediately();
        }
    }
}
