package com.mbmc.template.feature.search.presentation.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.mbmc.template.feature.search.R
import com.mbmc.template.feature.search.databinding.ActivityMainBinding
import com.mbmc.template.feature.search.di.Injector.inject
import com.mbmc.template.feature.search.presentation.event.UserEventHandler
import io.reactivex.disposables.CompositeDisposable

import javax.inject.Inject

class MainActivity : AppCompatActivity(), UserEventHandler {

    @Inject
    lateinit var repoViewModel: RepoViewModel
    private val disposables = CompositeDisposable()
    private val uiSate = UiSate()
    private val repoAdapter = RepoAdapter()
    private lateinit var binding: ActivityMainBinding
    private lateinit var handle: String

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setupUi()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }

    override fun onClicked() {
        getRepos(handle)
    }

    override fun onRetryClicked() {
        onClicked()
    }

    override fun onTextChanged(charSequence: CharSequence) {
        handle = charSequence.toString()
        uiSate.setHasText(!TextUtils.isEmpty(handle))
    }

    private fun setupUi() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.userEventHandler = this
        binding.uiState = uiSate
        binding.adapter = repoAdapter

        repoViewModel.observeRepos
            .observe(this, Observer {
                when (it.state) {
                    DataWrapper.State.INIT -> uiSate.setIsIdle()
                    DataWrapper.State.LOADING -> uiSate.setIsLoading()
                    DataWrapper.State.ERROR -> uiSate.setHasError()
                    DataWrapper.State.SUCCESS -> repoAdapter.setContent(it.data!!)
                }
            })
    }

    private fun getRepos(handle: String) {
        repoViewModel.getRepos(handle)
    }
}
