package se.lexicon.skovde;

import se.lexicon.skovde.models.Check;
import se.lexicon.skovde.models.WaterStateChange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**********************************************************
 Water

 Boiling point of water	    212°F	    100°C
 Freezing point of water	32°F	    0°C
 Absolute zero	            -459.6°F	-273.1°C

 **********************************************************
 Person

 Hypothermia	        <35.0°C	            95.0°F
 Normal	                36.5 - 37.5°C	    97.7 - 99.5°F
 Fever / Hyperthermia	>37.5 or 38.3°C	    99.5 or 100.9°F
 Hyperpyrexia	        >40.0 or 41.5°C	    104.0 or 106.7°F

 ***********************************************************/
public class App 
{
    public static void main( String[] args )
    {
        moreFuncInterLambda();
    }

    public static void funcInterClass()
    {
        WaterStateChange waterBoil = new WaterStateChange();

        System.out.println( waterBoil.temperature(122.2) );
    }

    public static void funcInterAnonInnerClass()
    {
        Check waterBoil = new Check() {
            @Override
            public boolean temperature(double temp) {
                return temp >= 100;
            }
        };

        Check waterFreeze = new Check() {
            @Override
            public boolean temperature(double temp) {
                return temp <= 0;
            }
        };

        System.out.println(waterBoil.temperature(90));
        System.out.println(waterFreeze.temperature(-90));
    }

    public static void funcInterLambda()
    {
        //Celsius
        Check waterBoil = temp -> temp >= 100;
        Check waterFreeze = temp -> temp <= 0;

        //Fahrenheit
        Check waterBoilF = temp -> temp >= 212;
        Check waterFreezeF = temp -> temp <= 32;

        System.out.println(waterBoil.temperature(190));
        System.out.println(waterFreeze.temperature(10));

        System.out.println(waterBoilF.temperature(190));
        System.out.println(waterFreezeF.temperature(10));
    }

    public static void moreFuncInterLambda()
    {
        //Celsius
        Check waterBoil = temp -> temp >= 100;
        Check waterFreeze = temp -> temp <= 0;

        //Fahrenheit
        Check waterBoilF = temp -> temp >= 212;
        Check waterFreezeF = temp -> temp <= 32;

        List<Double> temps = new ArrayList<>();
        temps.add(12.2);
        temps.add(122.2);
        temps.add(-12.2);
        temps.add(32.2);
        temps.add(22.2);

        /*
        for (double temp : temps ) {
            System.out.println(waterBoil.temperature(temp));
        }
        */

        //temps.forEach(System.out::println);
        temps.forEach(temp -> {System.out.println(temp + " : " +waterBoil.temperature(temp));});

    }
}
