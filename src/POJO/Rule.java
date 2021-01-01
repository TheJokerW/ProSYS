package POJO;

public class Rule {
    int factNum;
    int facts[];
    boolean used;//是否使用
    boolean possible;//是否可能
    boolean endResult;
    int resultID;
    int nextFactPos;//记录下一次需验证的特征位置

    public Rule(int factNum, int[] facts, boolean used, boolean possible, boolean endResult, int resultID, int nextFactPos) {
        this.factNum = factNum;
        this.facts = facts;
        this.used = used;
        this.possible = possible;
        this.endResult = endResult;
        this.resultID = resultID;
        this.nextFactPos = nextFactPos;
    }


}
