package com.mbmc.template.ui.activity;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.mbmc.template.Application;
import com.mbmc.template.data.UnauthorizedException;
import com.mbmc.template.di.component.UiComponent;
import com.mbmc.template.helper.ErrorHandler;
import com.mbmc.template.helper.ImageLoader;
import com.mbmc.template.rest.GithubApi;
import com.mbmc.template.rest.IpApi;

import javax.inject.Inject;

import butterknife.ButterKnife;
import rx.Scheduler;
import rx.Subscription;


public class BaseActivity extends AppCompatActivity {

    @Inject ImageLoader imageLoader;
    @Inject GithubApi githubApi;
    @Inject IpApi ipApi;
    @Inject Scheduler scheduler;

    Subscription subscription;

    private UiComponent uiComponent;


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (uiComponent != null) {
            unInject();
        }
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }

    protected void inject() {
        getUiComponent().inject(this);
    }

    protected UiComponent getUiComponent() {
        if (uiComponent == null) {
            uiComponent = ((Application) getApplication()).getUiComponent();
        }
        return uiComponent;
    }

    protected void unInject() {
        uiComponent = null;
    }

    protected void bind() {
        ButterKnife.bind(this);
    }

    protected void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected void showToast(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_LONG).show();
    }

    protected void handleApiError(Throwable throwable) {
        try {
            showSnack(ErrorHandler.get(this, throwable));
        } catch (UnauthorizedException e) {
            // logout
        }
    }

    protected void showSnack(String string) {
        Snackbar snackbar =
                Snackbar.make(findViewById(android.R.id.content), string, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

}
