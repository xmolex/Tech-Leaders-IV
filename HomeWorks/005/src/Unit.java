public class Unit {

    private final int HEALTH_DEFAULT = 1;
    private final int ATTACK_DEFAULT = 1;
    private final String NAME_DEFAULT = "Player";

    private int health;
    private int attack;
    private String name;

    public Unit(String name, int health, int attack) {
        if (name.isEmpty()) {
            name = NAME_DEFAULT;
        }

        if (health == 0) {
            health = HEALTH_DEFAULT;
        }

        if (attack == 0) {
            attack = ATTACK_DEFAULT;
        }

        this.name   = name;
        this.health = health;
        this.attack = attack;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    public void HealthReduce(int health) {
        this.health -= health;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getAttack() {
        return this.attack;
    }

}
