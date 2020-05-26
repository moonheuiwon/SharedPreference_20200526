package com.example.sharedpreference_20200526;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.sharedpreference_20200526.databinding.ActivitySignUpBinding;

public class SignUpActivity extends BaseActivity {

    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedRadioId = binding.workTypeRadioGroup.getCheckedRadioButtonId();

                if (clickedRadioId == -1) {
                    Toast.makeText(mContext, "아무 항목도 고르지 않았습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (clickedRadioId == R.id.fullTimeRadioBtn) {
                        Toast.makeText(mContext, "풀타임", Toast.LENGTH_SHORT).show();
                    }
                    else if (clickedRadioId == R.id.partTimeRadioBtn) {
                        Toast.makeText(mContext, "파트타임", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Log.d("오류", "잘못된 선택지");
                    }
                }
            }
        });

        binding.pwCheckEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String inputPw = s.toString();

                if (inputPw.equals("")) {
                    binding.pwCheckResultTxt.setText("비밀번호를 입력해주세요.");
                    binding.pwCheckResultTxt.setTextColor(Color.parseColor("#A0A0A0"));
                }
                else if (inputPw.length() < 8) {
                    binding.pwCheckResultTxt.setText("비밀번호가 너무 짧습니다.");
                    binding.pwCheckResultTxt.setTextColor(Color.RED);
                }
                else {
                    String originalPw = binding.pwEdt.getText().toString();
                    if (!originalPw.equals(inputPw)) {
                        binding.pwCheckResultTxt.setText("비밀번호가 서로 다릅니다.");
                        binding.pwCheckResultTxt.setTextColor(Color.RED);
                    }
                    else {
                        binding.pwCheckResultTxt.setText("사용해도 좋은 비밀번호입니다.");
                        binding.pwCheckResultTxt.setTextColor(Color.parseColor("#2767E3"));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.emailEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String input = s.toString();
                Log.d("변경된내용", s.toString());

//                @를 포함하고, 동시에 최소한 6글자이상이여야지 => 이메일로 인정한다.
                if (input.contains("@") && input.length() >= 6) {
                    binding.emailCheckResultTxt.setText("사용해도 좋은 이메일입니다.");

//                    하늘색으로 글씨색을 변경하고싶습니다.
                    binding.emailCheckResultTxt.setTextColor(Color.parseColor("#2767E3"));
                }
                else {
                    if (input.length() == 0) {
                        binding.emailCheckResultTxt.setText("이메일을 입력해주세요.");
                        binding.emailCheckResultTxt.setTextColor(Color.parseColor("#A0A0A0"));
                    }
                    else {
                        binding.emailCheckResultTxt.setText("이메일 양식으로 입력해주세요.");
                        binding.emailCheckResultTxt.setTextColor(Color.RED);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void setValues() {

    }
}
