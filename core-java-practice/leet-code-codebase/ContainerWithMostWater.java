class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int p1 = 0;
        int p2 = height.length - 1;
        int ans = Integer.MIN_VALUE;
        while (p1 < p2) {
            int minHeight = Math.min(height[p1], height[p2]);
            int width = p2 - p1;
            ans = Math.max(ans, minHeight * width);
            if (height[p1] > height[p2])
                p2--;
            else
                p1++;
        }
        return ans;
    }
}