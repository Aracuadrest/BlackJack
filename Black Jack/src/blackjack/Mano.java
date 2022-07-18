package blackjack;

import java.util.ArrayList;

public class Mano extends Mazo {
	
	//Constructor sin nada vacio

	public Mano() {
		this.cartas = new ArrayList();
		
	}

	//Método valorMano, calcula el valor de la mano que tenemos
	//Recorremos la lista y sumamos los valores
	public int valorMano() {
		int suma=0;
		for (Carta carta : cartas) {
			suma = suma + carta.getValor();
		}
		return suma;
	}
	
	// Método boolean finDeJuego true si tiene más de 21 puntos, el jugador se ha pasado
	public boolean finDejuego() {
		if (valorMano()>=21) {
			return true;
		}
		return false;
	}
	//return valorMano()>=21; nos ahorrariamos el if
		
	// Sobrescribe el metodo toString, pero antes muestre la puntuacion de la mano

	@Override
	public String toString() {
		return "Valor de la mano: " + valorMano() + "\n" + super.toString();
	}
	
	// Metodo pedirCarta al que se le pasa un mazo y solicita una carta y la
	// incluye si no se ha llegado al fin de juego
	public void pedirCarta(Mazo m) {
		if (!finDejuego()) {
		Carta c = m.solicitarCarta();
		this.cartas.add(c);
		}
	}
	
	
	
}
