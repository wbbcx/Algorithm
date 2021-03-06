package org.alg.algorithm.jack.第五周;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubTree {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 //recur(A, B) 函数：
//
//终止条件：
//当节点 BB 为空：说明树 BB 已匹配完成（越过叶子节点），因此返回 truetrue ；
//当节点 AA 为空：说明已经越过树 AA 叶子节点，即匹配失败，返回 falsefalse ；
//当节点 AA 和 BB 的值不同：说明匹配失败，返回 falsefalse ；
//返回值：
//判断 AA 和 BB 的左子节点是否相等，即 recur(A.left, B.left) ；
//判断 AA 和 BB 的右子节点是否相等，即 recur(A.right, B.right) ；
//isSubStructure(A, B) 函数：
//
//特例处理： 当 树 AA 为空 或 树 BB 为空 时，直接返回 falsefalse ；
//返回值： 若树 BB 是树 AA 的子结构，则必满足以下三种情况之一，因此用或 || 连接；
//以 节点 AA 为根节点的子树 包含树 BB ，对应 recur(A, B)；
//树 BB 是 树 AA 左子树 的子结构，对应 isSubStructure(A.left, B)；
//树 BB 是 树 AA 右子树 的子结构，对应 isSubStructure(A.right, B)；
//
//作者：jyd
//链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
