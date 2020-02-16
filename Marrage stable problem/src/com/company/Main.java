package com.company;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.Arrays;

public class Main {

    private static final int N = 5;

    public static void main(String[] args) {
	     int preparence[][] = {
                 {8, 6, 7, 5, 9},
                 {9, 7, 6, 5, 8},
                 {6, 9, 5, 8, 7},
                 {9, 6, 8, 7, 5},
                 {8, 5, 6, 7, 9},
                 {3, 1, 4, 2, 0},
                 {1, 0, 3, 2, 4},
                 {0, 2, 4, 3, 1},
                 {3, 0, 2, 1, 4},
                 {1, 4, 0, 2, 3}
         };
	     preparenceList(preparence);
    }

    private static void preparenceList(int[][] preparence) {
        int manStatus[] = new int[N];
        int womenPatner[] = new int[N];

        Arrays.fill(manStatus,0);
        Arrays.fill(womenPatner,-1);

        int freeman = N;
        while (freeman>0)
        {
            int man;
            for(man = 0;man<N;man++)
            {
                if(manStatus[man]==0)
                {
                    break;
                }
            }
            for(int i = 0;i<N && manStatus[man]==0;i++) {
                int women = preparence[man][i];
                if(womenPatner[women-N]== -1)
                {
                    womenPatner[women-N] = man;
                    manStatus[man] = 1;
                    freeman--;
                }else
                {
                    int current = womenPatner[women-N];
                    if(bestOne(preparence,women,man,current))
                    {
                        womenPatner[women-N] = man;
                        manStatus[man] = 1;
                        manStatus[current] = 0;
                    }
                }
            }
        }
        System.out.println("M  W");
        for(int i = 0;i<N;i++)
        {
            System.out.println(womenPatner[i]+"  "+(i+N));
        }
    }

    private static boolean bestOne(int[][] preparence, int women, int man, int current) {
        for(int i = 0;i<N;i++)
        {
            if(preparence[women][i]==man)
            {
                return true;
            }else if(preparence[women][i]==current)
            {
                return false;
            }
        }
        return false;
    }
}
