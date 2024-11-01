package currency;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String BYN = "BYN";
    private static final String USD = "USD";
    private static final String EUR = "EUR";
    private static final String JPY = "JPY";
    private static final String CNY = "CNY";
    private static final double BYN_TO_USD = 3.3;
    private static final double BYN_TO_EUR = 3.6;
    private static final double BYN_TO_JPY = 0.021;
    private static final double BYN_TO_CNY = 0.46;
    private static Map<String, Double> rates;

    public static void main(String[] args) {
        initRates();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the name of currency: (BYN, USD, EUR, JPY, CNY)");
        String currencyName = scanner.nextLine();
        while (!rates.containsKey(currencyName)){
            currencyName = scanner.nextLine();
        }
        System.out.println("Input the sum of currency: ");
        BigDecimal sum = scanner.nextBigDecimal();
        System.out.println("Your sum in different currencies: ");
        if (currencyName.equals(BYN)) {
            outputRates(rates, sum);
        } else {
            BigDecimal resultInByn = sum.multiply(BigDecimal.valueOf(rates.get(currencyName)))
                    .setScale(2, RoundingMode.HALF_UP);
            outputRates(rates, resultInByn);
        }
    }

    private static void initRates() {
        rates= new HashMap<>();
        rates.put(BYN, 1.0);
        rates.put(USD, BYN_TO_USD);
        rates.put(EUR, BYN_TO_EUR);
        rates.put(JPY, BYN_TO_JPY);
        rates.put(CNY, BYN_TO_CNY);
    }

    private static void outputRates(Map<String, Double> rates, BigDecimal sum) {
        for(String currency: rates.keySet()) {
            System.out.println(currency + " " + sum.divide(BigDecimal.valueOf(rates.get(currency)),
                    2, RoundingMode.HALF_UP));
        }
    }
}