/*
    Aufgabe 1) Zweidimensionale Arrays und Methoden - Vier Gewinnt
*/

import codedraw.*;

public class Aufgabe1 {

    private static int[][] genGameBoard(int row, int col) {
        return new int[row][col];
    }

    private static void drawGameBoard(CodeDraw myDrawObj, int[][] currentGameBoard, int oneSquareSize) {
        myDrawObj.clear();
        for (int row = 0; row < currentGameBoard.length; row++) {
            for (int col = 0; col < currentGameBoard[row].length; col++) {
                myDrawObj.setColor(Palette.BLUE);
                myDrawObj.fillSquare(col * oneSquareSize, row * oneSquareSize, oneSquareSize);
                switch (currentGameBoard[row][col]) {
                    case 0 -> myDrawObj.setColor(Palette.GRAY);
                    case 1 -> myDrawObj.setColor(Palette.RED);
                    case 2 -> myDrawObj.setColor(Palette.YELLOW);
                }
                myDrawObj.fillCircle(oneSquareSize * (col + 0.5), oneSquareSize * (row + 0.5), oneSquareSize / 3);
            }
        }
        myDrawObj.show();
    }

    private static boolean isMovePossible(int[][] currentGameBoard, int col) {
        for (int i = 0; i < currentGameBoard.length; i++) {
            if (currentGameBoard[i][col] == 0) {
                return true;
            }
        }
        return false;
    }

    private static void makeMove(int[][] currentGameBoard, int player, int col) {
        for (int i = currentGameBoard.length - 1; i >= 0; i--) {
            if (currentGameBoard[i][col] == 0) {
                currentGameBoard[i][col] = player;
                return;
            }
        }

    }

    private static void showText(CodeDraw myDrawObj, String text) {
        myDrawObj.drawText(myDrawObj.getWidth() / 2, myDrawObj.getHeight() / 2, text);
        myDrawObj.show(1000);
    }

    private static boolean existsWinner(int[][] currentGameBoard, int player) {
        //rows
        for (int row = 0; row < currentGameBoard.length; row++) {
            int counter = 0;
            for (int col = 0; col < currentGameBoard[row].length; col++) {
                if (currentGameBoard[row][col] == player) {
                    counter++;
                } else {
                    counter = 0;
                }

                if (counter >= 4) {
                    return true;
                }
            }
        }

        //cols
        for (int row = 0; row < currentGameBoard[0].length; row++) {
            int counter = 0;
            for (int col = 0; col < currentGameBoard.length; col++) {
                if (currentGameBoard[col][row] == player) {
                    counter++;
                } else {
                    counter = 0;
                }

                if (counter >= 4) {
                    return true;
                }
            }
        }

        // diagonals right to left from top to bottom
        // start with 3 because it is not possible to find a diagonal of four in the corners
        for (int row = 3; row < currentGameBoard.length; row++) {
            int counter = 0;
            int y = row;
            int x = 0;
            while (y >= 0 && x < currentGameBoard[0].length) {
                if (currentGameBoard[y][x] == player) {
                    counter++;
                } else {
                    counter = 0;
                }

                if (counter >= 4) {
                    return true;
                }

                x++;
                y--;
            }
        }

        //diagonals right to left from left to right
        for (int col = 1; col < currentGameBoard[0].length - 3; col++) {
            int counter = 0;
            int x = col;
            int y = currentGameBoard.length - 1;
            while (y >= 0 && x < currentGameBoard[0].length) {
                if (currentGameBoard[y][x] == player) {
                    counter++;
                } else {
                    counter = 0;
                }

                if (counter >= 4) {
                    return true;
                }

                x++;
                y--;
            }
        }

        //diagonals left to right from top to bottom
        for (int row = 3; row < currentGameBoard.length; row++) {
            int counter = 0;
            int y = row;
            int x = currentGameBoard[0].length - 1;
            while (x >= 0 && y >= 0) {
                if (currentGameBoard[y][x] == player) {
                    counter++;
                } else {
                    counter = 0;
                }

                if (counter >= 4) {
                    return true;
                }

                x--;
                y--;
            }
        }

        //diagonals left to right from right to left
        //start by -2 because the diagonal in length-1 got checked already
        //only run to col 3 so a diagonal of four can fit
        for (int col = currentGameBoard[0].length - 2; col >= 3; col--) {
            int counter = 0;
            int x = col;
            int y = currentGameBoard.length - 1;
            while (y >= 0 && x >= 0) {
                if (currentGameBoard[y][x] == player) {
                    counter++;
                } else {
                    counter = 0;
                }

                if (counter >= 4) {
                    return true;
                }

                x--;
                y--;
            }
        }

        return false;
    }

