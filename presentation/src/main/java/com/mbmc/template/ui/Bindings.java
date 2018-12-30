package com.mbmc.template.ui;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public final class Bindings {

    @BindingAdapter("adapter")
    public static void setAdapter(RecyclerView recyclerView, RepoAdapter repoAdapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(repoAdapter);
    }

    private Bindings() {

    }

}
