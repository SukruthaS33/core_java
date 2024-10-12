package com.sukrutha.collections;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.Scanner;

public class PhoneBookSimpleCode {

	public static void main(String[] args) {

		HashMap<String, List<String>> contacts = new HashMap<>();
		Scanner sc = new Scanner(System.in);

		System.out.println("Phonebook");
		System.out.println("what do you like to do?");
		System.out.println("Add new contact?");
		boolean userInput = sc.nextBoolean();
		while (userInput) {
			System.out.println("add no");
			String number = sc.next();
			System.out.println("add name");
			String name = sc.next();
			if (contacts.containsKey(name)) {

				ArrayList al = new ArrayList<>(contacts.get(name));
				al.add(number);
				contacts.put(name, al);
			}

			else {
				ArrayList al = new ArrayList<>();
				al.add(number);
				contacts.put(name, al);
			}

			System.out.println("would you like to stop or add more?");
			userInput = sc.nextBoolean();
		}
		System.out.println(contacts);
		System.out.println("search contact by name");
		String searchName = sc.next();
		System.out.println(searchName + contacts.get(searchName));
		System.out.println("search contact by number");
		String numberr = sc.next();
		for (Map.Entry<String, List<String>> entry : contacts.entrySet()) {
			String name = entry.getKey();
			List<String> numbers = entry.getValue();
			if (numbers.contains(numberr)) {
				System.out.println(name + " " + numberr);
			}

		}

	}
}
