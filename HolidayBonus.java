/*
* Class: CMSC203
* Instructor:Professor Monshi
* Description: This program calculates the total bonuses and the holiday bonus for the store based
* on final sales
* Due: 4/10/2021
* Platform/compiler:Eclipse Java
* I pledge that I have completed the programming assignment
independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Azariyas Tafesse
*/
public class HolidayBonus {
	
	public HolidayBonus() {
		
	}
	
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonuses = new double[data.length];
		for (int row = 0; row < bonuses.length; row++) {
			for (int column = 0; column < data[row].length; column++) {
				if (data[row][column] >= 0) {
					if (data[row][column] == TwoDimRaggedArrayUtility.getHighestInColumn(data, column)) {
						bonuses[row] += high;
					} else if (data[row][column] == TwoDimRaggedArrayUtility.getLowestInColumn(data, column)) {
						bonuses[row] += low;
					} else {
						bonuses[row] += other;
					}
				}
			}
		}
		return bonuses;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonuses = calculateHolidayBonus(data, high, low, other);
		double holidayBonuses = 0;
		for (int row = 0; row < bonuses.length; row++) {
			holidayBonuses += bonuses[row];
		}
		return holidayBonuses;
	}
}