public class FightLog {

    private static final int ARR_SIZE = 50;
    private int lastEventIndex = 0;
    private String[] events = new String[ARR_SIZE];
    private Unit winner;
    private Unit looser;

    public int getLastEventIndex() {
        return lastEventIndex;
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
        events[lastEventIndex] = event;
        if ( lastEventIndex + 1 > events.length ) {
            String[] temp = events;
            this.events = new String[temp.length + 10];
            for (int i = 0; i < temp.length; i++) {
                events[i] = temp[i];
            }
        }
        lastEventIndex++;
    }

    public String getEvents(int index) {
        return events[index];
    }

}
