import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = randomObstacleNumber();
        System.out.println("Şu an buradasınız: " + this.getName());
        System.out.println("Dikkatli ol burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor!");
        System.out.println("<S>avaş veya <K>aç");
        String selectBattle = input.next();
        selectBattle = selectBattle.toUpperCase();
        if (selectBattle.equals("S")) {
            if (combat(obsNumber)) {
                System.out.println(this.getName() + " tüm düşmanları yendiniz");
                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldün");
            return false;
        }

        return true;
    }

    public boolean combat(int obsNumber) {
        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealt(this.getObstacle().getDefaultHealth());
            playerStats();
            obstacleStats(i);
            Random rnd=new Random();
            boolean who=rnd.nextBoolean();
            System.out.println(who);
            if (who){
                while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealt() > 0) {
                    System.out.println("<V>ur veya <K>aç");
                    String selectCombat = input.next().toUpperCase();
                    if (selectCombat.equals("V")) {
                        System.out.println("Vurdun!");
                        getObstacle().setHealt(this.getObstacle().getHealt() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if (this.getObstacle().getHealt() > 0) {
                            System.out.println("Canavar size vurdu!");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    } else {
                        return false;
                    }
                }
            } else {
                while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealt() > 0) {
                    if (this.getObstacle().getHealt() > 0) {
                        System.out.println("Canavar size vurdu!");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                        System.out.println("<V>ur veya <K>aç");
                        String selectCombat = input.next().toUpperCase();
                        if (selectCombat.equals("V")) {
                            System.out.println("Vurdun!");
                            getObstacle().setHealt(this.getObstacle().getHealt() - this.getPlayer().getTotalDamage());
                            afterHit();}
                    }
                }
            }

            if (this.getObstacle().getHealt() < this.getPlayer().getHealth()) {
                System.out.println("Düşmanı yendin, " + this.getObstacle().getAward() + " para kazandın!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel paran: " + this.getPlayer().getMoney());
            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " canı: " + this.getObstacle().getHealt());
        System.out.println();
    }



    public void playerStats() {
        System.out.println("Oyuncu Değerleri");
        System.out.println();
        System.out.println("Sağlık: " + this.getPlayer().getHealth() +
                "\tSilah: " + this.getPlayer().getInventory().getWeapon().getName() +
                "\tZırh: " + this.getPlayer().getInventory().getArmor().getName() +
                "\tEngelleme: " + this.getPlayer().getInventory().getArmor().getBlock() +
                "\tHasar: " + this.getPlayer().getTotalDamage() +
                "\tPara: " + this.getPlayer().getMoney() + "\n");
    }

    public void obstacleStats(int i) {
        System.out.println(i + "." + this.getObstacle().getName() + " Değerleri");
        System.out.println();
        System.out.println("Sağlık: " + this.getObstacle().getHealt() +
                "\tHasar: " + this.getObstacle().getDamage() +
                "\tPara: " + this.getObstacle().getAward() + "\n");
    }

    public int randomObstacleNumber() {
        Random rnd = new Random();
        return rnd.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
