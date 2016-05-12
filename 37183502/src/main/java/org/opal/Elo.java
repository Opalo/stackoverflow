package org.opal;

import rx.Observable;
import rx.functions.Action1;

public class Elo {
    public static void main(String[] args) {
        hello("1", "2");
    }

    public static void hello(String... names) {
        Observable.from(names).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("Hello " + s + "!");
            }
        });
    }
}
