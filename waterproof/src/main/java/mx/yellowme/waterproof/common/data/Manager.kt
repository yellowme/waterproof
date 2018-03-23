package mx.yellowme.waterproof.common.data

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

/**
 * Created by luisburgos on 9/13/17.
 */
@SuppressLint("CommitPrefEdits")
abstract class Manager<Entity> internal constructor(context: Context, storageName: String) {

    val preferences: SharedPreferences = context.getSharedPreferences(storageName, 0)
    val editor: SharedPreferences.Editor

    init {
        editor = preferences.edit()
    }

    abstract fun save(toSave: Entity?)
    abstract fun clear()

    abstract val session: Entity?

}