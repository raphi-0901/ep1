/*
    Aufgabe 5) Zweidimensionale Arrays - Diverse Methoden
*/

import java.util.Arrays;

public class Aufgabe5 {

    private static int[][] genFilledArray(int n) {
        int[][] filledArray = new int[n][n];

        for (int i = 0; i < filledArray.length; i++) {
            for (int j = 0; j < filledArray.length; j++) {
                filledArray[i][j] = i + j;
            }
        }
        return filledArray;
    }

    private static int[][] extendArray(int[] inputArray) {
        int[][] extendedArray = new int[inputArray.length][];

        for (int i = 0; i < inputArray.length; i++) {
            int value = inputArray[i];
            int[] array = new int[2 * value + 1];
            Arrays.fill(array, -1);
            array[array.length / 2] = value;

            extendedArray[i] = array;
        }
        return extendedArray;
    }

    private static int[] reformatArray(int[][] inputArray) {
        int[] reformattedArray = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            int counter = 0;
            for (int j = 0; j < inputArray[i].length; j++) {
                if(inputArray[i][j] == 0) {
                    counter++;
                }
            }
            reformattedArray[i] = counter;
        }
        return reformattedArray;
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

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                System.out.print(inputArray[i] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] array = genFilledArray(2);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{0, 1}, {1, 2}}));
        System.out.println("-----");

        array = genFilledArray(4);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{0, 1, 2, 3}, {1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}}));
        System.out.println("-----");

        array = genFilledArray(7);
        printArray(array);
        System.out.println("-----");


        int[] array1 = new int[]{4, 0, 5, 2};
        int[][] array1res = extendArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{-1, -1, -1, -1, 4, -1, -1, -1, -1}, {0}, {-1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1}, {-1, -1, 2, -1, -1}}));
        System.out.println("-----");

        array1 = new int[]{0};
        array1res = extendArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{0}}));
        System.out.println("-----");

        array1 = new int[]{0, 1, 2, 1, 0};
        array1res = extendArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{0}, {-1, 1, -1}, {-1, -1, 2, -1, -1}, {-1, 1, -1}, {0}}));
        System.out.println("-----");


        int[][] array2 = new int[][]{{1, 0, 1, 1}, {0, 1, 1}, {0, 1, 0, 1, 1}, {0, 0, 0, 1, 0}, {1, 0}, {1, 1, 1, 1, 1}};
        int[] array2res = reformatArray(array2);
        printArray(array2res);
        assert (Arrays.equals(array2res, new int[]{1, 1, 2, 4, 1, 0}));
        System.out.println("-----");

        array2 = new int[][]{{1, 0, 1, 1, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1}};
        array2res = reformatArray(array2);
        printArray(array2res);
        assert (Arrays.equals(array2res, new int[]{5, 3, 6, 7, 5, 8, 7}));
        System.out.println("-----");
    }
}
