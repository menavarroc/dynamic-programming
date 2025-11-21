package com.homework.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knapsack {

    public static void knapsackSolution(int totalItems, int weightCapacity, int[] itemsWeight, int[] itemsValues) {

        int[][] virtualArray = new int[totalItems + 1][weightCapacity + 1];

        for (int row = 1; row < virtualArray.length; row++){
            for (int col = 0; col < virtualArray[0].length; col++) {
                int auxIndex = col - itemsWeight[row - 1];
                if (auxIndex < 0){
                    virtualArray[row][col] = Math.max(virtualArray[row -1][col], 0);
                } else {
                    virtualArray[row][col] = Math.max(virtualArray[row -1][col], virtualArray[row - 1][auxIndex] + itemsValues[row - 1]);
                }
            }
            System.out.println();
        }

        int auxWeightCapacity = weightCapacity;
        List<Integer> itemsSelected = new ArrayList<>();
        for (int i = totalItems; i > 0; i--) {
            if(virtualArray[i][auxWeightCapacity] != virtualArray[i - 1][auxWeightCapacity]){
                itemsSelected.add(i);
                auxWeightCapacity -=  itemsWeight[i - 1];
            }
        }

        System.out.println("Valor Mejor Mochila: " + virtualArray[totalItems][weightCapacity]);
        for (int element : itemsSelected){
            System.out.println("Object Selected: " + element);
        }
    }
}
