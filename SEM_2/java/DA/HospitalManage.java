import java.util.ArrayList;
import java.util.List;

abstract class Patient {
    private String patientName;
    private int patientAge;
    private String patientGender;
    private String patientID;
    private String patientAddress;
    private List<MedicalRecord> medicalRecords;

    public Patient(String patientName, int patientAge, String patientGender, String patientID, String patientAddress) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientGender = patientGender;
        this.patientID = patientID;
        this.patientAddress = patientAddress;
        this.medicalRecords = new ArrayList<>();
    }

    public String getPatientName() {
        return patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void addRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    public void deleteRecord(MedicalRecord record) {
        medicalRecords.remove(record);
    }

    public void viewRecord() {
        for (MedicalRecord record : medicalRecords) {
            record.displayRecord();
        }
    }
}

class Inpatient extends Patient {
    private int bedNumber;

    public Inpatient(String patientName, int patientAge, String patientGender, String patientID, String patientAddress, int bedNumber) {
        super(patientName, patientAge, patientGender, patientID, patientAddress);
        this.bedNumber = bedNumber;
    }

    public int getBedNumber() {
        return bedNumber;
    }
}

class Outpatient extends Patient {
    private String appointmentDate;

    public Outpatient(String patientName, int patientAge, String patientGender, String patientID, String patientAddress, String appointmentDate) {
        super(patientName, patientAge, patientGender, patientID, patientAddress);
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }
}

interface MedicalRecord {
    void addRecord();
    void deleteRecord();
    void displayRecord();
}

class LaboratoryReport implements MedicalRecord {
    private String testName;

    public LaboratoryReport(String testName) {
        this.testName = testName;
    }

    public void addRecord() {
        // Logic to add laboratory report
        System.out.println("Laboratory report added.");
    }

    public void deleteRecord() {
        // Logic to delete laboratory report
        System.out.println("Laboratory report deleted.");
    }

    public void displayRecord() {
        System.out.println("Laboratory Report: " + testName);
    }
}

class RadiologyImage implements MedicalRecord {
    private String imageType;

    public RadiologyImage(String imageType) {
        this.imageType = imageType;
    }

    public void addRecord() {
        // Logic to add radiology image
        System.out.println("Radiology image added.");
    }

    public void deleteRecord() {
        // Logic to delete radiology image
        System.out.println("Radiology image deleted.");
    }

    public void displayRecord() {
        System.out.println("Radiology Image: " + imageType);
    }
}

class Hospital {
    private List<Patient> patients;

    public Hospital() {
        patients = new ArrayList<>();
    }

    public void admitPatient(Patient patient) {
        patients.add(patient);
    }

    public void dischargePatient(Patient patient) {
        patients.remove(patient);
    }

    public void displayPatients() {
        System.out.println("List of Patients in the Hospital:");
        System.out.println("-----------------------------------");
        for (Patient patient : patients) {
            System.out.println("Patient ID: " + patient.getPatientID());
            System.out.println("Patient Name: " + patient.getPatientName());
            System.out.println("-----------------------------------");
        }
    }

    public void displayMedicalRecords(Patient patient) {
        System.out.println("Medical Records for patient: " + patient.getPatientName());
        patient.viewRecord();
    }
}

public class HospitalManage {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        Inpatient inpatient1 = new Inpatient("John", 40, "Male", "P001", "123 Street", 101);
        Inpatient inpatient2 = new Inpatient("Alice", 35, "Female", "P002", "456 Street", 102);
        Outpatient outpatient1 = new Outpatient("David", 50, "Male", "P003", "789 Street", "2023-06-01");
        Outpatient outpatient2 = new Outpatient("Sarah", 28, "Female", "P004", "321 Street", "2023-06-02");

        hospital.admitPatient(inpatient1);
        hospital.admitPatient(inpatient2);
        hospital.admitPatient(outpatient1);
        hospital.admitPatient(outpatient2);

        hospital.displayPatients();

        LaboratoryReport labReport1 = new LaboratoryReport("Blood Test");
        LaboratoryReport labReport2 = new LaboratoryReport("Urinalysis");
        RadiologyImage radiologyImage1 = new RadiologyImage("X-Ray");
        RadiologyImage radiologyImage2 = new RadiologyImage("MRI");

        // Add medical records for patients
        inpatient1.addRecord(labReport1);
        inpatient1.addRecord(radiologyImage1);
        outpatient1.addRecord(labReport2);
        outpatient2.addRecord(radiologyImage2);

        // Display medical records for a patient
        hospital.displayMedicalRecords(inpatient1);

        // Delete medical records for patients
        inpatient1.deleteRecord(labReport1);
        outpatient2.deleteRecord(radiologyImage2);

        hospital.dischargePatient(inpatient1);
        hospital.dischargePatient(outpatient2);

        hospital.displayPatients();
    }
}
