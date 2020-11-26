package top.derekdev.kotlinutil

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}