package com.LuckyAndreas.CodingTest.JavaBasic;

public class Mahasiswa {

	private String nim;
	private String nama;
	private double midTest;
	private double uas;
	private double kehadiran;
	private double nilaiAkhir;
	private String grade;
	
	public String getNim() {
		return nim;
	}
	public void setNim(String nim) {
		this.nim = nim;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public double getMidTest() {
		return midTest;
	}
	public void setMidTest(double midTest) {
		this.midTest = midTest;
	}
	public double getUas() {
		return uas;
	}
	public void setUas(double uas) {
		this.uas = uas;
	}
	public double getKehadiran() {
		return kehadiran;
	}
	public void setKehadiran(double kehadiran) {
		this.kehadiran = kehadiran;
	}
	
	public double getNilaiAkhir() {
		nilaiAkhir = (0.2 * kehadiran)+(0.4 * midTest)+(0.4*uas);
		return nilaiAkhir;
	}
	
	public String getGrade() {
		if(nilaiAkhir >= 85){
			grade = "A";
		}
		else if(nilaiAkhir >= 76 && nilaiAkhir <= 84){
			grade = "B";
		}
		else if(nilaiAkhir >= 61 && nilaiAkhir <= 75){
			grade = "C";
		}
		else if(nilaiAkhir >= 46 && nilaiAkhir <= 60){
			grade = "C";
		}
		else{
			grade = "E";
		}
		return grade;
	}

	public static String header() {
		String[] tmp = new String[] { "No.", "NIM",
				"Nama", "NilaiAkhir", "Grade" };
		String header = String.join(" | ", tmp);
		return header;
	}
	
}
