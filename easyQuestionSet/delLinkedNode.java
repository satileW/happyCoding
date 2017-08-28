//Write a function to delete a node (except the tail) in a singly linked list,
// given only access to that node
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode pre = null;
        while(node.next != null){
            node.val = node.next.val;
            pre = node;
            node = node.next;
        }
        pre.next = null;
    }
}
//for this question, you can think about
//if in a singly linked list you want to delete the tail node,
//how could you do that?
//You need get tail node's previous node, then make previousNode.next = null

//So, get back to this question: I don't have the head of the singly list
//but the node X I want to delete is not tail,
//this mean I can move the value of node X to the tail
//while I also record the previous node of tail node
//then I can do same thing : previousNode.next = null
