package lol;

import javaslang.collection.List;
import javaslang.control.Option;

public class Main {
    public static void main(String[] args) {

        Finder finder = new Finder();

        String input = "a1";
        Option<A> optA = finder.findA(input);

        //...
    }
}

class A {
    String aid;
    String bid;

    A(String aid, String bid) {
        this.aid = aid;
        this.bid = bid;
    }
}

class B {
    String bid;

    B(String bid) {
        this.bid = bid;
    }
}

class Finder {

    private static List<A> AAA = List.of(new A("a1", "b1"), new A("a2", "b2"));
    private static List<B> BBB = List.of(new B("b1"));

    Option<A> findA(String aid) {
        return AAA.find(a -> a.aid.equals(aid));
    }

    Option<B> findB(String bid) {
        return BBB.find(b -> b.bid.equals(bid));
    }

}