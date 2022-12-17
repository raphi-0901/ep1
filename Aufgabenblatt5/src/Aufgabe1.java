/*
    Aufgabe 1) Zweidimensionale Arrays - Diverse Methoden
*/

import java.util.Arrays;

public class Aufgabe1 {

    private static void shiftLines(int[][] workArray) {
        int[] map = new int[workArray.length];
        Arrays.fill(map, Integer.MAX_VALUE);

        // find all lines with the smallest number at the end
        // and store it in map array
        for (int i = 0; i < workArray.length; i++) {
            int localeMin = Integer.MAX_VALUE;
            for (int j = 0; j < workArray[i].length; j++) {
                localeMin = Math.min(localeMin, workArray[i][j]);
            }
            if (localeMin == workArray[i][workArray[i].length - 1]) {
                map[i] = localeMin;
            }
        }

        // find and store the smallest value of the map array
        int minIndex = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++) {
            if (map[i] < minValue) {
                minValue = map[i];
                minIndex = i;
            }
        }

        // swap the smallest value with the first one
        int[] swap = workArray[0];
        workArray[0] = workArray[minIndex];
        workArray[minIndex] = swap;
    }

    private static void addEntries(int[][] workArray) {
        //sind negative Werte im Array erlaubt??
        for (int i = 0; i < workArray.length; i++) {
            int maxValue = 0;
            // find max value in line
            for (int j = 0; j < workArray[i].length; j++) {
                maxValue = Math.max(maxValue, workArray[i][j]);
            }

            // create new array and fill it with maxValue
            int[] line = new int[workArray[i].length + maxValue];
            Arrays.fill(line, maxValue);

            // overwrite the previous values from old array
            for (int j = 0; j < workArray[i].length; j++) {
                line[j] = workArray[i][j];
            }
            workArray[i] = line;
        }
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[][] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                for (int j = 0; j < inputArray[i].length; j++) {
                    System.out.print(inputArray[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Test shiftLines:");
        int[][] array1 = new int[][]{{1, 3, 2}, {6, 2, 5}, {0, 7, 9}};
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{1, 3, 2}, {6, 2, 5}, {0, 7, 9}}));
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][]{{1, 5, 6, 7}, {1, 9, 6}, {4, 3}, {6, 3, 0, 6, 9}, {6, 4, 3}};
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{4, 3}, {1, 9, 6}, {1, 5, 6, 7}, {6, 3, 0, 6, 9}, {6, 4, 3}}));
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][]{{7, 3, 6}, {5}, {9, 1}, {3, 2, 4, 1}, {0}};
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{0}, {5}, {9, 1}, {3, 2, 4, 1}, {7, 3, 6}}));
        printArray(array1);
        System.out.println("-----");

        System.out.println("Test addEntries:");
        int[][] array2 = {{1}, {1, 2}, {1, 2, 3}};
        addEntries(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{1, 1}, {1, 2, 2, 2}, {1, 2, 3, 3, 3, 3}}));
        printArray(array2);
        System.out.println("-----");

        array2 = new int[][]{{3, 4, 2}, {1, 3, 2}, {5, 0, 1}};
        addEntries(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{3, 4, 2, 4, 4, 4, 4}, {1, 3, 2, 3, 3, 3}, {5, 0, 1, 5, 5, 5, 5, 5}}));
        printArray(array2);
        System.out.println("-----");

        array2 = new int[][]{{1, 2}, {1, 2, 4, 3}, {6}, {1, 2, 5, 3, 4}, {1}, {3}};
        addEntries(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{1, 2, 2, 2}, {1, 2, 4, 3, 4, 4, 4, 4}, {6, 6, 6, 6, 6, 6, 6}, {1, 2, 5, 3, 4, 5, 5, 5, 5, 5}, {1, 1}, {3, 3, 3, 3}}));
        printArray(array2);
    }
}

