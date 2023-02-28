package lab1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * CS 351 Lab 1
 * Kelvin Kemper
 */
public class lab1 {
    private static int withinCounter = 0;
    private static int overlapCounter = 0;

    /**
     * ***FILE DIRECTORY MUST USE BACKSPACES "\" at least on my windows machine***
     * Honestly not much error checking so program will quit if
     * directory isn't correct
     */

    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();

        while (!(fileName.equalsIgnoreCase("DONE"))) {
            try {
                File file = new File(fileName);
                BufferedReader br = new BufferedReader(new FileReader(file));
                readLines(br);
            } catch (FileNotFoundException e) {
                System.out.println("File path is incorrect: please use docs\\lab1.lab1\\<testcase>.txt");
                System.exit(1);
            }
            String methodCall = sc.nextLine();

            if (methodCall.equalsIgnoreCase("within")) {
                printWithin();
            }
            if (methodCall.equalsIgnoreCase("overlap")) {
                printOverlap();
            }
            fileName = sc.nextLine();

            overlapCounter = 0;
            withinCounter = 0;

            // String fileName = "docs/lab1/test_case1.txt"
            // String fileName = "src/docs/lab1.lab1/test_case1.txt";
        }
        System.exit(1);
    }

    /**
     * reads the text file line by line
     * @param br buffered reader input
     * @throws IOException if not a file path
     */
    private static void readLines(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            allTest(line);
        }
    }


    /**
     * complets within and overlap test for output
     * @param line each line of the text file
     */
    private static void allTest(String line) {
        int a = Character.getNumericValue(line.charAt(0));
        int b = Character.getNumericValue(line.charAt(2));
        int c = Character.getNumericValue(line.charAt(4));
        int d = Character.getNumericValue(line.charAt(6));
        if (((a <= c) && (b >= d)) || ((a >= c) && (b <= d))) {
            withinCounter++;
        }
        if (b >= c) {
            overlapCounter++;
        }
    }

    /**
     * prints within output if "output" is written by user
     */
    private static void printWithin() {
        System.out.println(withinCounter);
    }

    /**
     * prints overlap output if "within" is written by user
     */
    private static void printOverlap() {
        System.out.println(overlapCounter);
    }


}
///Users/kelvinkemper/IdeaProjects/cs351LabStuff/src/lab1/lab1.java