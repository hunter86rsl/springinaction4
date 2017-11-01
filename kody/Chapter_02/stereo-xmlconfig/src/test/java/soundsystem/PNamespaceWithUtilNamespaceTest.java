package soundsystem;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PNamespaceWithUtilNamespaceTest {

  @Rule
  public final StandardOutputStreamLog log = new StandardOutputStreamLog();

  @Autowired
  private MediaPlayer player;

  @Test
  public void play() {
    player.play();
    assertEquals(
        "Odtwarzam utwór Sgt. Pepper's Lonely Hearts Club Band artysty The Beatles\r\n" +
        "-Utwór: Sgt. Pepper's Lonely Hearts Club Band\r\n" +
        "-Utwór: With a Little Help from My Friends\r\n" +
        "-Utwór: Lucy in the Sky with Diamonds\r\n" +
        "-Utwór: Getting Better\r\n" +
        "-Utwór: Fixing a Hole\r\n" +
        "-Utwór: She's Leaving Home\r\n" +
        "-Utwór: Being for the Benefit of Mr. Kite!\r\n" +
        "-Utwór: Within You Without You\r\n" +
        "-Utwór: When I'm Sixty-Four\r\n" +
        "-Utwór: Lovely Rita\r\n" +
        "-Utwór: Good Morning Good Morning\r\n" +
        "-Utwór: Sgt. Pepper's Lonely Hearts Club Band (Reprise)\r\n" +
        "-Utwór: A Day in the Life\r\n",
        log.getLog());
  }

}
