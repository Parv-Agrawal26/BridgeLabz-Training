class AverageMarksCalculation {

    public static void main(String[] args) {

        String name = "Sam";

        int mathsMarks = 94;
        int physicsMarks = 95;
        int chemistryMarks = 96;

        int totalMarks = mathsMarks + physicsMarks + chemistryMarks;

        int totalSubjects = 3;

        double averageMarks = (double) totalMarks / totalSubjects;

        System.out.println(name + "average mark in PCM is " + averageMarks);
    }
}