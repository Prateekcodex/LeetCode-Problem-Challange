class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            // Find the kth node
            ListNode kth = getKthNode(groupPrev, k);

            // Less than k nodes remaining
            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;

            // Reverse current group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {

                ListNode next = curr.next;

                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Connect previous part to reversed group
            ListNode temp = groupPrev.next;

            groupPrev.next = kth;

            // Move groupPrev to the end of reversed group
            groupPrev = temp;
        }

        return dummy.next;
    }

    private ListNode getKthNode(
        ListNode current,
        int k
    ) {

        while (current != null && k > 0) {
            current = current.next;
            k--;
        }

        return current;
    }
}