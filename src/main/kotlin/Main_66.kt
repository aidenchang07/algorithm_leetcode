package com.aiden

/**
 * 題目：LeetCode 66. 加一 (Plus One)
 * 類別：Array / Math
 * 難度：簡單
 * 說明：給定一個由整數陣列表示的非負整數，陣列中每個元素代表一位數字。
 *       將該整數加一後，回傳新的陣列表示結果。
 * 核心：從最後一位開始加一並處理進位，若全為9則需擴充一位。
 * 範例：
 *    Input: [9,9,9]
 *    Output: [1,0,0,0]
 * 連結：https://leetcode.com/problems/plus-one/
 */
fun main() {
    val digits = intArrayOf(1,2,3)
    val result = plusOne(digits)
    println("result: ${result.contentToString()}")
}

/**
 * 將整數陣列所表示的數字加一後回傳新的陣列。
 *
 * 解法說明：
 * 1. 從陣列最後一位開始處理加一。
 * 2. 若該位 < 9，直接加一並返回結果。
 * 3. 若該位 == 9，設為 0，並繼續向前進位。
 * 4. 若整個陣列皆為 9，例如 [9,9,9]，需建立新陣列 [1,0,0,0]。
 *
 * 時間複雜度：O(n) — 最多遍歷整個陣列一次。
 * 空間複雜度：O(n) — 在全為 9 的情況下需新建一個陣列。
 */
fun plusOne(digits: IntArray): IntArray {
    for (i in digits.lastIndex downTo 0) {
        if (digits[i] < 9) {
            digits[i]++
            return digits
        }
        digits[i] = 0
    }

    // 若所有位數皆為9，需多一位 [1,0,0,...]
    val res = IntArray(digits.size + 1)
    res[0] = 1
    return res
}