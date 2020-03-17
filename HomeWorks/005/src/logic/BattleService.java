package logic;

import util.BattleMessagesUtil;

import java.util.Random;

public class BattleService {

    public static final int ROLL_100_PERCENT = 100;
    public static final int ATTACK_CHANCE = 50;
    public static final int FULL_DAMAGE_CHANCE = 66;
    public static final int HALF_DAMAGE_CHANCE = 33;
    public static final int FIRST_ROUND_NUMBER = 1;
    public static final int HALF_DAMAGE_MODIFIER = 2;
    public static final int QUOTER_DAMAGE_MODIFIER = 4;
    public static final int MIN_ROLL_VALUE = 1;
    private Random randomNumberGenerator = new Random();

    public FightLog fight(Unit unit1, Unit unit2) {
        FightLog fightLog = new FightLog();
        FightStep fightStep = new FightStep(unit1, unit2, FIRST_ROUND_NUMBER);
        while (fightStep.bothUnitsAlive()) {
            fightLog.add(BattleMessagesUtil.buildInfoMessage(unit1, unit2, fightStep.getRoundNumber()));
            performAttack(fightStep.getAttacker(), fightStep.getDefender(), fightLog);
            fightLog.add(BattleMessagesUtil.buildContrAttackMessage(fightStep.getDefender()));
            performAttack(fightStep.getDefender(), fightStep.getAttacker(), fightLog);
            fightStep.swapUnits();
            fightStep.increaseRoundNumber();
        }
        fightStep.finishFight();
        addFightResultToLog(fightStep, fightLog);
        return fightLog;
    }

    private void performAttack(Unit attacker, Unit defender, FightLog fightLog) {
        if (successfulRoll(ATTACK_CHANCE, roll(ROLL_100_PERCENT))) {
            int damageRollResult = roll(ROLL_100_PERCENT);
            int damage = calculateDamage(attacker.getDamagePoints(), damageRollResult);
            doDamage(defender, damage);
            fightLog.add(BattleMessagesUtil.buildDamageMessage(attacker, defender, damage));
            return;
        }
        fightLog.add(BattleMessagesUtil.buildMissedMessage(attacker));
    }

    private int calculateDamage(int unitDamagePoints, int damageRollResult) {
        if (successfulRoll(damageRollResult, FULL_DAMAGE_CHANCE)) {
            return unitDamagePoints;
        }
        if (successfulRoll(damageRollResult, HALF_DAMAGE_CHANCE)) {
            return unitDamagePoints / HALF_DAMAGE_MODIFIER;
        }
        return unitDamagePoints / QUOTER_DAMAGE_MODIFIER;
    }

    private void addFightResultToLog(FightStep fightRoundInfo, FightLog fightLog) {
        if (fightRoundInfo.bothUnitsDead()) {
            fightLog.add(BattleMessagesUtil.buildDrawMessage());
            return;
        }
        fightLog.add(BattleMessagesUtil.buildWinMessage(fightRoundInfo.getWinner()));
        fightLog.setWinner(fightRoundInfo.getWinner());
        fightLog.setLooser(fightRoundInfo.getLooser());
    }

    private int roll(int maxVal) {
        return randomNumberGenerator.nextInt(maxVal) + MIN_ROLL_VALUE;
    }

    private boolean successfulRoll(int rollResult, int minimum) {
        return rollResult >= minimum;
    }

    private void doDamage(Unit defender, int damage) {
        defender.decreaseCurrentHealth(damage);
    }
}
