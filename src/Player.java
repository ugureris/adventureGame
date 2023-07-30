import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int defaultHealt;
    private int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        for (GameChar gameChar : charList) {
            System.out.println("ID: " + gameChar.getId() +
                    "\tKarakter: " + gameChar.getName() +
                    "\t\t Hasar: " + gameChar.getDamage() + "" +
                    "\t\t Sağlık: " + gameChar.getHealth() +
                    "\t\t Para: " + gameChar.getMoney());
        }
        System.out.println("---------------");
        System.out.print("Bir Karakter Seçin: ");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }

    }

    public void printInfo() {
        System.out.println("Silahınız: " + this.getInventory().getWeapon().getName() +
                "\t Zırhınız: " + this.getInventory().getArmor().getName() +
                "\t Engelleme: " + this.getInventory().getArmor().getBlock() +
                "\t Hasarınız: " + this.getTotalDamage() +
                "\t Sağlık: " + this.getHealth() +
                "\t Para: " + this.getMoney());
    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setDefaultHealt(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefaultHealt() {
        return defaultHealt;
    }

    public void setDefaultHealt(int defaultHealt) {
        this.defaultHealt = defaultHealt;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
