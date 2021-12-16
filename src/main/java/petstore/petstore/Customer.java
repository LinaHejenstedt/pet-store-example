package main.java.petstore.petstore;

import java.util.Scanner;

public class Customer {
	private final Store store;
	private final Scanner scanner;

	private Customer(final Store theOnlyPetStore) {
		this.store = theOnlyPetStore;
		 scanner = new Scanner(System.in);
	}

	static Customer customerIn(Store store) {
		return new Customer(store);
	}

	public void chooseAction() {
		while (true) {
			System.out.println("Vad vill du göra?");
			System.out.println("1 för att titta på alla djur");
			System.out.println("2 för att köpa ett djur");
			System.out.println("välj 3 om du är nöjd och vill gå ur butiken");

			int choice = scanner.nextInt();
			if (choice == 1) {
				lookAtAnimals();
			} else if (choice == 2) {
				buyAnAnimal();
			} else if (choice == 3) {
				return;
			}
		}
	}

	private void lookAtAnimals() {
		store.seeAllAnimals();
	}

	private void buyAnAnimal() {
		System.out.println("Just nu har vi dessa djur.");
		lookAtAnimals();
		System.out.println("Vilket djur vill du köpa? Ange id.");

		int animalId = scanner.nextInt();
		try {
			Animal boughtAnimal = store.buyAnimal(animalId);
			System.out.println("Grattis! Du har nu köpt: " + boughtAnimal);

		} catch (IllegalArgumentException e) {
			System.out.println("Du valde inte ett existerande djur.");
		}

	}

}
