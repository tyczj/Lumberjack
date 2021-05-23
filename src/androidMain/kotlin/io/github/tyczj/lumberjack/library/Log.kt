package io.github.tyczj.lumberjack.library

import android.util.Log

actual open class Log {
    actual open fun debug(tag: String, message: String) {
        Log.d(tag, message)
    }

    actual open fun info(tag: String, message: String) {
        Log.i(tag, message)
    }

    actual open fun warn(tag: String, message: String) {
        Log.w(tag, message)
    }

    actual open fun verbose(tag: String, message: String) {
        Log.v(tag, message)
    }

    actual open fun error(tag: String, message: String) {
        Log.e(tag, message)
    }
}