package com.thiagoh.data_structures;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class StackTest {

	@Test
	public void test_push() {
		
		Stack stack = new Stack();
		
		Assert.assertEquals(stack.size(), 0);
		
		stack.push(10);
		stack.push(1);
		stack.push(2);
		stack.push(4);
		
		Assert.assertEquals(stack.size(), 4);
	}
	
	@Test
	public void test_pop() {
		
		Stack stack = new Stack();
		
		Assert.assertEquals(stack.size(), 0);
		
		stack.push(10);
		stack.push(1);
		stack.push(6);
		stack.push(2);
		stack.push(9);
		
		Assert.assertEquals(stack.size(), 5);
		
		Assert.assertEquals(stack.pop(), 9);
		Assert.assertEquals(stack.pop(), 2);
		Assert.assertEquals(stack.pop(), 6);
		Assert.assertEquals(stack.pop(), 1);
		Assert.assertEquals(stack.pop(), 10);
		
		Assert.assertNull(stack.pop());
		Assert.assertNull(stack.pop());
	}
	
	@Test
	public void test_peek() {
		
		Stack stack = new Stack();
		
		Assert.assertEquals(stack.size(), 0);
		
		stack.push(10);
		stack.push(1);
		stack.push(6);
		stack.push(2);
		stack.push(9);
		
		Assert.assertEquals(stack.size(), 5);
		
		Assert.assertEquals(stack.peek(), 9);
		stack.pop();
		
		Assert.assertEquals(stack.peek(), 2);
		stack.pop();
		
		Assert.assertEquals(stack.pop(), 6);
		Assert.assertEquals(stack.pop(), 1);
		
		Assert.assertEquals(stack.peek(), 10);
		stack.pop();
		
		Assert.assertNull(stack.pop());
		Assert.assertNull(stack.pop());
		Assert.assertNull(stack.peek());
		Assert.assertNull(stack.peek());
	}
}
