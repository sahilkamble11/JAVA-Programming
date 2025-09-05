import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryptDecrypt {

    private static final int SHIFT = 3; 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to encrypt or decrypt a file? (E/D):");
        String choice = scanner.nextLine().toUpperCase();

        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();

        System.out.println("Enter the output file path:");
        String outputFilePath = scanner.nextLine();

        if (choice.equals("E")) {
            processFile(filePath, outputFilePath, true);
        } else if (choice.equals("D")) {
            processFile(filePath, outputFilePath, false);
        } else {
            System.out.println("Invalid choice! Please enter 'E' for encryption or 'D' for decryption.");
        }

        scanner.close();
    }

    private static void processFile(String inputFilePath, String outputFilePath, boolean isEncrypt) {
        try {
            File inputFile = new File(inputFilePath);
            Scanner fileScanner = new Scanner(inputFile);
            FileWriter fileWriter = new FileWriter(outputFilePath);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String processedLine = isEncrypt ? encrypt(line) : decrypt(line);
                fileWriter.write(processedLine + "\n");
            }

            fileScanner.close();
            fileWriter.close();

            System.out.println("File processing completed. Output saved to " + outputFilePath);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error writing to output file: " + e.getMessage());
        }
    }

    private static String encrypt(String text) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                result.append((char) ((character - base + SHIFT) % 26 + base));
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }

    private static String decrypt(String text) {
        StringBuilder result = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                result.append((char) ((character - base - SHIFT + 26) % 26 + base));
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }
}
