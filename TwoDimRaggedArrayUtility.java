import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
* Class: CMSC203
* Instructor:Professor Monshi
* Description: This program accepts a ragged array and has methods to find max min total 
* and average
* Due: 4/24/2021
* Platform/compiler:Eclipse Java
* I pledge that I have completed the programming assignment
independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Azariyas Tafesse
*/
public class TwoDimRaggedArrayUtility {

	// Readfile and write to file methods obtained from github
	public static double[][] readFile(File file) throws FileNotFoundException{

		String[][] input = new String[10][10];
		Scanner sc = new Scanner(file);
		int row = 0, col = 0;
		// finds how many rows there are in file
		while (sc.hasNextLine()) {
			String[] currentRow = sc.nextLine().split(" ");
			for (col = 0; col < currentRow.length; col++) {
				input[row][col] = currentRow[col];
			}
			row++;
		}

		sc.close();

		double[][] sales = new double[row][];

		for (row = 0; row < sales.length; row++) {
			for (col = 0; input[row][col] != null; col++) {	}			
			sales[row] = new double[col];
			for (col = 0; col < sales[row].length; col++) {
				sales[row][col] = Double.parseDouble(input[row][col]);
			}
		}

		return sales;
	}
	
	public static void writeToFile(double[][] data,File outputFile) throws FileNotFoundException{
		
		PrintWriter file = new PrintWriter(outputFile);
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				file.print((col != 0) ? " " + data[row][col] : data[row][col]);
			}
			file.println();
		}

		file.close();
	}

	/**
	 * set total to 0 
	 * for loop to go through each row and column
	 * add the value of the colum and row to the total 
	 * @param data the array to calculate the total
	 * @return the total of the array
	 */
	public static double getTotal(double[][] data) {
		double total= 0;
		int row =0;
		for (int r =0; r < data.length;)
		{
			for(int c=0;c<data[row].length;c++)
			{
				total += data[row][c];
			}
			row++;
			r++;
	}
	
		return total;
	}
	
	/**
	 * * set total  and elementNumber to 0 
	 * for loop to go through each row and colum and add 1 to elementNumner
	 * add the value of the colum and row to the total then divide by element number
	 * @param data the array to calculate avg
	 * @return the average of the array
	 */
	public static double getAverage(double[][] data) {
		double total= 0;
		int elementNumber= 0;
		double average; 
		int row =0;
		for (int r =0; r < data.length;)
		{
			for(int c=0;c<data[row].length;c++)
			{
				total += data[row][c];
				elementNumber++;
			}
			row++;
			r++;
	}
		average = total/elementNumber;
	
		return average;
	}
	
	/**
	 * * set total to 0 
	 * for loop to go through each column
	 * add the value of the row to the total 
	 * @param data the array to look through
	 * @param row the row to calculate total
	 * @return the total in the row
	 */
	public static double getRowTotal(double[][] data,int row) {
		double total= 0;
		for(int c=0;c<data[row].length;c++)
		{
			total += data[row][c];
		}
		return total;
	}
	
	/**
	 * set total to 0 
	 * for loop to go through each row
	 * add the value of the colum to the total 
	 * @param data the array to look through
	 * @param col the col to calculate in
	 * @return the total in the row
	 */
	public static double getColumnTotal(double[][] data,int col) {
		double total=0;
		for(int r=0;r<data.length;r++)
		{
			
			if(data[r].length < col+1) {
				
				}
			else  {
				total+=data[r][col];
			}
		
			}
		return total;
	
	}
	/**
	 * set max to min value 
	  * a for loop to go through array
	  * check if current row as the specified col+1 other wise skip to next row
	  * check wether the data in the array is greater than max, if true set the new max
	 * @param data the array to look through 
	 * @param row the row to look in
	 * @return the highest value in the row
	 */
	public static double getHighestInRow(double[][] data,int row) {
		double max= Integer.MIN_VALUE;
		for(int c=0;c<data[row].length;c++)
		{
			if(data[row][c] > max) 
			{
				max = data[row][c];
			}
		
		}
		return max;
	}
	
	/**
	 * set max to min value index =0
	  * a for loop to go through array
	  * check if current row as the specified col+1 other wise skip to next row
	  * check wether the data in the array is greater than max, if true set r to index
	 * @param data the array to look through
	 * @param row the row to look in
	 * @return the index of the highest value
	 */
	public static int getHighestInRowIndex(double[][] data,int row) {
		double max= Integer.MIN_VALUE;
		int index =0;
		for(int c=0;c<data[row].length;c++)
		{
			if(data[row][c] > max) 
			{
				max = data[row][c];
				index = c;
			}
		
		}
		return index;
	}
	
	/**
	 * set min to max value and 
	  * a for loop to go through array
	  * check if current row as the specified col+1 other wise skip to next row
	  * check wether the data in the array is less than min, if true set the new min
	 * @param data the array to look through 
	 * @param row the row to look in
	 * @return the lowest value of the row
	 */
	public static double getLowestInRow(double[][] data,int row) {
		double min= Integer.MAX_VALUE;
		for(int c=0;c<data[row].length;c++)
		{
			if(data[row][c] < min) 
			{
				min= data[row][c];
			}
		
		}
		return min;
	}
	
	/**
	 * set min to max value and index to 0 
	  * a for loop to go through array
	  * check if current row as the specified col+1 other wise skip to next row
	  * check wether the data in the array is less than min, if true set the r to index
	 * @param data the array to look through
	 * @param row the row to look in
	 * @return the index of the lowest value
	 */
	public static int getLowestInRowIndex(double[][] data,int row) {
		double min= Integer.MAX_VALUE;
		int index =0;
		for(int c=0;c<data[row].length;c++)
		{
			if(data[row][c] < min) 
			{
				min = data[row][c];
				index = c;
			}
		
		}
		return index;
	}
	/**
	 * set max to min value 
	  * a for loop to go through array
	  * check if current row as the specified col+1 other wise skip to next row
	  * check whether the data in the array is greater than max, if true set the new max
	 * @param data the array to look through
	 * @param col the column to look in
	 * @return the highest value in the column
	 */
	public static double getHighestInColumn(double[][] data,int col) {
	
		double max=Integer.MIN_VALUE;
		for(int r=0;r<data.length;r++)
		{
			
			if(data[r].length < col+1) {
				}
			else if(data[r][col] > max) {
				max=data[r][col];
			}
		
			}
		return max;

		}
	
	/**
	 * set max to min value and index to 0 
	  * a for loop to go through array
	  * check if current row as the specified col+1 other wise skip to next row
	  * check weather the data in the array is greater than max, if true set the r to index
	 * @param dataarray of data 
	 * @param col the coloum to look in 0 = the 1 column
	 * @return return index of highest value 
	 */
	public static int getHighestInColumnIndex(double[][] data,int col) {
		double max=Integer.MIN_VALUE;
		int index =0;
		for(int r=0;r<data.length;r++)
		{
			
			if(data[r].length < col+1) {
				}
			else if(data[r][col] > max) {
				max=data[r][col];
				index =r;
			}
		
			}
		return index;
	}
	
	/**
	 * set min to max value and index to 0 
	  * a for loop to go through array
	  * check if current row as the specified col+1 other wise skip to next row
	  * check whether the data in the array is less than min, if true set the new min
	 * @param data the array to search in
	 * @param col the coloum to look in
	 * @return the lowest value in the coloum
	 */
	public static double getLowestInColumn(double[][] data,int col) {
		double min =Integer.MAX_VALUE;
		for(int r=0;r<data.length;r++)
		{
			
			if(data[r].length < col+1) {
			
				}
			else if(data[r][col] < min) {
				min=data[r][col];
			}
		
			}
		return min;
	}
	 /**
	  * set min to max value and index to 0 
	  * a for loop to go through array
	  * check if current row as the specified col+1 other wise skip to next row
	  * check whether the data in the array is less than min, if true set the r to index
	  * @param data the ragged array data
	  * @param col- the column to look in 0 = the first column
	  * @return return the index that has the Lowest data
	  */
	public static int getLowestInColumnIndex(double[][] data,int col) {
		double min=Integer.MAX_VALUE;
		int index =0;
		for(int r=0;r<data.length;r++)
		{
			
			if(data[r].length < col+1) {
				}
			else if(data[r][col] < min) {
				min=data[r][col];
				index =r;
			}
		
			}
		return index;
	}
	/**
	 * * set max to MIN VALUE
	 * for loop to go through each row and column
	 * check whether to current value is greater than max, if true set the new max 
	 * @param data the array to find highest value
	 * @return the highest value
	 */
	public static double getHighestInArray(double[][] data) {
		double max= Integer.MIN_VALUE;
		int row =0;
		for (int r =0; r < data.length;)
		{
			for(int c=0;c<data[row].length;c++)
			{
				if (data[row][c] > max)
				max = data[row][c];
			}
			row++;
			r++;
	}
	
		return max;
	}
	
	/**
	 * * set min to max VALue
	 * for loop to go through each row and column
	 * check wether the current value is less than min, if true set new min
	 * @param data- the data from the array
	 * @return return minimum value of the array
	 */
	public static double getLowestInArray(double[][] data) {
		double min= Integer.MAX_VALUE;
		int row =0;
		for (int r =0; r < data.length;)
		{
			for(int c=0;c<data[row].length;c++)
			{
				if (data[row][c] < min)
				min = data[row][c];
			}
			row++;
			r++;
	}
	
		return min;
	}
	
	

	
}
