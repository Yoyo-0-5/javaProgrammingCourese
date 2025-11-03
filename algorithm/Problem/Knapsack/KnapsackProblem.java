package algorithm.Problem.Knapsack;

import algorithm.Problem.*;
import java.util.Random;

public class KnapsackProblem implements Problem<Boolean> {
    
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

    @SuppressWarnings("unchecked")
    @Override
    public Chromosome<Boolean>[] generateChromosomes(int size) {
        Boolean[] genes = new Boolean[products.length];
        Chromosome<Boolean>[] chromosomes = new Chromosome[size];
        for (int i = 0; i < chromosomes.length; i++) {
            for (int j = 0; j < genes.length; j++) {
                genes[j] = rand.nextBoolean();
            }
            chromosomes[i] = new Chromosome<Boolean>(genes);
            chromosomes[i].setGenes(genes);
        }
        return chromosomes;
    }

    @Override
    public Boolean generateGene(int index) {
        return rand.nextBoolean();
    }

    @Override
    public void calculateFitness(Chromosome<Boolean>[] chromosomes) {
        double totalValue = 0.0d;
        double totalWeight = 0.0d;
        for(int i = 0; i < chromosomes.length; i++) {
            totalValue = 0.0d;
            totalWeight = 0.0d;
            for(int j = 0; j < chromosomes[i].getGenes().length; j++) {
                if(chromosomes[i].getGenes()[j]) {
                    totalValue += products[j].getValue();
                    totalWeight += products[j].getWeight();
                }
                if(totalWeight > maxWeight) {
                    totalValue = 0.0d;
                    break;
                }
            }
            chromosomes[i].setFitnessValue(totalValue);
        }
    }

}
