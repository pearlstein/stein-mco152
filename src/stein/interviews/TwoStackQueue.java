package stein.interviews;

import java.util.Stack;

public class TwoStackQueue {
	private Stack<String> stackA;
	private Stack<String> stackB;
	private int enqueueStack=1;
	private int dequeueStack=2;
	
	public void enqueue(String str){
		stackA.push(str);
	}
	public void dequeue(){
		while(!stackA.isEmpty()){
			stackB.push(stackA.pop());
		}
		stackB.pop();
		
		
	}
	
}
