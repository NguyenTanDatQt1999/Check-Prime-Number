package edu.fa;


import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AppTest {
	
	@BeforeAll
	public static void beforeAll() {
		System.out.println("This is beforeAll");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("This is afterAll");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("This is beforeEach");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("This is afterEach");
	}
	
    @Test
    public void testNTChan() throws Exception{
    	int n = 7;
    	boolean actual = Utils.checkNT(n);
        Assertions.assertTrue(actual);
    }
    
    @Test
    public void testNTException() {
    	Assertions.assertThrows(Exception.class, () -> {
    		Utils.checkNT(-5);
    	});
    }
    @Test
    @Tag("Tag1")
    @DisplayName("Kiem tra thoi gian chay khong qua 1 phut")
    public void testTimeout() {
    	Assertions.assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
    		Utils.checkNT(9);
    	});
    }
    @ParameterizedTest
    @ValueSource(ints = {2, 5, 7, 97, 103})
    public void testTrue(int n) throws Exception {
    	Assertions.assertTrue(Utils.checkNT(n));
    }
    @ParameterizedTest
    @CsvSource({"1, false, message 1", "17, true, message 2", "97, true, message 3"})
    public void testAll(int n, boolean expected, String message) {
    	try {
			Assertions.assertEquals(expected, Utils.checkNT(n), message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @ParameterizedTest
    @CsvFileSource(files = "src/resource/data.csv", numLinesToSkip = 0)
    public void testInFile(int n, boolean expected, String message) {
    	try {
			Assertions.assertEquals(expected, Utils.checkNT(n), message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}