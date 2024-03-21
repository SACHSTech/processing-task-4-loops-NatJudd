import processing.core.PApplet;

/**
 * creates a scalable window with 4 quadrants to reproduce the graphic
 * shown in the assignment as accuratly as possible
 * 
 * @author: N.Judd
 */
public class Sketch extends PApplet {
  // initialize variables

  // screen size
  // background width and height
  int intBgSize = 400; // change this value to scale the window
  // quadrant width and height
  int intQuadrantSize = intBgSize / 2;

  // quadrant one
  // amount of sqaures per row / column
  int intSquares = 10;
  // top left corner x coordinate
  int intGridPosX = 0;
  // top left corner y coordinate
  int intGridPosY = 0;

  // quadrant two
  // diameter of the circles
  int intCircleSize = intQuadrantSize / (2 * 5);
  // x coordinate of the top left corner of the grid
  int intCircleX = intQuadrantSize + intCircleSize;
  // y coordinate of the top left corner of the grid
  int intCircleY = intCircleSize;
  // the vertical distance added to the first circle
  int intRow;
  // the horizonatal distance added to the first circle
  int intColumn;
  // the x coordinate of each circle
  int intCirclePosX;
  // the y coordinate of each circle
  int intCirclePosY;

  // quadrant three
  // colour of the gradient
  int intRGB;
  // horizontal position of each gradient rectangle
  float fltRectPosX;
  // width of each rectangle
  float fltRectWidth = (float) intQuadrantSize / (float) 255;

  // quadrant four
  // diameter of the centre of the flower
  float fltCentreSize = intQuadrantSize / 5;
  // x and y coordinate of the flower centre
  int intCentrePos = intQuadrantSize + intQuadrantSize / 2;
  // pedal length
  float fltPedalL = (float) intQuadrantSize * (float) 0.2875;
  // pedal width
  float fltPedalW = (float) intQuadrantSize * (float) 0.075;

  // background size
  public void settings() {
    size(intBgSize, intBgSize);
  }

  // background colour
  public void setup() {
    background(255, 255, 255);
  }

  // quadrant one method
  private void quadrantOne() {
    // calculates and draws verticle grid lines
    stroke(0, 0, 0);
    for (int i = 0; i <= intSquares; i++) {
      intGridPosX = i * (intQuadrantSize / intSquares);
      line(intGridPosX, 0, intGridPosX, intQuadrantSize);
    }
    // calculates and draws horizontal grid lines
    for (int i = 0; i <= intSquares; i++) {
      intGridPosY = i * (intQuadrantSize / intSquares);
      line(0, intGridPosY, intQuadrantSize, intGridPosY);
    }
  }

  // quadrant two method
  private void quadrantTwo() {
    // calulates and draws the grid of circles
    for (int i = 0; i < 25; i++) {
      intRow = (i / 5) * (intCircleSize * 2);
      intColumn = (i % 5) * (intCircleSize * 2);
      intCirclePosX = intCircleX + intColumn;
      intCirclePosY = intCircleY + intRow;

      fill(200, 0, 100);
      ellipse(intCirclePosX, intCirclePosY, intCircleSize, intCircleSize);
    }
  }

  // quadrant three method
  private void quadrantThree() {
    // calculates colour and position of each rectangle in the gradient
    for (int i = 0; i <= 255; i++) {
      intRGB = i;
      fltRectPosX = i * fltRectWidth;

      stroke(intRGB);
      fill(intRGB);
      rect(fltRectPosX, (float) intQuadrantSize, fltRectWidth, (float) intQuadrantSize);
    }
  }

  // quadrant four method
  private void quadrantFour() {
    // move origin to center of quadrant four
    translate(intCentrePos, intCentrePos);

    // changes outline to black
    stroke(0);

    // change colour to orange
    fill(255, 140, 0);

    // calculates and draws pedals
    for (int i = 0; i < 8; i++) {
      // rotates 45 degrees each iteration
      rotate(radians(45));
      ellipse(fltCentreSize / 2 + fltPedalL / 2, 0, fltCentreSize + fltPedalL, fltCentreSize - fltPedalW);
    }

    // draws centre of flower
    stroke(0, 100, 25);
    fill(0, 100, 25);
    ellipse(0, 0, fltCentreSize, fltCentreSize);
  }

  // calls quadrant methods repeatedly
  public void draw() {
    // draws quadrant one
    quadrantOne();
    // draws quadrant two
    quadrantTwo();
    // draws quadrant three
    quadrantThree();
    // draws quadrant four
    quadrantFour();
  }
}