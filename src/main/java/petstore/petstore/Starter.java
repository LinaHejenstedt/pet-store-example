package main.java.petstore.petstore;

import java.util.Scanner;

public class Starter {

	// Logiken utgår från att den som kommer in i butiken varje gång får identifiera sig.
	// Men detta fokuserar på hur klasserna sitter ihop.
	// det finns mycket som kan göras annorlunda och bättre i detta lilla program - det är bara tänkt att illustrera hur klasser anropa varandra.

	public static void main(String[] args) {
		Store theOnlyPetStore = Store.emptyStore();
		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("Hej! Välkommen till djuraffären. Är du ägare eller Kund?");
			System.out.println("Välj 1 för ägare");
			System.out.println("eller 2 för kund");
			System.out.println("Vill du stänga butiken så välj 3");

			int choice = scanner.nextInt();

			if (choice == 1) {
				Owner owner = Owner.ownerFor(theOnlyPetStore);
				owner.chooseAction();
			} else if (choice == 2) {
				Customer customer = Customer.customerIn(theOnlyPetStore);
				customer.chooseAction();
			} else if (choice == 3) {
				System.out.println("Välkommen åter en annan dag!");
				System.exit(0);
			}
		}

	}
}
