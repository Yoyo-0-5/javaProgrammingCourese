package algorithm.DE;

public interface Problem{

	public Genome[] generateGenomes(int size);
	
	public double generateGene(int index);
	
	public double calculateFitness(Vector chrs);
	
	public Bound[] getBound();
	
	public int getDimensionSize();
	
	public String getProblemName();
}
