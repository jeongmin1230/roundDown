package com.example.rounddown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etInputNumber;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInputNumber = (EditText) findViewById(R.id.etInputNumber); // etInputNumber 라는 아이디를 가진 EditText 를 찾아옴
        tvResult = (TextView) findViewById(R.id.tvResult); // 결과 출력을 위해 tvResult 라는 아이디를 가진 TextView 를 찾아옴
    }

    public void onClickResult(View view) {

        try { // try-catch 문으로 예외 처리
            int inputNumber = Integer.parseInt(etInputNumber.getText().toString()); // etInputNumber 에 입력한 숫자를 가져오기 위해 toString 으로 변환하고 다시 parseInt 로 int 로 변환
            Log.i("jeongmin", "inputNumber : " + inputNumber); // inputNumber 의 값을 확인하기 위해 로그로 출력
            int inputToResult = inputNumber%100==0?inputNumber:inputNumber-inputNumber%100; // inputNumber 를 100으로 나눈 나머지가 0이면 inputNumber 그대로 출력, 나머지가 있다면 inputNumber 에서 100으로 나눈 나머지만큼을 뺀 수를 출력하기 위해 삼항연산자 사용
            tvResult.setText("결과는 " + inputToResult + "입니다.");
            etInputNumber.setText(""); // 결과 출력 할 때 etInputNumber 에 입력한 값 클리어
        } catch (Exception e) { // 예외처리
            Toast.makeText(getApplicationContext(), "값이 입력되지 않았습니다.\n값을 입력해주세요.", Toast.LENGTH_SHORT).show();
        }


    }
}