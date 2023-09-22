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

        System.out.println("Wie möchtest du dein Haustier nennen?");
        String name = new Scanner(System.in).nextLine();

        return new Tamagotchi(name);
    }


}

