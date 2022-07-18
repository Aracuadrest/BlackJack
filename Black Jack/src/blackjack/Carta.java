package blackjack;

public class Carta {
	//creacion de enum para el palo de la carta
	enum Palo{TREBOL,DIAMANTES,CORAZONES,PICAS};
	
	//declaracion de atributos;
	private Palo palo;
	private int numero;
	
	//Constructor parametrizado al que le pases el numero y el palo, y asigne los valores. El número deberá estar entre 1 y 13.
	public Carta(Palo palo, int numero) {
		super();
		this.palo = palo;
		if (numero>=1 && numero<=13)
				this.numero = numero;
	}

	//Métodos getters de los atributos de las cartas. No crear lo setters
	public Palo getPalo() {
		return palo;
	}

	public int getNumero() {
		return numero;
	}
	
	//Método getValor que devuelve el valor que tiene cada carta en el BlackJack. Los valores serán: 11 para el AS (1), 10 para las figuras (J,Q,K o 11, 12 y 13) y el valor correspondiente para el resto de las cartas (2, 3, 4, 5, 6, 7, 8, 9)
	public int getValor() {
		if (this.numero ==1)
				return 11;
		else if (this.numero>10) return 10;
		else return this.numero;
	}
	
	//Método mostrarNumero sin parámetros que devuelve un String con la representación de cada número. Para el 1 habrá que mostrar “AS”, para la 11 habrá que mostrar “J”, para la 12 habrá que mostrar “Q”, para la 13 “K” y para el resto su correspondiente valor.
	public String mostrarNumero() {
		if (this.numero ==1)
			return "AS";
		else if (this.numero==11) return "J";
		else if (this.numero==12) return "Q";
		else if (this.numero==13) return "K";
		else return Integer.toString(this.numero);// o tambien return "",+this.num;	
	}

	//Sobreescribe el método toString para que muestre la carta de la siguiente manera [ numero – Palo]. Por ejemplo, [3 – CORAZONES]
	@Override
	public String toString() {
		return "[" + this.mostrarNumero() + " - " + this.palo + "]";
	}
	
}
