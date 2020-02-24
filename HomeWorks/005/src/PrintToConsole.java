public class PrintToConsole {

    public void print(FightLog log) {
        // переходим в начало лога
        log.cleanPosRecord();

        // выводим все записи в консоль
        for (int i = 0; i < log.logLength(); i++) {
            System.out.println(log.getNextRecord());
        }
    }

}
