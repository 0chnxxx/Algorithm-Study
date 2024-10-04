/**
 * 로봇 청소기의 예약 청소 기능
 * 주변을 청소하다 사용자가 설정한 시간과 장소에 정확히 도착
 *
 * 로봇 청소기의 초기 위치는 (0, 0)
 * 로봇 청소기는 1초에 한 번 움직이고 상하좌우 중 하나의 방향으로 1만큼 이동
 * 동일한 장소를 다시 방문할 수 있음
 * N초의 시간 후 로봇 청소기가 (X, Y) 위치에 있어야함
 *
 * 첫번째 줄에 테스트 케이스 갯수 T 입력
 * 다음 T줄에 X, Y, N 입력
 *
 * 1 <= T <= 10
 * -10^9 <= X, Y <= 10^9
 * 1 <= N <= 2*10^9
 */

fun main(args: Array<String>) {
    val count = readLine()!!.toInt()

    for (i in 1..count) {
        val (x, y, second) = readLine()!!.split(" ").map { it.toInt() }

        if (isPossible(x, y, second)) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

private fun isPossible(x: Int, y: Int, second: Int): Boolean {
    val sum = Math.abs(x) + Math.abs(y)

    return (sum <= second) && ((sum - second) % 2 == 0)
}
