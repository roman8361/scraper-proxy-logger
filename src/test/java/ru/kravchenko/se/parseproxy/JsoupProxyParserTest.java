package ru.kravchenko.se.parseproxy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import ru.kravchenko.se.entity.ProxyEntity;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class JsoupProxyParserTest {

    @Test
    public void getHtmlProxyPage() throws IOException {
        String urlFreeProxyList = "https://free-proxy-list.net/";

        List<ProxyEntity> listProxy = getRowProxyList(urlFreeProxyList);
        listProxy.stream().forEach(System.out::println);
    }

    @Test
    public void getResponseCode() throws IOException {
        URL url = new URL("http://mail.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();


        int code = connection.getResponseCode();
        System.out.println(code);
    }

    @Test // TODO тестирование грязных и чистых прокси
    public void checkProxyListRowAndClean() throws IOException {
        List<ProxyEntity> rowProxyList = getRowProxyList("https://free-proxy-list.net/");
//        rowProxyList.stream().forEach(System.out::println);
        List<ProxyEntity> cleanProxyList = getCleanProxy(rowProxyList);
        cleanProxyList.stream().forEach(System.out::println);
    }

    private List<ProxyEntity> getCleanProxy(List<ProxyEntity> rowProxyList) throws IOException {
        List<ProxyEntity> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            try {
                ProxyEntity proxyEntity = rowProxyList.get(i);
                System.getProperties().put("proxySet", "true");
                System.getProperties().put("https.proxyHost", proxyEntity.getIp());
                System.getProperties().put("https.proxyPort", proxyEntity.getPort());
                HttpURLConnection conn = (HttpURLConnection) new URL("https://www.google.com").openConnection();
                conn.getContent();
                if (conn.getResponseCode() == 200) {
                    proxyEntity.setCheck(true);
                    System.out.println("ProxyEntity id: " + proxyEntity.getId());
                    System.out.println("ResponseCode: " + conn.getResponseCode());
                    System.out.println("Rejoice brothers and sisters!!!!");
                    result.add(proxyEntity);
                }
                conn.disconnect();
            } catch (SocketException | SSLHandshakeException e) {
                System.out.println(e);
            }
        }
        return result;
    }

    @Test
    public void connectUseProxy() throws IOException {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("36.89.165.89", 31647));
        URLConnection connection = new URL("http://mail.com").openConnection(proxy);

        System.out.println();
    }

    private List<ProxyEntity> getRowProxyList(String url) throws IOException {
        List<ProxyEntity> result = new ArrayList<>();
        String htmlProxyPage = Jsoup.connect(url).get().html();
        Document doc = Jsoup.parse(htmlProxyPage);

        Element table = doc.select("table").get(0); //select the first table.
        Elements rows = table.select("tr");

        for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            ProxyEntity proxyEntity = new ProxyEntity();
            proxyEntity.setIp(row.getElementsByTag("td").eq(0).text()); // ip
            proxyEntity.setPort(row.getElementsByTag("td").eq(1).text()); // port
            proxyEntity.setCode(row.getElementsByTag("td").eq(2).text()); // code
            proxyEntity.setCountry(row.getElementsByTag("td").eq(1).text()); // country
            proxyEntity.setAnonymity(row.getElementsByTag("td").eq(1).text()); // anonymity

            result.add(proxyEntity);
        }

        return result;
    }

}
