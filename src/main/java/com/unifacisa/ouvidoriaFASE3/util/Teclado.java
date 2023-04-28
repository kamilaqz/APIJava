package com.unifacisa.ouvidoriaFASE3.util;

import java.util.InputMismatchException;
import java.util.Scanner;

/*classe para uso do scanner e tratamento de exceções
 * 
 */
public class Teclado {
	private static Scanner input = new Scanner(System.in);

	public static Integer leInt() {
		try {
			return Integer.parseInt(input.nextLine());
		} catch (InputMismatchException e) {
			System.out.println("Comando inválido. Tente novamente.");
			return 0;
		} catch (NumberFormatException e) {
			System.out.println("Comando inválido. Tente novamente.");
			return 0;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Comando inválido. Tente novamente.");
			return 0;
		}
	}

	public static String leString() {
		try {
			return input.nextLine();
		} catch (Exception e) {
			return "Comando inválido. Tente novamente";
		}
	}

	public static void close() {
		input.close();
	}
}
