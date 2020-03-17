package util;

import logic.Unit;

public class BattleMessagesUtil {

    private static final String DAMAGE_MESSAGE = "%s deal %s damage to %s";
    private static final String MISSED_MESSAGE = "%s missed";
    private static final String CONTRATTACK_MESSAGE = "%s tries to contrattack";
    private static final String DRAW_MESSAGE = "The battle is over with a draw";
    private static final String WIN_MESSAGE = "%s won!!!";
    private static final String INFO_MESSAGE = "Round %s, %s has %s HP remaining and %s has %s HP remaining";

    public static String buildInfoMessage(Unit unit1, Unit unit2, long roundNumber) {
        return String.format(INFO_MESSAGE, roundNumber, unit1.getName(), unit1.getCurrentHealth(), unit2.getCurrentHealth(), unit2.getName());
    }

    public static String buildDamageMessage(Unit attacker, Unit defender, long damage) {
        return String.format(DAMAGE_MESSAGE, attacker.getName(), damage, defender.getName());
    }

    public static String buildContrAttackMessage(Unit defender) {
        return String.format(CONTRATTACK_MESSAGE, defender.getName());
    }

    public static String buildWinMessage(Unit winner) {
        return String.format(WIN_MESSAGE, winner.getName());
    }

    public static String buildMissedMessage(Unit unit1) {
        return String.format(MISSED_MESSAGE, unit1.getName());
    }

    public static String buildDrawMessage() {
        return DRAW_MESSAGE;
    }

}
