/*
 * Copyright 2016 Brian Donaldson
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uele.gotransitalert.android.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.app.NotificationCompat;

import com.uele.gotransitalert.android.R;

/**
 * Utils for showing local notifications
 */
public class NotificationUtils {

    /**
     * Shows a notification with text, title and icons
     *
     * @param notificationText
     * @param notificationTitle
     * @param notificationSmallIconResource
     * @param context
     */
    public static void showLocalNotification(String notificationText, String notificationTitle, int notificationSmallIconResource, Context context) {
        Notification notification = new NotificationCompat.Builder(context)
                .setTicker(notificationText)
                .setSmallIcon(notificationSmallIconResource)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .setContentTitle(notificationTitle)
                .setColor(context.getResources().getColor(R.color.colorPrimaryDark))
                .setContentText(notificationText)
                .setPriority(Notification.PRIORITY_HIGH)
                .setCategory(Notification.CATEGORY_CALL)
                .setAutoCancel(true)
                .build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }
}
