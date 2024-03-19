package com.br.aula05;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class Greeting {
    private  final  long id;
    private  final  String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public long getId() {
        return id;
    }


}
