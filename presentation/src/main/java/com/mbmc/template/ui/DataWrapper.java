package com.mbmc.template.ui;

public class DataWrapper<T> {

    public T data;
    public Throwable throwable;

    public DataWrapper(Throwable throwable) {
        this.throwable = throwable;
    }

    public DataWrapper(T data) {
        this.data = data;
    }

}