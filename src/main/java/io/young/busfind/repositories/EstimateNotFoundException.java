package io.young.busfind.repositories;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Estimate not found")
public class EstimateNotFoundException extends Exception {
}
