package com.thiagoh.projecteuler.p411;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.List;

import javax.swing.JPanel;

public class MatrixComponent extends JPanel {

	long n;
	LongestPathSolution s;
	double SPACE;
	int RADIUS;

	public MatrixComponent(long n, int width) {

		this.n = n;
		this.SPACE = width / n;
		this.RADIUS = 4;
		this.s = new LongestPathSolution(n);
		this.setPreferredSize(new Dimension(width, width));
	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		g2.draw(new Rectangle2D.Double(0, 0, n * SPACE, n * SPACE));

		for (int line = 0; line < n; line++) {
			g2.draw(new Line2D.Double(0, line * SPACE, n * SPACE, line * SPACE));
		}

		for (int col = 0; col < n; col++) {
			g2.draw(new Line2D.Double(col * SPACE, 0, col * SPACE, n * SPACE));
		}

		try {

			s.S();

			System.out.println(s.points);
			
			for (Node node : s.points) {
				paintNode(g2, node);
			}

			if (true )return;
			
			List<Node> path = null;//s.SPath();
			
			Node first = new Node(0, 0);
			Node last = new Node((int) n, (int) n);

			paintLine(g2, first, path.get(0));
			paintLine(g2, path.get(path.size() - 1), last);

			for (int i = 0; i < path.size(); i++) {

				Node node = path.get(i);

				if (i > 0) {
					paintLine(g2, path.get(i - 1), node);
				}

				paintNode(g2, node);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void paintLine(Graphics2D g, Node from, Node to) {

		double x1 = from.x * SPACE;
		double y1 = (n * SPACE) - from.y * SPACE;

		double x2 = to.x * SPACE;
		double y2 = (n * SPACE) - to.y * SPACE;

		g.setColor(Color.BLUE);
		g.setStroke(new BasicStroke(2));
		g.draw(new Line2D.Double(x1, y1, x2, y2));
	}

	private void paintNode(Graphics2D g, Node node) {

		double x = node.x * SPACE - RADIUS;
		double y = (n * SPACE) - (node.y * SPACE) - RADIUS;

		g.setColor(Color.red);
		g.setBackground(Color.BLACK);
		g.fill(new Ellipse2D.Double(x, y, RADIUS * 2, RADIUS * 2));
	}

}
