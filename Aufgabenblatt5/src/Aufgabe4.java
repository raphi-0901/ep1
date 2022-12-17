/*
    Aufgabe 4) Zweidimensionale Arrays und Rekursion - Labyrinth
*/
public class Aufgabe4 {

    public static void main(String[] args) {
        int mazeType = 1;
//        int[][] direction = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; //EAST,NORTH,WEST,SOUTH
        int[][] direction = new int[][]{{-1,0},{0,-1},{1,0},{0,1}}; //NORTH,WEST,SOUTH,EAST
//        int[][] direction = new int[][]{{0,-1},{1,0},{0,1},{-1,0}};//WEST,SOUTH,EAST,NORTH
//        int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};//SOUTH,EAST,NORTH,WEST

        char[][] myMaze = null;
        if (mazeType == 0) {
            myMaze = new char[][]{
                    "***************".toCharArray(),
                    "*         *   E".toCharArray(),
                    "***** *    *  *".toCharArray(),
                    "*   * *********".toCharArray(),
                    "*             *".toCharArray(),
                    "***********   *".toCharArray(),
                    "*             *".toCharArray(),
                    "* ***  ****   *".toCharArray(),
                    "*   *     *   *".toCharArray(),
                    "***** *****   *".toCharArray(),
                    "*        *    *".toCharArray(),
                    "* ********** **".toCharArray(),
                    "*        *    *".toCharArray(),
                    "*  S *        *".toCharArray(),
                    "***************".toCharArray()
            };
        } else if (mazeType == 1) {
            myMaze = new char[][]{
                    "***************".toCharArray(),
                    "*         *   E".toCharArray(),
                    "***** *    *  *".toCharArray(),
                    "*   * ******* *".toCharArray(),
                    "*             *".toCharArray(),
                    "***********   *".toCharArray(),
                    "*             *".toCharArray(),
                    "* ***  ****   *".toCharArray(),
                    "*   *     *   *".toCharArray(),
                    "***** *****   *".toCharArray(),
                    "*        *    *".toCharArray(),
                    "* ********** **".toCharArray(),
                    "*        *    *".toCharArray(),
                    "*  S *        *".toCharArray(),
                    "***************".toCharArray()
            };
        } else if (mazeType == 2) {
            myMaze = new char[][]{
                    "***************".toCharArray(),
                    "*         *   *".toCharArray(),
                    "***** *   * * *".toCharArray(),
                    "*   * ******* *".toCharArray(),
                    "*   *         *".toCharArray(),
                    "* *********   *".toCharArray(),
                    "*   *         *".toCharArray(),
                    "* ***  ****   *".toCharArray(),
                    "E   *     *   *".toCharArray(),
                    "***** *****   *".toCharArray(),
                    "*        *    *".toCharArray(),
                    "* *************".toCharArray(),
                    "* *      *    *".toCharArray(),
                    "*    *       S*".toCharArray(),
                    "***************".toCharArray()
            };
        }

        // Dieser Teil darf (muss aber nicht) verändert werden!!****************
        printMaze(myMaze);
        int[] startPoint = getStartPoint(myMaze);
        if (startPoint == null) {
            System.out.println("STARTPOINT MISSING!");
            return;
        }

        if (existsPathToExit(myMaze, startPoint[0], startPoint[1], direction)) {
            System.out.println("EXIT FOUND!");
        } else {
            System.out.println("EXIT NOT FOUND!");
        }

        //myMaze[startPoint[0]][startPoint[1]] = 'S';
        printMaze(myMaze);
        //**********************************************************************
    }

    private static int[] getStartPoint(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private static boolean existsPathToExit(char[][] maze, int row, int col, int[][] direction) {
        if (row > maze.length - 1 || col > maze[0].length - 1 || row < 0 || col < 0) {
            return false;
        }

        if (maze[row][col] == '*' || maze[row][col] == 'V') {
            return false;
        }

        if (maze[row][col] == 'E') {
            return true;
        }

        if (maze[row][col] != 'S') {
            maze[row][col] = 'V';
        }

        for (int[] ints : direction) {
            if (existsPathToExit(maze, row + ints[0], col + ints[1], direction)) {
                if (maze[row][col] != 'S') {
                    maze[row][col] = 'U';
                }
                return true;
            }
        }
        return false;
    }

    private static void printMaze(char[][] maze) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

}


