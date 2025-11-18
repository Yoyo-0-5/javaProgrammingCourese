package algorithm.Problem.DE;

public class TrialVector implements Vector {
    public double[] m_vector = null;

    public TrialVector() {
    }

    public TrialVector(double[] vector) {
        setVector(vector);
    }

    @Override
    public void setVector(double[] vector) {
        this.m_vector = vector.clone();
    }

    @Override
    public void setVector(double vector, int index) {
        this.m_vector[index] = vector;
    }

    @Override
    public double[] getVector() {
        return this.m_vector.clone();
    }
}
