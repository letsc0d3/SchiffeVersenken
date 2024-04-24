import java.util.Arrays;

public class Board {
    private static int MATRIX_SIZE = 9;
    private char[][] gameboard = new char[MATRIX_SIZE][MATRIX_SIZE];// Gameboard array for user visible print out
    private char[][] computerShips = new char[MATRIX_SIZE][MATRIX_SIZE];//Array for secret computer ship positions

    int maxComputerShips = 5;
    int maxHumanShips = 5;
    int computerShipsDestroyed = 0; // Counter
    int humanShipsDestroyed = 0; // Counter


    public int getMatrixSize() {
        return MATRIX_SIZE;
    }

    public char[][] getGameboard() {
        return gameboard;
    }

    public char[][] getComputerShips() {
        return computerShips;
    }

    public int getComputerShipsDestroyed() {
        return computerShipsDestroyed;
    }

    public int getHumanShipsDestroyed() {
        return humanShipsDestroyed;
    }

    public Board() {
    }

    public void setGameboardValues(int row, int col, char value) {

        if (value == '.') {//fill all fields of gameboard with default values
            for (char[] charArrayRow : gameboard) {
                Arrays.fill(charArrayRow, value);
            }
        } else {
            gameboard[row - 1][col - 1] = value;//fill focused field with value
        }
        printGameboard();
    }
    AudioPlayer audioPlayer = new AudioPlayer();

    private void printGameboard() {
        int row;
        int col;
        System.out.println("  123456789"); //Print top col numbers
        for (row = 0; row < gameboard.length; row++) {
            System.out.print(row + 1 + "|");//Print right row numbers

            for (col = 0; col < gameboard.length; col++) {
                System.out.print(gameboard[row][col]);//Print col values
            }
            System.out.print("|" + (row + 1));//Print left row numbers
            if (row == 0) System.out.print("\tSCORE"); // Print score of players
            if (row == 1) System.out.print("\tMensch:\t" + computerShipsDestroyed);
            if (row == 2) System.out.print("\tCPU:\t" + humanShipsDestroyed);
            System.out.println();
        }
        System.out.println("  123456789");//Print bottom col numbers
    }

    public void checkImpact(int row, int col) {

        if (computerShips[row - 1][col - 1] == 'c') {
            computerShipsDestroyed++;
            computerShips[row - 1][col - 1] = 'X';
            setGameboardValues(row, col, 'X');
            System.out.println("Computer-Schiff zerstört!");
            audioPlayer.playAudio("SchiffeVersenken/src/explosion.wav");


        } else if (gameboard[row - 1][col - 1] == '♥') {
            humanShipsDestroyed++;
            setGameboardValues(row, col, '†');
            System.out.println("Menschliches Schiff zerstört!");
            audioPlayer.playAudio("SchiffeVersenken/src/explosion.wav");


        } else if (gameboard[row - 1][col - 1] == '.') {
            setGameboardValues(row, col, '~');
        } else {
            setGameboardValues(row, col, gameboard[row - 1][col - 1]);

        }
    }
}
