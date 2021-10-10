import java.util.ArrayList;

public class Parametric extends LoggingUtils{
    private Vector point;
    private Vector vector;
    private ArrayList<OrderedPair> orderedPairsList;

    /**
     * prints the parametric formula of a line
     */
    public void printFormula(){
            System.out.println("Parametric form:");
            System.out.printf("\tl(t) = %s + t%s", point, vector);
    }

    /**
     * Using the parametric data, the implicit formula is generated.
     */
    public void printImplicitForm(){

        var vectorA = new Vector()
                .setV1(-1 * (vector.getV2()))
                .setV2(vector.getV1());

        double c = -1 * ((vectorA.getV1() * point.getV1()) + (vectorA.getV2() * point.getV2()));

        System.out.printf("\t%.2fa + %.2fb + %.2f = 0", vectorA.getV1(), vectorA.getV2(), c);

    }

    /**
     * Converts the parametric form to implicit and creates an object of the implicit form.
     * @return
     */
    public Implicit convertParametricToImplicit(){

        var vectorA = new Vector()
                .setV1(-1 * (vector.getV2()))
                .setV2(vector.getV1());

        double c = -1 * ((vectorA.getV1() * point.getV1()) + (vectorA.getV2() * point.getV2()));

        return new Implicit()
                .setCoefficientA(vectorA.getV2())
                .setCoefficientB(vectorA.getV1())
                .setCoefficientC(c)
                .setOrderedPairsList(orderedPairsList);
    }

    public Parametric setPoint(Vector point) {
        this.point = point;
        return this;
    }

    public Parametric setVector(Vector vector) {
        this.vector = vector;
        return this;
    }

    public Parametric setOrderedPairsList(ArrayList<OrderedPair> orderedPairsList) {
        this.orderedPairsList = orderedPairsList;
        return this;
    }
}


