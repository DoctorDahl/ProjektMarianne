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

    public GUI(Kindergarten kindergarten, String kindergartenName) {
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
        switch (string) {
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
        switch (string) {
            case "B":
            case "M":
            case "Q":
                return true;
        }
        return false;
    }

    /**
     * Transform lowercase "b", "m" and "q" to uppercase
     *
     * @param result the string to transform
     * @return "B", "M" or "Q" if input is "b", "m" or "q", otherwise the original string is returned
     */
    private static String cleanBMQ(String result) {
        switch (result) {
            case "b":
                return "B";
            case "m":
                return "M";
            case "q":
                return "Q";
        }
        return result;
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

    private void mainFlow() {
        String result;
        do{
            result = mainGUI();

            switch (result) {
                case "1":
                    //result = overMarianneFlow();
                    break;
                case "2":
                    //result = almMarianneFlow();
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

}
