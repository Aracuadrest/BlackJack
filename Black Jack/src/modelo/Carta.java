/**
 * Clase Carta
 */
package modelo;
/**
 * 
 *
 * Clase que modela una carta de la baraja. La carta tendrá 
 * un número y un palo y representará una carta de la baraja
 * francesa con los palos diamantes, picas, corazones y rombos.
 * Los número de la baraja van desde el 1(AS) hasta el 10,
 * la J, Q y K.
 *
 *<p>@author Araceli Cuadra</p>
 */
public class Carta {
	
	/**
	 * Tipo enumerado que representa al palo de la carta.
	 * Toma los valores Trebol, Diamantes, Corazones y Picas.
	 */
	//creacion de enum para el palo de la carta
	enum Palo{TREBOL,DIAMANTES,CORAZONES,PICAS};
	
	
	//declaracion de atributos;
	private Palo palo;
	private int numero;
	private boolean visible;
	
/**
 * Constructor parametrizado al que le pases el numero y el palo, y crea una carta asignando valores. 
 * @param palo Palo El palo de la carta (Trebol, Diamantes, Corazones y Picas).
 * @param numero int El número deberá estar entre 1 y 13.
 */
	public Carta(Palo palo, int numero) {
		super();
		this.palo = palo;
		if (numero>=1 && numero<=13) {
			this.numero = numero;
		}
		this.visible=true;
				
	}
/**
 * Constructor parametrizado al que le pases el numero, el palo y si la carta será visible o no,
 *  y asignará los valores.
 * @param palo Palo El palo de la carta (Trebol, Diamantes, Corazones y Picas).
 * @param numero int El número deberá estar entre 1 y 13.
 * @param visible boolean true si la carta se muestra o false en caso contrario
 */
	public Carta(Palo palo, int numero, boolean visible) {
		super();
		this.palo = palo;
		if (numero>=1 && numero<=13) {
			this.numero = numero;
		}
		this.visible = visible;
	}



	/**
	 * Método accesor que devuelve un palo.
	 * @return palo Palo (Trebol, Diamantes, Corazones o Picas).
	 */
	public Palo getPalo() {
		return palo;
	}
/**
 * Método accesor que devuelve el número de una carta.
 * @return numero int con el número de la carta(comprendido entre 1 y 13).
 */
	public int getNumero() {
		return numero;
	}
	/**
	 * Método accesor que devuelve verdadero si la carta se muestra a los jugadores.
	 * @return boolean true si la carta es visible o false en caso contrario.
	 */
	public boolean isVisible() {
		return visible;
	}
/**
 * Método de establecimiento de una carta para ser visible o no
 * @param visible boolean true si la carta es visible o false en caso contrario.
 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

/**
 * Método getValor que devuelve el valor que tiene cada carta en el BlackJack. Los valores serán: 
 * 11 para el AS (1),10 para las figuras (J,Q,K o 11, 12 y 13) y el valor correspondiente para 
 * el resto de las cartas (2, 3, 4, 5, 6, 7, 8, 9).
 * @return numero int con el valor de la carta
 */
	public int getValor() {
		if (this.numero ==1)
				return 11;
		else if (this.numero>10) return 10;
		else return this.numero;
	}

	/**
	 * Método mostrarNumero sin parámetros que devuelve un String con la representación de cada número.
	 *  Para el 1 habrá que mostrar “AS”, para la 11 habrá que mostrar “J”, para la 12 habrá que mostrar “Q”, 
	 *  para la 13 “K” y para el resto su correspondiente valor.
	 * @return String con la representación de cada número
	 */
	public String mostrarNumero() {
		if (this.numero ==1) {
			return "AS";
		}else if (this.numero==11) { return "J";
		}else if (this.numero==12) { return "Q";
		}else if (this.numero==13) { return "K";
		}else return Integer.toString(this.numero);// o tambien return "",+this.num;	
	}

	/**
	 * Sobreescribe el método toString para que muestre la carta de la siguiente
	 *  manera [ numero – Palo]. Por ejemplo, [3 – CORAZONES]
	 */
	@Override
	public String toString() {
		if (this.visible) {
		return "[" + this.mostrarNumero() + " - " + this.palo + "]";
		}
		return "[ Carta no visible ]";
	}
	
}
