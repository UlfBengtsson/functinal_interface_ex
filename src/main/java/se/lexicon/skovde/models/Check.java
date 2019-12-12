package se.lexicon.skovde.models;

@FunctionalInterface
public interface Check {
    boolean temperature(double temp);
}
