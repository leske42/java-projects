package stage5;

import stage3.ResourceCheckResult;
import stage3.Resources;
import stage4.PaymentCheckResult;

public class Controller {
    public static void run() {
            View.displayPrologue();
            Resources raw_needed = View.askforRequiredResources();
            Resources total_needed = Model.calculateRequiredResources(raw_needed);
            View.displayRequiredResources(total_needed);
            Resources available = View.collectAvailableResources();
            ResourceCheckResult journey_status = Model.checkResources(raw_needed, available);
            View.displayPossibilityOfJourney(journey_status);
            if (!journey_status.journeyPossible())
                return;
            PaymentInfo payment_info = View.collectPaymentMethod();
            PaymentCheckResult payment_status = Model.processPaymentForJourney(payment_info, raw_needed);
            View.displayPaymentResult(payment_info, payment_status);
            if (!payment_status.isFullJourneyAffordable())
                return;
            View.displayEpilogue();
    }
}
