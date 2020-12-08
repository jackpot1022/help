package javaFile;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

/*import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;*/
import java.io.*;

public class StageMakingTest extends JFrame
{
	//���� ��� �߰�
	public Image block[] =
	{
		new ImageIcon("src/images/��ϻ�/black.png").getImage(),
		new ImageIcon("src/images/��ϻ�/white.png").getImage(),
		new ImageIcon("src/images/��ϻ�/red.png").getImage(),
		new ImageIcon("src/images/��ϻ�/blue.png").getImage(),
		new ImageIcon("src/images/��ϻ�/yellow.png").getImage(),
		new ImageIcon("src/images/��ϻ�/orange.png").getImage(),
		new ImageIcon("src/images/��ϻ�/sky.png").getImage(),
		new ImageIcon("src/images/��ϻ�/up.png").getImage(),
		new ImageIcon("src/images/��ϻ�/right.png").getImage(),
		new ImageIcon("src/images/��ϻ�/left.png").getImage(),
		new ImageIcon("src/images/��ϻ�/down.png").getImage()
	};
	
	//������ ����
	public void createFrame()
	{
		setTitle("�������������׽�Ʈ"); 			//������â ����
		setSize(800, 800 + 25);  			//�������� ũ�� ����
		setResizable(false);  				//����ڰ� ������ ũ�� ���� false
		setVisible(true);					//������â�� ���̵��� ����
		setLocationRelativeTo(null);		//������ â�� ȭ�� ����� ������ ����
		setLayout(null);					//���̾ƿ��� ������� ������ �� �ֵ��� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//���������� JFrame�� ����ǵ��� ����
	}

	//�������� ����
	public void paint(Graphics g) 
	{
		BufferedReader br = null;			//������ �о�� ����
		String line = null;					//�о�� ���Ͽ��� ������ ������ ����
		try  //���� ����� ���� ������ ����� ���� try catch���� ����ؾ� �Ѵ�.
		{
		br = new BufferedReader(new FileReader("src/stage/stage8.txt"));	//stage1 �ؽ�Ʈ ������ �ҷ���
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		for(int y=0 ; y<16 ; y++)
		{
			try
			{
			line = br.readLine();			//stage1 �ؽ�Ʈ ���Ͽ��� �� ������ �о��
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			if(line == null)	break;
			//								//�о�� ���忡�� x��° ���ڰ� ���������� ���� 50*x, 25 + 50*y ��ǥ�� �ش� ��� �̹����� ����Ѵ�.
			for(int x=0 ; x<16 ; x++)
			{
				if(line.charAt(x)=='0')		//���ڰ� 0�� ��� ������ ��� ���
				{
					g.drawImage(block[0], 50*x, 25+50*y, null);
				}
				else if(line.charAt(x)=='W')	//���ڰ� W�� ��� �Ͼ�� ��� ���
				{
					g.drawImage(block[1], 50*x, 25+50*y, null);
				}
				else if(line.charAt(x)=='R')	//���ڰ� B�� ��� ������ ��� ���
				{
					g.drawImage(block[2], 50*x, 25+50*y, null);
				}
				else if(line.charAt(x)=='B')	//���ڰ� R�� ��� �Ķ��� ��� ���
				{
					g.drawImage(block[3], 50*x, 25+50*y, null);
				}
				else if(line.charAt(x)=='Y')	//���ڰ� Y�� ��� ����� ��� ���
				{
					g.drawImage(block[4], 50*x, 25+50*y, null);
				}
				else if(line.charAt(x)=='O')	//���ڰ� O�� ��� ��Ȳ�� ��� ���
				{
					g.drawImage(block[5], 50*x, 25+50*y, null);
				}
				else if(line.charAt(x)=='S')	//���ڰ� S�� ��� �ϴû� ��� ���
				{
					g.drawImage(block[6], 50*x, 25+50*y, null);
				}
				else if(line.charAt(x)=='P')	//���ڰ� P�� ��� ��ȫ�� ��� ���
				{
					g.drawImage(block[7], 50*x, 25+50*y, null);
				}
				else if(line.charAt(x)=='8')	//���ڰ� 8�� ��� ���� ��� ���
				{
					g.drawImage(block[8], 50*x, 25+50*y, null);
				}
				else if(line.charAt(x)=='6')	//���ڰ� 6�� ��� ������ ��� ���
				{
					g.drawImage(block[9], 50*x, 25+50*y, null);
				}
				else if(line.charAt(x)=='4')	//���ڰ� 4�� ��� ���� ��� ���
				{
					g.drawImage(block[10], 50*x, 25+50*y, null);
				}
				else if(line.charAt(x)=='2')	//���ڰ� 2�� ��� �Ʒ��� ��� ���
				{
					g.drawImage(block[11], 50*x, 25+50*y, null);
				}
			}
		}
		try
		{
			br.close();					//stage1���� ����
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		StageMakingTest smt = new StageMakingTest();
		smt.createFrame();
	}

}
