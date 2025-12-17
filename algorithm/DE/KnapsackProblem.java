package algorithm.DE;

import java.util.Random;

public class KnapsackProblem implements Problem{

	Random r = null;
	Product[] product = new Product[] {
		new Product("Green", 12.0, 4.0),
		new Product("Blue", 2.0, 2.0),
		new Product("Gray", 1.0, 2.0),
		new Product("Yellow", 4.0, 10.0)
	};
	double limitedWeight = 15.0;
	
	public KnapsackProblem(Random r) {
		this.r = r;
	}
	
	@Override
	public Genome[] generateGenomes(int size) {
		double[] genes = new double[product.length];
		Genome[] chrs = new Genome[size];
		
		for(int i = 0; i < chrs.length; i++) {
			for(int j = 0; j < genes.length; j++) {
				genes[j] = r.nextBoolean()?1:0;
			}
			chrs[i] = new Genome();
			chrs[i].setVector(genes);
		}
		return chrs;
	}

	@Override
	public double generateGene(int index) {
		return r.nextBoolean()?1:0;
	}

	@Override
	public double calculateFitness(Vector chrs) {
		double totalValue = 0.0d;
		double totalWeight = 0.0d;
		
		totalValue = 0.0d;
		totalWeight = 0.0d;
		for(int j = 0; j < chrs.getVector().length; j++) {
			if(chrs.getVector()[j] == 1) {
				totalValue = totalValue + product[j].getValue();
				totalWeight = totalWeight + product[j].getWeight();
			}
			if(totalWeight > limitedWeight) {
				totalValue = 0.0;
				break;
			}
		}
		return totalValue;
	}

	@Override
	public Bound[] getBound() {
		Bound[] bounds = new Bound[product.length];
		for(int i = 0; i < bounds.length; i++) {
			bounds[i] = new Bound(0, 1);
		}
		return bounds;
	}

	@Override
	public int getDimensionSize() {
		return product.length;
	}

	@Override
	public String getProblemName() {
		return "KnapsackProblem";
	}

}
