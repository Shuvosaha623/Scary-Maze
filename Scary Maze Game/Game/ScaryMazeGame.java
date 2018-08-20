import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class ScaryMazeGame extends JComponent implements MouseMotionListener,MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6083893756989364566L;
	
	BufferedImage intro;
	BufferedImage Label1;
	BufferedImage Label2;
	BufferedImage Label3;
	BufferedImage GameOver;
	BufferedImage currentLevel;
	AudioClip scream = JApplet.newAudioClip(getClass().getResource("/resource/scream.wav")) ;
	AudioClip music  = JApplet.newAudioClip(getClass().getResource("/resource/music.wav")) ; ;
	
	public ScaryMazeGame() throws IOException
	 {
		intro = ImageIO.read(getClass().getResource("/resource/Intro.jpg")) ;
		Label1 = ImageIO.read(getClass().getResource("/resource/Label1.jpg")) ;
		Label2 = ImageIO.read(getClass().getResource("/resource/Label2.jpg")) ;
		Label3 = ImageIO.read(getClass().getResource("/resource/Label3.jpg")) ;
		GameOver = ImageIO.read(getClass().getResource("/resource/GameOver.jpg")) ;
		
		currentLevel = intro; 
		music.loop();
		
	 }
	
	
	
  public static void main (String[] args) throws IOException
	{
		  JFrame window = new JFrame("Scary Maze by SHUVO!!");
		  ScaryMazeGame game = new ScaryMazeGame();
		  window.add(game);
		  window.pack();
		  window.setLocationRelativeTo(null);
		  window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		  window.setVisible(true);
		  
		  game.addMouseMotionListener(game);
		  game.addMouseListener(game);
		
	}
	
  
	public Dimension getPreferredSize()
	  {
		  return new Dimension(800,600);
		  
	  }
	  
	  protected void paintComponent(Graphics g)
	  {
		  g.setColor(Color.RED);
		  g.fillRect(0, 0, 800, 600);
		  g.drawImage(currentLevel, 0, 0,null);
		  
	  }



	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseMoved(MouseEvent e) 
	{
		//check the colors of the pixel 
		
		int x = e.getX();
		int y = e.getY();
		int color = currentLevel.getRGB(x, y);
		
		System.out.println(color);
		
		if (color == -13384082 )
		{
			currentLevel = Label1;
		}
		if (color == -2405841  )
		{
			currentLevel = intro;
		}
		if (color == -1398262  )
		{
			currentLevel = Label2;
		}
		if (color == -10662457 )
		{   
			scream.play();
			music.stop();
			currentLevel = GameOver;
		}
		if (color == -1570211 )
		{
			currentLevel = Label3;
		}
		if (color == -5436135 )
		{ 
		   scream.play();
		   music.stop();
		   currentLevel = GameOver;
		}
		
		
		repaint();
		
	}



	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (currentLevel == GameOver)
		{
			currentLevel = intro;
		}
		
		repaint();
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
