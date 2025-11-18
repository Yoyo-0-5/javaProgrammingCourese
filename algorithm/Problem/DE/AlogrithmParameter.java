package algorithm.Problem.DE;

import algorithm.Problem.Problem;

public class AlogrithmParameter {
    private int m_seed = 0;
    private int m_swarmSize = 0;
    private int m_max_generations = 0;

    private double m_mutationFactor = 0.0;
    private double m_recombinationCRfactor = 0.0d;
    private Problem m_problem = null;

    public AlogrithmParameter(){
        m_seed = 0;
        m_swarmSize = 0;
        m_max_generations = 0;
        m_mutationFactor = 0.0;
        m_recombinationCRfactor = 0.0;
    }

    public int getSeed() {
        return m_seed;
    }

    public void setSeed(int seed) {
        this.m_seed = seed;
    }

    public int getSwarmSize() {
        return m_swarmSize;
    }

    public void setSwarmSize(int swarmSize) {
        this.m_swarmSize = swarmSize;
    }

    public int getMaxGenerations() {
        return m_max_generations;
    }

    public void setMaxGenerations(int max_generations) {
        this.m_max_generations = max_generations;
    }

    public double getMutationFactor() {
        return m_mutationFactor;
    }

    public void setMutationFactor(double mutationFactor) {
        this.m_mutationFactor = mutationFactor;
    }

    public double getRecombinationCRfactor() {
        return m_recombinationCRfactor;
    }

    public void setRecombinationCRfactor(double recombinationCRfactor) {
        this.m_recombinationCRfactor = recombinationCRfactor;
    }

    public Problem getProblem() {
        return m_problem;
    }

    public void setProblem(Problem problem) {
        this.m_problem = problem;
    }
}

