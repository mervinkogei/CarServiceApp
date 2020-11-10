package com.bgstuffs.pabapp;

import android.app.Fragment;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Notifications extends Fragment {

    Button b_rock,b_scissor,b_paper;
    TextView tv_Score;
    ImageView iv_ComputerChoice, iv_HumanChoice;

    int HumanScore, ComputerScore = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_notifications,container,false);
//
//        b_rock = view.findViewById(R.id.bRock);
//        b_paper = view.findViewById(R.id.bPaper);
//        b_scissor = view.findViewById(R.id.bScissor);
//
//        tv_Score = view.findViewById(R.id.tvScore);

//        iv_ComputerChoice = view.findViewById(R.id.ivComputer);
//        iv_HumanChoice = view.findViewById(R.id.ivCurrent);

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.stone);
                String message = play_turn("Major Service");
                Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
                tv_Score.setText("Performance: Engine-> "+ Integer.toString(HumanScore)+" Brake-> "+Integer.toString(ComputerScore));
            }
        });

        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.paper);
                String message = play_turn("Minor Service");
                Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
                tv_Score.setText("Perfomance: Alignment-> "+ Integer.toString(HumanScore)+" Painting-> "+Integer.toString(ComputerScore));
            }
        });

        b_scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.scissor);
                String message = play_turn("Other Services");
                Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
                tv_Score.setText("Perfomance: Wheeling-> "+ Integer.toString(HumanScore)+" Wiring-> "+Integer.toString(ComputerScore));
            }
        });

        return view;
    }

    public String play_turn(String player_choice){
        String comp_choice = "";
        Random r = new Random();

        // choose 1 2 or 3
        int comp_number = r.nextInt(3)+1;

        if (comp_number == 1){
            comp_choice = "Major Service";
        }
        else if (comp_number == 2){
            comp_choice = "Minor Service";
        }
        else if (comp_number == 3){
            comp_choice = "Other Service";
        }
        // set the computer image based on the choice
        if (comp_choice == "Major Service"){
            iv_ComputerChoice.setImageResource(R.drawable.stone);
        }
        else if (comp_choice == "Minor Service"){
            iv_ComputerChoice.setImageResource(R.drawable.paper);
        }
        else if (comp_choice == "Other Service"){
            iv_ComputerChoice.setImageResource(R.drawable.scissor);
        }

        // to determine who will win
        if (comp_choice == player_choice){
            return "Attendance: Nobody attended to your car.";
        }
        else if (player_choice == "Major Service" && comp_choice == "Minor Service"){
            HumanScore++;
            return "Major Service is Done. You can go for Road Test!";
        }
        else if (player_choice == "Major Service" && comp_choice == "Other Service"){
            ComputerScore++;
            return "Other Service Service is Done. You can go for Road Test!";
        }
        else if (player_choice == "Other Service" && comp_choice == "Major Service"){
            ComputerScore++;
            return "Major Service is Done. You can go for Road Test!";
        }
        else if (player_choice == "Minor Service" && comp_choice == "Other Service"){
            HumanScore++;
            return "Major Service is Done. You can go for Road Test!";
        }
        else if (player_choice == "Minor Service" && comp_choice == "Major Service"){
            HumanScore++;
            return "Major Service is Done. You can go for Road Test!";
        }
        else if (player_choice == "Minor Service" && comp_choice == "Other Service"){
            ComputerScore++;
            return "Major Service is Done. You can go for Road Test!";
        }
        else
            return "Not Sure, Please Wait";

    }

}
