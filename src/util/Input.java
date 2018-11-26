package util;

import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input(Scanner scanner){
        this.scanner = scanner;
    }

    public String getString(){
        return this.scanner.nextLine();
    }

    public String getString(String prompt){
        System.out.println(prompt);
        return getString();
    }

    public boolean yesNo(){
        String userInput = getString( "Respond with yes or no [yes/y/n/no]");
        return (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes"));
    }

    public boolean yesNo(String prompt){
        System.out.println(prompt);
        return yesNo();
    }

    public void getBinary(){
        String input = getString("Enter a binary number: ");
        try{
            int output = Integer.parseInt(input, 2);
            System.out.printf("Your number is %d%n", output);
        } catch(NumberFormatException e){
            getBinary();
        }
    }
    public void getHexadecimal(){
        String input = getString("Enter a hexadecimal number: ");
        try{
            int output = Integer.parseInt(input, 16);
            System.out.printf("Your number is %d%n", output);
        } catch(NumberFormatException e){
            getHexadecimal();
        }
    }

    public static void main(String[] args) {
        Input input = new Input(new Scanner(System.in));
        input.getBinary();
        input.getHexadecimal();
    }

    public int getInt(){
        int input;
        try{
            input = Integer.valueOf(getString());
        } catch(NumberFormatException e){
            return getInt("Please enter a valid integer: ");
        }
        return input;
    }

    public int getInt(int min, int max){
        int input = getInt(String.format("Please enter an integer between %d and %d%n", min, max));
        return (input >= min && input <= max)? input: getInt(min, max);
    }

    public double getDouble(double min, double max){
        double input = getDouble(String.format("Please enter a double between %.1f and %.1f%n", min, max));
        return (input >= min && input <= max)? input: getDouble(min, max);

    }

    public int getInt(String prompt){
        String input = getString(prompt);
        try {
            return Integer.valueOf(input);
        } catch(NumberFormatException e){
            return getInt(prompt);
        }
    }


    public double getDouble(String prompt){
        String input = getString(prompt);
        try{
            return Double.valueOf(input);
        } catch(NumberFormatException e){
            return getDouble("Please enter a valid double: ");
        }
    }

}
