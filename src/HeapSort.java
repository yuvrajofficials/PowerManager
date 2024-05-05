

import java.util.List;

class User {
    String name;
    String phone;
    String city;

    public User(String name, String phone, String city) {
        this.name = name;
        this.phone = phone;
        this.city = city;
    }
}

public class HeapSort {
    public static void heapSort(List<User> users) {
        int n = users.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(users, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            User temp = users.get(0);
            users.set(0, users.get(i));
            users.set(i, temp);

            heapify(users, i, 0);
        }
    }

    private static void heapify(List<User> users, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && users.get(left).phone.compareTo(users.get(largest).phone) > 0) {
            largest = left;
        }

        if (right < n && users.get(right).phone.compareTo(users.get(largest).phone) > 0) {
            largest = right;
        }

        if (largest != i) {
            User swap = users.get(i);
            users.set(i, users.get(largest));
            users.set(largest, swap);

            heapify(users, n, largest);
        }
    }
}
