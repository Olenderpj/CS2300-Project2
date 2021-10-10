import java.util.ArrayList;

public class Main {

    public static final int parametricArrayLength = 11;

    public static void main(String[] args) {
        // Read data from the file and build a string array element from each line in the file
        FileUtils fileUtils = new FileUtils()
                .setFileName("Input.txt");
        ArrayList<String> data = fileUtils.readLinesFromFile();

        // Iterate over each line of data and using regex, break it into a smaller array of strings.
        for(String information: data){
            String[] rowData = information.split(" ");

            // Test condition to tell if the array contains an i or I for implicit and build a new object for that form
            if (ArrayUtils.arrayContains(rowData, "i")){
                System.out.println("\nImplicit Form:");
                var implicit = new Implicit()
                        .setCoefficientA(Double.parseDouble(rowData[1]))
                        .setCoefficientB(Double.parseDouble(rowData[2]))
                        .setCoefficientC(Double.parseDouble(rowData[3]))
                        .setOrderedPairsList(ArrayUtils.buildOrderedPairsList(rowData, 4));

                // print the different formulas starting with the implicit form.
                implicit.printImplicitFormula();
                implicit.printParametricForm();

                System.out.println("\nPoint Normal Form:");
                implicit.printPointNormalForm();

                System.out.print("\nDistance from point: ");
                for (OrderedPair orderedpair: implicit.getOrderedPairsList()){
                    implicit.testIfPointIsOnLine(orderedpair);
                }

                System.out.println();

            // Test condition to tell if the array contains a p or P for Parametric and build a new object for that form
            } else if (ArrayUtils.arrayContains(rowData, "p")){
                System.out.println("\n");
                var parametric = new Parametric()
                        .setPoint(new Vector().setV1(Double.parseDouble(rowData[1])).setV2(Double.parseDouble(rowData[2])))
                        .setVector(new Vector().setV1(Double.parseDouble(rowData[3])).setV2(Double.parseDouble(rowData[4])))
                        .setOrderedPairsList(ArrayUtils.buildOrderedPairsList(rowData, 5));

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
}
