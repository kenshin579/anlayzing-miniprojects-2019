package com.woowacourse.sunbook.codemcd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class ReactionApiController {

    private ReactionArticleService reactionArticleService;

    @Autowired
    public ReactionApiController(ReactionArticleService reactionArticleService) {
        this.reactionArticleService = reactionArticleService;
    }

    @PostMapping("/articles/{articleId}/good")
    @Transactional
    public ResponseEntity<ReactionDto> clickGood(@PathVariable Long articleId,
                                                 @RequestBody ReactionDto reactionDto) {
        ReactionDto resultReactionDto = reactionArticleService
                .clickGood(articleId, reactionDto);
        return new ResponseEntity<>(resultReactionDto, HttpStatus.OK);
    }

    @GetMapping("/articles/{articleId}/good")
    public ResponseEntity<ReactionDto> showGood(@PathVariable Long articleId) {
        ReactionDto reactionDto = reactionArticleService.showCount(articleId);
        return new ResponseEntity<>(reactionDto, HttpStatus.OK);
    }
}
