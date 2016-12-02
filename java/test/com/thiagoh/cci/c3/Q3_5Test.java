package com.thiagoh.cci.c3;

import java.util.Arrays;

import org.testng.annotations.Test;
import org.testng.internal.junit.ArrayAsserts;

import com.thiagoh.data_structures.HashMap;
import com.thiagoh.data_structures.List;
import com.thiagoh.data_structures.Stack;

@Test
public class Q3_5Test {

	@Test
	public void sortStack() {

		sortStack(10);

		sortStack(100);

		sortStack(1000);

		sortStack(10000);
	}

	private void sortStack(int numberOfItems) {

		// create a stack and an array with the same and unique elements
		HashMap l1 = new HashMap();
		for (int i = 0; i < numberOfItems; i++) {
			l1.set((int) (Math.random() * numberOfItems), true);
		}

		List keys = l1.keys();
		int[] arr1 = new int[keys.size()];
		Stack s1 = new Stack();

		for (int i = 0; i < keys.size(); i++) {
			int v = (int) keys.get(i);
			arr1[i] = v;
			s1.push(v);
		}

		// stack and an array created
		int[] arr2 = new int[s1.size()];

		// sort arr1
		Arrays.sort(arr1);

		// sort stack
		Q3_5.sortStack(s1);

		// send stack to arr2
		for (int i = 0; !s1.isEmpty();) {
			arr2[i++] = (int) s1.pop();
		}

		// compare arr1 and arr2
		ArrayAsserts.assertArrayEquals(arr1, arr2);
	}

}
