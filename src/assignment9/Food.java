package assignment9;

import java.awt.Color;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

 public static final double FOOD_SIZE = 0.02;
 private double x, y;
 
 /**
  * Creates a new Food at a random location
  */
 public Food() {
  
  Random random = new Random();
  
  this.x = random.nextDouble();
  this.y = random.nextDouble();
  
 }
 
 /**
  * Draws the Food
  */
 public void draw() {
  //FIXME
    StdDraw.setPenColor(Color.RED);
    StdDraw.filledCircle(x,y,FOOD_SIZE);
 }
 public double getX() {
  return x;
 }
 
 public double getY() {
  return y;
 }
 
 public void setX (double x) {
	 this.x= x;
 }
 
 public void setY (double y) {
	 this.y= y; 
 }
}