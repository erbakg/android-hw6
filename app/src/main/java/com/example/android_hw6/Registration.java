package com.example.android_hw6;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

public class Registration {
   private String email;
    private String password;

    private boolean signInStatus = false;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSignInStatus() {
        return signInStatus;
    }

    public void setSignInStatus(boolean signInStatus) {
        this.signInStatus = signInStatus;
    }
    // Define an interface for observing data changes
    public interface DataChangeListener {
        void onDataChanged(boolean newData);
    }

    private DataChangeListener listener;

    public void setListener(DataChangeListener listener) {
        this.listener = listener;
    }

    private void notifyDataChanged() {
        if (listener != null) {
            listener.onDataChanged(signInStatus);
        }
    }

    public void signIn(
            ConstraintLayout mainLayout,
            AppCompatEditText emailTextEdit,
            AppCompatEditText passwordTextEdit,
            Intent intent,
            AppCompatActivity activity
    ) {
        if (email.equals("admin") && password.equals("admin")) {
            this.signInStatus = true;
            notifyDataChanged();
        } else {
            Snackbar snackbar = Snackbar
                    .make(mainLayout, "Pass is not correct!", Snackbar.LENGTH_LONG)
                    .setAction("RETRY", view -> {
                        emailTextEdit.setText("");
                        passwordTextEdit.setText("");
                    });
            snackbar.show();
        }
    }
}
