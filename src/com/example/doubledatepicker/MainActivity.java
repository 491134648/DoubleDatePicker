package com.example.doubledatepicker;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button btn;
	TextView et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn = (Button) findViewById(R.id.dateBtn);
		et = (TextView) findViewById(R.id.et);

		btn.setOnClickListener(new View.OnClickListener() {
			Calendar c = Calendar.getInstance();

			@Override
			public void onClick(View v) {
				// ���һ��false��ʾ����ʾ���ڣ����Ҫ��ʾ���ڣ�������������true���߲�������
				new DoubleDatePickerDialog(MainActivity.this, 0, new DoubleDatePickerDialog.OnDateSetListener() {

					@Override
					public void onDateSet(DatePicker startDatePicker, int startYear, int startMonthOfYear,
							int startDayOfMonth, DatePicker endDatePicker, int endYear, int endMonthOfYear,
							int endDayOfMonth) {
						String textString = String.format("��ʼʱ�䣺%d-%d-%d\n����ʱ�䣺%d-%d-%d\n", startYear,
								startMonthOfYear + 1, startDayOfMonth, endYear, endMonthOfYear + 1, endDayOfMonth);
						et.setText(textString);
					}
				}, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), false).show();
			}
		});
	}
}
