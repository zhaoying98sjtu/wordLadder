package org.sang.demo.control;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

@RestController
public class DemoController {
    private static Logger logger = Logger.getLogger(DemoController.class.getClass());
    @RequestMapping("/wordladder")
    public FindLadder Ladder(@RequestParam(
            value="filename", defaultValue="smalldict1.txt") String name,
                             @RequestParam(value="word1", defaultValue="cat") String word1,
                             @RequestParam(value="word2", defaultValue="dog") String word2) {
        Wordladder wl = new Wordladder();
        try {
            logger.info("searching from " + word1 + " to " + word2);
            return wl.GetLadder(name, word1, word2);
        }catch(Exception e){
            logger.error("IOException occured");
            return new FindLadder(1,"IOException occured", new String[]{});
        }
    }
}