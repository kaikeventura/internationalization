package com.kaikeventura.internationalization;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class MyObject implements Serializable {

    @NotNull(message = "error.name")
    private String name;

    public MyObject() {
    }

    public MyObject(@NotNull String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
