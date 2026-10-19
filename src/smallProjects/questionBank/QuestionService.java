package smallProjects.questionBank;

import java.util.Arrays;
import java.util.Scanner;

public class QuestionService {
    Question[] questions;
    String[] options;
    String[] userAnswer;
    Scanner input;
    public QuestionService(){
        options = new String[]{"1", "2", "4", "8"};
        questions = new Question[5];
        questions[0] = new Question(1,"size of byte",options,"1");
        questions[1] = new Question(2,"size of short",options,"2");
        questions[2] = new Question(3,"size of int",options,"4");
        questions[3] = new Question(4,"size of long",options,"8");
        questions[4] = new Question(5,"size of char",options,"2");
        input = new Scanner(System.in);
        userAnswer = new String[questions.length];
    }
    public void playQuiz(){
        //System.out.println("In play quiz method");
        for(Question q: questions){
            System.out.println(String.format("Question no %d : %s",q.getId(),q.getQuestion()));
            for(String str : q.getOptions())
                System.out.println(str.formatted("'%s'",str));
            System.out.println("Enter your answer: ");
            userAnswer[q.getId()-1] = input.nextLine();
        }
        System.out.println("User answerd as: "+ Arrays.toString(userAnswer));
    }
    public void printScore(){
        //System.out.println("In printScore method");
        int score=0;
        for(int i=0;i<questions.length;i++){
            if(questions[i].getAnswer().equalsIgnoreCase(userAnswer[i])){
                score++;
            }
        }
        System.out.println(String.format("Your score is:%d/%d",score,questions.length));
    }
}
