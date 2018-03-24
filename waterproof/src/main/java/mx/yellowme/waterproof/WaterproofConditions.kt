package mx.yellowme.waterproof

object WaterproofConditions {
    fun <T> checkNotNull(reference: T?): T {
        if (reference == null) {
            throw NullPointerException()
        }
        return reference
    }
}
