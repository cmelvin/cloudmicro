package com.cloudmicro.microservices.genericpubservice;



public class DataBean {


    private Long id;
    private String data;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DataBean(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    public DataBean() {
    }
}
