/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tictactoe.tictactoe.Models;

import java.util.Random;

/**
 *
 * @author ashra
 */
public class AIPlayer extends Player {

    private static String botNames[] = {"Mike","Evobot","Buffybot","Marvin","Bender","Bingo","Aprilbot","Avril"};
    DifficultyLevel level;
    Random ra = new Random();
    public AIPlayer(DifficultyLevel diffLevel,Moves _move) {
        super(null,_move);
        super.username = botNames[ra.nextInt(8)];
        level = diffLevel;
    }

}
