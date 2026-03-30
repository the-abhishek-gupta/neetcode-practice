class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(new Car(position[i], speed[i]));
        list.sort((a,b)-> b.pos - a.pos);
        int ct = 0;
        double minTime = 0;
        for (Car c : list){
            double time = (double)(target - c.pos)/ c.sp;                        
            System.out.println(time+" "+c.pos+" "+c.sp);
            if (time > minTime){
                minTime = time;
                ct++;
            }
        }
        return ct;

    }
}
class Car{
    int pos, sp;
    Car(int p, int s){
        pos = p;
        sp = s;
    }
}
