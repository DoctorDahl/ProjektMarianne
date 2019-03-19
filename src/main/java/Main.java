import java.io.IOException;

public class Main {

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
