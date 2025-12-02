package algorithm.Problem.DE;

import java.util.Random;

public class KnapsackProblem implements Problem {
    
    Random rand = null;

    Product[] products = new Product[]{
        new Product("Green", 12.0, 4.0),
        new Product("Blue", 2.0, 2.0),
        new Product("Gray", 1.0, 2.0),
        new Product("Yellow", 4.0, 10.0)
    };

    double maxWeight = 15.0d;

    public KnapsackProblem(Random rand) {
        // 將外部傳入的 Random 指定給本類別使用，避免為 null 造成 NPE
        this.rand = rand;
    }

    
    @Override
    public Genome[] generateGenomes(int size) {
        double[] genes = new double[products.length];
        Genome[] chrs = new Genome[size];
        for (int i = 0; i < chrs.length; i++) {
            for (int j = 0; j < genes.length; j++) {
                genes[j] = rand.nextBoolean() ? 1.0d : 0.0d;
            }
            chrs[i] = new Genome();
            chrs[i].setVector(genes);
        }
        return chrs;
    }

    @Override
    public double generateGene(int index) {
        return rand.nextBoolean() ? 1.0d : 0.0d;
    }

    @Override
    public void calculateFitness(Genome[] chrs) {
        double totalValue = 0.0d;
        double totalWeight = 0.0d;
        for(int i = 0; i < chrs.length; i++) {
            totalValue = 0.0d;
            totalWeight = 0.0d;
            for(int j = 0; j < chrs[i].getVector().length; j++) {
                if(chrs[i].getVector()[j] == 1.0d) {
                    totalValue += products[j].getValue();
                    totalWeight += products[j].getWeight();
                }
                if(totalWeight > maxWeight) {
                    totalValue = 0.0d;
                    break;
                }
            }
            chrs[i].setFitnessValue(totalValue);
        }
    }

}
