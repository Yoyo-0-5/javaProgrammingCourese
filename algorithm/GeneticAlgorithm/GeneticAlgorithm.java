package algorithm.GeneticAlgorithm;


public class GeneticAlgorithm {

	private int[] mask = {0,1,0,0,1,0,1,1,1,1};

	private Chr A1 = new Chr(new int[]{0,5,3,4,8,9,10,2,3,6});
	private Chr A2 = new Chr(new int[]{1,3,6,8,7,5,3,2,1,5});
	private Chr newA1 = new Chr(new int[10]);
	private Chr newA2 = new Chr(new int[10]);


	public GeneticAlgorithm() {
		SinglePoint(5);
		printAll();
		disused();


		TwoPoint(3,5);
		printAll();
		disused();

		Uniform(mask);
		printAll();
	}


	public void printAll() {
		System.out.println("A1: \t" + java.util.Arrays.toString(A1.genes) + " Fitness: " + A1.evaluateFitness());
		System.out.println("A2: \t" + java.util.Arrays.toString(A2.genes) + " Fitness: " + A2.evaluateFitness());
		System.out.println("New A1: " + java.util.Arrays.toString(newA1.genes) + " Fitness: " + newA1.evaluateFitness());
		System.out.println("New A2: " + java.util.Arrays.toString(newA2.genes) + " Fitness: " + newA2.evaluateFitness());
		System.out.println();
	}

	public void SinglePoint(int point) {
		for (int i = 0; i < A1.genes.length; i++) {
			if (i < point) {
				newA1.genes[i] = A1.genes[i];
				newA2.genes[i] = A2.genes[i];
			} else {
				newA1.genes[i] = A2.genes[i];
				newA2.genes[i] = A1.genes[i];
			}
		}
	}

	public void TwoPoint(int point1, int point2) {
		for (int i = 0; i < A1.genes.length; i++) {
			if (i < point1 || i >= point2) {
				newA1.genes[i] = A1.genes[i];
				newA2.genes[i] = A2.genes[i];
			} else {
				newA1.genes[i] = A2.genes[i];
				newA2.genes[i] = A1.genes[i];
			}
		}
	}

	public void Uniform(int[] mask) {
		for (int i = 0; i < A1.genes.length; i++) {
			if (mask[i] == 0) {
				newA1.genes[i] = A1.genes[i];
				newA2.genes[i] = A2.genes[i];
			} else {
				newA1.genes[i] = A2.genes[i];
				newA2.genes[i] = A1.genes[i];
			}
		}
	}

	public void disused() {
		Chr[] pool = new Chr[] { A1, A2, newA1, newA2 };
		java.util.Arrays.sort(pool, new java.util.Comparator<Chr>() {
			@Override
			public int compare(Chr c1, Chr c2) {
				return Integer.compare(c2.evaluateFitness(), c1.evaluateFitness());
			}
		});
		A1 = pool[0];
		A2 = pool[1];
		newA1 = pool[2];
		newA2 = pool[3];
	}

	public static void main(String[] args) {
		new GeneticAlgorithm();
	}

	public class Chr {
		public int[] genes;
		public int fitnessValue;

		public Chr(int[] genes) {
			this.genes = genes;
		}

		public int evaluateFitness() {
			// Dummy fitness evaluation: sum of genes
			int sum = 0;
			for (int gene : genes) {
				sum += gene;
			}
			this.fitnessValue = sum;
			return this.fitnessValue;
		}
	}
}
