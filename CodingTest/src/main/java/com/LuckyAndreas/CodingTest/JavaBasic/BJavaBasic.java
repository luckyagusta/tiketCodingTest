package com.LuckyAndreas.CodingTest.JavaBasic;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@SuppressWarnings("resource")
public class BJavaBasic {
	public static boolean vowelCheck(char i) {
		boolean result = false;
		if (i == 'A' || i == 'a') {
			result = true;
		} else if (i == 'I' || i == 'i') {
			result = true;
		} else if (i == 'U' || i == 'u') {
			result = true;
		} else if (i == 'E' || i == 'e') {
			result = true;
		} else if (i == 'O' || i == 'o') {
			result = true;
		}

		return result;
	}

	public static void main(String[] args) {
		String input;
		Scanner sc = new Scanner(System.in);
		
		  System.out.print("Input Data : "); input = sc.nextLine();
		  changeLowerUppercase(input); // Input data: Saya sedang Belajar Bahasa PemOgraman JAVA. Output data: sAYA SEDANG bELAJAR bAHASA pEMoGRAMAN java.
		  removeVowel(input); // Input data: Saya sedang Belajar Bahasa PemOgraman JAVA. Output data:Sy sdng Bljr Bhs Pmgrmn JV.
		  countChar(input); // Input data : Developer PT. Global Tiket Network Output: De5vl3o3pr2PT2.Gbaik2t2Nwr
		  System.out.println();
		  System.out.println("======Java 8 Lambda======"); 
		  countWords(); //Jumlah kata dari teks di atas
		  countEachWords(); //Jumlah kemunculan tiap kata dari teks di atas
		  findMostFrequentWords(); // Jumlah kata yang paling banyak muncul dan katanya
		  findLeastFrequentWords(); // Jumlah kata yang hanya muncul satu kali + Jumlah kata yang paling sedikit muncul dan katanya

	}

	public static void changeLowerUppercase(String input) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			if (Character.isUpperCase(input.charAt(i))) {
				result.append(Character.toLowerCase(input.charAt(i)));

			} else if (Character.isLowerCase(input.charAt(i))) {
				result.append(Character.toUpperCase(input.charAt(i)));
			} else {
				result.append(input.charAt(i));
			}
		}
		System.out.println("Output Data : " + result);
	}

	public static void removeVowel(String input) {
		StringBuilder result = new StringBuilder();
		result.append(input);
		for (int i = 0; i < result.length(); i++) {
			if (vowelCheck(result.charAt(i)) == true) {
				result.deleteCharAt(i);
			}
		}
		System.out.println("Output Data : " + result);
	}

	public static void countChar(String input) {
		int count = 0, length = 0;
		System.out.print("Output Data : ");
		do {
			try {
				char temp[] = input.toCharArray();
				length = temp.length;
				count = 0;
				input = input.replaceAll("\\s+", "");
				for (int j = 0; j < length; j++) {
					if ((temp[0] == temp[j]) && ((temp[0] >= 65 && temp[0] <= 91) || (temp[0] >= 97 && temp[0] <= 123)))
						count++;
				}
				if (count > 1) {
					System.out.print(temp[0] + "" + count);
				} else {
					System.out.print(temp[0]);
				}
				input = input.replace("" + temp[0], "");
				
			} catch (Exception ex) {
			}
		} while (length != 1);
		System.out.print("r");
	}

	public static void countWords() {
		long wordCount = 0;
		Path textFilePath = Paths.get("src/main/resources/file.txt");
		try {
			Stream<String> fileLines = Files.lines(textFilePath, Charset.defaultCharset());
			wordCount = fileLines.flatMap(line -> Arrays.stream(line.split(" "))).count();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		System.out.println("Jumlah kata dari teks : " + wordCount ); 

	}

	public static void countEachWords() {
		try {
			System.out.println("=======================================");
			System.out.println("Jumlah kemunculan tiap kata dari teks :");
			Files.lines(Paths.get("src/main/resources/file.txt")).flatMap(line -> Stream.of(line.split("\\s+")))
					.filter(Pattern.compile("^\\w+$").asPredicate()).map(String::toLowerCase)
					.collect(Collectors.toMap(word -> word, word -> 1, Integer::sum))
					.entrySet().stream().sorted((a, b) -> a.getValue() == b.getValue()
							? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue())
					.forEach(System.out::println);
			System.out.println("=======================================");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void findMostFrequentWords() {
		Map<String, Integer> word = new HashMap<>();
		try {
			word = Files.lines(Paths.get("src/main/resources/file.txt")).map(Pattern.compile("\\p{Punct}")::matcher)
					.map(matcher -> matcher.replaceAll("")).flatMap(Pattern.compile("\\s+")::splitAsStream)
					.filter(Pattern.compile("^\\w+$").asPredicate()).filter(s -> s.length() >= 2)
					.map(s -> s.toLowerCase()).collect(Collectors.groupingBy(w -> w, Collectors.summingInt(w -> 1)));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("Jumlah kata yang paling banyak muncul :");
		word.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(1)
				.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
	}
	
	public static void findLeastFrequentWords() {
		Map<String, Integer> word = new HashMap<>();
		long count = 0;
		try {
			word = Files.lines(Paths.get("src/main/resources/file.txt")).map(Pattern.compile("\\p{Punct}")::matcher)
					.map(matcher -> matcher.replaceAll("")).flatMap(Pattern.compile("\\s+")::splitAsStream)
					.filter(Pattern.compile("^\\w+$").asPredicate()).filter(s -> s.length() >= 2)
					.map(s -> s.toLowerCase()).collect(Collectors.groupingBy(w -> w, Collectors.summingInt(w -> 1)));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (Entry<String, Integer> entry : word.entrySet())
		{
			if(entry.getValue() == 1){
				count++;
			}
			
		}
		System.out.print("Jumlah kata yang hanya muncul satu kali :");
		System.out.println(count);
		System.out.println("Jumlah kata yang paling sedikit muncul :");
		word.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).limit(count)
				.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
	}
}
