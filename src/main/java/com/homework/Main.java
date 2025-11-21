package com.homework;

import com.homework.knapsack.Knapsack;
import com.homework.knapsack.MatrixChainMultiplication;
import com.homework.knapsack.RodCut;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
//        executeKnapSack();
//        executeRocCut();
        executeMatrixChain();
    }

    static void executeKnapSack() {
        Knapsack.knapsackSolution(4, 6, new int[]{4, 3, 2, 3}, new int[]{3, 2, 4, 4});
        int[] valor = new int[]{79, 32, 47, 18, 26, 85, 33, 40, 45, 59};
        int[] peso = new int[]{85, 26, 48, 21, 22, 95, 43, 45, 55, 52};
        Knapsack.knapsackSolution(10, 140, peso, valor);
    }

    static void executeRocCut() {
        RodCut.RodCuttingSolution(new int[]{0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30}, 10);
    }

    static void executeMatrixChain() {
        MatrixChainMultiplication.solution(new int[]{30, 35, 15, 5, 10, 20, 25});
        MatrixChainMultiplication.solution(new int[]{5, 10, 3, 12, 5, 50, 6});
    }
}
