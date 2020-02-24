public class FightLog {

    private String[] history = new String[50000];
    private int posInArrayForInsert;
    private int posInArrayForPrint;

    public void insertRecord(String txt) {
        this.history[posInArrayForInsert] = txt;
        this.posInArrayForInsert++;
    }

    public void cleanPosRecord() {
        this.posInArrayForPrint = 0;
    }

    public String getNextRecord() {
        this.posInArrayForPrint++;
        return this.history[this.posInArrayForPrint-1];
    }

    public int logLength() {
        return this.posInArrayForInsert;
    }

}
