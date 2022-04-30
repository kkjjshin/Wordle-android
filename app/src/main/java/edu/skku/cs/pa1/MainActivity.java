package edu.skku.cs.pa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_submit = findViewById(R.id.btn_submit); // submit 버튼 생성
        ArrayList<InputWordle> items = new ArrayList<>(); //worlde listview 위한 ArrayList 생성
        ArrayList<Guesscontents_gray> items_gray = new ArrayList<>(); //guessview gray color 위한 ArrayList 생성
        ArrayList<Guesscontents_yellow> items_yellow = new ArrayList<>();
        ArrayList<Guesscontents_green> items_green = new ArrayList<>();


        //guessview에 넣기 위한 Arraylist 컬러별 지정
        ArrayList word_gray = new ArrayList();
        ArrayList word_yellow = new ArrayList();
        ArrayList word_green = new ArrayList();


        try {

            // 파일 읽어와서 string 저장
            AssetManager assetMgr = getAssets();
            InputStream is = assetMgr.open("wordle_words.txt");
            Scanner s = new Scanner(is).useDelimiter("\\A");
            String result = s.hasNext() ? s.next() : "";
            String[] array_file = result.split("\\n"); //파일 배열에 담아줌

            //랜덤 정답 생성 위한 인수
            Random random = new Random();
            int randint = random.nextInt(array_file.length);

            //랜덤 정답 생성
            String ans_wordle = array_file[randint];


            btn_submit.setOnClickListener(view -> {

                //콘텐츠 넣어줄 리스트 뷰 생성
                ListView lv_wordle = findViewById(R.id.listview_wordle);
                ListView gv_gray = findViewById(R.id.guessview1);
                ListView gv_yellow = findViewById(R.id.guessview2);
                ListView gv_green = findViewById(R.id.guessview3);


                //여기서 입려받은 텍스트뷰 알파벳 꺼내줌
                TextView textView = (TextView) findViewById(R.id.text_wordle);
                String str_textView = textView.getText().toString(); //배열로 변환 (소문자)

                // 글자 color 지정해주는 string
                String tv_color1 = null;
                String tv_color2 = null;
                String tv_color3 = null;
                String tv_color4 = null;
                String tv_color5 = null;


                //어댑터 생성
                ListViewAdapterWordle mAdapter = new ListViewAdapterWordle(getApplicationContext(), items); //wordle Listview 위한 어댑터
                GuessviewAdapter_gray mAdapter_gray = new GuessviewAdapter_gray(getApplicationContext(), items_gray); //guessviw gray 위한 어댑터
                GuessviewAdapter_yellow mAdapter_yellow = new GuessviewAdapter_yellow(getApplicationContext(), items_yellow);
                GuessviewAdapter_green mAdapter_green = new GuessviewAdapter_green(getApplicationContext(), items_green);

                //글자수 5개로 맞춰주는 작업
                for (int i = 0; i < array_file.length; i++) {
                    array_file[i] = array_file[i].substring(0, 5);
                }

                int dtnryCheck = 0; // 토스트메시지 보내기 위한 용도

                //입력한 글자 사전에 있는지 체크
                for (int i = 0; i < array_file.length; i++) {
                    if (str_textView.equals(array_file[i])) {
                        //사전에 존재하면 대문자로 변환 후, wordle list에 넣어줌
                        String[] array_textView = str_textView.toUpperCase().split("");


                        // Green 인지 확인 (존재 및 인덱스 위치 적합)
                        if (str_textView.toUpperCase().charAt(0) == ans_wordle.toUpperCase().charAt(0)) {
                            tv_color1 = "Green";
                            if (word_green.indexOf(array_textView[0]) == -1) {
                                word_green.add(array_textView[0]);
                                items_green.add(new Guesscontents_green(array_textView[0]));
                                if (word_yellow.indexOf(array_textView[0]) != -1) { //yellow 워드 지워줌
                                    items_yellow.remove(word_yellow.indexOf(array_textView[0]));
                                    word_yellow.remove(word_yellow.indexOf(array_textView[0]));
                                }
                            }
                        }
                        if (str_textView.toUpperCase().charAt(1) == ans_wordle.toUpperCase().charAt(1)) {
                            tv_color2 = "Green";
                            if (word_green.indexOf(array_textView[1]) == -1) {
                                word_green.add(array_textView[1]);
                                items_green.add(new Guesscontents_green(array_textView[1]));
                                if (word_yellow.indexOf(array_textView[1]) != -1) { //yellow 워드 지워줌
                                    items_yellow.remove(word_yellow.indexOf(array_textView[1]));
                                    word_yellow.remove(word_yellow.indexOf(array_textView[1]));
                                }
                            }
                        }
                        if (str_textView.toUpperCase().charAt(2) == ans_wordle.toUpperCase().charAt(2)) {
                            tv_color3 = "Green";
                            if (word_green.indexOf(array_textView[2]) == -1) {
                                word_green.add(array_textView[2]);
                                items_green.add(new Guesscontents_green(array_textView[2]));
                                if (word_yellow.indexOf(array_textView[2]) != -1) { //yellow 워드 지워줌
                                    items_yellow.remove(word_yellow.indexOf(array_textView[2]));
                                    word_yellow.remove(word_yellow.indexOf(array_textView[2]));
                                }
                            }
                        }
                        if (str_textView.toUpperCase().charAt(3) == ans_wordle.toUpperCase().charAt(3)) {
                            tv_color4 = "Green";
                            if (word_green.indexOf(array_textView[3]) == -1) {
                                word_green.add(array_textView[3]);
                                items_green.add(new Guesscontents_green(array_textView[3]));
                                if (word_yellow.indexOf(array_textView[3]) != -1) { //yellow 워드 지워줌
                                    items_yellow.remove(word_yellow.indexOf(array_textView[3]));
                                    word_yellow.remove(word_yellow.indexOf(array_textView[3]));
                                }
                            }
                        }
                        if (str_textView.toUpperCase().charAt(4) == ans_wordle.toUpperCase().charAt(4)) {
                            tv_color5 = "Green";
                            if (word_green.indexOf(array_textView[4]) == -1) {
                                word_green.add(array_textView[4]);
                                items_green.add(new Guesscontents_green(array_textView[4]));
                                if (word_yellow.indexOf(array_textView[4]) != -1) { //yellow 워드 지워줌
                                    items_yellow.remove(word_yellow.indexOf(array_textView[4]));
                                    word_yellow.remove(word_yellow.indexOf(array_textView[4]));
                                }
                            }
                        }


                        // Yellow 인지 확인 (존재만 함)
                        if (ans_wordle.indexOf(String.valueOf(str_textView.charAt(0))) != -1 &&
                                str_textView.toUpperCase().charAt(0) != ans_wordle.toUpperCase().charAt(0)) {
                            tv_color1 = "Yellow";
                            if (word_yellow.indexOf(array_textView[0]) == -1 && word_green.indexOf(array_textView[0]) == -1) {
                                word_yellow.add(array_textView[0]);
                                items_yellow.add(new Guesscontents_yellow(array_textView[0]));
                            }
                        }
                        if (ans_wordle.indexOf(String.valueOf(str_textView.charAt(1))) != -1 &&
                                str_textView.toUpperCase().charAt(1) != ans_wordle.toUpperCase().charAt(1)) {
                            tv_color2 = "Yellow";
                            if (word_yellow.indexOf(array_textView[1]) == -1 && word_green.indexOf(array_textView[1]) == -1) {
                                word_yellow.add(array_textView[1]);
                                items_yellow.add(new Guesscontents_yellow(array_textView[1]));
                            }
                        }
                        if (ans_wordle.indexOf(String.valueOf(str_textView.charAt(2))) != -1 &&
                                str_textView.toUpperCase().charAt(2) != ans_wordle.toUpperCase().charAt(2)) {
                            tv_color3 = "Yellow";
                            if (word_yellow.indexOf(array_textView[2]) == -1 && word_green.indexOf(array_textView[2]) == -1) {
                                word_yellow.add(array_textView[2]);
                                items_yellow.add(new Guesscontents_yellow(array_textView[2]));
                            }
                        }
                        if (ans_wordle.indexOf(String.valueOf(str_textView.charAt(3))) != -1 &&
                                str_textView.toUpperCase().charAt(3) != ans_wordle.toUpperCase().charAt(3)) {
                            tv_color4 = "Yellow";
                            if (word_yellow.indexOf(array_textView[3]) == -1 && word_green.indexOf(array_textView[3]) == -1) {
                                word_yellow.add(array_textView[3]);
                                items_yellow.add(new Guesscontents_yellow(array_textView[3]));
                            }
                        }
                        if (ans_wordle.indexOf(String.valueOf(str_textView.charAt(4))) != -1 &&
                                str_textView.toUpperCase().charAt(4) != ans_wordle.toUpperCase().charAt(4)) {
                            tv_color5 = "Yellow";
                            if (word_yellow.indexOf(array_textView[4]) == -1 && word_green.indexOf(array_textView[4]) == -1) {
                                word_yellow.add(array_textView[4]);
                                items_yellow.add(new Guesscontents_yellow(array_textView[4]));
                            }
                        }


                        //gray 인지 확인 및 guesslist에 넣어줌(아예 존재 X)
                        if (ans_wordle.indexOf(String.valueOf(str_textView.charAt(0))) == -1) {
                            tv_color1 = "Gray";
                            if (word_gray.indexOf(array_textView[0]) == -1) {
                                word_gray.add(array_textView[0]); //graylist 에 담아줌
                                items_gray.add(new Guesscontents_gray(array_textView[0]));
                            }
                        }
                        if (ans_wordle.indexOf(String.valueOf(str_textView.charAt(1))) == -1) {
                            tv_color2 = "Gray";
                            if (word_gray.indexOf(array_textView[1]) == -1) {
                                word_gray.add(array_textView[1]);
                                items_gray.add(new Guesscontents_gray(array_textView[1]));
                            }
                        }
                        if (ans_wordle.indexOf(String.valueOf(str_textView.charAt(2))) == -1) {
                            tv_color3 = "Gray";
                            if (word_gray.indexOf(array_textView[2]) == -1) {
                                word_gray.add(array_textView[2]);
                                items_gray.add(new Guesscontents_gray(array_textView[2]));
                            }
                        }
                        if (ans_wordle.indexOf(String.valueOf(str_textView.charAt(3))) == -1) {
                            tv_color4 = "Gray";
                            if (word_gray.indexOf(array_textView[3]) == -1) {
                                word_gray.add(array_textView[3]);
                                items_gray.add(new Guesscontents_gray(array_textView[3]));
                            }
                        }
                        if (ans_wordle.indexOf(String.valueOf(str_textView.charAt(4))) == -1) {
                            tv_color5 = "Gray";
                            if (word_gray.indexOf(array_textView[4]) == -1) {
                                word_gray.add(array_textView[4]);
                                items_gray.add(new Guesscontents_gray(array_textView[4]));
                            }
                        }

                        //wordle listView 데이터 담아줌
                        items.add(new InputWordle(array_textView[0], array_textView[1], array_textView[2],
                                array_textView[3], array_textView[4], tv_color1, tv_color2, tv_color3, tv_color4
                                , tv_color5));


                        // 새로 추가된 단어 표기위한 용도
                        mAdapter.notifyDataSetChanged();
                        mAdapter_gray.notifyDataSetChanged();
                        mAdapter_yellow.notifyDataSetChanged();


                        //어댑터로 보내줌
                        lv_wordle.setAdapter(mAdapter);
                        gv_gray.setAdapter(mAdapter_gray);
                        gv_yellow.setAdapter(mAdapter_yellow);
                        gv_green.setAdapter(mAdapter_green);

                        textView.setText(null); //textview value 초기화

                        dtnryCheck = 1;
                    }
                }

                //사전에 등재되지 않은 문자의 경우 토스트 메세지 날려줌
                if (dtnryCheck == 0) {
                    Toast.makeText(getApplicationContext(),
                            "word '" + str_textView + "' not in dictionary", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}