package mx.yellowme.waterproof;

import android.support.annotation.NonNull;

public class WaterproofConditions {
    public static @NonNull <T> T checkNotNull(final T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }
}
