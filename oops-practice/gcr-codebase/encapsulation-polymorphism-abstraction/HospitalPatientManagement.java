interface MedicalRecord {
    void addRecord(String record);

    void viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    Patient(String id, String name, int age) {
        patientId = id;
        this.name = name;
        this.age = age;
    }

    abstract double calculateBill();

    void getPatientDetails() {
        System.out.println(name + " " + age);
    }
}

class InPatient extends Patient implements MedicalRecord {
    InPatient(String id, String name, int age) {
        super(id, name, age);
    }

    double calculateBill() {
        return 5000;
    }

    public void addRecord(String record) {
        System.out.println("Record added");
    }

    public void viewRecords() {
        System.out.println("Viewing records");
    }
}
