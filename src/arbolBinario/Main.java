package arbolBinario;

import javax.swing.*;

/** @author Jenny **/

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArbolBinario nodoBinario = new ArbolBinario();
		int option = 0;

		do {
			try {
				String op = JOptionPane.showInputDialog(null, "----ARBOL BINARIO-----\n 1.- INSERTAR\n 2.- SALIR");
				if (op.equals("")) {
					JOptionPane.showConfirmDialog(null, "Debe elegir una opción");
				} else {
					option = Integer.parseInt(op);
					switch (option) {
					case 1: 
						int valorNodo;
						String numeroIngresado;
						numeroIngresado = JOptionPane.showInputDialog(null, "Ingrese el valor del nodo",
								JOptionPane.QUESTION_MESSAGE);
						if (numeroIngresado.equals("")) {
							JOptionPane.showMessageDialog(null, "Debe ingresar un valor al árbol");
							break;
						} else {
							valorNodo = Integer.parseInt(numeroIngresado);
							nodoBinario.agregarNodo(valorNodo, nodoBinario.getraiz());
						}
						break;
					case 2: 
						JOptionPane.showInternalMessageDialog(null, "Finalizado", "Fin",
								JOptionPane.INFORMATION_MESSAGE);
					
					default:	
						JOptionPane.showMessageDialog(null, "NO EXISTE ESA OPCIóN","Opción Invalida", JOptionPane.ERROR_MESSAGE);
					}
				}
			} catch (NumberFormatException error) {
				JOptionPane.showMessageDialog(null, "error  " + error.getMessage());
			}

		} while (option != 6);

	}

}
