package stage3;

import stage2.ResourceCalculator;

public class ResourceChecker {
    public ResourceChecker(Resources needed, Resources available) {
        int people = needed.getPeople();
        int days_water = (int) (available.getWater() / (needed.getWater() * people));
        int days_food = (int) (available.getFood() / (needed.getFood() * people));
        int days_tanks = available.getTanks() / (needed.getTanks() * people);

        int days_min = Math.min(days_water, Math.min(days_food, days_tanks));
        boolean journey = (days_min >= needed.getDays());
        boolean plus = (days_min > needed.getDays());
        int plus_days = -1;
        if (plus)
            plus_days = days_min - needed.getDays();
        ResourceCheckResult res = new ResourceCheckResult(journey, plus, plus_days, days_min);
    }
}
