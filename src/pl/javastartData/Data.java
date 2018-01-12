package pl.javastartData;

import pl.javastartConvert.Converter;

public class Data {
    private int unit;

    private String meters;
    private String centimeters;
    private String milimeters;

    private String kilograms;
    private String grams;
    private String miligrams;

    public Data() {
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getMeters() {
        return meters;
    }

    public void setMeters(String meters) {
        this.meters = meters;
    }

    public String getCentimeters() {
        return centimeters;
    }

    public void setCentimeters(String centimeters) {
        this.centimeters = centimeters;
    }

    public String getMilimeters() {
        return milimeters;
    }

    public void setMilimeters(String milimeters) {
        this.milimeters = milimeters;
    }


    public String getKilograms() { return kilograms; }

    public void setKilograms(String kilograms) { this.kilograms = kilograms; }

    public String getGrams() { return grams; }

    public void setGrams(String grams) { this.grams = grams; }

    public String getMiligrams() { return miligrams; }

    public void setMiligrams(String miligrams) { this.miligrams = miligrams; }
}
