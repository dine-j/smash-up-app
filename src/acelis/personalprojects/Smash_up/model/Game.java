package acelis.personalprojects.Smash_up.model;

import java.util.List;
import java.util.Random;

/**
 * Created by acelis on 06/06/16.
 */
public class Game {

    private Player[] listOfPlayers;
    private String[] playerNames;
    private List<String> availableRaces;

    public Game(int numberOfPlayers, String[] playerNames, List<String> availableRaces) {
        listOfPlayers = new Player[numberOfPlayers];
        this.playerNames = playerNames;
        this.availableRaces = availableRaces;
        distributeRaces();
    }

    private void distributeRaces() {
        for(int i = 0; i < listOfPlayers.length; ++i) {
            listOfPlayers[i] = new Player(playerNames[i], give2RandomRaces());
        }
    }

    private String[] give2RandomRaces() {
        Random random = new Random();
        String[] choix = new String[2];

        for(int i = 0; i < 2; ++i) {
            int index = random.nextInt(availableRaces.size());
            choix[i] = availableRaces.get(index);
            availableRaces.remove(index);
        }
        return choix;
    }

    public Player[] getListOfPlayers() {
        return listOfPlayers;
    }
}
