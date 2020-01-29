package edu.ucsb.cs56.ratcalc.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class RationalTest {

    private Rational r_5_15;
    private Rational r_24_6;
    private Rational r_3_7;  
    private Rational r_13_4;
    private Rational r_20_25;
    private Rational r_25_20;
    private Rational r_0_1; 
    
    @Before public void setUp() {
	r_5_15 = new Rational(5,15);
	r_24_6 = new Rational(24,6);
	r_3_7  = new Rational(3,7);
	r_13_4 = new Rational(13,4);
	r_20_25 = new Rational(20,25);
	r_25_20 = new Rational(25,20); //This fraction was declared but
                                   //not initialized in the original
                                   //code. Is it okay if I initialized it?
    r_0_1 = new Rational(0,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_denom_zero() {
	Rational r = new Rational(1,0);
    }
    
    @Test
    public void test_getNumerator_20_25() {
	assertEquals(4, r_20_25.getNumerator());
    }
    
    @Test
    public void test_getNumerator_13_4() {
	assertEquals(13, r_13_4.getNumerator());
    }
    
    @Test
    public void test_getDenominator_20_25() {
	assertEquals(5, r_20_25.getDenominator());
    }
    
    @Test
    public void test_getDenominator_13_4() {
	assertEquals(4, r_13_4.getDenominator());
    }

    @Test
    public void test_toString_5_15() {
	assertEquals("1/3",r_5_15.toString());
    }

    @Test
    public void test_toString_24_6() {
	assertEquals("4",r_24_6.toString());
    }

    @Test
    public void test_toString_3_7() {
	assertEquals("3/7",r_3_7.toString());
    }
    
    @Test
    public void test_toString_20_25() {
	assertEquals("4/5",r_20_25.toString());
    }

    @Test
    public void test_toString_0_1() {
	assertEquals("0",r_0_1.toString());
    }

    @Test
    public void test_gcd_5_15() {
	assertEquals(5, Rational.gcd(5,15));
    }

    @Test
    public void test_gcd_15_5() {
	assertEquals(5, Rational.gcd(15,5));
    }

    @Test
    public void test_gcd_24_6() {
	assertEquals(6, Rational.gcd(24,6));
    }

    @Test
    public void test_gcd_17_5() {
	assertEquals(1, Rational.gcd(17,5));
    }
    
    @Test
    public void test_gcd_1_1() {
	assertEquals(1, Rational.gcd(1,1));
    }

    @Test
    public void test_gcd_20_25() {
	assertEquals(5, Rational.gcd(20,25));
    }

    @Test
    public void test_rational_m10_m5() {
	Rational r = new Rational(-10,-5);
	assertEquals("2",r.toString());
    }

    @Test
    public void test_rational_m5_6() {
	Rational r = new Rational(-5,6);
	assertEquals("-5/6",r.toString());
    }

    @Test
    public void test_rational_7_m8() {
	Rational r = new Rational(7,-8);
	assertEquals("-7/8",r.toString());
    }

    @Test
    public void test_r_5_15_times_r_3_7() {
	Rational r = r_5_15.times(r_3_7);
	assertEquals("1/7",r.toString());
    }

    @Test
    public void test_r_3_7_times_r_13_4() {
	Rational r = r_3_7.times(r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_r_m3_1_times_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = r_m3_1.times(r_1_m3);
	assertEquals("1",r.toString());
    }

   @Test
    public void test_product_of_r_5_15_and_r_3_7() {
       Rational r = Rational.product(r_5_15,r_3_7);
       assertEquals("1/7",r.toString());
    }

    @Test
    public void test_product_of_r_3_7_and_r_13_4() {
	Rational r = Rational.product(r_3_7,r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_product_of_r_m3_1_and_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = Rational.product(r_m3_1,r_1_m3);
	assertEquals("1",r.toString());
    }
 
    //////////////////////
    //                  //
    //  TESTS FOR PLUS  //
    //                  //
    //////////////////////

    @Test
    public void test_5_15_plus_13_4() {
    Rational r = r_5_15.plus(r_13_4);
    assertEquals("43/12",r.toString());
    }

    @Test
    public void test_3_7_plus_13_4() {
    Rational r = r_3_7.plus(r_13_4);
    assertEquals("103/28", r.toString());
    }

    @Test
    public void test_m3_4_plus_1_m5() {
    Rational r_m3_4 = new Rational(-3,4);
    Rational r_1_m5 = new Rational(1,-5);
    Rational r = r_m3_4.plus(r_1_m5);
    assertEquals("-19/20",r.toString());
    }

    @Test
    public void test_0_1_plus_24_6() {
    Rational r = r_0_1.plus(r_24_6);
    assertEquals("4",r.toString());
    }

    @Test
    public void test_m3_1_plus_1_3() {
    Rational r_m3_1 = new Rational(-3,1);
    Rational r_1_3 = new Rational(1,3);
    Rational r = r_m3_1.plus(r_1_3);
    assertEquals("-8/3",r.toString());
    }

    @Test
    public void test_3_2_plus_m1_3() {
    Rational r_3_2 = new Rational(3,2);
    Rational r_m1_3 = new Rational(-1,3);
    Rational r = r_3_2.plus(r_m1_3);
    assertEquals("7/6",r.toString());
    }

    /////////////////////
    //                 //
    //  TESTS FOR SUM  //
    //                 //
    /////////////////////

    @Test
    public void test_5_15_sum_13_4() {
    Rational r = Rational.sum(r_5_15, r_13_4);
    assertEquals("43/12",r.toString());
    }

    @Test
    public void test_3_7_sum_13_4() {
    Rational r = Rational.sum(r_3_7, r_13_4);
    assertEquals("103/28",r.toString());
    }

    @Test
    public void test_m3_4_sum_1_m5() {
    Rational r_m3_4 = new Rational(-3,4);
    Rational r_1_m5 = new Rational(1,-5);
    Rational r = Rational.sum(r_m3_4, r_1_m5);
    assertEquals("-19/20",r.toString());
    }

    @Test
    public void test_0_1_sum_24_6() {
    Rational r = Rational.sum(r_0_1, r_24_6);
    assertEquals("4",r.toString());
    }

    @Test
    public void test_m3_1_sum_1_3() {
    Rational r_m3_1 = new Rational(-3,1);
    Rational r_1_3 = new Rational(1,3);
    Rational r = Rational.sum(r_m3_1, r_1_3);
    assertEquals("-8/3",r.toString());
    }

    @Test
    public void test_3_2_sum_m1_3() {
    Rational r_3_2 = new Rational(3,2);
    Rational r_m1_3 = new Rational(-1,3);
    Rational r = Rational.sum(r_3_2, r_m1_3);
    assertEquals("7/6",r.toString());
    }


    ///////////////////////
    //                   //
    //  TESTS FOR MINUS  //
    //                   //
    ///////////////////////

    @Test
    public void test_5_15_minus_3_7() {
    Rational r = r_5_15.minus(r_3_7);
    assertEquals("-2/21",r.toString());
    }

    @Test
    public void test_3_7_minus_13_4() {
    Rational r = r_3_7.minus(r_13_4);
    assertEquals("-79/28",r.toString());
    }

    @Test
    public void test_m3_1_minus_1_m3() {
    Rational r_m3_1 = new Rational(-3,1);
    Rational r_1_m3 = new Rational(1,-3);
    Rational r = r_m3_1.minus(r_1_m3);
    assertEquals("-8/3",r.toString());
    }

    @Test
    public void test_0_1_minus_24_6() {
    Rational r = r_0_1.minus(r_24_6);
    assertEquals("-4",r.toString());
    }

    @Test
    public void test_m3_1_minus_1_3() {
    Rational r_m3_1 = new Rational(-3,1);
    Rational r_1_3 = new Rational(1,3);
    Rational r = r_m3_1.minus(r_1_3);
    assertEquals("-10/3",r.toString());
    }

    @Test
    public void test_3_2_minus_m1_3() {
    Rational r_3_2 = new Rational(3,2);
    Rational r_m1_3 = new Rational(-1,3);
    Rational r = r_3_2.minus(r_m1_3);
    assertEquals("11/6",r.toString());
    }


    ////////////////////////////
    //                        //
    //  TESTS FOR DIFFERENCE  //
    //                        //
    ////////////////////////////

    @Test
    public void test_5_15_difference_3_7() {
    Rational r = Rational.difference(r_5_15, r_3_7);
    assertEquals("-2/21",r.toString());
    }

    @Test
    public void test_3_7_difference_13_4() {
    Rational r = Rational.difference(r_3_7, r_13_4);
    assertEquals("-79/28",r.toString());
    }

    @Test
    public void test_m3_1_difference_1_m3() {
    Rational r_m3_1 = new Rational(-3,1);
    Rational r_1_m3 = new Rational(1,-3);
    Rational r = Rational. difference(r_m3_1, r_1_m3);
    assertEquals("-8/3",r.toString());
    }

    @Test
    public void test_0_1_difference_24_6() {
    Rational r = Rational. difference(r_0_1, r_24_6);
    assertEquals("-4",r.toString());
    }

    @Test
    public void test_m3_1_difference_1_3() {
    Rational r_m3_1 = new Rational(-3,1);
    Rational r_1_3 = new Rational(1,3);
    Rational r = Rational. difference(r_m3_1, r_1_3);
    assertEquals("-10/3",r.toString());
    }

    @Test
    public void test_3_2_difference_m1_3() {
    Rational r_3_2 = new Rational(3,2);
    Rational r_m1_3 = new Rational(-1,3);
    Rational r = Rational. difference(r_3_2, r_m1_3);
    assertEquals("11/6",r.toString());
    }

    ////////////////////////////
    //                        //
    //  TESTS FOR RECIPROCAL  //
    //                        //
    ////////////////////////////

    @Test
    public void test_recip_20_25() {
    Rational r = r_20_25.reciprocalOf();
    assertEquals("5/4",r.toString()); 
    }

    @Test
    public void test_recip_25_20() {
    Rational r = r_25_20.reciprocalOf();
    assertEquals("4/5",r.toString()); 
    }

    @Test
    public void test_recip_m3_4() {
    Rational r_m3_4 = new Rational(-3,4);
    Rational r = r_m3_4.reciprocalOf();
    assertEquals("-4/3",r.toString()); 
    }

    @Test
    public void test_recip_1_m2() {
    Rational r_1_m2 = new Rational(1,-2);
    Rational r = r_1_m2.reciprocalOf();
    assertEquals("-2",r.toString()); 
    }

    @Test
    public void test_recip_m5_m2() {
    Rational r_m5_m2 = new Rational(-5,-2);
    Rational r = r_m5_m2.reciprocalOf();
    assertEquals("2/5",r.toString()); 
    }

    @Test
    public void test_recip_1_5() {
    Rational r_1_5 = new Rational(1,5);
    Rational r = r_1_5.reciprocalOf();
    assertEquals("5",r.toString()); 
    }

    @Test (expected = ArithmeticException.class)
    public void test_recip_0_1() {
    Rational r = r_0_1.reciprocalOf();
    }

    ///////////////////////////
    //                       //
    //  TESTS FOR DIVIDEDBY  //
    //                       //
    ///////////////////////////

    @Test
    public void test_5_15_dividedBy_24_6() {
    Rational r = r_5_15.dividedBy(r_24_6);
    assertEquals("1/12",r.toString());
    }

    @Test
    public void test_3_7_dividedBy_20_25() {
    Rational r = r_3_7.dividedBy(r_20_25);
    assertEquals("15/28",r.toString());
    }

    @Test
    public void test_m1_2_dividedBy_3_m4() {
    Rational r_m1_2 = new Rational(-1,2);
    Rational r_3_m4 = new Rational(3,-4);
    Rational r = r_m1_2.dividedBy(r_3_m4);
    assertEquals("2/3",r.toString());
    }

    @Test
    public void test_1_2_dividedBy_3_m4() {
    Rational r_1_2 = new Rational(1,2);
    Rational r_3_m4 = new Rational(3,-4);
    Rational r = r_1_2.dividedBy(r_3_m4);
    assertEquals("-2/3",r.toString());
    }

    @Test
    public void test_m1_2_dividedBy_3_4() {
    Rational r_m1_2 = new Rational(-1,2);
    Rational r_3_4 = new Rational(3,4);
    Rational r = r_m1_2.dividedBy(r_3_4);
    assertEquals("-2/3",r.toString());
    }

    @Test (expected = ArithmeticException.class)
    public void test_any_dividedBy_0_1() {
    Rational r = r_5_15.dividedBy(r_0_1);
    }

    //////////////////////////
    //                      //
    //  TESTS FOR QUOTIENT  //
    //                      //
    //////////////////////////

    @Test
    public void test_5_15_quotient_24_6() {
    Rational r = Rational.quotient(r_5_15, r_24_6);
    assertEquals("1/12",r.toString());
    }

    @Test
    public void test_3_7_quotient_20_25() {
    Rational r = Rational.quotient(r_3_7, r_20_25);
    assertEquals("15/28",r.toString());
    }

    @Test
    public void test_m1_2_quotient_3_m4() {
    Rational r_m1_2 = new Rational(-1,2);
    Rational r_3_m4 = new Rational(3,-4);
    Rational r = Rational.quotient(r_m1_2, r_3_m4);
    assertEquals("2/3",r.toString());
    }

    @Test
    public void test_1_2_quotient_3_m4() {
    Rational r_1_2 = new Rational(1,2);
    Rational r_3_m4 = new Rational(3,-4);
    Rational r = Rational.quotient( r_1_2, r_3_m4);
    assertEquals("-2/3",r.toString());
    }

    @Test
    public void test_m1_2_quotient_3_4() {
    Rational r_m1_2 = new Rational(-1,2);
    Rational r_3_4 = new Rational(3,4);
    Rational r = Rational.quotient(r_m1_2, r_3_4);
    assertEquals("-2/3",r.toString());
    }

    @Test (expected = ArithmeticException.class)
    public void test_any_quotient_0_1() {
    Rational r = Rational.quotient(r_5_15, r_0_1);
    }

    /////////////////////
    //                 //
    //  TESTS FOR LCM  //
    //                 //
    /////////////////////

    @Test
    public void test_lcm_2_5() {
    assertEquals(10,Rational.lcm(2,5));
    }

    @Test
    public void test_lcm_3_6() {
    assertEquals(6,Rational.lcm(3,6));
    }

    @Test
    public void test_lcm_4_7() {
    assertEquals(28,Rational.lcm(4,7));
    }

    @Test
    public void test_lcm_5_8() {
    assertEquals(40,Rational.lcm(5,8));
    }

    @Test
    public void test_lcm_1_37() {
    assertEquals(37,Rational.lcm(1,37));
    }

    @Test
    public void test_lcm_0_29() {
    assertEquals(0,Rational.lcm(0,29));
    }

}
