package de.rwth_aachen.dc.mvd.mvdxml1dot2.checker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.rwth_aachen.dc.mvd.checker.MvdXMLChecker;

public class MvdXMLCheckerFacadeTest {
	@Test
	public void exposesSharedCheckerFacade() {
		MvdXMLChecker checker = new MvdXMLv1dot2Check();

		assertTrue(checker instanceof MvdXMLv1dot2Check);
		assertEquals("1.2", checker.getMvdXMLVersion());
	}
}
