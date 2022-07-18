package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import blackjack.Carta.Palo;

public class Mazo {
	
	protected List<Carta> cartas;
	
	//Constructor sin parámetros. Genera un mazo de cartas con todas las cartas.
	//Para ello, deberemos recorrer todos los Palos y todo los posibles números y 
	//generaremos todas las cartas y las añadiremos a la lista. Para recorrer los palos
	//puedes utilizar: for (Palo p: Palo.values())
	public Mazo() {
		cartas=new ArrayList<>();
		for(Palo palo:Palo.values()) {
			for(int i=1;i<=13;i++) {
				Carta c=new Carta(palo,i);
				cartas.add(c);
			}
		}
	}
		
	//Método barajar() sin parámetros. Se encargará de barajar el mazo de cartas.
	//Lo único que hace es utilizar el método shuffle de la clase Collecction: Collections.shuffle(cartas);
	
	public void barajar() {
		Collections.shuffle(cartas);
	}
	// Método toString() para que muestre cada carta una debajo de otra.
	@Override
	public String toString() {
		String texto = "";
		for (Carta carta : cartas) {
			texto = texto + carta + "\n";
		}
		return texto;
	}
	// Método solicitarCarta() que devuelva 
	//la primera carta del mazo eliminándola de la lista
	public Carta solicitarCarta() {
		Carta c = cartas.get(cartas.size()-1);
		cartas.remove(cartas.size()-1);
		return c;
	}
	
	
	
	
	
	
	
	
}
