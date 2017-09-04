package org.billFarber.charts.dataGenerator;

public enum Organization {
    Acme("AC"),
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
