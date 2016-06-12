package tsi.secure.lock.data;

import java.util.ArrayList;
import java.util.List;

public class UserDataGen {

    public List<UserData> createSomeData() {

        final List<UserData> userData = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final UserData data = new UserData(i + 1, (int)(Math.random() * 9999) + 1000);
            userData.add(data);
        }

        return userData;
    }
}
