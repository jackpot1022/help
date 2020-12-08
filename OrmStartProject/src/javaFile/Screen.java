package javaFile;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.imageio.ImageIO;




public class Screen extends JFrame
{
	Image img;
	StageManager stagemanager = new StageManager();
	//난이도 선택화면 출력
		public void openSelectScreen()
		{
			JFrame selectFrame = new JFrame("Prototype");
		    JPanel panel2 = new JPanel();
			
			JButton buttonL1 = new JButton("Level 1");
			JButton buttonL2 = new JButton("Level 2");
			JButton buttonL3 = new JButton("Level 3");
			JButton buttonL4 = new JButton("Level 4");
			JButton buttonL5 = new JButton("Level 5");
			JButton buttonL6 = new JButton("Level 6");
			JButton buttonL7 = new JButton("Level 7");
			JButton buttonL8 = new JButton("Level 8");
			//Button buttonL9 = new Button("Level 9");
			//Button buttonL10 = new Button("Level 10");
			
			panel2.add(buttonL1);
			panel2.add(buttonL2);
			panel2.add(buttonL3);
			panel2.add(buttonL4);
			panel2.add(buttonL5);
			panel2.add(buttonL6);
			panel2.add(buttonL7);
			panel2.add(buttonL8);
			selectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//panel2.add(buttonL9);
			//panel2.add(buttonL10);
			
			buttonL1.addActionListener(new ActionListener() {
				
				@override
				public void actionPerformed (ActionEvent e)  {
					selectFrame.dispose();
					openL1Screen(); 
					
				}
			}) ; 
			
			buttonL2.addActionListener(new ActionListener() {
				
				@override
				public void actionPerformed (ActionEvent e) {
					selectFrame.dispose();
					openL2Screen(); 
					
				}
			});
			buttonL3.addActionListener(new ActionListener() {
				
				@override
				public void actionPerformed (ActionEvent e) {
					selectFrame.dispose();
					openL3Screen(); 
					
				}
			});
			buttonL4.addActionListener(new ActionListener() {
				
				@override
				public void actionPerformed (ActionEvent e) {
					selectFrame.dispose();
					openL4Screen(); 
					
				}
			});
			buttonL5.addActionListener(new ActionListener() {
				
				@override
				public void actionPerformed (ActionEvent e) {
					selectFrame.dispose();
					openL5Screen(); 
					
				}
			});
			buttonL6.addActionListener(new ActionListener() {
				
				@override
				public void actionPerformed (ActionEvent e) {
					selectFrame.dispose();
					openL6Screen(); 
					
				}
			});
			buttonL7.addActionListener(new ActionListener() {
				
				@override
				public void actionPerformed (ActionEvent e) {
					selectFrame.dispose();
					openL7Screen(); 
					
				}
			}); 
			buttonL8.addActionListener(new ActionListener()  {
				
				@override
				public void actionPerformed (ActionEvent e) {
					selectFrame.dispose();
					openL8Screen(); 
					
				}
			});
			/*buttonL9.addActionListener(new ActionListener() {
				
				@override
				public void actionPerformed (ActionEvent e) {
					selectFrame.setVisible(false);
					openL9Screen(); 
					
				}
			});
			buttonL10.addActionListener(new ActionListener() {
				
				@override
				public void actionPerformed (ActionEvent e) {
					selectFrame.setVisible(false);
					openL10Screen(); 
					
				}
			});*/
			
			selectFrame.add(panel2);
			
			selectFrame.setVisible(true);
			selectFrame.setSize(800, 825);
		}
		
