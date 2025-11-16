package com.laboratoriochad.utils;

import java.util.Scanner;

public class ManejoConsola {

    private final Scanner sc = new Scanner(System.in);

    public int leerEntero(String msg) {
        System.out.print(msg);
        return Integer.parseInt(sc.nextLine());
    }

    public String leerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public boolean leerBoolean(String msg) {
        System.out.print(msg);
        return Boolean.parseBoolean(sc.nextLine());
    }
}