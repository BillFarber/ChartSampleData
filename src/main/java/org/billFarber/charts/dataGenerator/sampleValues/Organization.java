package org.billFarber.charts.dataGenerator.sampleValues;

public enum Organization {
    Acme("AC"),
    Boeing("B"),
    Carnitas("CA"),
    DefenseIndustrialComplex("DI"),
    IAC("IAC");

    private String abbreviation;

    Organization(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String abbreviation() {
        return abbreviation;
    }
}
