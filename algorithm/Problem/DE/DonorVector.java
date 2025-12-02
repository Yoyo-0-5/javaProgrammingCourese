package algorithm.Problem.DE;

public class DonorVector implements Vector {
    public double[] m_vector = null;

    public DonorVector() {

    }

    public DonorVector(double[] vector) {
        this.m_vector = vector.clone();
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
