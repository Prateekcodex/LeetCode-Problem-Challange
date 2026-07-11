class Solution {
    public int maxArea(int[] height) {
        int p1=0, p2=height.length-1;
        int maxWater=0;
        while(p1<p2)
        {
            if(height[p1]<=height[p2])
            {
                maxWater=Math.max(maxWater,(height[p1]*(p2-p1)));
                p1++;
            }
            else
            {
                maxWater=Math.max(maxWater,(height[p2]*(p2-p1)));
                p2--;
            }
        }
        return maxWater;
    }
}