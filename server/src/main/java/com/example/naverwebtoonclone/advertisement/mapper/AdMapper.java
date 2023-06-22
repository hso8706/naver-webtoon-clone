package com.example.naverwebtoonclone.advertisement.mapper;

import com.example.naverwebtoonclone.advertisement.dto.AdDto;
import com.example.naverwebtoonclone.advertisement.dto.AdDto.Response;
import com.example.naverwebtoonclone.advertisement.entity.Ad;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdMapper {

    Ad postDtoToEntity (AdDto.Post postRequest);
    Ad patchDtoToEntity (AdDto.Patch patchRequest);
    AdDto.Response entityToResponse (Ad ad);
    List<AdDto.Response> adListToResponseList (List<Ad> adList);

}
