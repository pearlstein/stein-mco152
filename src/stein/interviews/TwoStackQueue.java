package stein.interviews;

import java.util.Stack;

public class TwoStackQueue {
	private Stack<String> stackA;
	private Stack<String> stackB;
	private Stack<String> enqueueStack;
	private Stack<String> dequeueStack;
	
	public TwoStackQueue(Stack<String> a, Stack<String> b){
		enqueueStack=stackA=a;
		dequeueStack=stackB=b;
	}
	public void enqueue(String str){
		while(!dequeueStack.isEmpty()){
			enqueueStack.push(dequeueStack.pop());
		}
		enqueueStack.push(str);
	}
	public void dequeue(){
		while(!enqueueStack.isEmpty()){
			dequeueStack.push(stackA.pop());
		}
		System.out.println(stackB.pop());
		
		
	}
	public static void main(String[] args){
		Stack<String> stackA=new Stack<String>();
		Stack<String> stackB=new Stack<String>();
		
		TwoStackQueue x=new TwoStackQueue(stackA,stackB);
		
		x.enqueue("A");
		x.enqueue("B");
		x.enqueue("C");
		
		x.dequeue();
		x.dequeue();
		
		x.enqueue("D");
		x.enqueue("E");
		
		x.dequeue();
		x.dequeue();
		x.dequeue();
			
	}
	
}
