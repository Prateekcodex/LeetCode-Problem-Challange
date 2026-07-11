class Solution {
    public int reverse(int x) {
        int res=0;
        while(x!=0)
        {
            int lastDigit=x%10;
            int currRes= res*10 + lastDigit;
            if((currRes-lastDigit)/10 !=res)
            {
                return 0;
            }
            res=currRes;
            x/=10;
        }
        return res;
    }
}