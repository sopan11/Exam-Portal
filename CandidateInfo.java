import java.util.Scanner;

public class CandidateInfo {
    Scanner sc = new Scanner(System.in);

    public Candidate createCandidate(int testId){
        System.out.println("Welcome to Student Registration Portal");
        System.out.println("Enter Roll No of Candidate: ");
        int rollNo = sc.nextInt();
        System.out.println("Enter Name of Candidate: ");
        String name = sc.next();
        System.out.println("Enter Password for Candidate: ");
        String password = sc.next();
        System.out.println("Candidate Registration Successful, please note the candidate test id => "+testId);

        return new Candidate(testId, rollNo, name, password);
    }

    public void updateProfile(Candidate candidate){
        System.out.println("Welcome to Update Profile Interface");
        System.out.println("1.Update Roll No\n2.Update Name\n3.Update Password");
        System.out.println("Enter Your choice: ");
        int ch = sc.nextInt();

        switch (ch){
            case 1:
                System.out.println("Enter New Roll No: ");
                candidate.setRollNo(sc.nextInt());
                break;
            case 2:
                System.out.println("Enter New Name: ");
                candidate.setName(sc.next());
                break;
            case 3:
                System.out.println("Enter New Password: ");
                candidate.setPassword(sc.next());
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void getTest(Candidate[] candidates){
        Portal portal = new Portal();
        portal.login(candidates);
    }
}
