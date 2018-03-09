package android.hospital.ux;

import android.content.Context;
import android.content.Intent;
import android.hospital.R;
import android.hospital.lib.edittext.MyCustomEditText;
import android.hospital.listeners.OnSingleClickListener;
import android.hospital.listeners.OnTouchPasswordListener;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    protected TextView term_of_use_and_policy, sign_in, sign_up;
    protected ImageView back;
    protected RelativeLayout content;
    protected MyCustomEditText sign_in_username, sign_in_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initData();
    }

    protected void initView() {
        term_of_use_and_policy = findViewById(R.id.term_of_use_and_policy);
        sign_in = findViewById(R.id.sign_in);
        sign_up = findViewById(R.id.sign_up);
        back = findViewById(R.id.back);
        content = findViewById(R.id.content);
        sign_in_username = findViewById(R.id.sign_in_username);
        sign_in_password = findViewById(R.id.sign_in_password);
    }

    protected void initData() {
        term_of_use_and_policy.setText(Html.fromHtml("By signing in, you confirm that you accept our <font color=\"#3584BD\">Terms of Use</font> and <font color=\"#3584BD\">Privacy Policy</font>"));
        setupUI(content);
        sign_in.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                finish();
                startActivity(mainIntent);
            }
        });

        back.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View view) {
                finish();
            }
        });
        sign_in_password.setOnTouchListener(new OnTouchPasswordListener(sign_in_password));
    }

    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof MyCustomEditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getWindow().getDecorView().getRootView().getWindowToken(), 0);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }

}
