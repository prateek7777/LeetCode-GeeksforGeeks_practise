/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)       //edge case.
            return null;
        return generateBSTFromArray(nums, 0, nums.length-1);
    }
    
    public TreeNode generateBSTFromArray(int[] nums, int start, int end){
        
        if(start > end)      //edge case.
            return null;
        
        int midPoint = start + (end-start)/2;             //midPoint of the nums array for the root. (nums array is sorted).
        TreeNode node = new TreeNode(nums[midPoint]);     //starting with the root.
        node.left = generateBSTFromArray(nums, start, midPoint-1);   //the left call.(binary search). (nums array is sorted).
        node.right = generateBSTFromArray(nums, midPoint+1, end);    //the right call.(binary search). (nums array is sorted).
        return node;    //returning the root.
 
    }
}