package algorithm.DE;

import java.util.Random;

public class Recombination implements I_Recombination{

	private Genome[] m_genome = null;
	private DonorVector[] m_donorVector = null;
	private TrialVector[] m_trivalVector = null;
	private Random rand = null;
	private Parameter m_parameter = null;
	
	public Recombination(Parameter parameter) {
		m_parameter = parameter;
		init();
	}
	
	public void init() {
		rand = new Random();
		rand.setSeed(m_parameter.getSeed());
		m_trivalVector = new TrialVector[m_parameter.getSwarSize()];
	}
	
	@Override
	public void setGenome(Genome[] genome) {m_genome = genome;}

	@Override
	public void setDonorVector(DonorVector[] donorVector) {m_donorVector = donorVector;}

	@Override
	public Vector[] getTrivalVector() {
		return m_trivalVector;
	}

	@Override
	public void createTrivalVector() {
		for(int i = 0; i < m_parameter.getSwarSize(); i++) {
			//System.out.println(m_parameter.getGenomeDimension());
			//System.out.println(rand);
			int Irand = rand.nextInt(m_parameter.getGenomeDimension());
			m_trivalVector[i] = new TrialVector(new double[m_parameter.getGenomeDimension()]);
			for(int j = 0; j < m_parameter.getGenomeDimension(); j++) {
				if(rand.nextDouble() <= m_parameter.getRecombinationCRfactor()||Irand==j) {
					m_trivalVector[i].setVector(m_donorVector[i].getVector()[j],j);
				}else {
					m_trivalVector[i].setVector(m_genome[i].getVector()[j],j);
				}
				Irand = (Irand+1)%m_parameter.getGenomeDimension();
			}
		}
	}

}
