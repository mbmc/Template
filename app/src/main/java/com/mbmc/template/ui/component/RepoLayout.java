package com.mbmc.template.ui.component;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mbmc.template.Application;
import com.mbmc.template.R;
import com.mbmc.template.helper.ImageLoader;
import com.mbmc.template.model.Repo;


public class RepoLayout extends LinearLayout {

    private TextView nameView;
    private TextView descriptionView;
    private TextView ownerNameView;
    private ImageView ownerAvatarView;


    public RepoLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        nameView = (TextView) findViewById(R.id.repo_name);
        descriptionView = (TextView) findViewById(R.id.repo_description);
        ownerNameView = (TextView) findViewById(R.id.repo_owner_name);
        ownerAvatarView = (ImageView) findViewById(R.id.repo_owner_avatar);
    }

    public void setContent(Repo repo) {
        nameView.setText(repo.name);
        descriptionView.setText(repo.description);
        ownerNameView.setText(repo.owner.login);
        Context context = getContext();
        ImageLoader imageLoader = ((Application) getContext().getApplicationContext())
                .getUiComponent().imageLoader();
        imageLoader.get(context, repo.owner.avatar, ownerAvatarView);
    }

}
