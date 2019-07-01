package com.mbmc.template.helper

import com.mbmc.template.util.Schedulers

object Schedulers {
    fun test(): Schedulers =
        Schedulers(io.reactivex.schedulers.Schedulers.trampoline(), io.reactivex.schedulers.Schedulers.trampoline())
}