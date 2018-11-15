package com.contato;

public class Main {

    public static void main(String[] args) {

        String img = "edu.jpeg";

        int length = img.length();
        int index = img.indexOf(".");
        int ponto = index + 1;

        String substring = img.substring(ponto, length);
        System.out.println(substring);
        System.out.println("ponto = " + ponto);


    }
}
