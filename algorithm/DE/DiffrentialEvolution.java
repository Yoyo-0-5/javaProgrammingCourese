package algorithm.DE;

import java.util.Arrays;
import java.util.Random;

public class DiffrentialEvolution {

	Random rand = new Random();
	private Vector[] m_trialVector = null;
	private DonorVector[] m_donorVector = null;
	private Genome[] m_targetVector = null;
	private Mutation m_mutation = null;
	private Recombination m_recombination = null;
	private Selection m_selection = null;
	Parameter m_parameter = null;
	
	
	public DiffrentialEvolution(Parameter parameter, Random rand) {
		this.rand = rand;
		this.rand.setSeed(2);
		int numberOfGeneration = 1;
		m_parameter = parameter;
		m_mutation = new Mutation(m_parameter);
		m_recombination = new Recombination(m_parameter);
		m_selection = new Selection(m_parameter);
		generateGenome();//s1
		
		while(numberOfGeneration <= m_parameter.getMaxGeneration()) {
			mutation();
			recombination();
			selection();
			System.out.println("第" + numberOfGeneration + "次迭代");
			for(Genome g:m_targetVector) {
				System.out.println(Arrays.toString(g.getVector()) + "\tFitness= " + g.getFitnessValue());
			}
			numberOfGeneration++;
		}
		
	}
	
	private void mutation() {
		m_mutation.setGenome(m_targetVector);
		m_mutation.createDonorVectors();
		m_donorVector = m_mutation.getDonorVector().clone();
	}
	
	private void recombination() {
		m_recombination.setDonorVector(m_donorVector);
		m_recombination.setGenome(m_targetVector);
		m_recombination.createTrivalVector();
		m_trialVector = m_recombination.getTrivalVector().clone();
	}
	
	private void selection() {
		m_selection.setGenome(m_targetVector);
		m_selection.setTrivalVector(m_trialVector);
		m_selection.createTargetVector();
		m_targetVector = m_selection.getTargetVector().clone();
		
	}
	
	private void generateGenome() {
		m_targetVector = m_parameter.getProblem().generateGenomes(m_parameter.getSwarSize());
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		Parameter parameter = new Parameter();
		parameter.setMaxGeneration(100);
		parameter.setRecombinationCRfactor(0.5);
		parameter.setSwarSize(10);
		parameter.setMutationFactory(0.5);
		parameter.setProblem(new TSPProblem(rand));
		parameter.setGenomeDimension(parameter.getProblem().getDimensionSize());
		new DiffrentialEvolution(parameter, rand);
	}
	
}
