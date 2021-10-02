import java.util.ArrayList;

public class Parametric extends LoggingUtils{
    private Vector p;
    private Vector v;
    private ArrayList<OrderedPair> orderedPairsList;

    public void printFormula(){
            System.out.println("Parametric form:");
            System.out.printf("\tl(t) = %s + t%s", p, v);
    }

    //TODO: Print implicit form - Finish this method.
    public void printImplicitForm(){
        System.out.println("Parametric -> Implicit:");

        var vectorA = new Vector()
                .setV1(-1 * (v.getV2()))
                .setV2(v.getV1());

        double c = -1 * ((vectorA.getV1() * p.getV1()) + (vectorA.getV2() * p.getV2()));

        System.out.printf("\t%.2fa + %.2fb + %.2f = 0", vectorA.getV1(), vectorA.getV2(), c);

    }

    public Implicit convertParametricToImplicit(){

        var vectorA = new Vector()
                .setV1(-1 * (v.getV2()))
                .setV2(v.getV1());

        double c = -1 * ((vectorA.getV1() * p.getV1()) + (vectorA.getV2() * p.getV2()));

        return new Implicit()
                .setCoefficientA(vectorA.getV2())
                .setCoefficientB(vectorA.getV1())
                .setCoefficientC(c);
    }


    public Parametric setP(Vector p) {
        this.p = p;
        return this;
    }

    public Parametric setV(Vector v) {
        this.v = v;
        return this;
    }

    public Parametric setOrderedPairsList(ArrayList<OrderedPair> orderedPairsList) {
        this.orderedPairsList = orderedPairsList;
        return this;
    }
}


