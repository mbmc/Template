package com.mbmc.template.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.mbmc.template.BR
import com.mbmc.template.R
import com.mbmc.template.entity.Repo

class RepoAdapter : RecyclerView.Adapter<RepoAdapter.ViewHolder>() {
    private val content = ArrayList<Repo>()

    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, position: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        return ViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.repo_view, viewGroup, false))
    }

    override fun onBindViewHolder(@NonNull viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(content[position])
    }

    override fun getItemCount(): Int = content.size

    fun setContent(content: List<Repo>) {
        this.content.clear()
        this.content.addAll(content)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val dataBinding: ViewDataBinding) : RecyclerView.ViewHolder(dataBinding.root) {
        fun bind(repo: Repo) {
            dataBinding.setVariable(BR.repo, repo)
            dataBinding.executePendingBindings()
        }
    }
}
