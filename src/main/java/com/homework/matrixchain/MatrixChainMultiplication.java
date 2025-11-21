package com.homework.matrixchain;

public class MatrixChainMultiplication {

    public static void solution(int[] arrayInput) {
        int size = arrayInput.length;
        int[][] optimalValueMatrix = new int[size][size];
        int[][] parenthesisSolutionMatrix = new int[size][size];

        for (int chainLength = 2; chainLength < size; chainLength++) {
            for (int startIndex = 1; startIndex < size - chainLength + 1; startIndex++) {
                int endIndex = startIndex + chainLength - 1;
                optimalValueMatrix[startIndex][endIndex] = Integer.MAX_VALUE;
                for(int indexCounter = startIndex; indexCounter < endIndex; indexCounter++){
                    int matrixAddition = optimalValueMatrix[startIndex][indexCounter] + optimalValueMatrix[indexCounter + 1][endIndex];
                    int valuesMultiplication = arrayInput[startIndex-1] * arrayInput[indexCounter] * arrayInput[endIndex];
                    int totalOperations =  matrixAddition + valuesMultiplication;
                    if(totalOperations < optimalValueMatrix[startIndex][endIndex]){
                        optimalValueMatrix[startIndex][endIndex] = totalOperations;
                        parenthesisSolutionMatrix[startIndex][endIndex] = indexCounter;
                    }
                }
            }
        }

        printMatrix(optimalValueMatrix);
        printMatrix(parenthesisSolutionMatrix);
        int endIndex = parenthesisSolutionMatrix[0].length - 1;
        optimalParenthesis(parenthesisSolutionMatrix,1, endIndex);

    }

    private static void optimalParenthesis(int[][] parentesisSolutionMatrix, int startIndex, int endIndex) {
        if(startIndex == endIndex){
            System.out.print("A" + startIndex);
        } else {
            System.out.print("(");
            optimalParenthesis(parentesisSolutionMatrix, startIndex, parentesisSolutionMatrix[startIndex][endIndex]);
            optimalParenthesis(parentesisSolutionMatrix, parentesisSolutionMatrix[startIndex][endIndex] + 1, endIndex);
            System.out.print(")");
        }
    }

    private static void printMatrix(int [][] matrix){
        System.out.println();
        for (int y = 1; y < matrix.length; y++){
            for (int x = 1; x < matrix.length; x++){
                System.out.print(matrix[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
