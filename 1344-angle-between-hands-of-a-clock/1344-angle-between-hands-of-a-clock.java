class Solution {
    public double angleClock(int hour, int minutes) {
        double HourAngle = (hour % 12)*30 + minutes*0.5;
        double MinuteAngle = minutes*6;
        double angle = Math.abs(HourAngle - MinuteAngle);
        return Math.min(angle , 360-angle);
    }
}