import java.util.Arrays;

public class Test7 {
    public static void main(String[] args) {
        int[][] test1 = {{5, 7, 5, 7}, {5}, {0, 1, 1, 0}};
        int [][] result = addTriangle(test1);
        System.out.println(Arrays.deepToString(result));
    }

    // meine Lösung
    private static int[][] raphisTriangle(int[][] input) {
        int copy[][] = new int[input.length + input[0].length][];

        for (int i = 0; i < input[0].length; i++) {
            copy[i] = new int[i + 1];

            // kann man auch so befüllen:
            // Arrays.fill(copy[i], i + 1);
            for (int j = 0; j < copy[i].length; j++) {
                copy[i][j] = i+1;
            }
        }

        int counter = 0;
        for (int i = input[0].length; i < copy.length; i++) {
            copy[i] = new int[input[counter].length];

            // statt der Schleife kann mans theoretisch auch so machen:
            // System.arraycopy(input[counter], 0, copy[i], 0, copy[i].length);
            for (int j = 0; j < copy[i].length; j++) {
                copy[i][j] = input[counter][j];
            }
            counter++;
        }

        return copy;
    }
    private static int[][] addTriangle(int[][] input) {
        int countindx = 0;

        int copy[][] = new int[input.length + input[0].length][];

        for (int i = 0; i < input[0].length; i++) {
            copy[i] = new int[i + 1];
        }
        for (int i = input[0].length; i < copy.length; i++) {
            copy[i] = new int[input[countindx].length];
            countindx++;

        }

        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (i < input[0].length) {
                    copy[i][j] = i + 1;
                }
            }
        }

        int counter = 0;
        for (int i = input[0].length; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
//                for (int k = 0; k < input.length; k++) {
//                    for (int l = 0; l < input[k].length; l++) {
//                        copy[i][j] = input[k][l];
//                    }
//                }
                copy[i][j] = input[counter][j];
            }
            counter++;
        }

        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                System.out.print(copy[i][j] + " ");
            }
            System.out.println();
        }
        return copy;
    }
}
