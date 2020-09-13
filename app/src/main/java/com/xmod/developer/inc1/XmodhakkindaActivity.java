package com.xmod.developer.inc1;

import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.util.*;

import java.util.*;

import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Context;
import android.os.Vibrator;
import android.view.View;

public class XmodhakkindaActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private double karalendirme = 0;
	private double hiz = 0;
	private double tit = 0;
	
	private LinearLayout linear1;
	private ImageView imageview5;
	
	private TimerTask t;
	private Vibrator v;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.xmodhakkinda);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		imageview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								v.vibrate((long)(1000));
							}
						});
					}
				};
				_timer.schedule(t, (int)(200));
			}
		});
	}
	private void initializeLogic() {
		_b(tit);
		Window window = this.getWindow();window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); window.setNavigationBarColor(Color.parseColor("#0277BD"));
		karalendirme = 0;
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						karalendirme++;
						_hizkare(karalendirme % 7);
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(0), (int)(300));
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						hiz++;
						_yazi(hiz % 7);
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(0), (int)(300));
		overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	private void _hizkare (final double _yazi) {
		if (_yazi == 0) {
			imageview5.setImageResource(R.drawable.x12onki);
		}
		if (_yazi == 1) {
			imageview5.setImageResource(R.drawable.x111111onbir);
		}
		if (_yazi == 2) {
			imageview5.setImageResource(R.drawable.x101010);
		}
		if (_yazi == 3) {
			imageview5.setImageResource(R.drawable.x9999);
		}
		if (_yazi == 4) {
			imageview5.setImageResource(R.drawable.x7777);
		}
		if (_yazi == 5) {
			imageview5.setImageResource(R.drawable.x555);
		}
		if (_yazi == 6) {
			imageview5.setImageResource(R.drawable.x333);
		}
	}
	
	
	private void _yazi (final double _mod) {
		
	}
	
	
	private void _b (final double _a) {
		if (_a == 1) {
			t = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							
						}
					});
				}
			};
			_timer.schedule(t, (int)(400));
			tit++;
		}
		if (_a == 2) {
			t = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							
						}
					});
				}
			};
			_timer.schedule(t, (int)(400));
		}
		if (_a == 3) {
			t = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							
						}
					});
				}
			};
			_timer.schedule(t, (int)(400));
		}
		if (_a == 4) {
			t = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							
						}
					});
				}
			};
			_timer.schedule(t, (int)(400));
		}
		if (_a == 5) {
			t = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							
						}
					});
				}
			};
			_timer.schedule(t, (int)(400));
		}
		if (_a == 6) {
			t = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							
						}
					});
				}
			};
			_timer.schedule(t, (int)(400));
		}
		tit--;
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
