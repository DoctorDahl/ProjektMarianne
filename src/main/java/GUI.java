import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GUI {

    Scanner scanner = new Scanner(System.in);
    Kindergarten kindergarten;

    static final int LINE_WIDTH = 76;
    static final int PRE_WS = 4;
    static final String spaces = "                                                                                                                                            ";
    static final String line = "+-------------------------------------------------------------------------------------------------------------------------------------------";

    public String headerBlock;
    public static String backLine = fillLine()
            + fillLine("Tast \"B\" for at gå tilbage.");

    public static String endLine = fillLine("Tast \"Q\" for at afslutte.");

    public static String mainLine = fillLine("Tast \"M\" for at gå til  hovedmenu.");

    public static String bottom = fillLine()
            + fillLine("Godkend med \"Enter\"")
            + fillLine()
            + horisontalLine();

    public static String footerBlock = backLine + mainLine + endLine + bottom;

    static String horisontalLine(int length) {
        return line.substring(0, length - 1) + "+\n";
    }

    static String horisontalLine() {
        return horisontalLine(LINE_WIDTH);
    }

    static String fillLine(String string, int length, int preWS) {
        return "|" + spaces.substring(0, preWS) + string + spaces.substring(0, length - (2 + preWS + string.length())) + "|\n";
    }

    static String fillLine(int length) {
        return "|" + spaces.substring(0, length - 2) + "|\n";
    }

    static String fillLine() {
        return fillLine(LINE_WIDTH);
    }

    static String fillLine(String string) {
        return fillLine(string, LINE_WIDTH, PRE_WS);
    }

    private String generateHeader(String kindergartenName) {

        String header = horisontalLine(LINE_WIDTH)
                + fillLine(kindergartenName, LINE_WIDTH, (LINE_WIDTH - kindergartenName.length()) / 2 - 1)
                + horisontalLine(LINE_WIDTH)
                + fillLine(LINE_WIDTH);

        return header;
    }

    public GUI(Kindergarten kindergarten, String kindergartenName) throws IOException{
        this.kindergarten = kindergarten;
        this.headerBlock = generateHeader(kindergartenName);
        mainFlow();
    }

    /**
     * Examine if a string is "M" or "Q"
     *
     * @param string the string to examine
     * @return true if string is "M" or "Q"
     */
    private static boolean isMQ(String string) {
        switch (string.toUpperCase()) {
            case "M":
            case "Q":
                return true;
        }
        return false;
    }

    /**
     * Examine if a string is "B", "M" or "Q"
     *
     * @param string the string to examine
     * @return true is string is "B", "M" or "Q"
     */
    private static boolean isBMQ(String string) {
        switch (string.toUpperCase()) {
            case "B":
            case "M":
            case "Q":
                return true;
        }
        return false;
    }



    /******************************************************************************************************************
     *
     *      Flow-, GUI- and Display-methods
     *
     *      "Flow" methods handle which direction to take through the program.
     *      "GUI" methods handle the inputs from the user.
     *      "Display" methods handle the look of the GUI.
     *
     ******************************************************************************************************************/

    private void mainFlow() throws IOException {
        String result;
        do{
            result = mainGUI();

            switch (result) {
                case "1":
                   managerAccessMenu();
                    break;
                case "2":
                    staffAccessMenu();
                    break;
            }
        } while (!result.equals("Q"));
    }

    private String mainGUI() {
        String result;
        while (true) {
            mainDisplay();
            result = scanner.next();
            scanner.nextLine();
            switch (result) {
                case "1":
                case "2":
                    return result;
                case "Q":
                case "q":
                    return "Q";
            }
        }
    }

    private void mainDisplay() {
        String screen = headerBlock
                + fillLine("Tast \"1\" hvis du er Over-Marianne.")
                + fillLine("Tast \"2\" hvis du er Almindelig Marianne.")
                + fillLine()
                + endLine
                + bottom;

        System.out.println(screen);
    }

    // TODO - implementer b - q - m
    public  void managerAccessMenu() throws IOException {
        String screen = headerBlock
                + fillLine("Tast \"1\" for at få tilgang til Børne menuen.")
                + fillLine("Tast \"2\" for at få tilgang til medarbejder menuen.")
                + fillLine("Tast \"3\" for at få tilgang til vagtplan menuen.")
                + fillLine("Tast \"4\" for at se en liste over alle børn")
                + fillLine("Tast \"5\" for at se en liste over alle medarbejdere")
                + fillLine("Tast \"6\" for at se en vagtplanen")
                + fillLine()
                + endLine
                + bottom;
        System.out.println(screen);

        int choice = Main.keyInput.nextInt();
        switch(choice){
            case 1:
                childrenMenu();
                break;
            case 2:
                employeeMenu();
                break;
            case 3: // TODO - rostermenu
                break;
            case 4:
                // TODO - PRINT ALLE BØRN -  søg specifikt barn
                break;
            case 5:
                // TODO - PRINT ALLE MEDARBEJDERE -  søg specifik medarbejder
                break;
            case 6: // TODO - se vagtplan
                default: switchDefault();
                    break;
        }

    }
    // TODO - implementer b - q - m
    public void staffAccessMenu(){
        String result = Main.keyInput.nextLine();
        do{
        String screen = headerBlock
                + fillLine("Tast \"1\" for at se en liste over alle børn.")
                + fillLine("Tast \"2\" for at se en liste over alle medarbejdere.")
                + fillLine("Tast \"3\" for at se en din vagtplan.")
                + fillLine()
                + endLine
                + bottom;
        System.out.println(screen);

        String choice = Main.keyInput.nextLine();
        switch (choice){
            case "1":
                // TODO - PRINT ALLE BØRN -  søg specifikt barn
                break;
            case "2":
                 // TODO - PRINT ALLE MEDARBEJDERE -  søg specifik medarbejder
                break;
            case "3": // TODO - se din vagtplan
                break;
                default: switchDefault();
                    break;
        }
        } while(!result.equalsIgnoreCase("q"));
    }
    // TODO - implementer b - q - m
    public void childrenMenu() {
        String screen = headerBlock
                +fillLine("Tast \"1\" for at oprette et nyt barn.")
                +fillLine("Tast \"2\" for at fjerne et barn.")
                + fillLine()
                + endLine
                + bottom;
        System.out.println(screen);
        String choice = Main.keyInput.nextLine();
        switch (choice){
            case "1": addChildDisplay();
                break;
            case "2": // TODO fjern barn
                default: switchDefault();
                    break;
        }
    }

    // TODO - implementer b - q - m
    public void employeeMenu() {
        String screen = headerBlock
                +fillLine("Tast \"1\" for at oprette en ny medarbejder.")
                +fillLine("Tast \"2\" for at fjerne en medarbejder. ")
                + fillLine()
                + endLine
                + bottom;
        System.out.println(screen);
        String choice = Main.keyInput.nextLine();
        switch (choice){
            case "1": addEmployeeDisplay();
                break;
            case "2": // TODO fjern medarbejder
            default: switchDefault();
                break;
        }
    }

    public void addChildDisplay() {

        System.out.println("indtast følgende data: \n");
        System.out.println("Barnets cpr nr:");
        Main.keyInput.nextLine();
        String socialSecNo = Main.keyInput.nextLine();
        System.out.println("Barnets fornavn:");
        String firstName = Main.keyInput.nextLine();
        System.out.println("Barnets efternavn:");
        String lastName = Main.keyInput.nextLine();
        System.out.println("Barnets specielle behov:");
        String specialConditions = Main.keyInput.nextLine();
        System.out.println("Barnets addresse: ");
        String address = Main.keyInput.nextLine();
        System.out.println("Første værges navn:");
        String parent1Name = Main.keyInput.nextLine();
        System.out.println("Første værges telefon nr:");
        String parent1Phone = Main.keyInput.nextLine();
        System.out.println("Første værges adresse:");
        String parent1Address = Main.keyInput.nextLine();
        System.out.println("Anden værges navn:");
        String parent2Name = Main.keyInput.nextLine();
        System.out.println("Anden værges telefon nr: ");
        String parent2Phone = Main.keyInput.nextLine();
        System.out.println("Anden værges adresse: ");
        String parent2Address = Main.keyInput.nextLine();

        try{
        kindergarten.enrollChild(new String[]{
                socialSecNo, firstName, lastName, specialConditions, address, parent1Name, parent1Phone,
                parent1Address, parent2Name, parent2Phone, parent2Address
        });
            System.out.println( firstName + " er oprettet i systemet");
        }catch(Exception e){
            System.out.println("Failed adding child");
            e.printStackTrace();
        }
    }

    public void addEmployeeDisplay() {

        System.out.println("Indtast følgende data: \n");
        System.out.println("Medarbejderens rolle\n Tast 0 for Manager\n Tast 1 for pædagog");
        String type = Main.keyInput.nextLine();
        System.out.println("Medarbejderens ID nummber: ");
        String idNo = Main.keyInput.nextLine();
        System.out.println("Medarbejderen fornavn: ");
        String f_name = Main.keyInput.nextLine();
        System.out.println("Medarbejderen efternavn: ");
        String l_name = Main.keyInput.nextLine();
        System.out.println("Telefon nummer: ");
        String phoneNo = Main.keyInput.nextLine();
        System.out.println("Adresse: ");
        String address = Main.keyInput.nextLine();
        System.out.println("Medarbejderen ønsket antal ugentlige timer: ");
        String numWorkHours = Main.keyInput.nextLine();
        try{
        kindergarten.addEmployee((new String[]{
                type, f_name, l_name, phoneNo, address, numWorkHours
        }));
            System.out.println(f_name + " Er oprettet i systemet");
        }catch(Exception e){
            System.out.println("Failed adding Employee");
            e.printStackTrace();
        }
    }

    public void switchDefault(){
        Main.keyInput.nextLine(); // clear the wrong input before trying again
        System.out.println("Wrong input");
    }


}
