package com.example.android_hw6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Registration.DataChangeListener {

    Registration user = new Registration();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        Context context = getApplicationContext();
        Intent intent = new Intent(context, MainActivity.class);

        user.setListener(this);

        AppCompatButton loginBtn = findViewById(R.id.login_btn);
        AppCompatEditText emailTextEdit = findViewById(R.id.mail_text);
        AppCompatEditText passwordTextEdit = findViewById(R.id.password_text);
        Log.d("hahah", "onCreate: " + user.isSignInStatus());
        if (user.isSignInStatus()) {
            loginBtn.setVisibility(View.GONE);
        }
        emailTextEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    loginBtn.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),
                            R.color.orange)));
                    user.setEmail(charSequence.toString());
                } else {
                    loginBtn.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),
                            R.color.gray)));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        passwordTextEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    loginBtn.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),
                            R.color.orange)));
                    user.setPassword(charSequence.toString());
                } else {
                    loginBtn.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),
                            R.color.gray)));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        ConstraintLayout mainLayout = findViewById(R.id.registration_screen);
        loginBtn.setOnClickListener(v -> {
            user.signIn(mainLayout, emailTextEdit, passwordTextEdit, intent, MainActivity.this);
        });
    }

    @Override
    public void onDataChanged(boolean newData) {
        AppCompatButton loginBtn = findViewById(R.id.login_btn);
        AppCompatEditText emailTextEdit = findViewById(R.id.mail_text);
        AppCompatEditText passwordTextEdit = findViewById(R.id.password_text);
        ConstraintLayout forgotTextView = findViewById(R.id.forgot_text_view);
        TextView smallTextView = findViewById(R.id.second_text);
        ConstraintLayout shadowView = findViewById(R.id.shadow_view);
        if (user.isSignInStatus()) {
            loginBtn.setVisibility(View.GONE);
            emailTextEdit.setVisibility(View.GONE);
            passwordTextEdit.setVisibility(View.GONE);
            forgotTextView.setVisibility(View.GONE);
            smallTextView.setVisibility(View.GONE);
        }
    }
}