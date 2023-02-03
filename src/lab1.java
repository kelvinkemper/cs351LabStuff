import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class lab1 {
    private static int withinCounter = 0;
    private static int overlapCounter = 0;


    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        String methodCall = sc.nextLine();
        if (methodCall.equals("within")) {

        }
        File doc = new File(fileName);
        InputStream is = new FileInputStream(fileName);
        if (fileName.equalsIgnoreCase("done")) {
            System.exit(1);
        } else if (doc.exists()) {
            printInputStream(is);
        }


        // String fileName = "src/docs/lab1/test_case1.txt";
    }

    private static void printInputStream(InputStream is) {
        try (InputStreamReader streamReader =
                new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
             String line;
            while ((line = reader.readLine()) != null) {
                     //System.out.println(line);
                     within(line);

            }
            System.out.println("within\n" + withinCounter);
            System.out.println("overlap\n" + overlapCounter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void within(String line) {
        int a = Character.getNumericValue(line.charAt(0));
        int b = Character.getNumericValue(line.charAt(2));
        int c = Character.getNumericValue(line.charAt(4));
        int d = Character.getNumericValue(line.charAt(6));
        if (((a <= c) && (b >= d)) || ((a >= c) && (b <= d))) {
            withinCounter++;
        }

    }

    private static void overlap(String line) {
        int a = Character.getNumericValue(line.charAt(0));
        int b = Character.getNumericValue(line.charAt(2));
        int c = Character.getNumericValue(line.charAt(4));
        int d = Character.getNumericValue(line.charAt(6));
        if (b >= c) {
            overlapCounter++;
        }
    }

}
