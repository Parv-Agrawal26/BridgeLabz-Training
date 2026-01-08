public class SocialMediaFriendConnectionsUsingSingly {
    public static void main(String[] args) {
        UserList users = new UserList();

        users.addUser(new User(1, "Alice", 20));
        users.addUser(new User(2, "Bob", 21));
        users.addUser(new User(3, "Charlie", 22));
        users.addUser(new User(4, "Daisy", 23));

        System.out.println("Users:");
        users.displayUsers();

        System.out.println("\nAdd friend connections:");
        users.addFriendConnection(1, 2);
        users.addFriendConnection(1, 3);
        users.addFriendConnection(2, 3);
        users.addFriendConnection(2, 4);

        System.out.println("\nFriends of Alice (ID=1):");
        users.displayFriendsOfUser(1);

        System.out.println("\nFriends of Bob (ID=2):");
        users.displayFriendsOfUser(2);

        System.out.println("\nMutual friends of Alice (1) and Bob (2):");
        users.findMutualFriends(1, 2);

        System.out.println("\nSearch user by Name 'Charlie':");
        users.searchUserByName("Charlie");

        System.out.println("\nRemove friend connection (2,3):");
        users.removeFriendConnection(2, 3);

        System.out.println("\nFriends of Bob (ID=2) after removal:");
        users.displayFriendsOfUser(2);

        System.out.println("\nFriend counts:");
        users.countFriendsForEachUser();
    }

    static final class User {
        final int userId;
        final String name;
        final int age;

        User(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
        }
    }

    static final class UserList {
        private static final class FriendNode {
            int friendId;
            FriendNode next;

            FriendNode(int friendId) {
                this.friendId = friendId;
            }
        }

        private static final class UserNode {
            User data;
            FriendNode friendsHead;
            UserNode next;

            UserNode(User data) {
                this.data = data;
            }
        }

        private UserNode head;

        void addUser(User user) {
            UserNode newNode = new UserNode(user);
            if (head == null) {
                head = newNode;
            } else {
                UserNode current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            System.out.println("User added: " + user.userId + " - " + user.name);
        }

        void displayUsers() {
            if (head == null) {
                System.out.println("No users.");
                return;
            }
            UserNode current = head;
            while (current != null) {
                System.out.println("User ID: " + current.data.userId + ", Name: " + current.data.name + ", Age: "
                        + current.data.age);
                current = current.next;
            }
        }

        boolean addFriendConnection(int userA, int userB) {
            if (userA == userB) {
                System.out.println("Cannot add self as friend.");
                return false;
            }

            UserNode a = findUserNodeById(userA);
            UserNode b = findUserNodeById(userB);
            if (a == null || b == null) {
                System.out.println("One or both users not found.");
                return false;
            }

            boolean addedA = addFriendToList(a, userB);
            boolean addedB = addFriendToList(b, userA);

            if (addedA && addedB) {
                System.out.println("Friend connection added between " + userA + " and " + userB);
                return true;
            }

            System.out.println("Friend connection already exists between " + userA + " and " + userB);
            return false;
        }

        boolean removeFriendConnection(int userA, int userB) {
            UserNode a = findUserNodeById(userA);
            UserNode b = findUserNodeById(userB);
            if (a == null || b == null) {
                System.out.println("One or both users not found.");
                return false;
            }

            boolean removedA = removeFriendFromList(a, userB);
            boolean removedB = removeFriendFromList(b, userA);

            if (removedA && removedB) {
                System.out.println("Friend connection removed between " + userA + " and " + userB);
                return true;
            }

            System.out.println("Friend connection not found between " + userA + " and " + userB);
            return false;
        }

        void findMutualFriends(int userA, int userB) {
            UserNode a = findUserNodeById(userA);
            UserNode b = findUserNodeById(userB);
            if (a == null || b == null) {
                System.out.println("One or both users not found.");
                return;
            }

            FriendNode fa = a.friendsHead;
            boolean found = false;
            while (fa != null) {
                if (containsFriend(b.friendsHead, fa.friendId)) {
                    System.out.println("Mutual Friend ID: " + fa.friendId + " (" + getUserName(fa.friendId) + ")");
                    found = true;
                }
                fa = fa.next;
            }

            if (!found) {
                System.out.println("No mutual friends.");
            }
        }

        void displayFriendsOfUser(int userId) {
            UserNode user = findUserNodeById(userId);
            if (user == null) {
                System.out.println("User not found.");
                return;
            }

            if (user.friendsHead == null) {
                System.out.println("No friends for " + user.data.name);
                return;
            }

            System.out.println("Friends of " + user.data.name + ":");
            FriendNode current = user.friendsHead;
            while (current != null) {
                System.out.println("Friend ID: " + current.friendId + " (" + getUserName(current.friendId) + ")");
                current = current.next;
            }
        }

        void searchUserById(int userId) {
            UserNode user = findUserNodeById(userId);
            if (user == null) {
                System.out.println("User with ID " + userId + " not found.");
                return;
            }
            System.out.println("Found User -> ID: " + user.data.userId + ", Name: " + user.data.name + ", Age: "
                    + user.data.age);
        }

        void searchUserByName(String name) {
            UserNode current = head;
            while (current != null) {
                if (current.data.name.equalsIgnoreCase(name)) {
                    System.out.println("Found User -> ID: " + current.data.userId + ", Name: " + current.data.name
                            + ", Age: " + current.data.age);
                    return;
                }
                current = current.next;
            }
            System.out.println("User with name '" + name + "' not found.");
        }

        void countFriendsForEachUser() {
            UserNode current = head;
            while (current != null) {
                int count = 0;
                FriendNode f = current.friendsHead;
                while (f != null) {
                    count++;
                    f = f.next;
                }
                System.out.println("User " + current.data.userId + " (" + current.data.name + ") has " + count
                        + " friends");
                current = current.next;
            }
        }

        private UserNode findUserNodeById(int userId) {
            UserNode current = head;
            while (current != null) {
                if (current.data.userId == userId) {
                    return current;
                }
                current = current.next;
            }
            return null;
        }

        private boolean addFriendToList(UserNode userNode, int friendId) {
            if (containsFriend(userNode.friendsHead, friendId)) {
                return false;
            }

            FriendNode newNode = new FriendNode(friendId);
            if (userNode.friendsHead == null) {
                userNode.friendsHead = newNode;
            } else {
                FriendNode current = userNode.friendsHead;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            return true;
        }

        private boolean removeFriendFromList(UserNode userNode, int friendId) {
            FriendNode head = userNode.friendsHead;
            if (head == null) {
                return false;
            }

            if (head.friendId == friendId) {
                userNode.friendsHead = head.next;
                return true;
            }

            FriendNode current = head;
            while (current.next != null) {
                if (current.next.friendId == friendId) {
                    current.next = current.next.next;
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        private boolean containsFriend(FriendNode friends, int friendId) {
            FriendNode current = friends;
            while (current != null) {
                if (current.friendId == friendId) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        private String getUserName(int userId) {
            UserNode user = findUserNodeById(userId);
            return user == null ? "Unknown" : user.data.name;
        }
    }
}
