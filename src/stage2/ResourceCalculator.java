package stage2;
import stage3.Resources;

public class ResourceCalculator {
    private final float   total_water;
    private final float   total_food;
    private final int     total_tanks;

    public ResourceCalculator(Resources resources) {
        int multiplier = resources.getDays() * resources.getPeople();
        total_water = resources.getWater() * multiplier;
        total_food = resources.getFood() * multiplier;
        total_tanks = resources.getTanks() * multiplier;
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
