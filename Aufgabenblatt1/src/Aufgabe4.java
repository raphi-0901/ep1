/*
    Aufgabe 4) CodeDraw Bibliothek
*/

import codedraw.CodeDraw;
import codedraw.Palette;

public class Aufgabe4 {

    public static void main(String[] args) {
        int windowSize = 400;
        double halfWindowSize = (double) windowSize / 2;
        CodeDraw cd = new CodeDraw(windowSize, windowSize);
        cd.setLineWidth(2);
        cd.setAlwaysOnTop(true);

        // circles
        cd.setColor(Palette.CYAN);
        cd.drawCircle(halfWindowSize * 0.5, halfWindowSize * 0.5, halfWindowSize * 0.5);
        cd.setColor(Palette.MAGENTA);
        cd.fillCircle(halfWindowSize * 0.5, halfWindowSize * 0.5, halfWindowSize * 0.25);

        // square
        cd.setColor(Palette.YELLOW);
        cd.fillSquare(halfWindowSize * 0.25, windowSize - halfWindowSize * 0.75, halfWindowSize * 0.5);
        cd.setColor(Palette.BLUE);
        cd.drawLine(halfWindowSize * 0.25, windowSize - halfWindowSize * 0.75, halfWindowSize * 0.75, windowSize - halfWindowSize * 0.25);
        cd.drawLine(halfWindowSize * 0.25, windowSize - halfWindowSize * 0.25, halfWindowSize * 0.75, windowSize - halfWindowSize * 0.75);

        // ellipses
        cd.setColor(Palette.RED);
        cd.fillEllipse(windowSize - 60, 60, 60, 15);
        cd.fillEllipse(windowSize - 60, 60, 15, 60);

        // lines
        cd.setColor(Palette.GREEN);
        int increment = 40;
        for (int i = 0; i < 11; i++) {
            double endPoint = halfWindowSize + i * increment;
            if (endPoint <= windowSize) {
                cd.drawLine(halfWindowSize, 0, endPoint, windowSize);
                continue;
            }
            endPoint = windowSize - (i - (0.5 * windowSize / increment)) * increment;
            cd.drawLine(halfWindowSize, 0, windowSize, endPoint);
        }
        cd.show();
    }
}
