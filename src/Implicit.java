import java.util.ArrayList;

public class Implicit extends LoggingUtils{
    private double coefficientA;
    private double coefficientB;
    private double coefficientC;
    private ArrayList<OrderedPair> orderedPairsList;

    /**
     * Prints out the implicit form of the line
     */
    public void printImplicitFormula(){
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

    /**
    // calculate the norm of the vector, then divide all coefficients by the norm
     */
    public void printPointNormalForm(){
        double vectorNorm = Math.sqrt((Math.pow(coefficientA, 2)) + (Math.pow(coefficientB, 2)));
        System.out.printf("\t%.1fx1 + %.1fx + %s = 0", (coefficientA / vectorNorm), (coefficientB/ vectorNorm), String.format("%.2f", coefficientC / vectorNorm));
    }

    /**
     * Using the implicit form of a line, the distance of an ordered pair can be tested to determine if it lies on the line.
     * @param orderedPair
     * @return
     */
    public double testIfPointIsOnLine(OrderedPair orderedPair){

        double resultAX = coefficientA * orderedPair.getX();
        double resultBY = coefficientB * orderedPair.getY();
        double resultAXBY = resultAX + resultBY;
        double finalResult = resultAXBY - Math.abs(coefficientC);

        System.out.printf("\n\t%s %s", orderedPair, checkIfPointIsOnTheLine(finalResult));
        return finalResult;

    }

    /**
     * If the parameter is equivlant to 0, then the point is on the line and a message is printed to the screen. Otherwise
     * the distance from the point to the line is printed.
     * @param value
     * @return
     */

    private String checkIfPointIsOnTheLine(double value){
        if(value == 0){
            return " to the line is "+ String.format("%.2f", value) + ", The point is on the line";
        } else{
            return " to the line is " + String.format("%.2f", value);
        }
    }

    // returns true if all the values exist and none are empty
    private boolean allValuesPersisted(){
        return !Double.isNaN(coefficientA) || !Double.isNaN(coefficientB) || !Double.isNaN(coefficientC);
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
