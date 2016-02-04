import java.util.Queue;
import java.util.Stack;

/**
 * Created by nikhandelwal on 1/24/2016.
 */
public class QueueUsingStacks  {

    Stack<Integer> forward = new Stack<>();
    Stack<Integer> reverse = new Stack<>();


    public void push(int i){
        forward.push(i);
    }

    public int poll(){

        if (!reverse.isEmpty()){
            return reverse.pop();
        }
        else{
            while(!forward.isEmpty()){
             reverse.push(forward.pop());

            }
            return reverse.pop();
        }
    }

    public int peek(){

        if (!reverse.isEmpty()){
            return reverse.peek();
        }
        else{
            while(!forward.isEmpty()){
                reverse.push(forward.pop());

            }
            return reverse.peek();
        }
    }

    public boolean isEmpty(){
        return forward.isEmpty()&&reverse.isEmpty();
    }



}
