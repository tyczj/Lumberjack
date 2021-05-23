# Lumberjack

A simple logging library for Kotlin Multiplatform Mobile

Lumberjack will use `Log` in Android and `NSLog` in iOS

```
Lumberjack.log(Priority.Debug, "SomeTag", "This is a basic example)
```

### Custom Loggers

If you want to do some custom processing of log messages you can create your own logger and add it to Lumberjack

Create a new class and have it extend `Log` then override any of the five different log message types

```
class MyLogger: Log() {
    override fun debug(tag: String, message: String) {
        //Handle debug messages
    }

    override fun info(tag: String, message: String) {
        //Handle info messages
    }

    override fun warn(tag: String, message: String) {
        //Handle warn messages
    }

    override fun verbose(tag: String, message: String) {
        //Handle verbose messages
    }

    override fun error(tag: String, message: String) {
        //Handle error messages
    }
}
```

Then all you have to do is add the new class to Lumberjack

```
Lumberjack.addLogger(MyLogger())
```

Now when you call `Lumberjack.log` your custom logger will get called along with the default logger

### Dependency

**Android**

```
releaseImplementation 'io.github.tyczj.lumberjack:Lumberjack-android:1.0.0@aar'
debugImplementation 'io.github.tyczj.lumberjack:Lumberjack-android-debug:1.0.0@aar'
```

**iOS**

```
implementation io.github.tyczj.lumberjack:Lumberjack-ios:1.0.0
```