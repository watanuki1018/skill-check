package q005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Q005 データクラスと様々な集計
 *
 * 以下のファイルを読み込んで、WorkDataクラスのインスタンスを作成してください。
 * resources/q005/data.txt
 * (先頭行はタイトルなので読み取りをスキップする)
 *
 * 読み込んだデータを以下で集計して出力してください。
 * (1) 役職別の合計作業時間
 * (2) Pコード別の合計作業時間
 * (3) 社員番号別の合計作業時間
 * 上記項目内での出力順は問いません。
 *
 * 作業時間は "xx時間xx分" の形式にしてください。
 * また、WorkDataクラスは自由に修正してください。
 *
[出力イメージ]
部長: xx時間xx分
課長: xx時間xx分
一般: xx時間xx分
Z-7-31100: xx時間xx分
I-7-31100: xx時間xx分
T-7-30002: xx時間xx分
（省略）
194033: xx時間xx分
195052: xx時間xx分
195066: xx時間xx分
（省略）
 */
public class Q005 {

    private static ArrayList<String> numberList;
    private static ArrayList<String> positionList;
    private static ArrayList<String> pCodeList;
    private static ArrayList<WorkData> workDataList;

    /**
     * データファイルを開く
     * resources/q003/data.txt
     */
    private static InputStream openDataFile() {
        return Q005.class.getResourceAsStream("data.txt");
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(openDataFile()));

        try {
            analyzeData(br);
        } catch (IOException ex) {
            System.out.println("error");
            return;
        }

        printNumberWorkTime();
        printPositionWorkTime();
        printPCodeWorkTime();
    }

    private static String[] splitData(String str) {
        return str.split(",", 0);
    }

    private static void analyzeData(BufferedReader br) throws IOException {
        String line;
        WorkData workData;
        String number;
        String position;
        String pCode;

        while ((line = br.readLine()) != null) {
            if (workDataList == null) {
                workDataList = new ArrayList<WorkData>();
                numberList = new ArrayList<String>();
                positionList = new ArrayList<String>();
                pCodeList = new ArrayList<String>();
                continue;
            }
            String[] splitStr = splitData(line);

            workData = new WorkData(splitStr);

            workDataList.add(workData);

            number = workData.getNumber();
            position = workData.getPosition();
            pCode = workData.getPCode();

            if (!numberList.contains(number)) {
                numberList.add(number);
            }

            if (!positionList.contains(position)) {
                positionList.add(position);
            }

            if (!pCodeList.contains(pCode)) {
                pCodeList.add(pCode);
            }
        }
    }

    private static void printNumberWorkTime() {
        for(String number : numberList) {
            int total = 0;
            for(WorkData workData : workDataList) {
                total += workData.getNumberWorkTime(number);
            }
            int totalHour = total / 60;
            int totalMinute = total % 60;
            System.out.println(number + ": " + totalHour + "時間" + totalMinute + "分");
        }
    }

    private static void printPositionWorkTime() {
        for(String position : positionList) {
            int total = 0;
            for(WorkData workData : workDataList) {
                total += workData.getPositionWorkTime(position);
            }
            int totalHour = total / 60;
            int totalMinute = total % 60;
            System.out.println(position + ": " + totalHour + "時間" + totalMinute + "分");
        }
    }

    private static void printPCodeWorkTime() {
        for(String pCode : pCodeList) {
            int total = 0;
            for(WorkData workData : workDataList) {
                total += workData.getpCodeWorkTime(pCode);
            }
            int totalHour = total / 60;
            int totalMinute = total % 60;
            System.out.println(pCode + ": " + totalHour + "時間" + totalMinute + "分");
        }
    }
}
// 完成までの時間: xx時間 20分