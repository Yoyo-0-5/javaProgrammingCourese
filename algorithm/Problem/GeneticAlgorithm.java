package algorithm.Problem;

import java.util.Arrays;
import java.util.Random;
import java.util.Comparator;

import algorithm.Problem.Knapsack.KnapsackProblem;

@SuppressWarnings("unchecked")
public class GeneticAlgorithm<T> {
    
    Random rand = new Random();
    Problem<T> problem = (Problem<T>) new KnapsackProblem(rand);

    private Chromosome<T>[] chromosome = null;
    private int chromosomeSize = 6;
    private Chromosome<T>[] springs = new Chromosome[4];
    private double crossoverRate = 0.75d;
    private double mutationRate = 0.1d;
    private int generationSize = 2;
    public GeneticAlgorithm() {
        rand.setSeed(2);
        
        generateChromosome();
        problem.calculateFitness(chromosome);
        printPopulation("初代");

        for (int gen = 1; gen <= generationSize; gen++) {
            evolveOneGeneration();
            printPopulation("第 " + gen + " 代");
        }
    }

    public void generateChromosome() {
        chromosome = problem.generateChromosomes(chromosomeSize);
    }

    
    private void printPopulation(String title) {
        System.out.println("\n" + title);
        int i = 1;
        for (Chromosome<T> chr : chromosome) {
            System.out.print(i + " 條染色體 : " + Arrays.toString(chr.getGenes()));
            System.out.println(" 適應值 : " + chr.getFitnessValue());
            i++;
        }
    }

    private void evolveOneGeneration() {
        for (int i = 0; i < springs.length; i += 2) {
            Chromosome<T> p1 = selectParent();
            Chromosome<T> p2 = selectParent();
            Chromosome<T>[] children = crossover(p1, p2);
            mutate(children[0]);
            mutate(children[1]);
            springs[i] = children[0];
            if (i + 1 < springs.length) springs[i + 1] = children[1];
        }

        problem.calculateFitness(springs);

        Chromosome<T>[] merged = (Chromosome<T>[]) new Chromosome[chromosome.length + springs.length];
        System.arraycopy(chromosome, 0, merged, 0, chromosome.length);
        System.arraycopy(springs, 0, merged, chromosome.length, springs.length);
        Arrays.sort(merged, Comparator.comparingDouble(Chromosome<T>::getFitnessValue).reversed());

        chromosome = (Chromosome<T>[]) new Chromosome[chromosomeSize];
        System.arraycopy(merged, 0, chromosome, 0, chromosomeSize);
    }

    private Chromosome<T> selectParent() {
        Chromosome<T> best = null;
        for (int i = 0; i < 3; i++) {
            Chromosome<T> cand = chromosome[rand.nextInt(chromosome.length)];
            if (best == null || cand.getFitnessValue() > best.getFitnessValue()) {
                best = cand;
            }
        }
        return cloneChromosome(best);
    }

    private Chromosome<T>[] crossover(Chromosome<T> p1, Chromosome<T> p2) {
        T[] g1 = p1.getGenes();
        T[] g2 = p2.getGenes();

        T[] c1 = g1.clone();
        T[] c2 = g2.clone();

        if (rand.nextDouble() < crossoverRate && g1.length > 1) {
            int cut = 1 + rand.nextInt(g1.length - 1);
            for (int i = cut; i < g1.length; i++) {
                T tmp = c1[i];
                c1[i] = c2[i];
                c2[i] = tmp;
            }
        }

        Chromosome<T> child1 = new Chromosome<>(c1);
        child1.setGenes(c1);
        Chromosome<T> child2 = new Chromosome<>(c2);
        child2.setGenes(c2);
        return new Chromosome[] { child1, child2 };
    }

    private void mutate(Chromosome<T> chr) {
        T[] genes = chr.getGenes();
        for (int i = 0; i < genes.length; i++) {
            if (rand.nextDouble() < mutationRate) {
                genes[i] = problem.generateGene(i);
            }
        }
        chr.setGenes(genes);
    }

    private Chromosome<T> cloneChromosome(Chromosome<T> src) {
        T[] g = src.getGenes().clone();
        Chromosome<T> copy = new Chromosome<>(g);
        copy.setGenes(g);
        copy.setFitnessValue(src.getFitnessValue());
        return copy;
    }

    public static void main(String[] args) {
        new GeneticAlgorithm<Boolean>();
    }
}
