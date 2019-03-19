import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Roster {

    private List<String[]> roster;
    private String year;
    private static final Map<String,Integer> DAY_TO_INT = new HashMap<>();
    private static final Map<String,Integer> SHIFT_TO_INT = new HashMap<>();

    {
        DAY_TO_INT.put("Monday",0);
        DAY_TO_INT.put("Tuesday",1);
        DAY_TO_INT.put("Wednesday",2);
        DAY_TO_INT.put("Thursday",3);
        DAY_TO_INT.put("Friday",4);

        SHIFT_TO_INT.put("Early",0);
        SHIFT_TO_INT.put("Late",1);
        SHIFT_TO_INT.put("PartTime",2);
    }


    public Roster(String year) {

        roster = new ArrayList<>();
        this.year = year;

        //First row contains only the year;
        roster.add(new String[] {""+year});

        //Three rows for Early/Late shifts and and PartTimeEmployees
        //52 times - once for each week in a year
        for(int i = 0; i < (52*3); i++)
            roster.add(new String[5]);

    }

    public Roster(List<String[]> roster) {
        this.roster = roster;
    }

    public List<String[]> getWeekRoster(int weekNo) {
        List<String[]> rosterWeek = new ArrayList<>();

        int startingRow = 3*(weekNo-1)+1;

        rosterWeek.add(roster.get(startingRow));
        rosterWeek.add(roster.get(startingRow+1));
        rosterWeek.add(roster.get(startingRow+2));

        return rosterWeek;
    }

    public String getShift(int weekNo, String day, String shift) {
        int startingRow = 3*(weekNo-1)+1;
        int column = DAY_TO_INT.get(day);
        int row = SHIFT_TO_INT.get(shift);

        String shiftString = roster.get(startingRow+row)[column];
        return shiftString;//.split(",");
    }

    public void setShift(int weekNo, String day, String shift) {
        int startingRow = 3*(weekNo-1)+1;
        int column = DAY_TO_INT.get(day);
        int row = SHIFT_TO_INT.get(shift);

        String[] relevantRow = roster.get(startingRow+row);
        relevantRow[column] = shift;

        roster.set(startingRow+row,relevantRow);
    }


    public List<String[]> getRoster() { return roster; }
    public String getYear() { return year; }
}
