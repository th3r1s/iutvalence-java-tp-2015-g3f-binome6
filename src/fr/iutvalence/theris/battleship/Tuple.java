package fr.iutvalence.theris.battleship;

/**
 * @author Robin
 * @param <A> 
 * @param <B>
 * classe paramétrée afin de gérer les pertes de parties
 */
public class Tuple<A, B> {

	private A firstElement;
	private B secondElement;
	
	/**
	 * @param firstElement
	 * @param secondElement
	 * constructeur
	 */
	public Tuple(A firstElement, B secondElement) {
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}

	/**
	 * @return
	 * setter du premier element
	 */
	public A getFirstElement() {
		return firstElement;
	}

	/**
	 * @param firstElement
	 * setter du premier element
	 */
	public void setFirstElement(A firstElement) {
		this.firstElement = firstElement;
	}

	/**
	 * @return
	 * getter du deuxieme element
	 */
	public B getSecondElement() {
		return secondElement;
	}

	/**
	 * @param secondElement
	 * setter du deuxieme element
	 */
	public void setSecondElement(B secondElement) {
		this.secondElement = secondElement;
	}
	
	
	
}
