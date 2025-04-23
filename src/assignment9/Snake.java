
package assignment9;

import java.util.LinkedList;

import java.awt.Color;

public class Snake {

 private static final double SEGMENT_SIZE = 0.02;
 private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.1;
 private LinkedList<BodySegment> segments;
 private double deltaX;
 private double deltaY;
 
 public Snake() {
  segments = new LinkedList<>();
  segments.add(new BodySegment(0.5,0.5,SEGMENT_SIZE));
  deltaX = 0; 
  deltaY = 0; 
 }
 
 public void changeDirection(int direction) {
  if(direction == 1) { //up
   deltaY = MOVEMENT_SIZE;
   deltaX = 0;
  } else if (direction == 2) { //down
   deltaY = -MOVEMENT_SIZE;
   deltaX = 0;
  } else if (direction == 3) { //left
   deltaY = 0;
   deltaX = -MOVEMENT_SIZE;
  } else if (direction == 4) { //right
   deltaY = 0;
   deltaX = MOVEMENT_SIZE;
  }
 }
 
 /**
  * Moves the snake by updating the position of each of the segments
  * based on the current direction of travel
  */
 public void move() {
  //for loop processing the body, parts moving to the location of the previous body party 
	 for (int i= segments.size()-1; i>0; i--) {
		 BodySegment current = segments.get(i);
		 BodySegment previous = segments.get(i-1);
		 current = new BodySegment (previous.getX(),previous.getY(),SEGMENT_SIZE);
		 segments.set(i, current);
	 }
	 
  //head
  BodySegment head = segments.get(0);  
  head.setX(head.getX() + deltaX);
  head.setY(head.getY() + deltaY);

  // BodySegment movedHead = new BodySegment(head.getX() + deltaX, head.getY() + deltaY, SEGMENT_SIZE);  
 }
 
 /**
  * Draws the snake by drawing each segment
  */
 public void draw() {
  //FIXME
  for(BodySegment segment: segments) {
   segment.draw(); 
  }
 }
 /**
  * The snake attempts to eat the given food, growing if it does so successfully
  * @param f the food to be eaten
  * @return true if the snake successfully ate the food
  */
 public boolean eatFood(Food f) {
  //FIXME
  BodySegment head = segments.get(0);
  double distance = Math.sqrt(Math.pow(head.getX() - f.getX(), 2) + Math.pow(head.getY() - f.getY(), 2));  
  if (distance <= SEGMENT_SIZE +Food.FOOD_SIZE) {
	  BodySegment lastSegment = segments.get(segments.size()-1);
	  segments.add(new BodySegment(lastSegment.getX(),lastSegment.getY(),SEGMENT_SIZE));
	  return true;
   }

   return false;
 }
 
 
 
 /**
  * Returns true if the head of the snake is in bounds
  * @return whether or not the head is in the bounds of the window
  */
 public boolean isInbounds() {
  //FIXME
  BodySegment head = segments.get(0);
  
  return head.getX()>0 && head.getX()<1 && head.getY()>0 && head.getY()<1;
 }
}