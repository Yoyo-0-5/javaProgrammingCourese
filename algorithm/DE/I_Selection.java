package algorithm.DE;

public interface I_Selection {
	void setGenome(Genome[] genome);
	
	void setTrivalVector(Vector[] trialVector);
	
	Genome[] getTargetVector();
	
	void createTargetVector();
}
