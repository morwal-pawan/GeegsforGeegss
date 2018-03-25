package tree;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

// tree shape depend on insertion
// number of compare for search or insertion is equal 1 + depth of node 
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;
    private int size;
    private boolean pair;

    private class Node {
	private Key key;
	private Value value;
	private Node left, right;
	int count;

	public Node(Key key, Value value) {
	    this.key = key;
	    this.value = value;
	    this.count = 1;
	}

	public String toString() {
	    if (value == null)
		return "(" + this.key + ")";
	    return "( k:" + this.key + " V:" + this.value + ")";
	}
    }

    // query operations
    public Value get(Key key) {
	Node x = root;
	if (x == null)
	    throw new NullPointerException();
	while (x != null) {
	    int cmp = key.compareTo(x.key);
	    if (cmp < 0)
		x = x.left;
	    else if (cmp > 0)
		x = x.right;
	    else if (cmp == 0)
		return x.value;
	}
	return null;
    }

    public boolean containsKey(Key key) {
	return get(key) != null;
    }

    public boolean isEmpty() {
	return root == null;
    }
    /* Computes the number of nodes in a tree. */
    public int size() {
	return size(root);
    }

    private int size(Node x) {
	if (x == null)
	    return 0;
	else
	    return x.count;
    }

    public Value minimum() {
	if (isEmpty())
	    throw new NullPointerException(" Tree is Empty ");
	return minimum(root);
    }

    private Value minimum(Node root) {
	Node temp = root;
	while (temp.left != null)
	    temp = temp.left;
	return temp.value;
    }

    private Node minimumRecur(Node x) {
	if (x.left == null)
	    return x;
	return minimumRecur(x.left);
    }

    public Value maximum() {
	if (isEmpty())
	    throw new NullPointerException(" Tree is Empty ");
	return maximum(root);
    }

    private Value maximum(Node root) {
	Node temp = root;
	for (; temp.right != null; temp = temp.right)
	    ;

	return temp.value;
    }

    private Value maximumRecur(Node x) {
	if (x.right == null)
	    return x.value;
	return maximumRecur(x.right);
    }

    // floor: Largest key <= to given key
    public int maxDepth() {
	return maxDepth(this.root);
    }

    private int maxDepth(Node current) {

	if (current == null)
	    return 0;

	int l_depth = maxDepth(current.left);
	int r_depth = maxDepth(current.right);
	if (l_depth > r_depth)
	    return (l_depth + 1);
	else
	    return (r_depth + 1);
    }

