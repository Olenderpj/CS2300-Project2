import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {
    public static String fileName;

    public ArrayList<String> readLinesFromFile(){
        ArrayList <String> stringArray = new ArrayList<>();

        try{
            File inputFile = new File(fileName);
            Scanner fileReader = new Scanner(inputFile);
            while (fileReader.hasNextLine()){
                String data = fileReader.nextLine();
                stringArray.add(data);
            }
        } catch (FileNotFoundException e) {
            System.out.print("[" + fileName + "]: may have a typo or does not exist");
            e.printStackTrace();
        }
        return stringArray;
    }

    public FileUtils setFileName(String fileName) {
        FileUtils.fileName = fileName;
        return this;
    }
}
