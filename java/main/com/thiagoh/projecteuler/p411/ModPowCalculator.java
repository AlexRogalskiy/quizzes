package com.thiagoh.projecteuler.p411;

import java.math.BigInteger;

public class ModPowCalculator {

	private long n;
	private BigInteger nbi;

	public ModPowCalculator(long n) {
		this.n = n;
		this.nbi = BigInteger.valueOf(n);
	}

	static final BigInteger one = BigInteger.valueOf(1L);
	static final BigInteger two = BigInteger.valueOf(2L);
	static final BigInteger three = BigInteger.valueOf(3L);

	private long xBoundary = 0;
	private BigInteger xValue = null;

	private long yBoundary = 0;
	private BigInteger yValue = null;

	long getX(long i) {

		long mod = 0;

		if (xBoundary == 0) {

			BigInteger pow = two.pow((int) i);
			BigInteger bi = pow.mod(nbi);

			mod = bi.longValue();

			if (pow.compareTo(nbi) == 1) {
				xBoundary = i;
				xValue = bi;
			}

		} else {

			BigInteger bi = two.pow((int) (i - xBoundary)).multiply(xValue).mod(nbi);
			mod = bi.longValue();

			xBoundary = i;
			xValue = bi;
		}

		return mod;
	}

	long getY(long i) {

		long mod = 0;

		if (yBoundary == 0) {

			BigInteger pow = three.pow((int) i);
			BigInteger bi = pow.mod(nbi);

			mod = bi.longValue();

			if (pow.compareTo(nbi) == 1) {
				yBoundary = i;
				yValue = bi;
			}

		} else {

			BigInteger bi = three.pow((int) (i - yBoundary)).multiply(yValue).mod(nbi);
			mod = bi.longValue();

			yBoundary = i;
			yValue = bi;
		}

		return mod;
	}

}