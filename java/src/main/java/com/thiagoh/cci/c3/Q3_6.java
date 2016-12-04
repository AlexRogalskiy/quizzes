package com.thiagoh.cci.c3;

import com.thiagoh.data_structures.Queue;

public class Q3_6 {

	public static class Animal {

		String name;
		int ticket;

		public Animal(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Animal [name=" + name + ", entered=" + ticket + "]";
		}
	}

	public static class Dog extends Animal {

		public Dog(String name) {
			super(name);
		}
	}

	public static class Cat extends Animal {

		public Cat(String name) {
			super(name);
		}
	}

	public static class Shelter {

		private Queue cats;
		private Queue dogs;
		private int ticket;

		public Shelter() {
			cats = new Queue();
			dogs = new Queue();
		}

		public void enqueue(Animal animal) {

			if (animal instanceof Dog) {
				dogs.enqueue(animal);
			} else if (animal instanceof Cat) {
				cats.enqueue(animal);
			}
			animal.ticket = ticket++;
		}

		public Animal dequeueAny() {
			Dog dog = null;
			Cat cat = null;
			Animal animal = null;
			if (!dogs.isEmpty()) {
				dog = (Dog) dogs.front.value;
			}
			if (!cats.isEmpty()) {
				cat = (Cat) cats.front.value;
			}

			if (cat != null && dog != null) {
				int compareTo = cat.ticket - dog.ticket;
				if (compareTo <= 0) {
					// return cat
					cats.dequeue();
					animal = cat;
				} else {
					// return dog
					dogs.dequeue();
					animal = dog;
				}
			} else if (cat != null) {
				// return cat
				cats.dequeue();
				animal = cat;
			} else if (dog != null) {
				// return dog
				dogs.dequeue();
				animal = dog;
			}

			return animal;
		}

		public Dog dequeueDog() {
			if (dogs.isEmpty()) {
				return null;
			}
			Dog dog = (Dog) dogs.front.value;
			dogs.dequeue();
			return dog;
		}

		public Cat dequeueCat() {
			if (cats.isEmpty()) {
				return null;
			}
			Cat cat = (Cat) cats.front.value;
			cats.dequeue();
			return cat;
		}
	}

}
