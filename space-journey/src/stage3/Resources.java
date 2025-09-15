package stage3;

public class Resources {
    private final int days;
    private final float water;
    private final float food;
    private final int tanks;
    private final int people;

    public Resources(int days, float water, float food, int tanks, int people) {
        this.days = days;
        this.water = water;
        this.food = food;
        this.tanks = tanks;
        this.people = people;
    }
    public int getDays() {
        return days;
    }
    public float getWater() {
        return water;
    }
    public float getFood() {
        return food;
    }
    public int getTanks() {
        return tanks;
    }
    public int getPeople() {
        return people;
    }
}
