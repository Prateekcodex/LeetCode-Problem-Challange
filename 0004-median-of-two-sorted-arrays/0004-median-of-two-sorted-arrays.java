class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int start = 0;
        int end = n1;

        while(start <= end){

            int part1 = start + (end - start) / 2;
            int part2 = (n1 + n2 + 1) / 2 - part1;

            int n1Left = (part1 == 0) ? Integer.MIN_VALUE : nums1[part1-1];
            int n1Right = (part1 == n1) ? Integer.MAX_VALUE : nums1[part1];

            int n2Left = (part2 == 0) ? Integer.MIN_VALUE : nums2[part2-1];
            int n2Right = (part2 == n2) ? Integer.MAX_VALUE : nums2[part2];

            if(n1Left > n2Right){
                end = part1 - 1;
            }
            else if(n2Left > n1Right){
                start = part1 + 1;
            }
            else{

                if((n1+n2)%2==0){
                    return (Math.max(n1Left,n2Left)+Math.min(n1Right,n2Right))/2.0;
                }

                return (double)Math.max(n1Left,n2Left);
            }
        }

        return 0.0;
    }
}