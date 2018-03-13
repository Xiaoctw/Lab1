package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testMagicSquares {
    MagicSquares magicSquares=null;
    @Before
    public void test(){
        magicSquares=new MagicSquares();
    }
    @Test
    public void testfile1(){
        boolean result=magicSquares.isLegalMagicSquare("1.txt");
       // System.out.println(magicSquares.isLegalMagicSquare("1.txt"));
        Assert.assertEquals(true,result);
    }
    @Test
    public void testfile2(){
     //   MagicSquares magicSquares=new MagicSquares();
        boolean result=magicSquares.isLegalMagicSquare("2.txt");
        Assert.assertEquals(true,result);
    }
    @Test
    public void testfile3(){
      //  MagicSquares magicSquares=new MagicSquares();
        boolean result=magicSquares.isLegalMagicSquare("3.txt");
        Assert.assertEquals(false,result);
    }
    @Test
    public void testfile4(){
      //  MagicSquares magicSquares=new MagicSquares();
        boolean result=magicSquares.isLegalMagicSquare("4.txt");
        Assert.assertEquals(false,result);
    }
    @Test
    public void testfile5(){
    //    MagicSquares magicSquares=new MagicSquares();
        boolean result=magicSquares.isLegalMagicSquare("5.txt");
        Assert.assertEquals(false,result);
    }
    @Test
    public void testgenerate1(){
        boolean result=MagicSquares.generateMagicSquare(4);
        Assert.assertEquals(false,result);
    }
    @Test
    public void testgenerate2(){
       boolean result=MagicSquares.generateMagicSquare(3);
        Assert.assertEquals(true,result);
    }
}
