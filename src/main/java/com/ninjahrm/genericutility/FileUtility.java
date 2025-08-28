package com.ninjahrm.genericutility;

import java.util.Random;

public class FileUtility {

	public int getRandomNumber() {
		Random random = new Random();
		int number = random.nextInt(4000);
		return number;
	}
}
