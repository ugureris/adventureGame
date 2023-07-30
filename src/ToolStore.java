public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya hoşgeldin");
        boolean showMenu=true;
        while (showMenu){
            System.out.println("1- Silahlar");
            System.out.println("2- Zırhlar");
            System.out.println("3- Çıkış yap");
            int selectCase = Location.input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.print("Geçersiz değer, tekrar giriniz: ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Tekrar Bekleriz.");
                    showMenu=false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("Silahlar");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + " <Para: " + w.getPrice() + " , Hasar: " + w.getDamage() + ">");
        }
        System.out.println("0 - Geri Dön");
    }

    public void buyWeapon() {
        System.out.print("Bir Silah Seçiniz: ");
        int selectWeaponID = Location.input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.print("Geçersiz değer, tekrar giriniz: ");
            selectWeaponID = input.nextInt();
        }
        Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);
        if (selectWeaponID != 0) {
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır");
                } else {
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    System.out.println("Önceki Silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Yeni Silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }

    public void printArmor() {
        System.out.println("Zırhlar");
        System.out.println();
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() + " <Para: " + a.getPrice() + " , Engelleme: " + a.getBlock() + ">");
        }
        System.out.println("0 - Geri Dön");
    }

    public void buyArmor() {
        System.out.print("Bir Zırh Seçiniz: ");
        int selectArmorID = Location.input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.print("Geçersiz değer, tekrar giriniz: ");
            selectArmorID = input.nextInt();
        }

        Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);

        if (selectArmorID != 0) {
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır");
                } else {
                    System.out.println(selectedArmor.getName() + " zırhını satın aldınız");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Kalan paranız: " + balance);
                }
            }
        }
    }
}
