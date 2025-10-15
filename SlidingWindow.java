/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datagramsocket;

import java.util.Arrays;

public class SlidingWindow {



private int windowSize;

private int[] frames;

private boolean[] ack;

public SlidingWindow(int windowSize, int

frameCount) {

this.windowSize = windowSize;

this.frames = new int[frameCount];

this.ack = new boolean[frameCount];

for (int i = 0; i < frameCount; i++) {

frames[i] = i; //10 frames

ack[i] = false; //10 ack are initialized to false

}

}

public void sendFrames() {

int sendIndex = 0; //first slot in sliding window

while (sendIndex < frames.length) {

for (int i = 0; i < windowSize && (sendIndex + i) <frames.length; i++) {

System.out.println("Sending frame: " +

frames[sendIndex + i]);

}

for (int i = 0; i < windowSize && (sendIndex + i) <frames.length; i++) {

ack[sendIndex + i] = receiveAck(sendIndex + i);

}

while (sendIndex < frames.length && ack[sendIndex]) {

sendIndex++;

}

}

}

private boolean receiveAck(int frame) {

// Simulate acknowledgment reception

System.out.println("Receiving ack for frame: " + frame);

return true; // Assume ack is always received for simplicity

}

public static void main(String[] args) {

int windowSize = 4; //buffer is 4

int frameCount = 10; //total packets to be sent is 10

SlidingWindow swp = new

SlidingWindow(windowSize, frameCount);

swp.sendFrames();

}

}



