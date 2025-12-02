package algorithm.Problem.DE;

public interface Problem {
    public Genome[] generateGenomes(int size);
    public double generateGene(int index);
    public void calculateFitness(Genome[] chromosomes);
}
