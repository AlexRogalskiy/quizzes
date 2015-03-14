package com.thiagoh.cci.c1;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class MapTest {

	private String getGiantString() {

		try {

			String giantString = IOUtils.toString(new URL("http://fundamentus.com.br/resultado.php?segmento=73")
					.openStream());

			return giantString;

		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}

		return "";
	}

	@Test
	public void testPut() {

		Map m = new Map();
		m.put("a", 123);
		m.put("b", null);
		m.put("c", Integer.MIN_VALUE);
		m.put("c", new Object());
		m.put("c", "c");

		String giantString = getGiantString();

		m.put("d", giantString);
	}

	@Test
	public void testGet() {

		Map m = new Map();

		m.put("a", 123);
		Assert.assertEquals(m.get("a"), 123);

		m.put("b", null);
		Assert.assertEquals(m.get("b"), null);

		m.put("c", Integer.MIN_VALUE);
		Assert.assertEquals(m.get("c"), Integer.MIN_VALUE);

		Object o = new Object();
		m.put("c", o);
		Assert.assertEquals(m.get("c"), o);
		Assert.assertNotEquals(m.get("c"), new Object());

		m.put("c", "c");
		Assert.assertEquals(m.get("c"), "c");

		String giantString = getGiantString();

		m.put("d", giantString);
		m.put("e", giantString);

		Assert.assertEquals(m.get("d"), giantString);
		Assert.assertEquals(m.get("d"), m.get("e"));
		Assert.assertNotEquals(m.get("d"), m.get("c"));
	}
}
