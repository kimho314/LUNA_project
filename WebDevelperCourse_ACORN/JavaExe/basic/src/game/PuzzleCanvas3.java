package game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

public class PuzzleCanvas3 extends Canvas{
	//private int[] pos = new int[9];
	private int[] pos = {0,1,2,3,4,5,6,7,8};
	private Puzzle2[] puzzles;
	//Puzzle2 puzzle;
	
	public PuzzleCanvas3()
	{
		puzzles = new Puzzle2[9];
	
		
		for(int i=0; i<pos.length; i++)
			pos[i] = i;
		
		Random rand = new Random();
		int p1 = 0;
		int p2 = 0;
		for (int i = 0; i < 10; i++) {
			p1 = rand.nextInt(9);
			p2 = rand.nextInt(9);
			if(p1 == p2)
				continue;

			int temp;
			temp = pos[p1];
			pos[p1] = pos[p2];
			pos[p2] = temp;
			
//			System.out.printf("p1 : %d, p2 : %d\n", p1, p2);
//			for(int cnt=0; cnt<9; cnt++)
//				System.out.printf("[%d] ", pos[cnt]);
//			System.out.println("");
			
		}
		
//		for(int i=0; i<9; i++)
//		{
//			puzzle = new Puzzle2();
//			puzzle.setPos(i);			
//			puzzle.setSrc(pos[i]);
//			
//			puzzles[i] = puzzle;
//		}
	}
	
	@Override
	public void paint(Graphics g) {
		
		
		for(int i=0; i<pos.length; i++)
		{
			Puzzle2 puzzle = new Puzzle2();
			puzzle.setPos(i);			
			puzzle.setSrc(pos[i]);
			
			puzzle.draw(g, this);
		}
	}
}
