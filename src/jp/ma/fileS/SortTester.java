package jp.ma.fileS;

public class SortTester {
	/*
	 * a[i]よりa[i+1]の方が大きかったら正解 を一個ずつ進めていく
	 */
	String tester(int[] ary, int index) {
		String result = "false";

		while (index < ary.length - 1) {
			if (ary[index] <= ary[index + 1]) {
				result = "true";
				index++;
			} else {
				StringBuilder sb = new StringBuilder();
				result = (sb.append(index).append("番と").append(index + 1).append("番要素のところがfalse")).toString();
				break; // 修正ロジック? 優しすぎる?(笑)
			}
		}

		return result;
	}

	/*
	 * Tester
	 */
	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		SortTester ster = new SortTester();
		int r = 0;

		for (int n = 1; n <= 10; n++) {
			// 読み込みロジックはFileLogicクラスから
			int[] ary = new FileLogic("").reader(r);
			String result = ster.tester(ary, 0);
			System.out.println(result);
			r += 200000000;
		}

		long end = System.currentTimeMillis();

		System.out.println((end - start) / 1000 + "秒");

	}

}