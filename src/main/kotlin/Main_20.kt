package com.aiden

/**
 * 題目：LeetCode 20. 有效的括號
 * 類別：String / Stack
 * 難度：簡單
 * 說明：判斷字串中的括號是否成對且順序正確，需符合左括號對應右括號、順序正確、無多餘括號等條件
 * 連結：https://leetcode.com/problems/valid-parentheses/
 */
fun main() {
    val s = "()"

    val s1 = "()[]{}"

    val s2 = "(]"

    val s3 = "([])"

    val s4 = "([)]"

    val result = isValid(s)
    println("result: $result")
}

/**
 * 解題思路：
 *   1. 使用 ArrayDeque 作為堆疊，存放左括號。
 *   2. 建立 Map，定義左括號對應的右括號。
 *   3. 遍歷字串：
 *      - 遇到左括號 → 入堆疊。
 *      - 遇到右括號 → 檢查堆疊頂端是否匹配。
 *   4. 若有不匹配或堆疊為空 → 回傳 false。
 *   5. 最後堆疊必須為空 → 回傳 true。
 * 時間複雜度：O(n)，每個字元最多進出堆疊一次。
 * 空間複雜度：O(n)，最壞情況下所有字元都是左括號。
 */
fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    val pairs = mapOf('(' to ')', '[' to ']', '{' to '}')
    for (c in s) {
        if (c in pairs.keys) {
            // 左括號入堆疊，等待後續匹配
            stack.add(c)
        } else {
            // 遇到右括號，檢查堆疊是否為空或不匹配
            if (stack.isEmpty()) return false
            val top = stack.removeLast()
            // 若堆疊頂端的左括號對應的右括號 != 當前字元，代表不合法
            if (pairs[top] != c) return false
        }
    }
    // 最後堆疊必須為空才合法
    return stack.isEmpty()
}