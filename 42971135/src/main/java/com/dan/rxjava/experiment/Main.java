package com.dan.rxjava.experiment;

import io.reactivex.Observable;

public class Main {
    public static void main(String[] args) {
        Observable.just("String").subscribe(System.out::print);
    }
}
