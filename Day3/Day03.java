package Day3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Day03 {
    public static void main(String[] args) {

        // **** DO NOT EDIT ANYTHING HERE ****
        ArrayList<String> fileData = getFileData("/workspaces/AdventOfCode-2025/Day3/data");
        int partOneAnswer = 0;
        long partTwoAnswer = 0;
        for (String batteries : fileData) {
            int voltage = getLargestCombination(batteries);
            partOneAnswer += voltage;
        }
        for (String batteries : fileData) {
            long voltage = getLargestCombination2(batteries);
            partTwoAnswer += voltage;
        }

        System.out.println("Part one answer: " + partOneAnswer);
        System.out.println("Part two answer: " + partTwoAnswer);
    }

    // COMPLETE THIS METHOD!
    public static int getLargestCombination(String batteries) {
        String tempStr = batteries.substring(0,batteries.length()-1); //get all but last value
        int firstNum;
        firstNum = findHighest(tempStr);
        tempStr = batteries.substring(findHighestIndx(tempStr)+1);
        firstNum *=10;
        firstNum += findHighest(tempStr);
        return firstNum;

    }
    public static long getLargestCombination2(String batteries) {
        Stack<Integer> maxVolt = new Stack<Integer>();
        String tempStr = batteries.substring(0,batteries.length()-12);
        batteries = batteries.substring(findHighestIndx(tempStr));
        for (int volt : batteries.chars().toArray()) { //get each value of batteries
            maxVolt.push(volt - 48);
        }
        int indx = 0;
        while (maxVolt.size() > 12) {
            maxVolt.get(indx);
            if (maxVolt.get(indx) < maxVolt.get(indx + 1) || maxVolt.get(indx) == 1) {
                maxVolt.remove(indx);
                indx--;
            } else {
                indx++;
            }
            if (indx > maxVolt.size() - 2) {
                break;
            }

        }
        String voltStr = "";
        for (int volt : maxVolt) {
            voltStr += volt;
        }
        voltStr = voltStr.substring(0,12);
        long max = Long.parseLong(voltStr);
        System.out.println(max);
        return max;
    }

    public static int findHighestIndx(String str) {
        int highest = 0;
        int tempNum;
        for (String num : str.split("")) {
            tempNum = Integer.parseInt(num);
            if (tempNum > highest) {
                highest = tempNum;
            }
            if (highest == 9) {
                break;
            }
        }
        return str.indexOf(highest + "");
    }

    public static int findHighest(String str) {
        int highest = 0;
        int tempNum;
        for (String num : str.split("")) {
            tempNum = Integer.parseInt(num);
            if (tempNum > highest) {
                highest = tempNum;
            }
            if (highest == 9) {
                break;
            }
        }
        return highest;
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