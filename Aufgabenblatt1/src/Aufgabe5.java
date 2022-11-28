/*
    Aufgabe 5) Schleifen und Zeichnen innerhalb des CodeDraw-Fensters
*/

import codedraw.CodeDraw;
import codedraw.Palette;

import java.awt.*;

public class Aufgabe5 {

    public static void main(String[] args) {
        int windowSize = 300;
        int n = 19;
        assert n > 4 && n < 20 : "n is out of range";
        CodeDraw cd = new CodeDraw(windowSize, windowSize);
        cd.setAlwaysOnTop(true);
        double radius = (double) windowSize / (2 * n);
        cd.setLineWidth(windowSize / 100);
        cd.setColor(Palette.RED);
        for (int i = 0; i < n; i++) {
            double circleOffset = (2 * i * radius);
            cd.drawCircle(radius, (2 * i * radius) + radius, radius);
            cd.drawCircle(circleOffset + radius, windowSize - radius, radius);

            if (i > 0 && i < n - 1) {
                double offset = 3 * radius;
                cd.setColor(Palette.BLUE);
                cd.drawCircle(windowSize - offset, circleOffset + radius, radius);
                cd.drawCircle(circleOffset + radius, offset, radius);
                cd.setColor(Palette.RED);
            }

            if (i > 1 && i < n - 2) {
                double offset = 5 * radius;
                cd.drawCircle(offset, circleOffset + radius, radius);
                cd.drawCircle(circleOffset + radius, windowSize - offset, radius);
            }
        }
        cd.show();
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
    }
}
