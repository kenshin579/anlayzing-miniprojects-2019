package com.woowacourse.sunbook.presentation.controller;

import com.woowacourse.sunbook.application.dto.reaction.ReactionDto;
import com.woowacourse.sunbook.application.service.ReactionCommentService;
import com.woowacourse.sunbook.presentation.support.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments/{commentId}/good")
public class ReactionCommentApiController {
    private ReactionCommentService reactionCommentService;

    @Autowired
    public ReactionCommentApiController(ReactionCommentService reactionCommentService) {
        this.reactionCommentService = reactionCommentService;
    }

    @GetMapping
    public ResponseEntity<ReactionDto> showGood(@PathVariable Long commentId,
                                                LoginUser loginUser) {
        ReactionDto reactionDto = reactionCommentService
                .showCount(loginUser.getId(), commentId);

        return new ResponseEntity<>(reactionDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReactionDto> clickGood(@PathVariable Long commentId,
                                                 LoginUser loginUser) {
        ReactionDto reactionDto = reactionCommentService.
                clickGood(loginUser.getId(), commentId);

        return new ResponseEntity<>(reactionDto, HttpStatus.OK);
    }
}