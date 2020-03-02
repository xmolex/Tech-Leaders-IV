public class PrintAtConsole {

    public void print(FightLog fightLog) {
        // выводим все записи в консоль
        for (int i = 0; i < fightLog.getLastEventIndex(); i++) {
            System.out.println(fightLog.getEvents(i));
        }

        // победители
        System.out.println("Winner is " + fightLog.getWinner().getName() );
        System.out.println("Looser is " + fightLog.getLooser().getName() );
    }

}
