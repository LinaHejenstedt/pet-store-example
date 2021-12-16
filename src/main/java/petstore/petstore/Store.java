package main.java.petstore.petstore;

import java.util.ArrayList;
import java.util.List;

public class Store {

	private List<Animal> animals;

	private Store() {
		this.animals = new ArrayList<>();
	}

	static Store emptyStore() {
		return new Store();
	}

	public void addAnimal(Animal animal) {
		animals.add(animal);
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void seeAllAnimals() {
		for (int i = 0; i < animals.size(); i++) {
			System.out.println(animals.get(i));
		}
	}

	public void removeAnimalWithId(final int animalId) {
		for (int i = 0; i < animals.size(); i++) {
			if (animals.get(i).getId() == animalId) {
				animals.remove(animals.get(i));
				break;
			}
		}
	}

	public Animal buyAnimal(final int animalId) {
		for (final Animal animal : animals) {
			if (animal.getId() == animalId) {
				return animal;
			}
		}
		throw new IllegalArgumentException("Not an existing animal");
	}
}
