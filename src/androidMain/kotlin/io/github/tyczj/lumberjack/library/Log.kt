package io.github.tyczj.lumberjack.library

import android.util.Log

actual class Log {
    actual fun debug(tag: String, message: String) {
        Log.d(tag, message)
    }

    actual fun info(tag: String, message: String) {
        Log.i(tag, message)
    }

    actual fun warn(tag: String, message: String) {
        Log.w(tag, message)
    }

    actual fun verbose(tag: String, message: String) {
        Log.v(tag, message)
    }

    actual fun error(tag: String, message: String) {
        Log.e(tag, message)
    }
}