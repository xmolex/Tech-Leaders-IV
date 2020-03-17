package logic;

public class FightStep {
    private Unit attacker;
    private Unit defender;
    private long roundNumber;
    private boolean fightIsFinished;

    public FightStep(Unit attacker, Unit defender, long number) {
        this.attacker = attacker;
        this.defender = defender;
        this.roundNumber = number;
        fightIsFinished = false;
    }

    public void increaseRoundNumber() {
        roundNumber++;
    }

    public void swapUnits() {
        Unit temp = attacker;
        attacker = defender;
        defender = temp;
    }

    public long getRoundNumber() {
        return roundNumber;
    }

    public Unit getAttacker() {
        return attacker;
    }

    public Unit getDefender() {
        return defender;
    }

    public boolean bothUnitsAlive() {
        return attacker.getCurrentHealth() > Unit.MIN_HP && defender.getCurrentHealth() > Unit.MIN_HP;
    }

    public boolean bothUnitsDead() {
        return attacker.getCurrentHealth() < Unit.MIN_HP && defender.getCurrentHealth() < Unit.MIN_HP;
    }

    public void finishFight() {
        fightIsFinished = true;
    }

    public Unit getWinner() {
        if (fightIsFinished && !bothUnitsDead()) {
            return attacker.getCurrentHealth() > Unit.MIN_HP ? attacker : defender;
        }
        return null;
    }

    public Unit getLooser() {
        if (fightIsFinished && !bothUnitsDead()) {
            return attacker.getCurrentHealth() > Unit.MIN_HP ? defender : attacker;
        }
        return null;
    }
}
