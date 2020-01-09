package ru.kravchenko.se.proxy;

import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JsoupProxyTest {

    private Map<String, String> boomers = new HashMap<>();

    @Before
    public void fillBoomers() {
        boomers.put("10Bet","https://www.10bet.com/"); //OK
        boomers.put("12Bet","http://www.12bet.com/"); // not starter page 7.01
        boomers.put("188bet","http://www.188bet.com/"); // not starter page 7.01
        boomers.put("18bet","https://www.18bet.com/en/euro/home"); // not parsing
        boomers.put("1xbet","https://1xbet.com/"); // not starter page 7.01
        boomers.put("888","https://www.888.ru"); // OK
        boomers.put("5dimes","https://www.5dimes.com/"); //OK
    }

    @Test
    public void showBoomers() {
        System.out.println(boomers.get("10Bet"));
    }
    @Test
    @SneakyThrows
    public void jsoupProxy() {
        String bookmerUrl = boomers.get("5dimes");
        for (int i = 1; i < 10; i++) {
            try {
           // Document doc = Jsoup.connect("https://www.marathonbet.com").proxy("212.87.248.11", 40762).get();
               Document doc = Jsoup.connect(bookmerUrl).proxy("5.15.180.175", 8080).get();
           //     Document doc = Jsoup.connect("https://2ip.ru/").proxy("212.87.248.11", 40762).get();
        //        Document doc = Jsoup.connect("https://1xbet.com/").proxy("212.87.248.11", 40762).get();
                System.out.println(doc);
            } catch (Exception e) {
                System.out.println("EXCEPTION: " + e.getMessage());
            }
            System.out.println("*****************************");
            System.out.println("COUNT: " + i);
            System.out.println("*****************************");
            Thread.sleep(2000);
        }
    }

}
