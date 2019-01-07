package com.LuckyAndreas.CodingTest.JavaBasic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("resource")
public class AJavaBasic {
	
	public static void main(String [] args) throws FileNotFoundException{
		int index = 0;
		
		List<Mahasiswa> listMhs = new ArrayList<>();
		List<String> grade = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Masukkan jumlah mahasiswanya : ");
		index = sc.nextInt();
	
		for(int i = 1 ; i<=index ; i ++){
			Mahasiswa mhs = new Mahasiswa();
			System.out.println("==================================================");
			System.out.print("Masukkan NIM : ");		
			mhs.setNim(sc.next());
			System.out.print("Masukkan Nama : ");
			mhs.setNama(sc.next());
			System.out.print("Masukkan Nilai Kehadiran : ");
			mhs.setKehadiran(sc.nextDouble());
			System.out.print("Masukkan Nilai MidTest : ");
			mhs.setMidTest(sc.nextDouble());
			System.out.print("Masukkan Nilai UAS : ");
			mhs.setUas(sc.nextDouble());
			listMhs.add(mhs);
		}
		
		for (int i=0 ; i<listMhs.size() ; i++) {
			System.out.print((i+1));
			System.out.print(" | ");
			System.out.print(listMhs.get(i).getNim() + " | ");
			System.out.print(listMhs.get(i).getNama() + " | ");
			System.out.print(listMhs.get(i).getNilaiAkhir());
			System.out.print(" | ");
			System.out.println(listMhs.get(i).getGrade());
			grade.add(listMhs.get(i).getGrade());
		}
		System.out.println("===============================================================");
		
		
		int a = Collections.frequency(grade, "A");
		int b = Collections.frequency(grade, "B");
	    int c = Collections.frequency(grade, "C");
			int pass = a+b+c;
		
		int d = Collections.frequency(grade, "D");
		int e = Collections.frequency(grade, "E");
			int notPass = d+e;
		
			System.out.println("Jumlah Mahasiswa : "+listMhs.size()+" (berdasarkan hasil kalkulasi)");
			System.out.println("Jumlah Mahasiswa yg Lulus : "+pass+" (berdasarkan hasil kalkulasi)");
			System.out.println("Jumlah Mahasiswa yg Tidak Lulus : "+notPass+" (berdasarkan hasil kalkulasi)");
			System.out.println("===============================================================");
		
	}
}