//    Write Code to Determine if Two Trees are Identical
    public boolean identicalTrees(BST bst1, BST bst2) {
	return identicalTrees(bst1.root, bst2.root);

    }

    public boolean identicalTrees(Node current1, Node current2) {
	if (current1 == null && current2 == null)
	    return true;

//	if (current1 != null && current2 != null)
//	    return ((current1.key == current2.key) 
//		    && (identicalTrees(current1.left, current2.left))
//		    && (identicalTrees(current1.right, current2.right)));
	if(current1 != null && current2 != null) {
	    if(current1.key == current2.key)
		return ( identicalTrees(current1.left, current2.left)&&identicalTrees(current1.right, current2.right));
	    else  return false;
	}
	return false;

    }

    public Key floorRecur(Key key) {
	if (key == null)
	    throw new NullPointerException();
	Node x = floorRecur(root, key);
	if (x == null)
	    return null;
	else
	    return x.key;
    }

    private Node floorRecur(Node x, Key key) {
	if (x == null)
	    return null;
	int cmp = key.compareTo(x.key);
	if (cmp == 0)
	    return x;
	else if (cmp < 0)
	    return floorRecur(x.left, key);

	Node r = floorRecur(x.right, key);
	if (r != null)
	    return r;
	else
	    return x;
    }

    public Key floor(Key key) {
	if (key == null)
	    throw new NullPointerException();
	Node x = floor(root, key);
	if (x == null)
	    return null;
	else
	    return x.key;
    }

    private Node floor(Node x, Key key) {

	Node temp = x;
	while (temp != null) {
	    int cmp = key.compareTo(temp.key);
	    if (cmp == 0)
		return temp;
	    else if (cmp < 0)
		temp = temp.left;

	    Node r = floorRecur(temp.right, key);
	    if (r != null)
		return r;
	    else
		return temp;
	}
	return null;
    }

    // Ceiling : smallest key >= to given key
    // rank : how many keys are less then to given key
    public int rank(Key key) {
	return rank(root, key);
    }

    public int rank(Node x, Key key) {
	if (x == null)
	    return 0;
	int cmp = key.compareTo(x.key);
	if (cmp < 0)
	    return rank(x.left, key);
	else if (cmp > 0)
	    return size(x.left) + 1 + rank(x.right, key);
	else
	    return size(x.left);

    }
    // Tree Traversals

    public Queue<Key> inOrder() {
	Queue<Key> queue = new ArrayDeque<>();
	inOrder(root, queue);
	return queue;
    }

    private void inOrder(Node x, Queue<Key> queue) {
	if (x == null)
	    return;
	inOrder(x.left, queue);
	// System.out.print(x + " " );
	queue.offer(x.key);
	inOrder(x.right, queue);
    }

    public Queue<Key> inorderNonRecur() {
	if (root == null)
	    return null;
	Deque<Node> stack = new ArrayDeque<>();
	Queue<Key> queue = new ArrayDeque<>();
	Node current = root;

	while (current != null) {
	    stack.offerLast(current);
	    current = current.left;
	}

	while (stack.size() > 0) {
	    current = stack.pollLast();

	    // System.out.print(current.key+" ");
	    queue.add(current.key);

	    if (current.right != null) {
		current = current.right;

		while (current != null) {
		    stack.offerLast(current);
		    current = current.left;
		}
	    }

	}
	return queue;

    }

    public Queue<Key> preOrderNonRecur() {
	if (root == null)
	    return null;
	Deque<Node> stack = new ArrayDeque<>();
	Queue<Key> queue = new ArrayDeque<>();
	Node current = null;
	stack.offerLast(root);
	while (!stack.isEmpty()) {
	    current = stack.pollLast();
	    queue.add(current.key);
	    if (current.right != null)
		stack.offerLast(current.right);
	    if (current.left != null)
		stack.offerLast(current.left);
	}
	return queue;

    }

    public Queue<Key> preOrder() {
	Queue<Key> queue = new ArrayDeque<>();
	preOrder(root, queue);
	return queue;
    }

    private void preOrder(Node x, Queue<Key> queue) {
	if (x == null)
	    return;
	// System.out.print(x + " " );
	queue.offer(x.key);
	preOrder(x.left, queue);
	preOrder(x.right, queue);
    }

    public Queue<Key> postOrder() {

	Queue<Key> queue = new ArrayDeque<>();
	postOrder(root, queue);
	return queue;
    }

    private void postOrder(Node x, Queue<Key> queue) {
	if (x == null)
	    return;
	postOrder(x.left, queue);
	postOrder(x.right, queue);
	queue.offer(x.key);
	// System.out.print(x + " " );
    }

    public Queue<Key> postOrderNonRecur() {
	Deque<Node> stack = new ArrayDeque<>();
	Deque<Key> queue = new ArrayDeque<>();
	Node current = null;
	stack.offerLast(root);
	while (!stack.isEmpty()) {
	    current = stack.pollLast();
	    if (current.left != null)
		stack.offerLast(current.left);
	    if (current.right != null)
		stack.offerLast(current.right);
	    queue.offerFirst(current.key);
	}
	return queue;
    }

    public Queue<Key> printLevelOrder() {
	if (root == null)
	    return null;
	Queue<Node> queue = new LinkedList<Node>();
	Queue<Key> result = new ArrayDeque<>();
	queue.add(root);

	while (true) {

	    int nodeAtLevel = queue.size();
	    if (nodeAtLevel == 0)
		break;

	    while (nodeAtLevel > 0) {
		Node temp = queue.poll();
		result.offer(temp.key);
		if (temp.left != null)
		    queue.add(temp.left);
		if (temp.right != null)
		    queue.add(temp.right);

		nodeAtLevel--;
	    }
	    // System.out.println();

	}
	return result;
    }

    public HashMap<Integer, ArrayDeque<Key>> diagonalPrint() {
	HashMap<Integer, ArrayDeque<Key>> diagonal = new HashMap<>();
	diagonalPrint(diagonal, 0, this.root);
	return diagonal;
    }

    public Node lca(Node root,Key v1,Key v2)
    {
      Node temp = root;
      while(temp!=null)
      {
        if(temp.key.compareTo(v1) < 0  && temp.key.compareTo(v2) < 0)
            temp = temp.left;
        else if( temp.key.compareTo(v1) > 0  && temp.key.compareTo(v2) > 0)
            temp = temp.right;
        else  break;
      }
    return temp;
       
    }
