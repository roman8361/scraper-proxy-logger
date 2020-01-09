package ru.kravchenko.se.logger;

import java.lang.reflect.Proxy;

public interface TestService {


    static TestService create() {
        final TestService bean = new TestServiceImpl();
        final Class[] classes = new Class[] {
                TestService.class
        };
        final ClassLoader classLoader = TestService.class.getClassLoader();
        final LogHandler handler = new LogHandler(bean);
        return (TestService) Proxy.newProxyInstance(classLoader,classes, handler);

    }

    void run();

    void test();

    void save();

}
