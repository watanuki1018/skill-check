package q005;

/**
 * 作業時間管理クラス
 * 自由に修正してかまいません
 */
public class WorkData {
    /** 社員番号 */
    private String number;

    /** 部署 */
    //private String department;

    /** 役職 */
    private String position;

    /** Pコード */
    private String pCode;

    /** 作業時間(分) */
    private int workTime;

    public WorkData(String[] data) {
        this.number = data[0];
        //this.department = data[1];
        this.position = data[2];
        this.pCode = data[3];
        this.workTime = Integer.parseInt(data[4]);
    }

    public String getNumber() {
        return this.number;
    }

    public String getPosition() {
        return this.position;
    }

    public String getPCode() {
        return this.pCode;
    }

    public Integer getNumberWorkTime(String number) {
        if (this.number.equals(number)) {
            return this.workTime;
        }

        return 0;
    }

    public Integer getPositionWorkTime(String position) {
        if (this.position.equals(position)) {
            return this.workTime;
        }

        return 0;
    }

    public Integer getpCodeWorkTime(String pCode) {
        if (this.pCode.equals(pCode)) {
            return this.workTime;
        }

        return 0;
    }
}
