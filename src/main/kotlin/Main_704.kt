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

}