package stage5;

import stage3.ResourceCheckResult;
import stage3.Resources;
import stage4.PaymentCheckResult;

public class Controller {
    private final View view;
    private final Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void run() {
            view.displayPrologue();
            Resources raw_needed = view.askforRequiredResources();
            Resources total_needed = model.calculateRequiredResources(raw_needed);
            view.displayRequiredResources(total_needed);
            Resources available = view.collectAvailableResources();
            ResourceCheckResult journey_status = model.checkResources(raw_needed, available);
            view.displayPossibilityOfJourney(journey_status);
            if (!journey_status.journeyPossible())
                return;
            PaymentInfo payment_info = view.collectPaymentMethod();
            PaymentCheckResult payment_status = model.processPaymentForJourney(payment_info, raw_needed);
            view.displayPaymentResult(payment_info, payment_status);
            if (!payment_status.isFullJourneyAffordable())
                return;
            view.displayEpilogue();
    }
}
