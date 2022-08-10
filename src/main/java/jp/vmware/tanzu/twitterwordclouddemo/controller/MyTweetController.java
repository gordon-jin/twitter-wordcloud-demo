package jp.vmware.tanzu.twitterwordclouddemo.controller;

import jp.vmware.tanzu.twitterwordclouddemo.repository.MyTweetRepository;
import jp.vmware.tanzu.twitterwordclouddemo.service.MyTweetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Profile({ "default", "stateless" })
public class MyTweetController {

	public final MyTweetService myTweetService;

	public MyTweetController(MyTweetService myTweetService) {
		this.myTweetService = myTweetService;
	}

	@GetMapping({ "/tweets" })
	public ModelAndView getAllTweets() {
		ModelAndView mav = new ModelAndView("tweets");
		mav.addObject("tweets", myTweetService.findAllByOrderByTweetIdDesc());
		return mav;
	}

}