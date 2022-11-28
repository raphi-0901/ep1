/*
    Aufgabe 5) Kreismuster => Rekursiv vs. Iterativ
*/

import codedraw.CodeDraw;
import codedraw.Palette;

import java.awt.*;

public class Aufgabe5 {
    private static void drawCirclePatternRecursively(CodeDraw myDrawObj, int x, int y, int r) {
        int newRadius = r / 2;
        if (newRadius > 2) {
            drawCirclePatternRecursively(myDrawObj, x - r, y - r, newRadius);
            drawCirclePatternRecursively(myDrawObj, x - r, y + r, newRadius);
            drawCirclePatternRecursively(myDrawObj, x + r, y - r, newRadius); // uncomment to get figure 1b
            drawCirclePatternRecursively(myDrawObj, x + r, y + r, newRadius);
        }

        myDrawObj.setColor(Palette.RED);
        myDrawObj.drawCircle(x, y, r);
        myDrawObj.setColor(Palette.ORANGE);
        myDrawObj.fillCircle(x, y, r);
    }

    private static void drawCirclePatternIteratively(CodeDraw myDrawObj, int maxRadius) {
        int radius = maxRadius;
        int counter = 0;
        while (true) {
            if (radius / 2 > 2) {
                radius = radius / 2;
                counter++;
            } else {
                break;
            }
        }

        // circles
        for (int i = counter; i >= 0; i--) {
            // x-axis
            for (int j = 0; j < Math.pow(2, i); j++) {
                double biggerCircleRadius = maxRadius / Math.pow(2, i - 1);
                double circleRadius = maxRadius / Math.pow(2, i);
                double x = 2 * (circleRadius + biggerCircleRadius * j);

                // y-axis
                for (int k = 0; k < Math.pow(2, i); k++) {
                    double y = 2 * (circleRadius + biggerCircleRadius * k);
                    myDrawObj.setColor(Palette.RED);
                    myDrawObj.drawCircle(x, y, circleRadius);
                    myDrawObj.setColor(Palette.ORANGE);
                    myDrawObj.fillCircle(x, y, circleRadius);
                }
            }
        }
    }

    public static void main(String[] args) {
        int size = 512;
        CodeDraw figure = new CodeDraw(size, size);
        figure.setLineWidth(3);
        figure.setAlwaysOnTop(true);
        drawCirclePatternRecursively(figure, size / 2, size / 2, size / 4);
        //drawCirclePatternIteratively(figure, 128);
        figure.show();
    }

    // Zusatzfragen
    //
    // 1.
    // Bsp: mit Size von 512:
    // größter Kreis hat 128
    // dann gibt es noch die Kreise mit folgenden Radien: 64, 32, 16, 8, 4
    // Jeder Kreisebene hat immer 4 Mal so viele wie die davor. Insgesamt gibt es 6 Ebenen.
    // --> 4⁰ + 4¹ + 4² + 4³ + 4⁴ + 4⁵ = 1365


    // 2.
    // Bsp: mit Size von 512:
    // größter Kreis hat 128
    // --> 4⁵ = 1024
    // bzw. n = log2(größter Kreis radius) - 1 0> 4^(n-1)

    // 3
    // den Pfad, der nach rechts oben zeichnet
    // drawCirclePatternRecursively(myDrawObj, x + r, y - r, newRadius);
}


