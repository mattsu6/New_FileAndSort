
package jp.ma.fileS;

public class QuickSortLogic {

	void swap(int[] ary, int inxA, int inxB) {
		int box = ary[inxA];
		ary[inxA] = ary[inxB];
		ary[inxB] = box;
	}

	int[] quickSort(int[] ary, int left, int right) {
		/*
		 * すべて要素そのものよりインデックスで扱う意識を持つ (まずパラメーターの受け取りから)
		 */
		int cl = left;
		int cr = right;
		// インデックスを「とっておく」
		// 右辺にとっておいて、左辺が動く

		int center = ary[(cl + cr) / 2];
		// 比較対象は「要素」そのもの（扱いづらいからインデックスで）
		/** centerで表したいのは真ん中のインデックスの中身 **/

		/* 動きを考えながら変数設定、条件分岐 */
		do {
			/*
			 * 場合による判別 ← if-elseでなくif(一つのifが終わったら次のif) 要素そのものの大きさを比較するブロック
			 */
			while (ary[cl] < center)
				cl++;
			// 終わるまでカーソル進ませる、だからifでなくwhile
			while (center < ary[cr])
				cr--;

			if (cl <= cr)
				swap(ary, cl++, cr--);
			// 後置インクリメント（ブロック通ってからインクり）
			// 本当はこの時点で cl > cr

		} while (cl <= cr);
		// cl = cr 必ず一度は交換
		// cl > cr になった時点でdo-while抜け出すロジック

		/*
		 * 抜け出したら、すぐ再帰(ifで二つにフィルタリング)
		 */
		if (left < cr)
			quickSort(ary, left, cr);
		if (cl < right)
			quickSort(ary, cl, right); // 左辺の整理が終わったら右辺に移る

		return ary;
	}

}
