import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static Scanner keyInput = new Scanner(System.in);

    public static void main(String[] args) {

        Kindergarten kindergarten = null;
        try {
            kindergarten = new Kindergarten();
            //generateTestData(kindergarten);
        } catch (IOException e) {
            //TODO - Handle dat shit.
            e.printStackTrace();
        }
        new GUI(kindergarten, "Roskilde Frie Børnehave");

    }

    public static void generateTestData(Kindergarten kindergarten) throws IOException{

        kindergarten.enrollChild(new String[] {"000000-0000","Anne","Annesen","ADHD","Annevej 1, 4000 Roskilde","Anja Annesen","20000000","Annevej 1, 4000 Roskilde","Arne Annesen","22000000","Annevej 1, 4000 Roskilde"});
        kindergarten.enrollChild(new String[] {"000000-0001","Bo","Bosen","Bangebuks.","Bovej 1, 4000 Roskilde","Bolette Bosen","20000001","Bovej 1, 4000 Roskilde","Børge Bosen","22000001","Bovej 1, 4000 Roskilde"});
        kindergarten.enrollChild(new String[] {"000000-0002","Clara","Clarasen","Cocioafhængig.","Clarevej 1, 4000 Roskilde","Caja Clarasen","20000002","Clarevej 1, 4000 Roskilde","Claus Clarasen","22000002","Clarevej 1, 4000 Roskilde"});
        kindergarten.enrollChild(new String[] {"000000-0003","Dennis","Dennissen","Drikker for meget.","Dennisvej 1, 4000 Roskilde","Denice Dennissen","20000003","Dennisvej 1, 4000 Roskilde","Didrik Dennissen","22000003","Dennisvej 1, 4000 Roskilde"});
        kindergarten.enrollChild(new String[] {"000000-0004","Emma","Emmasen","Eksplosiv.","Emmavej 1, 4000 Roskilde","Erika Emmasen","20000004","Emmavej 1, 4000 Roskilde","Erik Emmasen","22000004","Emmavej 1, 4000 Roskilde"});
        kindergarten.enrollChild(new String[] {"000000-0005","Frederik","Frederiksen","Frygteligt barn.","Frederikvej 1, 4000 Roskilde","Frederikke Frederiksen","20000005","Frederikvej 1, 4000 Roskilde","Frede Frederiksen","22000005","Frederikvej 1, 4000 Roskilde"});
        kindergarten.enrollChild(new String[] {"000000-0006","Gurli","Gurlisen","Grinern.","Gurlivej 1, 4000 Roskilde","Grethe Gurlisen","20000006","Gurlivej 1, 4000 Roskilde","Gunner Gurlisen","22000006","Gurlivej 1, 4000 Roskilde"});

        kindergarten.addEmployee(new String[] {"Manager","L","Marianne","Ledersen","00000000","Mariannegade 0, 0.mf, 4000 Roskilde"});

        kindergarten.addEmployee(new String[] {"FullTimeEmployee","F1","Marianne","Fuldtidsen1","10000001","Mariannegade 11, 1.mf, 4000 Roskilde"});
        kindergarten.addEmployee(new String[] {"FullTimeEmployee","F2","Marianne","Fuldtidsen2","10000002","Mariannegade 12, 2.mf, 4000 Roskilde"});
        kindergarten.addEmployee(new String[] {"FullTimeEmployee","F3","Marianne","Fuldtidsen3","10000003","Mariannegade 13, 3.mf, 4000 Roskilde"});
        kindergarten.addEmployee(new String[] {"FullTimeEmployee","F4","Marianne","Fuldtidsen4","10000004","Mariannegade 14, 4.mf, 4000 Roskilde"});
        kindergarten.addEmployee(new String[] {"FullTimeEmployee","F5","Marianne","Fuldtidsen5","10000005","Mariannegade 15, 5.mf, 4000 Roskilde"});
        kindergarten.addEmployee(new String[] {"FullTimeEmployee","F6","Marianne","Fuldtidsen6","10000006","Mariannegade 16, 6.mf, 4000 Roskilde"});

        kindergarten.addEmployee(new String[] {"PartTimeEmployee","D1","Marianne","Deltidsen1","20000001","Mariannegade 21, 1.mf, 4000 Roskilde"});
        kindergarten.addEmployee(new String[] {"PartTimeEmployee","D2","Marianne","Deltidsen2","20000002","Mariannegade 22, 2.mf, 4000 Roskilde"});
        kindergarten.addEmployee(new String[] {"PartTimeEmployee","D3","Marianne","Deltidsen3","20000003","Mariannegade 23, 3.mf, 4000 Roskilde"});
        kindergarten.addEmployee(new String[] {"PartTimeEmployee","D4","Marianne","Deltidsen4","20000004","Mariannegade 24, 4.mf, 4000 Roskilde"});


        String year = "2019";
        kindergarten.createNewRoster(year);

        for (int weekNo = 1; weekNo < 53; weekNo++) {

            kindergarten.addValueRoster(year, weekNo, "Monday", "Early", "F1");
            kindergarten.addValueRoster(year, weekNo, "Monday", "Early", "F2");
            kindergarten.addValueRoster(year, weekNo, "Monday", "Late", "F3");
            kindergarten.addValueRoster(year, weekNo, "Monday", "Late", "F4");
            kindergarten.addValueRoster(year, weekNo, "Monday", "PartTime", "D1§10:00§12:30");
            kindergarten.addValueRoster(year, weekNo, "Monday", "PartTime", "D2§13:00§17:00");

            kindergarten.addValueRoster(year, weekNo, "Tuesday", "Early", "F1");
            kindergarten.addValueRoster(year, weekNo, "Tuesday", "Early", "F2");
            kindergarten.addValueRoster(year, weekNo, "Tuesday", "Late", "F3");
            kindergarten.addValueRoster(year, weekNo, "Tuesday", "Late", "F4");
            kindergarten.addValueRoster(year, weekNo, "Tuesday", "PartTime", "D1§10:00§12:30");
            kindergarten.addValueRoster(year, weekNo, "Tuesday", "PartTime", "D2§13:00§17:00");

            kindergarten.addValueRoster(year, weekNo, "Wednesday", "Early", "F3");
            kindergarten.addValueRoster(year, weekNo, "Wednesday", "Early", "F4");
            kindergarten.addValueRoster(year, weekNo, "Wednesday", "Late", "F5");
            kindergarten.addValueRoster(year, weekNo, "Wednesday", "Late", "F6");
            kindergarten.addValueRoster(year, weekNo, "Wednesday", "PartTime", "D3§10:00§12:30");
            kindergarten.addValueRoster(year, weekNo, "Wednesday", "PartTime", "D4§13:00§17:00");

            kindergarten.addValueRoster(year, weekNo, "Thursday", "Early", "F3");
            kindergarten.addValueRoster(year, weekNo, "Thursday", "Early", "F4");
            kindergarten.addValueRoster(year, weekNo, "Thursday", "Late", "F5");
            kindergarten.addValueRoster(year, weekNo, "Thursday", "Late", "F6");
            kindergarten.addValueRoster(year, weekNo, "Thursday", "PartTime", "D3§10:00§12:30");
            kindergarten.addValueRoster(year, weekNo, "Thursday", "PartTime", "D4§13:00§17:00");

            kindergarten.addValueRoster(year, weekNo, "Friday", "Early", "F5");
            kindergarten.addValueRoster(year, weekNo, "Friday", "Early", "F6");
            kindergarten.addValueRoster(year, weekNo, "Friday", "Late", "F5");
            kindergarten.addValueRoster(year, weekNo, "Friday", "Late", "F6");
            kindergarten.addValueRoster(year, weekNo, "Friday", "PartTime", "D1§10:00§12:30");
            kindergarten.addValueRoster(year, weekNo, "Friday", "PartTime", "D3§13:00§17:00");
        }

    }

}
