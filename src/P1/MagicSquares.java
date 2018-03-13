package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class MagicSquares {

    public static void main(String[] args) throws IOException {
                MagicSquares magicSquares=new MagicSquares();
               System.out.println(magicSquares.isLegalMagicSquare("3.txt"));
        //   generateMagicSquare(10);
//        File file=new File("1.txt");
//        FileInputStream in=new FileInputStream(file);
//        Scanner scan=new Scanner(in);
//        while (scan.hasNext()){
//            System.out.print(scan.nextInt()+" ");
//
        MagicSquares.generateMagicSquare(4);
    }
    public boolean  isLegalMagicSquare(String filename){
        File file=new File(filename);
        try {
            FileReader fr=new FileReader(file);
            BufferedReader reader=new BufferedReader(fr);
            String line;
            while ((line=reader.readLine())!=null){
                if (line.indexOf(" ")!=-1){
                    System.out.println("数据中存在空格，错误");
                    return false;
                }
            }
            reader.close();
//            int n;
//            String line;
//            String firstLine="";
////            while ((line=reader.readLine())!=null){
//                firstLine=firstLine+line+"\t";
//            }
//            String[] arrs=firstLine.split("\t");
//            for (int i = 0; i <arrs.length ; i++) {
//                arrs[i].trim();
//            }
//            int[] arr=new int[arrs.length];
//            for(int i=0;i<arrs.length;i++) {
//                arr[i]= Integer.parseInt(arrs[i]);
//            }
//            n=(int) Math.sqrt(arrs.length);
//            if (n*n!=arrs.length){
//                return false;
//            }
            FileInputStream fileInputStream=new FileInputStream(filename);
            Scanner scanner=new Scanner(fileInputStream);
            int count=0;
            ArrayList<Integer> arrayList=new ArrayList<>();
            try {
                while (scanner.hasNext()) {
                    arrayList.add(scanner.nextInt());
                }
            }catch (java.util.InputMismatchException e){
                System.out.println("数据中存在浮点数");
                return false;
            }
           int n= (int) Math.sqrt(arrayList.size());
            if(n*n!=arrayList.size()){
                System.out.println("不符合幻方规格");
                return false;
            }
            int[][] data=new int[n][n];
            count=0;
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    data[i][j]=arrayList.get(count);
                    count++;
                }
            }
          //  test(data);
            int sumOfFirstLine=0;
            for(int i=0;i<n;i++) {
                sumOfFirstLine=sumOfFirstLine+data[0][i];
            }
            for(int i=0;i<n;i++) {
                int sumOfLine=0;
                for(int j=0;j<n;j++) {
                    sumOfLine=sumOfLine+data[i][j];
                }
                if(sumOfFirstLine!=sumOfLine) {
                    System.out.println("不符合幻方规格");
                    return false;
                }
            }
            for(int i=0;i<n;i++) {
                int sumOfLine=0;
                for(int j=0;j<n;j++) {
                    sumOfLine=sumOfLine+data[j][i];
                }
                if(sumOfFirstLine!=sumOfLine) {
                    System.out.println("不符合幻方规格");
                    return false;
                }
            }
            int sum1=0,sum2=0;
            for(int i=0;i<n;i++) {
                sum1=sum1+data[i][i];
                sum2=sum2+data[i][n-1-i];
            }
            if(sum1!=sumOfFirstLine) {
                System.out.println("不符合幻方规格");
                return false;
            }
            if(sum2!=sumOfFirstLine) {
                System.out.println("不符合幻方规格");
                return false;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    public static boolean generateMagicSquare(int n) {
        int [][]magic=new int[n][n];
        int row=0,col=n/2,i,j,square=n*n;
        for (i = 1; i <=square ; i++) {
            magic[row][col] = i;
            if (i % n == 0) {
                row++;
            } else {
                if (row == 0) {
                    row = n - 1;
                } else {
                    row--;
                }
                if (col == n - 1) {
                    col = 0;
                } else {
                    col++;
                }
            }
        }
        for ( i = 0; i < n; i++) {
            for (j=0;j<n;j++){
                System.out.println(magic[i][j]+"\t");
                System.out.println();
            }
        }
        return true;
    }
    public void test(int a[][]){
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[i].length ; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}

