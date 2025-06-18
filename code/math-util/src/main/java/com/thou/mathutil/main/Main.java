package com.thou.mathutil.main;

import com.thou.mathutil.core.MathUtil;

public class Main {
    public static void main(String[] args) {
        //thu nghiem ham tinh giai thua coi chay dung nhu thiet ke hay khong
        //ta phai dua ra cac tinh huong su dung ham trong thuc te

        /*
        TEST CASE: 1 tinh huong ham/app/man hinh/tinh nang
        duoc dua vao sd gia lap hanh vi dung cua ai do

        TEST CASE: LA 1 TINH HUONG SD, DUNG APP (HAY HAM) MA NO BAO GOM
        INPUT: DATA DAU VAO CU THE NAO DO
        OUTPUT: DAU RA UNG VOI XU LI CUA HAM/CHUC NANG CUA APP, DI NHIEN DUNG DAU VAO XU LI
        KI VONG (EXPECTED): MONG HAM SE TRA VE VALUE NAO DO UNG VOI INPUT O TREN
        SO SANH DE XEM XET KET QUA CO NHU KI VONG HAY KHONG
         */
        long expected = 120; //tao ki vong ham ói ve 120 neu tinh 5!
        int n = 5;
        long actual = MathUtil.getFactorial(n);
        System.out.println("5! = " + expected + " (expected)");
        System.out.println("5! = " + actual + " (actual)");
    }
}