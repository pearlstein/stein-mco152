package queue;

public class QueueException extends RuntimeException {
    public QueueException(String message){
    	super(message);
    }
    public QueueException(){
    	super("Queue problem");
    }
}