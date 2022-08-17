/**
 * Clase Mazo
 */

package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import modelo.Carta.Palo;

/**
 * 
 * 
 * Clase que modela el mazo de cartas con todas las cartas posibles y sus palos,
 * un total de 52 cartas de la baraja francesa.
 * El mazo tendrá una lista de palos( trebol, diamantes, corazones y picas) 
 * con todas las cartas por palo.
 * Usa la clase Carta.
 * @see Carta Carta
 *
 *<p>@author Araceli Cuadra</p>
 */
public class Mazo {
	
	protected List<Carta> cartas;
	
	/**
	 * Constructor sin parámetros. Genera un mazo de cartas con todas las cartas.
	 * Para ello, deberemos recorrer todos los Palos y todo los posibles números y
	 * generaremos todas las cartas y las añadiremos a la lista.
	 * Las cartas se muestran ordenadas Trebol, Diamantes, Corazones y Picas, y sus números.
	 */
	
	//Para recorrer los palos puedes utilizar: for (Palo p: Palo.values())
	public Mazo() {
		cartas=new ArrayList<>();
		for(Palo palo:Palo.values()) {
			for(int i=1;i<=13;i++) {
				Carta c=new Carta(palo,i);
				cartas.add(c);
			}
		}
	}
	/**
	 * Método sin parámetros. Se encargará de barajar el mazo de cartas.
	 */
	
	//Lo único que hace es utilizar el método shuffle de la clase Collecction: Collections.shuffle(cartas);
	
	public void barajar() {
		Collections.shuffle(cartas);
	}
	
	/**
	 * Muestra todas las cartas del mazo. Cada una en una línea.
	 */
	
	@Override
	public String toString() {
		String texto = "";
		for (Carta carta : cartas) {
			texto = texto + carta + "\n";
		}
		return texto;
	}
	
	/**
	 * Método que devuelve una carta del mazo eliminándola de la lista del mazo.
	 * @return Carta Una carta del mazo
	 */
	
	public Carta solicitarCarta() {
		Carta c = cartas.get(cartas.size()-1);
		cartas.remove(cartas.size()-1);
		return c;
	}
	
	
	
	
	
	
	
	
}
