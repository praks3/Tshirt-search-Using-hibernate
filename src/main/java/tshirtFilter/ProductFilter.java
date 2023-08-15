package tshirtFilter;
import java.util.*;

import com.nagarro.training.TshirtData.TshirtData;

public class ProductFilter { //for filtering products

	public static List<TshirtData> filterProducts(List<TshirtData> tshirts, String color, String size, String gender) {
		
		List<TshirtData> filteredProducts = new ArrayList<TshirtData>();
		for (TshirtData product : tshirts) {
			
			if (product.getColour().equalsIgnoreCase(color) && product.getSize().equalsIgnoreCase(size) &&
					product.getGender().equalsIgnoreCase(gender) && (product.getAvailability()=='Y'||product.getAvailability()=='y')) {
				
				filteredProducts.add(product);
			}
		}
		return filteredProducts;
	}

	public static List<TshirtData> sortProducts(List<TshirtData> filteredProducts, String outputPreference) { 	//for sorting filtered products
		
		List<TshirtData> sortedProducts = new ArrayList<TshirtData>(filteredProducts);
		
		if (outputPreference.equalsIgnoreCase("Price")) {
			Collections.sort(sortedProducts, new TshirtData.PriceComparator());
		}
		else if (outputPreference.equalsIgnoreCase("Rating")) {
			Collections.sort(sortedProducts, new TshirtData.RatingComparator());
		}
		else if (outputPreference.equalsIgnoreCase("Both")) {
			Collections.sort(sortedProducts, new TshirtData.PriceRatingComparator());
		}
		return sortedProducts;
	}
}