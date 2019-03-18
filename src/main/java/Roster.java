import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Roster {

    private List<String[]> roster;
    private int startWeek, endWeek;
    private CSV_Handler csv_Handler;

    public Roster(int week) {
        this(week, week);
    }

    public Roster(int startWeek, int endWeek) {
        csv_Handler = new CSV_Handler();
        roster = new ArrayList<String[]>();
        for(int i = 0; i < 5; i++)
            roster.add(new String[5]);
        this.startWeek = startWeek;
        this.endWeek = endWeek;
    }


    public void toCSV() throws IOException {

        Path path;
        for(int weekNo = startWeek; weekNo <= endWeek; weekNo++) {
            path = Paths.get("src/main/resources/RosterWeek" + weekNo + ".csv");
            csv_Handler.writeCSV(roster, path);
        }

    }
}
