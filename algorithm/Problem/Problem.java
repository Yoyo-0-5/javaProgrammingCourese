package algorithm.Problem;

public interface Problem<T> {
    public Chromosome<T>[] generateChromosomes(int size);
    public T generateGene(int index);
    public void calculateFitness(Chromosome<T>[] chromosomes);
}
