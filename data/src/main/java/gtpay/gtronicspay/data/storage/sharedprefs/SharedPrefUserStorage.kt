package gtpay.gtronicspay.data.storage.sharedprefs

import android.content.Context
import gtpay.gtronicspay.data.UserStorage
import gtpay.gtronicspay.data.storage.models.User


private const val SHARED_PREFS_NAME = "shared_pref_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_FIRST_NAME = "Default last name"
private const val DEFAULT_LAST_NAME = "Default last name"

class SharedPrefUserStorage(context: Context) : UserStorage{

    private val sharedPrefs = context.getSharedPreferences(
        SHARED_PREFS_NAME,
        Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPrefs.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPrefs.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun getName(): User {
        val firstName = sharedPrefs.getString(KEY_FIRST_NAME, DEFAULT_FIRST_NAME) ?: DEFAULT_FIRST_NAME
        val lastName = sharedPrefs.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME
        return User(firstName = firstName, lastName = lastName)
    }
}