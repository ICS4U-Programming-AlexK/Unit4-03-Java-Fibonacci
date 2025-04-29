import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * This program recursively calculates the Fibonacci number
 * for each valid number from an input file
 * and writes the result or error message for each line into an output file.
 * Author: Alex Kapajika
 * Version: 1.1
 * Since: 2025-04-23
 */
public final class Fibonacci {
    /** Constant for the input file. */
    private static final String INPUT_FILE = "input.txt";
    /** Constant for the output file. */
    private static final String OUTPUT_FILE = "output.txt";
    /**
     * This is to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Fibonacci() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * Main Method.
     * @param args Unused.
     */
    public static void main(final String[] args) {
        try (Scanner scanner = new Scanner(new File(INPUT_FILE));
                FileWriter writer = new FileWriter(OUTPUT_FILE)) {
            // Reading file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    writer.write("Empty line.\n");
                } else {
                    try {
                        int number = Integer.parseInt(line);
                        if (number < 0) {
                            writer.write("Negative number.\n");
                        } else {
                            // Calculate the Fibonacci number
                            int result = fibonacci(number);
                            writer.write("Fibonacci number at position "
                             + number + " is: "
                                    + result + "\n");
                        }
                    } catch (NumberFormatException e) {
                        writer.write("Invalid number: "
                         + line + "\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method calculates the Fibonacci number recursively.
     *
     * @param n The position in the Fibonacci sequence
     * @return The Fibonacci number at position n
     */
    public static int fibonacci(final int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
