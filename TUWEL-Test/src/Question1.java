import java.lang.reflect.Array;
import java.util.Arrays;

public class Question1 {
    public static void main(String[] args) {
        System.out.println(extract(new char[]{
                'c', 'a', 'd'
        }, 0, 3, 'a'));

        int[][] matrix = new int[4][4];
        fill(matrix, 4, 0, 0);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static String extract(char[] sequence, int start, int end, char omit) {
        if (start >= end) {
            return "";
        }
        if (sequence[start] == omit) {
            return extract(sequence, start + 1, end, omit);
        }
        return sequence[start] + extract(sequence, start + 1, end, omit);
    }

    private static void fill(int[][] matrix, int n, int r, int c) {
        if (r >= n || c >= n) {
            return;
        }
        matrix[r][c] = (r + c) % 2;
        fill(matrix, n, r + 1, c);
        fill(matrix, n, r, c + 1);
    }
}
