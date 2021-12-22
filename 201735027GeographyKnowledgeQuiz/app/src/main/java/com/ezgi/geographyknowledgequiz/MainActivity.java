package com.ezgi.geographyknowledgequiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ezgi.geographyknowledgequiz.model.Quiz;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private ImageView imageViewCancel = null;
    private CardView cardViewQuestion, cardViewOptionA, cardViewOptionB, cardViewOptionC, cardViewOptionD = null;
    private TextView textViewScoreAttemted, textViewQuestion, textViewOptionA, textViewOptionB, textViewOptionC, textViewOptionD = null;

    private ArrayList<Quiz> quizArrayList = new ArrayList<>();
    private HashSet<Quiz> quizHashSet = new HashSet<>();

    private int counter = 0;
    private int currentscore = 0;
    private int questionattemted = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewCancel = findViewById(R.id.imageViewCancel);
        cardViewQuestion = findViewById(R.id.cardViewQuestion);
        cardViewOptionA = findViewById(R.id.cardViewOptionA);
        cardViewOptionB = findViewById(R.id.cardViewOptionB);
        cardViewOptionC = findViewById(R.id.cardViewOptionC);
        cardViewOptionD = findViewById(R.id.cardViewOptionD);
        textViewScoreAttemted = findViewById(R.id.textViewScoreAttemted);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        textViewOptionA = findViewById(R.id.textViewOptionA);
        textViewOptionB = findViewById(R.id.textViewOptionB);
        textViewOptionC = findViewById(R.id.textViewOptionC);
        textViewOptionD = findViewById(R.id.textViewOptionD);

        setQuestionToHashSet(quizHashSet);
        getQuestionFromArrayList();

        setCardAnimations();

        setOnClicks();

    }

    private void setCardAnimations() {
        cardViewOptionA.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //0.8 ne kadar küçüleceğini gösteriyor daha küçük yapmak için azalt daha az küçültmek için artır
                        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(cardViewOptionA,
                                "scaleX", 0.95f);
                        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(cardViewOptionA,
                                "scaleY", 0.95f);
                        //Küçülme animasyonu hızlı gelirse arttırarak yavaşlatabilirsin
                        scaleDownX.setDuration(50);
                        scaleDownY.setDuration(50);

                        //Bu kısımları değiştirme
                        AnimatorSet scaleDown = new AnimatorSet();
                        scaleDown.play(scaleDownX).with(scaleDownY);

                        scaleDown.start();

                        cardViewOptionA.setCardBackgroundColor(getResources().getColor(R.color.purple_700));

                        //spinslot();
                        break;
                    case MotionEvent.ACTION_UP:
                        disableAnimationA();
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        disableAnimationA();
                        break;
                }

                return false;

            }
        });

        cardViewOptionB.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(cardViewOptionB,
                                "scaleX", 0.95f);
                        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(cardViewOptionB,
                                "scaleY", 0.95f);
                        scaleDownX.setDuration(50);
                        scaleDownY.setDuration(50);

                        AnimatorSet scaleDown = new AnimatorSet();
                        scaleDown.play(scaleDownX).with(scaleDownY);

                        scaleDown.start();

                        cardViewOptionB.setCardBackgroundColor(getResources().getColor(R.color.purple_700));

                        break;
                    case MotionEvent.ACTION_UP:
                        disableAnimationB();
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        disableAnimationB();
                        break;
                }

                return false;

            }
        });

        cardViewOptionC.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(cardViewOptionC,
                                "scaleX", 0.95f);
                        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(cardViewOptionC,
                                "scaleY", 0.95f);
                        scaleDownX.setDuration(50);
                        scaleDownY.setDuration(50);

                        AnimatorSet scaleDown = new AnimatorSet();
                        scaleDown.play(scaleDownX).with(scaleDownY);

                        scaleDown.start();

                        cardViewOptionC.setCardBackgroundColor(getResources().getColor(R.color.purple_700));

                        break;
                    case MotionEvent.ACTION_UP:
                        disableAnimationC();
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        disableAnimationC();
                        break;
                }

                return false;

            }
        });

        cardViewOptionD.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(cardViewOptionD,
                                "scaleX", 0.95f);
                        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(cardViewOptionD,
                                "scaleY", 0.95f);
                        scaleDownX.setDuration(50);
                        scaleDownY.setDuration(50);

                        AnimatorSet scaleDown = new AnimatorSet();
                        scaleDown.play(scaleDownX).with(scaleDownY);

                        scaleDown.start();

                        cardViewOptionD.setCardBackgroundColor(getResources().getColor(R.color.purple_700));

                        break;
                    case MotionEvent.ACTION_UP:
                        disableAnimationD();
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        disableAnimationD();
                        break;
                }

                return false;

            }
        });
    }

    private void setOnClicks() {
        imageViewCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        cardViewOptionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                disableAnimationA();

                if (textViewOptionA.getText().toString().equals(quizArrayList.get(counter).getAnswer())) {
                    currentscore++;
                }

                if (counter + 1 == quizArrayList.size()) {
                    questionattemted++;
                    setQuestionAttemted();
                    showBottomSheetDialog();
                }else {
                    counter++;

                    getQuestionFromArrayList();
                    questionattemted++;
                    setQuestionAttemted();
                }

            }
        });
        cardViewOptionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                disableAnimationB();

                if (textViewOptionB.getText().toString().equals(quizArrayList.get(counter).getAnswer())) {
                    currentscore++;
                }

                if (counter + 1 == quizArrayList.size()) {
                    questionattemted++;
                    setQuestionAttemted();
                    showBottomSheetDialog();
                }else {
                    counter++;

                    questionattemted++;
                    setQuestionAttemted();
                    getQuestionFromArrayList();
                }

            }
        });
        cardViewOptionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                disableAnimationC();

                if (textViewOptionC.getText().toString().equals(quizArrayList.get(counter).getAnswer())) {
                    currentscore++;
                }

                if (counter + 1 == quizArrayList.size()) {
                    questionattemted++;
                    setQuestionAttemted();
                    showBottomSheetDialog();
                }else {
                    counter++;

                    questionattemted++;
                    setQuestionAttemted();
                    getQuestionFromArrayList();
                }

            }
        });
        cardViewOptionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                disableAnimationD();

                if (textViewOptionD.getText().toString().equals(quizArrayList.get(counter).getAnswer())) {
                    currentscore++;
                }

                if (counter + 1 == quizArrayList.size()) {
                    questionattemted++;
                    setQuestionAttemted();
                    showBottomSheetDialog();
                }else {
                    counter++;

                    questionattemted++;
                    setQuestionAttemted();
                    getQuestionFromArrayList();
                }

            }
        });
    }

    private void disableAnimationA() {
        ObjectAnimator scaleDownX2 = ObjectAnimator.ofFloat(
                cardViewOptionA, "scaleX", 1f);
        ObjectAnimator scaleDownY2 = ObjectAnimator.ofFloat(
                cardViewOptionA, "scaleY", 1f);
        scaleDownX2.setDuration(50);
        scaleDownY2.setDuration(50);

        AnimatorSet scaleDown2 = new AnimatorSet();
        scaleDown2.play(scaleDownX2).with(scaleDownY2);

        scaleDown2.start();

        cardViewOptionA.setCardBackgroundColor(getResources().getColor(R.color.purple_500));
    }

    private void disableAnimationB() {
        ObjectAnimator scaleDownX2 = ObjectAnimator.ofFloat(
                cardViewOptionB, "scaleX", 1f);
        ObjectAnimator scaleDownY2 = ObjectAnimator.ofFloat(
                cardViewOptionB, "scaleY", 1f);
        scaleDownX2.setDuration(50);
        scaleDownY2.setDuration(50);

        AnimatorSet scaleDown2 = new AnimatorSet();
        scaleDown2.play(scaleDownX2).with(scaleDownY2);

        scaleDown2.start();

        cardViewOptionB.setCardBackgroundColor(getResources().getColor(R.color.purple_500));
    }

    private void disableAnimationC() {
        ObjectAnimator scaleDownX2 = ObjectAnimator.ofFloat(
                cardViewOptionC, "scaleX", 1f);
        ObjectAnimator scaleDownY2 = ObjectAnimator.ofFloat(
                cardViewOptionC, "scaleY", 1f);
        scaleDownX2.setDuration(50);
        scaleDownY2.setDuration(50);

        AnimatorSet scaleDown2 = new AnimatorSet();
        scaleDown2.play(scaleDownX2).with(scaleDownY2);

        scaleDown2.start();

        cardViewOptionC.setCardBackgroundColor(getResources().getColor(R.color.purple_500));
    }

    private void disableAnimationD() {
        ObjectAnimator scaleDownX2 = ObjectAnimator.ofFloat(
                cardViewOptionD, "scaleX", 1f);
        ObjectAnimator scaleDownY2 = ObjectAnimator.ofFloat(
                cardViewOptionD, "scaleY", 1f);
        scaleDownX2.setDuration(50);
        scaleDownY2.setDuration(50);

        AnimatorSet scaleDown2 = new AnimatorSet();
        scaleDown2.play(scaleDownX2).with(scaleDownY2);

        scaleDown2.start();

        cardViewOptionD.setCardBackgroundColor(getResources().getColor(R.color.purple_500));
    }

    private void setQuestionToHashSet(HashSet<Quiz> quizHashSet) {
        quizHashSet.add(new Quiz("Which is the largest continent (by area)? ", "Asia ", "Antarctica ", "North America ", "Africa ", "Asia "));
        quizHashSet.add(new Quiz("Bucharest is the capital city of which country? ", "Ukraine ", "Romania ", "Belarus ", "Moldova ", "Romania "));
        quizHashSet.add(new Quiz("Of these oceans, which is the largest? ", "Indian ", "Southern ", "Atlantic ", "Arctic ", "Atlantic "));
        quizHashSet.add(new Quiz("The longest ship canal in the world is the", "St. Laurence Seaway (USA and Canada) ", "Suez canal, Egypt ", "Kiel canal, Germany ", "Panama canal, Central America ", "St. Laurence Seaway (USA and Canada) "));
        quizHashSet.add(new Quiz("The luminous coloured ring, surrounding the sun is called the ", "nebula ", "comet", "asteroid ", "corona", "corona"));
        quizHashSet.add(new Quiz("The luminous coloured ring, surrounding the sun is called the ", "novas", "comets", "meteors", "astreoids", "astreoids"));
        quizHashSet.add(new Quiz("The lowermost and the oldest epoch of the Tertiary Period of geologic time is", "Pliocene", "Palaeozoic", "Holocene", "Palaeocene", "Palaeocene"));
        quizHashSet.add(new Quiz("The most recent era of the geological time scale is", "Mesozoic", "Cenozoic", "Triassic", "paleocene", "Cenozoic"));
        quizHashSet.add(new Quiz("The low heating capacity of which of the types of coal reduces its value as an industrial fuel?", "Anthracite", "Bituminous coal", "Lignite", "Peat", "Peat"));
        quizHashSet.add(new Quiz("The longest river in the Common wealth of independent states is the", "Irtysh river", "Ob river", "Yenisei river", "Volga river", "Volga river"));
        quizArrayList.addAll(quizHashSet);

    }

    private void setQuestion2ToHashSet(HashSet<Quiz> quizHashSet) {
        quizHashSet.add(new Quiz("The planet that takes the highest time for completing a rotation is ", "Mercury", "Venus", "Earth", "Pluto", "Venus"));
        quizHashSet.add(new Quiz("The river situated along the border between the USA and Mexico is", "the Rio Grande", "the Amazon", "the Mississippi", "the Colorado", "the Rio Grande"));
        quizHashSet.add(new Quiz("The period of daylight", "is nearly constant near the equator", "varies with latitude and the season", "reaches a maximum of 24 hour in the polar zones in summer", "All of the above", "All of the above"));
        quizHashSet.add(new Quiz("The planets with no natural satellites (reported so far) are", "Mercury and Venus", "Earth and Pluto", "Mars and Neptune", "Jupiter and Saturn", "Mercury and Venus"));
        quizHashSet.add(new Quiz("The plants of which of the following crops are highly sensitive to frost?", "Barely ", "Cotton", "Maize", "None of the above", "Cotton"));
        quizHashSet.add(new Quiz("The Pyrenees mountains are located on the border between ____ and ____", "Romania, Bulgaria ", "Norway, Sweden", "Hungary, Romania", "France, Spain", "France, Spain"));
        quizHashSet.add(new Quiz("The planet with the maximum number of natural satellites (moons), so far discovered is", "Jupiter", "Neptune", "Saturn", "Uranus", "Jupiter"));
        quizHashSet.add(new Quiz("The phenomenon of an opening occurring in the earth's surface through which a jet of hot water and steam is forces out at irregular intervals is called", "crater", "geyser", "hot spring", "volcano", "geyser"));
        quizHashSet.add(new Quiz("The panama canal links", "Canada with Greenland", "North America with South America", "Siberia with Greenland", "None of the above", "North America with South America"));
        quizHashSet.add(new Quiz("The planets called the inner planets, are", "Jupiter, Saturn, Uranus, Neptune", "Mars, Jupiter, Saturn, Uranus", "Saturn, Uranus, Neptune, Pluto", "Mercury, Venus, Earth, Mars", "Mercury, Venus, Earth, Mars"));
        quizArrayList.addAll(quizHashSet);
    }

    private void getQuestionFromArrayList() {
        textViewQuestion.setText(quizArrayList.get(counter).getQuestion());
        textViewOptionA.setText(quizArrayList.get(counter).getOption1());
        textViewOptionB.setText(quizArrayList.get(counter).getOption2());
        textViewOptionC.setText(quizArrayList.get(counter).getOption3());
        textViewOptionD.setText(quizArrayList.get(counter).getOption4());
    }

    @SuppressLint("SetTextI18n")
    private void showBottomSheetDialog() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.score_bottom, null, false);

        TextView score = view.findViewById(R.id.score);
        CardView cardViewRestartQuiz = view.findViewById(R.id.cardViewRestartQuiz);
        CardView cardViewSkipQuiz = view.findViewById(R.id.cardViewSkipQuiz);
        CardView cardViewCancel = view.findViewById(R.id.cardViewCancel);
        score.setText("Your score is \n"+currentscore+" / "+quizArrayList.size());

        cardViewRestartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionattemted = 0;
                counter = 0;
                currentscore = 0;

                setQuestionAttemted();

                getQuestionFromArrayList();

                bottomSheetDialog.dismiss();
            }
        });

        cardViewSkipQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quizHashSet.clear();
                quizArrayList.clear();

                questionattemted = 0;
                counter = 0;
                currentscore = 0;

                setQuestion2ToHashSet(quizHashSet);
                setQuestionAttemted();

                getQuestionFromArrayList();

                bottomSheetDialog.dismiss();
            }
        });

        cardViewCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.show();
    }

    @SuppressLint("SetTextI18n")
    private void setQuestionAttemted() {
        textViewScoreAttemted.setText("Question Attemted: "+questionattemted+" / "+quizArrayList.size());
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("LOG OUT");
        builder.setMessage("Are you sure you want to exit the application?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}