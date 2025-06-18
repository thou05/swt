package com.thou.mathutil.core;

public class MathUtil {

    /*
    trong class nay cung cap cho ai do nhieu ham xu li toan hoc
    clone class Math cu JDK
    hàm thư vien dung chung cho ai do, ko can luu lai trang thai/gia tri
    chon thiet ke la ham static
     */

    //ham tinh giai thua
    /*
    n! = 1.2.3...n
    khong co giai thua cho so am
    0! = 1! = 1 quy uoc
    gia thua hàm đồ thị dốc đứng, tang nhanh ve gia tri
    20 gia thua 18 con so 0, vua kip du cho kieu long cua java
    21 giai thua tran kieu long
    bai nay quy uoc tinh n! trong khoang tu 0 -> 20
     */
    public static long getFactorial(int n){
        if(n < 0 || n > 20){
            throw new IllegalArgumentException("Invalid n. Must be in range [0..20]");
        }
        if(n == 0 || n == 1){
            return 1;
        }
        long product = 1; //bien tich luy, tich nhan don, thuat toan heo dat
        for(int i = 2; i <= n; i++){
            product *= i;
        }
        return product;
    }

    //ctrl + shift + t de chon test

}
