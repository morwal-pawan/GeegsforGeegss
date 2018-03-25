package linklist;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class LinkList<Item extends Comparable<Item>> implements Iterable<Item> {
    private Node<Item> head;
    private Node<Item> old_list;
    private int size;

    public LinkList() {
	size = 0;
	head = null;
	old_list = null;
    }

    private class Node<Item> {
	Item item;
	Node<Item> left, right;

	public Node() {
	}

	public Node(Item item) {
	    this.item = item;
	    this.left = null;
	    this.right = null;
	}
    }

    public boolean isEmpty() {
	return head == null;
    }

    public int size() {
	return size;
    }

    @Override

    public Iterator<Item> iterator() {
	return new ListItr(head);
    }

    private class ListItr implements Iterator<Item> {
	Node<Item> current;

	public ListItr() {
	    this.current = head;
	}

	public ListItr(Node<Item> current) {
	    this.current = current;
	}

	@Override
	public boolean hasNext() {
	    return current != null;
	}

	public boolean hasPrevious() {
	    return current != null;
	}

	@Override
	public Item next() {
	    if (!hasNext())
		throw new NoSuchElementException();
	    Item item = current.item;
	    current = current.right;
	    return item;
	}

	public Item previous() {
	    if (!hasPrevious())
		throw new NoSuchElementException();
	    Item item = current.item;
	    current = current.left;
	    return item;
	}

	public void remove() {
	    if (!isEmpty())
		throw new NoSuchElementException();
	    throw new UnsupportedOperationException("remove not supported\n");
	}

    }

    public void add(Item item) {
	if (head == null) {
	    head = new Node<Item>(item);
	    size++;
	    return;
	}

	Node<Item> oldHead = head;
	head = new Node<Item>(item);
	head.right = oldHead;
	size++;
    }

    public void addFirst(Item item) {
	this.add(item);
    }

    public void addLast(Item item) {
	Node<Item> temp = head;
	if (head == null) {
	    head = new Node<Item>(item);
	    size++;
	    return;
	}
	for (; temp.right != null; temp = temp.right)
	    ;
	temp.right = new Node<Item>(item);
	size++;
	return;
    }

    public void addLastRecur(Item item) {
	head = addLastRecur(head, item);
	return;
    }

    public Node<Item> addLastRecur(Node<Item> current, Item item) {
	if (current == null)
	    return new Node<Item>(item);
	current.right = addLastRecur(current.right, item);
	return current;
    }

    public Item remove() {
	if (!isEmpty())
	    throw new NoSuchElementException();
	Item item = head.item;
	head = head.right;
	size--;
	return item;
    }

    public void printList() {
	System.out.println(" printing list");
	for (Node<Item> temp = this.head; temp != null; temp = temp.right)
	    System.out.print(" " + temp.item);
	System.out.println();
    }

    public void print() {
	System.out.println(" list");
	for (Item value : this)
	    System.out.print(" " + value);
	System.out.println();
    }

    // all methods are no recursive
    /* Given a key, deletes the first occurrence of key in linked list */
    public void deleteNode(Item key) {
	Node<Item> temp = head, pre = null;
	if (head != null && head.item == key) {
	    head = temp.right;
	    size--;
	    return;
	}
	for (; temp != null && temp.item != key;) {
	    pre = temp;
	    temp = temp.right;
	}
	if (temp == null)
	    return;
	pre.right = temp.right;
	size--;
    }

    public void deleteRecu(Item key) {
	head = deleteRecu(head, key);
	return;
    }

    private Node<Item> deleteRecu(Node<Item> current, Item key) {
	if (current == null)
	    return current;
	if (current != null && current.item == key)
	    return current.right;
	current.right = deleteRecu(current.right, key);
	return current;
    }

    public void deleteFirst() {
	deleteAtPosi(1);
    }

    public void deleteLast() {
	deleteAtPosi(size);
    }

    public void deleteAtPosi(int posi) {
	Node<Item> temp = head, pre = null;
	int index = 1;
	if (head == null)
	    return;
	if (head != null && index == posi) {
	    head = temp.right;
	    size--;
	    return;
	}
	for (; temp != null && index != posi; ++index) {
	    pre = temp;
	    temp = temp.right;
	}
	if (temp == null)
	    return;
	if (index == posi) {
	    pre.right = temp.right;
	    size--;
	}

    }

    public void deleteAtPosiRecur(int posi) {
	head = deleteAtPosiRecur(head, posi);
	return;
    }

    private Node<Item> deleteAtPosiRecur(Node<Item> current, int posi) {
	if (current == null)
	    return current;
	if (current != null && posi == 1) {
	    size--;
	    return current.right;
	}
	current.right = deleteAtPosiRecur(current.right, --posi);
	return current;
    }

    // Delete nodes which have a greater value on right side
    public void delLessRNode() {
	this.reverse();
	this.print();
	Node<Item> next = head;
	Node<Item> current = head;
	Node<Item> temp = null;

	for (; current != null && current.right != null;) {

	    Item item2 = next.item;
	    Item item1 = current.right.item;
	    System.out.println(item1 + " " + item2);
	    if (item1.compareTo(item2) < 0) {
		temp = current.right;
		current.right = temp.right;
		temp.right = null;
		temp = null;
	    } else {
		current = current.right;
		next = current;
	    }
	}
	this.reverse();
    }

    // Segregate even and odd nodes in a Linked List
    public void segregateEvenOdd() {
	LinkList<Item> list2 = new LinkList<Item>();
	Node<Item> next = head.right;
	Node<Item> current = head;

	for (; next.right != null && current != null;) {
	    if ((Integer) head.item % 2 == 0) {

		list2.addLast(head.item);
		head = head.right;
		current = head;
		next = head.right;
	    } else if ((Integer) current.right.item % 2 == 0) {
		list2.addLast(current.right.item);
		next = next.right;
		current.right = next;
	    } else {
		current = next;
		next = next.right;
	    }

	}
	Node<Item> last = list2.head;
	while (last.right != null)
	    last = last.right;
	last.right = this.head;
	this.head = list2.head;

    }

    public void detectAndRemoveLoop() {

	if (head == null || head.right == null)
	    return;
	Node<Item> slow = head, fast = head;
	slow = slow.right;
	fast = fast.right.right;

	while (fast != null && fast.right != null) {
	    if (slow == fast)
		break;
	    slow = slow.right;
	    fast = fast.right.right;
	}

	// If loop exists
	if (slow == fast) {
	    slow = head;
	    while (slow.right != fast.right) {
		slow = slow.right;
		fast = fast.right;
	    }

	    // since fast->next is the looping point
	    fast.right = null; /* remove loop */
	}
    }

    public int length() {
	int len = 0;
	for (Node<Item> temp = head; temp != null; temp = temp.right, ++len)
	    ;

	return len;
    }

    public int lengthRecur() {
	return lengthRecur(head);
    }

    private int lengthRecur(Node<Item> current) {
	if (current == null)
	    return 0;
	return lengthRecur(current.right) + 1;
    }

    public boolean seach(Item item) {
	for (Node<Item> temp = head; temp != null; temp = temp.right)
	    if (item == temp.item)
		return true;
	return false;
    }
    public boolean contains(Item item) {
	for (Node<Item> temp = head; temp != null; temp = temp.right)
	    if (item == temp.item)
		return true;
	return false;
    }
    public boolean seachRecur(Item item) {
	return searchRecur(head, item);
    }

    public boolean searchRecur(Node<Item> current, Item item) {
	if (current == null)
	    return false;
	if (current.item == item)
	    return true;
	return searchRecur(current.right, item);

    }
//    Sort a linked list of 0s, 1s and 2s
    public void sortList(LinkList<Integer> list) {
	int[] count = {0,0,0};
	LinkList<Integer> result = new LinkList<Integer>();
	for(Node<Item> temp = (LinkList<Item>.Node<Item>) list.head; temp!=null; temp= temp.right)
	    count[(Integer)temp.item]++;
	for(int index = 0; index <count.length; index++)
	{
	    while(count[index]-- > 0)
		result.addLast(index);
	}
	list.head = result.head;
    }
    public void swap(Item x, Item y) {
	
	if (x == y)
	    return;
	 System.out.println("hi");
	boolean[] found = new boolean[2];
	Node<Item> currX = head, currY = head, preX = null, preY = null;
	for (; currX != null || currY != null;) {
	    if (currX.item == x)
		found[0] = true;
	    if (currY.item == y)
		found[1] = true;
	    if (!found[0]) {
		preX = currX;
		currX = currX.right;
	    }
	    if (!found[1]) {
		preY = currY;
		currY = currY.right;
	    }
	    if (found[0] && found[1])
		break;
	}

	if (currX == null || currY == null)
	    return;

	if (preX != null)
	    preX.right = currY;
	else
	    head = currY;

	if (preY != null)
	    preY.right = currX;
	else
	    head = currX;

	Node<Item> temp = currX.right;
	currX.right = currY.right;
	currY.right = temp;

    }
    public void swap(Node<Item>head,Node<Item> x1, Node<Item> y1) {
	Item  x = x1.item;
	Item y = y1.item;
	if (x == y)
	    return;
	   
	boolean[] found = new boolean[2];
	Node<Item> currX = head, currY = head, preX = null, preY = null;
	for (; currX != null || currY != null;) {
	    if (currX.item == x)
		found[0] = true;
	    if (currY.item == y)
		found[1] = true;
	    if (!found[0]) {
		preX = currX;
		currX = currX.right;
	    }
	    if (!found[1]) {
		preY = currY;
		currY = currY.right;
	    }
	    if (found[0] && found[1])
		break;
	}

	if (currX == null || currY == null)
	    return;

	if (preX != null)
	    preX.right = currY;
	else
	    head = currY;

	if (preY != null)
	    preY.right = currX;
	else
	    head = currX;

	Node<Item> temp = currX.right;
	currX.right = currY.right;
	currY.right = temp;

    }
//    Pairwise swap elements of a given linked list by changing links
    public void swapPairWise() {
	Node<Item> first,second,temp;
	temp = head;
	first = this.head;
	second = this.head.right;
	for(; first!=null&&second!=null&&temp!=null; first= first.right.right,second=second.right.right)
	{ 
	    swap(first.item, second.item);
	}
    }
    public Item get(int index) {
	Node<Item> temp = head;
	if (index < 0 && index > this.size())
	    return null;
	for (; temp != null && index != 1; temp = temp.right, --index)
	    ;
	if (temp == null)
	    return null;

	return temp.item;
    }

    public Item getRecur(int index) {
	return getRecur(head, index);
    }

    private Item getRecur(Node<Item> current, int index) {
	if (current == null || (index < 0 && index > this.size()))
	    return null;
	if (current != null && index == 1)
	    return current.item;
	return getRecur(current.right, --index);
    }

    public Item getMiddle() {
	int size = this.size();
	if (size % 2 == 0)
	    return get(size / 2 + 1);
	else
	    return get(size / 2 + 1);
    }

    public Item middle() {
	if (head == null)
	    return null;
	Node<Item> slow = head, fast = head;
	for (; fast != null && fast.right != null; slow = slow.right, fast = fast.right.right)
	    ;
	return slow.item;
    }

    public Item middleRecur() {
	if (head == null)
	    return null;
	Node<Item> slow = head, fast = head;
	return middleRecur(slow, fast);
    }

    private Item middleRecur(Node<Item> slow, Node<Item> fast) {
	if (fast == null || fast.right == null)
	    return slow.item;
	return middleRecur(slow.right, fast.right.right);
    }

    public Item getNthLast(int n) {
	if (n < 0 && n > this.size())
	    return null;
	return get(this.size() - n + 1);
    }

    public void deleteList() {
	Scanner in = new Scanner(System.in);
	System.out.println(
		"You are going to delete the list\n Ente 1 for Not To Delete \n Enter any Key for To Delete\n");
	int value = in.nextInt();
	in.nextLine();
	if (value == 1) {
	    this.old_list = this.head;
	    this.head = null;
	    System.out.println(
		    "You have Successfully deleted the list\n \t\t but \n << You Can RECOVER IT >> USING recover() Method\n ");
	} else
	    ;
	in.close();

    }

    public void recover() {
	Scanner in = new Scanner(System.in);
	System.out.println(
		"You want to recove the deleted list\n press 1 for Recove \n press any key for Not To recover\n");
	int value = in.nextInt();
	if (value == 2 && old_list != null) {
	    this.head = this.old_list;
	    this.old_list = null;
	    System.out.println("You Have Successfully  Recovered The list\n");
	} else
	    ;
	in.close();
    }

    public int counts(Item number) {
	int count = 0;
	for (Node<Item> temp = head; temp != null; temp = temp.right)
	    if (temp.item == number)
		count++;
	return count;
    }

    public int countRecur(Item number) {
	return countRecur(head, number);
    }

    private int countRecur(Node<Item> current, Item number) {

	if (current == null)
	    return 0;
	if (current.item == number)
	    return 1 + countRecur(current.right, number);
	else
	    return countRecur(current.right, number);
    }

    public void reverse() {
	Node<Item> pre = null;
	Node<Item> current = head, next = null;
	while (current != null) {
	    next = current.right;
	    current.right = pre;
	    pre = current;
	    current = next;
	}

	head = pre;
    }

    public LinkList<Item> reverse(int k) {
	LinkList<Item> result = this;
	result.head = reverse(result.head, k);
	return result;
    }

    public Node<Item> reverse(Node<Item> head, int k) {
	Node<Item> pre = null;
	Node<Item> next = null;
	Node<Item> current = head;
	int count = 0;
	while (current != null && count < k) {
	    next = current.right;
	    current.right = pre;
	    pre = current;
	    current = next;
	    count++;
	}
	if (next != null)
	    head.right = reverse(next, k);

	return pre;

    }

    public void reverseRecur() {
	Node<Item> current = head;
	if (head == null || head.right == null)
	    return;
	reverseRecur(head);
	current.right = null;
    }

    private void reverseRecur(Node<Item> current) {
	if (current.right == null) {
	    head = current;
	    return;
	}
	reverseRecur(current.right);
	current.right.right = current;
    }

    public void reverseRecur1() {
	Node<Item> current = head;
	if (current == null || current.right == null)
	    return;
	reverseRecur1(current);
	return;
    }

    private Node<Item> reverseRecur1(Node<Item> current) {
	if (current.right == null) {
	    head.right = null;
	    head = current;
	    return head;
	}
	Node<Item> temp = reverseRecur1(current.right);
	temp.right = current;
	return current;
    }

    public boolean detectLoop() {
	Node<Item> slow = head;
	Node<Item> fast = head;
	for (; fast != null && fast.right != null; slow = slow.right, fast = fast.right.right)
	    if (fast == slow)
		return true;

	return false;
    }

    public boolean detectLoopRecur() {
	Node<Item> slow = head, fast = head;
	return detectLoopRecur(slow, fast);
    }

    @SuppressWarnings("null")
    private boolean detectLoopRecur(Node<Item> slow, Node<Item> fast) {
	if (fast != null || fast.right != null)
	    return false;
	if (slow == fast)
	    return true;
	return detectLoopRecur(slow.right, fast.right.right);
    }

    boolean hasCycle(Node<Item> head) {
	Set<Node<Item>> set = new HashSet<>();
	for (; head != null; head = head.right) {
	    if (!set.add(head))
		return true;
	}

	return false;
    }

    public boolean isPalindrome() {
	Node<Item> old = head;

	this.reverse();
	Node<Item> temp = head;
	for (; temp != null && old != null; temp = temp.right, old = old.right)
	    if (temp.item != old.item) {
		this.reverse();
		return false;
	    }
	this.reverse();
	return true;

    }

    public boolean isPalindormeRecur() {
	Node<Item> old = head, temp = head;
	boolean flag = false;
	flag = isPalindormeRecur(flag, temp);
	head = old;
	return flag;
    }

    private boolean isPalindormeRecur(boolean flag, Node<Item> current) {
	if (current.right == null)
	    if (current.item == head.item) {

		head = head.right;
		return true;
	    } else
		return false;
	flag = isPalindormeRecur(flag, current.right);
	if (flag) {
	    if (current.item == head.item) {
		head = head.right;
		return true;
	    } else
		return false;
	}

	return flag;
    }

    public Item getIntesectionNode(Node<Item> headA, Node<Item> headB) {
	Set<Node<Item>> set = new HashSet<>();
	for (Node<Item> temp = headA; temp != null; temp = temp.right)
	    set.add(temp);
	for (Node<Item> temp = headB; temp != null; temp = temp.right) {
	    if (!set.add(temp))
		return temp.item;
	}
	return null;
    }

    // Say you start with:
    //
    // A-->B-->C
    // 	       |
    // 	       V
    // 1-->2-->3--null
    // 1) Go through the first list setting each next pointer to NULL.
    //
    // Now you have:
    //
    // A B C
    //
    // 1-->2-->3 4 5
    //
    // 2) Now go through the second list and wait until you see a NULL, that is your
    // merge point.
    //
    Item getIntesectionNodeB(Node<Item> headA, Node<Item> headB) {
	Node<Item> temp = null;
	Node<Item> pre = null;
	temp = headA;
	while (temp.right != null) {
	    pre = temp;
	    temp = temp.right;
	    pre.right = null;
	}
	for (temp = headB; temp.right != null; temp = temp.right)
	    ;

	return temp.item;
    }

    public void moveToFront() {
	Node<Item> old = head;
	Node<Item> walk = head;
	for (; walk.right.right != null; walk = walk.right)
	    ;
	head = walk.right;
	walk.right = null;
	head.right = old;
    }

    public void moveTOFrontRecur() {
	Node<Item> walk = head;
	moveToFrontRecur(walk);

    }

    private void moveToFrontRecur(Node<Item> walk) {
	if (walk.right.right == null) {
	    Node<Item> old = head;
	    head = walk.right;
	    walk.right = null;
	    head.right = old;
	    return;
	}
	moveToFrontRecur(walk.right);
    }

    public void printReverseRecur() {
	Node<Item> walk = head;
	System.out.println(" print the list Recursively");
	printReverseRecur(walk);
    }

    private void printReverseRecur(Node<Item> walk) {
	if (walk == null)
	    return;
	printReverseRecur(walk.right);
	System.out.print(" " + walk.item);
    }

    public LinkList<Item> sortedIntersect(Node<Item> first, Node<Item> second) {
	LinkList<Item> result = new LinkList<>();
	Node<Item> walk_first = first;
	Node<Item> walk_second = second;

	while (walk_first != null && walk_second != null) {
	    Item item1 = walk_first.item;
	    Item item2 = walk_second.item;
	    int cmp = item1.compareTo(item2);
	    if (cmp < 0)
		walk_first = walk_first.right;
	    else if (cmp > 0)
		walk_second = walk_second.right;
	    else {
		result.addLast(walk_first.item);
		walk_first = walk_first.right;
		walk_second = walk_second.right;
	    }

	}
	return result;

    }

    public LinkList<Item> sortedIntersectRecur(Node<Item> first, Node<Item> second) {
	LinkList<Item> result = new LinkList<Item>();
	return sortedIntersectRecur(result, first, second);
    }

    private LinkList<Item> sortedIntersectRecur(LinkList<Item> result, Node<Item> first, Node<Item> second) {
	if (first == null || second == null)
	    return result;
	Item item1 = first.item;
	Item item2 = second.item;
	int cmp = item1.compareTo(item2);
	if (cmp < 0)
	    result = sortedIntersectRecur(result, first.right, second);
	else if (cmp > 0)
	    result = sortedIntersectRecur(result, first, second.right);
	else {
	    result.addLast(first.item);
	    result = sortedIntersectRecur(result, first.right, second.right);
	}

	return result;

    }

    public boolean areIdentical(LinkList<Item> first, LinkList<Item> second) {
	Node<Item> firstA = first.head;
	Node<Item> secondB = second.head;
	for (; firstA != null && secondB != null; firstA = firstA.right, secondB = secondB.right)
	    if (firstA.item != secondB.item)
		return false;
	if (firstA == null && secondB != null)
	    return false;
	else if (firstA != null && secondB == null)
	    return false;
	return true;

    }

    public boolean areIdenticalRecur(LinkList<Item> first, LinkList<Item> second) {
	Node<Item> firstA = first.head;
	Node<Item> secondB = second.head;
	boolean flag = false;
	return areIdenticalRecur(firstA, secondB, flag);

    }

    public boolean areIdenticalRecur(Node<Item> first, Node<Item> second, boolean flag) {
	if ((first != null && second == null) || (first == null && second != null)) {
	    System.out.println("length of  list are not equal");
	    return false;
	}

	if (first == null && second == null)
	    return true;
	flag = areIdenticalRecur(first.right, second.right, flag);
	if (flag) {
	    if (first.item == second.item)
		return true;
	    else
		return false;
	}
	return flag;
    }

    // Add two numbers represented by linked lists | Set 1
    public LinkList<Integer> addTwoLists(LinkList<Item> l1, LinkList<Item> l2) {
	LinkList<Integer> result = new LinkList<>();
	l1.reverse();
	l2.reverse();
	Node<Item> temp1 = l1.head;
	Node<Item> temp2 = l2.head;
	int num1 = 0;
	int num2 = 0;
	for (; temp1 != null; temp1 = temp1.right)
	    num1 = num1 * 10 + (Integer) temp1.item;
	for (; temp2 != null; temp2 = temp2.right)
	    num2 = num2 * 10 + (Integer) temp2.item;
	int sum = num1 + num2;
	while (sum > 0) {
	    result.addLast(sum % 10);
	    sum = sum / 10;
	}

	l1.reverse();
	l2.reverse();
	return result;

    }
//    Multiply two numbers represented by Linked Lists
    public LinkList<Integer> multiplyTwoLists(LinkList<Item> l1, LinkList<Item> l2) {
   	LinkList<Integer> result = new LinkList<>();
   	Node<Item> temp1 = l1.head;
   	Node<Item> temp2 = l2.head;
   	int num1 = 0;
   	int num2 = 0;
   	for (; temp1 != null; temp1 = temp1.right)
   	    num1 = num1 * 10 + (Integer) temp1.item;
   	for (; temp2 != null; temp2 = temp2.right)
   	    num2 = num2 * 10 + (Integer) temp2.item;
   	int sum = num1 * num2;
   	while (sum > 0) {
   	    result.addLast(sum % 10);
   	    sum = sum / 10;
   	}

   	return result;

       }
    public LinkList<Item> deleteAlter(LinkList<Item> list) {
	LinkList<Item> result = new LinkList<Item>();
	Node<Item> temp = list.head;
	for (; temp != null && temp.right != null; temp = temp.right.right) {
	    Item item = temp.item;
	    result.addLast(item);
	}
	if (temp != null)
	    result.addLast(temp.item);
	return result;

    }

    public LinkList<Item> deleteAlterA(LinkList<Item> list) {
	LinkList<Item> result = new LinkList<Item>();
	result.head = list.head;
	Node<Item> temp = result.head;
	while (temp != null && temp.right != null) {
	    temp.right = temp.right.right;
	    temp = temp.right;
	}

	if (temp != null)
	    result.addLast(temp.item);
	return result;

    }

    public LinkList<Item> deleteAterRecur(LinkList<Item> list) {
	LinkList<Item> result = new LinkList<Item>();
	result.head = list.head;
	Node<Item> temp = result.head;
	result.head = deleteAterRecur(head);
	return result;
    }

    @SuppressWarnings("unchecked")
    public LinkList<Item>[] IntersectionAndUnion(LinkList<Item> l1, LinkList<Item> l2) {
	LinkList<Item>[] result = (LinkList<Item>[]) new LinkList[2]; // tack care of it
	for (int i = 0; i < result.length; i++)
	    result[i] = new LinkList<Item>();

	int len1 = l1.length();
	int len2 = l2.length();
	if (len1 < len2) {
	
	    for (Node<Item> temp = l1.head; temp != null; temp = temp.right)
		result[0].addFirst(temp.item);

	    for (Node<Item> walk = l2.head; walk != null; walk = walk.right)
		if (l1.contains(walk.item))
		    result[1].addFirst(walk.item); // intersection
		else
		    result[0].addFirst(walk.item); // union
	} else {
	
	    for (Node<Item> temp = l2.head; temp != null; temp = temp.right)
		result[0].addFirst(temp.item);

	    for (Node<Item> walk = l1.head; walk != null; walk = walk.right)
		if (l2.contains(walk.item))
		    result[1].addFirst(walk.item); // intersection
		else
		    result[0].addFirst(walk.item); // union
	}
	return result;

    }

    public Node<Item> deleteAterRecur(Node<Item> current) {
	if (current == null || current.right == null)
	    return current;
	current.right = deleteAterRecur(current.right.right);
	return current;
    }

    public static void main(String[] args) throws IOException {
	Scanner in = new Scanner(new FileReader("src/files/listInput.txt"));

	LinkList<Integer> list1 = new LinkList<>();
	int size = in.nextInt();
	while (size-- > 0) {
	    int item = in.nextInt();
	    list1.addLast(item);
	}
	LinkList<Integer> list2 = new LinkList<>();
	size = in.nextInt();
	while (size-- > 0) {
	    int item = in.nextInt();
	    list2.addLast(item);
	}
	list1.print();
	list2.print();
	in.close();

    }

}
