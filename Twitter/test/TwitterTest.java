import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {

	Twitter t;

	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}

	@Test
	public void testvratiSvePoruke() {
		t.unesi("Mladen", "Nova poruka");
		t.unesi("Korisnik", "Druga poruka");
		
		TwitterPoruka p = new TwitterPoruka();
		TwitterPoruka p1 = new TwitterPoruka();
		
		p.setKorisnik("Mladen");
		p.setPoruka("Nova poruka");
		
		p1.setKorisnik("Korisnik");
		p1.setPoruka("Druga poruka");
		
		LinkedList<TwitterPoruka> nizPoruka = new LinkedList<TwitterPoruka>();
		
		nizPoruka = t.vratiSvePoruke();
		
		assertEquals(p, nizPoruka.get(0));
		assertEquals(p1, nizPoruka.get(1));
	}

	@Test
	public void testUnesi() {
		t.unesi("Mladen", "Nova poruka");

		LinkedList<TwitterPoruka> provera = new LinkedList<TwitterPoruka>();

		TwitterPoruka p = new TwitterPoruka();

		p.setKorisnik("Mladen");
		p.setPoruka("Nova poruka");

		provera.addLast(p);

		assertEquals(provera, t.vratiSvePoruke());
	}

	@Test
	public void testVratiPoruke() {
		t.unesi("Mladen", "Nova poruka 2");
		t.unesi("Mladen", "Tag Nova poruka");

		TwitterPoruka[] provera = new TwitterPoruka[1];

		TwitterPoruka p = new TwitterPoruka();

		p.setKorisnik("Mladen");
		p.setPoruka("Tag Nova poruka");

		provera[0] = p;

		TwitterPoruka[] original = t.vratiPoruke(1, "Tag");

		assertArrayEquals(provera, original);
	}

}
