import java.util.ArrayList;

public class Parametric extends LoggingUtils{
    private double p1;
    private double p2;
    private double v1;
    private double v2;
    private ArrayList<OrderedPair> orderedPairsList;

    public void printFormula(){
        if (allValuesPersisted()){
            System.out.print("***Formula Placeholder***");
        }
    }

    //TODO: Print implicit form - Finish this method.
    public void printImplicitForm(){
        System.out.println("Parametric -> Implicit:");
        // Construct the initial vector
        var resultingVector = new Vector()
                .setA(v1 - p1)
                .setB(v2 - p2);

        // construct the perpendicular vector
        var perpendicularVector = new Vector()
                .setA(-1 *(resultingVector.getB()))
                .setB(resultingVector.getA());

        double c;

        //System.out.printf("\n%.2fa + %.2fb + %.2f = 0", );
    }

    // returns true if all the values exist and none are empty
    private boolean allValuesPersisted(){
        return !Double.isNaN(p1) || !Double.isNaN(p2) || !Double.isNaN(v1) || !Double.isNaN(v2);
    }

}


