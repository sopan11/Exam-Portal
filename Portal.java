import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;

public class Portal {
    Scanner sc = new Scanner(System.in);

    public void login(Candidate[] candidates) {
        for (; ; ) {
            System.out.println("Welcome to Test Portal");
            System.out.println("Enter Candidate Test ID: ");
            int test_id = sc.nextInt();
            System.out.println("Enter Roll No: ");
            int rollNo = sc.nextInt();
            System.out.println("Enter Password: ");
            String password = sc.next();

            for (int i = 0; i < candidates.length; i++) {
                if ((candidates[i].getTest_id() == test_id) && (candidates[i].getPassword().equals(password))) {
                    System.out.println("Logged In Successfully");
                    System.out.println("Press any key to start test");
                    sc.nextLine();
                    System.out.flush();
                    runTest(candidates[i]);
                } else {
                    System.out.println("Invalid credentials");
                }
            }
            System.out.println("Login another candidate: (press yes)");
            Scanner sc = new Scanner(System.in);
            if(!sc.next().equals("yes")){
                break;
            }
        }
    }

    private void runTest(Candidate candidate){
        String fileName = "Questions.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            Date starTime = new Date();
            Date endTime = new Date(starTime.getTime() + 60 + 60000);
            System.out.println("Test Started at: " + starTime + "\nThe Test will be end at: " + endTime);

                while ((line = br.readLine()) != null) {
                    if (new Date().before(endTime)) {
                        System.out.println(line);
                        System.out.println("Ans: ");
                        String input = sc.nextLine();

                        String ans_fileName = "answer_cand" + candidate.getRollNo() + ".txt";
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ans_fileName, true))) {
                            bw.write(input);
                            bw.newLine();
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }
                System.out.println("Test completed for the candidate with details -\nName: " + candidate.getName() + "\nRoll No: " + candidate.getRollNo() + "\nTest Id: " + candidate.getTest_id());
                System.out.println("Press any key to continue: ");
                sc.nextLine();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        evaluate_marks(candidate);
    }

    public void evaluate_marks(Candidate candidate){
        String fileName = "answer_cand"+candidate.getRollNo()+".txt";
        String fileName2 = "Answers.txt";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(fileName2));
            String answer_line, user_answer;
            while ((answer_line = bufferedReader2.readLine()) != null && (user_answer = bufferedReader.readLine()) != null){
                if(user_answer.equalsIgnoreCase(answer_line)){
                    candidate.setObtained_marks(candidate.getObtained_marks()+1);
                    candidate.setCorrect(candidate.getCorrect()+1);
                }
                else {
                    candidate.setIncorrect(candidate.getIncorrect()+1);
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println("\n\nThe Obtained Marks of the candidate is: "+candidate.getObtained_marks());
        System.out.println("The number of correct responses is: "+candidate.getCorrect());
        System.out.println("The Number of incorrect Response is: "+candidate.getIncorrect());
        System.out.println("Press any key to continue");
        System.out.println("Logging out");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}
