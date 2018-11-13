package com.javiermasero.data.constants

import com.javiermasero.data.BuildConfig

import java.util.*
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern

/**
 * Tmdb Constants
 */
class Constants {
    companion object {

        /**
         * Normalize pattern
         * */
        val PATTERN_ACCENTS_REGEX = ".*[ÀÁÂÃÄÈÉÊËÍÌÎÏÙÚÛÜÒÓÔÕÖÑÇªº§³²¹àáâãäèéêëíìîïùúûüòóôõöñç].*"
        val NORMALIZE_PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+")

        /**
         * Database
         * */
        /*val DATABASE_NAME: String = when (buildType) {
            BuildType.MOCK -> "Tmdb_mock"
            BuildType.DEBUG_STATIC -> "Tmdb_debug_static"
            BuildType.DEBUG -> "Tmdb_debug"
            BuildType.RELEASE -> "Tmdb_release"
        }*/

        /**
         * The Preferences
         * */
        /*val PREFERENCES_NAME: String = when (buildType) {
            BuildType.MOCK -> "Tmdb_mock"
            BuildType.DEBUG_STATIC -> "Tmdb_debug_static"
            BuildType.DEBUG -> "reina_sofia_debug"
            BuildType.RELEASE -> "reina_sofia_release"
        }*/

        /**
         * Must to update data interval
         * */
        val UPDATE_DATA_INTERVAL: UpdateInterval = when (buildType) {
            BuildType.MOCK -> UpdateInterval(value = 30, unit = Calendar.MINUTE)
            BuildType.DEBUG_STATIC -> UpdateInterval(value = 5, unit = Calendar.HOUR)
            BuildType.DEBUG -> UpdateInterval(value = 16, unit = Calendar.HOUR)
            BuildType.RELEASE -> UpdateInterval(value = 16, unit = Calendar.HOUR)
        }

        /**
         * Android Notification Channel
         * */
        /*val NOTIFICATION_CHANNEL_ID: String = when (buildType) {
            BuildType.MOCK -> "Tmdb_mock"
            BuildType.DEBUG_STATIC -> "Tmdb_debug_static"
            BuildType.DEBUG -> "reina_sofia_debug"
            BuildType.RELEASE -> "reina_sofia_release"
        }*/

        /**
         * Sync Interval, in minutes
         * */
        val SYNC_INTERVAL: SyncInterval = when (buildType) {
            BuildType.MOCK -> SyncInterval(value = 30, unit = TimeUnit.MINUTES)
            BuildType.DEBUG_STATIC -> SyncInterval(value = 15, unit = TimeUnit.MINUTES)
            BuildType.DEBUG -> SyncInterval(value = 2, unit = TimeUnit.MINUTES)
            BuildType.RELEASE -> SyncInterval(value = 1, unit = TimeUnit.MINUTES)
        }


        val EMPTY_STRING = ""

        val SERVER_TIMEOUT_SECONDS: Long = 120

        val NO_ID = -1

        /**
         * DATABASE CONSTANTS
         * */

        const val FILM = "film"
        const val PAGE = "page"

        val REGISTER_DELIMITER = ";"

        const val DATE_TIME = "date_time"

        const val DEFAULT_INT: Int = 0
        const val DEFAULT_LONG: Long = 0
        const val DEFAULT_DOUBLE: Double = 0.0
    }
}

data class SyncInterval(val value: Long, val unit: TimeUnit)
data class UpdateInterval(val value: Int, val unit: Int)

private val isMock: Boolean = BuildConfig.BUILD_TYPE == "mock"

private val isDebugStatic: Boolean = BuildConfig.BUILD_TYPE == "debug_static"

private val isDebug: Boolean = BuildConfig.BUILD_TYPE == "debug"

val buildType: BuildType = when {
    isMock -> BuildType.MOCK
    isDebugStatic -> BuildType.DEBUG_STATIC
    isDebug -> BuildType.DEBUG
    else -> BuildType.RELEASE
}

enum class BuildType {
    MOCK, DEBUG_STATIC, DEBUG, RELEASE
}