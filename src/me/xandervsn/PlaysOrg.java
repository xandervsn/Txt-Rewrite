package me.xandervsn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class PlaysOrg {
	
	String input;
	Scanner scanner = new Scanner(System.in);
	String path;
	String output = "";
	char mod;
	Boolean play;
	int start;
	String perp = "";
	String num;

	public PlaysOrg() throws IOException {
		
		for(int a = 1; a <= 18; a++) {

			System.out.println(":3");
			input = scanner.nextLine();
			path = "C:\\Users\\stefa\\eclipse-workspace\\References\\Plays\\" + input + "_TXT_FolgerShakespeare.txt";
			String txt = Files.readString(Paths.get(path));
			
			if(txt.contains("Characters in the Play")) {
				for (int i = 0; i < txt.length(); i++) {
					if((txt.charAt(i) == 'A' && txt.charAt(i+1) == 'C' && txt.charAt(i+2) == 'T' && txt.charAt(i+3) == ' ' && txt.charAt(i+4) == '1') ||
					   (txt.charAt(i) == 'I' && txt.charAt(i+1) == 'N' && txt.charAt(i+2) == 'D' && txt.charAt(i+3) == 'U' && txt.charAt(i+4) == 'C') ||
					   (txt.charAt(i) == 'P' && txt.charAt(i+1) == 'R' && txt.charAt(i+2) == 'O' && txt.charAt(i+3) == 'L' && txt.charAt(i+4) == 'O') ||
					   (txt.charAt(i) == 'A' && txt.charAt(i+1) == 'C' && txt.charAt(i+2) == 'T' && txt.charAt(i+3) == ' ' && txt.charAt(i+4) == '1') ) {
						start = i;
						output(txt, start);
						return;
					}
				}
			}else {
				play = false;
			}
		}
	}
	
	public void output(String txt, int start) throws IOException {
		for (int i = start; i < txt.length(); i++) {
			if((txt.charAt(i)  >= 'a' && txt.charAt(i) <= 'z') ||
				(txt.charAt(i) == '.') ||
				(txt.charAt(i) == ',') ||
				(txt.charAt(i) == '?') ||
				(txt.charAt(i) == ' ') ||
				(txt.charAt(i) == '\n') ||
				(txt.charAt(i) == '-') ) {
				mod = txt.charAt(i);
			}else if(txt.charAt(i)  >= 'A' && txt.charAt(i) <= 'Z') {
				mod = (char) (txt.charAt(i) + 32);
			}else if(txt.charAt(i)  >= '0' && txt.charAt(i) <= '9'){
				toLetter(txt.charAt(i));
				mod = 'ヅ';
				output += num;
			}else {
				mod = 'ヅ';
			}
			
			if(mod != 'ヅ') {
				output += mod;
			}
		}
		PrintWriter pw = new PrintWriter(new FileWriter(new File("rewrite-" + input + ".txt")));
		pw.write(output);
		pw.close();
	}
	
	public String toLetter(char current) {
		if(current == '0') {
			num = "zero";
		}else if(current == '1') {
			num = "one";
		}else if(current == '2') {
			num = "two";
		}else if(current == '3') {
			num = "three";
		}else if(current == '4') {
			num = "four";
		}else if(current == '5') {
			num = "five";
		}else if(current == '6') {
			num = "six";
		}else if(current == '7') {
			num = "seven";
		}else if(current == '8') {
			num = "eight";
		}else if(current == '9') {
			num = "nine";
		}
		
		return num;
	}

	public static void main(String[] args) throws IOException {
		new PlaysOrg();
	}

}
