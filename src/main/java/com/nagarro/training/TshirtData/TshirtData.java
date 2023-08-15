package com.nagarro.training.TshirtData;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tshirts")
public class TshirtData {

	@Id
	@Column(name="tshirtID")
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="colour")
	private String colour;
	@Column(name="gender")
	private String gender;
	@Column(name="size")
	private String size;
	@Column(name="price")
	private double price;
	@Column(name="rating")
	private double rating;
	@Column(name="availability")
	private char availability;

	public TshirtData() {

	}
	public TshirtData(String id, String name, String colour,String gender,String size,double price,double rating,char availability) {
		this.id = id;
		this.name = name;
		this.colour = colour;
		this.gender = gender;
		this.size = size;
		this.price = price;
		this.rating = rating;
		this.availability = availability;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public char getAvailability() {
		return availability;
	}

	public void setAvailability(char availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return String.format("| %-15s | %-30s | %-10s | %-7s | %-6s | %7.2f | %6.2f |%n",
				id, name, colour, gender, size, price, rating);
	}

	public static String getHeader() {
		return String.format("+-----------------+--------------------------------+------------+---------+--------+--------+-------+%n" +
				"| ID              | Name                           | Colour     | Gender  | Size   | Price  | Rating%n" +
				"+-----------------+--------------------------------+------------+---------+--------+--------+-------+%n");
	}
	
	public static class PriceComparator implements Comparator<TshirtData> {
		public int compare(TshirtData p1, TshirtData p2) {
			return Double.compare(p1.getPrice(),p2.getPrice());
		}
	}	

	public static class RatingComparator implements Comparator<TshirtData> {
		public int compare(TshirtData p1, TshirtData p2) {
			return Double.compare(p2.getRating(), p1.getRating());
		}
	}

	public static class PriceRatingComparator implements Comparator<TshirtData> {
		public int compare(TshirtData p1, TshirtData p2) {
			int priceComparison = Double.compare(p1.getPrice(), p2.getPrice());
			if (priceComparison == 0) {
				return Double.compare(p2.getRating(), p1.getRating());
			}
			return priceComparison;
		}
	}
}
