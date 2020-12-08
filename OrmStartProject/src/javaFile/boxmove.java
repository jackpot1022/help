package javaFile;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class boxmove extends JFrame{
	private Image player = new ImageIcon("src/images/player.png").getImage();
	private Image Nblock = new ImageIcon("src/images/Nblock.png").getImage();
	private Image bufferImage;
	private Graphics screenGraphic;
	private int playerX, playerY;
	private int NblockX, NblockY;
	private int NblockWidth = Nblock.getWidth(null);
	private int NblockHeight = Nblock.getHeight(null);
	private int playerWidth = player.getWidth(null);
	private int playerHeight = player.getHeight(null);

//public class boxmove extends InIt{
	public int CPX , CPY;
	public int mT = 0;
	private boolean up, down, left, right;
	public boolean turn = true; //나중에 특수블록을 위한 변수
	//private Image background
	public boxmove() {
		setTitle("박스게임");
		setVisible(true);
		setSize(800,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new KeyAdapter() {
			//입력 판단
			public void keyPressed(KeyEvent e) {
				if(turn == true) { //한 방향으로만 이동 ( 충돌 시에  turn을 true로 바꿔줘야함)
					switch(e.getKeyCode()) {
					case KeyEvent.VK_W:
						up = true;		
						mT = 0;
						turn = false;
						break;
					case KeyEvent.VK_S:
						down = true;
						mT =0;
						turn = false;
						break;
					case KeyEvent.VK_A:
						left = true;
						mT = 0;
						turn = false;
						break;
					case KeyEvent.VK_D:
						right = true;
						mT =0;
						turn = false;
						break;
					}
			}
		}


		});
		Init();
		while(true) {
			try {
				Thread.sleep(20);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			keyProcess();	
			
			crash();

			}
	}
	
	
	
	
	public void crash() {
		if(playerX +playerWidth > NblockX && NblockX + NblockWidth > playerX && playerY + playerHeight > NblockY && NblockY + NblockHeight > playerY) {
			mT = 1;
			turn = true;
			CPX = playerX;
			CPY = playerY;
			// 충돌시에 플레이어와 블록 사이의 거리가 너무 가까워서 계속 충돌 판정이 일어남
			// 그래서 충돌 시 어느 정도 거리를 띄어줘야할듯함 (아래는 그 코드임)
	//		if(up == true) {
	//			playerY = CPY +5;
	//		}
	//		if(down == true) {
	//			playerY = CPY - 5;
	//		}
	//		if(left == true){
	//			playerX = CPX -5;
	//		}
	//		if(right == true){
	//			playerX = CPX + 5;
	//		}
		}
		}
	
	//위치 메서드
	public void Init() {
		playerX = (800 - playerWidth)/2;
		playerY = (800 - playerHeight)/2;
		NblockX = (800 - NblockWidth)/2;
		NblockY = (800 - NblockHeight)/3;
		
	}
	//이동 폭
	public void keyProcess() {
		if(mT == 0) {
			if(up == true) {
				playerY-=10;
				mT = 0;
		
			}
			
			if(down == true) {
				playerY+=10;
				mT = 0;
			
			}
			if(left == true) {
				playerX-=10;	
				mT = 0;
			}
			
			if(right == true) {
				playerX+=10;
				mT = 0;
			}
		}
	}
	//깜빡임 방지
	public void paint(Graphics g) {
	 bufferImage = createImage(800,800);
	 screenGraphic = bufferImage.getGraphics();
	 screenDraw(screenGraphic);
	 g.drawImage(bufferImage, 0,  0, null);
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(player, playerX, playerY, null);
		g.drawImage(Nblock, NblockX, NblockY, null);
		this.repaint();
		
	}
	public static void main(String[] args) {
		new boxmove();

	}

}
