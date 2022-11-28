/*
    Aufgabe 1) Codeanalyse, Codingstyle und Methoden
*/
public class Aufgabe1 {
    //TODO zu Punkt a): Beschreiben Sie hier in wenigen Sätzen was der Spaghetticode macht
    // Der Code erzeugt das Muster für eine fixe Breite und Länge.

    //TODO zu Punkt b): Beschreiben Sie in wenigen Sätzen was Sie ändern würden und warum
    // Ich würde Code-Duplication vermeiden. -> soweit wie möglich in Hilfsmethoden unterteilen
    // Ich würde keine hardgecodeten Magic-Numbers verwenden. -> keiner kennt sich später mal aus und es ist nicht flexibel
    // Ich würde den Code formattieren. (Hab ich leider aus Versehen gemacht, deswegen passt es hier)


    //TODO zu Punkt c): Implementieren Sie hier die Methoden Ihrer Lösung
    public static void generateStartingLine(int width) {
        System.out.print("#");
        for (int i = 0; i < width; i++) {
            System.out.print("|");
        }
        System.out.println("#");
    }

    public static void generateInclining(int width, int symbolCount) {
        String plus = "";
        for (int i = 0; i < symbolCount; i++) {
            plus += "+";
        }

        String stars = "";
        int starCount = width - 2 * symbolCount;
        for (int i = 0; i < starCount; i++) {
            stars += "*";
        }

        System.out.println(plus + "\\" + stars + "/" + plus);
    }

    public static void generateDeclining(int width, int symbolCount) {
        String plus = "";
        int plusCount = width / 2 - symbolCount + 1;
        for (int i = 0; i < plusCount; i++) {
            plus += "+";
        }

        String stars = "";
        int starCount = 2 * (symbolCount - 1);
        for (int i = 0; i < starCount; i++) {
            stars += "*";
        }

        System.out.println(plus + "/" + stars + "\\" + plus);
    }

    public static void generateOutput(int width) {
        generateStartingLine(width);
        for (int parts = 0; parts < 4; parts++) {
            for (int i = 1; i <= width / 2; i++) {
                if (parts % 2 == 0) {
                    generateInclining(width, i);
                } else {
                    generateDeclining(width, i);
                }
            }
        }
        generateStartingLine(width);
    }


    public static void main(String args[]) {
        //********************************************************
        //TODO zu Punkt d): Implementieren Sie hier Ihre Lösung für die Angabe
        System.out.println("Ihre Ausgabe:");
        generateOutput(10);
        //********************************************************

        System.out.println();
        System.out.println("Ausgabe Spaghetticode:");
        System.out.print("#");
        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
        }
        System.out.println("#");
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.print("\\");
            for (int j = 1; j <= (10 - 2 * i); j++) {
                System.out.print("*");
            }
            System.out.print("/");
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= (10 / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.print("/");
            for (int j = 1; j <= 2 * (i - 1); j++) {
                System.out.print("*");
            }
            System.out.print("\\");
            for (int j = 1; j <= (10 / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.print("\\");
            for (int j = 1; j <= (10 - 2 * i); j++) {
                System.out.print("*");
            }
            System.out.print("/");
            for (int j = 1; j <= i; j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= (10 / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.print("/");
            for (int j = 1; j <= 2 * (i - 1); j++) {
                System.out.print("*");
            }
            System.out.print("\\");
            for (int j = 1; j <= (10 / 2 - i + 1); j++) {
                System.out.print("+");
            }
            System.out.println();
        }
        System.out.print("#");
        for (int i = 1; i <= 10; i++) {
            System.out.print("|");
        }
        System.out.println("#");
    }
}


