public class OrderedPair {
    double x;
    double y;

    public OrderedPair(double inputX, double inputY){
        this.x = inputX;
        this.y = inputY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public OrderedPair getX(double x) {
        this.x = x;
        return this;
    }

    public OrderedPair getY(double y) {
        this.y = y;
        return this;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ") ";
    }
}
