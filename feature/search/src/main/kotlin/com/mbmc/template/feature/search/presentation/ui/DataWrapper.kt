package com.mbmc.template.feature.search.presentation.ui

class DataWrapper<T> {
    var data: T? = null
    var throwable: Throwable? = null
    var state: State = State.INIT

    enum class State {
        INIT,
        LOADING,
        SUCCESS,
        ERROR,
    }

    constructor(state: State) : this(state, null, null)

    constructor(data: T?) : this(State.SUCCESS, data, null)

    constructor(throwable: Throwable?) : this(State.ERROR, null, throwable)

    private constructor(state: State, data: T?, throwable: Throwable?) {
        this.state = state
        this.data = data
        this.throwable = throwable
    }
}