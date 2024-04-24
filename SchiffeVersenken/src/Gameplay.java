public class Gameplay {
    public Gameplay() {
    }

    public void runGame(){
        Players players = new Players();
        players.humanPlaceShips();
        players.computerPlaceShips();


        while (true) {

            boolean isHumanShipLeft = (players.board.humanShipsDestroyed < players.board.maxHumanShips);
            boolean isComputerShipLeft = (players.board.getComputerShipsDestroyed() < players.board.maxComputerShips);
            /*if (!isHumanShipLeft) {
                break;
            } else {*/
                players.humanFire();
                isComputerShipLeft = (players.board.getComputerShipsDestroyed() < players.board.maxComputerShips);
                isHumanShipLeft = (players.board.humanShipsDestroyed < players.board.maxHumanShips);
          //  }
            if (!isHumanShipLeft || !isComputerShipLeft) {
                break;
            } else {
                players.computerFire();
                isComputerShipLeft = (players.board.getComputerShipsDestroyed() < players.board.maxComputerShips);
                isHumanShipLeft = (players.board.humanShipsDestroyed < players.board.maxHumanShips);
            }
            if (!isHumanShipLeft || !isComputerShipLeft) {
                break;
            }
        }
        if (players.board.humanShipsDestroyed == players.board.maxHumanShips) {
            System.out.println("Sorry, deine Flotte ist zerstört!");
        } else {
            System.out.println("Glückwunsch, du hast gewonnen!");
        }
    }
}
