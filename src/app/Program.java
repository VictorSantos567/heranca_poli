package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			
			sc.nextLine();
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char p = sc.next().charAt(0);

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (p == 'c') {

				list.add(new Product(name, price));

			} else if (p == 'u') {

				System.out.print("Manufacture date (DD/MM/YYYY): ");
				sc.nextLine();
				String manufactureDate = sc.nextLine();

				list.add(new UsedProduct(name, price, sdf.parse(manufactureDate)));

			} else if (p == 'i') {

				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();

				list.add(new ImportedProduct(name, price, customsFee));

			}
		}
		System.out.println("");
		System.out.println("PRICE TAGS");
		for (Product product : list) {
			System.out.println(product.priceTag());
		}

		sc.close();
	}

}
