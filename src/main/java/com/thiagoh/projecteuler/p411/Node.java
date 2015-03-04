package com.thiagoh.projecteuler.p411;

import java.util.List;

public class Node implements Comparable<Node> {

	List<Node> nexts;
	List<Node> greatestDistanceFrom0x0;
	List<Node> greatestDistanceToNxN;
	int x;
	int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Node other = (Node) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public int compareTo(Node o) {
		int v = 0;
		if (o.x > x) {
			v = 1;
		} else if (o.x == x) {
			if (o.y > y) {
				v = 1;
			} else if (o.y == y) {
				v = 0;
			} else {
				v = -1;
			}

		} else {
			v = -1;
		}

		return v * -1;
	}

}
