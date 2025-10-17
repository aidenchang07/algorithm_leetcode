package com.aiden

/**
 * 題目：LeetCode 704. 二分搜尋 (Binary Search)
 * 類別：Array / Binary Search
 * 難度：簡單
 * 說明：給定一個遞增排序的整數陣列與目標值 target，
 *       若目標存在於陣列中，回傳其索引；否則回傳 -1。
 *
 * 解法說明：
 * 1. 設定左右邊界 left、right。
 * 2. 重複取中間索引 mid，比較 nums[mid] 與 target。
 * 3. 若相等回傳索引；
 *    若 mid 值小於 target，向右收縮；
 *    若 mid 值大於 target，向左收縮。
 * 4. 若搜尋結束仍未找到，回傳 -1。
 *
 * 連結：https://leetcode.com/problems/binary-search/
 */
fun main() {
    val nums = intArrayOf(-1,0,3,5,9,12)
    val target = 9
    val result = binarySearch(nums, target)
    println("result: ${result}")
}

/**
 * 使用二分搜尋法 (Binary Search) 在排序好的整數陣列中尋找目標值。
 *
 * @param nums   已遞增排序的整數陣列
 * @param target 要查找的目標值
 * @return 若找到目標，回傳索引；否則回傳 -1
 *
 * 時間複雜度：O(log n)  — 每次迴圈都將搜尋範圍縮小一半。
 * 空間複雜度：O(1)      — 僅使用固定變數。
 */
fun binarySearch(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.lastIndex
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) {
            return mid
        }
        if (nums[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return -1
}