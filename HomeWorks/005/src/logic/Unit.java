package logic;

public class Unit {
    public static final int MIN_HP = 0;
    private String name;
    private int healthPoints;
    private int currentHealth;
    private int damagePoints;


    public Unit(String name, int healthPoints, int damagePoints) {
        this.name = name;
        setHealthPoints(healthPoints);
        setDamagePoints(damagePoints);
        this.currentHealth = healthPoints;
    }

    private void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    private void setDamagePoints(int damagePoints) {
        this.damagePoints = damagePoints;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getDamagePoints() {
        return damagePoints;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void decreaseCurrentHealth(int damage) {
        if (currentHealth < MIN_HP) {
            return;
        }
        this.currentHealth -= damage;
    }
}


