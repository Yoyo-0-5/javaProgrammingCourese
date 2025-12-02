package algorithm.Problem.DE;

public class Genome implements Vector {
    public double[] m_vector = null;
    public double m_fitnessValue = 0.0;

    public Genome() {
    }

    public Genome(double[] vector) {
        setVector(vector);
    }

    public Genome(double[] vector, double fitnessValue) {
        setVector(vector);
        setFitnessValue(fitnessValue);
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

    public double getFitnessValue() {
        return m_fitnessValue;
    }

    public void setFitnessValue(double fitnessValue) {
        this.m_fitnessValue = fitnessValue;
    }

}
