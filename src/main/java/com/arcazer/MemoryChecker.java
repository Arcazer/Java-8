package com.arcazer;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class MemoryChecker {
	private static final long MEBIBYTE = 1024L * 1024L;

	private MemoryChecker() {
	}

	public static long bytesToMebibytes(long bytes) {
		return bytes / MEBIBYTE;
	}

	// Java Arraylist size on 32bit is 4byte + storedObj size per element
	// here storedObj is store as UTF-8(Eclipse Setting) --> size= stringlength
	// e.g. math.random retun string with 18 chars --> 18byte
	// Total 4 byte + 18byte per list element
	public static void simpleMemoryCheck() throws UnsupportedEncodingException {
		var list = new ArrayList<String>();
		for (int i = 0; i <= 10_000_000; i++) {
			list.add(String.valueOf(Math.random()));
		}

		System.out.printf("String length:%s%n", list.get(0).length());
		System.out.printf("String size in bytes: %d%n", list.get(0).getBytes("UTF-8").length);
		Runtime runtime = Runtime.getRuntime();

		System.out.printf("Total memory in bytes: %d%n", runtime.totalMemory());
		System.out.printf("Total memory in mebibytes: %d%n%n", bytesToMebibytes(runtime.totalMemory()));

		long memoryBeforeGC = runtime.totalMemory() - runtime.freeMemory();
		System.out.printf("Used memory in bytes: %s%n", memoryBeforeGC);
		System.out.printf("Used memory in mebibytes: %d%n%n", bytesToMebibytes(memoryBeforeGC));

		// garbage collector
		runtime.gc();

		long memoryAfterGC = runtime.totalMemory() - runtime.freeMemory();
		System.out.printf("Used memory in bytes: %s%n", memoryAfterGC);
		System.out.printf("Used memory in mebibytes: %d%n%n ", bytesToMebibytes(memoryAfterGC));

		list = null;
		runtime.gc();

		long memoryAfterGCAndListClear = runtime.totalMemory() - runtime.freeMemory();
		System.out.printf("Used memory in bytes: %s%n", memoryAfterGCAndListClear);
		System.out.printf("Used memory in mebibytes: %d%n%n ", bytesToMebibytes(memoryAfterGCAndListClear));
	}
}
