package io.coffeelessprogrammer.dp;

import java.util.Arrays;

public class Knapsack {

    private static int[] weight = new int[]{1, 2, 4, 2, 5};
    private static int[] value = new int[]{5, 3, 5, 3, 2};

    private static int[][] memo;

    /**
     * Return the highest value knapsack based on the current inventory
     * @param startingCapacity Initial capacity of Knapsack
     */
    public static int fillKnapsack(int startingCapacity) {
        initializeMemo(startingCapacity);
        return fillKnapsack(weight.length-1, startingCapacity);
    }

    /**
     * Return the highest value knapsack based on the current inventory
     * @param n Current item's index
     * @param C Capacity remaining in Knapsack
     */
    private static int fillKnapsack(int n, int C) {
        if(n == -1) return 0;
        if(memo[n][C] != -1) return memo[n][C];

        int result;

        if(C==0)
            result = 0;
        else if(weight[n] > C)
            result = fillKnapsack(n-1, C);
        else {
            int skipItem = fillKnapsack(n-1, C);
            int includeItem = value[n] + fillKnapsack(n-1, C-weight[n]);
            result = Math.max(skipItem, includeItem);
        }

        memo[n][C] = result;

        return result;
    }

    // #region ShowSteps

    private static int depth;
    private static int currentKnapsackValue;
    private static String[] tabs;

    public static int showSteps(int startingCapacity) {
        depth = 0;
        currentKnapsackValue = 0;
        initializeTabs();
        initializeMemo(startingCapacity);
        System.out.printf("N=Item\nCR=Capacity remaining\nKS=Knapsack value\nV=Item value\nC=Current Capacity\nW=Item weight\n");
        return fillShowSteps(weight.length-1, startingCapacity);
    }

    private static int fillShowSteps(int n, int C) {
        if(n == -1) return 0;

        System.out.printf("\n%sN=%d, CR=%d, KV=%d\n", tabs[depth], n+1, C, currentKnapsackValue);
        if(memo[n][C] != -1) return memo[n][C];

        int result;

        if(C==0){
            System.out.printf("%s- The bag is full!\n", tabs[depth]);
            result = 0;
        }
        else if(weight[n] > C) {
            System.out.printf("%s- Item weight (%d) exceeds remaining capacity\n", tabs[depth], weight[n]);
            ++depth;
            result = fillShowSteps(n-1, C);
        }
        else {
            ++depth;

            // Skip item
            System.out.printf("%s- Skipping item %d (C=%d)\n", tabs[depth], n+1, C);
            int skipItem = fillShowSteps(n-1, C);

            // Include item
            System.out.printf("%s- Including item %d [V=%d] (C=%d, W=%d)\n", tabs[depth], n+1, value[n], C, weight[n]);
            currentKnapsackValue += value[n];
            int includeItem = value[n] + fillShowSteps(n-1, C-weight[n]);
            result = Math.max(skipItem, includeItem);
        }

        memo[n][C] = result;

        System.out.println(stringifyMemo());

        --depth;
        currentKnapsackValue -= value[n];

        return result;
    }

    // #endRegion

    // #region Helpers

    private static void initializeMemo(int knapsackCapacity) {
        memo = new int[weight.length][knapsackCapacity+1];

        for(int i=0; i < weight.length; ++i) {
            for(int j=0; j < knapsackCapacity+1; ++j) {
                memo[i][j] = -1;
            }
        }
    }

    private static void initializeTabs() {
        tabs = new String[weight.length+1];

        StringBuilder sb = new StringBuilder();

        for(int i=0; i < weight.length+1; ++i) {
            tabs[i] = sb.toString();
            sb.append("\t");
        }
    }

    private static String stringifyMemo() {
        StringBuilder sb = new StringBuilder(tabs[depth] + "[\n");

        for(int i= weight.length-1; i > -1; --i) {
            sb.append(tabs[depth]).append("\tn=").append(i+1).append("\t").append(stringify2DigitArray(memo[i])).append("\n");
        }
        sb.append(tabs[depth]).append("]\n");

        return sb.toString();
    }

    private static String stringify2DigitArray(int[] arr) {
        StringBuilder sb = new StringBuilder("[^");

        for(int i=1; i < arr.length; ++i) {
            if(arr[i] == -1) sb.append(",   ");
            else if(Integer.toString(arr[i]).length() == 1) sb.append(",  ").append(arr[i]);
            else sb.append(", ").append(arr[i]);
        }

        return sb.append("]\n").toString();
    }

    // #endRegion
}
