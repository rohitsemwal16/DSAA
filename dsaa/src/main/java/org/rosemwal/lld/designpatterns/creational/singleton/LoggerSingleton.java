package org.rosemwal.lld.designpatterns.creational.singleton;

public class LoggerSingleton {

    private static LoggerSingleton lazyInstance = null;
    private static LoggerSingleton eagerInstance = new LoggerSingleton();

    private LoggerSingleton()   {
        // No OP
    }

    public static LoggerSingleton getLazyInstance() { // LAZY LOADING // loading when needed instead of app startup
        if (lazyInstance == null)    {
            lazyInstance = new LoggerSingleton();
        }
        return lazyInstance;
    }

    public static LoggerSingleton getLazyInstanceThreadSafe() { // LAZY LOADING // loading when needed instead of app startup
        if (lazyInstance == null)    {
            synchronized (LoggerSingleton.class) {
                if (lazyInstance == null) {
                    lazyInstance = new LoggerSingleton();
                }
            }
        }
        return lazyInstance;
    }

    public static LoggerSingleton getEagerInstance() { // LAZY LOADING // loading when needed instead of app startup
        return eagerInstance;
    }
}
