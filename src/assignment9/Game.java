package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
 
 private Snake snake;
 private Food food;
 private int score; 
 
 public Game() {
  StdDraw.enableDoubleBuffering();
  snake = new Snake ();
  food = new Food ();
  score = 0; 
 
  //FIXME - construct new Snake and Food objects
 }
 
 public void play() {
  while (snake.isInbounds()) { //TODO: Update this condition to check if snake is in bounds
   int dir = getKeypress();
   //Testing only: you will eventually need to do more work here
   if (dir!= -1) {
       snake.changeDirection(dir);
  }
   //2. move 
   snake.move();
    
    //3. new food
    if (snake.eatFood(food)) {
    	food= new Food();
    	score ++; 
    }
   
   //4.drawing update
   updateDrawing();
  }
  StdDraw.clear();
  StdDraw.setPenColor(StdDraw.BLUE);
  StdDraw.setFont(StdDraw.getFont().deriveFont(40f));
  StdDraw.text(0.5, 0.5, "Game Over");
  StdDraw.setPenColor(StdDraw.CYAN);
  StdDraw.text(0.5, 0.4, "Score:"+ score);
  StdDraw.show();
  
 }
 
 
 private int getKeypress() {
  if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
   return 1;
  } else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
   return 2;
  } else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
   return 3;
  } else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
   return 4;
  } else {
   return -1;
  }
 }
 
 /**
  * Clears the screen, draws the snake and food, pauses, and shows the content
  */
 private void updateDrawing() {
  //FIXME
  StdDraw.clear();
  snake.draw();
  food.draw();
  //adding score
  StdDraw.setPenColor(StdDraw.BLACK);
  StdDraw.textRight(0.95,0.95,"Score: "+score);
  
  StdDraw.pause(50);
  StdDraw.show();
 }
 
 public static void main(String[] args) {
  Game g = new Game();
  g.play();
 }
}