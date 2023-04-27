package com.storage.controller;

import com.storage.dto.ThirdPartyDto;
import com.storage.dto.ThirdPartyMapper;
import com.storage.service.ThirdPartyService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/thirdparties")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class ThirdPartyController {
    @Inject
    ThirdPartyService thirdPartyService;

    @Inject
    ThirdPartyMapper thirdPartyMapper;

    @GET
    public Response getAllProducts() {
        List<ThirdPartyDto> thirdPartyDtoList = thirdPartyMapper.thirdPartyListToThirdPartyDtoList(thirdPartyService.getAllThirdParty());
        return Response.ok(thirdPartyDtoList).build();
    }
}
