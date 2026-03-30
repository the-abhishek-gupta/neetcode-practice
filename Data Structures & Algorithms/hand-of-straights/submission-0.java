class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int each : hand)
            map.put(each, map.getOrDefault(each, 0)+1);
        Arrays.sort(hand);

        for (int each : hand){
            if (map.get(each) > 0){
                for (int i = each ; i < each + groupSize; i++){
                    if (map.getOrDefault(i, 0) == 0)
                        return false;
                    map.put(i, map.get(i)-1);
                }
            }
        }
        return true;

    }
}
