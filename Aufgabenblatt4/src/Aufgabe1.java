/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {

    private static void fillArray(int[] filledArray) {
        int number = 6;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = number;
            number += 6;
        }
    }

    private static void printContentFilteredArray(int[] workArray) {
        int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if (copiedArray[i] % 4 == 0) {
                copiedArray[i] = -1;
            }
        }
        printArray(copiedArray);
    }

    private static void fillArrayWithNewContent(int[] workArray) {
        int[] helpArray = new int[10];
        int number = 6;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = number;
            number += 6;
        }
        workArray[0] = 12;
        workArray = helpArray;
        printArray(workArray);
    }

    private static void printArray(int[] workArray) {
        //for (int i = 0; i < workArray.length; i--) {
        for (int i = 0; i < workArray.length; i++) {
            System.out.print(workArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] filledArray = new int[10];
        fillArray(filledArray);
        printArray(filledArray);

        printContentFilteredArray(filledArray);
        printArray(filledArray);

        filledArray[0] = 777;
        printArray(filledArray);

        fillArrayWithNewContent(filledArray);
        printArray(filledArray);
    }

    //**************************************************************************
    //**** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    //**************************************************************************
    //Frage 1:
    //weil die Schleifen nach unten zählt. Das heißt der Wert von i ist im zweiten Durchlauf -1, was kein gültiger Index ist.


    //Frage 2:
    //weil es über die Referenz das Array direkt bearbeitet.


    //Frage 3:
    //wieder über die Referenz bearbeitet. Keine wirkliche Kopie.


    //Frage 4:
    //weil workArray eine lokale Variable ist, und die Referenz davon geändert wird. Dadurch ändert sich aber nicht das Ursprungsarray.
    //wenn man in der Methode vor dem Re-Referenzieren, einen Wert im Array ändert, dann ändert sich auch der Wert vom Array in main.
}
