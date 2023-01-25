import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        int[][] data0 = {{3, 0}, {0, 1}, {2, 2}};
        int[][] data1 = {{0, 1, 0, 0, 1, 0}, {}, {2, 2, 2, 2, 0, 1}};
        int[] target1 = {0, 0, 0};
        int[] target2 = {9, 9, 9, 9};

        System.out.println(Arrays.deepToString(labelPath(3, new int[][]{})));
        System.out.println(Arrays.deepToString(labelPath(4, data0)));
        findMatches(data0, data0[1], target1);
        System.out.println(Arrays.toString(target1));
        findMatches(data1, data0[1], target1);
        System.out.println(Arrays.toString(target1));
        findMatches(data1, data0[2], target2);
        System.out.println(Arrays.toString(target2));

        System.out.println(insertMiddle("XY", "abc"));
        System.out.println(insertMiddle("01234", "abc"));
        System.out.println(insertMiddle("01234567890123", "./-"));
    }

    private static String insertMiddle(String input, String seps) {
        if(input.length() == 1) {
            return input;
        }

        if(seps.length() == 0) {
            return input;
        }

        String reducedSeps = seps.substring(1);
        String firstHalf = input.substring(0, input.length() / 2);
        String secondHalf = input.substring(input.length() / 2);
        return  insertMiddle(firstHalf, reducedSeps) + seps.charAt(0) + insertMiddle(secondHalf, reducedSeps);
    }

    private static void findMatches(int[][] data, int[] pattern, int[] target) {
        for (int i = 0; i < data.length; i++) {
            int countOccurences = 0;
            for (int j = 0; j <= data[i].length - pattern.length; j++) {
                boolean found = true;
                for (int k = 0; k < pattern.length; k++) {
                    if(data[i][j+k] != pattern[k]) {
                        found = false;
                        break;
                    }
                }

                if(found) {
                    countOccurences++;
                }
            }
            target[i] = countOccurences;
        }
    }

    private static int[][] labelPath(int n, int[][] points) {
        int[][] result = new int[n][n];

        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], n);
        }

        for (int i = 0; i < points.length; i++) {
            result[points[i][0]][points[i][1]] = -1;
        }
        return result;
    }
}
