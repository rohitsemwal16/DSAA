package org.rosemwal.lld.designpatterns.singleton;

public class SingletonMain {

    public static void main(String[] args) {
        LoggerSingleton lazyLoggerInstance1 = LoggerSingleton.getLazyInstance();
        LoggerSingleton lazyLoggerInstance2 = LoggerSingleton.getLazyInstance();

        System.out.println("Lazy Loader Singleton Object "+ lazyLoggerInstance1 + " Second "+ lazyLoggerInstance2);

        LoggerSingleton eagerLoggerInstance1 = LoggerSingleton.getEagerInstance();
        LoggerSingleton eagerLoggerInstance2 = LoggerSingleton.getEagerInstance();

        System.out.println("Eager Loader Singleton Object "+ eagerLoggerInstance1 + " Second "+ eagerLoggerInstance2);


    }
}
