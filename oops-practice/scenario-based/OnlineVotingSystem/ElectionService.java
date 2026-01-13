public abstract class ElectionService {
    abstract void castVote(String voterId, String candidate) throws DuplicateVoteException;
}
