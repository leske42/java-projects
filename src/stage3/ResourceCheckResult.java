package stage3;

public class ResourceCheckResult {
    private final boolean journeyPossible;
    private final boolean hasSurplus;
    private final int     extraDays;
    private final int     possibleDays;

    public ResourceCheckResult(boolean journey, boolean plus, int plus_days, int max_days) {
        journeyPossible = journey;
        hasSurplus = plus;
        extraDays = plus_days;
        possibleDays = max_days;
    }

    public boolean journeyPossible() {
        return journeyPossible;
    }

    public boolean hasSurplus() {
        return hasSurplus;
    }

    public int getExtraDays() {
        return extraDays;
    }

    public int getPossibleDays() {
        return possibleDays;
    }
}
