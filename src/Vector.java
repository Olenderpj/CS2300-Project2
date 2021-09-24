public class Vector {
    private double B;
    private double A;

    public double getB() {
        return B;
    }

    public double getA() {
        return A;
    }

    public Vector setB(double B) {
        this.B = B;
        return this;
    }

    public Vector setA(double A) {
        this.A = A;
        return this;
    }

    @Override
    public String toString() {
        return "[" + A + " " + B + "]";
    }
}
