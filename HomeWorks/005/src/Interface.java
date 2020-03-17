import logic.BattleService;
import logic.FightLog;
import logic.Unit;

import java.util.Random;
import java.util.Scanner;

public class Interface {

    private static final int COMMAND_NUMBER_EXIT = 0;
    private static final int COMMAND_NUMBER_MANUAL = 1;
    private static final int COMMAND_NUMBER_RANDOM = 2;

    public void print(FightLog fightLog) {
        for (int i = 0; i < fightLog.getLastEventIndex(); i++)
            System.out.println(fightLog.getEvents(i));

        System.out.println("The winner is " + fightLog.getWinner().getName());
        System.out.println("The looser is " + fightLog.getLooser().getName());

    }

    public void scan() {
        int userChoice = -1;
        String enterName;
        int enterHealthPoints;
        int enterDamagePoints;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inter '" + COMMAND_NUMBER_EXIT + "', to exit the program,\n" +
                "Inter '" + COMMAND_NUMBER_MANUAL + "', to create units,\n" +
                "Inter '" + COMMAND_NUMBER_RANDOM + "' to create units with random characters.\n");

        userChoice = scanner.nextInt();


        while (userChoice != COMMAND_NUMBER_EXIT) {
            if (userChoice == COMMAND_NUMBER_MANUAL) {
                System.out.println("Enter the name of the first warrior : ");
                enterName = scanner.next();
                System.out.println("Enter the health points of the first warrior : ");
                enterHealthPoints = scanner.nextInt();
                System.out.println("Enter the damage points of the first warrior : ");
                enterDamagePoints = scanner.nextInt();
                Unit unit1 = new Unit(enterName, enterHealthPoints, enterDamagePoints);
                System.out.println("Enter the name of the second warrior: ");
                enterName = scanner.next();
                System.out.println("Enter the health points of the second warrior: ");
                enterHealthPoints = scanner.nextInt();
                System.out.println("Enter the damage points of the second warrior : ");
                enterDamagePoints = scanner.nextInt();
                Unit unit2 = new Unit(enterName, enterHealthPoints, enterDamagePoints);

                equalsMain(unit1, unit2);
            }

            if (userChoice == COMMAND_NUMBER_RANDOM) {
                Random random = new Random();
                enterHealthPoints = random.nextInt(200) + 10;
                enterDamagePoints = random.nextInt(100) + 10;
                Unit unit1 = new Unit("Unit1", enterHealthPoints, enterDamagePoints);
                enterHealthPoints = random.nextInt(200) + 10;
                enterDamagePoints = random.nextInt(100) + 10;
                Unit unit2 = new Unit("Unit2", enterHealthPoints, enterDamagePoints);

                equalsMain(unit1, unit2);

            }

            if (userChoice > COMMAND_NUMBER_RANDOM)
                System.out.println("You enter a wrong number. Try again");

            System.out.println("Inter '" + COMMAND_NUMBER_EXIT + "', to exit the program,\n" +
                    "Inter '" + COMMAND_NUMBER_MANUAL + "', to create units,\n" +
                    "Inter '" + COMMAND_NUMBER_RANDOM + "' to create units with random characters.\n"
            );
            userChoice = scanner.nextInt();

        }

        System.out.println("GoodBye");
        scanner.close();
    }

    private void equalsMain(Unit unit1, Unit unit2) {
        BattleService battleService = new BattleService();
        FightLog fightLog = battleService.fight(unit1, unit2);
        print(fightLog);
    }


}
