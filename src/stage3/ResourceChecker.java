package stage3;

import stage2.ResourceCalculator;

public class ResourceChecker {
    private final float water_available;
    private final float food_available;
    private final int   tanks_available;

    public ResourceChecker(Resources available) {
        water_available = available.getWater();
        food_available = available.getFood();
        tanks_available = available.getTanks();
    }

    public ResourceCheckResult checkResources(Resources needed) {
        int people = needed.getPeople();
        int days_water = (int) (water_available / (needed.getWater() * people));
        int days_food = (int) (food_available / (needed.getFood() * people));
        int days_tanks = tanks_available / (needed.getTanks() * people);

        int days_min = Math.min(days_water, Math.min(days_food, days_tanks));
        boolean journey = (days_min >= needed.getDays());
        boolean plus = (days_min > needed.getDays());
        int plus_days = -1;
        if (plus)
            plus_days = days_min - needed.getDays();
        return new ResourceCheckResult(journey, plus, plus_days, days_min);
    }
}
