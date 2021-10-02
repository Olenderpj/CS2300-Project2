public class Vector {
    private double v1;
    private double v2;

    public double getV1() {
        return v1;
    }

    public double getV2() {
        return v2;
    }

    public Vector setV1(double B) {
        this.v1 = B;
        return this;
    }

    public Vector setV2(double A) {
        this.v2 = A;
        return this;
    }

    @Override
    public String toString() {
        return "[" + v2 + " " + v1 + "]";
    }
}
