package se.lexicon.skovde.models;

public class WaterStateChange implements Check {

    //Boiling point of water	    212°F	    100°C
    @Override
    public boolean temperature(double temp) {
        return temp >= 100;
    }
}
