import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils()
                .setFileName("testInput.txt");
        ArrayList<String> data = fileUtils.readLinesFromFile();

        for(String information: data){
            String[] rowData = information.split(" ");

            if (arrayContains(rowData, "i")){
                System.out.println("Implicit:");
                Implicit implicit = new Implicit()
                        .setCoefficientA(Double.parseDouble(rowData[1]))
                        .setCoefficientB(Double.parseDouble(rowData[2]))
                        .setCoefficientC(Double.parseDouble(rowData[3]))
                        .setOrderedPairsList(buildOrderedPairsList(rowData));

                implicit.printFormula();
                implicit.printParametricForm();

            System.out.println();

            } else if (arrayContains(rowData, "p")){
                System.out.println("Parametric:\n ");
                //TODO: Complete parametric class
            }
        }
    }

    // Search an array for a specific value
    public static <E> boolean arrayContains(E[] array, String x){
        boolean contains = false;

        for (E value: array){
            if (Objects.equals(value, x) || Objects.equals(value, x.toUpperCase())) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    public static ArrayList<OrderedPair> buildOrderedPairsList (String[] array){
        // build ordered pairs
        ArrayList<OrderedPair> orderedPairsList = new ArrayList<>();

        for (int i = 5; i < array.length; i += 2){
            orderedPairsList.add(new OrderedPair(Double.parseDouble(array[i]), Double.parseDouble(array[i + 1])));
        }
        return orderedPairsList;
    }
}