//    boolean checkBST(Node root) {
//        Node pre = null;
//      return checkBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
//    }
//  boolean checkBST(Node current, int min, int max){
//     if(current == null) return true;
//     if(current.data < min  || current.data > max) return false;
//     return checkBST(current.left,min,current.data - 1) && checkBST(current.right,current.data + 1,max);
//  }
    public void diagonalPrint(HashMap<Integer, ArrayDeque<Key>> diagonal, int level, Node current) {
	if (current == null)
	    return;
	ArrayDeque<Key> list = diagonal.get(level);
	if (list == null) {
	    list = new ArrayDeque<>();
	    list.add(current.key);
	} else {
	    list.add(current.key);
	}
	diagonal.put(level, list);
	if (current.left != null) {
	    int i1 = level + 1;
	    diagonalPrint(diagonal, (i1), current.left);
	}

	if (current.right != null)
	    diagonalPrint(diagonal, level, current.right);

    }

    // Print a Binary Tree in Vertical Order

    public TreeMap<Integer, ArrayDeque<Key>> verticalPrint() {
	TreeMap<Integer, ArrayDeque<Key>> vertical = new TreeMap<Integer, ArrayDeque<Key>>(); // for sorted key
	verticalPrint(vertical, 0, this.root);
	for (Integer key : vertical.keySet()) {
	    for (Key value : vertical.get(key))
		System.out.print(" " + value);
	    System.out.println();
	}
	return vertical;
    }

    public void verticalPrint(TreeMap<Integer, ArrayDeque<Key>> vertical, int verticalIndex, Node current) {
	if (current == null)
	    return;
	ArrayDeque<Key> list = vertical.get(verticalIndex);
	if (list == null)
	    list = new ArrayDeque<>();
	list.add(current.key);
	vertical.put(verticalIndex, list);
	if (current.left != null)
	    verticalPrint(vertical, verticalIndex - 1, current.left);

	if (current.right != null)
	    verticalPrint(vertical, verticalIndex + 1, current.right);

    }

    public Queue<Key> reversePrintLevelOrder() {
	if (root == null)
	    return null;
	Queue<Node> queue = new LinkedList<Node>();
	Deque<Key> stack = new ArrayDeque<>();
	queue.add(root);

	while (true) {

	    int nodeAtLevel = queue.size();
	    if (nodeAtLevel == 0)
		break;

	    while (nodeAtLevel > 0) {
		Node temp = queue.poll();
		stack.offerFirst(temp.key);
		if (temp.right != null)
		    queue.add(temp.right);
		if (temp.left != null)
		    queue.add(temp.left);
		nodeAtLevel--;
	    }
	    System.out.println();

	}
	return stack;
    }
    // Modification Operations

    public void delete(Key k) {
	root = delete(root, k);
    }

    private Node delete(Node x, Key key) {
	if (x == null)
	    return null;
	int cmp = key.compareTo(x.key);
	if (cmp < 0)
	    x.left = delete(x.left, key);
	else if (cmp > 0)
	    x.right = delete(x.right, key);
	else {
	    if (x.left == null && x.right != null)
		return x.right; // node which has only left child
	    else if (x.left != null && x.right == null)
		return x.left;
	    else {
		Node t = x;
		x = minimumRecur(t.right);
		x.right = deleteMinRecur(t.right);
		x.left = t.left;

	    }

	}

	x.count = size(x.left) + 1 + size(x.right);
	return x;
    }

    public void deleteMin() {
	// root = deleteMinRecur(root);
	deleteMin(root);
    }

    public Node deleteMinRecur(Node x) {
	if (x.left == null)
	    return x.right;
	x.left = deleteMinRecur(x.left);
	x.count = size(x.left) + 1 + size(x.right);
	return x;
    }

    public void deleteMin(Node x) {
	if (x.left == null) { // if first node is minimum;
	    root = x.right;
	    return;
	}
	Node current = x;
	Node pre = null;
	for (; current.left != null;) {

	    pre = current;
	    current = current.left;
	}
	pre.left = current.right;

    }

    public void deleteMax() {
	// root = deleteMaxRecur(root);
	deleteMax(root);
    }

    private Node deleteMaxRecur(Node x) {
	if (x.right == null)
	    return x.left;
	x.right = deleteMaxRecur(x.right);
	x.count = size(x.right) + 1 + size(x.right);
	return x;
    }

    private void deleteMax(Node x) {
	if (x.right == null) { // if first node is maximum
	    root = x.left;
	    return;
	}
	Node current = x;
	Node pre = null;
	for (; current.right != null;) {
	    pre = current;
	    current = current.right;
	}
	pre.right = current.left;
    }

    private Node put(Node x, Key key, Value value) {
	if (x == null)
	    return new Node(key, value);
	int cmp = key.compareTo(x.key);
	if (cmp < 0)
	    x.left = put(x.left, key, value);
	else if (cmp > 0)
	    x.right = put(x.right, key, value);
	else if (cmp == 0)
	    x.value = value;

	x.count = size(x.left) + 1 + size(x.right);

	return x;
    }

    public void put(Key key, Value value) {
	root = put(root, key, value);
    }

    public void put(Key key) {
	this.pair = false;
	root = put(root, key, null);
    }
    
    
   
    public static void main(String[] args) throws IOException {
	Scanner in = new Scanner(new FileReader("src/files/BSTinput.txt"));

	BST<Integer, Integer> bst = new BST<>();
	int size = in.nextInt();
	while (size-- > 0) {
	    int key = in.nextInt();
	    // int value = in.nextInt();
	    bst.put(key);
	}

	TreeMap<Integer, ArrayDeque<Integer>> vertical = bst.verticalPrint();
	//
	

	in.close();

    }
    
    
}
