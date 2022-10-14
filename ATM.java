import java.util.Scanner;

public class ATM {
    AccountManagerImp accountManagerImp = new AccountManagerImp();

    public void start(Account account, AnotherAccount unaccount, Account account2) {
        Login giris = new Login();
        Scanner scanner = new Scanner(System.in);

        System.out.println("ATM ye hoşgeldiniz!");

        System.out.println("Hesap Sahibi giriş sayfası");

        int login_try = 3;

        while (true) {
            if (giris.login(account) || giris.login(account2)) {
                System.out.println("Giriş başarılı Yönlendiriliyorsunuz...");
                break;
            } else {
                System.out.println("Giriş başarısız!");
                login_try -= 1;
                System.out.println("kalan giriş hakkınız: " + login_try);
            }
            if (login_try == 0) {
                System.out.println("Giriş hakkınız dolmuştur lütfen daha sonra tekrar deneyin!");
                return;
            }
        }

        System.out.println("**************************");
        String islemler = """
                1. Bakiye Görüntüle
                2. Para yatırma işlemleri
                3. Para çekme işlemleri
                4. Havale/EFT Transfer işlemleri
                Çıkış için q'ya basın.
                """;
        System.out.println(islemler);
        System.out.println("**************************");
        while (true) {
            System.out.println("Yapmak istediğiniz işlemi seçin: ");
            String islem = scanner.nextLine();

            if (islem.equals("q")) {
                break;
            } else if (islem.equals("1")) {
                System.out.println("Güncel bakiyeniz: " + account.getBalance());
            } else if (islem.equals("2")) {
                accountManagerImp.depositMoney(account);
            } else if (islem.equals("3")) {
                accountManagerImp.withdrawMoney(account);
            } else if (islem.equals("4")) {
                accountManagerImp.transferMoney(unaccount,account,account2);
            } else {
                System.out.println("Geçersiz işlem girdiniz Lütfen tekrar deneyin.");
            }
        }
    }
}

