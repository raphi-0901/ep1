/*
    Aufgabe 3) Verschachtelung von Schleifen und Methoden - Fröhliche Zahlen
*/
public class Aufgabe3 {

    private static boolean isHappyNumber(int number) {
        int input = number;
        while (true) {
            int sum = 0;
            int div;
            int mod;
            while (true) {
                div = input / 10;
                mod = input % 10;
                sum += mod * mod;
                input = div;

                if(div == 0) {
                    break;
                }
            }

            if(sum <= 0) {
                break;
            }
            if(sum == 1) {
                return true;
            }
            if(sum == 4) {
                return false;
            }
            input = sum;
        }

        return false;
    }

    private static int countHappyNumbers(int start, int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        return -1; //Zeile kann geändert oder entfernt werden.
    }

    private static void printHappyNumbers(int start, int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    }

    public static void main(String[] args) {
        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE isHappyNumber(...).
        System.out.println("230 --> " + isHappyNumber(230));
        assert (isHappyNumber(2030));
        System.out.println("97 --> " + isHappyNumber(97));
        assert (isHappyNumber(97));
        System.out.println("7 --> " + isHappyNumber(7));
        assert (isHappyNumber(7));
        assert (isHappyNumber(1));
        System.out.println("58 --> " + isHappyNumber(58));
        assert (!isHappyNumber(58));
        System.out.println("40 --> " + isHappyNumber(40));
        assert (!isHappyNumber(40));
        System.out.println("5 --> " + isHappyNumber(5));
        assert (!isHappyNumber(5));
        assert (!isHappyNumber(4));
        System.out.println();
        //**********************************************************************

        //TODO: Testen Sie hier alle Methoden mit verschiedenen Inputs!
    }
}
