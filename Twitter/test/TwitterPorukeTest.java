import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.twitter.poruke.TwitterPoruka;

public class TwitterPorukeTest {

	private TwitterPoruka tp;

	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	@Test
	public void testSetKorisnikSveOk() {
		String korisnik = "UticajniTwitteras";

		tp.setKorisnik(korisnik);

		assertEquals(korisnik, tp.getKorisnik());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		tp.setKorisnik("");
	}

	@Test
	public void testSetPorukaSveOk() {
		String poruka = "Nova poruka";

		tp.setPoruka(poruka);

		assertEquals(poruka, tp.getPoruka());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tp.setPoruka(null);
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaVeciOd140() {
		tp.setPoruka("Celnici Tvitera su razmisljali da povecaju limit broja karaktera"
				+ " za svaki tvit sa 140 na cak 10.000, ali su se ipak predomislili. "
				+ "Suosnivac Tvitera Dzek Dorsi je rekao kako je ovo ogranicenje i dalje najbolje resenje za njih, "
				+ "narocito sto je prvobitna najava izazvala negodovanje kod vecine korisnika.");
	}

	@Test
	public void testToString() {
		String korisnik = "Novi korisnik";
		String poruka = "Nova poruka";
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		assertEquals("KORISNIK:" + korisnik + " PORUKA:" + poruka, tp.toString());
	}

}
