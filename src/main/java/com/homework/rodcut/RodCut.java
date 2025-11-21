package com.homework.rodcut;

public class RodCut {

    public static void RodCuttingSolution(int[] prices, int rodSize) {
        int[] revenueArray = new int[rodSize + 1];
        int[] solutionArray = new int[rodSize + 1];
        for (int j = 1; j <= rodSize; j++){
            int maxRevenue = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++){
                int currentRevenue = prices[i] + revenueArray[j - i];
                if(maxRevenue < currentRevenue){
                    maxRevenue = currentRevenue;
                    solutionArray[j] = i;
                }
            }
            revenueArray[j] = maxRevenue;
        }
        int n = rodSize - 1;
        while (n > 0){
            System.out.println(solutionArray[n]);
            n = n - solutionArray[n];
        }
    }
}
