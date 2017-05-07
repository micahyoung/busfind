package io.young.busfind.presenters;

import io.young.busfind.Estimate;
import io.young.busfind.models.webhook.WebhookResponse;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class WebhookResponsePresenter {
    public static WebhookResponse present(Estimate estimate) {
        String estimateText;
        double miles = estimate.getDistance() * 0.000621371;
        if (estimate.getEta() != null) {
            long minutes = ZonedDateTime.now().until(estimate.getEta(), ChronoUnit.MINUTES);
            estimateText = String.format("The %s bus will arrive in %d minutes and is %d stops and %.1f miles away.", estimate.getLineName(), minutes, estimate.getStops(), miles);
        } else {
            estimateText = String.format("The %s bus is %d stops and %.1f miles away. No estimated time.", estimate.getLineName(), estimate.getStops(), miles);
        }

        return new WebhookResponse() {{
            speech = estimateText;
            displayText = estimateText;
            source = "busfind.young.io";
        }};
    }

    public static WebhookResponse error(String stopcode) {
        String estimateText = String.format("Sorry, I could not find information for the stop: \"%s\"", stopcode);
        return new WebhookResponse() {{
            speech = estimateText;
            displayText = estimateText;
            source = "busfind.young.io";
        }};
    }
}
