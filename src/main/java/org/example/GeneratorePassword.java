package org.example;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import java.util.ArrayList;
import java.util.List;

public class GeneratorePassword {

    private final PasswordGenerator generatore = new PasswordGenerator();

    public String genera(int lunghezza, boolean usaNumeri, boolean usaSimboli) {
        List<CharacterRule> regole = new ArrayList<>();

        // Queste due regole ci sono sempre: almeno 1 minuscola e 1 maiuscola
        regole.add(new CharacterRule(EnglishCharacterData.LowerCase, 1));
        regole.add(new CharacterRule(EnglishCharacterData.UpperCase, 1));

        // Queste dipendono dalle scelte dell'utente
        if (usaNumeri) {
            regole.add(new CharacterRule(EnglishCharacterData.Digit, 1));
        }
        if (usaSimboli) {
            regole.add(new CharacterRule(EnglishCharacterData.Special, 1));
        }

        return generatore.generatePassword(lunghezza, regole);
    }
}
