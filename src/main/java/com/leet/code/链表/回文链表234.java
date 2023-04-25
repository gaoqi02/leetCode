package com.leet.code.链表;

import java.util.List;

/**
 * @author gaoqi
 * @date 2020/3/21.
 */
public class 回文链表234 {

    public boolean isPalindrome(ListNode head) {
        // 两个指针，一个走一步，一个走两步
        if (head == null) {
            return true;
        }

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode reverseList1(ListNode head) {
        ListNode tmp = null;
        ListNode curr = head;
        while (curr.next != null) {
            ListNode nextTemp = curr.next;
            tmp = nextTemp;
            curr.next = nextTemp.next;
            tmp.next = curr;
        }
        return tmp;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


    private ListNode frontPointer;



    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }


    public boolean isPalindromedigui(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
}
