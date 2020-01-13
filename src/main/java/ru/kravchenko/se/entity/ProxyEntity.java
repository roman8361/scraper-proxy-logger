package ru.kravchenko.se.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProxyEntity extends AbstractEntity {

    private String ip;

    private String port;

    private String code;

    private String country;

    private String anonymity;

    private Boolean check = false;

    @Override
    public String toString() {
        return "ProxyEntity{" +
                "ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", code='" + code + '\'' +
                ", country='" + country + '\'' +
                ", anonymity='" + anonymity + '\'' +
                ", check=" + check +
                '}';
    }

}
