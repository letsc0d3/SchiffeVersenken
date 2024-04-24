import java.util.concurrent.ThreadLocalRandom;

public class Players {

    Board board = new Board();
    AudioPlayer audioPlayer = new AudioPlayer();


    private UserInput userInput;

    public Players() {
        userInput = new UserInput();
        board.setGameboardValues(0, 0, '.'); // Create default board
    }

    public void humanPlaceShips() {
        int shipsPlaced = 0;
        boolean fieldIsOccupied = true;
        int row = 0;
        int col = 0;
        while (shipsPlaced < board.maxHumanShips) {
            while (fieldIsOccupied) {
                System.out.println("Setze Schiff " + (shipsPlaced + 1));

                row = userInput.getNum("Zeile: ");// Enter row
                col = userInput.getNum("Spalte: ");// Enter col

                if (board.getGameboard()[row - 1][col - 1] != '♥') {
                    fieldIsOccupied = false;
                }
            }
            board.setGameboardValues(row, col, '♥');
            shipsPlaced++;
            fieldIsOccupied = true;
        }
    }


    public void computerPlaceShips() {
        int shipsPlaced = 0;

        while (shipsPlaced < board.maxComputerShips) {
            int row = ThreadLocalRandom.current().nextInt(1, board.getMatrixSize() + 1);
            int col = ThreadLocalRandom.current().nextInt(1, board.getMatrixSize() + 1);

            if (board.getGameboard()[row - 1][col - 1] != 'a') {
                board.getComputerShips()[row - 1][col - 1] = 'c';
                shipsPlaced++;
            }
        }
    }

    public void humanFire() {
        int row = 0;
        int col = 0;
        System.out.println("Ziele und feuer!");
        row = userInput.getNum("Zeile: ");// Enter row
        col = userInput.getNum("Spalte: ");// Enter col
        //audioPlayer.playAudio("C:\\Users\\EmreAkca\\IdeaProjects\\SchiffeVersenken\\SchiffeVersenken\\src\\cannon2.wav");
        audioPlayer.playAudio("SchiffeVersenken/src/cannon2.wav");

        board.checkImpact(row, col);
    }

    public void computerFire() {
        System.out.println("Computer feuert zurück!");
        audioPlayer.playAudio("SchiffeVersenken/src/cannon.wav");
        int row = ThreadLocalRandom.current().nextInt(1, board.getMatrixSize() + 1);
        int col = ThreadLocalRandom.current().nextInt(1, board.getMatrixSize() + 1);

        board.checkImpact(row, col);
    }
}
