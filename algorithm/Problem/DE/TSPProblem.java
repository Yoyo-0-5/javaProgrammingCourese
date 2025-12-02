package algorithm.Problem.DE;

import java.util.ArrayList;
import java.util.Random;


public class TSPProblem implements Problem {

    private int[][] citeDistance = new int[][]{
        {0, 1, 2, 4, 5, 2, 2, 3},
        {1, 0, 1, 3, 2, 1, 3, 4},
        {2, 1, 0, 4, 2, 2, 1, 5},
        {4, 3, 4, 0, 3, 4, 2, 1},
        {5, 2, 2, 3, 0, 2, 3, 1},
        {2, 1, 2, 4, 2, 0, 4, 2},
        {2, 3, 1, 2, 3, 4, 0, 2},
        {3, 4, 5, 1, 1, 2, 2, 0}
    };

    private Random rand = null;


    public TSPProblem(Random rand) {
        this.rand = rand;
    }

    @Override
    public Genome[] generateGenomes(int size) {
        double[] genes = new double[citeDistance.length];
        Genome[] chrs = new Genome[size];
        for (int i = 0; i < chrs.length; i++) {
            for (int j = 0; j < genes.length; j++) {
                genes[j] = rand.nextInt(citeDistance.length - j);
            }
            chrs[i] = new Genome();
            chrs[i].setVector(genes);
        }
        return chrs;
    }

    @Override
    public double generateGene(int index) {
        return rand.nextInt(citeDistance.length - index);
    }

    @Override
    public void calculateFitness(Genome[] chromosomes) {
        for (int i = 0; i < chromosomes.length; i++) {
            int distance = 0;
            double[] lehmer = lehmerCode(chromosomes[i].getVector());
            for (int j = 1; j < lehmer.length; j++) {
                int cite1 = (int)lehmer[j - 1];
                int cite2 = (int)lehmer[j];
                distance = distance + citeDistance[cite1][cite2];
            }
            int cite1 = (int)lehmer[lehmer.length - 1];
            int cite2 = (int)lehmer[0];
            distance = distance + citeDistance[cite1][cite2];
            chromosomes[i].setFitnessValue(distance);
        }
    }

    private double[] lehmerCode(double[] objects) {
        double[] lehmer = new double[objects.length];
        ArrayList<Integer> cites = new ArrayList<Integer>();
        for (int i = 0; i < citeDistance.length; i++) {
            cites.add(i);
        }
        for(int i = 0; i < objects.length; i++) {
            lehmer[i] = cites.remove((int)objects[i]);
        }
        return lehmer;
    }

}
