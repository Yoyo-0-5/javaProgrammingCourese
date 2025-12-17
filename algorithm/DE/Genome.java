package algorithm.DE;

public class Genome implements Vector{

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
	
	public void setFitnessValue(double fitnessValue) {
		m_fitnessValue = fitnessValue;
	}
	
	public double getFitnessValue() {
		return m_fitnessValue;
	}

}
