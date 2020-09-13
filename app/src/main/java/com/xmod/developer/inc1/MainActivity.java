package com.xmod.developer.inc1;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import android.app.*;
import android.os.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.text.*;
import android.util.*;
import android.webkit.*;

import java.util.*;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.SeekBar;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ScrollView;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.animation.ObjectAnimator;
import android.media.SoundPool;
import android.media.MediaPlayer;

import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.webkit.WebViewClient;
import android.support.v4.content.ContextCompat;
import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class MainActivity extends AppCompatActivity {


	private AdView adview;




	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private FloatingActionButton _fab;
	private DrawerLayout _drawer;
	private String package_name = "";
	private String your_version = "";
	private String latest_version = "";
	private HashMap<String, Object> map = new HashMap<>();
	private double numara = 0;
	
	private ArrayList<String> string = new ArrayList<>();
	private ArrayList<String> font = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> map1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> map2 = new ArrayList<>();
	
	private LinearLayout linear2;
	private SeekBar seekbar1;
	private WebView webview1;
	private TextView textview1;
	private ImageView imageview2;
	private ImageView imageview4;
	private ScrollView _drawer_a;
	private LinearLayout _drawer_dra;
	private LinearLayout _drawer_linear2;
	private TextView _drawer_ab;
	private LinearLayout _drawer_linear3;
	private LinearLayout _drawer_linear4;
	private LinearLayout _drawer_linear5;
	private LinearLayout _drawer_linear6;
	private LinearLayout _drawer_linear7;
	private LinearLayout _drawer_linear8;
	private LinearLayout _drawer_linear9;
	private LinearLayout _drawer_linear10;
	private LinearLayout _drawer_linear11;
	private ImageView _drawer_imageview1;
	private TextView _drawer_g;
	private ImageView _drawer_imageview2;
	private TextView _drawer_f;
	private ImageView _drawer_imageview3;
	private TextView _drawer_e;
	private ImageView _drawer_imageview4;
	private TextView _drawer_d;
	
	private TimerTask timr;
	private Intent i = new Intent();
	private SharedPreferences id;
	private AlertDialog.Builder custom;
	private ObjectAnimator abc = new ObjectAnimator();
	private AlertDialog.Builder a;
	private Intent b = new Intent();
	private SharedPreferences data;
	private Intent intent = new Intent();
	private Intent bc = new Intent();
	private SharedPreferences data1;
	private Intent ab = new Intent();
	private SoundPool s;
	private MediaPlayer m;
	private DatabaseReference Ver = _firebase.getReference("version");
	private ChildEventListener _Ver_child_listener;
	private AlertDialog.Builder mi;
	private TimerTask im;
	private TimerTask acilis;
	private TimerTask birkeregoster;
	private Vibrator v;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);

		MobileAds.initialize(this, "ca-app-pub-4377139267165661/8888547768");
		adview = findViewById(R.id.adView);
		AdRequest ads = new AdRequest.Builder().addTestDevice("").build();
		adview.loadAd(ads);






		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_fab = (FloatingActionButton) findViewById(R.id._fab);
		
		_drawer = (DrawerLayout) findViewById(R.id._drawer);ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(MainActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);
		
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		seekbar1 = (SeekBar) findViewById(R.id.seekbar1);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		_drawer_a = (ScrollView) _nav_view.findViewById(R.id.a);
		_drawer_dra = (LinearLayout) _nav_view.findViewById(R.id.dra);
		_drawer_linear2 = (LinearLayout) _nav_view.findViewById(R.id.linear2);
		_drawer_ab = (TextView) _nav_view.findViewById(R.id.ab);
		_drawer_linear3 = (LinearLayout) _nav_view.findViewById(R.id.linear3);
		_drawer_linear4 = (LinearLayout) _nav_view.findViewById(R.id.linear4);
		_drawer_linear5 = (LinearLayout) _nav_view.findViewById(R.id.linear5);
		_drawer_linear6 = (LinearLayout) _nav_view.findViewById(R.id.linear6);
		_drawer_linear7 = (LinearLayout) _nav_view.findViewById(R.id.linear7);
		_drawer_linear8 = (LinearLayout) _nav_view.findViewById(R.id.linear8);
		_drawer_linear9 = (LinearLayout) _nav_view.findViewById(R.id.linear9);
		_drawer_linear10 = (LinearLayout) _nav_view.findViewById(R.id.linear10);
		_drawer_linear11 = (LinearLayout) _nav_view.findViewById(R.id.linear11);
		_drawer_imageview1 = (ImageView) _nav_view.findViewById(R.id.imageview1);
		_drawer_g = (TextView) _nav_view.findViewById(R.id.g);
		_drawer_imageview2 = (ImageView) _nav_view.findViewById(R.id.imageview2);
		_drawer_f = (TextView) _nav_view.findViewById(R.id.f);
		_drawer_imageview3 = (ImageView) _nav_view.findViewById(R.id.imageview3);
		_drawer_e = (TextView) _nav_view.findViewById(R.id.e);
		_drawer_imageview4 = (ImageView) _nav_view.findViewById(R.id.imageview4);
		_drawer_d = (TextView) _nav_view.findViewById(R.id.d);
		id = getSharedPreferences("id", Activity.MODE_PRIVATE);
		custom = new AlertDialog.Builder(this);
		a = new AlertDialog.Builder(this);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		data1 = getSharedPreferences("data1", Activity.MODE_PRIVATE);
		mi = new AlertDialog.Builder(this);
		v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				textview1.setText(webview1.getTitle());
				imageview2.setVisibility(View.GONE);
				imageview4.setVisibility(View.VISIBLE);
				seekbar1.setVisibility(View.VISIBLE);
				seekbar1.setProgress((int)10);
				timr = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								seekbar1.setProgress((int)15);
								timr = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												seekbar1.setProgress((int)25);
												timr = new TimerTask() {
													@Override
													public void run() {
														runOnUiThread(new Runnable() {
															@Override
															public void run() {
																seekbar1.setProgress((int)30);
																timr = new TimerTask() {
																	@Override
																	public void run() {
																		runOnUiThread(new Runnable() {
																			@Override
																			public void run() {
																				seekbar1.setProgress((int)40);
																			}
																		});
																	}
																};
																_timer.schedule(timr, (int)(100));
															}
														});
													}
												};
												_timer.schedule(timr, (int)(100));
											}
										});
									}
								};
								_timer.schedule(timr, (int)(100));
							}
						});
					}
				};
				_timer.schedule(timr, (int)(100));
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				textview1.setText(webview1.getTitle());
				imageview2.setVisibility(View.VISIBLE);
				imageview4.setVisibility(View.GONE);
				timr = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								seekbar1.setProgress((int)50);
								timr = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												seekbar1.setProgress((int)60);
												timr = new TimerTask() {
													@Override
													public void run() {
														runOnUiThread(new Runnable() {
															@Override
															public void run() {
																seekbar1.setProgress((int)70);
																timr = new TimerTask() {
																	@Override
																	public void run() {
																		runOnUiThread(new Runnable() {
																			@Override
																			public void run() {
																				seekbar1.setProgress((int)80);
																			}
																		});
																	}
																};
																_timer.schedule(timr, (int)(100));
																timr = new TimerTask() {
																	@Override
																	public void run() {
																		runOnUiThread(new Runnable() {
																			@Override
																			public void run() {
																				seekbar1.setProgress((int)90);
																				timr = new TimerTask() {
																					@Override
																					public void run() {
																						runOnUiThread(new Runnable() {
																							@Override
																							public void run() {
																								seekbar1.setProgress((int)95);
																								timr = new TimerTask() {
																									@Override
																									public void run() {
																										runOnUiThread(new Runnable() {
																											@Override
																											public void run() {
																												seekbar1.setProgress((int)100);
																												seekbar1.setVisibility(View.GONE);
																											}
																										});
																									}
																								};
																								_timer.schedule(timr, (int)(100));
																							}
																						});
																					}
																				};
																				_timer.schedule(timr, (int)(100));
																			}
																		});
																	}
																};
																_timer.schedule(timr, (int)(100));
															}
														});
													}
												};
												_timer.schedule(timr, (int)(100));
											}
										});
									}
								};
								_timer.schedule(timr, (int)(100));
							}
						});
					}
				};
				_timer.schedule(timr, (int)(100));
				super.onPageFinished(_param1, _param2);
			}
		});
		
		textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				overridePendingTransition(android.support.design.R.anim.abc_grow_fade_in_from_bottom, android.support.design.R.anim.abc_grow_fade_in_from_bottom);
				webview1.loadUrl(webview1.getUrl());
				textview1.setText(webview1.getTitle());
				m = MediaPlayer.create(getApplicationContext(), R.raw.scan);
				m.start();
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				overridePendingTransition(android.support.design.R.anim.abc_grow_fade_in_from_bottom, android.support.design.R.anim.abc_grow_fade_in_from_bottom);
				webview1.stopLoading();
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				custom.setView(R.layout.dial);
				custom.setPositiveButton("Video", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						id.edit().putString("video", webview1.getUrl()).commit();
						i.setClass(getApplicationContext(), VideoActivity.class);
						startActivity(i);
					}
				});
				custom.setNeutralButton("Back", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				custom.setNegativeButton("Music", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						id.edit().putString("audio", webview1.getUrl()).commit();
						i.setClass(getApplicationContext(), AudioActivity.class);
						startActivity(i);
					}
				});
				custom.create().show();
				overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
			}
		});
		
		_Ver_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				timr = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								Ver.addListenerForSingleValueEvent(new ValueEventListener() {
									@Override
									public void onDataChange(DataSnapshot _dataSnapshot) {
										map1 = new ArrayList<>();
										try {
											GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
											for (DataSnapshot _data : _dataSnapshot.getChildren()) {
												HashMap<String, Object> _map = _data.getValue(_ind);
												map1.add(_map);
											}
										}
										catch (Exception _e) {
											_e.printStackTrace();
										}
										latest_version = map1.get((int)0).get("v").toString();
										if (Double.parseDouble(latest_version) > Double.parseDouble(your_version)) {
											mi.setTitle("İyi Haber Güncelleme Var");
											mi.setPositiveButton("İndir", new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface _dialog, int _which) {
													webview1.loadUrl("https://drive.google.com/drive/folders/19IRHnmXj_1z96JbLH75ndDnN9-ewaN3S");
												}
											});
											mi.setNegativeButton("Güncellemedikce açılmaz ", new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface _dialog, int _which) {
													
												}
											});
											mi.create().show();
										}
										else {
											if (Double.parseDouble(your_version) > Double.parseDouble(latest_version)) {
												Ver.child("app").child("v").setValue(your_version);
											}
											else {
												webview1.loadUrl("https://m.youtube.com/?hl=tr&gl=TR");
											}
										}
									}
									@Override
									public void onCancelled(DatabaseError _databaseError) {
									}
								});
							}
						});
					}
				};
				_timer.schedule(timr, (int)(1500));
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		Ver.addChildEventListener(_Ver_child_listener);
		
		_drawer_g.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (numara == 0) {
					numara++;
					_drawer_a.setBackgroundColor(Color.BLACK);
					linear2.setBackgroundColor(0xFF000000);
					android.support.v7.app.ActionBar ab = getSupportActionBar();
					ab.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.parseColor("#FF000000")));
					
					setTitle(Html.fromHtml("<font color='#FFFFFF'>  YouTube Mp3 & Mp4</font>")); 
					_drawer_d.setTextColor(Color.parseColor("#FFFFFF"));
					_drawer_e.setTextColor(Color.parseColor("#FFFFFF"));
					_drawer_g.setTextColor(Color.parseColor("#FFFFFF"));
					_drawer_f.setTextColor(Color.parseColor("#FFFFFF"));
					_drawer_ab.setTextColor(Color.parseColor("#FFFFFF"));
					imageview2.setImageResource(R.drawable.ic_autorenew_white1);
					imageview4.setImageResource(R.drawable.ic_clear_white);
					textview1.setTextColor(0xFFFFFFFF);
				}
				else {
					if (numara == 1) {
						_drawer_ab.setTextColor(Color.parseColor("#000000"));
						numara--;
						_drawer_a.setBackgroundColor(Color.WHITE);
						linear2.setBackgroundColor(0xFFFFFFFF);
						android.support.v7.app.ActionBar ab = getSupportActionBar();
						ab.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.parseColor("#FFFFFF")));
						
						setTitle(Html.fromHtml("<font color='#000000'>  YouTube Mp3 & Mp4</font>")); 
						_drawer_d.setTextColor(Color.parseColor("#000000"));
						_drawer_e.setTextColor(Color.parseColor("#000000"));
						_drawer_f.setTextColor(Color.parseColor("#000000"));
						_drawer_g.setTextColor(Color.parseColor("#000000"));
						numara = numara;
						imageview4.setImageResource(R.drawable.ic_close_black);
						imageview2.setImageResource(R.drawable.ic_loop_black);
						textview1.setTextColor(0xFF000000);
					}
				}
				overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
			}
		});
		
		_drawer_f.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				b.setClass(getApplicationContext(), MailsendxmodActivity.class);
				b.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(b);
				overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
			}
		});
		
		_drawer_e.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				b.setClass(getApplicationContext(), XmodhakkindaActivity.class);
				b.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(b);
				overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
			}
		});
		
		_drawer_d.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				b.setClass(getApplicationContext(), YenilikActivity.class);
				b.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(b);
				overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
			}
		});
	}
	private void initializeLogic() {
		webview1.setDownloadListener(new DownloadListener() {     public void onDownloadStart(String url, String userAgent,                 String contentDisposition, String mimetype,                 long contentLength) {         Intent i = new Intent(Intent.ACTION_VIEW);         i.setData(Uri.parse(url));         startActivity(i);     } });
		webview1.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
				DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
				String cookies = CookieManager.getInstance().getCookie(url);
				request.addRequestHeader("cookie", cookies);
				request.addRequestHeader("User-Agent", userAgent);
				request.setDescription("Downloading file...");
				request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
				request.allowScanningByMediaScanner(); request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimetype));
				
				DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				manager.enqueue(request);
				showMessage("Downloading File....");
				//Notif if success
				BroadcastReceiver onComplete = new BroadcastReceiver() {
					public void onReceive(Context ctxt, Intent intent) {
						showMessage("Download Complete!");
						unregisterReceiver(this);
					}};
				registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
			}
		});
		textview1.setText(webview1.getTitle());
		webview1.setWebChromeClient(new CustomWebClient());
		webview1.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		package_name = "com.xmod.developer.inc";
		try {
			android.content.pm.PackageInfo pinfo = getPackageManager().getPackageInfo( package_name, android.content.pm.PackageManager.GET_ACTIVITIES);
			your_version = pinfo.versionName; }
		catch (Exception e){ showMessage(e.toString()); }
		DatabaseReference rootRef = _firebase.getReference();
		 rootRef.child("version").addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
				if (snapshot.exists()) { } else {
					map = new HashMap<>();
					map.put("v", your_version);
					Ver.child("app").updateChildren(map);
					map.clear();
				} }
			@Override
			public void onCancelled(DatabaseError _error) { } });
		birkeregoster = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (data1.getString("splash1", "").length() == 0) {
							data1.edit().putString("splash1", "false").commit();
							bc.setClass(getApplicationContext(), SplashActivity.class);
							startActivity(bc);
							bc.setAction(Intent.ACTION_VIEW);
							bc.setClass(getApplicationContext(), AcilisActivity.class);
							finish();
						}
					}
				});
			}
		};
		_timer.schedule(birkeregoster, (int)(3000));
		setTitle(Html.fromHtml("<font color='#000000'> YouTube Mp3 & Mp4</font>")); 
		{
			linear2.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
			       }
		Intent go_to_new = new Intent(MainActivity.this, AcilisActivity.class); startActivity(go_to_new);
		timr = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						
					}
				});
			}
		};
		_timer.schedule(timr, (int)(10000));
		CookieManager.getInstance().setAcceptCookie(true);
		webview1.getSettings().setSavePassword(true);
		webview1.getSettings().setSaveFormData(true);
		WebSettings webSettings = webview1.getSettings(); 
		webSettings.setJavaScriptEnabled(true); 
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
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
	
	@Override
	public void onBackPressed() {
		if (webview1.canGoBack()) {
			webview1.goBack();
			textview1.setText(webview1.getTitle());
		}
		else {
			a.setMessage("Leaving YouTube Storage");
			a.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					finish();
				}
			});
			a.setNegativeButton("Continue", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			a.create().show();
		}
	}
	private void _extra () {
	}

	public class CustomWebClient extends WebChromeClient {
		private View mCustomView;
		private WebChromeClient.CustomViewCallback mCustomViewCallback;
		protected FrameLayout frame;
		
		// Initially mOriginalOrientation is set to Landscape
		private int mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
		private int mOriginalSystemUiVisibility;
		
		// Constructor for CustomWebClient
		public CustomWebClient() {}
		
		public Bitmap getDefaultVideoPoster() {
			if (MainActivity.this == null) {
				return null; }
			return BitmapFactory.decodeResource(MainActivity.this.getApplicationContext().getResources(), 2130837573); }
		
		public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback viewCallback) {
			if (this.mCustomView != null) {
				onHideCustomView();
				return; }
			this.mCustomView = paramView;
			this.mOriginalSystemUiVisibility = MainActivity.this.getWindow().getDecorView().getSystemUiVisibility();
			// When CustomView is shown screen orientation changes to mOriginalOrientation (Landscape).
			MainActivity.this.setRequestedOrientation(this.mOriginalOrientation);
			// After that mOriginalOrientation is set to portrait.
			this.mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
			this.mCustomViewCallback = viewCallback; ((FrameLayout)MainActivity.this.getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1)); MainActivity.this.getWindow().getDecorView().setSystemUiVisibility(3846);
		}
		
		public void onHideCustomView() {
			((FrameLayout)MainActivity.this.getWindow().getDecorView()).removeView(this.mCustomView);
			this.mCustomView = null;
			MainActivity.this.getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
			// When CustomView is hidden, screen orientation is set to mOriginalOrientation (portrait).
			MainActivity.this.setRequestedOrientation(this.mOriginalOrientation);
			// After that mOriginalOrientation is set to landscape.
			this.mOriginalOrientation = android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE; this.mCustomViewCallback.onCustomViewHidden();
			this.mCustomViewCallback = null;
		}
	}
	
	{
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
