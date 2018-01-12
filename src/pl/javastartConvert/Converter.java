package pl.javastartConvert;
import pl.javastartData.Data;

public class Converter {
    private double zmienna;

    public double milimitersToMeters(Double mm){
       return mm / 1000;
    }
    public double milimitersToCentimeters(Double mm){
        return mm / 10;
    }

    public double centimitersToMeters(Double cm){
        return cm / 100;
    }
    public double centimitersToMilimeters(Double cm){ return cm * 10; }

    public double metersToCentimeters(Double m){
        return m * 100;
    }
    public double metersToMilimeters(Double m){
        return m * 1000;
    }

    public double kilosToGrams(Double kg) { return (kg) * 100;    }
    public double kilosToMiligrams(Double kg) { return kg * 1000000;
    }
    public double gramsToKilos(Double gm) { return gm / 1000;    }
    public double gramsToMiligrams(Double gm) { return gm * 1000; }

    public double miligramsToKilos(Double mg) { return mg / 1000000; }
    public double miligramsToGrams(Double mg) { return mg / 1000;}

}