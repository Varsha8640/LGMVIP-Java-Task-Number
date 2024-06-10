import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter extends JFrame implements ActionListener {
    private JComboBox<String> fromCurrencyComboBox;
    private JComboBox<String> toCurrencyComboBox;
    private JTextField amountTextField;
    private JLabel resultLabel;
    private JButton convertButton;

    // Currency exchange rates (you'll need to update these with current rates)
    private Map<String, Double> exchangeRates = new HashMap<>();

    public CurrencyConverter() {
        super("Currency Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new GridLayout(5, 2));

        // Initialize exchange rates (example)
        exchangeRates.put("USD", 1.0); // US Dollar
        exchangeRates.put("EUR", 0.9); // Euro
        exchangeRates.put("GBP", 0.8); // British Pound
        exchangeRates.put("INR", 80.0); // Indian Rupee
        exchangeRates.put("JPY", 110.0); // Japanese Yen

        // Create components
        fromCurrencyComboBox = new JComboBox<>(exchangeRates.keySet().toArray(new String[0]));
        toCurrencyComboBox = new JComboBox<>(exchangeRates.keySet().toArray(new String[0]));
        amountTextField = new JTextField();
        resultLabel = new JLabel("Result will be displayed here");
        convertButton = new JButton("Convert");

        // Add action listener to the convert button
        convertButton.addActionListener(this);

        // Add components to the frame
        add(new JLabel("From Currency:"));
        add(fromCurrencyComboBox);
        add(new JLabel("To Currency:"));
        add(toCurrencyComboBox);
        add(new JLabel("Amount:"));
        add(amountTextField);
        add(convertButton);
        add(resultLabel);

        // Set visibility
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            try {
                // Get values from input fields
                String fromCurrency = (String) fromCurrencyComboBox.getSelectedItem();
                String toCurrency = (String) toCurrencyComboBox.getSelectedItem();
                double amount = Double.parseDouble(amountTextField.getText());

                // Perform the conversion
                double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);

                // Update the result label
                resultLabel.setText(String.format("%.2f %s", convertedAmount, toCurrency));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input. Please enter a valid number.");
            }
        }
    }

    // Method to convert currency
    private double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        // Get the exchange rates
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);

        // Convert the amount
        return (amount / fromRate) * toRate;
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}