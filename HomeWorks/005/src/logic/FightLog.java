package logic;

public class FightLog {
    private static final int BATTLE_HISTORY_SIZE = 50;
    private int lastEventIndex = 0;
    private String[] events = new String[BATTLE_HISTORY_SIZE];
    private Unit winner;
    private Unit looser;

    public void setWinner(Unit winner) {
        this.winner = winner;
    }

    public void setLooser(Unit looser) {
        this.looser = looser;
    }

    public int getLastEventIndex() {
        return lastEventIndex;
    }

    public Unit getWinner() {
        return winner;
    }

    public Unit getLooser() {
        return looser;
    }


    public void add(String event) {
        if (lastEventIndex + 1 > events.length) {
            String[] temp = events;
            events = new String[temp.length + 20];
            for (int i = 0; i < temp.length; i++) {
                events[i] = temp[i];
            }

        }
        events[lastEventIndex] = event;


        lastEventIndex++;
    }

    public String getEvents(int index) {
        return events[index];
    }

}
