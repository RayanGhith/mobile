package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class playActivity extends AppCompatActivity {
    String[] question_list = {"Qu'est-ce que l'apprentissage supervisé?",
            "Quel algorithme d'apprentissage non supervisé est souvent utilisé pour la réduction de dimensionnalité?",
            "Quel type d'apprentissage est utilisé pour les chatbots qui apprennent de manière incrémentielle à partir des interactions avec les utilisateurs?",
            "Quel est le rôle principal des algorithmes de renforcement en intelligence artificielle?",
            "Qu'est-ce que le clustering dans le contexte de l'apprentissage non supervisé ?"
    };
    String[] choose_list = {"Un modèle apprend sans supervision","Un modèle apprend avec un ensemble de données étiquetées","Un modèle apprend en utilisant des renforcements","Aucune des réponses ci-dessus",
            "K-Means","Réseaux de neurones","Analyse en composantes principales (ACP)","Forêts aléatoires",
            "supervisé","non supervisé","par renforcement","semi-supervisé",
            "Classification","Prédiction","Optimisation basée sur la récompense","Regroupement",
            "Assigner des étiquettes prédéfinies à des données d'entrée","Regrouper des données similaires sans étiquettes prédéfinies","Comparer des modèles pour sélectionner le meilleur","Appliquer des renforcements pour améliorer la précision d'un modèle"
    };
    String[] correct_list = {"Un modèle apprend avec un ensemble de données étiquetées","Analyse en composantes principales (ACP)","par renforcement","Optimisation basée sur la récompense","Regrouper des données similaires sans étiquettes prédéfinies"};



    TextView cpt_question , text_question;
    Button btn_choose1 , btn_choose2 , btn_choose3 , btn_choose4 , btn_next;


    int currentQuestion =  0  ;
    int scorePlayer =  0  ;
    boolean isclickBtn = false;
    String valueChoose = "";
    Button btn_click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        cpt_question = findViewById(R.id.cpt_question);
        text_question = findViewById(R.id.text_question);

        btn_choose1 = findViewById(R.id.btn_choose1);
        btn_choose2 = findViewById(R.id.btn_choose2);
        btn_choose3 = findViewById(R.id.btn_choose3);
        btn_choose4 = findViewById(R.id.btn_choose4);
        btn_next = findViewById(R.id.btn_next);

        findViewById(R.id.image_back).setOnClickListener(
                a-> finish()
        );
        remplirData();
        btn_next.setOnClickListener(
                view -> {
                        if (isclickBtn){
                            isclickBtn = false;

                            if(!valueChoose.equals(correct_list[currentQuestion])){
                                Toast.makeText(playActivity.this , "erreur",Toast.LENGTH_LONG).show();
                                btn_click.setBackgroundResource(R.drawable.background_btn_erreur);

                            }else {
                                Toast.makeText(playActivity.this , "correct",Toast.LENGTH_LONG).show();
                                btn_click.setBackgroundResource(R.drawable.background_btn_correct);

                                scorePlayer++;
                            }
                            new Handler().postDelayed(() -> {
                                if(currentQuestion!=question_list.length-1){
                                    currentQuestion = currentQuestion + 1;
                                    remplirData();
                                    valueChoose = "";
                                    btn_choose1.setBackgroundResource(R.drawable.background_btn_choose);
                                    btn_choose2.setBackgroundResource(R.drawable.background_btn_choose);
                                    btn_choose3.setBackgroundResource(R.drawable.background_btn_choose);
                                    btn_choose4.setBackgroundResource(R.drawable.background_btn_choose);

                                }else {
                                    Intent intent  = new Intent(playActivity.this , ResulteActivity.class);
                                    intent.putExtra("Resute" , scorePlayer);
                                    startActivity(intent);
                                    finish();
                                }

                            },2000);

                        }else {
                            Toast.makeText(playActivity.this ,  "Vous devez en choisir un",Toast.LENGTH_LONG).show();
                        }
                }
        );


    }

    void remplirData(){
        cpt_question.setText((currentQuestion+1) + "/" + question_list.length);
        text_question.setText(question_list[currentQuestion]);

        btn_choose1.setText(choose_list[4 * currentQuestion]);
        btn_choose2.setText(choose_list[4 * currentQuestion+1]);
        btn_choose3.setText(choose_list[4 * currentQuestion+2]);
        btn_choose4.setText(choose_list[4 * currentQuestion+3]);

    }

    public void ClickChoose(View view) {
        btn_click = (Button)view;

        if (isclickBtn) {
            btn_choose1.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose2.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose3.setBackgroundResource(R.drawable.background_btn_choose);
            btn_choose4.setBackgroundResource(R.drawable.background_btn_choose);
        }
        chooseBtn();


    }
    void chooseBtn(){

        btn_click.setBackgroundResource(R.drawable.background_btn_choose_color);
        isclickBtn = true;
        valueChoose = btn_click.getText().toString();
    }
}