
public class Renderer {
    Tamagotchi tama;
    public Renderer (Tamagotchi tama) {
        this.tama = tama;
    }

    public void clearScreen () {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public void makeFrame () throws InterruptedException {

        this.clearScreen();
        System.out.println(tama.name);

        tama.printBars();
        tama.printTamagotchi();

    }



}