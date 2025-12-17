package algorithm.DE;

public class Parameter {
	private int m_seed = 0;
	private int m_swarSize = 0;
	private int m_max_generation = 0;
	private int m_genomeDimension = 0;
	
	private double m_mutationFactory = 0.0;
	private double m_recombinationCRfactor = 0.0d;
	private Problem m_problem = null;
	
	public Parameter() {
		m_seed = 0;
		m_swarSize = 0;
		m_max_generation = 0;
		m_mutationFactory = 0.0;
		m_recombinationCRfactor = 0.0;
		
	}
	
	public void setSeed(int seed) {m_seed = seed;}
	public void setSwarSize(int size) {m_swarSize = size;}
	public void setMaxGeneration(int maxGeneration) {m_max_generation = maxGeneration;}
	public void setMutationFactory(double mutationFactory) {m_mutationFactory = mutationFactory;}
	public void setRecombinationCRfactor(double recombinationCRfactor) {m_recombinationCRfactor = recombinationCRfactor;}
	public void setProblem(Problem problem) {m_problem = problem;}
	public void setGenomeDimension(int dim) {m_genomeDimension = dim;} 
	
	public int getSeed() {return m_seed;}
	public int getSwarSize() {return m_swarSize;}
	public int getMaxGeneration() {return m_max_generation;}
	public double getMutationFactory() {return m_mutationFactory;}
	public double getRecombinationCRfactor() {return m_recombinationCRfactor;}
	public Problem getProblem() {return m_problem;}
	public int getGenomeDimension() {return m_genomeDimension;}
	
	
	
	
}
