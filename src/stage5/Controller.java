package stage5;

import stage3.Resources;

public class Controller {
    public static void run() {
            View.checkHealthAndApproveTravelers();
            Resources resources = View.askforRequiredResources();
            Resources result = Model.calculateRequiredResources(resources);
            View.displayRequiredResources(result);


//        System.out.println("Starting preparation for the space journey");
//        checkHealthAndApproveTravelers();
//        Resources needed = calculateRequiredResources();
//        Resources available = collectResources();
//        if (!checkResources(needed, available) || !processPaymentForJourney(needed)) {
//            return ;
//        }
//        countdown();
//        startSpaceJourney();
    }
}
