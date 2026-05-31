class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currmass = mass;
        for(int asteroid : asteroids){
            if(currmass < asteroid){
                return false;
            }
            currmass += asteroid;
        }
        return true;
    }
}