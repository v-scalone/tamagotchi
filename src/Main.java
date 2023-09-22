import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Tamagotchi tama = chooseName();
        var renderer = new Renderer(tama);



        while (tama.alive) {
            renderer.makeFrame();
            tama.promt();
        }

    }

    public static Tamagotchi chooseName(){
        String name;
        while (true) {
            try {
                System.out.println("Wie möchtest du dein Haustier nennen?");
                name = new Scanner(System.in).nextLine();
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Bitte gibt ");
            }
        }
        return new Tamagotchi(name);
    }


}

