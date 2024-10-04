/**
 * 길이가 N인 문자열 S
 * 문자열을 서로 겹치지 않는 3개의 부분문자열로 나눈다.
 * 부분문자열은 모두 길이가 1 이상이어야하며 연속해야함
 *
 * 등장하는 모든 부분문자열 그룹을 합쳐서 중복을 제거하고 사전순(오름차순)으로 정렬한 결과가 P
 * 각 부분문자열 그룹의 3개 문자열이 P에서 등장하는 순서가 점수
 *
 * 점수의 최댓값을 출력
 *
 * 첫번째 줄에 문자열 길이 N 입력
 * 두번째 줄에 문자열 S 입력
 *
 * 3 <= N <= 100
 * S는 알파벳 소문자
 */

fun main(args: Array<String>) {
    val length = readLine()!!.toInt()
    val text = readLine()!!
    val stringSet = mutableSetOf<String>()
    val splitedStrings = mutableListOf<Array<String>>()

    for (i in 1 until length - 1) {
        for (j in i + 1 until length) {
            val part1 = text.substring(0, i)
            val part2 = text.substring(i, j)
            val part3 = text.substring(j, length)

            stringSet.add(part1)
            stringSet.add(part2)
            stringSet.add(part3)
            splitedStrings.add(arrayOf(part1, part2, part3))
        }
    }

    var maxScore = 0
    val stringList = stringSet.toMutableList().sorted()

    for (splitedString in splitedStrings) {
        var score = 0

        for (string in splitedString) {
            score += stringList.indexOf(string) + 1
        }

        maxScore = maxOf(maxScore, score)
    }

    println(maxScore)
}
