import java.util.Arrays;

/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    public static void main(String[] args) {
        // a
        int[] array = {6, 1, 8, 2, 5, 3, 4, 7, 9, 0};
        String output = "";
        for (int value:array
             ) {
            output += value + "#";
        }
        System.out.println(output.substring(0, output.length() - 1));

        // b
        int[] array2 = new int[12];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = 6 * (i + 1);
        }

        for (int i = 0; i < array2.length; i++) {
            array2[i] = array2[i] % 9 == 0 ? 0 : array2[i];
            System.out.print(array2[i] + " ");
        }

        // c
        System.out.println();
        int[] array3 = {7, 3, 2, 7, 6, 7, 7, 8, 9, 5};
        int countOccurencesOfSeven = 0;
        for (int j : array3) {
            if (j == 7) {
                countOccurencesOfSeven++;
            }
        }
        int[] copyOfArray3 = new int[array3.length + countOccurencesOfSeven];
        int countSeven = 0;
        int index = 0;
        while(countSeven < countOccurencesOfSeven || index < array3.length) {
            int currentValue = array3[index];
            copyOfArray3[index + countSeven] = currentValue;
            if(currentValue == 7) {
                countSeven++;
                copyOfArray3[index + countSeven] = -1;
            }
            index++;
        }

        for (int v:copyOfArray3
             ) {
            System.out.print(v + " ");
        }

        // d
        int[] array4 = new int[11];
        for (int i = 0; i < array4.length; i++) {
            array4[i] = i + 1;
        }

        int counter = array4.length - 1;
        System.out.println();
        System.out.print("while-Schleife: ");
        while(counter >= 0) {
            if(counter == 0) {
                System.out.print(array4[counter]);
            }
            else {
                System.out.print(array4[counter] + ",");
            }
            counter--;
        }
        System.out.println();
        System.out.print("for-Schleife: ");
        for (int i = array4.length - 1; i >= 0; i--) {
            if(i == 0) {
                System.out.print(array4[i]);
            }
            else {
                System.out.print(array4[i] + ",");
            }
        }
    }
}

