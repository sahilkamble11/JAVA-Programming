import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter unit (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().toUpperCase().charAt(0);

        if (unit == 'C') {
            double fahrenheit = (temperature * 9/5) + 32;
            System.out.println(temperature + "°C is " + fahrenheit + "°F");
        } else if (unit == 'F') {
            double celsius = (temperature - 32) * 5/9;
            System.out.println(temperature + "°F is " + celsius + "°C");
        } else {
            System.out.println("Invalid unit");
        }

        scanner.close();
    }
}
