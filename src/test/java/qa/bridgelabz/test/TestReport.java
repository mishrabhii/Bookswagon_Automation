package qa.bridgelabz.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestReport {
	@Test
    public void testPassed() {
        AssertJUnit.assertTrue(true);
    }

    @Test
    public void testFailed() {
        AssertJUnit.assertFalse(false);
    }

    @Test
    public void testDepend() {
        AssertJUnit.assertTrue(true);
    }
}


