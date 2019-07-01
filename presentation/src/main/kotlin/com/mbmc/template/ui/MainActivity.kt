package com.mbmc.template.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mbmc.template.R
import com.mbmc.template.databinding.ActivityMainBinding
import com.mbmc.template.event.UserEventHandler
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable

import javax.inject.Inject

class MainActivity : AppCompatActivity(), UserEventHandler {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val disposables = CompositeDisposable()
    private val uiSate = UiSate()
    private val repoAdapter = RepoAdapter()
    private lateinit var repoViewModel: RepoViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var handle: String

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
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

        repoViewModel = ViewModelProviders.of(this, viewModelFactory).get(RepoViewModel::class.java)

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
