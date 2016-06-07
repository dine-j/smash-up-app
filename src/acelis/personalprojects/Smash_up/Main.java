package acelis.personalprojects.Smash_up;

import acelis.personalprojects.Smash_up.model.Game;
import acelis.personalprojects.Smash_up.model.Player;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends Activity {

    private int numberOfPlayers;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ask_number);
    }

    public void onClickAskNames(View view) {
        EditText inputNumber = (EditText) findViewById(R.id.nb_input);
        numberOfPlayers = Integer.parseInt(inputNumber.getText().toString());
        setInputNameView(numberOfPlayers);
    }

    public void onClickDistributeRaces(View view) {
        String[] names = getInputNames();
        Game startGame = new Game(numberOfPlayers, names);
        setContentView(R.layout.result);
        showResults(startGame.getListOfPlayers());
    }

    private void setInputNameView(int numberOfPlayers) {
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

    public String[] getInputNames() {
        String[] names = new String[numberOfPlayers];
        switch(numberOfPlayers) {
            case 2:
                names[0] = ((TextView) findViewById(R.id.player1_input)).getText().toString();
                names[1] = ((TextView) findViewById(R.id.player2_input)).getText().toString();
                break;
            case 3:
                names[2] = ((TextView) findViewById(R.id.player3_input)).getText().toString();
                break;
            case 4:
                names[3] = ((TextView) findViewById(R.id.player4_input)).getText().toString();
        }
        return names;
    }

    private void showResults(Player[] players) {
        switch(players.length) {
            case 2:
                ((TextView) findViewById(R.id.player1)).setText(players[0].toString());
                ((TextView) findViewById(R.id.player2)).setText(players[1].toString());
                break;
            case 3:
                ((TextView) findViewById(R.id.player3)).setText(players[2].toString());
                break;
            case 4:
                ((TextView) findViewById(R.id.player4)).setText(players[3].toString());
                break;
            default:
                // TODO add default behavior
                break;
        }
    }
}
