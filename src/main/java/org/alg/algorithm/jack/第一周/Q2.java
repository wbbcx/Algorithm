package org.alg.algorithm.jack.第一周;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/** 递归解法：
 * class Solution {
 *     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
 *         if (l1 == null) {
 *             return l2;
 *         } else if (l2 == null) {
 *             return l1;
 *         } else if (l1.val < l2.val) {
 *             l1.next = mergeTwoLists(l1.next, l2);
 *             return l1;
 *         } else {
 *             l2.next = mergeTwoLists(l1, l2.next);
 *             return l2;
 *         }
 *
 *     }
 * }
 */
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class Q2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode m = pre;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                m.next = l1;
                l1 = l1.next;
            } else {
                m.next = l2;
                l2 = l2.next;
            }
            m = m.next;
        }
        m.next = l1 == null ? l2 : l1;
        return pre.next;
    }
}


