package ru.kravchenko.se.logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class LogHandler implements InvocationHandler {

    private static final Logger LOGGER = Logger.getGlobal();

    private Object targer;

    public LogHandler(Object targer) {this.targer = targer;}

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LOGGER.info(proxy.getClass().getName() + "::" + method.getName());
        return method.invoke(targer, args);
    }
}
