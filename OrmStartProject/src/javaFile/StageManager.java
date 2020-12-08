package javaFile;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class StageManager extends JFrame
{
	ArrayList<String> stage = new ArrayList<String>();	//�о�� ������ ���ڿ��� ������ ����
	BufferedImage bufferImage = new BufferedImage(800, 800 + 25, BufferedImage.TYPE_INT_RGB);
	Graphics screenGraphic = bufferImage.getGraphics();
	int playerX = 0;
	int playerY = 0;
	int playerSpeed = 5;
	int playerMoveDelay = 10;
	boolean turn = true;
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	boolean firstPlayerPos=false;
	boolean clear = false;
	
	public Image clearImage = new ImageIcon("src/images/��ϻ�/clear.png").getImage();
	public Image block[] =
		{
			new ImageIcon("src/images/��ϻ�/black.png").getImage(),
			new ImageIcon("src/images/��ϻ�/white.png").getImage(),
			new ImageIcon("src/images/��ϻ�/red.png").getImage(),
			new ImageIcon("src/images/��ϻ�/blue.png").getImage(),
			new ImageIcon("src/images/��ϻ�/yellow.png").getImage(),
			new ImageIcon("src/images/��ϻ�/orange.png").getImage(),
			new ImageIcon("src/images/��ϻ�/sky.png").getImage(),
			new ImageIcon("src/images/��ϻ�/sky.png").getImage(),
			new ImageIcon("src/images/��ϻ�/up.png").getImage(),
			new ImageIcon("src/images/��ϻ�/right.png").getImage(),
			new ImageIcon("src/images/��ϻ�/left.png").getImage(),
			new ImageIcon("src/images/��ϻ�/down.png").getImage()
		};
	
	public void createFrame(String title)
	{
		setTitle(title); 			//������â ����
		setSize(800, 800 + 25);  			//�������� ũ�� ����
		setResizable(false);  				//����ڰ� ������ ũ�� ���� false
		setLocationRelativeTo(null);		//������ â�� ȭ�� ����� ������ ����
		setLayout(null);					//���̾ƿ��� ������� ������ �� �ֵ��� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���������� JFrame�� ����ǵ��� ����
		setVisible(true);
		
		System.out.println("OK");
	}
	
	public void loadStage(FileReader stageTxt) throws IOException
	{
		BufferedReader br = new BufferedReader(stageTxt);			//������ �о�� ����
		
		
		for(int y=0 ; y<16 ; y++)
		{
			stage.add(br.readLine());
		}
		//System.out.printf("check4\n");
		br.close();
	}
	
	public void paint(Graphics screenGragphic)
	{
		screenDraw(screenGragphic);
	}
	
	public void screenDraw(Graphics g) 
	{
		try {
			if (clear) {
				g.drawImage(clearImage, 0, 0, null);
				return;
			}
			for (int y = 0; y < 16; y++) {
				for (int x = 0; x < 16; x++) {
					if (stage.get(y).charAt(x) == '0') //���ڰ� 0�� ��� ������ ��� ���
					{
						g.drawImage(block[0], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == 'W') //���ڰ� W�� ��� �Ͼ�� ��� ���
					{
						g.drawImage(block[1], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == 'R') //���ڰ� R�� ��� ������ ��� ���
					{
						g.drawImage(block[2], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == 'B') //���ڰ� B�� ��� �Ķ��� ��� ���
					{
						if (!firstPlayerPos) {
							g.drawImage(block[3], 50 * x, 25 + 50 * y, null);
							playerX = 50 * x;
							playerY = 25 + 50 * y;
							firstPlayerPos = true;
						} else {
							g.drawImage(block[0], 50 * x, 25 + 50 * y, null);
						}

					} else if (stage.get(y).charAt(x) == 'Y') //���ڰ� Y�� ��� ����� ��� ���
					{
						g.drawImage(block[4], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == 'O') //���ڰ� O�� ��� ��Ȳ�� ��� ���
					{
						g.drawImage(block[5], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == 'S') //���ڰ� S�� ��� �ϴû� ��� ���
					{
						g.drawImage(block[6], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == 'P') //���ڰ� P�� ��� ��ȫ�� ��� ���
					{
						g.drawImage(block[7], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == '8') //���ڰ� 8�� ��� ���� ��� ���
					{
						g.drawImage(block[8], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == '6') //���ڰ� 6�� ��� ������ ��� ���
					{
						g.drawImage(block[9], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == '4') //���ڰ� 4�� ��� ���� ��� ���
					{
						g.drawImage(block[10], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == '2') //���ڰ� 2�� ��� �Ʒ��� ��� ���
					{
						g.drawImage(block[11], 50 * x, 25 + 50 * y, null);
					}
				}
			}
			g.drawImage(block[3], playerX, playerY, null);
			//System.out.printf("playerPos : %d %d\n", playerX, playerY);
		} catch (NullPointerException npe) {
			System.out.println("null �����ϱ�");
		}
	}
	
	public void playerCtrl()
	{
		addKeyListener(new KeyAdapter() 	//�Է� �Ǵ�
		{
			public void keyPressed(KeyEvent e) 
			{
				if(turn == true) 			//�� �������θ� �̵� ( �浹 �ÿ�  turn�� true�� �ٲ������)
				{ 
					switch(e.getKeyCode()) 
					{
					case KeyEvent.VK_W:
						up = true;		
						turn = false;
						break;
					case KeyEvent.VK_S:
						down = true;
						turn = false;
						break;
					case KeyEvent.VK_A:
						left = true;
						turn = false;
						break;
					case KeyEvent.VK_D:
						right = true;
						turn = false;
						break;
					}
				}
			}
		});
		
		while(true)
		{
			try
			{
				Thread.sleep(playerMoveDelay);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			judgeCrash();
			if(up)	playerY -= playerSpeed;
			else if(down)	playerY += playerSpeed;
			else if(left)	playerX -= playerSpeed;
			else if(right)	playerX += playerSpeed;
			super.repaint();
			//System.out.printf("%d %d\n", playerX, playerY);
		}
	}
	
	public void judgeCrash()
	{
		int judgeBlockX = playerX;
		int judgeBlockY = playerY;
		char judgeBlock = '\0';
		boolean crash = false;
		if(up)	judgeBlockY -= playerSpeed - 1;
		else if(down)	judgeBlockY += playerSpeed + 50 - 1;
		else if(left)	judgeBlockX -= playerSpeed - 1;
		else if(right)	judgeBlockX += playerSpeed + 50 - 1;
		
		if(judgeBlockX<0 || judgeBlockX > 775)	crash = true;
		if(judgeBlockY<25 || judgeBlockY > 800)	crash = true;
		
		if(!crash)
		{
			judgeBlock = stage.get((judgeBlockY-25)/50).charAt(judgeBlockX/50);
			//System.out.printf("playerPos : %d %d\n", playerX, playerY);
			//System.out.printf("judgeBlockPos : %d %d\n",judgeBlockX, judgeBlockY);
			//System.out.printf("judgeBlock : %c\n",judgeBlock);
			if(judgeBlock!='0' && judgeBlock != 'B')	crash = true;
			if(judgeBlock == 'Y')
			{
				System.out.printf("clear!\n");
				clear = true;
				super.repaint();
				//System.exit(0);
			}
		}
		if(crash)
		{
			up = false;
			down = false;
			left = false;
			right = false;
			turn = true;
		}
		
		return;
	}
	
	public void stageStart(String title, String stageTxt) throws IOException
	{
		StageManager stageManager = new StageManager();
		
		System.out.printf("check3\n");
		stageManager.createFrame(title);
		stageManager.loadStage(new FileReader(stageTxt));
		System.out.printf("check4\n");
		paint(screenGraphic);
		System.out.printf("check5\n");
		stageManager.playerCtrl();
	}
	
}


