package org.example;

import org.pojo.Product;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Handle nn = new Handle();
        Product pr = new Product("12","vip", 1221);
        nn.add(pr);
    }
}