    private static void clearGameBoard(CodeDraw myDrawObj, int[][] currentGameBoard, int oneSquareSize) {
        for (int row = 0; row < currentGameBoard.length; row++) {
            int[][] duplicate = new int[currentGameBoard.length][currentGameBoard[0].length];
            System.arraycopy(currentGameBoard, 0, duplicate, 1, currentGameBoard.length - 1);
            System.arraycopy(duplicate, 0, currentGameBoard, 0, duplicate.length);
            drawGameBoard(myDrawObj, currentGameBoard, oneSquareSize);
            myDrawObj.show(500);
        }
    }


    public static void main(String[] args) {
        // canvas settings
        int rowsGameBoard = 6;
        int colsGameBoard = 7;
        int oneSquareSize = 50;
        int width = oneSquareSize * colsGameBoard;
        int height = oneSquareSize * rowsGameBoard;

        CodeDraw myDrawObj = new CodeDraw(width, height);
        EventScanner myEventSC = myDrawObj.getEventScanner();

        // game variables
        int[][] myGameBoard = genGameBoard(rowsGameBoard, colsGameBoard);
        int player = 1;
        int fieldsUsed = 0;
        boolean gameActive = true;

        // set font for text
        TextFormat font = new TextFormat();
        font.setFontSize(28);
//        font.setFontName("Arial");
        font.setTextOrigin(TextOrigin.CENTER);
        font.setBold(true);
        myDrawObj.setTextFormat(font);

        // initial draw of the game board
        drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);

        // game play starts
        System.out.println("Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " has to make a move!");
        while (!myDrawObj.isClosed() && gameActive) {
            if (myEventSC.hasKeyPressEvent()) {
                if (myEventSC.nextKeyPressEvent().getChar() == 'q') {
                    gameActive = false;
                }
            } else if (myEventSC.hasMouseClickEvent()) {
                MouseClickEvent currentClick = myEventSC.nextMouseClickEvent();
                int mouseX = currentClick.getX();
                int col = mouseX / oneSquareSize;

                if (!isMovePossible(myGameBoard, col)) {
                    myDrawObj.setColor(Palette.PINK);
                    showText(myDrawObj, "Column already full!");
                    drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                    continue;
                }

                makeMove(myGameBoard, player, col);
                drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                fieldsUsed++;
                int nextPlayer = player == 1 ? 2 : 1;

                if (existsWinner(myGameBoard, player)) {
                    System.out.println("Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " won!");
                    myDrawObj.setColor(Palette.TURQUOISE);
                    showText(myDrawObj, "Player " + player + (player == 1 ? " (RED)" : " (YELLOW)") + " won!");

                    //recreate gameboard
                    player = nextPlayer;
                    fieldsUsed = 0;
                    myGameBoard = genGameBoard(rowsGameBoard, colsGameBoard);
                    drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                    myDrawObj.setColor(Palette.PINK);
                    showText(myDrawObj, "Next round!");
                    drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                    continue;
                }

                if (fieldsUsed == myGameBoard[0].length * myGameBoard.length) {
                    player = nextPlayer;
                    myDrawObj.setColor(Palette.PINK);
                    showText(myDrawObj, "Board full");
                    clearGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                    showText(myDrawObj, "Try again!");
                    drawGameBoard(myDrawObj, myGameBoard, oneSquareSize);
                    fieldsUsed = 0;
                    continue;
                }

                System.out.println("Player " + nextPlayer + (nextPlayer == 1 ? " (RED)" : " (YELLOW)") + " has to make a move!");
                player = nextPlayer;
            } else {
                myEventSC.nextEvent();
            }
        }
        myDrawObj.close();
    }
}


