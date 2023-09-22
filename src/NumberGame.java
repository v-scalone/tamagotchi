import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public NumberGame () {}

    public boolean playGame () {
        int input = 0;
        int tries = 0;

        System.out.println("Ich habe eine Nummer zwischen 0 und 25 im Kopf.");
        System.out.println("Gebe einen Tip ab.");
        int num = new Random().nextInt(26);

        while (true){

            while (true) {
                try{
                    input = new Scanner(System.in).nextInt();
                    break;
                }
                catch (java.util.InputMismatchException e) {
                    System.out.println("Bitte gebe eine ganze Zahl ein.");
                }
            }
            tries += 1;

            if ( input < num ) {
                System.out.println("Die Zahl ist groesser.");
            }
            else if ( input > num ) {
                System.out.println("Die Zahl ist kleiner.");
            }
            else {
                System.out.println("Herzlichen Glueckwunsch! Du hast die Zahl in " + tries + " Versuchen erraten. Aber reicht es, um dein Haustier glücklich zu machen?");
                break;
            }
        }

        return tries <= 4;
    }


}
