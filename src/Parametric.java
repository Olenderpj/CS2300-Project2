public class Parametric {
    private static double p1;
    private static double p2;
    private static double v1;
    private static double v2;

    public void printFormula(){
        if (allValuesPersisted()){
            System.out.print("***Formula Placeholder***");
        }
    }

    // returns true if all the values exist and none are empty
    private boolean allValuesPersisted(){
        return !Double.isNaN(p1) || !Double.isNaN(p2) || !Double.isNaN(v1) || !Double.isNaN(v2);
    }
}


