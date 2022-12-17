/*
    Aufgabe 2) Zweidimensionale Arrays - Sortieren und Filtern
*/
public class Aufgabe2 {

    private static double[][] genCircleFilter(int n, double radius) {
        if(n % 2 == 0 || n < 1) {
            return null;
        }

        double[][] filter = new double[n][n];
        int middle = n/2;

        for (int i = 0; i < filter.length; i++) {
            int distanceY = Math.abs(middle - i);
            for (int j = 0; j < filter[i].length; j++) {
                int distanceX = Math.abs(middle - j);
                double delta = Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
                filter[i][j] = delta > radius ?  0 :  1;
            }
        }
        return filter;
    }

    private static double[][] applyFilter(double[][] workArray, double[][] filterArray) {
        int filterArrayHeight = filterArray.length;
        int filterArrayWidth = filterArray[0].length; //sind alle konstant laut Vorbedingungen
        int filterArrayMiddleX = filterArray.length / 2;
        int filterArrayMiddleY = filterArray[0].length / 2;

        double[][] output = new double[workArray.length][workArray[0].length];
        for (int i = 0; i < workArray.length; i++) {
            //check if filter fits in X direction
            if(i - filterArrayMiddleX < 0 || i + filterArrayMiddleX > workArray.length - 1) {
                continue;
            }

            for (int j = 0; j < workArray[i].length; j++) {
                //check if filter fits in Y direction
                if(j - filterArrayMiddleY < 0 || j + filterArrayMiddleY > workArray[i].length - 1) {
                    continue;
                }

                //calculation
                double sum = 0;
                for (int k = 0; k < filterArrayHeight; k++) {
                    for (int l = 0; l < filterArrayWidth; l++) {
                        int x = i + k - filterArrayMiddleX;
                        int y = j + l - filterArrayMiddleY;
                        sum += workArray[x][y] * filterArray[k][l];
                    }
                }
                output[i][j] = sum;
            }
        }
        return output;
    }

    private static void print(double[][] workArray) {
        if (workArray != null) {
            for (int y = 0; y < workArray.length; y++) {
                for (int x = 0; x < workArray[y].length; x++) {
                    System.out.printf("%.2f", workArray[y][x]);
                    System.out.print("\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] myResultArray;

        double[][] myFilter1 = genCircleFilter(3, 1.2);
        System.out.println("Output -> myFilter1 (genCircleFilter mit size = 3 und radius = 1.2):");
        print(myFilter1);

        double[][] myFilter2 = genCircleFilter(7, 2.5);
        System.out.println("Output -> myFilter2 (genCircleFilter mit size = 7 und radius = 2.5):");
        print(myFilter2);

        double[][] myArray1 = {{0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 2, 2, 2, 0}, {0, 3, 3, 3, 0}, {0, 0, 0, 0, 0}};
        System.out.println("Output -> myArray1:");
        print(myArray1);

        myResultArray = applyFilter(myArray1, myFilter1);
        System.out.println("Output -> myFilter1 applied to myArray1:");
        print(myResultArray);

        myResultArray = applyFilter(myArray1, myFilter2);
        System.out.println("Output -> myFilter2 applied to myArray1:");
        print(myResultArray);

        //Beispiel aus Aufgabenblatt
        double[][] myArray3 = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
        double[][] myFilter3 = {{1, 0, 0}, {1, 2, 0}, {0, 0, 3}};
        System.out.println("Output -> myArray3:");
        print(myArray3);
        System.out.println("Output -> myFilter3:");
        print(myFilter3);
        myResultArray = applyFilter(myArray3, myFilter3);
        System.out.println("Output -> myFilter3 applied to myArray3:");
        print(myResultArray);

        double[][] myArray4 = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 2, 3, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        double[][] myFilter4 = {{0, 0, 0}, {0, 0, 0}, {0, 0.5, 0}};
        System.out.println("Output -> myArray4:");
        print(myArray4);
        System.out.println("Output -> myFilter4:");
        print(myFilter4);
        myResultArray = applyFilter(myArray4, myFilter4);
        System.out.println("Output -> myFilter4 applied to myArray4:");
        print(myResultArray);
        //TODO: Erstellen Sie den Filter aus dem Aufgabenblatt, wenden Sie ihn auf myArray4 an und geben Sie das Ergebnis mittels print() aus
    }


}
