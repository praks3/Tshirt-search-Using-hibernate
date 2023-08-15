package tshirtFilter;
import java.util.*;
import com.nagarro.training.TshirtData.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main {
	public static void main(String[]args) {
		
		Data new1= new Data();
		new1.start();
		Scanner sc= new Scanner(System.in);
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		while(true) {
			String color ="",size="",gender="", outputPreference="";
			
			do {
				System.out.println("enter color:");
				color= sc.nextLine();
			}
			while (!color.matches("[a-zA-Z]+"));
			
			do {
			System.out.println("enter size(S/M/L/XL/XXL):");
			size = sc.nextLine();
			}
			while(!size.matches("[smlxlSMLXL]{1,2}|xxl|XXL"));
			
			do {
			System.out.println("enter gender(M/F):");
			gender = sc.nextLine();
			}
			while(!gender.matches("[mMfF]{1}"));
			
			System.out.println("enter Preference(Price/Rating/Both):");
			outputPreference = sc.nextLine();
			
			Session session = factory.openSession();
			session.beginTransaction();
			Query<TshirtData> query =session.createQuery("from TshirtData",TshirtData.class);
			List<TshirtData> tshirts =query.list();
			
			session.getTransaction().commit();
			session.close();
		
			List<TshirtData> filteredProducts = ProductFilter.filterProducts(tshirts, color, size, gender);
			List<TshirtData> sortedProducts = ProductFilter.sortProducts(filteredProducts, outputPreference);

			if(!sortedProducts.isEmpty()) {
				System.out.println(TshirtData.getHeader());
				for (TshirtData product : sortedProducts) {
					System.out.println(product.toString());
				}
				System.out.println("Continue Searching more tshirts?(Y/N)");
				String option=sc.nextLine();
				if(option.equalsIgnoreCase("n")) {
					System.out.println("*******END*****");
					System.exit(0);
					sc.close();
					factory.close();
				}
			}		

			else {
				System.out.println("****Tshirt not available.Please try again****");
				System.out.println("Continue Searching more tshirts?(Y/N)");
				String option=sc.nextLine();
				if(option.equalsIgnoreCase("n")) {
					System.out.println("*******END*****");
					System.exit(0);	
					sc.close();
					factory.close();
					}
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		
	}
}
