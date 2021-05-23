package io.github.tyczj.lumberjack.library

class Lumberjack {

    companion object{

        private val _loggers: MutableList<Log> = mutableListOf(Log())

        fun addLogger(log: Log){
            _loggers.add(log)
        }

        fun log(priority: Priority, tag: String, message: String){
            _loggers.forEach {
                when(priority){
                    Priority.Debug -> it.debug(tag, message)
                    Priority.Info -> it.info(tag, message)
                    Priority.Warning -> it.warn(tag, message)
                    Priority.Verbose -> it.verbose(tag, message)
                    Priority.Error -> it.error(tag, message)
                }
            }
        }
    }
}