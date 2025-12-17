package algorithm.DE;

import java.util.ArrayList;
import java.util.Random;

public class TSPProblem implements Problem{

	Random r = null;
	
	public TSPProblem(Random r) {
		this.r = r;
	}
	
	public int[][] cityDistance = new int[][] {
		{0,1,2,4,5,2,2,3},
		{1,0,1,3,2,1,3,4},
		{2,1,0,4,2,2,1,5},
		{4,3,4,0,3,4,2,1},
		{5,2,2,3,0,2,3,1},
		{2,1,2,4,2,0,4,2},
		{2,3,1,2,3,4,0,2},
		{3,4,5,1,1,2,2,0}
	};
	
	@Override
	public Genome[] generateGenomes(int size) {
		double[] genes = new double[cityDistance.length];
		Genome[] chrs = new Genome[size];
		for(int i = 0; i < chrs.length; i++) {
			for(int j = 0; j < genes.length; j++) {
				genes[j] = r.nextInt(cityDistance.length-j);
			}
			chrs[i] = new Genome();
			chrs[i].setVector(genes);
		}
		
		return chrs;
	}

	@Override
	public double generateGene(int index) {
		return r.nextInt(cityDistance.length - index);
	}

	@Override
	public double calculateFitness(Vector chrs) {
		double distance = 0.0;
		double[] lehmer = lehmerCode(chrs.getVector());
		for(int j = 1; j < lehmer.length; j++) {
			int cite1 = (int)lehmer[j-1];
			int cite2 = (int)lehmer[j];
			distance = distance + cityDistance[cite1][cite2];
		}
		int cite1 = (int)lehmer[lehmer.length-1];
		int cite2 = (int)lehmer[0];
		distance = distance + cityDistance[cite1][cite2];
		return distance;
		
	}
	
	private double[] lehmerCode(double[] object) {
		double[] lehmer = new double[object.length];
		ArrayList<Integer>cites = new ArrayList<Integer>();
		for(int i = 0; i < cityDistance.length; i++) {
			cites.add(i);
		}
		for(int i = 0; i < object.length; i++) {
			lehmer[i] = cites.remove((int)object[i]);
		}
		return lehmer;
	}

	@Override
	public Bound[] getBound() {
		Bound[] bounds = new Bound[cityDistance.length];
		for(int i = 0; i < bounds.length; i++) {
			bounds[i] = new Bound(0, cityDistance.length - i - 1);
		}
		return bounds;
	}

	@Override
	public int getDimensionSize() {
		return cityDistance.length;
	}

	@Override
	public String getProblemName() {
		return "TSP problem";
	}

}
