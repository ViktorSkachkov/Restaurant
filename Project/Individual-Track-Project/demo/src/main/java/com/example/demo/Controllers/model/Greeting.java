package com.example.demo.Controllers.model;

public class Greeting {
    private String content;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = "";
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
