package youtubeEgitim;

public class Main {

	public static void main(String[] args) {
		// IoC Container
		
		CustomerManager customerManager = new CustomerManager(new Customer() , new CarCreditManager());
		customerManager.giveCredit();
		
		CarCreditManager carCreditManager = new CarCreditManager();
		carCreditManager.calculate();
		
		TeacherCreditManager teacherCreditManager = new TeacherCreditManager();
		teacherCreditManager.calculate();
		
		/*
		 * int sayi1 = 10; int sayi2 = 20; sayi1 = sayi2; sayi2 = 100;
		 * System.out.println(sayi1);
		 */
		/*
		 * int[] sayilar1 = {1,2,3}; int[] sayilar2 = {10, 20, 30}; sayilar1 = sayilar2;
		 * sayilar2[0] = 1000; System.out.println(sayilar1[0]);
		 */

		/*
		CreditManager creditManager = new CreditManager();
		creditManager.Calculate();
		creditManager.Calculate();
		creditManager.Save();

		Customer customer = new Customer(); // ornegini olusturmak, instance olusturmak, instance creation
		customer.id = 1;
		customer.city = "Izmir";
		

		CustomerManager customerManager = new CustomerManager(customer);
		customerManager.save();
		customerManager.delete();

		Company company = new Company();
		company.taxNumber = "100000";
		company.companyName = "Arcelik";
		company.id = 100;
		
		CustomerManager customerManager2 = new CustomerManager(new Person());
		
		Person person = new Person();
		person.firstName = "";
		person.nationalIdentity = "";
		
		Customer c1 = new Customer();
		Customer c2 = new Person();
		Customer c3 = new Company();
		*/

	}
}
