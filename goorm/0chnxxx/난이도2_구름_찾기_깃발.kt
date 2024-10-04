/**
 * 한 변의 길이가 N인 격자 모양의 게임판 M
 * 게임판 일부 칸엔 구름이 숨겨져 있고 모든 구름의 위치를 찾으면 승리
 * 구름을 찾기 쉽게 게임판 위에 깃발을 설치
 * 깃발은 구름이 없는 칸이면서 상하좌우와 대각선으로 인접한 8칸 중 구름이 하나 이상 있는 칸에만 설치 가능
 * 설치한 깃발에는 인접한 8칸 중 구름이 있는 칸의 갯수가 적힘
 * 깃발을 세울 수 있는 모든 칸에 깃발을 세움
 * 깃발의 값들 중 K인 깃발이 몇개인지?
 *
 * 첫번째 줄에 게임판 크기 N, 깃발의 값 K
 * 이후 줄부터 각 칸에 대한 정보가 N개씩 N줄
 *
 * 1 <= N <= 1000
 * 1 <= K <= 8
 * N, K는 정수
 * 각 칸의 정보는 0 또는 1
 */

fun main(args: Array<String>) {
    val (length, target) = readLine()!!.split(" ").map { it.toInt() }
    val board = Array(length) { IntArray(length) }
    var result = 0

    for (i in 0 until length) {
        val data = readLine()!!.split(" ").map { it.toInt() }

        for (j in 0 until length) {
            board[i][j] = data[j]
        }
    }

    for (i in 0 until length) {
        for (j in 0 until length) {
            val isCloud = board[i][j] == 1
            val cloudCount = if (!isCloud) getCloudCount(i, j, length, board) else 0

            if (cloudCount == target) {
                result++
            }
        }
    }

    println(result)
}

private fun getCloudCount(x: Int, y: Int, length: Int, board: Array<IntArray>): Int {
    var value = 0

    if (x in 0 until length && y in 0 until length && board[x][y] == 1) {
        value++
    }

    if (x in 0 until length && y - 1 in 0 until length && board[x][y - 1] == 1) {
        value++
    }

    if (x - 1 in 0 until length && y - 1 in 0 until length && board[x - 1][y - 1] == 1) {
        value++
    }

    if (x + 1 in 0 until length && y - 1 in 0 until length && board[x + 1][y - 1] == 1) {
        value++
    }

    if (x in 0 until length && y + 1 in 0 until length && board[x][y + 1] == 1) {
        value++
    }

    if (x - 1 in 0 until length && y + 1 in 0 until length && board[x - 1][y + 1] == 1) {
        value++
    }

    if (x + 1 in 0 until length && y + 1 in 0 until length && board[x + 1][y + 1] == 1) {
        value++
    }

    if (x - 1 in 0 until length && y in 0 until length && board[x - 1][y] == 1) {
        value++
    }

    if (x + 1 in 0 until length && y in 0 until length && board[x + 1][y] == 1) {
        value++
    }

    return value
}
