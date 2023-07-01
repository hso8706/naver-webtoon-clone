package com.example.naverwebtoonclone.web_info.mapper;

import com.example.naverwebtoonclone.web_info.dto.WebInfoDto;
import com.example.naverwebtoonclone.web_info.entity.WebInfo;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WebInfoMapper {

    WebInfo postDtoToEntity (WebInfoDto.Post postRequest);
    WebInfo patchDtoToEntity (WebInfoDto.Patch patchRequest);
    WebInfoDto.Response entityToResponse (WebInfo webInfo);
    List<WebInfoDto.Response> webInfoListToResponseList (List<WebInfo> webInfoList);

}
