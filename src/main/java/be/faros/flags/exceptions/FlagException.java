package be.faros.flags.exceptions;

import org.togglz.core.Feature;

public class FlagException extends RuntimeException {
    public FlagException(Feature flag) {
        super("Flag %s toggled off".formatted(flag.name()));
    }
}
