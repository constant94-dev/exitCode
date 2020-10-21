package com.psj.welfare.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.psj.welfare.R;
import com.psj.welfare.custom.OnSingleClickListener;

import java.util.ArrayList;

/*
 * 메인 테스트 액티비티는 구현해 놓은 메인 액티비티를 수정이 필요할 때
 * 수정된 화면을 미리보기 할 때 사용한다
 * */
public class MainActivity extends AppCompatActivity {

	public static final String TAG = "MainTestActivity";

	Button main_done;
	ImageView main_logo, main_job_img, main_student_img, main_living_img, main_pregnancy_img, main_child_img, main_cultural_img, main_company_img, main_homeless_img, main_old_img, main_disorder_img, main_multicultural_img, main_law_img, main_etc_img;
	TextView main_job_title, main_student_title, main_living_title, main_pregnancy_title, main_child_title, main_cultural_title, main_company_title, main_homeless_title, main_old_title, main_disorder_title, main_multicultural_title, main_law_title, main_etc_title;
	LinearLayout main_job, main_student, main_living, main_pregnancy, main_child, main_cultural, main_company, main_homeless, main_old, main_disorder, main_multicultural, main_law, main_etc;

	// 더보기 버튼을 눌렀는지 확인할 때 사용할 boolean 변수. true일 경우에만 로고 클릭 이벤트를 발동시킨다
	boolean isClicked = false;
	// 더보기 버튼 있는 레이아웃
	LinearLayout more_layout;
	// 장애인, 다문화, 법률, 기타 버튼 있는 레이아웃
	LinearLayout multi_law_layout, etc_layout;

	ArrayList<String> m_favorList = new ArrayList<>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// 필요한 뷰들의 findViewById()를 모아놓은 메서드
		init();

