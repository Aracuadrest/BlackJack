/**
 * Clase Mano
 */
package modelo;

import java.util.ArrayList;
import exceptions.SeHaPasadoException;
import exceptions.TieneBlackJackExceptio;

/**
 * Clase que modela las cartas de un jugador. Esta clase extiende de
 * la clase Mazo.
 * @see Mazo Mazo
 * 
 * 
 *<p>@author Araceli Cuadra</p>
 */
public class Mano extends Mazo {
	
	/**
	 * Constructor sin parámetros que crea una mano de
	 * cartas vacía.
	 */

	public Mano() {
		this.cartas = new ArrayList();
		
	}
	
/**
 * Método que calcula el valor de la mano que tiene el jugador.
 * Se basa en la suma de los valores de cada carta de la mano.
 * @see Carta#getValor() getValor
 * @return int con el valor de la mano o 0 si no hay cartas en la mano
 */
	//
	//Recorremos la lista y sumamos los valores
	public int valorMano() {
		int suma=0;
		for (Carta carta : cartas) {
			suma = suma + carta.getValor();
		}
		return suma;
	}
	/**
	 * Método igual que el método valorMano(), pero sólo calcula el valor de las
	 * cartas que son visibles.
	 * @see Mano#valorMano() valorMano()
	 * @return int valor de las cartas visibles de la mano o 0 si ninguna carta es visible
	 * o no hay cartas en la mano
	 */

	
	public int valorManoVisibles() {
		int suma=0;
		for (Carta carta : cartas) {
			if(carta.isVisible()) {
				suma = suma + carta.getValor();	
			}
	
		}
		return suma;
	}
	/**
	 * Método que indica si el jugador se ha pasado de 21 puntos por lo que el juego se acaba
	 * 	@return boolean true si el valor de la mano es superior a 21
	 * 				 o false en caso contrario
	 */
	// 
	public boolean finDejuego() {
		if (valorMano()>=21) {
			return true;
		}
		return false;
	}
	//return valorMano()>=21; nos ahorrariamos el if
		
	/**
	 * Muestra la puntuación de la mano de las cartas visibles además de las cartas de la mano.
	 */


	@Override
	public String toString() {
			return "Valor de la mano: " + valorManoVisibles() + "\n" + super.toString();
		
	}
	/**
	 * Método para solicitar una carta más al Mazo pasado como parámetro y añadirla a la mano
	 * @param m Mazo solicitamos una carta de este mazo pasado
	 * @throws SeHaPasadoException Se lanza esta excepción 
	 * cuando el valor de la mano sobrepasa 21
	 * @throws TieneBlackJackExceptio Se lanza esta excepción cuando 
	 * el valor de la mano alcanza el valor de 21
	 */

	public void pedirCarta(Mazo m) throws SeHaPasadoException, TieneBlackJackExceptio {
		if (valorMano()>21) {
			throw new SeHaPasadoException("Se ha pasado");
		}
		if(valorMano()==21) {
			throw new TieneBlackJackExceptio("BlackJack");
		}
		
		Carta c = m.solicitarCarta();
		this.cartas.add(c);
		
		
	}
	/**
	 * Método para solicitar una carta del Mazo pasado por parámetro y con el parámetro visible o no.
	 * @param m Mazo que le pasamos 
	 * @param boolean visible true para indicar que la carta será visible o false para no visible.
	 */
	
	public void pedirCarta(Mazo m, boolean visible) {
		if (!finDejuego()) {
		Carta c = m.solicitarCarta();
		c.setVisible(visible);
		this.cartas.add(c);
		}
	}
	/**
	 * Método para descubrir todas las cartas haciendolas visibles todas las cartas de la mano.
	 * @see Carta#setVisible(boolean) setVisible(true)
	 */
	
	
	public void descubrir() {
		for (Carta carta : cartas) {
			carta.setVisible(true);
		}
	}
	
	
	
}
