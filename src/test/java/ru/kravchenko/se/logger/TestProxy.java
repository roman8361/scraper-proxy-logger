package ru.kravchenko.se.logger;

import org.junit.Test;

public class TestProxy {

    @Test
    public void test() {
        final TestService testService = TestService.create();
        testService.test();
        testService.run();
        testService.save();
        testService.save();
    }

}
