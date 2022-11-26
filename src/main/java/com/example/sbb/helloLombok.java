package com.example.sbb;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
//@Setter
public class helloLombok {
    private final String hello;
    private final int lombok;

    public static void main(String[] args) {
        helloLombok _helloLombok = new helloLombok("hello", 5);
//        _helloLombok.setHello("hellooooooo");
//        _helloLombok.setLombok(5);
        System.out.println(_helloLombok.getHello());
        System.out.println(_helloLombok.getLombok());
    }
}
