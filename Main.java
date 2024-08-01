import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        CandidateInfo candidateInfo = new CandidateInfo();

        System.out.println("Enter Number of candidates you want to register: ");
        int n = sc.nextInt();
        System.out.println("Enter Test Id: ");
        int testId = sc.nextInt();
        Candidate[] candidates = new Candidate[n];
        for(int i=0; i<candidates.length; i++) {
            candidates[i] = candidateInfo.createCandidate(testId);
        }
        System.out.println("Do you want to update details of any candidate: (press yes)");
        String choice = sc.next();

        if(choice.equals("yes")){
            System.out.println("Enter Roll No and password of candidate: ");
            int rollNo = sc.nextInt();
            String password = sc.next();
            int count=-1;
            for(int i=0; i< candidates.length; i++){
                if((candidates[i].getRollNo() == rollNo) && candidates[i].getPassword().equals(password)){
                    count++;
                }
            }
            if(count>=0){
                candidateInfo.updateProfile(candidates[count]);
            }
            else {
                System.out.println("Credentials mismatch or candidate not registered");
            }
        }
        for(; ;){
            candidateInfo.getTest(candidates);
            System.out.println("Do you want to continue: (press yes)");
            String ch = sc.next();
            if (!ch.equals("yes")) {
                break;
            }
        }
        System.out.println("The marks obtained by all candidates is: ");
        for(int i=0; i< candidates.length; i++){
            System.out.println("Candidate Roll No: "+candidates[i].getRollNo()+"\nCandidate Name: "+candidates[i].getName()+"\nObtained marks: "+candidates[i].getObtained_marks());
        }
    }
}
