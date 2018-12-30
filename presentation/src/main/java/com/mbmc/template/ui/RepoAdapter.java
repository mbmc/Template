package com.mbmc.template.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.mbmc.template.BR;
import com.mbmc.template.R;
import com.mbmc.template.domain.entity.Repo;

import java.util.ArrayList;
import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

    private List<Repo> content = new ArrayList<>();

    @NonNull
    @Override
    public RepoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        return new ViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.repo_view,
                viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RepoAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bind(content.get(i));
    }

    @Override
    public int getItemCount() {
        return content.size();
    }

    public void setContent(List<Repo> content) {
        this.content.clear();
        this.content.addAll(content);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding dataBinding;

        public ViewHolder(ViewDataBinding dataBinding) {
            super(dataBinding.getRoot());
            this.dataBinding = dataBinding;
        }

        public void bind(Repo repo) {
            dataBinding.setVariable(BR.repo, repo);
            dataBinding.executePendingBindings();
        }
    }

}
