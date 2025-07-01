package com.thou.mathutil.core;

import com.sun.jdi.Value;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


//cau lenh nay bao hieu rang se can loop qua tap data
//de lap cap data input/expected nhoi vao ham test
//@RunWith(Value = Parameterized.class) => JUNIT4
class MathUtilDDTTest {
    /* JUNIT4

    //ta se tra ve mang 2 chieu gom nhieu cap Expected|Input

    @Parameterized.Parameters
    //JUnit se ngam chay loop qua tung dong cua mang de lay ra dc cap data input/expected
    //ten ham khong quan trong, quan trong la @
    public static Object[][] initData(){
        return new Integer[][]{
                {0, 1},
                {1, 1,},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120}
        };
    }
    //gia su loop qua tung dong cua mang, ta van can gan tung value cua cot vao bien tuong ung input, expected de lat hoi feed cho ham

    @Parameterized.Parameter(value = 0)
    public int n; //bien map voi value cua cot 0 cua mang
    @Parameterized.Parameter(value = 1)
    public long expected; //kieu long vi gia tri tra ve cua ham getF() la long

    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell(){
        assertEquals(expected, MathUtil.getFactorial(n));
    }

     */

    //JUNIT5
    static Stream<Arguments> initData() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 6),
                Arguments.of(4, 24),
                Arguments.of(5, 120)
        );
    }

    @ParameterizedTest
    @MethodSource("initData")
    public void testGetFactorialGivenRightArgumentReturnsWell(int n, long expected) {
        assertEquals(expected, MathUtil.getFactorial(n));
    }
}