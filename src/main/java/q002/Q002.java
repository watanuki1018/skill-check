package q002;

import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

/**
 * Q002 並べ替える
 *
 * dataListに "ID,名字" の形式で20個のデータがあります。
 * これをID順に並べて表示するプログラムを記述してください。
 *
 * dataListの定義を変更してはいけません。
 *
 *
[出力結果イメージ]
1,伊藤
2,井上
（省略）
9,清水
10,鈴木
11,高橋
（省略）
20,渡辺
 */
public class Q002 {
    /**
     * データ一覧
     */
    private static final String[] dataList = {
            "8,佐藤",
            "10,鈴木",
            "11,高橋",
            "12,田中",
            "20,渡辺",
            "1,伊藤",
            "18,山本",
            "13,中村",
            "5,小林",
            "3,加藤",
            "19,吉田",
            "17,山田",
            "7,佐々木",
            "16,山口",
            "6,斉藤",
            "15,松本",
            "2,井上",
            "4,木村",
            "14,林",
            "9,清水"
    };

    public static void main(String[] args) {
        Comparator<String> compareRule = definedCompareRule();

        List<String> sortList = Arrays.asList(dataList);
        Collections.sort(sortList, compareRule);
        sortList.forEach(System.out::println);
    }

    public static Comparator<String> definedCompareRule() {
        return new Comparator<String>() {
            public int compare(String o1, String o2) {
                return Integer.compare(
                    Integer.parseInt(o1.split(",", 0)[0]),
                    Integer.parseInt(o2.split(",", 0)[0])
                );
            }
        };
    }
}
// 完成までの時間: 20分