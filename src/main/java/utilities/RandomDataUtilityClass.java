package utilities;

import java.text.SimpleDateFormat;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class RandomDataUtilityClass {

	static Faker faker;
	static String fName;
	static String lName;
	static String name;
	static String title;
	static String ph_no;
	static String ph_no1;
	static String buildingNo, streetAddress, cityName, state, country, postCode;
	static String addressFull;

	public static String getfName() {
		faker = new Faker(new Locale("en-IND"));
		fName = faker.name().firstName();
		return fName;
	}

	public static String getlName() {
		faker = new Faker(new Locale("en-IND"));
		lName = faker.name().lastName();
		return lName;

	}

	public static String getFullName() {
		faker = new Faker(new Locale("en-IND"));
		name = faker.name().fullName();
		return name;
	}

	public static String getbuildingNoAndStreetAddress() {
		faker = new Faker(new Locale("en-IND"));
		buildingNo = faker.address().buildingNumber();
		streetAddress = faker.address().streetAddress();
		return buildingNo + streetAddress;
	}

	public static String getCity() {
		faker = new Faker(new Locale("en-IND"));
		cityName = faker.address().cityName();
		return cityName;
	}

	public static String getState() {
		faker = new Faker(new Locale("en-IND"));
		state = faker.address().state();
		return state;
	}

	public static String getCountry() {
		faker = new Faker(new Locale("en-IND"));
		country = faker.country().name();
		return country;
	}

	public static String getPostCode() {
		faker = new Faker(new Locale("en-IND"));
		postCode = faker.address().zipCode();
		return postCode;
	}

	public static String getFullAddress() {
		faker = new Faker(new Locale("en-IND"));
		addressFull = faker.address().fullAddress();
		return addressFull;

	}

	public static String getTitle() {
		faker = new Faker();
		title = faker.name().title();
		return title;

	}

	public static String getRandomEmail() {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = 5;
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		String randomStringEmail = sb.toString() + "@gmail.com";
		return randomStringEmail;

	}

	public static String getRandomPhoneNumber() {

		faker = new Faker();
		ph_no = faker.phoneNumber().phoneNumber();
		return ph_no;
	}

	public static String getRandomPhoneNumber1() {
		// Locale locale = new Locale("In");
		faker = new Faker(new Locale("en-IND"));
		String extensn = faker.phoneNumber().extension();
		ph_no1 = faker.phoneNumber().cellPhone().concat(extensn);
		return ph_no1;
	}

	public static String getBirthDayDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Faker faker = new Faker();
		String dob = sdf.format(faker.date().birthday());

		return dob;

	}

	public static String getBirthDayYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
		Faker faker = new Faker();
		String dob = sdf.format(faker.date().birthday());

		return dob;

	}

}
