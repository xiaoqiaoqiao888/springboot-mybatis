package com.rails.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rails.timer.NoticeJob;
import com.rails.timer.NoticeService;

@RestController
public class AsyncController {

	@Autowired
	private AsyncService asyncService;
	@Autowired
	private NoticeService noticeService;

	@GetMapping("/hello")
	public String hello(@RequestParam String str) {

		// asyncService.hello();

		for (int i = 0; i < 5; i++) {

			NoticeJob noticeJob = new NoticeJob();
			noticeJob.setJobId(i + "");
			boolean add = noticeService.add(noticeJob);
			// noticeService.run();
			System.out.println(add + ":" + i);
		}
		return "SUCCESS";
	}
}
