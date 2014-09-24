package fi.raksamanageri.domain;

import fi.raksamanageri.domain.Patevyys;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PatevyysTest {
    
    public PatevyysTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void patevyydellaOnNimi() {
        Patevyys p = new Patevyys("Koe");
        assertEquals(p.getNimi(), "Koe");
    }
}