		// 더보기 버튼을 누르면 더보기 버튼이 사라지고 다른 4가지 버튼들이 나오게 한다
		more_layout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				isClicked = true;
				Log.e(TAG, "isClicked : " + isClicked);
				Log.e(TAG, "더보기 버튼 클릭됨");
				// 더보기 버튼이 있는 레이아웃은 아예 안 보이게 한다
				more_layout.setVisibility(View.GONE);
				// 다른 4가지 레이아웃들은 보이도록 한다
				main_disorder.setVisibility(View.VISIBLE);
				multi_law_layout.setVisibility(View.VISIBLE);
				main_law.setVisibility(View.VISIBLE);
				etc_layout.setVisibility(View.VISIBLE);
			}
		});

		// 메인 로고 클릭 리스너 호출
		main_logo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isClicked) {
					// 클릭 리스너 작동으로 true가 되었던 boolean 변수를 false로 되돌려, 클릭 시 true가 되어 다른 뷰들을 보여줄 수 있도록 한다
					isClicked = false;
					Log.e(TAG, "isClicked : " + isClicked);
					// 화면 전환 효과 없이 더보기 버튼이 있는 페이지로 이동하게 한다 = VISIBLE 상태가 되었던 버튼들을 다시 GONE 상태로 되돌린다
					more_layout.setVisibility(View.VISIBLE);
					main_disorder.setVisibility(View.GONE);
					multi_law_layout.setVisibility(View.GONE);
					main_law.setVisibility(View.GONE);
					etc_layout.setVisibility(View.GONE);
				}
			}
		});

	} // onCreate end

	@Override
	protected void onStart() {
		super.onStart();


	} // onStart end

	@Override
	protected void onResume() {
		super.onResume();

		main_done.setOnClickListener(new OnSingleClickListener() {
			@Override
			public void onSingleClick(View v) {
				m_favorList.add(0, "전체");
				Intent m_intent = new Intent(MainActivity.this, ResultBenefitActivity.class);
				m_intent.putStringArrayListExtra("favor_btn", m_favorList);
				startActivity(m_intent);
				finish();
			}
		});


		main_job.setOnClickListener(new OnSingleClickListener() {
			@Override
			public void onSingleClick(View v) {
				Log.e(TAG, "취업 레이아웃 클릭!");

				if (v.isSelected()) {
					m_favorList.remove("취업·창업");
					main_job_title.setTextColor(getResources().getColor(R.color.colorBlack));
					main_job_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.job));
					Log.i(TAG, "버튼 클릭 상태 비활성화");
					main_job.setSelected(!main_job.isSelected());
				} else {
					m_favorList.add("취업·창업");
					main_job_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.job_after));
					main_job_title.setTextColor(getResources().getColor(R.color.colorMainWhite));
					Log.i(TAG, "버튼 클릭 활성화!!");
					main_job.setSelected(true);
				}

			}
		}); // 취업 클릭 리스너 끝


		main_student.setOnClickListener(new OnSingleClickListener() {
			@Override
			public void onSingleClick(View v) {
				Log.e(TAG, "학생 레이아웃 클릭!");

				if (v.isSelected()) {
					m_favorList.remove("학생·청년");
					main_student_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.student));
					main_student_title.setTextColor(getResources().getColor(R.color.colorBlack));
					Log.i(TAG, "버튼 클릭 상태 비활성화");
					main_student.setSelected(!main_student.isSelected());
				} else {
					m_favorList.add("학생·청년");
					main_student_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.student_after));
					main_student_title.setTextColor(getResources().getColor(R.color.colorMainWhite));
					Log.i(TAG, "버튼 클릭 활성화!!");
					main_student.setSelected(true);
				}

			}
		}); // 학생 클릭 리스너 끝

		main_living.setOnClickListener(new OnSingleClickListener() {
			@Override
			public void onSingleClick(View v) {
				if (v.isSelected()) {
					m_favorList.remove("주거");
					main_living_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.living));
					main_living_title.setTextColor(getResources().getColor(R.color.colorBlack));
					Log.i(TAG, "버튼 클릭 상태 비활성화");
					main_living.setSelected(!main_living.isSelected());
				} else {
					m_favorList.add("주거");
					main_living_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.living_after));
					main_living_title.setTextColor(getResources().getColor(R.color.colorMainWhite));
					Log.i(TAG, "버튼 클릭 활성화!!");
					main_living.setSelected(true);
				}
			}
		}); // 주거 클릭 리스너 끝

		main_pregnancy.setOnClickListener(new OnSingleClickListener() {
			@Override
			public void onSingleClick(View v) {
				if (v.isSelected()) {
					m_favorList.remove("육아·임신");
					main_pregnancy_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.pregnancy));
					main_pregnancy_title.setTextColor(getResources().getColor(R.color.colorBlack));
					Log.i(TAG, "버튼 클릭 상태 비활성화");
					main_pregnancy.setSelected(!main_pregnancy.isSelected());
				} else {
					m_favorList.add("육아·임신");
					main_pregnancy_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.pregnancy_after));
					main_pregnancy_title.setTextColor(getResources().getColor(R.color.colorMainWhite));
					Log.i(TAG, "버튼 클릭 활성화!!");
					main_pregnancy.setSelected(true);
				}
			}
		}); // 육아 클릭 리스너 끝


		main_child.setOnClickListener(new OnSingleClickListener() {
			@Override
			public void onSingleClick(View v) {
				if (v.isSelected()) {
					m_favorList.remove("아기·어린이");
					main_child_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.child));
					main_child_title.setTextColor(getResources().getColor(R.color.colorBlack));
					Log.i(TAG, "버튼 클릭 상태 비활성화");
					main_child.setSelected(!main_child.isSelected());
				} else {
					m_favorList.add("아기·어린이");
					main_child_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.child_after));
					main_child_title.setTextColor(getResources().getColor(R.color.colorMainWhite));
					Log.i(TAG, "버튼 클릭 활성화!!");
					main_child.setSelected(true);
				}
			}
		}); // 아기 클릭 리스너 끝

		main_cultural.setOnClickListener(new OnSingleClickListener() {
			@Override
			public void onSingleClick(View v) {
				if (v.isSelected()) {
					m_favorList.remove("문화·생활");
					main_cultural_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.cultural));
					main_cultural_title.setTextColor(getResources().getColor(R.color.colorBlack));
					Log.i(TAG, "버튼 클릭 상태 비활성화");
					main_cultural.setSelected(!main_cultural.isSelected());
				} else {
					m_favorList.add("문화·생활");
					main_cultural_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.cultural_after));
					main_cultural_title.setTextColor(getResources().getColor(R.color.colorMainWhite));
					Log.i(TAG, "버튼 클릭 활성화!!");
					main_cultural.setSelected(true);
				}
			}
		}); // 문화 클릭 리스너 끝

		main_company.setOnClickListener(new OnSingleClickListener() {
			@Override
			public void onSingleClick(View v) {
				if (v.isSelected()) {
					m_favorList.remove("기업·자영업자");
					main_company_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.company));
					main_company_title.setTextColor(getResources().getColor(R.color.colorBlack));
					Log.i(TAG, "버튼 클릭 상태 비활성화");
					main_company.setSelected(!main_company.isSelected());
				} else {
					m_favorList.add("기업·자영업자");
					main_company_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.company_after));
					main_company_title.setTextColor(getResources().getColor(R.color.colorMainWhite));
					Log.i(TAG, "버튼 클릭 활성화!!");
					main_company.setSelected(true);
				}
			}
		}); // 기업 클릭 리스너 끝

		main_homeless.setOnClickListener(new OnSingleClickListener() {
			@Override
			public void onSingleClick(View v) {
				if (v.isSelected()) {
					m_favorList.remove("저소득층");
					main_homeless_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.homeless));
					main_homeless_title.setTextColor(getResources().getColor(R.color.colorBlack));
					Log.i(TAG, "버튼 클릭 상태 비활성화");
					main_homeless.setSelected(!main_homeless.isSelected());
				} else {
					m_favorList.add("저소득층");
					main_homeless_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.homeless_after));
					main_homeless_title.setTextColor(getResources().getColor(R.color.colorMainWhite));
					Log.i(TAG, "버튼 클릭 활성화!!");
					main_homeless.setSelected(true);
				}
			}
		}); // 저소득층 클릭 리스너 끝

		main_old.setOnClickListener(new OnSingleClickListener() {
			@Override
			public void onSingleClick(View v) {
				if (v.isSelected()) {
					m_favorList.remove("중장년·노인");
					main_old_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.old));
					main_old_title.setTextColor(getResources().getColor(R.color.colorBlack));
					Log.i(TAG, "버튼 클릭 상태 비활성화");
					main_old.setSelected(!main_old.isSelected());
				} else {
					m_favorList.add("중장년·노인");
					main_old_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.old_after));
					main_old_title.setTextColor(getResources().getColor(R.color.colorMainWhite));
					Log.i(TAG, "버튼 클릭 활성화!!");
					main_old.setSelected(true);
				}
			}
		}); // 노인 클릭 리스너 끝

		main_disorder.setOnClickListener(new OnSingleClickListener() {
			@Override
			public void onSingleClick(View v) {
				if (v.isSelected()) {
					m_favorList.remove("장애인");
					main_disorder_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.disorder));
					main_disorder_title.setTextColor(getResources().getColor(R.color.colorBlack));
					Log.i(TAG, "버튼 클릭 상태 비활성화");
					main_disorder.setSelected(!main_disorder.isSelected());
				} else {
					m_favorList.add("장애인");
					main_disorder_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.disorder_after));
					main_disorder_title.setTextColor(getResources().getColor(R.color.colorMainWhite));
					Log.i(TAG, "버튼 클릭 활성화!!");
					main_disorder.setSelected(true);
				}
			}
		}); // 장애인 클릭 리스너 끝

		main_multicultural.setOnClickListener(new OnSingleClickListener() {
			@Override
			public void onSingleClick(View v) {
				if (v.isSelected()) {
					m_favorList.remove("다문화");
					main_multicultural_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.multicultural));
					main_multicultural_title.setTextColor(getResources().getColor(R.color.colorBlack));
					Log.i(TAG, "버튼 클릭 상태 비활성화");
					main_multicultural.setSelected(!main_multicultural.isSelected());
				} else {
					m_favorList.add("다문화");
					main_multicultural_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.multicultural_after));
					main_multicultural_title.setTextColor(getResources().getColor(R.color.colorMainWhite));
					Log.i(TAG, "버튼 클릭 활성화!!");
					main_multicultural.setSelected(true);
				}
			}
		});

		main_law.setOnClickListener(new OnSingleClickListener() {
			@Override
			public void onSingleClick(View v) {
				if (v.isSelected()) {
					m_favorList.remove("법률");
					main_law_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.law));
					main_law_title.setTextColor(getResources().getColor(R.color.colorBlack));
					Log.i(TAG, "버튼 클릭 상태 비활성화");
					main_law.setSelected(!main_law.isSelected());
				} else {
					m_favorList.add("법률");
					main_law_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.law_after));
					main_law_title.setTextColor(getResources().getColor(R.color.colorMainWhite));
					Log.i(TAG, "버튼 클릭 활성화!!");
					main_law.setSelected(true);
				}
			}
		});

		main_etc.setOnClickListener(new OnSingleClickListener() {
			@Override
			public void onSingleClick(View v) {
				if (v.isSelected()) {
					m_favorList.remove("기타");
					main_etc_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.etc));
					main_etc_title.setTextColor(getResources().getColor(R.color.colorBlack));
					Log.i(TAG, "버튼 클릭 상태 비활성화");
					main_etc.setSelected(!main_etc.isSelected());
				} else {
					m_favorList.add("기타");
					main_etc_img.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.etc_after));
					main_etc_title.setTextColor(getResources().getColor(R.color.colorMainWhite));
					Log.i(TAG, "버튼 클릭 활성화!!");
					main_etc.setSelected(true);
				}
			}
		});

	}// onResume end

	// 더보기 버튼 외 4개 버튼들의 findViewById()를 모아놓은 메서드
	private void init() {
		// 인태 초기화
		main_logo = (ImageView) findViewById(R.id.main_logo);
		more_layout = (LinearLayout) findViewById(R.id.more_layout);
		multi_law_layout = (LinearLayout) findViewById(R.id.multi_law_layout);
		etc_layout = (LinearLayout) findViewById(R.id.etc_layout);

		// 상준 초기화
		main_done = findViewById(R.id.main_done);

		main_job = findViewById(R.id.main_job);
		main_job_title = findViewById(R.id.main_job_title);
		main_job_img = findViewById(R.id.main_job_img);

		main_student = findViewById(R.id.main_student);
		main_student_title = findViewById(R.id.main_student_title);
		main_student_img = findViewById(R.id.main_student_img);

		main_living = findViewById(R.id.main_living);
		main_living_img = findViewById(R.id.main_living_img);
		main_living_title = findViewById(R.id.main_living_title);

		main_pregnancy = findViewById(R.id.main_pregnancy);
		main_pregnancy_img = findViewById(R.id.main_pregnancy_img);
		main_pregnancy_title = findViewById(R.id.main_pregnancy_title);

		main_child = findViewById(R.id.main_child);
		main_child_img = findViewById(R.id.main_child_img);
		main_child_title = findViewById(R.id.main_child_title);

		main_cultural = findViewById(R.id.main_cultural);
		main_cultural_img = findViewById(R.id.main_cultural_img);
		main_cultural_title = findViewById(R.id.main_cultural_title);

		main_company = findViewById(R.id.main_company);
		main_company_img = findViewById(R.id.main_company_img);
		main_company_title = findViewById(R.id.main_company_title);

		main_homeless = findViewById(R.id.main_homeless);
		main_homeless_img = findViewById(R.id.main_homeless_img);
		main_homeless_title = findViewById(R.id.main_homeless_title);

		main_old = findViewById(R.id.main_old);
		main_old_img = findViewById(R.id.main_old_img);
		main_old_title = findViewById(R.id.main_old_title);

		main_disorder = findViewById(R.id.main_disorder);
		main_disorder_img = findViewById(R.id.main_disorder_img);
		main_disorder_title = findViewById(R.id.main_disorder_title);

		main_multicultural = findViewById(R.id.main_multicultural);
		main_multicultural_img = findViewById(R.id.main_multicultural_img);
		main_multicultural_title = findViewById(R.id.main_multicultural_title);

		main_law = findViewById(R.id.main_law);
		main_law_img = findViewById(R.id.main_law_img);
		main_law_title = findViewById(R.id.main_law_title);

		main_etc = findViewById(R.id.main_etc);
		main_etc_img = findViewById(R.id.main_etc_img);
		main_etc_title = findViewById(R.id.main_etc_title);
	}


} // MainActivity class end
