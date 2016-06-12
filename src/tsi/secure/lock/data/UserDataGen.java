package tsi.secure.lock.data;

import java.util.ArrayList;
import java.util.List;

public class UserDataGen {

    public List<UserData> createSomeData() {

        final List<UserData> userData = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            final int pass = (int)(Math.random() * 9000) + 1000;

            if (pass <= 9999) {
                final UserData data = new UserData(i + 1, pass);
                userData.add(data);
            }
        }

        return userData;
    }
}
