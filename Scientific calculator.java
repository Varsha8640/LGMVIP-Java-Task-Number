
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;

public class ScientificCalculator extends JFrame implements ActionListener {

    // Components of the calculator
    JTextField display;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton, decButton, equButton, clrButton, delButton;
    JButton sinButton, cosButton, tanButton, logButton, sqrtButton, powButton, factButton, piButton;

    // Variables for calculations
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    // Constructor for the calculator
    public ScientificCalculator() {
        // Set the title of the window
        setTitle("Scientific Calculator");

        // Set the size of the window
        setSize(420, 580);

        // Set the layout of the window
        setLayout(null);

        // Create the display field
        display = new JTextField();
        display.setBounds(30, 40, 340, 40);
        display.setEditable(false);
        add(display);

        // Create the number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setBounds(30 + (i % 3) * 80, 100 + (i / 3) * 50, 50, 40);
            numberButtons[i].addActionListener(this);
            add(numberButtons[i]);
        }

        // Create the decimal button
        decButton = new JButton(".");
        decButton.setBounds(30 + (2) * 80, 100 + (3) * 50, 50, 40);
        decButton.addActionListener(this);
        add(decButton);

        // Create the function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        clrButton = new JButton("C");
        delButton = new JButton("Del");
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = equButton;
        functionButtons[5] = clrButton;
        functionButtons[6] = delButton;

        // Set the bounds for the function buttons
        for (int i = 0; i < 7; i++) {
            functionButtons[i].setBounds(30 + (i % 2) * 80, 350 + (i / 2) * 50, 50, 40);
            functionButtons[i].addActionListener(this);
            add(functionButtons[i]);
        }

        // Create the scientific function buttons
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        logButton = new JButton("log");
        sqrtButton = new JButton("sqrt");
        powButton = new JButton("x^y");
        factButton = new JButton("n!");
        piButton = new JButton("π");
        functionButtons[7] = sinButton;
        functionButtons[8] = cosButton;
        functionButtons[9] = tanButton;
        functionButtons[10] = logButton;
        functionButtons[11] = sqrtButton;
        functionButtons[12] = powButton;
        functionButtons[13] = factButton;
        functionButtons[14] = piButton;

        // Set the bounds for the scientific function buttons
        for (int i = 7; i < 15; i++) {
            functionButtons[i].setBounds(210 + (i % 3) * 60, 100 + (i / 3) * 50, 60, 40);
            functionButtons[i].addActionListener(this);
            add(functionButtons[i]);
        }

        // Set the defaultCloseOperation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the visibility of the window
        setVisible(true);
    }

    // Event handler for button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if the clicked button is a number button
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }

        // Check if the clicked button is the decimal button
        if (e.getSource() == decButton) {
            display.setText(display.getText().concat("."));
        }

        // Check if the clicked button is an operator button
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        } else if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        } else if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        } else if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }

        // Check if the clicked button is the equals button
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(display.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }

            display.setText(String.valueOf(result));
        }

        // Check if the clicked button is the clear button
        if (e.getSource() == clrButton) {
            display.setText("");
        }

        // Check if the clicked button is the delete button
        if (e.getSource() == delButton) {
            String string = display.getText();
            display.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                display.setText(display.getText() + string.charAt(i));
            }
        }

        // Check if the clicked button is the sine button
        if (e.getSource() == sinButton) {
            num1 = Double.parseDouble(display.getText());
            result = Math.sin(Math.toRadians(num1));
            display.setText(String.valueOf(result));
        }

        // Check if the clicked button is the cosine button
        if (e.getSource() == cosButton) {
            num1 = Double.parseDouble(display.getText());
            result = Math.cos(Math.toRadians(num1));
            display.setText(String.valueOf(result));
        }

        // Check if the clicked button is the tangent button
        if (e.getSource() == tanButton) {
            num1 = Double.parseDouble(display.getText());
            result = Math.tan(Math.toRadians(num1));
            display.setText(String.valueOf(result));
        }

        // Check if the clicked button is the logarithm button
        if (e.getSource() == logButton) {
            num1 = Double.parseDouble(display.getText());
            result = Math.log10(num1);
            display.setText(String.valueOf(result));
        }

        // Check if the clicked button is the square root button
        if (e.getSource() == sqrtButton) {
            num1 = Double.parseDouble(display.getText());
            result = Math.sqrt(num1);
            display.setText(String.valueOf(result));
        }

        // Check if the clicked button is the power button
        if (e.getSource() == powButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '^';
            display.setText("");
        }

        // Check if the clicked button is the factorial button
        if (e.getSource() == factButton) {
            num1 = Double.parseDouble(display.getText());
            result = factorial((int) num1);
            display.setText(String.valueOf(result));
        }

        // Check if the clicked button is the pi button
        if (e.getSource() == piButton) {
            display.setText(display.getText().concat("3.14159265359"));
        }

        // Check if the clicked button is the power button
        if (e.getSource() == powButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '^';
            display.setText("");
        }

        // Calculate the power
        if (e.getSource() == equButton && operator == '^') {
            num2 = Double.parseDouble(display.getText());
            result = Math.pow(num1, num2);
            display.setText(String.valueOf(result));
        }
    }

    // Function to calculate the factorial
    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    // Main method
    public static void main(String[] args) {
        new ScientificCalculator();
    }
}
