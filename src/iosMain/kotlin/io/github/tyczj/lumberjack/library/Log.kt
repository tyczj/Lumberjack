package io.github.tyczj.lumberjack.library

import platform.Foundation.NSLog

actual open class Log {
    actual open fun debug(tag: String, message: String) {
        logMessage("DEBUG/$tag", message)
    }

    actual open fun info(tag: String, message: String) {
        logMessage("INFO/$tag", message)
    }

    actual open fun warn(tag: String, message: String) {
        logMessage("WARN/$tag", message)
    }

    actual open fun verbose(tag: String, message: String) {
        logMessage("VERBOSE/$tag", message)
    }

    actual open fun error(tag: String, message: String) {
        logMessage("ERROR/$tag", message)
    }

    private fun logMessage(tag: String, message: String){
        NSLog("$tag: $message")
    }
}