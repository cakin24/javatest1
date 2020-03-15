package GPer;

public class Test
{
    public static void main( String[] args ) {
        GPer gper = GPer.getInstance();
        Teacher tom1 = new Teacher("Tom");
        Teacher mic = new Teacher("Tim");
        gper.addObserver(tom1);
        gper.addObserver(mic);
        Question question = new Question();
        question.setUsername("小明");
        System.out.println("测试1");
        question.setContent("观察者设计模式适用于哪些场景？");
        gper.publishQuestion(question);
        System.out.println("打印2");
    }
}
