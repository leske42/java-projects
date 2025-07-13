package stage5;

import stage2.ResourceCalculator;
import stage3.ResourceCheckResult;
import stage3.ResourceChecker;
import stage3.Resources;

import java.util.Scanner;

public class Model {

    static Resources calculateRequiredResources(Resources resources) {
        ResourceCalculator calc = new ResourceCalculator(resources);
        return new Resources(-1, calc.getTotalWater(), calc.getTotalFood() , calc.getTotalOxygenTanks(), -1);
    }

    static ResourceCheckResult checkResources(Resources needed, Resources available) {
        ResourceChecker checker = new ResourceChecker(available);
        return checker.checkResources(needed);
    }
}
