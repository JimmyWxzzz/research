package com.example.customspringbootstarterautoconfigure.service.bean;


import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties("name")
public class helloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
