package com.uele.gotransitalert.android.data;

import com.uele.gotransitalert.android.data.db.DbHelper;
import com.uele.gotransitalert.android.data.network.ApiHelper;
import com.uele.gotransitalert.android.data.prefs.PreferencesHelper;

import io.reactivex.Observable;

public interface DataManager
        extends DbHelper, PreferencesHelper, ApiHelper {

    void updateApiHeader(Long userId, String accessToken);

    void setUserAsLoggedOut();

    Observable<Boolean> seedDatabaseQuestions();

    Observable<Boolean> seedDatabaseOptions();

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}

