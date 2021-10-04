import java.sql.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static final int parametricArrayLength = 11;

    public static void main(String[] args) {
        // Read data from the file and build a string array element from each line in the file
        FileUtils fileUtils = new FileUtils()
                .setFileName("testInput.txt");
        ArrayList<String> data = fileUtils.readLinesFromFile();

        // Iterate over each line of data and using regex, break it into a smaller array of strings.
        for(String information: data){
            String[] rowData = information.split(" ");

            // Test condition to tell if the array contains an i or I for implicit and build a new object for that form
            if (arrayContains(rowData, "i")){
                System.out.println("Implicit Form:");
                var implicit = new Implicit()
                        .setCoefficientA(Double.parseDouble(rowData[1]))
                        .setCoefficientB(Double.parseDouble(rowData[2]))
                        .setCoefficientC(Double.parseDouble(rowData[3]))
                        .setOrderedPairsList(buildOrderedPairsList(rowData, 4));

                // print the different formulas starting with the implicit form.
                implicit.printFormula();
                implicit.printParametricForm();

                System.out.println("\nPoint Normal Form:");
                implicit.printPointNormalForm();

                System.out.print("\nDistance from point: ");
                for (OrderedPair orderedpair: implicit.getOrderedPairsList()){
                    implicit.testIfPointIsOnLine(orderedpair);
                }

                System.out.println();

                // Test condition to tell if the array contains a p or P for Parametric and build a new object for that form
            } else if (arrayContains(rowData, "p")){
                System.out.println();
                var parametric = new Parametric()
                        .setP(new Vector().setV1(Double.parseDouble(rowData[1])).setV2(Double.parseDouble(rowData[2])))
                        .setV(new Vector().setV1(Double.parseDouble(rowData[3])).setV2(Double.parseDouble(rowData[4])))
                        .setOrderedPairsList(buildOrderedPairsList(rowData, 5));

                // print the different formulas
                parametric.printFormula();

                System.out.println("\nParametric -> Implicit:");
                parametric.printImplicitForm();

                // Use the parametric object's data to create an implicit object so the methods can be re-used.
                var implicitFromParametric = parametric.convertParametricToImplicit();

                System.out.println("\nPoint Normal Form:");
                implicitFromParametric.printPointNormalForm();

                System.out.print("\nDistance from point: ");
                for (OrderedPair orderedPair: implicitFromParametric.getOrderedPairsList()){
                    implicitFromParametric.testIfPointIsOnLine(orderedPair);
                }
            }
        }
    }

    // Search an array for a specific value
    public static <E> boolean arrayContains(E[] array, String x){
        boolean containsValue = false;

        for (E value: array){
            if (Objects.equals(value, x) || Objects.equals(value, x.toUpperCase())) {
                containsValue = true;
                break;
            }
        }
        return containsValue;
    }

    // build an array of ordered pair objects from the given arrays. (this data comes after vector or point data)
    public static ArrayList<OrderedPair> buildOrderedPairsList (String[] array, int startPoint){
        var orderedPairs = new ArrayList<OrderedPair>();

        for (int i = startPoint; i < array.length; i += 2){
            orderedPairs.add(new OrderedPair(Double.parseDouble(array[i]), Double.parseDouble(array[i + 1])));
        }
        return orderedPairs;
    }
}
