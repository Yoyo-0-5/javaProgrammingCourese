package algorithm.DE;

public interface I_Mutation {
	void setGenome(Genome[] genome);
	
	Vector[] getDonorVector();
	
	void createFourVectors();
	
	void createDonorVectors();
}
