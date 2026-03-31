class ZaraBonus {
    static double[][] generate() {
        double[][] data = new double[10][2];
        for (int i = 0; i < 10; i++) {
            data[i][0] = 10000 + (int) (Math.random() * 90000);
            data[i][1] = (int) (Math.random() * 10);
        }
        return data;
    }

    static double[][] calculate(double[][] data) {
        double[][] result = new double[10][2];
        for (int i = 0; i < 10; i++) {
            double bonus = (data[i][1] > 5) ? data[i][0] * 0.05 : data[i][0] * 0.02;
            result[i][0] = data[i][0] + bonus;
            result[i][1] = bonus;
        }
        return result;
    }
}
