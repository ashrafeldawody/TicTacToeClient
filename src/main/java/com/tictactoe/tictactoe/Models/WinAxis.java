/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tictactoe.tictactoe.Models;

import java.util.ArrayList;

/**
 *
 * @author ashra
 */
public class WinAxis {

    public Point firstPoint;
    public Point secondPoint;
    public Point thirdPoint;
    public final static ArrayList<WinAxis> winAxisList;

    public WinAxis(Point x, Point y, Point z) {
        firstPoint = x;
        secondPoint = y;
        thirdPoint = z;
    }

    static
    {
        winAxisList = new ArrayList<>();
        winAxisList.add(new WinAxis(new Point(0, 0), new Point(0, 1), new Point(0, 2)));
        winAxisList.add(new WinAxis(new Point(1, 0), new Point(1, 1), new Point(1, 2)));
        winAxisList.add(new WinAxis(new Point(2, 0), new Point(2, 1), new Point(2, 2)));

        winAxisList.add(new WinAxis(new Point(0, 0), new Point(1, 0), new Point(2, 0)));
        winAxisList.add(new WinAxis(new Point(0, 1), new Point(1, 1), new Point(2, 1)));
        winAxisList.add(new WinAxis(new Point(0, 2), new Point(1, 2), new Point(2, 2)));

        winAxisList.add(new WinAxis(new Point(0, 0), new Point(1, 1), new Point(2, 2)));
        winAxisList.add(new WinAxis(new Point(2, 0), new Point(1, 1), new Point(0, 2)));
    }
}
