package test;
import static org.junit.Assert.*;

import org.junit.Test;

import app.ItemIDFetch;

import org.junit.Assert;

public class WoWTest {

	@Test
	public void test() {
		String result = ItemIDFetch.fetchItem("Convergence of Fates");
		Assert.assertEquals(result, "140806");
		result = ItemIDFetch.fetchItem("convergence of fates");
		Assert.assertEquals(result, "140806");
		result = ItemIDFetch.fetchItem("asdf");
		Assert.assertEquals(result, null);
	}

}
