package com.sopra.helper;

import java.util.Random;

public final class StringGenerator {
	public static String lower = "abcdefghijklmnopqrstuvwxyz";
	public static String upper = lower.toUpperCase();
	public static String digits ="0123456789";
	public static String commonSymbols = "_-+*/<>!·$%&/()=?¿_:;|@#~{[]}]{}·";
	public static String allChars = lower + upper + commonSymbols + digits;
	
	public static String generateFixedLengthString(int len) {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder(len);
		
		int pos = 0;
		for (int i = 0; i < len; i++) {
			pos = rand.nextInt(allChars.length());
			sb.append(allChars.charAt(pos));
		}
		return sb.toString();
	}
	
	public static String generateDynamicLengthString() {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		
		int pos = 0;
		for (int i = 0; i < rand.nextInt(allChars.length())+5; i++) {
			pos = rand.nextInt(allChars.length());
			sb.append(allChars.charAt(pos));
		}
		return sb.toString();
	}
}
