package com.ProyectoFinal;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        var claveManuel = encoder.encode("111");
        var claveSaul = encoder.encode("222");
        var claveJoshua = encoder.encode("333");
        System.out.println("Manuel (111) : " + claveManuel);
        System.out.println("Saul (222) : " + claveSaul);
        System.out.println("Joshua (333) : " + claveJoshua);

    }

}
