package algorithm.DE;

public class TrialVector implements Vector{

	public double[] m_vector = null;
	
	public TrialVector() {
		
	}
	
	public TrialVector(double[] vector) {
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
