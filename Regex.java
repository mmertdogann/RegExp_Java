package Regex;

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

public class Regex {

    public static void main(String[] args) throws IOException {


        File file = new File("Input1.txt"); // input file name "Input1.txt"
        try (PrintWriter outText = new PrintWriter("Output1.txt", "UTF-8")) { // this creates a new txt file
            Scanner input = new Scanner(file); // scan the input file



            while (input.hasNext()) {  // this will read whole text

                String readLine = input.nextLine(); // continue reading line by line
                readLine = deleteProcess1(readLine);
                readLine = deleteProcess2(readLine);
                readLine = deleteProcess3(readLine);
                readLine = deleteProcess4(readLine);
                readLine = deleteProcess5(readLine);
                readLine = deleteProcess6(readLine);
                outText.println(readLine);  //write the text which was created Line number: 13

            }


        }
    }


        private static String deleteProcess6 (String input){   // reduce many letters which are the same
            Pattern pattern = Pattern.compile("([a-zA-Z])\\1\\1+");
            Matcher match = pattern.matcher(input);
            return match.replaceAll("$1$1$1");

        }

        private static String deleteProcess5 (String input){ // change any digits to NUMBER
            Pattern pattern = Pattern.compile("^([0-9]+)");
            Matcher match = pattern.matcher(input);
            return match.replaceAll("NUMBER");


        }

        private static String deleteProcess4 (String input){  // turn "-" to " - "
            Pattern pattern = Pattern.compile("-");
            Matcher match = pattern.matcher(input);
            return match.replaceAll(" - ");
        }

        private static String deleteProcess3 (String input){ // URL
            Pattern pattern = Pattern.compile("\\w+:\\/\\/\\S+");
            Matcher match = pattern.matcher(input);
            return match.replaceAll("");

        }

        private static String deleteProcess2 (String input){ // #
            Pattern pattern = Pattern.compile("(#)([A-Za-z0-9])");
            Matcher match = pattern.matcher(input);
            return match.replaceAll("");

        }

        private static String deleteProcess1 (String input){ // @
            Pattern pattern = Pattern.compile("(@\\w+)([A-Za-z0-9])");
            Matcher match = pattern.matcher(input);
            return match.replaceAll("");

        }
    }
