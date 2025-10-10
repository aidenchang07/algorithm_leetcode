package com.aiden

/**
 * 題目：LeetCode 136. 只出現一次的數 (Single Number)
 * 類別：Array / Bit Manipulation
 * 難度：簡單
 * 說明：在非空整數陣列中，每個元素都出現兩次，只有一個元素只出現一次，找出該數。
 * 核心：使用 XOR（異或）特性，a ^ a = 0、a ^ 0 = a。
 * 連結：https://leetcode.com/problems/single-number/
 */
fun main() {
    val nums = intArrayOf(4,1,2,1,2)
    val result = singleNumber(nums)
    println("result: $result")
}

// 自己寫的，時間複雜度 O(n)、空間複雜度 O(n)
fun singleNumber(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    nums.forEach { i ->
        map[i]?.let { count ->
            map[i] = count + 1
        } ?: run {
            map[i] = 1
        }
    }
    return map.entries.first { it.value == 1 }.key
}