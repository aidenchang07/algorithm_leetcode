package com.aiden

/**
 * 題目：LeetCode 70. 爬樓梯 (Climbing Stairs)
 * 類別：Dynamic Programming / Fibonacci
 * 難度：簡單
 * 說明：每次可以爬 1 或 2 階，計算爬到第 n 階有多少種方法
 * 連結：https://leetcode.com/problems/climbing-stairs/
 * 參考資料：
 * https://www.youtube.com/watch?v=65oOtJzyJWY
 * https://youtu.be/_TfB09416G8?si=8LK5pD8nuwE23LcL&t=1056
 * https://www.stoody.com.tw/blog-detail/44
 */
fun main() {
    val n = 5
    val result = climbStairs(n)
    println("result: ${result}")
}

/**
 * 對於總階數 n，每種走法由 1 階與 2 階組成。
 * 若使用 y 次 2 階，則剩下的 1 階為 (n - 2y)，總步數為 (n - y)。
 * 每種拆法的排列數為 C(n - y, y)，即從 (n - y) 步中選出 y 個位置放 2 階。
 *
 * 累加所有合法 y（0 到 ⌊n/2⌋）的組合數，即為總走法數。
 *
 * @param n 總階數
 * @return 所有合法走法的總數
 */
fun climbStairs(n: Int): Int {
    var total = 0
    for (y in 0 .. n/2) {
        total += combination(n - y, y)
    }
    return total
}

/**
 * 計算組合數 C(sup, sub)，即從 sup 個物件中選 sub 個的方式數（不考慮順序）
 *
 * 數學定義：
 * C(n, k) = n! / (k! * (n - k)!)
 *
 * 為避免階乘溢位，改用連乘積公式：
 * C(n, k) = ∏_{i=1}^{k} (n - i + 1) / i
 *
 * 若 n 大於 100 可能要考慮預先約分的方法
 *
 * 其中：
 * - sup：上標（superscript），代表 n
 * - sub：下標（subscript），代表 k
 *
 * 當 sub = 0 時，空乘積定義為 1（C(n, 0) = 1）
 *
 * @param sup 組合數的上標 n
 * @param sub 組合數的下標 k
 * @return 組合數 C(sup, sub)
 */
fun combination(sup: Int, sub: Int): Int {
    if (sub == 0) return 1 // 空乘積直接給1
    var result = 1
    for (i in 1..sub) {
        // 會加 1 是為了 i = 1 時，要讓分子從 n 開始，定位性質
        // 會減 i 是為了要遞減乘每個數
        result *= (sup - i + 1) / i
    }
    return result
}