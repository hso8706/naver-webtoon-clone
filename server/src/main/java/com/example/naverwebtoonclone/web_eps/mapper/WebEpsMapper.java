package com.example.naverwebtoonclone.web_eps.mapper;

import com.example.naverwebtoonclone.web_eps.dto.WebEpsDto;
import com.example.naverwebtoonclone.web_eps.entity.WebEps;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WebEpsMapper {

    WebEps postDtoToEntity (WebEpsDto.Post postRequest);
    WebEps patchDtoToEntity (WebEpsDto.Patch patchRequest);
    WebEpsDto.Response entityToResponse (WebEps webInfo);
    List<WebEpsDto.Response> webInfoListToResponseList (List<WebEps> webInfoList);

}
