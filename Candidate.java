public class Candidate {
    private int rollNo;
    private String name;
    private String password;
    private int obtained_marks = 0;
    private int correct = 0;
    private int incorrect = 0;
    private int test_id;

    public Candidate(int test_id, int rollNo, String name, String password) {
        this.test_id = test_id;
        this.rollNo = rollNo;
        this.name = name;
        this.password = password;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getObtained_marks() {
        return obtained_marks;
    }

    public void setObtained_marks(int obtained_marks) {
        this.obtained_marks = obtained_marks;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public int getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
    }
}
