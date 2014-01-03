package com.example.studyfromvideo.appwidget;

import com.example.studyfromvideo.R;
import com.example.studyfromvideo.complexcomponent.ComplexCompActivity;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class ExampleAppWidgetProvider extends AppWidgetProvider{
    private static final String UPDATE_ACTION = "studyFromVideo.UPDATE_ACTION";
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		// TODO Auto-generated method stub
		System.out.println("onDeleted");
		super.onDeleted(context, appWidgetIds);
	}

	@Override
	public void onDisabled(Context context) {
		// TODO Auto-generated method stub
		System.out.println("onDisabled");
		super.onDisabled(context);
	}

	@Override
	public void onEnabled(Context context) {
		// TODO Auto-generated method stub
		System.out.println("onEnabled");
		super.onEnabled(context);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("onReceive");
		
		String action = intent.getAction();
		if(UPDATE_ACTION.equals(action)) {
			RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
					R.layout.example_appwidget);
			remoteViews.setTextViewText(R.id.widget_test_testView, "Œ‘≤€°£°£≥…π¶¡À∞•~");
			AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
			ComponentName componentName = new ComponentName(context, ExampleAppWidgetProvider.class);
			appWidgetManager.updateAppWidget(componentName, remoteViews);
		} else {
			super.onReceive(context, intent);
		}
		
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		System.out.println("onUpdate");
		final int N = appWidgetIds.length;

        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];

            // Create an Intent to launch ExampleActivity
            Intent intent = new Intent(context, ComplexCompActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

            Intent intent2 = new Intent();
            intent2.setAction(UPDATE_ACTION);
            PendingIntent pendingIntent2 = PendingIntent.getBroadcast(context, -1, intent2, 0);
            
            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.example_appwidget);
            views.setOnClickPendingIntent(R.id.widget_test_button, pendingIntent);
            views.setOnClickPendingIntent(R.id.widget_change_button, pendingIntent2);
            
            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
            
            
        }
	}

}
