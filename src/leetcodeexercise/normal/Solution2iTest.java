package leetcodeexercise.normal;

import org.junit.Test;

/**
 * @author Jay
 * @description 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * @date Created in 2020/3/10 10:35 上午
 */
public class Solution2iTest {


    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;

        l3.next = l4;
        System.out.println(addTwoNumbers(l1, l3));
    }

    /**
     * 将每一位相加，大于10则记录下来进位，
     * 在下一次迭代时相加。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 构建链表
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        // carry 为进位
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        // 构建新数据，并且将
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;

    }

}