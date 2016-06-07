package acelis.personalprojects.Smash_up;

import acelis.personalprojects.Smash_up.model.Game;
import acelis.personalprojects.Smash_up.model.Player;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
        do {
            EditText inputNumber = (EditText) findViewById(R.id.nb_input);
            numberOfPlayers = Integer.parseInt(inputNumber.getText().toString());
            setInputNameView(numberOfPlayers);
        } while(numberOfPlayers < 2 || numberOfPlayers > 4);
    }

    public void onClickDistributeRaces(View view) {
        String[] names = getInputNames();
        Game startGame = new Game(numberOfPlayers, names, getChosenExtensions());
        setContentView(R.layout.result);
        showResults(startGame.getListOfPlayers());
    }

    public void onClickStartOver(View view) {
        setContentView(R.layout.ask_number);
    }

    public void onClickClose(View view) {
        System.exit(1);
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

        names[0] = ((TextView) findViewById(R.id.player1_input)).getText().toString();
        names[1] = ((TextView) findViewById(R.id.player2_input)).getText().toString();

        switch (numberOfPlayers) {
            case 3:
                names[2] = ((TextView) findViewById(R.id.player3_input)).getText().toString();
                break;
            case 4:
                names[2] = ((TextView) findViewById(R.id.player3_input)).getText().toString();
                names[3] = ((TextView) findViewById(R.id.player4_input)).getText().toString();
                break;
        }

        return names;
    }

    private void showResults(Player[] players) {
        ((TextView) findViewById(R.id.player1)).setText(players[0].toString());
        ((TextView) findViewById(R.id.player2)).setText(players[1].toString());

        switch(players.length) {
            case 3:
                ((TextView) findViewById(R.id.player3)).setText(players[2].toString());
                break;
            case 4:
                ((TextView) findViewById(R.id.player3)).setText(players[2].toString());
                ((TextView) findViewById(R.id.player4)).setText(players[3].toString());
                break;
        }
    }

    public List<String> getChosenExtensions() {
        List<String> listOfRaces = new ArrayList<>();
        String[] basicRaces = getResources().getStringArray(R.array.basic_races);
        for(int i = 0; i < basicRaces.length; ++i) {
            listOfRaces.add(basicRaces[i]);
        }
        if(((CheckBox) findViewById(R.id.extension1)).isChecked()) {
            String[] extension1 = getResources().getStringArray(R.array.extension1);
            for(int i = 0; i < extension1.length; ++i) {
                listOfRaces.add(extension1[i]);
            }
        }
        if(((CheckBox) findViewById(R.id.extension2)).isChecked()) {
            String[] extension2 = getResources().getStringArray(R.array.extension2);
            for(int i = 0; i < extension2.length; ++i) {
                listOfRaces.add(extension2[i]);
            }
        }
        if(((CheckBox) findViewById(R.id.extension3)).isChecked()) {
            String[] extension3 = getResources().getStringArray(R.array.extension3);
            for(int i = 0; i < extension3.length; ++i) {
                listOfRaces.add(extension3[i]);
            }
        }
        return listOfRaces;
    }
}
