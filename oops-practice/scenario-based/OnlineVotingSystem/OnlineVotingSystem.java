import java.util.ArrayList;
import java.util.List;

public class OnlineVotingSystem extends ElectionService {
    static List<Voter> voters = new ArrayList<>();
    static List<Candidate> candidates = new ArrayList<>();

    @Override
    void castVote(String voterId, String candidateName) throws DuplicateVoteException {
        for (Voter v : voters) {
            if (v.voterId.equals(voterId)) {
                if (v.voted) {
                    throw new DuplicateVoteException("Vote already casted");
                }
                for (Candidate c : candidates) {
                    if (c.name.equalsIgnoreCase(candidateName)) {
                        c.votes++;
                        v.voted = true;
                        System.out.println("Vote recorded");
                        return;
                    }
                }
            }
        }
        System.out.println("Invalid voter or candidate");
    }

    public static void main(String[] args) {
        OnlineVotingSystem ovs = new OnlineVotingSystem();

        voters.add(new Voter("V101"));
        candidates.add(new Candidate("Amit"));
        candidates.add(new Candidate("Rohit"));

        try {
            ovs.castVote("V101", "Amit");
            ovs.castVote("V101", "Rohit");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
