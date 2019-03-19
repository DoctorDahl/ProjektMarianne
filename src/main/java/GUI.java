import java.io.IOException;
import java.lang.reflect.Array;
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

    public GUI(Kindergarten kindergarten, String kindergartenName) throws IOException {
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
        do {
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
    public void managerAccessMenu() throws IOException {
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

        String choice = scanner.next();
        scanner.nextLine();
        switch (choice) {
            case "1":
                childrenMenu();
                break;
            case "2":
                employeeMenu();
                break;
            case "3":
                // TODO - rostermenu
                break;
            case "4":
                getAllChildren();
                // -  søg specifikt barn
                break;
            case "5":
                getAllEmployees();
                // TODO -  søg specifik medarbejder
                break;
            case "6":
                // TODO - se vagtplan
                break;
            default:
                switchDefault();
                break;
        }

    }

    // TODO - implementer b - q - m
    public void staffAccessMenu() throws IOException {

        String screen = headerBlock
                + fillLine("Tast \"1\" for at se en liste over alle børn.")
                + fillLine("Tast \"2\" for at se en liste over alle medarbejdere.")
                + fillLine("Tast \"3\" for at se en din vagtplan.")
                + fillLine()
                + endLine
                + bottom;
        System.out.println(screen);

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                getAllChildren();// TODO  -  søg specifikt barn
                break;
            case "2":
                getAllEmployees(); // TODO  -  søg specifik medarbejder
                break;
            case "3": // TODO - se din vagtplan
                break;
            default:
                switchDefault();
                break;
        }

    }

    // TODO - implementer b - q - m
    public void childrenMenu() {
        String screen = headerBlock
                + fillLine("Tast \"1\" for at oprette et nyt barn.")
                + fillLine("Tast \"2\" for at fjerne et barn.")
                + fillLine()
                + endLine
                + bottom;
        System.out.println(screen);
        String choice = scanner.next();
        scanner.nextLine();
        switch (choice) {
            case "1":
                addChildDisplay();
                break;
            case "2":
                deleteChild();
                break;
            default:
                switchDefault();
        }
    }

    // TODO - implementer b - q - m
    public void employeeMenu() {
        String screen = headerBlock
                + fillLine("Tast \"1\" for at oprette en ny medarbejder.")
                + fillLine("Tast \"2\" for at fjerne en medarbejder. ")
                + fillLine()
                + endLine
                + bottom;
        System.out.println(screen);
        String choice = scanner.next();
        scanner.nextLine();
        switch (choice) {
            case "1":
                addEmployeeDisplay();
                break;
            case "2":
                deleteEmployee();
                break;
            default:
                switchDefault();
        }
    }

    public void rosterMenu() {
        String screen = headerBlock
                + fillLine("Tast \"1\" for at oprette en ny medarbejder.")
                + fillLine("Tast \"2\" for at fjerne en vagtplan")
                + fillLine("Tast \"3\" for at opdatere en vagtplan")
                + fillLine("Tast \"4\" for at se vagtplan")
                + fillLine()
                + endLine
                + bottom;
        System.out.println(screen);
        String choice = scanner.nextLine();
        switch (choice){
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
                default: switchDefault();
        }
    }

    public void addChildDisplay() {

        String[] prompts = new String[]{
                "Barnets cpr nr:",
                "Barnets fornavn:",
                "Barnets efternavn:",
                "Barnets specielle behov:",
                "Barnets addresse:",
                "Første værges fulde navn:",
                "Første værges telefon nr:",
                "Første værges adresse:",
                "Anden værges fulde navn:",
                "Anden værges telefon nr:",
                "Anden værges adresse:"
        };
        String[] childInfo = new String[11];

        String screen;
        for (int i = 0; i < childInfo.length; i++) {
            screen = headerBlock
                    + fillLine(prompts[i])
                    + bottom;
            System.out.println(screen);
            childInfo[i] = scanner.nextLine();
        }

        try {
            kindergarten.enrollChild(childInfo);
            screen = headerBlock
                    + fillLine(childInfo[1] + " er oprettet i systemet.")
                    + bottom;
            System.out.println(screen);
            scanner.nextLine();
        } catch (IOException e) {
            screen = headerBlock
                    + fillLine("Der opstod en fejl. Prøv igen.")
                    + bottom;
            System.out.println(screen);
            scanner.nextLine();
        }

    }

    public void addEmployeeDisplay() {

        String[] prompts = new String[]{
                "Medarbejderens rolle: \"Manager\",\"FullTimeEmployee\" eller \"PartTimeEmployee\"",
                "Medarbejderens ID nummer:",
                "Medarbejderen fornavn:",
                "Medarbejderen efternavn:",
                "Telefon nummer:",
                "Adresse:"
        };
        String[] employeeInfo = new String[7];

        String screen;
        for (int i = 0; i < employeeInfo.length-1; i++) {
            screen = headerBlock
                    + fillLine(prompts[i])
                    + bottom;
            System.out.println(screen);
            employeeInfo[i] = scanner.nextLine();
        }
        if(employeeInfo[0].toUpperCase().equals("PARTTIMEEMPLOYEE")) {
            screen = headerBlock
                    + fillLine("Hvor mange timers abejdsuge?")
                    +bottom;
            System.out.println(screen);
            employeeInfo[6] = scanner.nextLine();
        } else {
            employeeInfo = Arrays.copyOf(employeeInfo,6);
        }

        try {
            kindergarten.addEmployee(employeeInfo);
            screen = headerBlock
                    + fillLine(employeeInfo[2] + " er oprettet i systemet.")
                    + bottom;
            System.out.println(screen);
            scanner.nextLine();
        } catch (IOException e) {
            screen = headerBlock
                    + fillLine("Der opstod en fejl. Prøv igen.")
                    + bottom;
            System.out.println(screen);
            scanner.nextLine();
        }

    }

    public void deleteChild() {
        System.out.println("Indtast CPR nr på ønsket barn: ");
        //scanner.nextLine();
        String socialSecNo = scanner.nextLine();
        try {
            kindergarten.disenrollChild(socialSecNo);
            System.out.println("barn fjernet");
        } catch (Exception e) {
            System.out.println("Failed deleting child");
            e.printStackTrace();
        }
    }

    public void deleteEmployee() {
        System.out.println("Indtast idNo på ønsket medarbejder: ");
        //scanner.nextLine();
        String idNo = scanner.nextLine();
        try {
            kindergarten.removeEmployee(idNo);
            System.out.println("Medarbejder fjernet");
        } catch (Exception e) {
            System.out.println("Failed deleting staff");
            e.printStackTrace();
        }
    }

    public void getAllChildren() {
        String childInfo;
        for (Child child : kindergarten.getChildren()) {
            childInfo = child.getSocialSecNo() + ", " + child.getF_name() + " " + child.getL_name();
            System.out.println(fillLine(childInfo));
        }
    }

    public void getAllEmployees() {
        String employeeInfo;
        for (Employee employee : kindergarten.getEmployees()) {
            employeeInfo = employee.getIdNo() + ", " + employee.getF_name() + " " + employee.getL_name();
            System.out.println(fillLine(employeeInfo));
        }
    }

    public void switchDefault() {
        scanner.nextLine(); // clear the wrong input before trying again
        System.out.println("Wrong input");
    }
}

/*
    public void ChildrenSearch(){

         choice = sc. nextLine()
        int i = 0;
        while (choice != kindergarten.children[i]) {
            i++;
        }

    }
}
