package com.example.lambda;

import java.util.Objects;
import java.util.function.Function;

public interface Delay {

    static  <V,T>  T runDelayed(Function<? super V, ? extends T> func,V param) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return func.apply(param);
    }

}
