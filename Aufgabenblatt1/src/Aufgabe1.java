/*
    Aufgabe 1) for-Schleifen
*/
public class Aufgabe1 {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 17; i <= 170; i += 17) {
            sum += i;
        }
        System.out.println(sum);

        for (int i = 60; i <= 82; i += 6) {
            System.out.print(i + " ");
        }
        System.out.println();


        for (int i = 118; i <= 585; i++) {
            if (i % 9 == 0 && i % 13 == 0) {
                System.out.print("+" + i);
            }
        }
        System.out.print("+");
        System.out.println();

        for (int i = 65; i > 45; i--) {
            System.out.print((char) i + " ");
        }

        System.out.println("");
        String text = "Es ist kein echtes Edelmetall!";
        int occurences = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == 'E' || c == 'e') {
                occurences++;
            }
        }
        System.out.println(occurences);
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    }
}
