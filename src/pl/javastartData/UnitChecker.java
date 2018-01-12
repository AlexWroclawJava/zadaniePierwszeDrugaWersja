package pl.javastartData;

public class UnitChecker {

    public static String METERS = "metr";
    public static String CENTIMETERS = "centr";
    public static String MILIMETERS = "milr";

    public static String KILOGRAMS = "kilgr";
    public static String GRAMS = "grs";
    public static String MILIGRAMS = "miligr";

    public String getUnitMeasureFromRequestParameters(String meters, String centimeters, String milimiters) {
        if (!meters.isEmpty()) {
            return METERS;
        }
        if (!centimeters.isEmpty()) {
            return CENTIMETERS;
        }
        else
            return MILIMETERS;
        }


    public String getUnitWeightFromRequestParameters(String kilograms, String grams, String miligrams) {
        if (!kilograms.isEmpty()) {
            return KILOGRAMS;
        }
        if (!grams.isEmpty()) {
            return GRAMS;
        }
        else
            return MILIGRAMS;
    }
}
