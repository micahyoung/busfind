package io.young.busfind.presenters;

import io.young.busfind.Estimate;
import io.young.busfind.models.webhook.WebhookResponse;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class WebhookResponsePresenter {
    public static WebhookResponse present(Estimate estimate) {
        String estimateText;
        double miles = estimate.getDistance() * 0.000621371;
        if (estimate.getEta() != null) {
            long minutes = LocalDateTime.now().until(estimate.getEta(), ChronoUnit.MINUTES);
            estimateText = String.format("It will arrive in %d minutes and is %d stops and %.1f miles away.", minutes, estimate.getStops(), miles);
        } else {
            estimateText = String.format("It is %d stops and %.1f miles away. No estimated time.", estimate.getStops(), miles);
        }

        return new WebhookResponse() {{
            speech = estimateText;
            displayText = estimateText;
            source = "busfind.young.io";
        }};
    }
}
