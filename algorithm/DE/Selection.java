package algorithm.DE;

public class Selection implements I_Selection{

	private Vector[] m_genome = null;
	private Vector[] m_trailVector = null;
	private Genome[] m_targetVector = null;
	private Parameter m_parameter = null;
	
	public Selection(Parameter parameter) {
		m_parameter = parameter;
		init();
	}
	
	private void init() {
		m_trailVector = new Vector[m_parameter.getSwarSize()];
		m_targetVector = new Genome[m_parameter.getSwarSize()];
	}
	
	@Override
	public void setGenome(Genome[] genome) {
		m_genome = genome.clone();
	}

	@Override
	public void setTrivalVector(Vector[] trialVector) {
		m_trailVector = trialVector;
	}

	@Override
	public Genome[] getTargetVector() {
		return m_targetVector;
	}

	@Override
	public void createTargetVector() {
		for(int i = 0; i < m_parameter.getSwarSize(); i++) {
			double genomeFitness = m_parameter.getProblem().calculateFitness(m_genome[i]);
			double trialVectorFitness = m_parameter.getProblem().calculateFitness(m_trailVector[i]);
			if(trialVectorFitness <= genomeFitness) {//choose trialVectorFitness
				m_targetVector[i] = new Genome(m_trailVector[i].getVector().clone(), trialVectorFitness);
			}else {
				m_targetVector[i] = new Genome(m_genome[i].getVector().clone(), genomeFitness);
			}
			
		}
	}

}
