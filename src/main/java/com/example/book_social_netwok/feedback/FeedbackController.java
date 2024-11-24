package com.example.book_social_netwok.feedback;

import com.example.book_social_netwok.common.PageResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("feedbacks")
@RequiredArgsConstructor
@Tag(name = "feedbacks")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<Integer> saveFeedback(@Valid @RequestBody FeedbackRequest feedbackRequest, Authentication connectedUser) {
        return ResponseEntity.ok(feedbackService.save(feedbackRequest, connectedUser));
    }

    @GetMapping("/book/{book-id}")
    public ResponseEntity<PageResponse<FeedbackResponse>> getAllFeedbackByBook(
            @PathVariable("book-id") Integer bookId,
            @RequestParam(name = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = "10", required = false) int pageSize,
            Authentication connectedUser
    ){
        return ResponseEntity.ok(feedbackService.findAllFeedbackByBook(bookId, pageNo, pageSize, connectedUser));
    }
}
