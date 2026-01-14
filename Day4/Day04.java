import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day04 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("/workspaces/AdventOfCode-2025/Day4/data");
        String[][] grid = get2DArray(fileData);
        int partOneAnswer = 0;
        int partTwoAnswer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                String e = grid[i][j];
                if (e.equals("@")) {
                    int count = countAdjacent(grid, i, j);
                    if (count < 4) {
                        partOneAnswer++;
                    }
                }
            }
        }
        boolean added;
        while (true) {
            added = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    String e = grid[i][j];
                    if (e.equals("@")) {
                        int count = countAdjacent2(grid, i, j);
                        if (count < 4) {
                            partTwoAnswer++;
                            grid[i][j] = "X";
                            added = true; 
                        }
                    }
                }
            }
            if (!added) {
                break;
            }
        }
        System.out.println("Part one answer: " + partOneAnswer);
        System.out.println("Part one answer: " + partTwoAnswer);

    }

    // COMPLETE THIS METHOD! This method should see how many paper rolls are surrounding
    // the roll at position "row" and "col"
    // You should never go out of bounds because I created a border around the 2D grid
    // to prevent this
    public static int countAdjacent(String[][] grid, int row, int col) {
        int count = 0;
            for (int i = row-1; i < row+2; i++) {
                for (int j = col-1; j < col+2; j++) {
                    if (grid[i][j].equals("@")) {
                        count++;
                    }
            }
        }
        return count-1;
    }

    public static int countAdjacent2(String[][] grid, int row, int col) {
        int count = 0;
            for (int i = row-1; i < row+2; i++) {
                for (int j = col-1; j < col+2; j++) {
                    if (grid[i][j].equals("@")) {
                        count++;
                    }
            }
        }
        return count-1;
    }

    public static String[][] get2DArray(ArrayList<String> fileData) {

        String borderRow = "";
        for (int i = 0; i < fileData.get(0).length(); i++) {
            borderRow += ".";
        }

        fileData.add(0, borderRow);
        fileData.add(borderRow);

        for (int i = 0; i < fileData.size(); i++) {
            String s = fileData.get(i);
            s = "." + s + ".";
            fileData.set(i, s);
        }

        int rows = fileData.size();
        int cols = fileData.get(0).length();
        String[][] grid = new String[rows][cols];


        for (int i = 0; i < fileData.size(); i++) {
            String row = fileData.get(i);
            for (int j = 0; j < row.length(); j++) {
                String entry = row.substring(j, j+1);
                grid[i][j] = entry;
            }
        }

        return grid;
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