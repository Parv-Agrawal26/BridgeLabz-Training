import java.util.ArrayList;


public class HospitalManagement {
    static ArrayList<Doctor> doctors=new ArrayList<>();
    static void assignDoctorToPatient(Patient patient) {
        for (Doctor doctor : doctors) {
            if (doctor.getSpecialization().equalsIgnoreCase(patient.getTypeOfDoctorRequired())) {
                System.out.println("Assigned " + doctor.getName() + " to patient " + patient.getName());
                doctor.patient = patient;
                patient.assignedDoctor = doctor;
                return;
            }
        }
        System.out.println("No suitable doctor found for patient " + patient.getName());
    }

    public static void main(String[] args) {
        Doctor doc1 = new Doctor("Dr. Smith", "Cardiology");
        Doctor doc2 = new Doctor("Dr. Jones", "Neurology");
        Doctor doc3 = new Doctor("Dr. Brown", "General");

        doctors.add(doc1);
        doctors.add(doc2);
        doctors.add(doc3);

        Patient patient1 = new InPatient("John Doe", 45, "Heart Disease", "Cardiology", 101);
        Patient patient2 = new OutPatient("Jane Smith", 30, "Migraine", "Neurology", "2024-06-15");

        assignDoctorToPatient(patient1);
        assignDoctorToPatient(patient2);

        patient1.displayPatientInfo();
        patient2.displayPatientInfo();

        Bill bill1 = new Bill(1, 5000.0);
        bill1.generateBill(patient1, bill1.getAmount());

    }
}

abstract class Patient {
    private String name;
    private int age;
    private String disease;
    private String typeOfDoctorRequired;
    Doctor assignedDoctor;

    Patient(String name, int age, String disease, String typeOfDoctorRequired) {
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.typeOfDoctorRequired = typeOfDoctorRequired;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    String getDisease() {
        return disease;
    }
    String getTypeOfDoctorRequired() {
        return typeOfDoctorRequired;
    }
    abstract void displayPatientInfo();
}

class InPatient extends Patient{
    private int roomNumber;

    InPatient(String name, int age, String disease, String typeOfDoctorRequired, int roomNumber) {
        super(name, age, disease, typeOfDoctorRequired);
        this.roomNumber = roomNumber;
    }

    int getRoomNumber() {
        return roomNumber;
    }

    void displayPatientInfo() {
        System.out.println("InPatient Name: " + getName() + ", Age: " + getAge() + ", Disease: " + getDisease() + ", Room Number: " + roomNumber);
    }
}

class OutPatient extends Patient{
    private String appointmentDate;

    OutPatient(String name, int age, String disease, String typeOfDoctorRequired, String appointmentDate) {
        super(name, age, disease, typeOfDoctorRequired);
        this.appointmentDate = appointmentDate;
    }

    String getAppointmentDate() {
        return appointmentDate;
    }

    void displayPatientInfo() {
        System.out.println("OutPatient Name: " + getName() + ", Age: " + getAge() + ", Disease: " + getDisease() + ", Appointment Date: " + appointmentDate);
    }

}

class Doctor {
    private String name;
    private String specialization;
    Patient patient;

    Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    String getName() {
        return name;
    }

    String getSpecialization() {
        return specialization;
    }
}

class Bill implements Payable {
    private int billId;
    private double amount;

    Bill(int billId, double amount) {
        this.billId = billId;
        this.amount = amount;
    }

    int getBillId() {
        return billId;
    }

    double getAmount() {
        return amount;
    }

    @Override
    public void generateBill(Patient patient, double amount) {
        System.out.println("Generating bill for Patient: " + patient.getName() + ", Amount: " + amount);
    }
}

interface Payable {
    void generateBill(Patient patient, double amount);
}