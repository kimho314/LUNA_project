package role_game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dynamic_array.ObjectList;

public class RoleCanvas extends Canvas implements MouseListener, KeyListener {
	
	private Kid kid;
	private Background bg;
	//private Missile[] missiles;
	//private ObjectList missiles;
	private List<Missile> missiles;
	private int cnt;
	private Set<Integer> pressed;
	
	public RoleCanvas() {
		
		addMouseListener(this);
		addKeyListener(this);
		
		pressed = new HashSet<Integer>();
		
		cnt = 0;
		kid = new Kid();
		bg = new Background();
		//missiles = new Missile[100];
		missiles = new ArrayList<>();
		//missiles = new ObjectList();
		
		
		new Thread(() -> {

			while (true) {
				try {
					bg.update();
					kid.update();
					
//					for (int i = 0; i < missiles.length; i++) {
//						if (missiles[i] != null)
//							missiles[i].update();
//					}	
					
					for(Missile obj : missiles)
					{
						obj.update();
					}
					
//					for(int i=0; i<missiles.size(); i++)
//					{
//						((Missile)missiles.get(i)).update();
//					}
					
					Thread.sleep(17);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				repaint();
			}

		}).start();
		
		
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	@Override
	public void paint(Graphics g) {
		
		Image bufImage = createImage(this.getWidth(), this.getHeight());
		Graphics g2 = bufImage.getGraphics();
		bg.draw(g2, this);
		kid.draw(g2, this);
		
//		for (int i = 0; i < missiles.length; i++) {
//			if (missiles[i] != null)
//				missiles[i].draw(g2, this);
//		}
		
		for(Missile obj : missiles)
		{
			obj.draw(g2,this);
		}
		
//		for(int i=0; i<missiles.size(); i++)
//		{
//			((Missile)missiles.get(i)).draw(g2,this);
//		}
		
		g.drawImage(bufImage, 0, 0, this);
	}
	
	@Override
	public synchronized void keyPressed(KeyEvent e) {

		pressed.add(e.getKeyCode());

		if (pressed.size() > 1) {

			for (Integer obj : pressed) {
				switch (obj.intValue()) {
				case KeyEvent.VK_LEFT:
					kid.move(Direction.LEFT);
					break;

				case KeyEvent.VK_RIGHT:
					kid.move(Direction.RIGHT);
					break;

				case KeyEvent.VK_UP:
					kid.move(Direction.UP);
					break;

				case KeyEvent.VK_DOWN:
					kid.move(Direction.DOWN);
					break;

				case KeyEvent.VK_SPACE:
//					missiles[cnt] = kid.fire();
//					cnt++;
//					if(cnt >= missiles.length)
//						cnt = 0;
					Missile m = kid.fire();
					if (m != null) {
						missiles.add(m);
					}
					break;
				}
			}
		}
	}

	@Override
	public synchronized void keyReleased(KeyEvent e) {
		//pressed.remove(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
