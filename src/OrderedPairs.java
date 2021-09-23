public class OrderedPairs {
    double x;
    double y;



    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public OrderedPairs getX(double x) {
        this.x = x;
        return this;
    }

    public OrderedPairs getY(double y) {
        this.y = y;
        return this;
    }
}
