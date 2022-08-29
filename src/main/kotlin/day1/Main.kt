import java.io.File

fun main() {
    val numbers = File("src/main/kotlin/day1/input1").readLines().map(String::toInt)

    //BY pair  (Find Two numbers the result = 2020)
    fun List<Int>.findPairOfSum(sum: Int): Pair<Int , Int>? {
        val complements = associateBy { sum - it }
        return firstNotNullOfOrNull { number ->
            complements[number]?.let { complement ->
                Pair(number , complement)
            }
        }
    }

    val pair = numbers.findPairOfSum(2020)
    println(pair)
    println(pair?.let { (x , y) -> x * y })



    //  BY triple  (Find three numbers the result = 2020)
    fun List<Int>.findTripleOfSum(): Triple<Int , Int , Int>? = firstNotNullOfOrNull { x ->
        findPairOfSum(2020 - x)?.let { pair ->
            Triple(x , pair.first , pair.second)
        }
    }

    val triple = numbers.findTripleOfSum()
    println(triple)
    println(triple?.let { (x , y , z) -> x * y * z })

}