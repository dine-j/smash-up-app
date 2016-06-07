package acelis.personalprojects.Smash_up.model;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    private List<String> race = new ArrayList<String>();

    public Race() {
        String[] basicRaces = {"Pirates", "Ninja", "Zombies", "Robots", "Dinosaures", "Sorciers", "Petit Peuple", "Aliens"};
        String[] extension3 = {"Chats", "Fées", "Poney", "Princesse"};
        for (int i = 0; i < basicRaces.length; i++) {
            race.add(basicRaces[i]);
        }
        for (int i = 0; i < extension3.length; i++) {
            race.add(extension3[i]);
        }
    }

    public List<String> getRaces() {
        return race;
    }

    public String[] getRandom2Races() {
        Random random = new Random();
        String[] choix = new String[2];

        for(int i = 0; i < 2; ++i) {
            int index = random.nextInt(race.size());
            choix[i] = race.get(index);
            race.remove(index);
        }
        return choix;
    }
}