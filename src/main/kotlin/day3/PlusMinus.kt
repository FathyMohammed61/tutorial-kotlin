package day3

import java.io.File

fun main() {
    val passwords = File("src/main/kotlin/day3/input.txt").readLines()
    println(passwords.size)
}
