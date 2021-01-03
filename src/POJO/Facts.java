package POJO;

public class Facts {
    int featureNum;
    int features[];
    public Facts(int featureNum, int[] features) {
        this.featureNum = featureNum;
        this.features = features;
    }
    //初始化
    public Facts(){
        featureNum =0;
        features =new int[0];
    }
    public int getFeatureNum() {
        return featureNum;
    }

    public void setFeatureNum(int featureNum) {
        this.featureNum = featureNum;

    }

    public int[] getFeatures() {
        return features;
    }

    public void setFeatures(int[] features) {
        this.features = features;
    }
}
