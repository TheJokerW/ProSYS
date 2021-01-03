package POJO;

public class Rule {
    int factNum;
    int facts[];
    boolean used;//是否使用
    boolean possible;//是否可能
    boolean endResult;
    int resultID;
    int nextFactPos;//记录下一次需验证的特征位置

    public int getFactNum() {
        return factNum;
    }

    public void setFactNum(int factNum) {
        this.factNum = factNum;
    }

    public int[] getFacts() {
        return facts;
    }

    public void setFacts(int[] facts) {
        this.facts = facts;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean isPossible() {
        return possible;
    }

    public void setPossible(boolean possible) {
        this.possible = possible;
    }

    public boolean isEndResult() {
        return endResult;
    }

    public void setEndResult(boolean endResult) {
        this.endResult = endResult;
    }

    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    public int getNextFactPos() {
        return nextFactPos;
    }

    public void setNextFactPos(int nextFactPos) {
        this.nextFactPos = nextFactPos;
    }

    public Rule(int factNum, int[] facts, boolean used, boolean possible, boolean endResult, int resultID, int nextFactPos) {
        this.factNum = factNum;
        this.facts = facts;
        this.used = used;
        this.possible = possible;
        this.endResult = endResult;
        this.resultID = resultID;
        this.nextFactPos = nextFactPos;
    }
    public Rule(int factNum,int[] facts,boolean endResult,int resultID){
        this.used=false;
        this.possible=true;
        this.factNum = factNum;
        this.facts=facts;
        this.endResult=endResult;
        this.resultID=resultID;
        this.nextFactPos=0;
    }

}
