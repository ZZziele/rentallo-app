package com.sda.rentalloapp.mapper;

import com.sda.rentalloapp.domain.Pictures;
import com.sda.rentalloapp.dto.PicturesDto;

public class PicturesMapper implements Mapper<Pictures, PicturesDto> {

        @Override
        public PicturesDto fromEntityToDto(Pictures entity) {
            return PicturesDto.builder()
                    .mainPictureUrl(entity.getMainPictureUrl())
                    .picturesUrls(entity.getPicturesUrl())
                    .build();
        }

    @Override
    public Pictures fromDtoToEntity(PicturesDto dto) {
        return Pictures.builder()
                .mainPictureUrl(dto.mainPictureUrl())
                .picturesUrl(dto.picturesUrls())
                .build();
    }
}

