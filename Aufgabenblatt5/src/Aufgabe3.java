/*
    Aufgabe 3) Zweidimensionale Arrays und CodeDraw - Bildverarbeitung "Finding Waldo"
*/

import codedraw.CodeDraw;
import codedraw.Palette;
import codedraw.Image;


import javax.security.auth.login.AccountLockedException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Aufgabe3 {

    // converts RGB image into a grayscale array
    private static int[][] convertImg2Array(Image img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int[][] imgArray = new int[height][width];
        Color tempColor;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                tempColor = img.getPixel(col, row);
                imgArray[row][col] = (int) (tempColor.getRed() * 0.3 + tempColor.getGreen() * 0.59 + tempColor.getBlue() * 0.11);
            }
        }
        return imgArray;
    }

    //detect waldo by template matching
    private static void detectWaldo(CodeDraw myDrawObj, Image img, Image template) {
        myDrawObj.setLineWidth(6);
        myDrawObj.setColor(Palette.DEEP_PINK);

        int[][] picture = convertImg2Array(img);
        int[][] waldo = convertImg2Array(template);

        int filterArrayHeight = waldo.length;
        int filterArrayWidth = waldo[0].length; //sind alle konstant laut Vorbedingungen
        int filterArrayMiddleX = filterArrayHeight / 2;
        int filterArrayMiddleY = filterArrayWidth / 2;

        double smallestSum = Double.MAX_VALUE;
        for (int i = 0; i < picture.length; i++) {
            //check if filter fits
            if (i - filterArrayMiddleX < 0 || i + filterArrayMiddleX > picture.length - 1) {
                continue;
            }

            for (int j = 0; j < picture[i].length; j++) {
                //check if filter fits
                if (j - filterArrayMiddleY < 0 || j + filterArrayMiddleY > picture[i].length - 1) {
                    continue;
                }

                //calculation
                double sum = 0;
                for (int k = 0; k < filterArrayHeight; k++) {
                    for (int l = 0; l < filterArrayWidth; l++) {
                        int x = i + k - filterArrayMiddleX;
                        int y = j + l - filterArrayMiddleY;
                        sum += Math.abs(picture[x][y] - waldo[k][l]);
                    }
                }

                if (sum < smallestSum) {
                    smallestSum = sum;
                    myDrawObj.drawImage(0, 0, img);
                    myDrawObj.drawRectangle(j - filterArrayMiddleY, i - filterArrayMiddleX, waldo[0].length, waldo.length);
                    myDrawObj.show(300);
                }
            }
        }
        System.out.println("Found!");
    }

    public static void main(String[] args) {

        //waldo1
//        String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/6NcsuQdriPbHcKN/download"; //waldo1.png
//        String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/AwlmIBqj2V1qGV7/download"; //template1.png

        //waldo2
//        String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/922nyXVsBkMKz6K/download"; //waldo2.png
//        String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/tqTFXxF2BkeKnhm/download"; //template2.png

        //waldo3
        String linkWaldo = "https://owncloud.tuwien.ac.at/index.php/s/DR2u4Xf5muAZsWo/download"; //waldo3.png
        String linkTemplate = "https://owncloud.tuwien.ac.at/index.php/s/xEMZlbdHJ4ZfLfz/download"; //template3.png

        // open image file
        Image img = Image.fromUrl(linkWaldo);

        // open template image file
        Image template = Image.fromUrl(linkTemplate);

        // set StdDraw window size based on the image size
        int width = img.getWidth();
        int height = img.getHeight();
        CodeDraw cd = new CodeDraw(width, height);

        //draw image
        cd.drawImage(0, 0, img);
        cd.show();

        //detect Waldo given in 'template' and show result in image 'img'
        detectWaldo(cd, img, template);
    }
}





