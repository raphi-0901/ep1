import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int[][] test1 = {{1, 2, 0, -1, -2, 3}, {-1, 2, 3}, {0, 0}, {}, {4, 5, -1}};
        int[][] test2 = {{1, 2, 3}, {4, 5, 2}, {-2, -3, 2, -1}, {3, 2, 1, 5}, {4, 5, 1, 4}};
        int[][] test3 = {{1, -1, 2, -2, 3}, {1, 2, 3}, {-3, -1, -2}};
        char[] age1 = {'d', 'u', '-', 'd', 'u', '-', 'd', 'a', '-', 'd', 'a'};
        char[] age2 = {'m', 'a', 'm', 'a', '!', 'n', 'e', 'i', 'n'};
        int[][] result1 = generate(test1);
        int[][] result2 = generate(test2);
        int[][] result3 = generate(test3);
        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(result2));
        System.out.println(Arrays.deepToString(result3));

        fill(test1, test2[3], test2[4]);
        fill(result1, test2[2], test2[4]);
        fill(test3, test2[2], test2[3]);
        System.out.println(Arrays.deepToString(test1));
        System.out.println(Arrays.deepToString(result1));
        System.out.println(Arrays.deepToString(test3));

        System.out.println(extractString(age1, 0, age1.length, '-'));
        System.out.println(extractString(age1, 1, 7, 'u'));
        System.out.println(extractString(age2, 0, 5, 'a'));
        System.out.println(extractString(age2, 5, age2.length, 'n'));
    }

    private static void fill(int[][] target, int[] values, int[] times) {
        int currentValueIndex = 0;
        int currentValueCount = 0;

        for (int row = 0; row < target.length; row++) {
            for (int col = 0; col < target[row].length; col++) {
                if (currentValueCount == times[currentValueIndex]) {
                    currentValueIndex++;
                    currentValueCount = 0;
                }
                target[row][col] = values[currentValueIndex];
                currentValueCount++;
            }
        }
    }

    private static int[][] generate(int[][] input) {
        int[][] workArray = new int[input.length][];
        int countPositives = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] >= 0) {
                    countPositives++;
                }
            }

            int[] temp = new int[input[i].length];
            int countNegatives = 0;
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] >= 0) {
                    countPositives--;
                    temp[temp.length - 1 - countPositives] = input[i][j];
                } else {
                    temp[countNegatives] = input[i][j];
                    countNegatives++;
                }
            }
            workArray[i] = temp;
        }
        return workArray;
    }

    private static String extractString(char[] sequence, int start, int end, char omit) {
        if (start >= end) {
            return "";
        }

        if (sequence[start] == omit) {
            return extractString(sequence, start + 1, end, omit);
        }

        return sequence[start] + extractString(sequence, start + 1, end, omit);
    }
}
