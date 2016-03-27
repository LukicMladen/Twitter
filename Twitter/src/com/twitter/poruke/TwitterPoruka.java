package com.twitter.poruke;

/**
 * Klasa koja predstavlja poruku na Twitteru, sadrzi naziv korisnika i sadrzaj poruke.
 * @author Mladen Lukic
 *
 */
public class TwitterPoruka {
	/**
	 * Naziv korisnika kao String.
	 */
	private String korisnik;
	/**
	 * Tekst poruke na Twitteru kao String.
	 */
	private String poruka;
	
	/**
	 * Metoda vraca vrednost atributa ime.
	 * @return naziv/ime korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Metoda postavlja novu vrednost za atribut korisnik
	 * 
	 * @param korisnik Novi naziv korisnika
	 * @throws java.lang.RuntimeException ako je uneti korisnik:
	 * <ul>
	 * <li>null</li> 
	 * <li>prazan String</li>
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda vraca crednost parametra poruka
	 * @return tekst poruke
	 */
	public String getPoruka() {
		return poruka;
	}
	
	/**
	 * Metoda postavlja tekst poruke odredjenog korisnika
	 * 
	 * @param poruka Tekst poruke
	 * @throws java.lang.RuntimeException ako je uneta poruka:
	 * <ul>
	 * <li>null</li> 
	 * <li>duza od 140 karaktera</li>
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	/**
	 * Metoda vraca vrednost svih atributa klase TwitterPoruka u vidu Stringa.
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}