package algorithm.Problem;

public class Chromosome<T> {
    private T[] genes = null;
    private double fitnessValue = 0.0;

    public Chromosome(T[] genes) {
        this.genes = genes;
    }

    public T[] getGenes() {
        return genes;
    }

    public void setGenes(T[] genes) {
        this.genes = genes.clone();
    }

    public double getFitnessValue() {
        return fitnessValue;
    }

    public void setFitnessValue(double fitnessValue) {
        this.fitnessValue = fitnessValue;
    }

    
}
