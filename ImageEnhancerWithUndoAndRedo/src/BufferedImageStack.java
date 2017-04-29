import java.awt.image.BufferedImage;
import java.util.*;

// Stack class to hold an array of BufferedImages for the purposes
// of holding actions to undo or redo.
public class BufferedImageStack {
	private BufferedImage[] stack;
	private int stackSize;
	
	// Base constructor with initial array size of 2 and stack size of 0.
	public BufferedImageStack(){
		stack = new BufferedImage[2];
		stackSize = 0;
	}
	
	// Pushes the argument someImage onto the stack and increments the size, doubling
	// the maximum size of the array if the stack size becomes too large.
	public void push(BufferedImage someImage){
		if (stackSize >= stack.length){
			BufferedImage[] temp = new BufferedImage[stack.length*2];
			for(int i = 0; i < stack.length; i++)
				temp[i] = stack[i];
			stack = temp;
		}
		stack[stackSize] = someImage;
		stackSize++;
	}
	
	// Returns the image at the top of the stack, throwing an EmptyStackException
	// if the stack is empty.
	public BufferedImage pop(){
		if(this.isEmpty())
			throw new EmptyStackException();
		stackSize--;
		return stack[stackSize];
	}
	
	// Returns a boolean value where true represents the stack being empty and false
	// represents the stack containing relevant elements.
	public boolean isEmpty(){
		return stackSize == 0;
	}
	
	// An un-stack-like method to retrieve the index-th BufferedImage element of the stack
	public BufferedImage get(int index){
		return stack[index];
	}
	
	// Returns the current size of the stack.
	public int getSize(){
		return stackSize;
	}
	
	// Another un-stack-like method to retrieve the current size of the underlying
	// data structure implementation of the stack (in this case an array)
	public int getArraySize(){
		return stack.length;
	}
	
	// Method for (effectively) emptying the stack in O(1) rather than O(n)
	public void clearStack(){
		stackSize = 0;
	}
	
	
}
