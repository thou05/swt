package com.thou.mathutil.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilTest {
    //day la class se su dung cac ham cua thu vien/framework JUnit
    //de kiem thu/kiem tra code chinh - ham getFactorial() ben class core.MathUtil
    //viet code de test code chinh ben kia!!

    //co nhieu quy tac dat ten ham kiem thu
    //ham duoi day la tinh huong test ham chay thanh cong
    //ta se dung ham kieu well - dua 5!, 6!, khong choi dua -5!, 30!
    //@Test JUnit se phoi hop voi JVM de chay ham nay
    //@Test phia hau truong chinh la public static void main()
    //co nhieu @Test ung voi nhieu case khac nhau de kiem thu tinh giai thua
    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        int n = 0; //test thu tinh huong tu te dau vao, may phai chay dung
        long expected = 1; //hi vong 0! = 1
        //long actual = ; goi ham can test ben core/app chinh/code chinh
        long actual = MathUtil.getFactorial(n);

        //so sanh expected vs. actual dung xanh xanh do do, framework
        assertEquals(expected, actual);
        //ham giup so sanh 2 gia tri nao do co giong nhau khong
        //neu giong => thay mau xanh den duong- duong thong, code ngon, it nhat cho case dang test
        //neu khong giong => thay mau do den duong, ham y expected khong giong actual

        //gop them vai case thanh cong/dau vao ngon!! ham phai tinh ngon
        assertEquals(1, MathUtil.getFactorial(1)); // 1! = 1
        assertEquals(2,  MathUtil.getFactorial(2));
        assertEquals(6,  MathUtil.getFactorial(3));
        assertEquals(24,  MathUtil.getFactorial(4));
        assertEquals(120,  MathUtil.getFactorial(5));
        assertEquals(720,  MathUtil.getFactorial(6));
    }

    /*ham getF() ta thiet ke co 2 tinh huong xu li
      1. dua data tu te trong khoang [0..20] -> tinh dung dc n! -> done
      2. dua data ca chon, am, > 20; THIET KE CUA HAM LA NEM RA NGOAI LE
        TAO KI VONG NGOAI LE XUAT HIEN KHI N < 0 || N > 20
        rat mong ngoai le xuat hien voi n ca chon nay

        neu ham nhan vao n < 0 hoac n > 20 va ham nem ra ngoai le
        => HAM CHAY DUNG NHU THIET KE  => XANH PHAI XUAT HIEN

        neu ham nhan vao n < 0 hoac n > 20 va lam khong nem ra ngoai le
        =>sure HAM CHAY SAI THIET KE, SAI KI VONG, MAU DO

        TEST CASE:
            input: -5
            expected: IllegalArgumentException xuat hien

        tinh huong bat thuong, ngoai le, ngoai du tinh, du lieu la nhung thu khong the do luong, so sanh theo kieu value => ma chi co the do luong = cach chung co xuat hien hay khong
        => assertEquals() khong dung de so sanh 2 ngoai le
     */

    @Test
    public void getFactorialGivenWrongArgumentThrowsException() {
        //assetThrows(tham so 1: loai ngoai le muon so sanh, tham so 2: doan code chay vang ra ngoai runnable
        assertThrows(IllegalArgumentException.class, () -> MathUtil.getFactorial(-5));
        assertThrows(IllegalArgumentException.class, () -> MathUtil.getFactorial(21));
    }

    //bat ngoai le, xem ham co nem ve ngoai le hay khong khi ca chon
    //co nem => tuc ham chay dung thiet ke => xanh
    @Test
    public void getFactorialGivenWrongArgumentThrowsException_TryCatch(){
        //chu dong kiem soat ngoai le
        try{
            MathUtil.getFactorial(-5);
        } catch (Exception e) {
            //bat try-catch la JUnit se ra xanh do da chu dong kiem soat ngoai le
            //nhung khong chac ngoai le minh can co xuat hien hay ko?
            //=> can co doan code kiem soat dung ngoai le IllegalArgumentException xuat hien
            assertEquals("Invalid n. Must be in range [0..20]", e.getMessage());
        }
    }
}