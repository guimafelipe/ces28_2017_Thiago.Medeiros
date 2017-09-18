package aula_9_Q1;

import java.util.Random;

public class RandomIntGenerator {
	public int next() {
		Random aux = new Random();
	    return aux.nextInt((this.max - this.min) + 1) + this.min;
	}
	
	private RandomIntGenerator(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public static RandomIntGenerator UpTo(int max) {
		return new RandomIntGenerator(Integer.MIN_VALUE/2, max);
	}
	
	public static RandomIntGenerator DownTo(int min) {
		return new RandomIntGenerator(min, Integer.MAX_VALUE/2);		
	}
	
	public static RandomIntGenerator Between(int min, int max) {
		return new RandomIntGenerator(min, max);
	}

	private final int min;
	private final int max;
}
