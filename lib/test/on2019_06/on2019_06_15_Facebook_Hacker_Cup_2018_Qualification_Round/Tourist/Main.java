package on2019_06.on2019_06_15_Facebook_Hacker_Cup_2018_Qualification_Round.Tourist;

import net.egork.chelper.tester.NewTester;

import org.junit.Assert;
import org.junit.Test;

public class Main {
	@Test
	public void test() throws Exception {
		if (!NewTester.test("lib/test/on2019_06/on2019_06_15_Facebook_Hacker_Cup_2018_Qualification_Round/Tourist/Tourist.json"))
			Assert.fail();
	}
}
