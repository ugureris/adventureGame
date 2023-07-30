public class Obstacle {
    private int id;
    private String name;
    private int damage;
    private int healt;
    private int award;
    private int defaultHealth;



    public Obstacle(int id, String name, int damage, int healt, int award) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.healt = healt;
        this.defaultHealth = healt;
        this.award = award;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealt() {
        return healt;
    }

    public void setHealt(int healt) {
        if (healt < 0) {
            healt = 0;
        }
        this.healt = healt;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

}
