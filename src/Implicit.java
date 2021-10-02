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
                .setV2(coefficientA)
                .setV1(coefficientB);

        var point = new Point();

        if (A > B){
            point.setP1((-1 * coefficientC)/ coefficientA)
                    .setP2(0);
        } else {
            point.setP1(0)
                    .setP2((-1 * coefficientC)/ coefficientB);
        }

        System.out.println("Implicit -> Parametric:");
        System.out.printf("\tl(t) = [%.2f, %.2f] + t[%.2f, %.2f]", point.getP1(), point.getP2(), vector.getV1(), (vector.getV2() * -1));
    }

    public void printPointNormalForm(){

        //TODO: The coefficientB value that is printed here is incorrect - Figure out why!
        double magnitudeA = Math.sqrt((Math.pow(coefficientA, 2)) + (Math.pow(coefficientB, 2)));
        System.out.printf("\t%.1fa + %.1fb + %s = 0", (coefficientA / magnitudeA), (coefficientB/ magnitudeA), String.format("%.2f", coefficientC / magnitudeA));
    }

    public double testIfPointIsOnLine(OrderedPair orderedPair){
        double magnitude = Math.sqrt((Math.pow(coefficientA, 2)) + (Math.pow(coefficientB, 2))); // Correct

        double numerator = (coefficientA * orderedPair.getX() + coefficientB * orderedPair.getY() - coefficientC);

        double result = numerator / magnitude;

        System.out.printf("\n\t%s %s", orderedPair, checkIfPointIsOnTheLine(result));

        return result;
    }

    private String checkIfPointIsOnTheLine(double value){
        if(value == 0){
            return "The point is on the line.";
        } else{
            return " to the point is " + String.format("%.2f", value);
        }
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
