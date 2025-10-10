package com.aiden

/**
 * 題目：LeetCode 1. 兩數之和
 * 類別：Array / HashMap
 * 難度：簡單
 * 說明：找出陣列中兩個數字加起來等於 target 的索引
 * 連結：https://leetcode.com/problems/two-sum/
 */
fun main() {
    val data = intArrayOf(2, 7, 11, 15)
    val target = 18
    val result = twoSum(data, target)
    println("result: ${result.contentToString()}")
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>() // 散列表：數值 -> 索引
    nums.forEachIndexed { index, num ->
        val key = target - num
        if (map.containsKey(key)) {
            // 找到解答，回傳搭配數值的索引與當前索引
            return intArrayOf(map[key]!!, index)
        }
        // 將目前數值與索引記錄起來
        map[num] = index
    }
    return intArrayOf()
}