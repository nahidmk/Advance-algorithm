package com.company;

public class Main {

    public static void main(String[] args) {
        int n = 7;
        int coin[] = {1, 2, 3, 5};
        int value[] = new int[n + 1];
        Coin_Change_problem(7, coin);

    }

    private static void Coin_Change_problem(int n, int[] coin) {
        int t[][] = new int[coin.length + 1][n + 1];
        t[0][0] = 1;
        for (int i = 1; i <= coin.length; i++) {
            for (int j = 0; j <= n; j++) {
                if (coin[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                }else {
                    int v = j - coin[i - 1];
                    t[i][j] = t[i - 1][j] + t[i][v];
                }
            }
        }
        for (int i = 0; i <= coin.length; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("result : " + t[coin.length][n]);
    }
}

