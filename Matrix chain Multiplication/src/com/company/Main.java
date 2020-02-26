package com.company;

public class Main {

    public static void main(String[] args) {
	  int arr[] = {4,10,3,12,20,7};
	  int n = arr.length;
	  int result = mcm(arr,n);
        System.out.println("result : "+result);
    }

    private static int mcm(int[] arr, int n) {
        int t[][] = new int[n][n];
        for(int l = 2;l<n;l++)
        {
            for(int i = 1;i<n-l+1;i++)
            {
                int j = i+l-1;
                if(j==i)
                {
                    t[i][j]=0;
                }
                t[i][j] = Integer.MAX_VALUE;
                for(int k = i;k<j;k++)
                {
                    int value = t[i][k]+t[k+1][j]+arr[i-1]*arr[k]*arr[j];
                    if(t[i][j]>value)
                    {
                        t[i][j] = value;
                    }
                }
            }
        }

        return t[1][n-1];
    }
}
