package acelis.personalprojects.Smash_up.model;

/**
 * Created by acelis on 06/06/16.
 */
public class Game {

    private Player[] listOfPlayers;
    private String[] playerNames;

    public Game(int numberOfPlayers, String[] playerNames) {
        listOfPlayers = new Player[numberOfPlayers];
        this.playerNames = playerNames;
        distributeRaces();
    }

    private void distributeRaces() {
        Race gameRaces = new Race();
        for(int i = 0; i < listOfPlayers.length; ++i) {
            listOfPlayers[i] = new Player(playerNames[i], gameRaces.getRandom2Races());
        }
    }

    public Player[] getListOfPlayers() {
        return listOfPlayers;
    }
}
