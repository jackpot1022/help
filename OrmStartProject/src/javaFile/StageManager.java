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
	ArrayList<String> stage = new ArrayList<String>();	//읽어온 파일의 문자열을 저장할 변수
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
	
	public Image clearImage = new ImageIcon("src/images/블록색/clear.png").getImage();
	public Image block[] =
		{
			new ImageIcon("src/images/블록색/black.png").getImage(),
			new ImageIcon("src/images/블록색/white.png").getImage(),
			new ImageIcon("src/images/블록색/red.png").getImage(),
			new ImageIcon("src/images/블록색/blue.png").getImage(),
			new ImageIcon("src/images/블록색/yellow.png").getImage(),
			new ImageIcon("src/images/블록색/orange.png").getImage(),
			new ImageIcon("src/images/블록색/sky.png").getImage(),
			new ImageIcon("src/images/블록색/sky.png").getImage(),
			new ImageIcon("src/images/블록색/up.png").getImage(),
			new ImageIcon("src/images/블록색/right.png").getImage(),
			new ImageIcon("src/images/블록색/left.png").getImage(),
			new ImageIcon("src/images/블록색/down.png").getImage()
		};
	
	public void createFrame(String title)
	{
		setTitle(title); 			//윈도우창 제목
		setSize(800, 800 + 25);  			//프레임의 크기 설정
		setResizable(false);  				//사용자가 프레임 크기 조정 false
		setLocationRelativeTo(null);		//윈도우 창이 화면 가운데로 오도록 설정
		setLayout(null);					//레이아웃을 내맘대로 설정할 수 있도록 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//정상적으로 JFrame이 종료되도록 설정
		setVisible(true);
		
		System.out.println("OK");
	}
	
	public void loadStage(FileReader stageTxt) throws IOException
	{
		BufferedReader br = new BufferedReader(stageTxt);			//파일을 읽어올 변수
		
		
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
					if (stage.get(y).charAt(x) == '0') //글자가 0일 경우 검은색 블록 출력
					{
						g.drawImage(block[0], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == 'W') //글자가 W일 경우 하얀색 블록 출력
					{
						g.drawImage(block[1], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == 'R') //글자가 R일 경우 빨간색 블록 출력
					{
						g.drawImage(block[2], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == 'B') //글자가 B일 경우 파란색 블록 출력
					{
						if (!firstPlayerPos) {
							g.drawImage(block[3], 50 * x, 25 + 50 * y, null);
							playerX = 50 * x;
							playerY = 25 + 50 * y;
							firstPlayerPos = true;
						} else {
							g.drawImage(block[0], 50 * x, 25 + 50 * y, null);
						}

					} else if (stage.get(y).charAt(x) == 'Y') //글자가 Y일 경우 노란색 블록 출력
					{
						g.drawImage(block[4], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == 'O') //글자가 O일 경우 주황색 블록 출력
					{
						g.drawImage(block[5], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == 'S') //글자가 S일 경우 하늘색 블록 출력
					{
						g.drawImage(block[6], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == 'P') //글자가 P일 경우 분홍색 블록 출력
					{
						g.drawImage(block[7], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == '8') //글자가 8일 경우 위쪽 블록 출력
					{
						g.drawImage(block[8], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == '6') //글자가 6일 경우 오른색 블록 출력
					{
						g.drawImage(block[9], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == '4') //글자가 4일 경우 왼쪽 블록 출력
					{
						g.drawImage(block[10], 50 * x, 25 + 50 * y, null);
					} else if (stage.get(y).charAt(x) == '2') //글자가 2일 경우 아래색 블록 출력
					{
						g.drawImage(block[11], 50 * x, 25 + 50 * y, null);
					}
				}
			}
			g.drawImage(block[3], playerX, playerY, null);
			//System.out.printf("playerPos : %d %d\n", playerX, playerY);
		} catch (NullPointerException npe) {
			System.out.println("null 무시하기");
		}
	}
	
	public void playerCtrl()
	{
		addKeyListener(new KeyAdapter() 	//입력 판단
		{
			public void keyPressed(KeyEvent e) 
			{
				if(turn == true) 			//한 방향으로만 이동 ( 충돌 시에  turn을 true로 바꿔줘야함)
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


