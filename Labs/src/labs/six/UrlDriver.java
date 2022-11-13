package labs.six;

import java.util.Scanner;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.InputMismatchException;

// This is one way to accomplish today's lab
public class UrlDriver {

    Scanner scanIn;
    String  url;

    public UrlDriver() {
        scanIn = new Scanner(System.in);
    }

    public void promptUser() {
        System.out.print("Please enter a URL to connect to > ");
        url  = scanIn.next();
    }



    public void go() {


        promptUser();
        Scanner scanWeb = null;

        try {
            URL lab4 = new URL(url);
            scanWeb = new Scanner(lab4.openStream());
        } catch (MalformedURLException mue) {
            System.out.println("Malformed exception: " + mue.getMessage());
            System.exit(1);
        } catch (IOException ioe) {
            System.out.println("IO Exception: " + ioe.getMessage());
            System.exit(1);
        }
        if (scanWeb.hasNextLine()) {
            String firstLine = scanWeb.nextLine();
            if (firstLine.equals("lab6 KM")) {
                float sum = 0.0f;
                int cnt = 0;
                while (scanWeb.hasNext()) {
                    try {
                        sum += scanWeb.nextDouble();
                        cnt += 1;
                    }
                    catch(InputMismatchException e) {
                        scanWeb.next();
                    }

                }
                System.out.println("Count: " + cnt + ", Sum: " + sum);
                System.out.println("Mean = " + (sum/cnt));

            }
            else {
                System.out.println(firstLine);
                while (scanWeb.hasNextLine()) {
                    System.out.println(scanWeb.nextLine());
                }
            }
        }
    }

    public static void main(String[] args) {
        UrlDriver driver = new UrlDriver();
        driver.go();
    }

}