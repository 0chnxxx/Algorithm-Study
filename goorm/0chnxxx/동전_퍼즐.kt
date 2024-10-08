/**
 * 무한 격자 평면 위에 몇몇 격자점에 동전이 놓여져 있다.
 * 퍼즐의 목표는 최소 개수의 동전을 옮겨서 새로운 모양을 만드는 것이다.
 * 동전을 옮길 때는 한 번에 한 개씩 동전을 들어서 빈 격자점에 놓으면 된다.
 * 회전된 모양이나 대칭된 모양을 만드는 것은 인정되지 않는다.
 *
 * 현재 동전의 배치와 만들어야 하는 동전의 배치가 주어질 때 옮겨야 하는 동전의 개수는 최소 몇 개인가?
 *
 * 첫번째 줄에 H1, W1 입력
 * 다음 H1개의 줄에는 . 은 빈칸 0 은 동전이 있는 칸으로 현재 동전의 배치인 길이 W1의 문자열이 주어진다.
 * 그 다음 줄에 H2, W2 입력
 * 다음 H2개의 줄에는 . 은 빈칸 0은 동전이 있는 칸으로 만들어야 하는 동전의 배치인 길이 W2의 문자열이 주어진다.
 *
 * 1 <= H1, W1 <= 10
 * 1 <= H2, W2 <= 10
 * 두 배치의 동전 개수는 동일하다.
 */

data class State(
    val coins: List<Pair<Int, Int>>,
    val moves: Int
)

fun main(args: Array<String>) {
    val (h1, w1) = readLine()!!.split(" ").map { it.toInt() }
    val before = Array(h1) { CharArray(w1) }

    for (i in 0 until h1) {
        val coins = readLine()!!.toCharArray()

        for (j in 0 until w1) {
            before[i][j] = coins[j]
        }
    }

    val (h2, w2) = readLine()!!.split(" ").map { it.toInt() }
    val after = Array(h2 * 3) { CharArray(w2 * 3) }

    var sol = 0

    for (i in 0 until h2) {
        val coins = readLine()!!.toCharArray()

        for (j in 0 until w2) {
            after[i + h2][j + w2] = coins[j]

            if (after[i + h2][j + w2] == 'O') {
                sol++
            }
        }
    }

    var answer = 0

    for (i in 0 .. h2 * 2) {
        for (j in 0 .. w2 * 2) {
            var count = 0

            for (k in 0 until h1) {
                for (l in 0 until w1) {
                    if (k + i < after.size && l + j < after[0].size && before[k][l] == after[k + i][l + j] && before[k][l] == 'O') {
                        count++
                    }
                }
            }

            answer = maxOf(answer, count)
        }
    }

    println(sol - answer)
}
