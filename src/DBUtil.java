import POJO.Facts;
import POJO.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public  class DBUtil {

    //特征集与结果集初始化，用以输入输出
    static String Features[] = {"反刍","有蹄","哺乳类",
            "眼向前方","有爪","犬齿","吃肉","下蛋","能飞",
            "有羽毛","蹄类","食肉类","鸟类","有奶","毛发",
            "善飞","黑色白条纹","游泳","长腿","长脖子","黑条纹",
            "暗斑点","黄褐色"};

    static String Results[] = {"信天翁","企鹅","鸵鸟","斑马","长颈鹿","虎","豹"};
    Scanner input;
    ArrayList<String> features;
    ArrayList<Facts> facts;
    ArrayList<Rule> rules;
    private static DBUtil instance;

    public static DBUtil getInstance(){
        if(instance==null){
            instance = new DBUtil();
            instance.initFeatures();
            instance.initRules();
        }
        return instance;
    }
    private DBUtil(){
        input=new Scanner(System.in);
        features = new ArrayList<>();
        facts = new ArrayList<>();
        rules = new ArrayList<>();
    }

    public int printMenuAndGetOption(){
        System.out.println("***********************************************");
        System.out.println("1.添加特征集       2.添加事实");
        System.out.println("3.添加规则         4.查看特征集");
        System.out.println("5.查看事实         6.查看规则");
        System.out.println("7.推理             8.结束");
        System.out.println("***********************************************");
        return (input.nextInt());
    }

    public boolean isSucceedDeal(int currentOption){
        switch (currentOption){
            case 1:
                inputFeatures();
                break;
            case 2:
                inputFacts();
                break;
            case 3:
                inputRules();
                break;
            case 4:
                showFeatures();
                break;
            case 5:
                showFacts();
                break;
            case 6:
                showRules();
                break;
            case 7:
                cal();
                break;
            case 8:
                return false;

        }
        return true;
    }



    public void inputFeatures(){
        System.out.println("***********************************************");
        System.out.println("请输入特征值的个数：");
        int num = input.nextInt();
        System.out.println("请输入特征值(空格分隔)");
        for (int i = 0; i < num; i++) {
            features.add(input.next());
        }
        System.out.println("***********************************************");
    }
     
    public void inputFacts(){
        System.out.println("***********************************************");
        System.out.println("请输入事实的个数：");
        int num = input.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.println("请输入第"+(i+1)+"个事实的特征集的编号的个数：");
            int factNum = input.nextInt();
            int[] facts = new int[factNum];
            for (int j = 0; j < factNum; j++) {
                System.out.println("请输入特征集的编号（以空格分隔）：");
                facts[j] = input.nextInt();
            }
            Facts facts1= new Facts(factNum,facts);
            if(isExistedFact(facts1))
                this.facts.add(facts1);
        }
        System.out.println("***********************************************");
    }

    public void inputRules(){
        System.out.println("***********************************************");
        System.out.println("请输入规则的个数：");
        int num = input.nextInt();
        for (int i = 0; i < num; i++) {

            System.out.println("请输入第"+(i+1)+"个规则作为条件的事实的编号：");
            int factID = input.nextInt();
            System.out.println("请输入第"+(i+1)+"个规则作为结果的事实的编号：");
            int resultID = input.nextInt();
            Rule rule= new Rule(facts.get(factID).getFeatureNum(),facts.get(factID).getFeatures(),true,resultID);
            if (!isExistedRule(rule)){
                rules.add(rule);
            }
        }
        System.out.println("***********************************************");
    }

    public void showFeatures(){
        System.out.println("*****************show features*****************");
        for (int i = 0; i < features.size(); i++) {
            System.out.println("特征集"+(i+1)+":"+features.get(i));
        }
        System.out.println("***********************************************");
    }

    public void showFacts(){
        System.out.println("*****************show Facts*****************");
        for (int i = 0; i < facts.size(); i++) {
            System.out.println("事实"+(i+1)+":");
            int[] features= facts.get(i).getFeatures();
            for (int j = 0; j < features.length; j++) {
                System.out.print(features[j]);
                System.out.print(' ');

            }
            System.out.println("");
        }
        System.out.println("***********************************************");
    }

    public void showRules(){
        System.out.println("*****************show features*****************");
        for (int i = 0; i < rules.size(); i++) {
            System.out.println("规则"+(i+1)+":");
            int[] facts= rules.get(i).getFacts();
            for (int j = 0; j < facts.length; j++) {
                System.out.print(facts[j]);
                System.out.print(' ');
            }
            System.out.print("->" + rules.get(i).getResultID());
            System.out.println("");
        }
        System.out.println("***********************************************");
    }

    public boolean isExistedFact(Facts fact){
        for (int i = 0; i < facts.size(); i++) {
            if(fact.getFeatureNum() == facts.get(i).getFeatureNum()){
                for (int j = 0; j < fact.getFeatureNum(); j++) {
                    if(fact.getFeatures()[j]!=facts.get(i).getFeatures()[j]){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean isExistedRule(Rule rule){
        for (int i = 0; i < rules.size(); i++) {
            if(rule.getFactNum()==rules.get(i).getFactNum()&&rule.isEndResult()==rules.get(i).isEndResult()){
                for (int j = 0; j < rule.getFactNum(); j++) {
                    if(rule.getFacts()[j]!=rules.get(i).getFacts()[j]){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean cal(){
        Facts factsDB =new Facts();
        System.out.println("请输入匹配的特征的数量");
        int featureNum=input.nextInt();//输入一个正整数
        factsDB.setFeatureNum(featureNum);
        System.out.println("对应上表，输入将要匹配的特征值序号");
        int[] features = new int[25];
        for(int k=0;k<featureNum;k++){
            int feature=input.nextInt();//输入一个正整数
            features[k] = feature;
        }
        /*f[0]=14;f[1]=22;f[2]=20;f[3]=19;f[4]=2;*/
        factsDB.setFeatures(features);
        boolean isEnd = false;
        boolean findAns = false;
        while(!isEnd){
            isEnd= true;
            for(int i=0;i<rules.size();i++){
                if(rules.get(i).isUsed() || !rules.get(i).isPossible()) continue;//该规则失效
                int res = cmp(rules.get(i),factsDB);
                if(res == 0){
                    continue;//不匹配
                }else if(res == 1){
                    //匹配，但是为中间值
                    int[] facts=factsDB.getFeatures();
                    int n = factsDB.getFeatureNum();
                    facts[n]=rules.get(i).getResultID();
                    factsDB.setFeatures(facts);
                    factsDB.setFeatureNum(++n);
                    isEnd= false;
                    break;
                }else if(res == 2){
                    //匹配，且为最终答案
                    System.out.println("结果是:"+ this.features.get(rules.get(i).getResultID()-1));
                    findAns=true;
                    break;
                }
            }
        }
        if(!findAns){
            System.out.println("无匹配答案");
        }
        return true;
    }

    //初始化规则库
    private void initRules(){

        //以下为结果集
        //rule0
        int fact0[]={3,12,22,23};
        facts.add(new Facts(4,fact0));
        rules.add(new Rule(4,fact0,true,30));
        //rule1
        int fact1[]={3,12,21,23};
        facts.add(new Facts(4,fact1));
        rules.add(new Rule(4,fact1,true,29));
        //rule2
        int fact2[]={11,19,20,22};
        facts.add(new Facts(4,fact2));
        rules.add(new Rule(4,fact2,true,28));

        //rule3
        int fact3[]={11,21};
        facts.add(new Facts(2,fact3));
        rules.add(new Rule(2,fact3,true,27));

        //rule4
        int fact4[]={17,19,20,13,9};
        facts.add(new Facts(5,fact4));
        rules.add(new Rule(5,fact4,true,26));

        //rule5
        int fact5[]={17,18,13,9};
        facts.add(new Facts(4,fact5));
        rules.add(new Rule(4,fact5,true,25));

        int fact6[]={16,13};
        facts.add(new Facts(2,fact6));
        rules.add(new Rule(2,fact6,true,24));

        //以下为非结果集
        int fact7[]={15};
        facts.add(new Facts(1,fact7));
        rules.add(new Rule(1,fact7,false,26));


        int fact8[]={14};
        facts.add(new Facts(1,fact8));
        rules.add(new Rule(1,fact8,false,26));


        int fact9[]={10};
        facts.add(new Facts(1,fact9));
        rules.add(new Rule(1,fact9,false,13));


        int fact10[]={8,9};
        facts.add(new Facts(2,fact10));
        rules.add(new Rule(2,fact10,false,13));


        int fact11[]={1,7};
        facts.add(new Facts(2,fact11));
        rules.add(new Rule(2,fact11,false,12));


        int fact12[]={4,5,6};
        facts.add(new Facts(3,fact12));
        rules.add(new Rule(3,fact12,false,12));


        int fact13[]={2,3};
        facts.add(new Facts(2,fact13));
        rules.add(new  Rule(2,fact13,false,11));


        int fact14[]={1,3};
        facts.add(new Facts(2,fact14));
        rules.add(new Rule(2,fact14,false,11));
    }

    private void initFeatures(){
        for (int i = 0; i < Features.length; i++) {
            features.add(Features[i]);
        }
        for (int i = 0; i < Results.length; i++) {
            features.add(Results[i]);
        }
    }

    public int cmp(Rule r,Facts f){
        int F_Rule[] = r.getFacts();
        int F_Fact[]= f.getFeatures();
        int factNum =f.getFeatureNum();

        for(int i=r.getNextFactPos();i<r.getFactNum();i++){
            boolean isMatch=false;
            for(int j=0;j<factNum;j++){
                if(F_Rule[i] == F_Fact[j]){//匹配成功
                    if(i+1 == r.getFactNum()){//全部规则特征已匹配完毕
                        r.setUsed(true);
                        if(r.isEndResult()){
                            //是最终答案
                            return 2;
                        }else{
                            //中间特征
                            return 1;
                        }
                    }
                    //部分特征匹配成功，开始匹配下一个特征
                    isMatch=true;
                    break;
                }else{
                    //不匹配，继续循环
                    continue;
                }
            }
            if(isMatch){
                //匹配成功
                continue;
            }else{
                //匹配失败
                r.setNextFactPos(i);
                return 0;
            }
        }
        //无匹配项
        return 0;
    }
}
