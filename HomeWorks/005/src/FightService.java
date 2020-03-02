import java.util.Random;

public class FightService {

    public FightLog fight(Unit unitFirst, Unit unitSecond) {

        // инициализация лога
        FightLog fightLog = new FightLog();

        // используем ссылки для определения того, кто будет бить первым
        Unit unitFirstForIteration;
        Unit unitSecondForIteration;

        // запись в лог готовых юнитов
        fightLog.add(unitFirst.getName() + " ready, health: " + unitFirst.getHealth() + ", attack: " + unitFirst.getAttack());
        fightLog.add(unitSecond.getName() + " ready, health: " + unitFirst.getHealth() + ", attack: " + unitFirst.getAttack());

        // бьемся пока кто-то не умрет
        int ourAttack;
        while (unitFirst.isAlive() && unitSecond.isAlive()) {

            // определяем кто будет бить первым
            if (isStartFirst()) {
                unitFirstForIteration  = unitFirst;
                unitSecondForIteration = unitSecond;
            }
            else {
                unitFirstForIteration  = unitSecond;
                unitSecondForIteration = unitFirst;
            }

            // первый наносит удар
            ourAttack = getRandAttack(unitFirstForIteration.getAttack());
            unitSecondForIteration.HealthReduce(ourAttack);
            fightLog.add(unitFirstForIteration.getName() + " attack " + unitSecondForIteration.getName() + ", " + ourAttack + " damage");
            if (! unitSecondForIteration.isAlive()) {
                // второй умер, выходим
                fightLog.add(unitSecondForIteration.getName() + " died");
                fightLog.setWinner(unitFirstForIteration);
                fightLog.setLooser(unitSecondForIteration);
                return fightLog;
            }

            // второй наносит удар
            ourAttack = getRandAttack(unitSecondForIteration.getAttack());
            unitFirstForIteration.HealthReduce(ourAttack);
            fightLog.add(unitSecondForIteration.getName() + " attack " + unitFirstForIteration.getName() + ", " + ourAttack + " damage");
            if (! unitFirstForIteration.isAlive()) {
                // первый умер, выходим
                fightLog.add(unitFirstForIteration.getName() + " died");
                fightLog.setWinner(unitSecondForIteration);
                fightLog.setLooser(unitFirstForIteration);
                return fightLog;
            }
        }

        return fightLog;
    }

    // случайное количество очков атаки с учетом максимальной силы атаки
    private int getRandAttack(int attackMax) {
        Random random = new Random();
        return random.nextInt(attackMax);
    }

    // случайным образом выбираем, кто бьет первым
    private boolean isStartFirst() {
        Random random = new Random();
        return random.nextInt(100) < 50;
    }

}


