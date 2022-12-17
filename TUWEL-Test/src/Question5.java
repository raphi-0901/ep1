import java.util.Arrays;

public class Question5 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[] array = new int[]{1, 2, 3, 4, 5};
        int[] array2= new int[]{1, 2, 3, 4, 5};
        rotate1(array, 1);
        rotate2(array2, 2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
        double[][][] x = new double[2][2][0];
        x[0][0][0] = 3;
        x[0][1][0] = 3;
        System.out.println(x);
    }


    private static void rotate1(int[] data, int k) {
        for (int i = 0; i < k; i++) {
            int j, temp;
            temp = data[0];
            for (j = 0; j < data.length - 1; j++) {
                data[j] = data[j + 1];
            }
            data[j] = temp;
        }
    }

    private static void rotate2(int[] data, int k) { // Zeile A
        k = k % data.length;
        int[] help = new int[k];
        for (int i = 0; i < k; i++) {
            help[i] = data[i];
        }
        int size = data.length - k;
        for (int i = 0; i < size; i++) {
            data[i] = data[i + k];
        }
        for (int i = size; i < data.length; i++) {
            data[i] = help[i - size];
        }
    }
}
