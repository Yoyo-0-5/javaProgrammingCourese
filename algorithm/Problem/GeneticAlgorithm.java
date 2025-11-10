package algorithm.Problem;

import java.util.Arrays;
import java.util.Random;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

// import algorithm.Problem.Knapsack.KnapsackProblem;
import algorithm.Problem.TSP.TSPProblem;

@SuppressWarnings({ "unchecked" })
public class GeneticAlgorithm<T> {
    
    Random rand = new Random();
    Problem<T> problem = (Problem<T>) new TSPProblem(rand);

    private Chromosome<T>[] chromosomes = null;
    private int chromosomeSize = 6;
    private Chromosome<T>[] springs = new Chromosome[4];
    private double crossoverRate = 0.75;
    private double mutationRate = 0.1;
    private int generationSize = 10;

    public GeneticAlgorithm() {

        int numberOfGeneration = 1;

        rand.setSeed(1);

        generateChromosome();

        int i = 0;
        for (Chromosome<T> chr: chromosomes) {
            System.out.print(i + "條染色體:" + Arrays.toString(chr.getGenes()));
            System.out.println("\t" + chr.getFitnessValue());
            i++;
        }

        while (numberOfGeneration <= generationSize) {
            System.out.println("\n 第 " + numberOfGeneration + " 代");

            calculateFitnessValue();

            selection();
            System.out.println("\nSelection 選擇結果");
            i = 0;
            for (Chromosome<T> spr : springs) {
                System.out.print(i + "條染色體:" + Arrays.toString(spr.getGenes()));
                System.out.println("\t" + spr.getFitnessValue());
                i++;
            }

            crossover();
            System.out.println("\nCrossover 交配結果");
            i = 0;
            for (Chromosome<T> spr : springs) {
                System.out.print(i + "條染色體:" + Arrays.toString(spr.getGenes()));
                System.out.println("\t" + spr.getFitnessValue());
                i++;
            }

            mutation();
            System.out.println("\nMutation 突變結果");
            
            calculateSpringFitnessValue();
            
            i = 0;
            for (Chromosome<T> spr : springs) {
                System.out.print(i + "條染色體:" + Arrays.toString(spr.getGenes()));
                System.out.println("\t" + spr.getFitnessValue());
                i++;
            }

            System.out.println("\n完整的 Population (10條)");
            i = 0;
            for (Chromosome<T> chr: chromosomes) {
                System.out.print(i + "條染色體:" + Arrays.toString(chr.getGenes()));
                System.out.println("\t" + chr.getFitnessValue());
                i++;
            }
            for (Chromosome<T> spr : springs) {
                System.out.print(i + "條染色體:" + Arrays.toString(spr.getGenes()));
                System.out.println("\t" + spr.getFitnessValue());
                i++;
            }

            updatePopulation();

            System.out.println("\n第 " + numberOfGeneration + " 次最佳解: " + 
                Arrays.toString(chromosomes[0].getGenes()) + "\t適應值: " + 
                chromosomes[0].getFitnessValue());

            numberOfGeneration++;
        }
    }

    public void generateChromosome() {
        chromosomes = problem.generateChromosomes(chromosomeSize);
    }

    public void calculateFitnessValue() {
        problem.calculateFitness(chromosomes);
    }

    public void selection() {
        LinkedList<Chromosome<T>> population = new LinkedList<>();
        for (Chromosome<T> chr : chromosomes) {
            population.add(chr);
        }

        for (int i = 0; i < springs.length; i++) {
            int randomIndex = rand.nextInt(population.size());
            Chromosome<T> selected = population.remove(randomIndex);
            
            springs[i] = new Chromosome<>();
            springs[i].setGenes((T[]) selected.getGenes());
            springs[i].setFitnessValue(selected.getFitnessValue());
        }
    }

    public void crossover() {
        for (int i = 0; i < springs.length; i += 2) {
            if (rand.nextDouble() < crossoverRate) {
                twoPointCrossover(springs[i], springs[i + 1]);
            }
        }
    }

    public void twoPointCrossover(Chromosome<T> chr1, Chromosome<T> chr2) {
        int first = rand.nextInt(chr1.getGenes().length);
        int second = rand.nextInt(chr1.getGenes().length);

        if (first > second) {
            int temp = first;
            first = second;
            second = temp;
        }

        for (int i = first; i <= second; i++) {
            Object temp = chr1.getGenes()[i];
            chr1.getGenes()[i] = chr2.getGenes()[i];
            chr2.getGenes()[i] = (T) temp;
        }
    }

    public void mutation() {
        for (int i = 0; i < springs.length; i++) {
            for (int j = 0; j < springs[i].getGenes().length; j++) {
                if (rand.nextDouble() < mutationRate) {
                    springs[i].getGenes()[j] = problem.generateGene(j);
                }
            }
        }
    }

    public void calculateSpringFitnessValue() {
        problem.calculateFitness(springs);
    }

    public void updatePopulation() {
        ArrayList<Chromosome<T>> population = new ArrayList<>();
        
        for (Chromosome<T> chr : chromosomes) {
            population.add(chr);
        }
        
        for (Chromosome<T> spr : springs) {
            population.add(spr);
        }

        Collections.sort(population, new Comparator<Chromosome<T>>() {
            @Override
            public int compare(Chromosome<T> o1, Chromosome<T> o2) {
                if (o1.getFitnessValue() > o2.getFitnessValue()) {
                    return 1;
                } else if (o1.getFitnessValue() < o2.getFitnessValue()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        chromosomes = new Chromosome[chromosomeSize];

        for (int i = 0; i < chromosomeSize; i++) {
            chromosomes[i] = new Chromosome<>();
            Chromosome<T> c = population.remove(0);
            chromosomes[i].setGenes((T[]) c.getGenes());
            chromosomes[i].setFitnessValue(c.getFitnessValue());
        }
    }

    public static void main(String[] args) {
        new GeneticAlgorithm<Integer>();
    }
}
