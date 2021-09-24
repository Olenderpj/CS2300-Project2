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

    //TODO: Print implicit form
    public void printImplicitForm(){

    }

    // returns true if all the values exist and none are empty
    private boolean allValuesPersisted(){
        return !Double.isNaN(p1) || !Double.isNaN(p2) || !Double.isNaN(v1) || !Double.isNaN(v2);
    }

}


