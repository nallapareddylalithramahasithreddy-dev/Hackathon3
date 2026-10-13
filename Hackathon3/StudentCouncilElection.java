// Scenario: Student Council Election A college is conducting an online student council election where students can nominate themselves for positions such as President, Vice-President, and Secretary. Store each candidate's name, roll number, position, and votes received. Candidates should be registered using different combinations of candidate details. Validate candidate information, compare names to avoid duplicate nominations, display candidate names in uppercase for official election records, and identify the candidate with the highest number of votes for each position. Task: Develop a Java application to simulate this student council election process using constructors, method overloading, and String manipulation. Register at least two candidates for the same position, record their votes, and announce the winner. Expected Output: ========== STUDENT COUNCIL ELECTION ========== Candidate Registered Successfully Candidate Name : ANANYA Roll Number : 101 Position : PRESIDENT Votes Received : 125 Candidate Registered Successfully Candidate Name : RAHUL Roll Number : 102 Position : PRESIDENT Votes Received : 98 Duplicate Candidate Check: Candidate Name : ANANYA Status : Duplicate Nomination ---------- ELECTION RESULTS ---------- Position : PRESIDENT Winning Candidate : ANANYA Total Votes : 125 ============================================= Note: The output is illustrative. Actual output should depend on the candidates and votes processed by the program.



import java.util.*;

class Candidate {
    private String name;
    private String rollNumber;
    private String position;
    private int votes;

    
    Candidate(String name, String rollNumber, String position, int votes) {
        this.name = name.toUpperCase(); 
        this.rollNumber = rollNumber;
        this.position = position.toUpperCase();
        this.votes = votes;
    }

   
    Candidate(String name, String rollNumber, String position) {
        this(name, rollNumber, position, 0); 
    }

   
    Candidate(String name, String rollNumber) {
        this(name, rollNumber, "UNASSIGNED", 0);
    }

    public String getName() { return name; }
    public String getRollNumber() { return rollNumber; }
    public String getPosition() { return position; }
    public int getVotes() { return votes; }

    public void setVotes(int votes) { this.votes = votes; }
    public void setPosition(String position) { this.position = position.toUpperCase(); }

    public void display() {
        System.out.println("Candidate Name : " + name);
        System.out.println("Roll Number    : " + rollNumber);
        System.out.println("Position       : " + position);
        System.out.println("Votes Received : " + votes);
    }
}

public class StudentCouncilElection {
    private static List<Candidate> candidates = new ArrayList<>();

    // Register candidate with duplicate check
    public static void registerCandidate(Candidate c) {
        for (Candidate existing : candidates) {
            if (existing.getName().equals(c.getName())) {
                System.out.println("Duplicate Candidate Check:");
                System.out.println("Candidate Name : " + c.getName());
                System.out.println("Status         : Duplicate Nomination");
                return;
            }
        }
        candidates.add(c);
        System.out.println("Candidate Registered Successfully");
        c.display();
    }

   
    public static void announceResults() {
        System.out.println(" ELECTION RESULTS ");
        Map<String, Candidate> winners = new HashMap<>();

        for (Candidate c : candidates) {
            String pos = c.getPosition();
            if (!winners.containsKey(pos) || c.getVotes() > winners.get(pos).getVotes()) {
                winners.put(pos, c);
            }
        }

        for (String pos : winners.keySet()) {
            Candidate win = winners.get(pos);
            System.out.println("Position : " + pos);
            System.out.println("Winning Candidate : " + win.getName());
            System.out.println("Total Votes : " + win.getVotes());
        }
        System.out.println("=");
    }

    public static void main(String[] args) {
        System.out.println(" STUDENT COUNCIL ELECTION");

       
        Candidate c1 = new Candidate("Ananya", "101", "President", 125);
        Candidate c2 = new Candidate("Rahul", "102", "President", 98);
        Candidate c3 = new Candidate("Ananya", "103", "President", 150); 

        registerCandidate(c1);
        registerCandidate(c2);
        registerCandidate(c3);

        announceResults();
    }
}

