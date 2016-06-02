package com.mbmc.template.ui.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.mbmc.template.R;
import com.mbmc.template.model.Repo;
import com.mbmc.template.ui.component.RepoLayout;
import com.mbmc.template.util.Bundles;


public class RepoFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        RepoLayout repoLayout = (RepoLayout) View.inflate(getActivity(), R.layout.layout_repo, null);

        repoLayout.setContent((Repo) Bundles.getParcelable(getArguments()));

        return new AlertDialog.Builder(getActivity())
                .setView(repoLayout)
                .setTitle(R.string.repo)
                .create();

    }

}
