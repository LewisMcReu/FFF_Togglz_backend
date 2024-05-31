package be.faros.flags.web;

import be.faros.flags.FeatureFlags;
import be.faros.flags.domain.Emblem;
import be.faros.flags.exceptions.FlagException;
import be.faros.flags.web.dto.ChargeLayerDTO;
import be.faros.flags.web.dto.FlagDTO;
import be.faros.flags.web.dto.LayerDTO;
import org.springframework.stereotype.Component;
import org.togglz.core.context.FeatureContext;
import org.togglz.core.manager.FeatureManager;

@Component
public class FlagValidator {
    private final FeatureManager featureManager;

    public FlagValidator(FeatureManager featureManager) {
        this.featureManager = featureManager;
    }

    public void validate(FlagDTO flag) {
        boolean allowChargeLayers = FeatureContext.getFeatureManager().isActive(FeatureFlags.CHARGE);
        boolean allowNasaEmblem = FeatureContext.getFeatureManager().isActive(FeatureFlags.NASA);
        if (allowChargeLayers && allowNasaEmblem) {
            return;
        }

        for (LayerDTO layer : flag.getLayers()) {
            if (layer instanceof ChargeLayerDTO cl) {
                if (!allowChargeLayers) {
                    throw new FlagException(FeatureFlags.CHARGE);
                } else if (cl.getEmblem() == Emblem.NASA && !allowNasaEmblem) {
                    throw new FlagException(FeatureFlags.NASA);
                }
            }
        }
    }
}
