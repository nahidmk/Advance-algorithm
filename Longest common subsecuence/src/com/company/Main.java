package com.company;


public class Main {

    public static void main(String[] args) {
	    String s1 = "ABCBDAB";
	    String s2 = "ABDBCA";
	    int n1 = s1.length();
	    int n2 = s2.length();
	    lcs(s1,n1,s2,n2);
    }

    private static void lcs(String s1, int n1, String s2, int n2) {
        int arr[][] = new int[n1+1][n2+1];
        String graph[][] = new String [n1+1][n2+1];
        for(int i = 1;i<=n1;i++)
        {
            for(int j = 1;j<=n2;j++)
            {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    arr[i][j] = arr[i-1][j-1]+1;
                    graph[i][j] = "D";
                }
                else if(arr[i-1][j]>=arr[i][j-1])
                {
                    arr[i][j] = arr[i-1][j];
                    graph[i][j] = "U";
                }else
                {
                    arr[i][j] = arr[i][j-1];
                    graph[i][j] = "L";
                }
            }
        }
        int i = n1, j = n2;
        StringBuilder s = new StringBuilder();
        while (i>0 && j>0)
        {
            if(graph[i][j].equals("D"))
            {
                s.append(s1.charAt(i-1));
                i--;
                j--;
            }else if (graph[i][j].equals("U"))
            {
                i--;
            }else
            {
                j--;
            }
        }
        s = s.reverse();
        System.out.println("the word = "+s.toString());
    }
}
