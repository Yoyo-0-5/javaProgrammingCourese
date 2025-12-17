package algorithm.DE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Mutation implements I_Mutation{

	private Genome[] m_genome = null;
	private DonorVector[] m_donorVector = null;
	private double[][][] m_threeVector = null;
	private Random m_rand = null;
	private ArrayList<Integer>SwarmIndex = null;
	private Parameter m_parameter = null;
	
	public Mutation(Parameter paramater) {
		m_parameter = paramater;
		init();
	}
	
	public void init() {
		m_rand = new Random();
		m_rand.setSeed(m_parameter.getSeed());
		m_donorVector = new DonorVector[m_parameter.getSwarSize()];
		m_threeVector = new double[m_parameter.getSwarSize()][3][m_parameter.getGenomeDimension()];
		createSwarmIndex();
	}
	
	private void createSwarmIndex() {
		SwarmIndex = new ArrayList<Integer>();
		for(int i = 0; i < m_parameter.getSwarSize(); i++) {
			SwarmIndex.add(i);
		}
		Collections.shuffle(SwarmIndex, m_rand);
	} 
	
	@Override
	public void setGenome(Genome[] genome) {m_genome = genome.clone();}
	@Override
	public DonorVector[] getDonorVector() {return m_donorVector;}

	@Override
	public void createFourVectors() {
		int nowindex = 0;
		for(int i = 0; i< m_parameter.getSwarSize(); i++) {
			nowindex = getIndex(i);
			boolean flag = nowindex < m_parameter.getSwarSize()/2?true:false;
			m_threeVector[i][0] = m_genome[SwarmIndex.get(flag?++nowindex:--nowindex)].getVector();
			m_threeVector[i][1] = m_genome[SwarmIndex.get(flag?++nowindex:--nowindex)].getVector();
			m_threeVector[i][2] = m_genome[SwarmIndex.get(flag?++nowindex:--nowindex)].getVector();
			Collections.shuffle(SwarmIndex, m_rand);
			
		}
	}

	private int getIndex(int index) {
		for(int i = 0; i < SwarmIndex.size(); i++) {
			if(SwarmIndex.get(i).intValue() == index) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public void createDonorVectors() {
		createFourVectors();
		for(int i = 0; i < m_parameter.getSwarSize(); i++) {
			m_donorVector[i] = new DonorVector(new double[m_parameter.getGenomeDimension()]);
			for(int j = 0; j < m_parameter.getGenomeDimension(); j++) {
				double value = (m_threeVector[i][0][j]) + F(m_threeVector[i][1][j] - m_threeVector[i][2][j]);
				value = value >= m_parameter.getProblem().getBound()[j].getUpper()?	
						m_parameter.getProblem().getBound()[j].getUpper()://true	
							value < m_parameter.getProblem().getBound()[j].getLower()?	
									m_parameter.getProblem().getBound()[j].getLower():value;
				m_donorVector[i].setVector(value, j);
			}
		}
	}
	
	private double F(double v) {
		return m_parameter.getMutationFactory()*v;
	}

}
