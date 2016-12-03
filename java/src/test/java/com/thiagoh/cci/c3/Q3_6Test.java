package com.thiagoh.cci.c3;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thiagoh.cci.c3.Q3_6.Animal;
import com.thiagoh.cci.c3.Q3_6.Shelter;
import com.thiagoh.data_structures.Queue;

@Test
public class Q3_6Test {

	@Test
	public void dequeueAny() {

		Animal dog1 = new Q3_6.Dog("dog1");
		Animal dog2 = new Q3_6.Dog("dog2");
		Animal dog3 = new Q3_6.Dog("dog3");
		Animal dog4 = new Q3_6.Dog("dog4");
		Animal dog5 = new Q3_6.Dog("dog5");
		Animal dog6 = new Q3_6.Dog("dog6");
		Animal dog7 = new Q3_6.Dog("dog7");

		Animal cat1 = new Q3_6.Cat("cat1");
		Animal cat2 = new Q3_6.Cat("cat2");
		Animal cat3 = new Q3_6.Cat("cat3");
		Animal cat4 = new Q3_6.Cat("cat4");
		Animal cat5 = new Q3_6.Cat("cat5");
		Animal cat6 = new Q3_6.Cat("cat6");
		Animal cat7 = new Q3_6.Cat("cat7");
		Animal cat8 = new Q3_6.Cat("cat8");
		Animal cat9 = new Q3_6.Cat("cat9");

		Shelter s = new Shelter();

		s.enqueue(dog1);
		s.enqueue(cat1);
		s.enqueue(cat2);
		s.enqueue(dog2);
		s.enqueue(dog3);
		s.enqueue(dog4);
		s.enqueue(dog5);
		s.enqueue(cat3);
		s.enqueue(cat4);
		s.enqueue(cat5);
		s.enqueue(dog6);
		s.enqueue(cat6);
		s.enqueue(cat7);
		s.enqueue(cat8);
		s.enqueue(cat9);
		s.enqueue(dog7);

		Assert.assertEquals(s.dequeueAny(), dog1);
		Assert.assertEquals(s.dequeueAny(), cat1);
		Assert.assertEquals(s.dequeueAny(), cat2);
		Assert.assertEquals(s.dequeueAny(), dog2);
		Assert.assertEquals(s.dequeueAny(), dog3);
		Assert.assertEquals(s.dequeueAny(), dog4);
		Assert.assertEquals(s.dequeueAny(), dog5);
		Assert.assertEquals(s.dequeueAny(), cat3);
		Assert.assertEquals(s.dequeueAny(), cat4);
		Assert.assertEquals(s.dequeueAny(), cat5);
		Assert.assertEquals(s.dequeueAny(), dog6);
		Assert.assertEquals(s.dequeueAny(), cat6);
		Assert.assertEquals(s.dequeueAny(), cat7);
		Assert.assertEquals(s.dequeueAny(), cat8);
		Assert.assertEquals(s.dequeueAny(), cat9);
		Assert.assertEquals(s.dequeueAny(), dog7);
	}
	
	@Test
	public void dequeue() {
		
		Animal dog1 = new Q3_6.Dog("dog1");
		Animal dog2 = new Q3_6.Dog("dog2");
		Animal dog3 = new Q3_6.Dog("dog3");
		Animal dog4 = new Q3_6.Dog("dog4");
		Animal dog5 = new Q3_6.Dog("dog5");
		Animal dog6 = new Q3_6.Dog("dog6");
		Animal dog7 = new Q3_6.Dog("dog7");
		
		Animal cat1 = new Q3_6.Cat("cat1");
		Animal cat2 = new Q3_6.Cat("cat2");
		Animal cat3 = new Q3_6.Cat("cat3");
		Animal cat4 = new Q3_6.Cat("cat4");
		Animal cat5 = new Q3_6.Cat("cat5");
		Animal cat6 = new Q3_6.Cat("cat6");
		Animal cat7 = new Q3_6.Cat("cat7");
		Animal cat8 = new Q3_6.Cat("cat8");
		Animal cat9 = new Q3_6.Cat("cat9");
		
		Shelter s = new Shelter();
		
		s.enqueue(dog1);
		s.enqueue(cat1);
		s.enqueue(cat2);
		s.enqueue(dog2);
		s.enqueue(dog3);
		s.enqueue(dog4);
		s.enqueue(dog5);
		s.enqueue(cat3);
		s.enqueue(cat4);
		s.enqueue(cat5);
		s.enqueue(dog6);
		s.enqueue(cat6);
		s.enqueue(cat7);
		s.enqueue(cat8);
		s.enqueue(cat9);
		s.enqueue(dog7);
		
		Assert.assertEquals(s.dequeueAny(), dog1);
		Assert.assertEquals(s.dequeueCat(), cat1);
		Assert.assertEquals(s.dequeueCat(), cat2);
		Assert.assertEquals(s.dequeueDog(), dog2);
		Assert.assertEquals(s.dequeueDog(), dog3);
		Assert.assertEquals(s.dequeueAny(), dog4);
		Assert.assertEquals(s.dequeueDog(), dog5);
		Assert.assertEquals(s.dequeueAny(), cat3);
		Assert.assertEquals(s.dequeueCat(), cat4);
		Assert.assertEquals(s.dequeueAny(), cat5);
		Assert.assertEquals(s.dequeueAny(), dog6);
		Assert.assertEquals(s.dequeueCat(), cat6);
		Assert.assertEquals(s.dequeueAny(), cat7);
		Assert.assertEquals(s.dequeueCat(), cat8);
		Assert.assertEquals(s.dequeueAny(), cat9);
		Assert.assertEquals(s.dequeueDog(), dog7);
	}

}
