package com.thiagoh.data_structures;

import java.util.Comparator;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class StackMinTest {

	@Test
	public void test_push() {

		StackMin stack = new StackMin(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.intValue() - o2.intValue();
			}
		});

		Assert.assertEquals(stack.size(), 0);

		stack.push(10);
		stack.push(1);
		stack.push(2);
		stack.push(4);

		Assert.assertEquals(stack.size(), 4);
	}

	@Test
	public void test_pop() {

		StackMin stack = new StackMin(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.intValue() - o2.intValue();
			}
		});

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

		StackMin stack = new StackMin(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.intValue() - o2.intValue();
			}
		});

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

	@Test
	public void test_min() {

		StackMin stack = new StackMin(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.intValue() - o2.intValue();
			}
		});

		Assert.assertEquals(stack.size(), 0);

		stack.push(12);
		stack.push(30);
		stack.push(10);
		stack.push(9);
		stack.push(40);
		stack.push(4);
		stack.push(6);

		Assert.assertEquals(stack.min(), 4);
		Assert.assertEquals(stack.pop(), 6); // pops 6

		Assert.assertEquals(stack.min(), 4);
		Assert.assertEquals(stack.pop(), 4); // pops 4

		Assert.assertEquals(stack.min(), 9);
		Assert.assertEquals(stack.pop(), 40); // pops 40

		Assert.assertEquals(stack.min(), 9);
		Assert.assertEquals(stack.pop(), 9); // pops 9

		Assert.assertEquals(stack.min(), 10);
		Assert.assertEquals(stack.pop(), 10); // pops 10

		Assert.assertEquals(stack.min(), 12);
		Assert.assertEquals(stack.pop(), 30); // pops 30

		Assert.assertEquals(stack.min(), 12);
		Assert.assertEquals(stack.pop(), 12); // pops 30

		Assert.assertNull(stack.pop()); // no more elements
		Assert.assertNull(stack.peek()); // no more elements
	}

}
