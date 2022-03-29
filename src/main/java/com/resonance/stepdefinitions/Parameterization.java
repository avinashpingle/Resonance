package com.resonance.stepdefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Parameterization {

	int x, y, result = 0;
	ArrayList<Integer> al = new ArrayList<>();
	String fname, lname, fullName;

	@Given("I have {int} and {int}")
	public void acceptTwoNumber(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@When("I add them")
	public void addNumbers() {
		result = x + y;
	}

	@Then("verify that addition is even")
	public void isAdditionEven() {
		Assert.assertTrue(result % 2 == 0, "Addition result is not even: " + result);
	}

	@Given("I have first name as {string}")
	public void acceptFirstName(String fname) {
		this.fname = fname;
	}

	@When("I append last name {string}")
	public void appendNames(String lname) {
		String name = fname.concat(" " + lname);
		fullName = name;
	}

	@Then("I can see full name")
	public void displayFullName() {
		System.out.println("Full name: " + fullName);
	}

	@Given("I have following numbers:")
	public void acceptListOfElements(DataTable dt) {
		List<List<Integer>> table = dt.asLists(Integer.class);
		for (List<Integer> row : table) {
			for (Integer elem : row) {
				System.out.print(elem + " ");
			}
			System.out.println();
		}
	}

	@When("I add all elements of list")
	public void addElementsOfList() {
		for (Integer element : al) {
			result = result + element;
		}
	}

	@Then("verify if the result is prime number")
	public void checkIfResultIsPrime() throws TimeoutException {
		boolean isPrime = false;
		int count = 1;
		for (int i = 1; i < result; i++) {
			if (result % i == 0) {
				count++;
			}
		}
		throw new TimeoutException();
		//Assert.assertTrue(count<=2, "The number is not prime: "+result);
		
	}
	
	@Given("I have numbers from {int}")
	public void readDataFromExcel(int rowNumber) throws Exception {
		String dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(dir+"/src/test/resources/TestData/Numbers.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheetAt(0);
		Row row = sheet.getRow(rowNumber);
		this.x = (int) row.getCell(0).getNumericCellValue();
		this.y = (int) row.getCell(1).getNumericCellValue();
	}
}
