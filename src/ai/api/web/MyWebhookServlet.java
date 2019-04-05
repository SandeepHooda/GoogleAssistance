package ai.api.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;

import ai.api.model.Fulfillment;
import ai.api.web.AIWebhookServlet;

@WebServlet("/webhook")
public class MyWebhookServlet extends AIWebhookServlet {
  @Override
  protected void doWebhook(AIWebhookRequest input, Fulfillment output) {
    output.setSpeech("You said: " + input.getResult().getFulfillment().getSpeech());
  }
}