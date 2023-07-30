import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera Oyununa Hoşgeldin");

        System.out.print("Lütfen Bir İsim Giriniz: ");
        // String playerName=input.next();
        Player player = new Player("ugur");
        System.out.println(player.getName() + " bu karanlık ve sisli adaya hoşgeldin..");
        System.out.println("Burada yaşananların hepsi gerçek\n");
        System.out.println("-------------");
        System.out.println("Karakterler");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println("----------------");
            System.out.println();
            System.out.println("Bölgeler");
            System.out.println();
            System.out.println("1- Güvenli Ev --> Burası sizin için güvenli, burada düşman yok");
            System.out.println("2- Eşya Dükkanı --> Silah veya Zırh satın alabilirsiniz");
            System.out.println("3- Mağara --> Ödül <Yemek>, dikkatli ol canavar çıkabilir");
            System.out.println("4- Orman --> Ödül <Odun>, dikkatli ol canavar çıkabilir");
            System.out.println("5- Nehir --> Ödül <Su>, dikkatli ol canavar çıkabilir");
            System.out.println("6- Maden --> Ödül <Para, Silah, Zırh, diikatli ol canavar çıkabilir");
            System.out.println("0- Oyunu Sonlandır");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçin: ");
            int selectLoc = input.nextInt();
            if (selectLoc==6){

            }
            System.out.println();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location=new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location=new Quarry(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir değer gir");
                    break;
            }
            if (location==null){
                System.out.println("Oyun Bitti");
                break;
            }
            if (!location.onLocation()){
                System.out.println("Game Over!");
                break;
            }
        }


    }
}
