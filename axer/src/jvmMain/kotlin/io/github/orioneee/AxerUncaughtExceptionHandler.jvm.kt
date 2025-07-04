package io.github.orioneee

import kotlin.system.exitProcess

actual fun logAboutException(exception: Throwable, exit: Boolean) {
    System.err.println(exception.stackTraceToString())
    if(exit) {
        exitProcess(10)
    }
}