class Solution {
    public boolean lemonadeChange(int[] bills) {
        int _5 = 0;
        int _10 = 0;
        int _20 = 0;
        for (int each : bills){
            if (each == 5)
                _5++;
            else if (each == 10){
                _10++;
                _5--;
                if (_5 <0)
                    return false;
            }
            else{
                if (_5 > 0 && _10 > 0){
                    _10--;
                    _5--;
                }
                else if (_5>=3)
                    _5-=3;
                else
                    return false;
            }
        }
        return true;
    }
}