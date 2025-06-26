package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class DeriveScheduleTime implements ToIntFunction {

	static int minScheduleTime = 30;

	static String[] p1WorkingTime = { "08:00", "18:00" };

	static String[] p2WorkingTime = { "08:30", "19:00" };

	public static void main(String[] args) {
		String[][] p1 = { { "10:00", "11:00" }, { "13:00", "14:00" }, { "15:00", "15:30" }, { "16:00", "16:30" } };
		String[][] p2 = { { "09:30", "10:00" }, { "11:30", "12:30" }, { "16:00", "17:30" } };

//		findAvailTime(p1, p2);
		findAvailTime1(p1, p2);
	}

	/*
	 * workingTimeP1=["10:00","18:00"] workingTimeP=["09:30","19:00"] p1 =
	 * [["10:00","11:00"],["13:00","14:00"],["15:00","15:30"],["16:00","16:30"]] p2
	 * = [["09:30","10:00"],["11:30","12:30"],["16:00","17:30"]]
	 * 
	 * [["09:30","10:00"],["10:00","11:00"],["11:30","12:30"],["13:00","14:00"],[
	 * "15:00","15:30"],["16:00","16:30"],["16:00","17:30"]]
	 * 
	 * Output -
	 * [["11:00","11:30"],["12:30","13:00"],["14:00","15:00"],["15:30","16:00"],[
	 * "17:30","18:00"]]
	 */
	static void findAvailTime(String[][] p1, String[][] p2) {
		List<String[]> busyTime = new ArrayList<>();
		int p1Pointer = 0;
		int p2Pointer = 0;
		while (p1.length > p1Pointer || p2.length > p2Pointer) {
			if (p1.length == p1Pointer) {
				busyTime.add(p2[p2Pointer]);
				p2Pointer++;
			} else if (p2.length == p2Pointer) {
				busyTime.add(p1[p1Pointer]);
				p1Pointer++;
			} else if (compareTime(convertIntoMin(p1[p1Pointer][1]), convertIntoMin(p2[p2Pointer][1])) == -1) {
				busyTime.add(p1[p1Pointer]);
				p1Pointer++;
			} else {
				busyTime.add(p2[p2Pointer]);
				p2Pointer++;
			}
		}

		busyTime.stream().forEach(sa -> System.out.println(sa[0] + " - " + sa[1]));
		System.out.println("------------------------------------");
		String firstEndTime = null;

		String maxStartTime = compareTime(convertIntoMin(p1WorkingTime[0]), convertIntoMin(p2WorkingTime[0])) == -1
				? p2WorkingTime[0]
				: p1WorkingTime[0];
		System.out.println(maxStartTime);
		String minEndTime = compareTime(convertIntoMin(p1WorkingTime[1]), convertIntoMin(p2WorkingTime[1])) == 1
				? p2WorkingTime[1]
				: p1WorkingTime[1];
		System.out.println(minEndTime);
		System.out.println("-----------------------------------");

		if ((convertIntoMin(busyTime.get(0)[0]) > convertIntoMin(maxStartTime))
				&& subtract(convertIntoMin(maxStartTime), convertIntoMin(busyTime.get(0)[0]))) {
			System.out.println(maxStartTime + " : " + busyTime.get(0)[0]);
		}

		for (int i = 0; i < busyTime.size(); i++) {
			if (i == 0) {
				firstEndTime = busyTime.get(i)[1];
				continue;
			}
			if (compareTime(convertIntoMin(firstEndTime), convertIntoMin(busyTime.get(i)[0])) == -1
					&& subtract(convertIntoMin(firstEndTime), convertIntoMin(busyTime.get(i)[0]))) {
				System.out.println(firstEndTime + " : " + busyTime.get(i)[0]);
			}
			firstEndTime = busyTime.get(i)[1];
		}

		if ((convertIntoMin(busyTime.get(busyTime.size() - 1)[1]) < convertIntoMin(minEndTime))
				&& subtract(convertIntoMin(busyTime.get(busyTime.size() - 1)[1]), convertIntoMin(minEndTime))) {
			System.out.println(busyTime.get(busyTime.size() - 1)[1] + " : " + minEndTime);
		}
	}

	static int convertIntoMin(String p) {
		String[] timeFrame = p.split(":");
		int timeInMin = Integer.parseInt(timeFrame[0]) * 60 + Integer.parseInt(timeFrame[1]);
		return timeInMin;
	}

	static int compareTime(int timeInMinP1, int timeInMinP2) {
		return Integer.compare(timeInMinP1, timeInMinP2);
	}

	static boolean subtract(int timeInMinP1, int timeInMinP2) {
		return (timeInMinP2 - timeInMinP1) >= minScheduleTime;
	}

	static void findAvailTime1(String[][] p1, String[][] p2) {
		List<String[]> busyTime = new ArrayList<>();
		Collections.addAll(busyTime, p1);
		Collections.addAll(busyTime, p2);

		busyTime.forEach(sa -> System.out.println(sa[0] + " - " + sa[1]));

		busyTime.sort(Comparator.comparingInt(a -> convertIntoMin(a[1])));
		System.out.println("---------------------------");
		busyTime.forEach(sa -> System.out.println(sa[0] + " - " + sa[1]));
	}

	@Override
	public int applyAsInt(Object a) {
		String[] timeFrame = a.toString().split(":");
		int timeInMin = Integer.parseInt(timeFrame[0]) * 60 + Integer.parseInt(timeFrame[1]);
		return timeInMin;
	}

}
