import java.util.Random;

public class FightService {

    public FightLog fight(Unit unitFirst, Unit unitSecond) {

        // инициализация лога
        FightLog log = new FightLog();

        // используем ссылки для определения того, кто будет бить первым
        Unit unitFirstForIteration;
        Unit unitSecondForIteration;

        // запись в лог готовых юнитов
        log.insertRecord(unitFirst.getName() + " ready, health: " + unitFirst.getHealth() + ", attack: " + unitFirst.getAttack());
        log.insertRecord(unitSecond.getName() + " ready, health: " + unitFirst.getHealth() + ", attack: " + unitFirst.getAttack());

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
            log.insertRecord(unitFirstForIteration.getName() + " attack " + unitSecondForIteration.getName() + ", " + ourAttack + " damage");
            if (! unitSecondForIteration.isAlive()) {
                // второй умер, выходим
                log.insertRecord(unitSecondForIteration.getName() + " died");
                return log;
            }

            // второй наносит удар
            ourAttack = getRandAttack(unitSecondForIteration.getAttack());
            unitFirstForIteration.HealthReduce(ourAttack);
            log.insertRecord(unitSecondForIteration.getName() + " attack " + unitFirstForIteration.getName() + ", " + ourAttack + " damage");
            if (! unitFirstForIteration.isAlive()) {
                // первый умер, выходим
                log.insertRecord(unitFirstForIteration.getName() + " died");
                return log;
            }
        }

        return log;
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


