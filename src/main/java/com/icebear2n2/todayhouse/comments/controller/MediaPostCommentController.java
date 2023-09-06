package com.icebear2n2.todayhouse.comments.controller;

import com.icebear2n2.todayhouse.domain.request.MediaPostCommentRequest;
import com.icebear2n2.todayhouse.domain.response.MediaPostCommentResponse;
import com.icebear2n2.todayhouse.comments.service.MediaPostCommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments/media-post")
@Tag(name = "Media Post Comment REST API", description = "사진/동영상 게시물 댓글 REST API")
public class MediaPostCommentController {

    private final MediaPostCommentService mediaPostCommentService;

    @PostMapping
    @Operation(summary = "사진/동영상 게시물 댓글 작성", description = "사진/동영상 게시물에 댓글을 작성할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added comment to the media post"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Avatar or Media Post Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public void insert(@RequestBody MediaPostCommentRequest request) {
        mediaPostCommentService.insert(request);
    }

    @GetMapping
    @Operation(summary = "사진/동영상 게시물 댓글 전체 조회", description = "사진/동영상 게시물에 대한 전체 댓글을 조회할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved comments for the media posts"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public Page<MediaPostCommentResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return mediaPostCommentService.getAll(pageRequest);
    }

    @PutMapping("{id}")
    @Operation(summary = "사진/동영상 게시물 댓글 수정", description = "사진/동영상 게시물에 댓글을 수정할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated comment for media post"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Comment Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public MediaPostCommentResponse update(@PathVariable("id") Long mediaPostCommentId, @RequestBody MediaPostCommentRequest request) {
        return mediaPostCommentService.update(mediaPostCommentId, request);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "사진/동영상 게시물 댓글 삭제", description = "사진/동영상 게시물에 댓글을 삭제할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully removed comment from the media post"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Comment Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public void delete(@PathVariable("id") Long mediaPostCommentId) {
        mediaPostCommentService.delete(mediaPostCommentId);
    }
}
