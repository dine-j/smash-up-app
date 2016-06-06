package acelis.personalprojects.Smash_up;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AskNumberPlayer extends Activity {
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
        int numberOfPlayers = Integer.parseInt(inputNumber.getText().toString());
        AskNames askNamesActivity = new AskNames(numberOfPlayers);
    }
}
