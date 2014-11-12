package com.joygin.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.joygin.demo.view.SwitchButton;
import com.joygin.demo.view.SwitchButton.OnStateChangeListener;

/**
 * @author 房建斌
 * @date 2014-11-11 下午5:43:07
 *
 */
public class SwitchButtonActivity extends Activity implements OnClickListener{
	
	SwitchButton switchButton;
	TextView textview;
	Button bt_on;
	Button bt_off;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_switch_button);
		
		switchButton = (SwitchButton) findViewById(R.id.switch_button);
		textview = (TextView) findViewById(R.id.textview);
		bt_on = (Button) findViewById(R.id.bt_on);
		bt_off = (Button) findViewById(R.id.bt_off);
		
		bt_on.setOnClickListener(this);
		bt_off.setOnClickListener(this);
		
		if(switchButton.isOn()) {
			textview.setText("当前状态: 开");
		} else {
			textview.setText("当前状态: 关");
		}
		
		switchButton.setOnStateChangeListener(new OnStateChangeListener() {
			
			@Override
			public void onStateChanged(boolean on) {
				if(on) {
					textview.setText("当前状态: 开");
				} else {
					textview.setText("当前状态: 关");					
				}
			}
		});
		
	}
	
	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.bt_on:
			switchButton.turnOn();
			break;
		case R.id.bt_off:
			switchButton.turnOff();
			break;
		}
	}
}