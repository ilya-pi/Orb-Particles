package me.orb.particles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Ilya Pimenov
 *         Orb Particles
 */
@Controller
@RequestMapping(value = "/controller1")
public class EventsController {

    @RequestMapping("method1")
    public void sendMessage(HttpServletResponse response) throws IOException {
        try {
            response.setContentType("text/event-stream");
            response.setCharacterEncoding("UTF-8");
            PrintWriter writer = response.getWriter();
            for (int i = 0; i < 3; i++) {
                writer.write("data: " + i + "\n\n");
                writer.flush();
                Thread.sleep(5000);
            }
            writer.write("data: close\n\n");
            writer.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}

