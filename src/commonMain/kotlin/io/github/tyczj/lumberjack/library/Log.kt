package io.github.tyczj.lumberjack.library

expect class Log {
    fun debug(tag: String, message: String)
    fun info(tag: String, message: String)
    fun warn(tag: String, message: String)
    fun verbose(tag: String, message: String)
    fun error(tag: String, message: String)
}