package org.example;

public class ValutatorePassword {
    public String valuta(String password) {
        int punti = 0;

        // Più è lunga, meglio è
        if (password.length() >= 8) {
            punti++;
        }
        if (password.length() >= 12) {
            punti++;
        }
        if (password.length() >= 16) {
            punti++;
        }

        // Più tipi di caratteri ci sono, meglio è
        boolean haMinuscole = false;
        boolean haMaiuscole = false;
        boolean haNumeri = false;
        boolean haSimboli = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                haMinuscole = true;
            } else if (Character.isUpperCase(c)) {
                haMaiuscole = true;
            } else if (Character.isDigit(c)) {
                haNumeri = true;
            } else {
                haSimboli = true;
            }
        }

        if (haMinuscole) punti++;
        if (haMaiuscole) punti++;
        if (haNumeri) punti++;
        if (haSimboli) punti++;

        if (punti <= 3) {
            return "🔴 Debole";
        } else if (punti <= 5) {
            return "🟡 Media";
        } else {
            return "🟢 Forte";
        }
    }
}
