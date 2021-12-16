package main.java.petstore.petstore;

public class Animal {

	private int id;
	private String name;
	private String breed;

	public Animal(final int id, final String name, final String breed) {
		this.id = id;
		this.name = name;
		this.breed = breed;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}

	@Override
	public String toString() {
		return "Id: " + id +
				" Breed: " + breed +
				" Name: " + name;
	}
}
