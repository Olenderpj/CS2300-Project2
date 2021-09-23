public class Implicit {
    double coeffecientA;
    double coeffecientB;
    double coeffecientC;

    public void printFormula(){
        if (allValuesPersisted()){
            System.out.print("***Formula Placeholder***");

        }
    }

    // returns true if all the values exist and none are empty
    private boolean allValuesPersisted(){
        return !Double.isNaN(coeffecientA) || !Double.isNaN(coeffecientB) || !Double.isNaN(coeffecientC);
    }
}
