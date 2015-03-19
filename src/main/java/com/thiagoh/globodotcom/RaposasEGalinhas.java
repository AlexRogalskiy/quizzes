package com.thiagoh.globodotcom;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RaposasEGalinhas {

	char[][] farm;
	int C;
	int R;

	private static int PATH_UP = 1 << 0;
	private static int PATH_RIGHT = 1 << 1;
	private static int PATH_DOWN = 1 << 2;
	private static int PATH_LEFT = 1 << 3;

	private class Farm extends Stack<Node> {
		private int k;
		private int v;
	}

	public String solve(String[] lines) {

		farm = new char[lines.length][];

		for (int i = 0; i < lines.length; i++) {
			farm[i] = lines[i].toCharArray();
		}

		R = farm.length;
		C = farm[0].length;

		Node[][] nodes = new Node[R][C];

		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				nodes[y][x] = new Node(y, x);
			}
		}
		List<Farm> fs = new ArrayList<RaposasEGalinhas.Farm>();
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				Node node = nodes[y][x];
				if (node.h() || node.visited) {
					continue;
				}
				fs.add(discover(node, nodes));
			}
		}

		int sumK = 0;
		int sumV = 0;

		for (Farm farm : fs) {
			if (farm.v == 0 && farm.k == 0) {
				continue;
			} else if (farm.v >= farm.k) {
				sumV += farm.v;
			} else {
				sumK += farm.k;
			}
		}

		return sumK + " " + sumV;
	}

	private Farm discover(Node node, Node[][] nodes) {

		if (node.visited) {
			return node.f;
		}

		if (node.f == null) {
			node.f = new Farm();
		}

		node.f.push(node);
		node.f.k += node.k() ? 1 : 0;
		node.f.v += node.v() ? 1 : 0;
		node.visited = true;

		if (node.up()) {
			Node up = node.getUp(nodes);
			up.f = node.f;
			discover(up, nodes);
		}

		if (node.down()) {
			Node down = node.getDown(nodes);
			down.f = node.f;
			discover(down, nodes);
		}

		if (node.right()) {
			Node right = node.getRight(nodes);
			right.f = node.f;
			discover(right, nodes);
		}

		if (node.left()) {
			Node left = node.getLeft(nodes);
			left.f = node.f;
			discover(left, nodes);
		}

		return node.f;
	}

	private class Node {
		private Farm f;
		private boolean visited;
		private int path;
		private int y;
		private int x;
		private char c;

		private Node(int _y, int _x) {

			c = farm[_y][_x];
			y = _y;
			x = _x;

			if (_y > 0) {
				char c1 = farm[_y - 1][_x];
				if (c1 == '.' || c1 == 'k' || c1 == 'v') {
					path |= PATH_UP;
				}
			}

			if (_y < R - 1) {
				char c1 = farm[_y + 1][_x];
				if (c1 == '.' || c1 == 'k' || c1 == 'v') {
					path |= PATH_DOWN;
				}
			}

			if (_x > 0) {
				char c1 = farm[_y][_x - 1];
				if (c1 == '.' || c1 == 'k' || c1 == 'v') {
					path |= PATH_LEFT;
				}
			}

			if (_x < C - 1) {
				char c1 = farm[_y][_x + 1];
				if (c1 == '.' || c1 == 'k' || c1 == 'v') {
					path |= PATH_RIGHT;
				}
			}
		}

		private boolean h() {
			return c == '#';
		}

		private boolean k() {
			return c == 'k';
		}

		private boolean v() {
			return c == 'v';
		}

		private boolean up() {
			return (path & PATH_UP) == PATH_UP;
		}

		private boolean down() {
			return (path & PATH_DOWN) == PATH_DOWN;
		}

		private boolean right() {
			return (path & PATH_RIGHT) == PATH_RIGHT;
		}

		private boolean left() {
			return (path & PATH_LEFT) == PATH_LEFT;
		}

		private Node getUp(Node[][] nodes) {
			return nodes[y - 1][x];
		}

		private Node getDown(Node[][] nodes) {
			return nodes[y + 1][x];
		}

		private Node getRight(Node[][] nodes) {
			return nodes[y][x + 1];
		}

		private Node getLeft(Node[][] nodes) {
			return nodes[y][x - 1];
		}
	}
}
