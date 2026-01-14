package Day5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// for this Day, I made an "IngredientRange" object that holds two numbers
// the minimum and the maximum for the range in the file
public class Day05 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("/workspaces/AdventOfCode-2025/Day5/data");
        ArrayList<String> ranges = new ArrayList<String>();
        ArrayList<Long> numbers = new ArrayList<Long>();
        for (String nums : fileData) {
            if (nums.contains("-")) {
                ranges.add(nums);
            }
            else {
                numbers.add(Long.parseLong(nums));
            }
        }
        long partOneAnswer = 0;
        long partTwoAnswer = 0;
        for (long num : numbers) {
            for (String range : ranges) {
                if (inRange(num, range)) {
                    partOneAnswer++;
                    break;
                }
            }
        }

        ArrayList<String> finalRanges = new ArrayList<String>();
        String range1;
        String range2;
        for (String range : ranges) {
            finalRanges.add(range);
        }
        boolean canMerge = true;
        int size;
        while (canMerge) {
            canMerge = false;
            size = finalRanges.size()-1;
            for (int i = 0; i <= size; i++) {
                range1 = finalRanges.get(i);
                for (int j = 0; j < finalRanges.size() && j != i; j++) {
                    range2 = finalRanges.get(j);

                    if (canMerge(range2, range1)) {
                        finalRanges.set(j, mergeRange(range2, range1)); 
                        finalRanges.remove(i);
                        canMerge = true;
                        size-=1;
                        break;
                    }

                    
                }
            }
        }

        
        long num1;
        long num2;
        System.out.println();
        for (String range : finalRanges) {
            System.out.println(range);
            num1 = Long.parseLong(range.split("-")[0]);
            num2 = Long.parseLong(range.split("-")[1]);
            partTwoAnswer+= num2 - num1 + 1;
        }

        System.out.println("Part 1 Answer: " + partOneAnswer);
        System.out.println("Part 2 Answer: " + partTwoAnswer);
    }
    public static String mergeRange(String range1, String range2) {
        Long min1 = Long.parseLong(range1.split("-")[0]);
        Long max1 = Long.parseLong(range1.split("-")[1]);
        Long min2 = Long.parseLong(range2.split("-")[0]);
        Long max2 = Long.parseLong(range2.split("-")[1]);
        return Math.min(min1, min2) + "-" + Math.max(max1, max2);
    }
    
    public static boolean canMerge(String range1, String range2) {
        Long min1 = Long.parseLong(range1.split("-")[0]);
        Long max1 = Long.parseLong(range1.split("-")[1]);
        Long min2 = Long.parseLong(range2.split("-")[0]);
        Long max2 = Long.parseLong(range2.split("-")[1]);
        if (Math.min(max1, max2) + 1 >= Math.max(min1,min2)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean inRange(long num, String range) {
        Long min = Long.parseLong(range.split("-")[0]);
        Long max = Long.parseLong(range.split("-")[1]);
        if (num >= min && num <= max) {
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

