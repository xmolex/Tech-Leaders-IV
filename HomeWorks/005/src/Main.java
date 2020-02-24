public class Main {

    public static void main(String[] args) {

        // создаем двух юнитов
        Unit Player1 = new Unit("Mark", 80, 9);
        Unit Player2 = new Unit("Denis", 80, 8);

        // проводим битву
        FightService fightService = new FightService();
        FightLog log = fightService.fight(Player1, Player2);

        // выводим лог в консоль
        PrintToConsole printObj = new PrintToConsole();
        printObj.print(log);

    }
}
