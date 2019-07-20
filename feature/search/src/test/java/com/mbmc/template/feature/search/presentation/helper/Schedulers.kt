package com.mbmc.template.feature.search.presentation.helper

import com.mbmc.template.common.core.util.Schedulers

object Schedulers {
    fun test(): Schedulers =
        Schedulers(io.reactivex.schedulers.Schedulers.trampoline(), io.reactivex.schedulers.Schedulers.trampoline())
}