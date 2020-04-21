public class CircularQueue {
    private Object[] circularQueue;
    private int rear, front;

    public CircularQueue(int capacity){
        circularQueue = new Object[capacity];
        rear = -1;
        front = 0;
    }

    public void enqueue(Object data){
        if (isFull())
            System.out.println("Queue overflow");
        else{
            rear = (rear + 1) % circularQueue.length;
            circularQueue[rear] = data;
        }
    }

    public Object dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        else{
            Object retData = circularQueue[front];
            circularQueue[front] = null;
            front = (front + 1) % circularQueue.length;
            return retData;
        }
    }

    public boolean isEmpty(){
        return circularQueue[front] == null;
    }

    public boolean isFull(){
        return front == (rear + 1) % circularQueue.length && circularQueue[front] != null && circularQueue[rear] != null;
    }

    public Object peek(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        else
            return circularQueue[front];
    }

    public int size() {
        if (rear >= front)
            return rear - front + 1;
        else if (circularQueue[front] != null)
            return circularQueue.length - (front - rear) + 1;
        else
            return 0;
    }
}
