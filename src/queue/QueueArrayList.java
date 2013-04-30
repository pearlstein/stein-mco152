package queue;

import java.util.ArrayList;

public class QueueArrayList<T> {
	
	  private  ArrayList<T> items;
	  private int front ;
	  
	  public QueueArrayList(){
		  items = new ArrayList<T>();
		  front =0;
		  
	  }
	  public boolean isEmpty(){
		  return items.isEmpty();
		  
		  
	  }
	   public void enqueue(T newItem)throws QueueException{
		
		  items.add(newItem);
		 
		 
	  }
	  public T dequeue()throws QueueException{
		  if (!items.isEmpty()){
			  T queueFront = items.get(front);
			  front +=1;
			  return queueFront;

		  }
		  else
			  throw new QueueException("Queue empty");
		  
		  
	  }
	  public void dequeueAll(){
	 	  //garbage collector will remove current array
		 items.removeAll(items);
		  front =0;
		  
	  }
	  public T peek() throws QueueException{
		  if (!items.isEmpty()){
			  return items.get(front);
		  }
		  else
			  throw new QueueException("Queue empty");
		  
	  }
	}



