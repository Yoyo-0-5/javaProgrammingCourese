package algorithm.DE;

public interface I_Recombination {
	void setGenome(Genome[] genome);
	
	void setDonorVector(DonorVector[] donorVector);
	
	Vector[] getTrivalVector();
	
	void createTrivalVector();
}
