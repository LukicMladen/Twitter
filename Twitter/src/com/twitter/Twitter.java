package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Klasa koja predstavlja Twitter. Svaki objekat ove klase ima listu objekata
 * klase TwitterPoruka.
 * 
 * @author Mladen Lukic
 *
 */
public class Twitter {
	/**
	 * Atribut poruke je lista objekata klase TwitterPoruka.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Metoda vraca sve poruke koje se nalaze u listi poruka.
	 * 
	 * @return poruke Lista poruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Metoda kreira novi objekat klase TwitterPoruka, popunjava atribute i
	 * postavlja na poslednje mesto u listi
	 * 
	 * @param korisnik
	 *            Novi korisnik
	 * @param poruka
	 *            Nova poruka
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	/**
	 * Metoda pretrazuje listu poruka na osnovu unetog taga, puni novi niz sa
	 * objektima cije poruke sadrze uneti tag dok ne dodje do maxBroja, i onda
	 * kao povratnu vrednost vraca taj novi niz.
	 * 
	 * @param maxBroj
	 *            Predstavlja maksimalan broj objekata u nizu
	 * @param tag
	 *            Predstavlja kriterijum na osnovu kog pretrazujemo listu
	 * @return rezultat Niz koji sadrzi sve objekte cije poruke sadrze
	 *         kriterijum tag        
	 * @throws java.lang.RuntimeException ako je uneti tag:
	 * <ul>
	 * <li>null</li> 
	 * <li>prazan String</li>
	 * </ul> 
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1) {
				if (brojac < maxBroj) {
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else
					break;
			}
		return rezultat;
	}
}