package com.haiprj.apps.openweather.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.haiprj.apps.openweather.App;
import com.haiprj.apps.openweather.R;
import com.haiprj.apps.openweather.base.BaseActivity;
import com.haiprj.apps.openweather.databinding.ActivitySignBinding;
import com.haiprj.apps.openweather.view.dialog.WarningDialog;

public class SignActivity extends BaseActivity<ActivitySignBinding> {

    public static enum SignType {
        SIGN_IN,
        SIGN_UP
    }
    public static void start(Context context) {
        Intent starter = new Intent(context, SignActivity.class);
        context.startActivity(starter);
    }
    private FirebaseAuth firebaseAuth;
    private SignType signType = SignType.SIGN_IN;
    @Override
    protected void initView() {
        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            App.getInstance().setFirebaseUser(firebaseAuth.getCurrentUser());
            startMain();
        }

        this.reloadView();
    }

    public void startMain() {
        MainActivity.start(this);
        this.finish();
    }

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void initData() {
        binding.signBtn.setOnClickListener(v -> {
            if (binding.email.getText().length() <= 0 || binding.pass.getText().length() <= 0) {
                WarningDialog.getInstance(this).showMessage(getString(R.string.warning_empty));
                return;
            }
            if (signType.equals(SignType.SIGN_IN)) {

                firebaseAuth.signInWithEmailAndPassword(
                        binding.email.getText().toString().trim(),
                        binding.pass.getText().toString().trim()
                ).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        App.getInstance().setFirebaseUser(task.getResult().getUser());
                        startMain();
                    }
                    else {
                        WarningDialog.getInstance(this).showMessage(task.getException().getMessage());
                    }
                });
            }
            else if (signType.equals(SignType.SIGN_UP)) {
                firebaseAuth.createUserWithEmailAndPassword(
                        binding.email.getText().toString().trim(),
                        binding.pass.getText().toString().trim()
                ).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        App.getInstance().setFirebaseUser(task.getResult().getUser());
                        startMain();
                    }
                    else {
                        WarningDialog.getInstance(this).showMessage(task.getException().getMessage());
                    }
                });
            }

        });
        this.binding.otherOptionBtn.setOnClickListener(v -> {
            if (this.signType.equals(SignType.SIGN_IN)) signType = SignType.SIGN_UP;
            else if (this.signType.equals(SignType.SIGN_UP)) {
                signType = SignType.SIGN_IN;
            }
            this.reloadView();
        });
    }

    private void reloadView() {
        if (signType.equals(SignType.SIGN_IN)) {
            this.binding.title.setText(getString(R.string.sign_in));
            this.binding.signBtn.setText(getString(R.string.sign_in));
            this.binding.otherOptionBtn.setText(getString(R.string.sign_up));
            this.binding.signBtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#009737")));
            this.binding.otherOptionBtn.setTextColor(getColor(R.color.purple_200));
        }
        else if (signType.equals(SignType.SIGN_UP)) {
            this.binding.title.setText(getString(R.string.sign_up));
            this.binding.signBtn.setText(getString(R.string.sign_up));
            this.binding.otherOptionBtn.setText(getString(R.string.sign_in));
            this.binding.signBtn.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.purple_200)));
            this.binding.otherOptionBtn.setTextColor(ColorStateList.valueOf(Color.parseColor("#009737")));
        }
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_sign;
    }
}
