import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner keyInput = new Scanner(System.in);

    public static void main(String[] args) {

        Kindergarten kindergarten = null;
        try {
            kindergarten = new Kindergarten();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new GUI(kindergarten, "Roskilde Frie Børnehave");

    }
}
