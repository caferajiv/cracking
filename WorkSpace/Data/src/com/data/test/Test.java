package com.data.test;

import com.data.list.DoubleLinkedList;
import com.data.list.LinkedList;
import com.data.queue.Queue;
import com.data.stack.Stack;
import com.data.tree.BinarySearchTree;

public class Test {
	public static void main(String args[]){
		//stackTest();
		//queueTest();
		//linkedListTest();
		//doubleLinkedListTest();
		bsTreeTest();
		
	}
	
	public static void stackTest(){
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.showStack();
		System.out.println(stack.pop());
		stack.showStack();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.showStack();
	}
	
	public static void queueTest(){
		Queue queue = new Queue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.showQueue();
		System.out.println(queue.dequeue());
		queue.showQueue();
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.showQueue();
		queue.enqueue(1);
		queue.showQueue();
		
		
	}
	
	public static void linkedListTest(){
		LinkedList linkedList = new LinkedList();
		linkedList.addLast(1);
		linkedList.addFirst(2);
		linkedList.showLinkedList();
		linkedList.addLast(3);
		linkedList.addLast(4);
		linkedList.addLast(5);
		linkedList.addLast(6);
		linkedList.addLast(7);
		linkedList.showLinkedList();
		linkedList.addFirst(8);
		linkedList.showLinkedList();
		linkedList.insertAtLoc(9, 4);
		linkedList.showLinkedList();
		linkedList.remove(4);
		linkedList.showLinkedList();
		linkedList.removeFirst();
		linkedList.showLinkedList();
		System.out.println(linkedList.removeLast());
		linkedList.showLinkedList();
		linkedList.search(9);
		linkedList.showLinkedList();
		linkedList.reverse();
		linkedList.showLinkedList();
		
		
		
	}
	
	public static void doubleLinkedListTest(){
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.addLast(1);
		doubleLinkedList.addFirst(2);
		doubleLinkedList.showDoubleLinkedList();
		doubleLinkedList.addLast(3);
		doubleLinkedList.addLast(4);
		doubleLinkedList.addLast(5);
		doubleLinkedList.addLast(6);
		doubleLinkedList.addLast(7);
		doubleLinkedList.addFirst(8);
		doubleLinkedList.showDoubleLinkedList();
		doubleLinkedList.insertAtLoc(9, 4);
		doubleLinkedList.showDoubleLinkedList();
		doubleLinkedList.showDoubleLinkedList();
		System.out.println(doubleLinkedList.remove(4));
		doubleLinkedList.showDoubleLinkedList();
		doubleLinkedList.removeFirst();
		doubleLinkedList.showDoubleLinkedList();
		System.out.println(doubleLinkedList.removeLast());
		doubleLinkedList.showDoubleLinkedList();
		doubleLinkedList.search(9);
		doubleLinkedList.showDoubleLinkedList();
		
		
		
		
	}
	
	public static void bsTreeTest(){
		BinarySearchTree bsTree= new BinarySearchTree();
		bsTree.addChild(1);
		bsTree.addChild(4);
		bsTree.addChild(5);
		bsTree.addChild(2);
		bsTree.addChild(7);
		bsTree.addChild(3);
		bsTree.addChild(6);
		bsTree.addChild(9);
		bsTree.addChild(8);
		bsTree.inOrderTraversal();
		bsTree.preOrderTraversal();
		bsTree.postOrderTraversal();
		bsTree.removeChild(1);
		bsTree.inOrderTraversal();
		//bsTree.breadthFirstTraversal();
		
	} 

}
