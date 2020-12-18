package uet.oop.bomberman;

import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.gui.Frame;
import uet.oop.bomberman.input.Keyboard;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * Tạo vòng lặp game, lưu trữ một vài tham số cấu hình toàn cục.
 * Phương thức render(), update() cho entities
 */
public class Game extends Canvas {

	public static void main(String[] args) {
		new Frame();
	}

	public static final int TILES_SIZE = 16,// Độ to ô gạch
			WIDTH = TILES_SIZE * (31/2),	//16 ô chiều ngang
			HEIGHT = 13 * TILES_SIZE;		//13 ô chiều dọc

	public static int SCALE = 3;		// Kích thước màn
	
	public static final String TITLE = "BombermanGame";	//  Tên cửa sổ tùy ý

	// Các chỉ số defaul của bomber
	private static final int BOMBRATE = 1;			//Số bom
	private static final int BOMBRADIUS = 1;		//Độ dài flame
	private static final double BOMBERSPEED = 1.0;	//speed
	public static final int TIME = 200;		//Time màn chơi
	public static final int POINTS = 0;		//Điểm
	public static final int LIVES = 3;		//Mạng

	public static final int HIGHSCORE = (Integer.valueOf(Score.Read()));
        
	protected static int SCREENDELAY = 3;		//Delay màn hình

	//Chỉ số của nhân vật và có thể thay đổi trong màn chơi
	protected static int bombRate = BOMBRATE;
	protected static int bombRadius = BOMBRADIUS;
	protected static double bomberSpeed = BOMBERSPEED;
	
	protected int _screenDelay = SCREENDELAY;
	
	private Keyboard _input;
	private boolean _running = false;
	private boolean _paused = true;
	
	private Board _board;
	private Screen screen;
	private Frame _frame;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public Game(Frame frame) {
		_frame = frame;			            //Set khung hình
		_frame.setTitle(TITLE);	            //Tên
		screen = new Screen(WIDTH, HEIGHT);	//Khung hình
		_input = new Keyboard();            //Phím nhận
		_board = new Board(this, _input, screen);
		addKeyListener(_input);
	}
	
	
	private void renderGame() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();		   //Xóa
		_board.render(screen); //Hiển thị lại
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen._pixels[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		_board.renderMessages(g);
		g.dispose();
		bs.show();
	}
	public void start() {
		_running = true;
		
		long  lastTime = System.nanoTime();		//thời gian đã chạy, vòng lặp cũ
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0; //nanosecond, 60 frames per second: thời gian quét một frame
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();

		while(_running) {
			long now = System.nanoTime();		//thời gian hiện tại
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				update();
				updates++;
				delta--;
			}
			
			if(_paused) {
				if(_screenDelay <= 0) {
					_board.setShow(-1);
					_paused = false;
				}
				renderScreen();		//hiển thị screen
			} else {
				renderGame();		//hiển thị game
			}
				
			
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				_frame.setTime(_board.subtractTime());
				_frame.setPoints(_board.getPoints());
				_frame.setLives(_board.getLives());

				timer += 1000;
				System.out.println(updates + " rate, " + frames + " fps");
				updates = 0;
				frames = 0;
				
				if(_board.getShow() == 2)
					--_screenDelay;
			}
		}
	}

	private void update() {
		_input.update();
		_board.update();
	}

	private void renderScreen() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}

		screen.clear();
		Graphics g = bs.getDrawGraphics();
		_board.drawScreen(g);
		g.dispose();
		bs.show();
	}
	
	public static double getBomberSpeed() {
		return bomberSpeed;
	}
	
	public static void addBomberSpeed(double i) {
		bomberSpeed += i;
	}

	public static int getBombRadius() {
		return bombRadius;
	}
	
	public static void addBombRadius(int i) {
		bombRadius += i;
	}

	public static int getBombRate() {
		return bombRate;
	}
	
	public static void addBombRate(int i) {
		bombRate += i;
	}

	public void resetScreenDelay() {
		_screenDelay = SCREENDELAY;
	}

	public Board getBoard() {
		return _board;
	}
        public void run() {
		_running = true;
		_paused = false;
	}

	public boolean isPaused() {
		return _paused;
	}
	
	public void pause() {
		_paused = true;
	}
	
}
