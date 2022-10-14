import java.util.Scanner;

public class AccountManagerImp implements IAccountManager, IAnotherAccountManager {

    @Override
    public void depositMoney(Account account) {
        double blnc;
        String answer;


        Scanner deposit = new Scanner(System.in);
        System.out.println("Yatırılacak tutarı girin: ");
        System.out.println("Yatırma işlemini iptal etmek için q'ya basın: ");
        answer = deposit.nextLine();
        if(answer.equals("q")) {
        deposit.nextLine();
        if (amount <= 0) {
            System.out.print("İşleminiz gerçekleştirilemiyor!");
        } else {
            blnc = account.getBalance();
            blnc += amount;
            account.setBalance(blnc);
            System.out.println("İşleminiz başarıyla gerçekleştirildi!");
            System.out.println("Güncel bakiyeniz: " + account.getBalance());
        }

    }

    @Override
    public void withdrawMoney(Account account) {
        double blnc;
        double amount;

        Scanner withdraw = new Scanner(System.in);
        System.out.println("Çekmek istediğiniz tutarı girin: ");
        amount = withdraw.nextDouble();
        withdraw.nextLine();
        if (account.getBalance() - amount < 0) {
            System.out.println("İşleminiz gerçekleştirilemiyor!");
            System.out.println("Yeterli bakiyeniz bulunmamaktadır.");
        } else {
            blnc = account.getBalance();
            blnc -= amount;
            account.setBalance(blnc);
            System.out.println("İşleminiz başarıyla gerçekleştirilmiştir.");
            System.out.println("Güncel bakiyeniz: " + account.getBalance());
        }
    }
    @Override
    public void transferMoney(AnotherAccount unaccount, Account account, Account account2) {
        Scanner iban = new Scanner(System.in);
        Scanner name = new Scanner(System.in);
        Scanner lstname = new Scanner(System.in);
        Scanner transfer = new Scanner(System.in);
        Scanner control = new Scanner(System.in);
        String nm, lstnm, ibano, answer;
        double mainBalance, balance, amount;


        System.out.println("Transfer İşlemi (HAVALE/EFT)");
        System.out.println("IBAN: ");
        ibano = iban.nextLine();
        System.out.println("Hesap sahibinin adı: ");
        nm = name.nextLine();
        System.out.println("Hesap sahibinin soyadı: ");
        lstnm = lstname.nextLine();

        String pattern = "[TR70]0004";
        if (account2.getIBAN().matches(pattern) && account.getIBAN().matches(pattern)) {
            if (ibano.equals(account2.getIBAN()) && nm.equals(account2.getUsername())) {
                System.out.println("Hesap doğrulandı");
                while (true) {
                    System.out.println("Gönderilecek tutarı girin: ");
                    amount = transfer.nextDouble();
                    if (amount <= 10) {
                        System.out.println("Transfer işlemi gerçekleştirilemiyor.");
                    } else if (amount >= 2000) {
                        System.out.println("Bir günde 2000TL den fazla para transferi yapılamaz.");
                    } else {
                        System.out.println("Transfer işlemi gerçkeleştiriliyor...");
                        balance = account.getBalance();
                        mainBalance = account.getBalance();
                        if (mainBalance <= amount) {
                            System.out.println("Bakiye yetersiz!");
                        } else {
                            mainBalance -= amount;
                            account.setBalance(mainBalance);
                            System.out.println("Emirhan hesap: " + account.getBalance());
                            balance += amount;
                            account2.setBalance(balance);
                            System.out.println("Kontrol amaçlıdır johnDoe hesap: " + account2.getBalance());
                            break;
                        }
                    }
                }
            } else if (ibano.equals(unaccount.getIBAN()) && nm.equals(unaccount.getFirstname()) && lstnm.equals(unaccount.getLastname())) {
                System.out.println("Hesap doğrulandı!");
                while (true) {
                    System.out.println("Gönderilecek tutarı giriniz: ");
                    amount = transfer.nextDouble();
                    if (amount <= 10) {
                        System.out.println("Transfer işlemi gerçekleştirilemiyor.");
                    } else if (amount >= 2000) {
                        System.out.println("Bir günde 2000TL den fazla para transferi yapılamaz.");
                    } else {
                        System.out.println("Transfer işlemi gerçkeleştiriliyor...");
                        balance = unaccount.getBalance();
                        System.out.println("Transfer işlemi gerçekleştirme ücreti 2TL dir. Onaylıyor musunuz(Evet/Hayır): ");
                        answer = control.nextLine();
                        if (answer.equals("Evet")) {

                            System.out.println("Kontrol amaçlıdır diğer bankadaki transfer öncesi bakiye: " + balance);
                            mainBalance = account.getBalance();
                            if (mainBalance <= amount) {
                                System.out.println("Bakiye yetersiz!");
                            } else {
                                mainBalance -= 2;
                                mainBalance -= amount;
                                account.setBalance(mainBalance);
                                System.out.println("Emirhan hesap: " + account.getBalance());
                                balance += amount;
                                unaccount.setBalance(balance);
                                System.out.println("Kontrol amaçlıdır Diğer bankadaki trasnfer sonrası bakiye: " + unaccount.getBalance());
                                break;
                            }


                        } else {
                            System.out.println("Transfer İşlemi iptal edildi.");
                        }

                    }
                }
            } else {
                System.out.println("Girilen bilgiler hatalı lütfen tekrar deneyin!");
            }
        }
    }
}



