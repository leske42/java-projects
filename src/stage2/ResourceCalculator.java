package stage2;

public class ResourceCalculator {
    private final float   total_water;
    private final float   total_food;
    private final int     total_tanks;

    public ResourceCalculator(int days, float water, float food, int tanks, int people) {
        int multiplier = days * people;
        total_water = water * multiplier;
        total_food = food * multiplier;
        total_tanks = tanks * multiplier;
    }

    public float getTotalWater() {
        return total_water;
    }

    public float getTotalFood() {
        return total_food;
    }

    public int getTotalOxygenTanks() {
        return total_tanks;
    }
}
