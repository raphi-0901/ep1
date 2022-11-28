/*
    Aufgabe 3) Verschachtelte Schleifen
*/
public class Aufgabe3 {

    public static void main(String[] args) {
        int n = 5;
        int pattern = 2;

        for (int i = 0; i < n; i++) {
            if (pattern == 0) {
                System.out.println(" ".repeat(i) + "*");
            }
            if (pattern == 1) {
                System.out.println(" ".repeat(n-i-1) + "*".repeat(i));
            }
            if (pattern == 2) {
                System.out.println(" ".repeat(i) + "*".repeat(n));
            }
        }
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    }
}
