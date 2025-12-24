class FootballHeightStats {
    static int sum(int[] heights) {
        int total = 0;
        for (int index = 0; index < heights.length; index++) {
            total = total + heights[index];
        }
        return total;
    }

    static double mean(int[] heights) {
        return sum(heights) / (double) heights.length;
    }

    static int shortest(int[] heights) {
        int min = heights[0];
        for (int index = 1; index < heights.length; index++) {
            if (heights[index] < min)
                min = heights[index];
        }
        return min;
    }

    static int tallest(int[] heights) {
        int max = heights[0];
        for (int index = 1; index < heights.length; index++) {
            if (heights[index] > max)
                max = heights[index];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = new int[11];
        for (int i = 0; i < 11; i++) {
            heights[i] = 150 + (int) (Math.random() * 101);
            System.out.println(heights[i]);
        }
        System.out.println("Shortest " + shortest(heights));
        System.out.println("Tallest " + tallest(heights));
        System.out.println("Mean " + mean(heights));
    }
}
