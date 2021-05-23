package io.github.tyczj.lumberjack.library

enum class Priority{
    Debug,
    Info,
    Warning,
    Verbose,
    Error
}

expect open class Log() {
    open fun debug(tag: String, message: String)
    open fun info(tag: String, message: String)
    open fun warn(tag: String, message: String)
    open fun verbose(tag: String, message: String)
    open fun error(tag: String, message: String)
}