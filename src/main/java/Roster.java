import java.util.ArrayList;
import java.util.List;

public class Roster {

    private List<String[]> roster;
    private int startWeek, endWeek;
    private CSV_Handler csv_Handler;

    public Roster(int week) {
        this(week, week);
    }

    public Roster(int startWeek, int endWeek) { //TODO Husk ugenr øverst.
        csv_Handler = new CSV_Handler();
        roster = new ArrayList<String[]>();
        for(int i = 0; i < 5; i++)
            roster.add(new String[5]);
        this.startWeek = startWeek;
        this.endWeek = endWeek;
    }

    public Roster(List<String[]> roster) {
        this.roster = roster;
        this.startWeek = Integer.parseInt(roster.get(0)[0]);
    }

    public List<String[]> getRoster() {
        return roster;
    }
}
