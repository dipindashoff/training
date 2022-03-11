package javaProgrammingPart3;

public class InterviewQuestions {

    /*
    https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/solutions-451-500/487-max-consecutive-ones-ii.html
     */

    /*
    You are given an array of positive numbers from 1 to n,
    such that all numbers from 1 to n are present except one number x.
    You have to find x. The input array is not sorted.
     */

    /*
    I have an array of integers
    Find the number wt most duplicates
     */

    /*
    Remove duplicate integers in an array
    e.g. [1,1,2,3,3,3,4,5] -> [1,2,3,4,5]
     */

    /*
    Remove Duplicates from Sorted Array
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
    element appears only once. The relative order of the elements should be kept the same. Since it is impossible to
    change the length of the array in some languages, you must instead have the result be placed in the first part
    of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements
    of nums should hold the final result. It does not matter what you leave beyond the first k elements. Return k after
    placing the final result in the first k slots of nums. Do not allocate extra space for another array. You must do
    this by modifying the input array in-place with O(1) extra memory.

    int[] nums = [...]; // Input array
    int[] expectedNums = [...]; // The expected answer with correct length
    int k = removeDuplicates(nums); // Calls your implementation

    assert k == expectedNums.length;
    for (int i = 0; i < k; i++) {
        assert nums[i] == expectedNums[i];
        }
    If all assertions pass, then your solution will be accepted.

    Example 1:
    Input: nums = [1,1,2]
    Output: 2, nums = [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).

    Example 2:
    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4
    respectively.
     */

    /*
    Given a dictionary of words and an input string,
    tell whether the input string can be completely segmented into dictionary words. Return a boolean.
     */

    /*
    Write a function fib() that takes an integer n and returns the nth Fibonacci number.
    Note: The Fibonacci series is a numerical series where each item is the sum of the two previous items.
    It starts off like this: 0,1,1,2,3,5,8,13,21...
     */

    /*
    Flatten the nested arrays.
    e.g. [[[1],2],[3]],4] -> [1,2,3,4]
     */

    /*
    Write a function that returns the longest sequence of consecutive zeroes in a binary string.
    e.g.
    Input  : arr[] = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1}
    Output : 4
     */

    /*
    Sum of a 2D array
    e.g.
    Input: int a[][] = {{1, 3, 4}, {2, 3}, {7, 6, 5, 4, 3, 2, 1}, {9}, {8}};
    Output: 40

     */

    /*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Note that you must do this in-place without making a copy of the array.
    Example :
    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]
     */

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     */

    /*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
    and j != k, and nums[i] + nums[j] + nums[k] == 0.
    Notice that the solution set must not contain duplicate triplets.
    Example 1:
    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
     */
}
