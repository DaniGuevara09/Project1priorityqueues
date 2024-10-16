package co.edu.uptc.project1priorityqueues.model;

public class Patient {
    private String turn;
    private boolean disabled;
    private boolean pregnant;
    private String ageRange;

    public Patient() {
    }

    public Patient(boolean disabled, boolean pregnant, String ageRange) {
        this.disabled = disabled;
        this.pregnant = pregnant;
        this.ageRange = ageRange;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }
}