		// Level 1
		public void openL1Screen() 
		{
			try
			{
			stagemanager.stageStart("Stage 1", "src/stage/stage1.txt");
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		// Level 2
		public void openL2Screen() 
		{
			try
			{
			stagemanager.stageStart("Stage 2", "src/stage/stage2.txt");
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}		}

		// Level 3
		public void openL3Screen() 
		{
			try
			{
			stagemanager.stageStart("Stage 3", "src/stage/stage3.txt");
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}		} 
		// Level 4
	    public void openL4Screen() 
		{ 
	    	try
			{
			stagemanager.stageStart("Stage 4", "src/stage/stage4.txt");
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		// Level 5
		public void openL5Screen() 
		{
			try
			{
			stagemanager.stageStart("Stage 5", "src/stage/stage5.txt");
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		// Level 6
		public void openL6Screen()
		{
			try
			{
			stagemanager.stageStart("Stage 6", "src/stage/stage6.txt");
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		// Level 7
		public void openL7Screen() 
		{
			try
			{
			stagemanager.stageStart("Stage 7", "src/stage/stage7.txt");
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		// Level 8
		public void openL8Screen() 
		{
			try
			{
			stagemanager.stageStart("Stage 8", "src/stage/stage8.txt");
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		/*// Level 9
		public void openL9Screen() throws IOException
		{ 
			createFrame("Stage 9");
		}
		// Level 10
		public void openL10Screen() throws IOException
		{
			createFrame("Stage 10");
		}*/
		
	// HOW TO 화면 출력
	public void openHowToScreen1() // 앞화면
	{
		
		JFrame frame = new JFrame("Prototype-HowTo");
		frame.setSize(1000, 1000);
		
		JPanel panel = new JPanel(); // 보조패널을 넣을 메인패널
		
		JPanel subPanel = new JPanel(); // 버튼 넣을 보조패널
		
		JButton button_next = new JButton("next"); // 다음 화면으로 가는 버튼
		JButton button_main = new JButton("main"); // 메인 화면으로 가는 버튼
		
		File image1 = new File("src/images/howto1.png"); // 1째 이미지 선언
		
		BufferedImage howToimage1 = null;               // 파일을 이미지로 전환
		try {
			howToimage1 = ImageIO.read(image1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel image = new JLabel(new ImageIcon(howToimage1));

		BorderLayout fl = new BorderLayout();
		panel.setLayout(fl);
		
		subPanel.add(button_next);  //버튼을 서브패널에 추가
		subPanel.add(button_main);
		
		ActionListener listener_next = new ActionListener() {
			
			@override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				openHowToScreen2();
			}
		};
		
		ActionListener listener_main = new ActionListener() {
			
			@override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				openStartScreen();
			}
		};
		button_next.addActionListener(listener_next);
		button_main.addActionListener(listener_main);
		panel.add(image, BorderLayout.CENTER);
		panel.add(subPanel, BorderLayout.NORTH); // 메인패널에 서브패널을 추가
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setResizable(false);  				//사용자가 프레임 크기 조정 false
		frame.setLocationRelativeTo(null);  //위치 지정

		frame.setVisible(true); //화면에 보이기

	}
	public void openHowToScreen2() // 뒤화면
	{
		
		JFrame frame = new JFrame("Prototype-HowTo");
		frame.setSize(1000, 1000);
		
		JPanel panel = new JPanel();
		
		JPanel subPanel = new JPanel();
		
		JButton button_back = new JButton("back"); // 이전 화면으로 가는 버튼
		JButton button_main = new JButton("main"); // 메인 화면으로 가는 버튼
		
		File image2 = new File("src/images/howto2.png"); // 2째 이미지 선언
		
		BufferedImage howToimage2 = null;               // 파일을 이미지로 전환
		try {
			howToimage2 = ImageIO.read(image2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel image = new JLabel(new ImageIcon(howToimage2));

		BorderLayout fl = new BorderLayout();
		panel.setLayout(fl);
		
		subPanel.add(button_back);  //버튼을 서브패널에 추가
		subPanel.add(button_main);
		
		ActionListener listener_back = new ActionListener() {
			
			@override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				openHowToScreen1();
			}
		};
		
		ActionListener listener_main = new ActionListener() {
			
			@override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				openStartScreen();
			}
		};
		
		button_back.addActionListener(listener_back);
		button_main.addActionListener(listener_main);
		panel.add(image, BorderLayout.CENTER);
		panel.add(subPanel, BorderLayout.NORTH); // 메인패널에 서브패널을 추가
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setResizable(false);  				//사용자가 프레임 크기 조정 false
		frame.setLocationRelativeTo(null);  //위치 지정
		
		frame.setVisible(true); //화면에 보이기

	}
	// 게임 시작화면 출력
	public void openStartScreen() 
	{
		
		JFrame startFrame = new JFrame("Prototype-Start");
		JPanel panel = new JPanel();
		
		JButton buttonStart = new JButton("게임시작");
		JButton buttonHow = new JButton("HOW TO?");
		JButton buttonEnd = new JButton("게임종료");
		
		panel.add(buttonStart);
		panel.add(buttonHow);
		panel.add(buttonEnd);
		startFrame.add(panel);
		
		startFrame.setSize(1000, 1000);
		startFrame.setVisible(true);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 게임시작 버튼
		buttonStart.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				// 게임시작 창을 닫고 난이도 선택 창을 띄움
				startFrame.dispose();
				openSelectScreen();
			}
			
		});
		
		// HOW TO 버튼
		buttonHow.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				startFrame.dispose();
				openHowToScreen1();
			}
			
		});
		
		// 게임종료 버튼
		buttonEnd.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
			
		});
	}

}