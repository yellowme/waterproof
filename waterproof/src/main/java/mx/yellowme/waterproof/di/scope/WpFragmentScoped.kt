package mx.yellowme.waterproof.di.scope

import javax.inject.Scope

/**
 * Created by migdonio on 2/03/18.
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class WpFragmentScoped
