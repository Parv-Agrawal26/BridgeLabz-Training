class PCMScore {
    static int[][] generate(int students) {
        int[][] marks = new int[students][3];
        for (int i = 0; i < students; i++) {
            marks[i][0] = (int) (Math.random() * 100);
            marks[i][1] = (int) (Math.random() * 100);
            marks[i][2] = (int) (Math.random() * 100);
        }
        return marks;
    }

    static double[][] calculate(int[][] marks) {
        double[][] result = new double[marks.length][3];
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            double percent = Math.round(avg * 100) / 100.0;
            result[i][0] = total;
            result[i][1] = avg;
            result[i][2] = percent;
        }
        return result;
    }
}
