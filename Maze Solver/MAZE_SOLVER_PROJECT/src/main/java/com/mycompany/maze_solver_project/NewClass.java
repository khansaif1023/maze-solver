/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver_project;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author saif1
 */
public class NewClass extends JFrame {

        private int[][] maze=
    {   {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    public List<Integer> path=new ArrayList<>();
    
    public NewClass(){
        setTitle("Maze Solver");
        setSize(640,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DepthFirst.searchpath(maze,1,1,path);
    }

    /**
     *
     * @param g
     * @param 
     */
    @Override
     public void paint(Graphics g){
       g.translate(100, 100);
       for(int i=0;i<maze.length;i++){
           for(int j=0;j<maze[0].length;j++){
               Color color;
               switch(maze[i][j]){
               case 1: color=Color.BLACK;break;
               case 9: color=Color.RED;break;
               default: color=Color.WHITE;break;
           }
             g.setColor(color);
             g.fillRect(j*30,i*30,30,30);
             g.setColor(color.RED);
             g.drawRect(j*30,i*30,30,30);
          
           }
       }
       for(int i=0;i<path.size();i+=2){
           int pathx=path.get(i);
           int pathy=path.get(i+1);
           System.out.println("X Coordinate"+pathx);
           System.out.println("Y Coordinate"+pathy);
           g.setColor(color.GREEN);
           g.fillRect(20*pathx,20*pathy,20,20);
       }
     }
     public static void main(String[] args){
         NewClass view=new NewClass();
         view.setVisible(true);
     } 
}
