import java.util.ArrayList;

public class SocialMediaFriendConnectionsUsingSingly{
    User head;

    public void addUser(int userId, String name, int age){
        User newUser = new User(userId, name, age);
        if(head == null){
            head = newUser;
            System.out.println("User added: " + name);
        } else {
            User current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newUser;
            System.out.println("User added: " + name);
        }
    }

    public void addFriend(int userId, int friendId){
        User user = findUserById(userId);
        User friend = findUserById(friendId);
        if(user != null && friend != null){
            user.friends.add(friend);
            friend.friends.add(user);
            System.out.println(friend.name + " added as a friend to " + user.name);
        } else {
            System.out.println("User not found.");
        }
    }

    public User findUserById(int userId){
        User current = head;
        while(current != null){
            if(current.userId == userId){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void removeFriend(int userId, int friendId){
        User user = findUserById(userId);
        User friend = findUserById(friendId);
        if(user != null && friend != null){
            user.friends.remove(friend);
            friend.friends.remove(user);
            System.out.println(friend.name + " removed from friends of " + user.name);
        } else {
            System.out.println("User not found.");
        }
    }

    public void displayFriends(int userId){
        User user = findUserById(userId);
        if(user != null){
            System.out.print("Friends of " + user.name + ": ");
            for(User friend : user.friends){
                System.out.print(friend.name + " ");
            }
            System.out.println();
        } else {
            System.out.println("User not found.");
        }
    }

    void searchUserByName(String name){
        User current = head;
        boolean found = false;
        while(current != null){
            if(current.name.equalsIgnoreCase(name)){
                System.out.println("User found: " + current.name + ", Age: " + current.age);
                found = true;
            }
            current = current.next;
        }
        if(!found){
            System.out.println("User with name " + name + " not found.");
        }
    }

    void searchUserById(int userId){
        User user = findUserById(userId);
        if(user != null){
            System.out.println("User found: " + user.name + ", Age: " + user.age);
        } else {
            System.out.println("User with ID " + userId + " not found.");
        }
    }

    void countFriends(int userId){
        User user = findUserById(userId);
        if(user != null){
            System.out.println(user.name + " has " + user.friends.size() + " friends.");
        } else {
            System.out.println("User not found.");
        }
    }

    void mutualFriends(int userId1, int userId2){
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if(user1 != null && user2 != null){
            System.out.print("Mutual friends of " + user1.name + " and " + user2.name + ": ");
            for(User friend1 : user1.friends){
                if(user2.friends.contains(friend1)){
                    System.out.print(friend1.name + " ");
                }
            }
            System.out.println();
        } else {
            System.out.println("One or both users not found.");
        }
    }

    public static void main(String[] args) {
        SocialMediaFriendConnectionsUsingSingly sm = new SocialMediaFriendConnectionsUsingSingly();
        sm.addUser(1, "Alice", 25);
        sm.addUser(2, "Bob", 30);
        sm.addUser(3, "Charlie", 28);
        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.displayFriends(1);
        sm.countFriends(1);
        sm.mutualFriends(2, 3);
        sm.searchUserByName("Alice");
        sm.searchUserById(2);
        sm.removeFriend(1, 2);
        sm.displayFriends(1);
    }
}

class User{
    int userId;
    String name;
    int age;
    ArrayList<User> friends;
    User next;
    User(int userId, String name, int age){
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}