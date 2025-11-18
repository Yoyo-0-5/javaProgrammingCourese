package algorithm.Problem.DE;

public class Bound {
    private double upper;
    private double lower;

    public Bound(double lower, double upper) {
        setUpper(upper);
        setLower(lower);
    }

    public double getUpper() {
        return upper;
    }

    public void setUpper(double upper) {
        this.upper = upper;
    }

    public double getLower() {
        return lower;
    }

    public void setLower(double lower) {
        this.lower = lower;
    }
}
