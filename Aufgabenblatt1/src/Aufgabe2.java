/*
    Aufgabe 2) while-Schleifen
*/
public class Aufgabe2 {

    public static void main(String[] args) {
//        String text = "Wir beginnen am Anfang mit den Grundlagen.";
        String text = "Kein gesuchtes Zeichen im String!";
        int count = 0;
        String output = "";
        while (count < text.length()) {
            if (count % 2 == 1) {
                char c = text.charAt(count);
                if (c != 'a') {
                    output += c;
                }
            }
            count++;
        }
        System.out.println(output);

        count = 0;
        int foundIndex = -1;
        while (count < text.length()) {
            if (text.charAt(count) == 's') {
                foundIndex = count;
                break;
            }
            count++;
        }
        System.out.println(foundIndex);

        int number = 17;
        while (number < 238) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
            }
            number += 17;
        }

        System.out.println();
        count = 1;
        int occurrences = 0;
        while (count <= text.length() && occurrences < 3) {
            char c = text.charAt(text.length() - count);
            if (c == 'e') {
                occurrences++;
            }
            System.out.print(c);
            count++;
        }

        System.out.println();
        occurrences = 0;
        count = 0;
        while (count < text.length()) {
            char c = text.charAt(count);
            switch (c) {
                case ' ', '!', '.' -> occurrences++;
            }
            count++;
        }
        System.out.println(occurrences);
    }
}






