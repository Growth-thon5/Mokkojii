package com.example.mokkoji.domain.cheer.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

public record CheerRequest(
        Long userId,

        @NotBlank(message = "내용은 비어 있을 수 없습니다.")
        @Size(max = 300, message = "응원 메시지는 300자 이내로 작성해주세요.")
        String content,

        @Size(max = 5, message = "태그는 최대 5개까지 선택할 수 있습니다.")
        List<String> tagList,

        @Size(max = 3, message = "이미지는 최대 3장까지 첨부할 수 있습니다.")
        List<String> imageList
) {
}
