package org.hmis.cardGame;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class CartaMasAlta {

	private static int money = 10;

	public static void main(String args[]) throws FileNotFoundException {
		int num;
		Scanner leer = new Scanner(System.in);
		Deck2 baraja = new Deck2();

		while (money > 0) {
			System.out.println("Introduzca la cantidad deseada: " + money);
			num = leer.nextInt();
			
			if ((money - num) >= 0 && num != 0) {
				Card c1 = baraja.dealCard();
				System.out.println(c1);
				Card c2 = baraja.dealCard();
				System.out.println(c2);
				
				if ((c1.getValue() > c2.getValue() && c2.getValue() != 1)
						| (c1.getValue() == 1 && c2.getValue() != 1)) {
					money = money + num;
					
				} else if (c1.getValue() < c2.getValue() || c2.getValue() == 1) {
					money = money - num;
					
				}
			} else if (num == 0) {
				System.out.println("Termina el juego por decision del jugador");
				break;
				
			} else if ((money - num) < 0) {
				System.out.println(
						"No hay suficiente dinero, dispone de " + money + " y ha querido apostar " + num);
			}
			
		}
		System.out.println("Ha finalizado el juego");
	}
}
