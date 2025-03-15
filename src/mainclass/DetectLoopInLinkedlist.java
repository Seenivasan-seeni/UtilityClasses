package mainclass;

class ListNode {
	int key;
	ListNode next;
	
	ListNode(int key){
		this.key = key;
		next = null;
	}
}

public class DetectLoopInLinkedlist {
	
	public boolean hasCycle(ListNode node) {
		ListNode slow = node;
		ListNode fast = node;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) 
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = node;  //Detected loop in the Linked list
		DetectLoopInLinkedlist detectLoopInLinkedlist = new DetectLoopInLinkedlist();
		System.out.println(detectLoopInLinkedlist.hasCycle(node));
	}

}
