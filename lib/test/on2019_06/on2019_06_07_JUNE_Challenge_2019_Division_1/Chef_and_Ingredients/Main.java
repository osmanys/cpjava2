package on2019_06.on2019_06_07_JUNE_Challenge_2019_Division_1.Chef_and_Ingredients;

import net.egork.chelper.tester.NewTester;

import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!NewTester.test("lib/test/on2019_06/on2019_06_07_JUNE_Challenge_2019_Division_1/Chef_and_Ingredients/Chef and Ingredients.json"))
			Assert.fail();
	}
}
