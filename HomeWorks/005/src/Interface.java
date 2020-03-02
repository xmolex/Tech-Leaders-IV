import com.sun.javaws.IconUtil;

import java.util.Random;
import java.util.Scanner;

public class Interface {

    private static final int MAX_HEALTH_RAND = 100;
    private static final int MAX_ATTACK_RAND = 50;
    private static final String[] ARRAY_NAMES_RAND = {"Mark","John","Tony","Andrew","Devid"};

    public void print(FightLog fightLog) {
        // выводим все записи в консоль
        for (int i = 0; i < fightLog.getLastEventIndex(); i++) {
            System.out.println(fightLog.getEvents(i));
        }

        // победители
        System.out.println("Winner is " + fightLog.getWinner().getName() );
        System.out.println("Looser is " + fightLog.getLooser().getName() );
    }

    public void startInterface() {
        System.out.println("Введите число:");
        System.out.println("    1 - создать случайный поединок");
        System.out.println("    2 - создать поединок с заданными параметрами");
        System.out.println("    0 - выход");
        Scanner scanner = new Scanner(System.in);

        int userChoice = -1;
        while (userChoice != 0) {
            userChoice = scanner.nextInt();
            if (userChoice == 1) {
                // случайный поединок
                // создаем двух юнитов
                Random random = new Random();
                Unit player1 = new Unit( ARRAY_NAMES_RAND[random.nextInt(ARRAY_NAMES_RAND.length)],
                        random.nextInt(MAX_HEALTH_RAND),
                        random.nextInt(MAX_ATTACK_RAND)
                );
                Unit player2 = new Unit( ARRAY_NAMES_RAND[random.nextInt(ARRAY_NAMES_RAND.length)],
                        random.nextInt(MAX_HEALTH_RAND),
                        random.nextInt(MAX_ATTACK_RAND)
                );

                // проводим битву
                FightService fightService = new FightService();
                FightLog log = fightService.fight(player1, player2);

                // выводим лог в консоль
                Interface printObj = new Interface();
                printObj.print(log);

                // выходим
                userChoice = 0;

            }
            else if (userChoice == 2) {
                // поединок с заданными параметрами
                String unitName;
                int unitHealth;
                int unitAttack;

                // первый боец
                System.out.println("Введите имя игрока1, строку:");
                unitName = scanner.nextLine();
                System.out.println("Введите здоровье игрока1, число:");
                unitHealth = scanner.nextInt();
                System.out.println("Введите силу атаки игрока1, число:");
                unitAttack = scanner.nextInt();
                Unit player1 = new Unit( unitName, unitHealth, unitAttack );

                // второй боец
                System.out.println("Введите имя игрока2, строку:");
                unitName = scanner.nextLine();
                System.out.println("Введите здоровье игрока2, число:");
                unitHealth = scanner.nextInt();
                System.out.println("Введите силу атаки игрока2, число:");
                unitAttack = scanner.nextInt();
                Unit player2 = new Unit( unitName, unitHealth, unitAttack );

                // проводим битву
                FightService fightService = new FightService();
                FightLog log = fightService.fight(player1, player2);

                // выводим лог в консоль
                Interface printObj = new Interface();
                printObj.print(log);

                // выходим
                userChoice = 0;

            }
            else {
                // неверный параметр
                System.out.println("Вы ввели неверный параметр, используйте 0-2");
            }
        }
        System.out.println("Завершение работы");
    }
}
