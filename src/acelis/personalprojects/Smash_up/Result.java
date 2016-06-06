package acelis.personalprojects.Smash_up;

import acelis.personalprojects.Smash_up.model.Player;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by acelis on 06/06/16.
 */
public class Result extends Activity {

    private Player[] players;

    public Result(Player[] players) {
        this.players = players;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        showResults();
    }

    private void showResults() {
        switch(players.length) {
            case 2:
                ((TextView) findViewById(R.id.player1)).setText((CharSequence) players[0]);
                ((TextView) findViewById(R.id.player2)).setText((CharSequence) players[1]);
                break;
            case 3:
                ((TextView) findViewById(R.id.player3)).setText((CharSequence) players[2]);
                break;
            case 4:
                ((TextView) findViewById(R.id.player4)).setText((CharSequence) players[3]);
                break;
            default:
                // TODO add default behavior
                break;
        }
    }
}
