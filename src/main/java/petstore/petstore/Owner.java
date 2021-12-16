package main.java.petstore.petstore;

import java.util.Scanner;

public class Owner {

	private final Store myStore;
	private final Scanner scanner;

	public Owner(final Store myStore) {
		this.myStore = myStore;
		scanner = new Scanner(System.in);
	}

	static Owner ownerFor(Store myStore) {
		return new Owner(myStore);
	}

	public void chooseAction() {
		while (true) {
			System.out.println("Vad vill du göra?");
			System.out.println("1 för att lägga till djur");
			System.out.println("2 för att titta på alla djur");
			System.out.println("3 för att ta bort ett djur");
			System.out.println("välj 4 om du är nöjd och vill gå ur butiken");
			int choice = scanner.nextInt();
			if (choice == 1) {
				addAnimalToStore();
			} else if (choice == 2) {
				lookAtAnimals();
			} else if (choice == 3) {
				removeAnimalFromStore();
			} else if (choice == 4) {
				return;
			}
		}

	}

	//Jag hade troligen flyttat detta till en egen klass - som hanterar input/output mer
	public void addAnimalToStore() {

		System.out.println("Vilket sorts djur vill du lägga till? Katt eller hund?");
		String breed = scanner.next();
		System.out.println("Vad heter djuret?");
		String name = scanner.next();
		System.out.println("du har valt att lägga till en " + breed + " vid namn " + name);
		int noOfAnimals = myStore.getAnimals().size();
		int newAnimalId = noOfAnimals + 1;

		Animal newAnimalToAdd = new Animal(newAnimalId, name, breed);

		myStore.addAnimal(newAnimalToAdd);

	}

	public void lookAtAnimals() {
		myStore.seeAllAnimals();
	}

	public void removeAnimalFromStore() {
		System.out.println("Det här är de djur som just nu finns i affären.");

		myStore.seeAllAnimals();

		System.out.println("Vilket djur vill du ta bort? Ange dess id");

		int animalId = scanner.nextInt();
		myStore.removeAnimalWithId(animalId);
	}

}
