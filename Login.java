import java.util.Scanner;

public class Login {


    public boolean login(Account account) {
        Scanner controlLogin = new Scanner(System.in);
        Scanner changePassword = new Scanner(System.in);
        Scanner answers = new Scanner(System.in);
        while (true) {
            String loginUsername;
            String loginPassword;
            String newPassword;
            String answer;

            System.out.println("Hesap adınız: ");
            loginUsername = controlLogin.nextLine();

            System.out.println("Hesap Şifreniz: ");
            loginPassword = controlLogin.nextLine();

            if (account.getUsername().equals(loginUsername) && account.getPassword().equals(loginPassword)) {
                return true; // Değer true olarak gönderildi ve arayüze giriş yapıldı
            } else if (account.getUsername().equals(loginUsername) && !account.getPassword().equals(loginPassword)) {
                System.out.println("Şifreniz hatalı şifrenizi değiştirmek ister misiniz? (Evet/Hayır): ");
                answer = answers.nextLine();
                if (answer.equals("Evet")) {
                    while(true) {
                        System.out.println("Yeni şifrenizi girin: ");
                        newPassword = changePassword.nextLine();
                        if(newPassword.length() < 8 || newPassword.length() > 20) {
                            System.out.println("Şifreniz 8 karakterden büyük 20 karakterden küçük veya eşit olmalı");
                        } else {
                            account.setPassword(newPassword);
                            System.out.println("Şifreniz başarıyla değiştirildi!");
                            break;
                        }
                    }continue;
                } else if(answer.equals("Hayır")) {
                    System.out.println("Yönlendiriliyorsunuz...");
                    continue;
                }

            } else {
                return false;
            }

            return false;
        }
    }
}



