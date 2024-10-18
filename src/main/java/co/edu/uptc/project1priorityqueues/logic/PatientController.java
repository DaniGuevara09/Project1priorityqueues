package co.edu.uptc.project1priorityqueues.logic;

import co.edu.uptc.project1priorityqueues.model.Patient;

import java.util.*;

public class PatientController {
    private TreeSet<Patient> patients;

    private int contDisabled;
    private int contPregnant;
    private int contAge;
    private int contOther;

    private int contId;

    public PatientController() {}

    public PatientController(Comparator<Patient> comparator) {
        //this.patients = new PriorityQueue<>(comparator);
        patients = new TreeSet<>(comparator);

        contDisabled = 1;
        contPregnant = 1;
        contAge = 1;
        contOther = 1;

        contId = 0;
    }

    public List<String> getTurn(){
        List <String> turnList = new ArrayList<>();

        for (Patient patient : patients) {
            turnList.add(patient.getTurn());
        }
        return turnList;
    }

    public String addPatient(boolean disabled, boolean pregnant, String ageRange){
        Patient newPatient = new Patient(contId, disabled, pregnant, ageRange);
        String turn = newTurn(newPatient);

        patients.add(newPatient);
        contId++;
        return turn;
    }

    public String newTurn(Patient patient){
        String turn;

        if (patient.isDisabled()){
            turn = "A" + contDisabled++;
        } else if (patient.isPregnant()){
            turn = "B" + contPregnant++;
        } else if (patient.getAgeRange().equals("≥ 60")){
            turn = "C" + contAge++;
        } else {
            turn = "D" + contOther++;
        }
        patient.setTurn(turn);
        return  turn;
    }

    public static class PatientComparator implements Comparator<Patient> {
        @Override
        public int compare(Patient p1, Patient p2) {

            System.out.println(p1.getTurn());
            System.out.println(p2.getTurn());

            if (p1.getTurn().compareTo(p2.getTurn()) > 0){
                return 1;
            } else if (p1.getTurn().compareTo(p2.getTurn()) < 0){
                return -1;
            } else {

                if (p1.getTurn().substring(1).compareTo(p2.getTurn().substring(1)) > 0){
                    return 1;
                } else{
                    return -1;
                }
            }
        }
    }
}