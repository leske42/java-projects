package stage5;

import stage3.ResourceCheckResult;
import stage3.Resources;

public class Controller {
    public static void run() {
            View.checkHealthAndApproveTravelers();
            Resources raw_needed = View.askforRequiredResources();
            Resources total_needed = Model.calculateRequiredResources(raw_needed);
            View.displayRequiredResources(total_needed);
            Resources available = View.collectAvailableResources();
            ResourceCheckResult result = Model.checkResources(total_needed, available);
            View.displayPossibilityOfJourney(result);
            if (!result.journeyPossible())
                return;
//        if (!checkResources(needed, available) || !processPaymentForJourney(needed)) {
//            return ;
//        }
//        countdown();
//        startSpaceJourney();
    }
}
