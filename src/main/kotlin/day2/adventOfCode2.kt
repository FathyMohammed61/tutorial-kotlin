package day2

import java.io.File
fun main() {
    val passwords = File("src/main/kotlin/day2/input2").readLines().map(PasswordWithPolicy::parse)
    passwords.forEach(::println)
}

data class PasswordWithPolicy(val password: String , val range: IntRange , val letter: Char) {
    companion object {
        fun parse(line: String) = PasswordWithPolicy(
            password = line.substringAfter(": ") ,
            letter = line.substringAfter(" ").substringBefore(":").single() ,
            range = line.substringAfter(" ").let {
                val (start , end) = it.split("_")
                start.toIntOrNull()!!..end.toIntOrNull()!!
            }

        )
    }
}

