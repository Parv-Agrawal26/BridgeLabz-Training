import java.util.*;

public class FileBackupScheduler {

    private PriorityQueue<BackupTask> queue =
        new PriorityQueue<>();

    public void addBackupTask(String path,int priority)
            throws InvalidBackupPathException {

        if(path == null || path.length() == 0){
            throw new InvalidBackupPathException("Invalid backup path");
        }

        queue.add(new BackupTask(path,priority));
        System.out.println("Backup task added: "+path);
    }

    public void executeBackups(){
        System.out.println("\nExecuting Backups:");

        while(!queue.isEmpty()){
            BackupTask task = queue.poll();
            System.out.println("Backing up "+task.getFolderPath()
                +" Priority "+task.getPriority());
        }
    }

    public static void main(String[] args){

        FileBackupScheduler scheduler =
            new FileBackupScheduler();

        try{
            scheduler.addBackupTask("/system/config",5);
            scheduler.addBackupTask("/user/photos",3);
            scheduler.addBackupTask("",2);
        }
        catch(InvalidBackupPathException e){
            System.out.println(e.getMessage());
        }

        scheduler.executeBackups();
    }
}
