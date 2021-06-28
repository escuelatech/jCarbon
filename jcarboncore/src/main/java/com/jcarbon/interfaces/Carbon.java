package com.jcarbon.interfaces;

import java.util.Objects;
import java.util.function.Consumer;

//@FunctionalInterface
public interface Carbon<T> {
    T accept(T t);

//    default Consumer<T> andThen(Consumer<? super T> after) {
//        Objects.requireNonNull(after);
//        return (T t) -> { accept(t); after.accept(t); };
//    }
}
