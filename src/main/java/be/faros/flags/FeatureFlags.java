package be.faros.flags;

import org.togglz.core.Feature;
import org.togglz.core.util.NamedFeature;

public final class FeatureFlags {
    public static final Feature SAVE_FLAG = new NamedFeature("save_flag");
    public static final Feature LIKE_FLAG = new NamedFeature("like_flag");
    public static final Feature UPDATE_FLAG = new NamedFeature("update_flag");
    public static final Feature CHARGE = new NamedFeature("charge_layer");
    public static final Feature NASA = new NamedFeature("nasa_emblem");

    private FeatureFlags() {
    }
}
