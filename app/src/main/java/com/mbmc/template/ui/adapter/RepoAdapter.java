package com.mbmc.template.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mbmc.template.R;
import com.mbmc.template.model.Repo;
import com.mbmc.template.ui.activity.MainActivity;
import com.mbmc.template.util.Strings;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RepoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Repo> content = new ArrayList<>();


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_repo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ViewHolder viewHolder = (ViewHolder) holder;
        final Repo repo = content.get(position);
        viewHolder.nameView.setText(Strings.getRepoName(repo.name));
        viewHolder.dateView.setText(repo.getCreatedAt());
        viewHolder.ownerNameView.setText(repo.owner.login);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) viewHolder.itemView.getContext()).showRepo(repo);
            }
        });
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


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.repo_name) TextView nameView;
        @BindView(R.id.repo_date) TextView dateView;
        @BindView(R.id.repo_owner_name) TextView ownerNameView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
