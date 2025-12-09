import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day01 {
    public static void main(String[] args) {

        ArrayList<String> lines = getFileData("/workspaces/AdventOfCode-2025/Day1/data");

        int partOneAnswer = 0;
        int partTwoAnswer = 0;
        partOneAnswer = getPartOneNumber(lines);
        partTwoAnswer = getPartTwoNumber(lines);
        System.out.println("Part one answer: " + partOneAnswer);
        System.out.println("Part two answer: " + partTwoAnswer);
    }

    public static int getPartOneNumber(ArrayList<String> lines) {
        int start = 50;
        int count = 0;

        for (int i = 0 ; i < lines.size(); i++) {
            String line = lines.get(i);
            int subtract = Integer.parseInt(line.substring(1));
            subtract %= 100;

            if (line.substring(0,1).equals("L")) {
            start -= subtract;         
            } 
        
            else if (line.substring(0,1).equals("R")) {
            start += subtract;
            }
            
            if (start < 0) {
            start += 100;
            }

            if (start > 99) {
            start -= 100;
            }

            if (start == 0 ) {
            count +=1;
            } 
        }
        return count;
    }

    public static int getPartTwoNumber(ArrayList<String> lines) {
        int start = 50;
        int count = 0;
        int previousNum = 50;

        for (int i = 0 ; i < lines.size(); i++) {
            String line = lines.get(i);
            int subtract = Integer.parseInt(line.substring(1));
            subtract %= 100;
            int revolutions = Integer.parseInt(line.substring(1)) / 100;

            if (line.substring(0,1).equals("L")) {
                previousNum = start;
                start -= subtract;
                
                if (start < 0 && previousNum != 0) {
                    count += 1;
                    start += 100;
                    System.out.println("previous:" + previousNum + " after turn: " + start);
                } 
                else if (start < 0) {
                    start += 100;
                }
                if (start > 99 && previousNum != 0 && start != -1) {
                    count += 1;
                    start -= 100;
                    System.out.println("previous:" + previousNum + " after turn: " + start);
                } 
                else if (start > 99) {
                    start -= 100;
                }         
            } 
        
            else if (line.substring(0,1).equals("R")) {
                previousNum = start;
                start += subtract;
                
                if (start > 99 && previousNum != 0 && start != 100) {
                    count += 1;
                    start -= 100;
                    System.out.println("previous:" + previousNum + " after turn: " + start);
                } 
                else if (start > 99) {
                    start -= 100;
                }  
            }

            if (start == 0) {
                count += 1;
            }             

            count += revolutions;
            
        }
        return count;
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