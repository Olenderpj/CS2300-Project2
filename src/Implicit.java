import java.util.ArrayList;

public class Implicit extends LoggingUtils{
    private double coefficientA;
    private double coefficientB;
    private double coefficientC;
    private ArrayList<OrderedPair> orderedPairsList;

    public void printFormula(){
        if (!allValuesPersisted()){
            printMissingValueError();

        } else {
            String equation = "";

            if (coefficientA < 0){
                equation += "(" + coefficientA + ")a + ";
            } else {
                equation+= coefficientA + "a + ";
            }

            if (coefficientB < 0){
                equation += "(" + coefficientB + ")b + ";
            } else {
                equation+= coefficientB + "b + ";
            }

            if (coefficientC < 0){
                equation += "(" + coefficientC + ") = 0";
            } else {
                equation+= coefficientC + " = 0";
            }
            System.out.println("\t" + equation);
        }
    }

    /**
     *  Parametric generic form = l: l(t) = p + t * v
     */
    public void printParametricForm(){
        double A = Math.abs(coefficientA);
        double B = Math.abs(coefficientB);

        var vector = new Vector()
                .setA(coefficientA)
                .setB(coefficientB);

        var point = new Point();

        if (A > B){
            point.setP1((-1 * coefficientC)/ coefficientA)
                    .setP2(0);
        } else {
            point.setP1(0)
                    .setP2((-1 * coefficientC)/ coefficientB);
        }

        System.out.println("Implicit -> Parametric:");
        System.out.printf("\tl(t) = [%.2f, %.2f] + t[%.2f, %.2f]", point.getP1(), point.getP2(), vector.getB(), (vector.getA() * -1));
    }

    public void printPointNormalForm(){

    }

    public void printDistanceFromPoint(){

    }


    // returns true if all the values exist and none are empty
    private boolean allValuesPersisted(){
        return !Double.isNaN(coefficientA) || !Double.isNaN(coefficientB) || !Double.isNaN(coefficientC);
    }

    public double getCoefficientA() {
        return coefficientA;
    }

    public double getCoefficientB() {
        return coefficientB;
    }

    public double getCoefficientC() {
        return coefficientC;
    }

    public ArrayList<OrderedPair> getOrderedPairsList() {
        return orderedPairsList;
    }

    public Implicit setCoefficientA(double coefficientA) {
        this.coefficientA = coefficientA;
        return this;
    }

    public Implicit setCoefficientB(double coefficientB) {
        this.coefficientB = coefficientB;
        return this;
    }

    public Implicit setCoefficientC(double coefficientC) {
        this.coefficientC = coefficientC;
        return this;
    }

    public Implicit setOrderedPairsList(ArrayList<OrderedPair> orderedPairsList) {
        this.orderedPairsList = orderedPairsList;
        return this;
    }
}
