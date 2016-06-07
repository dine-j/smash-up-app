package acelis.personalprojects.Smash_up;

import acelis.personalprojects.Smash_up.model.Game;
import acelis.personalprojects.Smash_up.model.Player;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acelis on 06/06/16.
 */
public class AskNames extends Activity {

    private int numberOfPlayers;

    public AskNames(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        setView();
    }

    private void setView() {
        switch(numberOfPlayers) {
            case 2:
                setContentView(R.layout.two_players);
                break;
            case 3:
                setContentView(R.layout.three_players);
                break;
            case 4:
                setContentView(R.layout.four_players);
                break;
            default:
                // TODO: add case default
                break;
        }
    }

    public void onClickDistributeRaces(View view) {
        String[] names = getInputNames();
        Game startGame = new Game(numberOfPlayers, names);
        Result results = new Result(startGame.getListOfPlayers());
    }

    private String[] getInputNames() {
        String[] names = new String[numberOfPlayers];
        switch(numberOfPlayers) {
            case 2:
                names[0] = findViewById(R.id.player1).toString();
                names[1] = findViewById(R.id.player2).toString();
                break;
            case 3:
                names[2] = findViewById(R.id.player3).toString();
                break;
            case 4:
                names[3] = findViewById(R.id.player4).toString();
        }
        return names;
    }
}
