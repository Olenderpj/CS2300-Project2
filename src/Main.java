import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils()
                .setFileName("testInput.txt");
        ArrayList<String> data = fileUtils.readLinesFromFile();
        System.out.print(data);


    }
}
