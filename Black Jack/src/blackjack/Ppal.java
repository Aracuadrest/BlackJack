package blackjack;

import java.util.Scanner;

import exceptions.SeHaPasadoException;
import exceptions.TieneBlackJackExceptio;

public class Ppal {
	
	private static Mazo mazo;
	private static Mano jugador;
	private static Mano banca;

	public static void main(String[] args) {
		
		Mazo mazo = new Mazo();
		Mano jugador = new Mano();
		Mano banca = new Mano();
		
		System.out.println("-----------------------");
		System.out.println("  Barajando cartas...");
		System.out.println("-----------------------");
		mazo.barajar();
		
		System.out.println("  Repartiendo cartas...");
		
		
		try {
			jugador.pedirCarta(mazo);
			banca.pedirCarta(mazo);
			jugador.pedirCarta(mazo);
			banca.pedirCarta(mazo, false);
		} catch (SeHaPasadoException | TieneBlackJackExceptio e) {
			
			
		}
		
		
		
		System.out.println("Las cartas de la banca: "+banca);
		System.out.println("Las cartas del jugador: "+jugador);
		
				
		Scanner entrada = new Scanner(System.in);
		int opcion;
		do {
		System.out.println("¿Quieres carta? 1.si 0.no");
		opcion = entrada.nextInt();
		if (opcion ==1) {
			try {
				jugador.pedirCarta(mazo);
			} catch (SeHaPasadoException | TieneBlackJackExceptio e) {
			
			}
			System.out.println("Tienes en tu mano \n"+jugador);
		}
		
		}while (opcion!=0 && !jugador.finDejuego());
		
		/**if (jugador.valorMano()==21) {
			System.out.println("Campeón. Has conseguido BlackJack");
		}else if (jugador.valorMano()>21) {
			System.out.println("Te has pasado");
		}else {
			System.out.println("Te has plantado con "+jugador.valorMano());
		}*/
		
		
		System.out.println("-----------------------");
		System.out.println("   Juega la banca...");
		System.out.println("-----------------------");
		
		banca.descubrir();
		System.out.println("Las cartas de la banca: "+banca);

		if (jugador.valorMano()>21) {
			System.out.println("La banca gana");
		}else {
			do {
				System.out.println("Pidiendo carta");
				try {
					banca.pedirCarta(mazo);
				} catch (SeHaPasadoException e) {
					// TODO Bloque catch generado automáticamente
					e.printStackTrace();
				} catch (TieneBlackJackExceptio e) {
					// TODO Bloque catch generado automáticamente
					e.printStackTrace();
				}
				System.out.println(banca);
				}while ( banca.valorMano()<=16);
				
				if (jugador.valorMano()>banca.valorMano() || banca.valorMano()>21) {
					System.out.println("Enhorabuena has ganado: "+jugador+"\n La banca pierde");
				}else if(jugador.valorMano()==banca.valorMano()) {
					System.out.println("Empate");
					System.out.println("Jugador: "+jugador);
					System.out.println("Banca: "+banca);
				}else {
					System.out.println("Gana la banca: "+banca);
				}
					
		}
				
		System.out.println("Juega con responsabilidad");

	}

}
