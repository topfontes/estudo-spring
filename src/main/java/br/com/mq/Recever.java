package br.com.mq;

import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;

@Component
public class Recever {
	 private CountDownLatch latch = new CountDownLatch(1);
	  
	  public void processMessage(String message) {
	    System.out.println("Received <" + message + ">");
	    latch.countDown();
	  }

	  public CountDownLatch getLatch() {
	    return latch;
	  }

}
