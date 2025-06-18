package com.thou.lambda.main;

import com.thou.lambda.core.Salutation;

public class Main {
    public static void main(String[] args) {
       //xai interface kieu truyen thong - new class con da implements cha
        SalutationVN loiChao = new SalutationVN();
        loiChao.sayHello();

        //cach 2: khong them lam class con implements cha
        //xai kieu on-the-go, take-away
        //ANONUMOUS CLASS nghia la EO CAN TAO CLASS TUONG MINH, CHI CAN NEW VA GO CODE VA CHAM HOI

        Salutation helloEN = new Salutation() {
            @Override
            public void sayHello() {
                System.out.println("oi gioi oi trinh la gi ma lai rinh ai tam");
            }
        };
        helloEN.sayHello();
        //vi chi co 1 ham trong interface va can co code cho ham nay khi dung
        //du la anonymous hay lam class rieng
        //vi chi co 1 ham duy nhat can code/implement, tai sao ko tap trung vao code ma viet ca ten ham lam chi
        //rut gon tu class rieng thanh anonumou, bot dc ten class, bot luon ten ham cho gon => lambda expression
        //chi con cai day nit - code cua ham ma hoi
        //chi duoc xai cai day nit - lambda ex - khi choi voi functional interface - interface chi co 1 ham

        Salutation helloJP = () -> {
            System.out.println("watasio");
        };
        helloJP.sayHello();
    }
}