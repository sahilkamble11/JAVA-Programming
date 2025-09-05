import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        // Prompt the user for character types to include
        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");
        
        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("yes");

        // Build the character set based on user choices
        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        StringBuilder characterSet = new StringBuilder();
        if (includeNumbers) characterSet.append(numbers);
        if (includeLowercase) characterSet.append(lowercase);
        if (includeUppercase) characterSet.append(uppercase);
        if (includeSpecial) characterSet.append(special);

        if (characterSet.length() == 0) {
            System.out.println("No character types selected. Please include at least one type of character.");
            return;
        }
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }
        System.out.println("Generated password: " + password.toString());

        scanner.close();
    }
}
