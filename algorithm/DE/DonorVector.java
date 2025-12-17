package algorithm.DE;

public class DonorVector implements Vector{
	
	public double[] m_vector = null;

	public DonorVector() {
		
	}
	
	public DonorVector(double[] vector) {
		setVector(vector);
	}
	
	@Override
	public void setVector(double[] vector) {
		m_vector = vector.clone();
	}

	@Override
	public double[] getVector() {
		return m_vector.clone();
	}

	@Override
	public void setVector(double value, int index) {
		m_vector[index] = value;
	}

}
