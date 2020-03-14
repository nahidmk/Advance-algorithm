package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
	  int arr[] = {4,10,3,12,20,7};
	  int n = arr.length;
	  int result = mcm(arr,n);
        System.out.println("result : "+result);
    }

    private static int mcm(int[] arr, int n) {
        int t[][] = new int[n][n];
        int s[][] = new int[n][n];
        List<String> matrix = new ArrayList<>();
        matrix.add("(");
        for(int l = 2;l<n;l++)
        {
            for(int i = 1;i<n-l+1;i++)
            {
                int j = i+l-1;
                t[i][j] = Integer.MAX_VALUE;
                for(int k = i;k<j;k++)
                {
                    int value = t[i][k]+t[k+1][j]+arr[i-1]*arr[k]*arr[j];
                    if(t[i][j]>value)
                    {
                        t[i][j] = value;
                        s[i][j] = k;
                    }
                }
            }
        }
//        for(int i = 1;i<n-1;i++)
//        {
//            for(int j =2;j<n;j++)
//            {
//                System.out.print(s[i][j]+" ");
//            }
//            System.out.println();
//        }
        for(int i = 0;i<n-1;i++)
        {
            matrix.add("M"+(i+1));
        }
        matrix.add(")");
        calculateExpresion(s,1,n-1);
        System.out.println();
        return t[1][n-1];
    }

    private static void calculateExpresion(int[][] s, int i,int j) {
        if(i==j)
        {
            System.out.print("M"+i+" ");
        }else
        {
            System.out.print("(");
            calculateExpresion(s,i,s[i][j]);
            calculateExpresion(s,s[i][j]+1,j);
            System.out.print(")");
        }


    }
}
