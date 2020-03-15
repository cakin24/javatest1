package GPer;

import java.util.Observable;

public class GPer extends Observable{
    private String name = "GPer生态圈";
    private static GPer gper = null;
    private GPer(){}
    public static GPer getInstance(){
        if(null == gper){
            gper = new GPer();
        }
        return gper;
    }
    public String getName(){
        return name;
    }
    public void publishQuestion(Question question){
        System.out.println(question.getUsername()+"在"+this.name+"上提交了一个问题。");
        setChanged();
        notifyObservers(question);
        int a = 0;
        int b = 0;
        a = test1(b);
    }


    /**
     * @Author cwx897169 on 2020/3/1 20:22
     * @param: 
     * @return: 
     * @Description:
     */   
    private int test1( int b ) {
        return 0;
    }


}
