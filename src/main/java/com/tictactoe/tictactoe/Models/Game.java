/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tictactoe.tictactoe.Models;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author ashraf
 */
public class Game {
    public Player xPlayer;
    public Player oPlayer;
    private GameMode mode;
    private Moves lastMove = null;
    private int movesCount = 0;
    public Moves[][] board;
	public Game(Player p1) {
		p1.move = Moves.X;
		xPlayer = p1;
		oPlayer = new AIPlayer(DifficultyLevel.EASY,Moves.O);
		initBoard();
	}

	public Game(Player p1, Player p2) {
		p1.move = Moves.X;
		p2.move = Moves.O;

		xPlayer = p1;
		oPlayer = p2;
		initBoard();
	}

	private void initBoard() {
		board = new Moves[3][3];
		for (Moves[] row : board)
			Arrays.fill(row, Moves.EMPTY);
	}

    public Moves checkWin() {
        for (WinAxis axis : WinAxis.winAxisList)
        {
            if (board[axis.firstPoint.x][axis.firstPoint.y] == board[axis.secondPoint.x][axis.secondPoint.y]
                    && board[axis.secondPoint.x][axis.secondPoint.y] == board[axis.thirdPoint.x][axis.thirdPoint.y]
                    && board[axis.firstPoint.x][axis.firstPoint.y] != Moves.EMPTY)
            {
               return board[axis.firstPoint.x][axis.firstPoint.y];
            }
        }
        return Moves.EMPTY;
    }

    public WinAxis getWinAxis() {
        for (WinAxis axis : WinAxis.winAxisList)
        {
            if (board[axis.firstPoint.x][axis.firstPoint.y] == board[axis.secondPoint.x][axis.secondPoint.y]
                    && board[axis.secondPoint.x][axis.secondPoint.y] == board[axis.thirdPoint.x][axis.thirdPoint.y]
                    && board[axis.firstPoint.x][axis.firstPoint.y] != Moves.EMPTY)
            {
               return axis;
            }
        }
        return null;
    }

    public void play(int x, int y) {
        if(movesCount >= 9 || board[x][y] != Moves.EMPTY) return;
        if(lastMove == xPlayer.move){
            board[x][y] = oPlayer.move;
            lastMove = Moves.O;
        }else{
            board[x][y] = xPlayer.move;
            lastMove = Moves.X;
        }
        movesCount++;
    }

    public void easyMove() {
        Random r = new Random();
        int randx = r.nextInt(3);
        int randy = r.nextInt(3);

        while (true)
        {
            if (board[randx][randy] == Moves.EMPTY)
            {
                board[randx][randy] = Moves.O;
                break;
            }
            randx = r.nextInt(3);
            randy = r.nextInt(3);
        }

    }
}
