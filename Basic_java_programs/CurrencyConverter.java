import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverter {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Prompt user for input
            System.out.print("Enter the amount in base currency: ");
            double amount = Double.parseDouble(reader.readLine());

            System.out.print("Enter the base currency code (e.g., USD): ");
            String baseCurrency = reader.readLine().toUpperCase();

            System.out.print("Enter the target currency code (e.g., EUR): ");
            String targetCurrency = reader.readLine().toUpperCase();

            // Retrieve exchange rate from API
            double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);

            // Convert currency
            double convertedAmount = amount * exchangeRate;

            // Display result
            System.out.println(amount + " " + baseCurrency + " is equal to " + convertedAmount + " " + targetCurrency);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) throws IOException {
        String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + baseCurrency;
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String response = reader.readLine();
            reader.close();

            JSONObject json = new JSONObject(response);
            JSONObject rates = json.getJSONObject("rates");
            return rates.getDouble(targetCurrency);
        } else {
            throw new IOException("Failed to retrieve exchange rate. HTTP error code: " + responseCode);
        }
    }
}
