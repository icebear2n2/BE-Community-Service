package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.HouseTourDto;
import com.icebear2n2.todayhouse.domain.dto.CommentDto;
import com.icebear2n2.todayhouse.domain.entity.HouseTour;
import lombok.Getter;

import java.util.List;

@Getter
public class HouseTourResponse extends HouseTourDto {

    private List<CommentDto> comments;
    public HouseTourResponse(HouseTour houseTour) {
        super(houseTour);
        comments = houseTour.getComments().stream().map(CommentDto::new).toList();
    }
}
