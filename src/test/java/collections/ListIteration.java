package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListIteration {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		
		list.add("a");
		list.add("b");
		
		System.out.println(list.get(0));
		
		list.forEach(System.out::println);
		
		for(String a: Arrays.asList("a", "b"))
			System.out.println(a);
		
		usingIterator();

	}
	
	/*
	 * Advantage of using an Iterator
	 * The collection can be modified while during iteration
	 */
	public static void usingIterator() {
		List<Product> products = new ArrayList<>();
		products.add(new Product(10));
		products.add(new Product(21));
		products.add(new Product(30));
		
		final Iterator<Product> productIterator = products.iterator();
		while(productIterator.hasNext()){
			Product product = productIterator.next();
			if(product.getWeight() > 20)
				System.out.println(product);
			else
				productIterator.remove(); // remove from collection
		 }
		System.out.println(products);
	}

}
