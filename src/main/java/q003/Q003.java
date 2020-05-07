package q003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * Q003 集計と並べ替え
 *
 * 以下のデータファイルを読み込んで、出現する単語ごとに数をカウントし、アルファベット辞書順に並び変えて出力してください。
 * resources/q003/data.txt
 * 単語の条件は以下となります
 * - "I"以外は全て小文字で扱う（"My"と"my"は同じく"my"として扱う）
 * - 単数形と複数形のように少しでも文字列が異れば別単語として扱う（"dream"と"dreams"は別単語）
 * - アポストロフィーやハイフン付の単語は1単語として扱う（"isn't"や"dead-end"）
 *
 * 出力形式:単語=数
 *
[出力イメージ]
（省略）
highest=1
I=3
if=2
ignorance=1
（省略）

 * 参考
 * http://eikaiwa.dmm.com/blog/4690/
 */
public class Q003 {
    /**
     * データファイルを開く
     * resources/q003/data.txt
     */
    private static InputStream openDataFile() {
        return Q003.class.getResourceAsStream("data.txt");
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(openDataFile()));
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();

        try {
            analyzeData(br, map);
        } catch (IOException ex) {
            System.out.println("error");
            return;
        }

        for (String key : map.keySet()) {
            System.out.println(key + "=" + map.get(key));
        }
    }

    private static String[] splitData(String str) {
        return str.split("[,|\\.|;]\s*|\s", 0);
    }

    private static void analyzeData(BufferedReader br, TreeMap<String, Integer> map) throws IOException {
        String line;

        while ((line = br.readLine()) != null) {
            String[] splitStr = splitData(line);
            for (String word : splitStr) {
                if (word.equals("")) {
                    continue;
                }

                if (!word.equals("I")) {
                    word = word.toLowerCase();
                }

                int count = 0;
                if (map.get(word) != null) {
                    count = map.get(word);
                }

                count++;
                map.put(word, count);
            }
        }
    }
}
// 完成までの時間: 2時間