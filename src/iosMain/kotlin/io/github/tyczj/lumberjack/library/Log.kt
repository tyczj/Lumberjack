package io.github.tyczj.lumberjack.library

import platform.Foundation.NSLog

actual class Log {
    actual fun error(tag: String, message: String) {
        logMessage("ERROR/$tag", message)
    }

    actual fun info(tag: String, message: String) {
        logMessage("INFO/$tag", message)
    }

    actual fun verbose(tag: String, message: String) {
        logMessage("VERBOSE/$tag", message)
    }

    actual fun debug(tag: String, message: String) {
        logMessage("DEBUG/$tag", message)
    }

    actual fun warn(tag: String, message: String) {
        logMessage("WARN/$tag", message)
    }

    private fun logMessage(tag: String, message: String){
        NSLog("$tag: $message")
    }
}