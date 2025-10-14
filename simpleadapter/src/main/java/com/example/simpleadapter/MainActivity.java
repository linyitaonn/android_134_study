package com.example.simpleadapter;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] animalName = {"CAT", "DOG", "ELEPHANT", "LION", "MONKEY", "TIGER"};
    private int[] animalImage = {R.drawable.cat, R.drawable.dog, R.drawable.elephant, R.drawable.lion, R.drawable.monkey, R.drawable.tiger};

    private static final String CHANNEL_ID = "animal_notification_channel";
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Animal Notifications";
            String description = "Notifications for animal selections";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    private void sendNotification(String animalName) {
        // 创建通知点击后的 Intent
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        // 构建通知
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground) // 使用应用图标
                .setContentTitle(animalName)
                .setContentText(animalName+"来了")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        // 显示通知
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        try {
            notificationManager.notify(animalName.hashCode(), builder.build());
        } catch (SecurityException e) {
            Log.e("Notification", "Permission not granted for notifications", e);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // 创建通知渠道
        createNotificationChannel();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mListView = findViewById(R.id.main_listView);

        List<HashMap<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < animalName.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", animalName[i]);
            map.put("icon", animalImage[i]);
            data.add(map);
        }

        String[] from = {"name", "icon"};
        int[] to = {R.id.animal_name, R.id.animal_icon};

        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,
                data,
                R.layout.item,
                from,
                to
        );
        mListView.setAdapter(simpleAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, Object> item = (HashMap<String, Object>) parent.getItemAtPosition(position);
                String animalName = (String) item.get("name");

                // 创建自定义布局的 Toast
                Toast toast = new Toast(MainActivity.this);
                View toastView = getLayoutInflater().inflate(R.layout.custom_toast, null);

                // 设置文本内容
                TextView textView = toastView.findViewById(R.id.toast_text);
                textView.setText(animalName);

                toast.setView(toastView);

                // 自定义 Toast 可以设置位置
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                int screenHeight = displayMetrics.heightPixels;
                int yPosition = screenHeight * 2/3;
                toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, yPosition);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();

                // 发送通知
                sendNotification(animalName);
            }
        });

    }
}
