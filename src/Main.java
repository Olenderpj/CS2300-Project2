import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static final int parametricArrayLength = 10;
    public static final int implicitArrayLength = 9;

    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils()
                .setFileName("testInput.txt");
        ArrayList<String> data = fileUtils.readLinesFromFile();

        for(String information: data){
            String[] rowData = information.split(" ");

            if (arrayContains(rowData, "i")){
                System.out.println("Implicit Form:");
                Implicit implicit = new Implicit()
                        .setCoefficientA(Double.parseDouble(rowData[1]))
                        .setCoefficientB(Double.parseDouble(rowData[2]))
                        .setCoefficientC(Double.parseDouble(rowData[3]))
                        .setOrderedPairsList(buildOrderedPairsList(rowData));

                implicit.printFormula();
                implicit.printParametricForm();
                System.out.println("\nPoint Normal Form:");
                implicit.printPointNormalForm();

                //TODO: Test this once the array length is confirmed by the professor.
                //implicit.testIfPointIsOnLine();
                System.out.print("\nDistance from point: ");
                for (OrderedPair orderedpair: implicit.getOrderedPairsList()){
                    implicit.testIfPointIsOnLine(orderedpair);
                }

            System.out.println();

            } else if (arrayContains(rowData, "p")){
                System.out.println("Parametric Form:\n ");
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
        var orderedPairList = new ArrayList<OrderedPair>();

        int orderedPairStart = 3;

        if (array.length == parametricArrayLength){
            orderedPairStart = 4;
        }

        for (int i = orderedPairStart; i < array.length; i+=2){
            if ((i+1 < array.length)) {
                var orderedPair = new OrderedPair(Double.parseDouble(array[i]), Double.parseDouble(array[i + 1]));
                orderedPairList.add(orderedPair);
            }
        }
        return orderedPairList;
    }
}
