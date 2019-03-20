import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GUI {

    private Scanner scanner = new Scanner(System.in);
    private Kindergarten kindergarten;

    private static final int LINE_WIDTH = 76;
    private static final int PRE_WS = 4;
    private static final String spaces = "                                                                                                                                            ";
    private static final String line = "+-------------------------------------------------------------------------------------------------------------------------------------------";

    private String headerBlock;
    //private static String backLine = fillLine()
    //        + fillLine("Tast \"B\" for at gå tilbage.");
    //private static String endLine = fillLine("Tast \"Q\" for at afslutte.");
    //private static String mainLine = fillLine("Tast \"M\" for at gå til  hovedmenu.");

    private static String bottom = fillLine()
            + fillLine("Godkend med \"Enter\"")
            + fillLine()
            + horisontalLine();

    //public static String footerBlock = backLine + mainLine + endLine + bottom;

    private static String horisontalLine(int length) {
        return line.substring(0, length - 1) + "+\n";
    }

    private static String horisontalLine() {
        return horisontalLine(LINE_WIDTH);
    }

    private static String fillLine(String string, int length, int preWS) {
        return "|" + spaces.substring(0, preWS) + string + spaces.substring(0, length - (2 + preWS + string.length())) + "|\n";
    }

    private static String fillLine(int length) {
        return "|" + spaces.substring(0, length - 2) + "|\n";
    }

    private static String fillLine() {
        return fillLine(LINE_WIDTH);
    }

    private static String fillLine(String string) {
        return fillLine(string, LINE_WIDTH, PRE_WS);
    }

    private String generateHeader(String kindergartenName) {
        return horisontalLine(LINE_WIDTH)
                + fillLine(kindergartenName, LINE_WIDTH, (LINE_WIDTH - kindergartenName.length()) / 2 - 1)
                + horisontalLine(LINE_WIDTH)
                + fillLine(LINE_WIDTH);
    }

    public GUI(Kindergarten kindergarten, String kindergartenName) {
        this.kindergarten = kindergarten;
        this.headerBlock = generateHeader(kindergartenName);
        mainFlow();
    }


    /*********************************************
     *
     *      Methods for GUI-flow are below.
     *
     *      <<>> Here be dragons <<>>
     *
     *********************************************/

    private void mainFlow() {
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
                + bottom;

        System.out.println(screen);
    }

    private void managerAccessMenu() {
        String screen = headerBlock
                + fillLine("Tast \"1\" for at få tilgang til Børne menuen.")
                + fillLine("Tast \"2\" for at få tilgang til medarbejder menuen.")
                + fillLine("Tast \"3\" for at få tilgang til vagtplan menuen.")
                + fillLine("Tast \"4\" for at se en liste over alle børn")
                + fillLine("Tast \"5\" for at se en liste over alle medarbejdere")
                + fillLine("Tast \"6\" for at se en vagtplanen")
                + fillLine()
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
                rosterMenu();
                break;
            case "4":
                getAllChildren();
                break;
            case "5":
                getAllEmployees();
                break;
            case "6":
                seeRoster();
                break;
            default:
                switchDefault();
                break;
        }

    }

    private void staffAccessMenu() {

        String screen = headerBlock
                + fillLine("Tast \"1\" for at se en liste over alle børn.")
                + fillLine("Tast \"2\" for at se en liste over alle medarbejdere.")
                + fillLine("Tast \"3\" for at se en din vagtplan.")
                + fillLine()
                + bottom;
        System.out.println(screen);

        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                getAllChildren();
                break;
            case "2":
                getAllEmployees();
                break;
            case "3":
                seeRoster();
                break;
            default:
                switchDefault();
                break;
        }

    }

    private void childrenMenu() {
        String screen = headerBlock
                + fillLine("Tast \"1\" for at oprette et nyt barn.")
                + fillLine("Tast \"2\" for at fjerne et barn.")
                + fillLine()
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

    private void employeeMenu() {
        String screen = headerBlock
                + fillLine("Tast \"1\" for at oprette en ny medarbejder.")
                + fillLine("Tast \"2\" for at fjerne en medarbejder. ")
                + fillLine()
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

    private void rosterMenu() {
        String screen = headerBlock
                + fillLine("Tast \"1\" for at oprette en ny medarbejder.")
                + fillLine("Tast \"2\" for at fjerne en vagtplan")
                + fillLine("Tast \"3\" for at opdatere en vagtplan")
                + fillLine("Tast \"4\" for at se vagtplan")
                + fillLine()
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
                seeRoster();
                break;
                default: switchDefault();
        }
    }

    private void addChildDisplay() {

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

        kindergarten.enrollChild(childInfo);
        screen = headerBlock
                + fillLine(childInfo[1] + " er oprettet i systemet.")
                + bottom;
        System.out.println(screen);
        scanner.nextLine();


    }

    private void addEmployeeDisplay() {

        String[] prompts = new String[]{
                "\"Manager\",\"FullTimeEmployee\" eller \"PartTimeEmployee\"?",
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

        kindergarten.addEmployee(employeeInfo);
        screen = headerBlock
                + fillLine(employeeInfo[2] + " er oprettet i systemet.")
                + bottom;
        System.out.println(screen);
        scanner.nextLine();

    }

    private void deleteChild() {

        String screen = headerBlock
                + fillLine("Indtast CPR nr på barn der ønskes fjernet:")
                + bottom;
        System.out.println(screen);

        String socialSecNo = scanner.nextLine();

        kindergarten.disenrollChild(socialSecNo);
        screen = headerBlock
                + fillLine("Barn fjernet fra systemet.")
                + bottom;
        System.out.println(screen);
        scanner.nextLine();

    }

    private void deleteEmployee() {
        String screen = headerBlock
                + fillLine("Indtast idNo på medarbejder der ønskes fjernet:")
                + bottom;
        System.out.println(screen);

        String idNo = scanner.nextLine();

        kindergarten.removeEmployee(idNo);
        screen = headerBlock
                + fillLine("Medarbejder fjernet fra systemet.")
                + bottom;
        System.out.println(screen);
        scanner.nextLine();

    }

    private void getAllChildren() {
        String childInfo;
        for (Child child : kindergarten.getChildren()) {
            childInfo = child.getSocialSecNo() + ", " + child.getF_name() + " " + child.getL_name();
            System.out.println(fillLine(childInfo));
        }
    }

    private void getAllEmployees() {
        String employeeInfo;
        for (Employee employee : kindergarten.getEmployees()) {
            employeeInfo = employee.getIdNo() + ", " + employee.getF_name() + " " + employee.getL_name();
            System.out.println(fillLine(employeeInfo));
        }
    }

    private void seeRoster() {
        String screen = headerBlock
                + fillLine("Indtast årstal for ønsket vagtplan:")
                + bottom;
        System.out.println(screen);

        String year = scanner.nextLine();

        screen = headerBlock
                + fillLine("Indtast uge nr:")
                + bottom;
        System.out.println(screen);

        String weekNo = scanner.nextLine();

        screen = headerBlock
                + fillLine("Ugeplan for uge " + weekNo + " år " + year)
                + stringyfyWeekRoster(kindergarten.getWeekRoster(year,Integer.parseInt(weekNo)),weekNo)
                + bottom;
        System.out.println(screen);
        scanner.nextLine();
    }

    private String stringyfyWeekRoster(List<String[]> weekRoster, String weekNo) {

        List<List<String>> earlyShifts = new ArrayList<>();
        List<List<String>> lateShifts = new ArrayList<>();
        List<List<String>> partTime = new ArrayList<>();

        for(int i = 0; i < weekRoster.get(0).length; i++) {
            earlyShifts.add(Arrays.asList(weekRoster.get(0)[i].split(",")));
            lateShifts.add(Arrays.asList(weekRoster.get(1)[i].split(",")));
            partTime.add(Arrays.asList(weekRoster.get(2)[i].split(",")));
        }

        List<List<List<String>>> fuck = new ArrayList<>();

        for (List<String> day : partTime) {
            List<List<String>> dailyInfo = new ArrayList<>();
            for (String employee : day) {
                List<String> empInfo = Arrays.asList(employee.split("§"));
                dailyInfo.add(empInfo);
            }
            fuck.add(dailyInfo);
        }


        int earlyLines = 0;
        int lateLines = 0;
        int partTimeLines = 0;

        for(List list : earlyShifts) {
            if(list.size() > earlyLines) {
                earlyLines = list.size();
            }
        }
        for(List list : lateShifts) {
            if(list.size() > lateLines) {
                lateLines = list.size();
            }
        }
        for(List list : partTime) {
            if(list.size() > partTimeLines) {
                partTimeLines = list.size();
            }
        }


        if(weekNo.length() == 1) {
            weekNo += " ";
        }
        StringBuilder rosterSB =
                new StringBuilder(fillLine("+--------+--------+--------+--------+--------+--------+", LINE_WIDTH, 8)
                        + fillLine("| Uge " + weekNo + " |  Man   |  Tirs  |  Ons   |  Tors  |  Fre   |", LINE_WIDTH, 8)
                        + fillLine("+--------+--------+--------+--------+--------+--------+", LINE_WIDTH, 8)
                        + fillLine("|  Åbner |  "
                        + idNoOrSpace(earlyShifts.get(0).get(0)) + "    |  "
                        + idNoOrSpace(earlyShifts.get(1).get(0)) + "    |  "
                        + idNoOrSpace(earlyShifts.get(2).get(0)) + "    |  "
                        + idNoOrSpace(earlyShifts.get(3).get(0)) + "    |  "
                        + idNoOrSpace(earlyShifts.get(4).get(0)) + "    |", LINE_WIDTH, 8
                ));

        if(earlyLines > 1) {
            for(int i = 1; i < earlyLines; i++) {
                rosterSB.append(fillLine("|        |  "
                        + idNoOrSpace(earlyShifts.get(0).get(i)) + "    |  "
                        + idNoOrSpace(earlyShifts.get(1).get(i)) + "    |  "
                        + idNoOrSpace(earlyShifts.get(2).get(i)) + "    |  "
                        + idNoOrSpace(earlyShifts.get(3).get(i)) + "    |  "
                        + idNoOrSpace(earlyShifts.get(4).get(i)) + "    |", LINE_WIDTH, 8));
            }
        }

        rosterSB.append(fillLine("+--------+--------+--------+--------+--------+--------+", LINE_WIDTH, 8)).append(fillLine("| Lukker |  "
                + idNoOrSpace(lateShifts.get(0).get(0)) + "    |  "
                + idNoOrSpace(lateShifts.get(1).get(0)) + "    |  "
                + idNoOrSpace(lateShifts.get(2).get(0)) + "    |  "
                + idNoOrSpace(lateShifts.get(3).get(0)) + "    |  "
                + idNoOrSpace(lateShifts.get(4).get(0)) + "    |", LINE_WIDTH, 8));

        if(lateLines > 1) {
            for(int i = 1; i < lateLines; i++) {
                rosterSB.append(fillLine("|        |  "
                        + idNoOrSpace(lateShifts.get(0).get(i)) + "    |  "
                        + idNoOrSpace(lateShifts.get(1).get(i)) + "    |  "
                        + idNoOrSpace(lateShifts.get(2).get(i)) + "    |  "
                        + idNoOrSpace(lateShifts.get(3).get(i)) + "    |  "
                        + idNoOrSpace(lateShifts.get(4).get(i)) + "    |", LINE_WIDTH, 8));
            }
        }

        rosterSB.append(fillLine("+--------+--------+--------+--------+--------+--------+", LINE_WIDTH, 8)).append(fillLine("| Deltid | "
                + idNoOrSpace(fuck.get(0).get(0).get(0)) + "     | "
                + idNoOrSpace(fuck.get(1).get(0).get(0)) + "     | "
                + idNoOrSpace(fuck.get(2).get(0).get(0)) + "     | "
                + idNoOrSpace(fuck.get(3).get(0).get(0)) + "     | "
                + idNoOrSpace(fuck.get(4).get(0).get(0)) + "     |", LINE_WIDTH, 8)).append(fillLine("|        |  "
                + idNoOrSpace(fuck.get(0).get(0).get(1)) + " |  "
                + idNoOrSpace(fuck.get(1).get(0).get(1)) + " |  "
                + idNoOrSpace(fuck.get(2).get(0).get(1)) + " |  "
                + idNoOrSpace(fuck.get(3).get(0).get(1)) + " |  "
                + idNoOrSpace(fuck.get(4).get(0).get(1)) + " |", LINE_WIDTH, 8)).append(fillLine("|        |  "
                + idNoOrSpace(fuck.get(0).get(0).get(2)) + " |  "
                + idNoOrSpace(fuck.get(1).get(0).get(2)) + " |  "
                + idNoOrSpace(fuck.get(2).get(0).get(2)) + " |  "
                + idNoOrSpace(fuck.get(3).get(0).get(2)) + " |  "
                + idNoOrSpace(fuck.get(4).get(0).get(2)) + " |", LINE_WIDTH, 8));

        if(partTimeLines > 1) {
            for(int i = 1; i < partTimeLines; i++) {
                rosterSB.append(fillLine("|        | "
                        + idNoOrSpace(fuck.get(0).get(i).get(0)) + "     | "
                        + idNoOrSpace(fuck.get(1).get(i).get(0)) + "     | "
                        + idNoOrSpace(fuck.get(2).get(i).get(0)) + "     | "
                        + idNoOrSpace(fuck.get(3).get(i).get(0)) + "     | "
                        + idNoOrSpace(fuck.get(4).get(i).get(0)) + "     |", LINE_WIDTH, 8)).append(fillLine("|        |  "
                        + idNoOrSpace(fuck.get(0).get(i).get(1)) + " |  "
                        + idNoOrSpace(fuck.get(1).get(i).get(1)) + " |  "
                        + idNoOrSpace(fuck.get(2).get(i).get(1)) + " |  "
                        + idNoOrSpace(fuck.get(3).get(i).get(1)) + " |  "
                        + idNoOrSpace(fuck.get(4).get(i).get(1)) + " |", LINE_WIDTH, 8)).append(fillLine("|        |  "
                        + idNoOrSpace(fuck.get(0).get(i).get(2)) + " |  "
                        + idNoOrSpace(fuck.get(1).get(i).get(2)) + " |  "
                        + idNoOrSpace(fuck.get(2).get(i).get(2)) + " |  "
                        + idNoOrSpace(fuck.get(3).get(i).get(2)) + " |  "
                        + idNoOrSpace(fuck.get(4).get(i).get(2)) + " |", LINE_WIDTH, 8));
            }
        }
        rosterSB.append(fillLine("+--------+--------+--------+--------+--------+--------+", LINE_WIDTH, 8));

        return rosterSB.toString();

    }

    private String idNoOrSpace(String string) {
        return (string == null) ? "  " : string;
    }

    private void switchDefault() {
        scanner.nextLine(); // clear the wrong input before trying again
        System.out.println("Wrong input");
    }

}
