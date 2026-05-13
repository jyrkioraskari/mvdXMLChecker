package de.rwth_aachen.dc.mvd.mvdxml1dot1.checker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.rwth_aachen.dc.mvd.checker.MvdXMLChecker;

public class MvdXMLCheckerFacadeTest {
	@Test
	public void exposesSharedCheckerFacade() {
		MvdXMLChecker checker = new MvdXMLv1dot1Check();

		assertTrue(checker instanceof MvdXMLv1dot1Check);
		assertEquals("1.1", checker.getMvdXMLVersion());
	}
}
