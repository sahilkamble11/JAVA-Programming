import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a password to check its strength:");
        String password = scanner.nextLine();
        
        int strength = checkPasswordStrength(password);
        
        System.out.println("Password strength: " + strength + "/5");
        if (strength < 3) {
            System.out.println("Weak password. Try including uppercase letters, lowercase letters, numbers, and special characters.");
        } else if (strength == 3 || strength == 4) {
            System.out.println("Moderate password. Consider making it stronger.");
        } else {
            System.out.println("Strong password!");
        }
        
        scanner.close();
    }
    
    public static int checkPasswordStrength(String password) {
        int strength = 0;
        
        if (password.length() >= 8) {
            strength++;
        }
        if (password.matches(".*[A-Z].*")) {
            strength++;
        }
        if (password.matches(".*[a-z].*")) {
            strength++;
        }
        if (password.matches(".*[0-9].*")) {
            strength++;
        }
        if (password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            strength++;
        }
        
        return strength;
    }
}
