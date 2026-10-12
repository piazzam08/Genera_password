package org.example;
import java.util.Scanner;
import static java.lang.IO.println;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Scanner tastiera = new Scanner(System.in);
        GeneratorePassword generatore = new GeneratorePassword();
        ValutatorePassword valutatore = new ValutatorePassword();

        boolean continua = true;

        println("🔐 Generatore di Password 🔐");

        while (continua) {
            println();
            println("1) Genera una password");
            println("0) Esci");
            println("Scegli: ");
            String scelta = tastiera.nextLine();

            switch (scelta) {
                case "1" -> {
                    try {
                        println("Quanti caratteri (8-32)? ");
                        int lunghezza = Integer.parseInt(tastiera.nextLine());

                        if (lunghezza < 8 || lunghezza > 32) {
                            println("Scegli un numero tra 8 e 32.");
                        } else {
                            boolean numeri = chiediSiNo(tastiera, "Vuoi i numeri?");
                            boolean simboli = chiediSiNo(tastiera, "Vuoi i simboli (!, #, $...)?");

                            String password = generatore.genera(lunghezza, numeri, simboli);
                            println(" Password: " + password);
                            println("Forza: " + valutatore.valuta(password));
                        }
                    } catch (NumberFormatException e) {
                        println("Devi scrivere un numero!");
                    }
                }
                case "0" -> {
                    continua = false;
                    println("Ciao! Usa password sicure! 👋");
                }
                default -> println("Scelta non valida, riprova.");
            }
        }

        tastiera.close();
    }

    // Fa una domanda e restituisce true se l'utente risponde "s"
    private static boolean chiediSiNo(Scanner tastiera, String domanda) {
        println(domanda + " (s/n): ");
        String risposta = tastiera.nextLine();
        return risposta.equalsIgnoreCase("s");
    }

}
