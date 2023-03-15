package com.symphony.BuyPoints.exception.custom;

public class ChartNameExistsException extends RuntimeException{

    public ChartNameExistsException(String name) {
        super("Chart name already exists " + name);
    }

}
