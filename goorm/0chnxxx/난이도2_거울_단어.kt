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

val alphabets = arrayOf('b', 'd', 'i', 'l', 'm', 'n', 'o', 'p', 'q', 's', 'z', 'u', 'v', 'w', 'x')
val notMirrorAlphabets = arrayOf('b', 'd', 'p', 'q', 's', 'z')

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
    for (i in 0 until word.length) {
        val char = word[i]

        // 1글자 단어일 경우 거울 단어인지
        if (word.length == 1 && notMirrorAlphabets.contains(char)) {
            return false
        }

        // 홀수 글자 단어일 경우 가운데 단어가 거울 단어인지
        if (word.length % 2 == 1 && i == ((1 + word.length) / 2) - 1 && notMirrorAlphabets.contains(char)) {
            return false
        }

        // 거울 단어를 포함하고 있는지
        if (!alphabets.contains(char)) {
            return false
        }
    }

    return true
}
