public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Account account = new Account("Emirhan","er2025EMCE",2000, 7800,"TR70 0004 6011 7788 8888 0203 35");// Bu bankaya ait olan hesap bilgilerini gönderdim.
        Account account2 = new Account("John", "johndoe123",3200,9200,"TR70 0004 6011 8899 8000 0203 35");
        AnotherAccount unaccount = new AnotherAccount("TR76 0004 6011 7788 8000 0203 35","Omer","Armagan",2000); // Farklı bir bankaya ait olan hesap bilgilerini gönderdim.



        atm.start(account,unaccount,account2);
        System.out.println("İşlemler sonlandırılıyor...");
        System.out.println("Çıkış yapıldı.");

    }
}