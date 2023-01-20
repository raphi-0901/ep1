import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int[][] test1 = {{5, 2, 4}, {2, 7, 3}, {9, 5, 8}};
        int[][] test2 = {{1}};
        int[][] test3 = {{6, 7, 8}, {7, 5, 3, 1}, {2}};
        String seq1 = "ABBAACBA";

        int[][] result1 = generate(test1);
        int[][] result2 = generate(test2);
        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(result2));

        reorder(result1);
        reorder(result2);
        reorder(test3);
        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(result2));
        System.out.println(Arrays.deepToString(test3));

        System.out.println(isPresentNTimes(seq1, 'A', 4));
        System.out.println(isPresentNTimes(seq1, 'A', 3));
        System.out.println(isPresentNTimes(seq1, 'A', 5));
        System.out.println(isPresentNTimes(seq1, 'Z', 0));
    }

    private static boolean isPresentNTimes(String sequence, char marker, int count) {
        if(sequence.length() == 0) {
            return count == 0;
        }

        if(sequence.charAt(0) == marker) {
            return isPresentNTimes(sequence.substring(1), marker, count - 1);
        }
        return isPresentNTimes(sequence.substring(1), marker, count);
    }

    private static void reorder(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            int[] temp = new int[input[i].length];
            for (int j = 0; j < temp.length; j++) {
                temp[temp.length - 1 - j] = input[i][j];
            }
            input[i] = temp;
        }
    }

    private static int[][] generate(int[][] input) {
        int[][] workArray = new int[input.length * 2 - 1][];

        for (int i = 0; i < input.length; i++) {
            int[] temp = new int[input.length - i];

            for (int j = 0; j < temp.length; j++) {
                temp[j] = input[i][j];
            }
            workArray[i] = temp;
            workArray[workArray.length - 1 - i] = temp;
        }

        return workArray;
    }


}