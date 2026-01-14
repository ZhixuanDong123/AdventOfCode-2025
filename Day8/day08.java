package Day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day08 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("/workspaces/AdventOfCode-2025/Day8/data");
        ArrayList<ArrayList<String>> coords = new ArrayList<ArrayList<String>>();
        for (String cords : fileData) {
            coords.add(cords.split(","));
        }
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
