/**
 * 거울 단어는 알파벳을 거울에 비췄을 때 다르게 보인다.
 * 표에 없는 알파벳은 알파벳쌍이 없으며 거울 단어가 아니다.
 * 거울 단어인지 아닌지 판단
 *
 * 첫번째 줄에 단어의 갯수 N 입력
 * 이후 N줄에 단어 입력
 *
 * 1 <= N <= 1000
 * 각 단어 길이는 1 이상 100 이하
 * 알파벳은 소문자
 *
 * 단어가 거울 단어이면 Mirror 출력 아니면 Normal 출력
 */

val pairs = arrayOf(
    'b' to 'd',
    'i' to 'i',
    'l' to 'l',
    'm' to 'm',
    'n' to 'n',
    'o' to 'o',
    'p' to 'q',
    's' to 'z',
    'u' to 'u',
    'v' to 'v',
    'w' to 'w',
    'x' to 'x'
)

val mirrorAlphabets = pairs
    .filter { it.first == it.second }
    .map { arrayOf(it.first, it.second) }
    .flatMap { it.asSequence() }
    .distinct()
    .toList()

fun main(args: Array<String>) {
    val count = readLine()!!.toInt()

    for (i in 1..count) {
        val word = readLine()!!

        if (isMirror(word)) {
            println("Mirror")
        } else {
            println("Normal")
        }
    }
}

private fun isMirror(word: String): Boolean {
    val length = word.length

    // 1글자 단어일 경우 거울 단어인지
    if (length == 1 && !mirrorAlphabets.contains(word.first())) {
        return false
    }

    // 홀수 글자 단어일 경우 가운데 단어가 거울 단어인지
    if (length % 2 == 1 && (!mirrorAlphabets.contains(word[((1 + word.length) / 2) - 1]) || findPair(word[((1 + word.length) / 2) - 1]) == null)) {
        return false
    }

    for (i in 0 until length / 2) {
        val frontChar = word[i]
        val backChar = word[length - i - 1]

        val pair = findPair(frontChar)

        // 거울 단어인지
        if (pair == null) {
            return false
        }

        // 해당 쌍이 맞는지
        if (pair.first != backChar && pair.second != backChar) {
            return false
        }
    }

    return true
}

private fun findPair(char: Char): Pair<Char, Char>? {
    return pairs.find { it.first == char || it.second == char }
}
