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
	public boolean turn = true; //���߿� Ư������� ���� ����
	//private Image background
	public boxmove() {
		setTitle("�ڽ�����");
		setVisible(true);
		setSize(800,800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new KeyAdapter() {
			//�Է� �Ǵ�
			public void keyPressed(KeyEvent e) {
				if(turn == true) { //�� �������θ� �̵� ( �浹 �ÿ�  turn�� true�� �ٲ������)
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
			// �浹�ÿ� �÷��̾�� ��� ������ �Ÿ��� �ʹ� ������� ��� �浹 ������ �Ͼ
			// �׷��� �浹 �� ��� ���� �Ÿ��� �������ҵ��� (�Ʒ��� �� �ڵ���)
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
	
	//��ġ �޼���
	public void Init() {
		playerX = (800 - playerWidth)/2;
		playerY = (800 - playerHeight)/2;
		NblockX = (800 - NblockWidth)/2;
		NblockY = (800 - NblockHeight)/3;
		
	}
	//�̵� ��
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
	//������ ����
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
