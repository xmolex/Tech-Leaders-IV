import java.util.ArrayList;

public class FightLog {

    private int lastEventIndex = 0;
    private ArrayList events = new ArrayList();
    private Unit winner;
    private Unit looser;

    public int getLastEventIndex() {
        return events.size();
    }

    public Unit getWinner() {
        return winner;
    }

    public Unit getLooser() {
        return looser;
    }

    public void setWinner(Unit winner) {
        this.winner = winner;
    }

    public void setLooser(Unit looser) {
        this.looser = looser;
    }

    public void add(String event) {
        events.add(event);
    }

    public String getEvents(int index) {
        return (String) events.get(index);
    }

}
