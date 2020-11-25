package com.tony.day3;

import com.tony.TreeNode;

/**
 * @ClassName
 * Description 好像没有用到KMP算法
 * @Author hzf
 * @Date 2020/11/25 19:31
 */
public class Solution {
    //子结构
    public Boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        Boolean result = false;

        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = ifAhasB(root1, root2);
            }
            // 先判断左边
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            // 再判断右边
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;

    }

    public Boolean ifAhasB(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return true;
        }
        if (root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return ifAhasB(root1.left, root2.left) && ifAhasB(root1.right, root2.right);
    }
}
