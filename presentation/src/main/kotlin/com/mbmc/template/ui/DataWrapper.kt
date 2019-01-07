package com.mbmc.template.ui

class DataWrapper<T> {
    var data: T? = null
    var throwable: Throwable? = null

    constructor(data: T) {
        this.data = data
    }

    constructor(throwable: Throwable) {
        this.throwable = throwable
    }
}