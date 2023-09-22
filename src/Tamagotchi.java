import java.util.InputMismatchException;
import java.util.Scanner;

public class Tamagotchi {

    private int tiredness;
    private int cleanliness;
    private int happiness;
    public String name;
    public boolean alive = true;

    public int state = 0;



    public Tamagotchi (String name) {
        cleanliness = 4;
        tiredness = 1;
        happiness = 3;
        this.name = name;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public int getTiredness() {
        return tiredness;
    }

    public int getHappiness() {
        return happiness;
    }

    public void wake (int amount) {
        //method for decreasing tiredness
        for (int i = 0; i < amount; i++) {
            if (tiredness > 1) {
                tiredness --;
//                System.out.println("tiredness = " + tiredness);
            }
            else if (i == 0 && tiredness == 1) {
                System.out.println(name + " ist schon ganz Wach ._.");
                break;
            }
            else {
                break;
            }
        }
    }

    public void tire (int amount) {
        //method for tiring
        for (int i = 0; i < amount; i++) {
            if (tiredness < 5) {
                this.tiredness ++;
//                System.out.println("tiredness = " + tiredness);
            } else {
                this.tiredness ++;
                //if tiredness > 5 --> tamagotchi dies
                System.out.println(name + "ist todmüde. Bete zu Satan um es wider zum Leben zu erwecken.");
                if (this.worship()) {
                    this.tiredness = 1;
                }
                break;
            }
        }
    }

    public void clean (int amount){
        //method for increasing cleanliness
        for (int i = 0; i < amount; i++) {
            if (cleanliness < 5) {
                cleanliness ++;
//                System.out.println("cleanliness = " + cleanliness);
            }
            else if (i == 0 && cleanliness == 5) {
                System.out.println(name + " ist schon Sauber ._.");
                break;
            }
            else {
                break;
            }
        }
    }

    public void dirty (int amount) {
        for (int i = 0; i < amount; i++) {
            if (cleanliness > 1) {
                cleanliness --;
//                System.out.println("cleanliness = " + cleanliness);
            }
            else {
                System.out.println(name + " erstickt am Schmutz :(");
                cleanliness --;
                if (this.worship()) {
                    this.cleanliness = 5;
                }
                break;
            }
        }
    }

    public void makeHappy (int amount) {
        //method for increasing happiness
        for (int i = 0; i < amount; i++) {
            if (happiness < 5) {
                happiness ++;
//                System.out.println("happiness = " + happiness);
            }
            else if (i == 0 && happiness == 5) {
                System.out.println(name + " ist schon Glücklich ._.");
                break;
            } else {
                break;
            }
        }
    }

    public void makeSad (int amount) {
        //method for decreasing happiness
        for (int i = 0; i < amount; i++) {
            if (happiness > 1) {
                happiness --;
//                System.out.println("cleanliness = " + happiness);
            }
            else {
                happiness --;
                System.out.println(name + " ist todunglüclich! :(");
                if (this.worship()) {
                    this.happiness = 5;
                }
                break;
            }
        }
    }

    private boolean worship () {
        int input = 2;
        //worship satan to revive tamagotchi

        //clears screen
        updateState();
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
        printTamagotchi();

        System.out.println("Drücke [1] um Satan anzubeten.  |  Drücke [any] um Jesus anzubeten.");
        try {
            input = new Scanner(System.in).nextInt();
        }
        catch (InputMismatchException e) {
        }

        if (input == 1) {
            System.out.println("Du hast "+ name +" mit Satans hilfe gerettet.");
            return true;
        }
        else {
            System.out.println("Jesus hat dir nicht geholfen.");
            new AsciiPrinter().gameOver();
            //System.out.println("gameOver");
            System.exit(0);
            return false;
        }
    }

    public void printBars(){
        //print bars to represent stats

        //print happiness bars
//        System.out.println();
        System.out.print("Happiness:   ");
        for (int i = 0; i < happiness; i++) {
            System.out.print("█");
        }
        for (int i = 0; i < 5 - happiness; i++) {
            System.out.print("░");
        }

        //print tiredness bars
        System.out.println();
        System.out.print("Tiredness:   ");
        for (int i = 0; i < tiredness; i++) {
            System.out.print("█");
        }
        for (int i = 0; i < 5 - tiredness; i++) {
            System.out.print("░");
        }

        //print cleanliness bars
        System.out.println();
        System.out.print("Cleanliness: ");
        for (int i = 0; i < cleanliness; i++) {
            System.out.print("█");
        }
        for (int i = 0; i < 5 - cleanliness; i++) {
            System.out.print("░");
        }

        System.out.println();

    }


    public void promt () throws InterruptedException {
        System.out.println();
        System.out.println("Was möchtest du tun?");
        System.out.println("[1] - Spielen | [2] -  Baden | [3] Schlafen | [any] lieber allein ins Kino. | [9] spiel beenden.");

        int input = 8;

        try {
            input = new Scanner(System.in).nextInt();
        }
        catch (InputMismatchException err) {}


        if (input == 1) {
            System.out.println("Toll, ihr spielt eine Runde nummern raten!");
            if (new NumberGame().playGame()){
                System.out.println("Du warst gut! Das hat " + name + " glücklich gemacht.");
                Thread.sleep(750);
                this.tire(1);
                this.makeHappy(2);
            }
            else {
                System.out.println("Du warst nicht so gut. Das macht " + name + " traurig");
                Thread.sleep(750);
                this.tire(2);
                this.makeSad(1);
            }
            this.dirty(1);
            Thread.sleep(1000);
        }
        else if (input == 2){
            System.out.println("Du entschließt dich, " + name + " zu baden.");
            Thread.sleep(750);
            this.clean(2);
            this.makeSad(1);
            Thread.sleep(1000);
        } else if (input == 3) {
            System.out.println("Du bringst " + name + " ins Bett.");
            Thread.sleep(750);
            this.wake(5);

            this.makeHappy(1);
            Thread.sleep(1000);
        } else if (input == 9) {
            alive = false;

        } else {
            System.out.println(name + " fühlt sich alleine gelassen und kann sich nicht um sich selbst kümmern.");
            Thread.sleep(750);
            this.makeSad(1);
            this.dirty(1);
            Thread.sleep(1000);

        }
        updateState();
    }

    private void updateState () {
        if (cleanliness < 1 || tiredness > 5 || happiness < 1){
            state = 3;
        } else if (tiredness > 3) {
            state = 2;
        } else if (happiness > 3) {
            state = 1;
        } else {
            state = 0;
        }
    }


    public void printTamagotchi (){

        String[] states = new String[] { null, null, null, null} ;

        final String happy = """
                     _   _
                    (q\\_/p)
                .-.  |. .|
                   \\ =\\,/=
                    )/ _ \\ \s
                   (/\\):(/\\) \s
                    \\_   _/\s
                    `""^""`\s""";



        final String excited = """
                     _   _
                    (q\\_/p)
                .-.  |^ ^|
                   \\ =\\,/=
                    )/ _ \\ \s
                   (/\\):(/\\) \s
                    \\_   _/\s
                    `""^""`\s""";

        final String dead = """
                     _   _
                    (q\\_/p)
                .-.  |x x|
                   \\ =\\,/=
                    )/ _ \\ \s
                   (/\\):(/\\) \s
                    \\_   _/\s
                    `""^""`\s""";

        final String tired = """
                     _   _
                    (q\\_/p)
                .-.  |- -|
                   \\ =\\,/=
                    )/ _ \\ \s
                   (/\\):(/\\) \s
                    \\_   _/\s
                    `""^""`\s""";

        states[0] = happy;
        states[1] = excited;
        states[2] = tired;
        states[3] = dead;

        System.out.println(states[state]);



    }

    public static Tamagotchi chooseName() throws InterruptedException {

        System.out.println("Wie möchtest du dein Haustier nennen?");
        String name = new Scanner(System.in).nextLine();

        return new Tamagotchi(name);
    }

//    public static void typeWriter (String str) throws InterruptedException {
//        for (int i = 0; i < str.length(); i++) {
//            System.out.print(str.charAt(i));
//            Thread.sleep(100);
//        }
//
//
//    }
}



