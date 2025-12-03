package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {

        // Day 2 data parsing set up
        ArrayList<String> fileData = getFileData("/workspaces/AdventOfCode-2025/Day2/data");
        ArrayList<Long> productIDs = new ArrayList<Long>();
        for (String s : fileData.get(0).split(",")) {
            long first = Long.parseLong(s.split("-")[0]);
            long second = Long.parseLong(s.split("-")[1]);
            for (long i = first; i <= second; i++) {
                productIDs.add(i);
            }
        }
        // Day 2 data parsing set up complete
        // "productIDs" is a list of "long" variables that make up each product ID from the file

        long partOneAnswer = 0;

        for (Long p : productIDs) {
            if (isValidProductID(p, false)) {
                partOneAnswer += p;
                System.out.println(p);
            }

        }

        System.out.println("Part one answer: " + partOneAnswer);
    }

    public static boolean isValidProductID(long productID, boolean partTwo) {
        String pID = productID + "";
        if (pID.length() % 2 != 0) {
            return false;
        }
        String firstHalf = pID.substring(0, pID.length()/2);
        String secondHalf = pID.substring(pID.length()/2);
        if (firstHalf.equals(secondHalf)) {
            return true;
        }
        return false;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}