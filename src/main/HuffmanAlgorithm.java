package main;

import java.util.PriorityQueue;

public class HuffmanAlgorithm {

	static class CharOccurence implements Comparable<CharOccurence> {
		private int id;
		private int occur;

		public int getId() {
			return id;
		}

		public int getOccur() {
			return occur;
		}

		public CharOccurence(int id, int occur) {
			super();
			this.id = id;
			this.occur = occur;
		}

		@Override
		public String toString() {
			return "CharOccurence [id=" + id + ", occur=" + occur + "]";
		}

		@Override
		public int compareTo(CharOccurence o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.occur, o.occur);
		}
	}

	public static void main(String[] args) {
		CharOccurence occurence1 = new CharOccurence(0, 6);
		CharOccurence occurence2 = new CharOccurence(1, 3);
		CharOccurence occurence3 = new CharOccurence(2, 4);
		CharOccurence occurence4 = new CharOccurence(3, 2);
		CharOccurence occurence5 = new CharOccurence(4, 1);

		PriorityQueue<CharOccurence> pq = new PriorityQueue<>();
		pq.add(occurence1);
		pq.add(occurence2);
		pq.add(occurence3);
		pq.add(occurence4);
		pq.add(occurence5);

		System.out.println(pq);

		String[] occurArr = new String[pq.size()];
		int num = 0;
		int i = 0;

		while (!pq.isEmpty()) {
			CharOccurence ch = pq.poll();
			if (num > ch.getOccur()) {
				occurArr[i] = occurArr[i] + "0";
			} else {
				occurArr[i] = occurArr[i] + "1";
			}
			num = num + ch.getOccur();
		}

	}

}
